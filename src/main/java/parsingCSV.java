import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class parsingCSV {

    public static MinhaArrayList<Player> lerPlayers(String caminhoArquivo) {
        MinhaArrayList<Player> players = new MinhaArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            boolean primeiraLinha = true;

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();

                if (linha.isEmpty()) {
                    continue;
                }

                String[] partes = linha.split(",");

                if (partes.length < 2) {
                    continue;
                }

                String nickname = partes[0].trim();
                String posicaoTexto = partes[1].trim();

                if (primeiraLinha) {
                    primeiraLinha = false;

                    if (nickname.equalsIgnoreCase("nickname") &&
                        posicaoTexto.equalsIgnoreCase("ranking")) {
                        continue;
                    }
                }

                int posicao = Integer.parseInt(posicaoTexto);

                Player player = new Player(nickname, posicao);

                players.add(player);
            }

        } catch (IOException e) {
            System.out.println("Erro ao abrir ou ler o arquivo CSV: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter ranking para número: " + e.getMessage());
        }

        return players;
    }

    public static void carregarCSV(String caminhoArquivo, BinarySearchTree<Player> ranking) {
        MinhaArrayList<Player> players = lerPlayers(caminhoArquivo);

        for (int i = 0; i < players.size(); i++) {
            ranking.insert(players.get(i));
        }

    }
}
