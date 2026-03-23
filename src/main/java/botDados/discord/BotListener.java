package botDados.discord;

import botDados.dados.CalculaDados;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BotListener extends ListenerAdapter {
    private static final Pattern DICE_PATTERN = Pattern.compile("(?i)(\\d*)d(\\d+)(?:\\s*([+-])\\s*(\\d+))?");

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        String conteudo = event.getMessage().getContentRaw().toLowerCase();
        Matcher matcher = DICE_PATTERN.matcher(conteudo);

        if (matcher.find()) {
            try {
                String qtdTexto = matcher.group(1);

                int qtd = ((qtdTexto == null || qtdTexto.isEmpty() ? 1 : Integer.parseInt(qtdTexto)));

                int faces = Integer.parseInt(matcher.group(2));

                int mod = 0;
                if (matcher.group(3) != null && matcher.group(4) != null) {
                    String sinal = matcher.group(3);
                    int valorMod = Integer.parseInt(matcher.group(4));
                    mod = sinal.equals("-") ? -valorMod : valorMod;
                }

                CalculaDados.Resultado res = CalculaDados.processar(qtd + "d" + faces, mod);
                Collections.sort(res.dados, Collections.reverseOrder());

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < res.dados.size(); i++) {
                    int d = res.dados.get(i);
                    if (d == faces || d == 1) sb.append("**").append(d).append("**");
                    else sb.append(d);
                    if (i < res.dados.size() - 1) sb.append(", ");
                }
                String dadosFormatados = sb.append(" ").toString();

                EmbedBuilder eb = getEmbedBuilder(res, faces);

                eb.addField("Dados:", dadosFormatados, false);
                eb.addField("Bônus:", String.valueOf(mod), true);
                eb.addField("Total:", "**" + res.total + "**", true);

                eb.setFooter("Rolado por " + event.getAuthor().getName(), event.getAuthor().getEffectiveAvatarUrl());

                event.getChannel().sendMessageEmbeds(eb.build()).queue();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @NotNull
    private static EmbedBuilder getEmbedBuilder(CalculaDados.Resultado res, int faces) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("🎲 Resultado da Rolagem: " + res.inputOriginal);

        int maiorDado = res.dados.getFirst();
        int menorDado = res.dados.getLast();

        if (maiorDado == faces) {
            eb.setColor(Color.GREEN);
            eb.setDescription("✨ **Sucesso Crítico!** O destino está a seu favor.");
        } else if (menorDado == 1) {
            eb.setColor(Color.RED);
            eb.setDescription("💀 **Falha Crítica!** Algo deu muito errado.");
        } else {
            eb.setColor(Color.CYAN);
        }
        return eb;
    }
}