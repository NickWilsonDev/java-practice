/** CommandLineArgs.java
 *  Echo command line args back.
 *  Just used for reference.
 */

public class CommandLineArgs {

    public static void main (String[] args) {
        System.out.println("Number of Args:: " + args.length);
        for(String s: args) {
            System.out.println(s);
        }
    }
}
