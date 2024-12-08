import java.io.File;
import java.io.IOException;

public class TestDirectory {
    /**
     * Main-Methode.
     *
     * @param args
     *            Uebergabeparameter
     * @throws IOException
     */

    public static void main(String[] args) throws IOException {
        String verzeichnis = "NeuesVerzeichnis/VFH";
        //File ordner = new File(verzeichnis);
        erzeugeVerzeichnis(verzeichnis);

    }

    private static File erzeugeVerzeichnis(String ordner){
        File testVerzeichnis = new File(ordner);
        // leere Datei erzeugen
        testVerzeichnis.mkdirs();
        testVerzeichnis.setWritable(true);
        return testVerzeichnis;
    }
}
