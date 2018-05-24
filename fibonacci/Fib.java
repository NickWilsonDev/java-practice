/* fibonacci program without recursion */

public class Fib {

    public static int fib(int n) {
        if (n == 0)
            return 0;

        if (n == 1) {
            return 1;
        } else {
            int first = 0;
            int second = 1;
            int nth = 1;

            for (int i = 2; i <= n; i++) {
                nth = first + second;
                first = second;
                second = nth;
            }
            return nth;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(fib(n));
    }
}
