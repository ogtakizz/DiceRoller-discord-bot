package botDados.dados;

import java.util.ArrayList;
import java.util.List;

public class CalculaDados {
    public static class Resultado {
        public int total;
        public List<Integer> dados;
        public String inputOriginal;

        public Resultado(int total, List<Integer> dados, String input) {
            this.total = total;
            this.dados = dados;
            this.inputOriginal = input;
        }
    }

    public static Resultado processar(String formula, int modificador) {
        String[] partes = formula.toLowerCase().split("d");
        int qtd = Integer.parseInt(partes[0]);
        int faces =  Integer.parseInt(partes[1]);

        List<Integer> rolagens = new ArrayList<>();
        int soma = 0;

        for (int i = 0; i < qtd; i++) {
            int r = (int) (Math.random() * faces) + 1;
            rolagens.add(r);
            soma += r;
        }

        return new Resultado(soma + modificador, rolagens, formula);
    }
}
