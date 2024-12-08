import java.io.*;

public class HtmlConv {

    public static void main(String[] args) throws IOException {

        var HtmlConvRead = "datei1702_vor.html";
        var HtmlConvReadNew = "datei1702_nach.html";

        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(HtmlConvRead), "UTF-8"));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(HtmlConvReadNew), "UTF-8"))
        ) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Ersetze Umlaute und das scharfe S
                line = line.replace("ä", "&auml;")
                        .replace("Ä", "&Auml;")
                        .replace("ö", "&ouml;")
                        .replace("Ö", "&Ouml;")
                        .replace("ü", "&uuml;")
                        .replace("Ü", "&Uuml;")
                        .replace("ß", "&szlig;");
                // Schreibe die bearbeitete Zeile in die Ausgabedatei
                verweigereZugriff(new File(HtmlConvRead));

                writer.write(line);
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Konvertierung abgeschlossen. Überprüfen Sie die Datei: " + HtmlConvReadNew);
    }

    private static void verweigereZugriff(File testDatei) {
        if (!testDatei.setReadOnly()) {
            System.err.println("Konnte die Datei nicht auf schreibgeschützt setzen: " + testDatei.getAbsolutePath());
        }
    }
}





