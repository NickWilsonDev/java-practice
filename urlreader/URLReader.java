import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLReader {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://nickwilsondev.github.io/Portfolio/");

            try {
                URLConnection connection = url.openConnection();
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

                String inputLine = in.readLine();
                while (inputLine != null) {
                    System.out.println(inputLine);
                    inputLine = in.readLine();
                }
                in.close();
            } catch(IOException ioe) {
                System.out.println(ioe);
            }

        } catch(MalformedURLException m) {
            System.out.println(m);
        }
    }
}
