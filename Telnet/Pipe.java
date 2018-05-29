/*
 * Pipe.java
 * from 'Java Cookbook'
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Pipe extends Thread {
    BufferedReader is;
    PrintStream os;

    /** Construct a Pipe to read from is and write to os */
    Pipe(InputStream is, OutputStream os) {
        this.is = new BufferedReader(new InputStreamReader(is));
        this.os = new PrintStream(os);
    }

    /** Do the reading and writing */
    public void run() {
        String line;
        try {
            while ((line = is.readLine()) != null) {
                os.print(line);
                os.print("\r\n");
                os.flush();
            }
        } catch(IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
