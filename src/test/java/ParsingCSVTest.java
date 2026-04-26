import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParsingCSVTest {

    @Test
    void deveLerPlayersIgnorandoCabecalho() throws IOException {
        File arquivoTemporario = File.createTempFile("players", ".csv");

        try (FileWriter writer = new FileWriter(arquivoTemporario)) {
            writer.write("nickname,ranking\n");
            writer.write("KDA_Kitsune,50\n");
            writer.write("JettMainBR,25\n");
        }

        MinhaArrayList<Player> players = parsingCSV.lerPlayers(arquivoTemporario.getAbsolutePath());

        assertEquals(2, players.size());

        assertEquals("KDA_Kitsune", players.get(0).getNickname());
        assertEquals(50, players.get(0).getRanking());

        assertEquals("JettMainBR", players.get(1).getNickname());
        assertEquals(25, players.get(1).getRanking());

        arquivoTemporario.delete();
    }

    @Test
    void deveLerPlayersSemCabecalho() throws IOException {
        File arquivoTemporario = File.createTempFile("players", ".csv");

        try (FileWriter writer = new FileWriter(arquivoTemporario)) {
            writer.write("SageOfDawn,12\n");
            writer.write("NexusRider,6\n");
        }

        MinhaArrayList<Player> players = parsingCSV.lerPlayers(arquivoTemporario.getAbsolutePath());

        assertEquals(2, players.size());

        assertEquals("SageOfDawn", players.get(0).getNickname());
        assertEquals(12, players.get(0).getRanking());

        assertEquals("NexusRider", players.get(1).getNickname());
        assertEquals(6, players.get(1).getRanking());

        arquivoTemporario.delete();
    }
}
