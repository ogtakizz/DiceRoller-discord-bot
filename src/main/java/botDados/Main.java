package botDados;

import botDados.discord.BotListener;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main {
    static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        JDABuilder.createDefault(dotenv.get("DISCORD_TOKEN"))
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .addEventListeners(new BotListener())
                .build();
    }
}
