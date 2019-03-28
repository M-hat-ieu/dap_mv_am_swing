package fr.hoc.dap.swingcli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        Fenetre fen = new Fenetre();
    }

    public static String getData(final String url) throws IOException {

        URL url1 = new URL(url);

        BufferedReader reader = null;
        StringBuilder stringBuilder;

        //se connect au serveur
        HttpURLConnection connection = (HttpURLConnection) url1.openConnection();

        //récupére un flux en retour de connexion
        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        stringBuilder = new StringBuilder();

        String line = null;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line + "\n");
        }
        return stringBuilder.toString();

    }
}
