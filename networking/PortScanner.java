/* PortScanner.java
 * Find out which of the first 1024 ports might be hosting TCP servers on a
 * specified host.
 */

import java.net.Socket;
import java.net.UnknownHostException;
import java.net.ConnectException;
import java.io.IOException;

public class PortScanner {
    public static void main(String[] args) {
        String host = "localhost";

        if (args.length > 0) {
            host = args[0];
        }

        Socket sock = null;
        for (int i = 1; i < 1024; i++) {
            try {
                sock = new Socket(host, i);
                System.out.println("There is a server on port: " + i + 
                                   " of " + host);
                sock.close();
            } catch (UnknownHostException ex) {
                System.err.println(ex);
                break;
            } catch (ConnectException ex) {
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}
