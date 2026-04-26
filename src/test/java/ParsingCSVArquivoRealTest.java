import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParsingCSVArquivoRealTest {

    @Test
    void deveLerArquivoPlayersCSV() {
        MinhaArrayList<Player> players = parsingCSV.lerPlayers("src/main/java/players.csv");

        assertEquals(100, players.size());

        assertEquals("KDA_Kitsune", players.get(0).getNickname());
        assertEquals(50, players.get(0).getRanking());

        assertEquals("RadiantRookie", players.get(99).getNickname());
        assertEquals(100, players.get(99).getRanking());
    }
}
