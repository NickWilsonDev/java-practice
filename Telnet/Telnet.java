/*
 * Telnet.java
 * came from 'Java Cookbook' O'reilly
 * a Telnet client
 */
import java.io.IOException;
import java.net.Socket;

public class Telnet {

    String host;
    int portNum;

    public static void main(String[] argv) {
        new Telnet().talkTo(argv);
    }

    private void talkTo(String av[]) {
        if (av.length >= 1)
            host = av[0];
        else
            host = "localhost";
        if (av.length >= 2)
            portNum = Integer.parseInt(av[1]);
        else
            portNum = 23;
        System.out.println("Host " + host + "; port " + portNum);
        try {
            Socket s = new Socket(host, portNum);

            // connect the remote to our stdout
            new Pipe(s.getInputStream(), System.out).start();

            // connect our stdin to the remote
            new Pipe(System.in, s.getOutputStream()).start();
        } catch(IOException e) {
            System.out.println(e);
            return;
        }
        System.out.println("Connected OK");
    }
}
