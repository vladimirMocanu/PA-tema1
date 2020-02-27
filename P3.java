
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 *
 * @author Vladimir
 */
public class P3 {

    static class p3 {

        // public final static String FISIER_INTRARE = args[0];
        // public final static String FISIER_IESIRE = "out";
        int numarNumere;
        int[] sirNumere;

        private void citireFisier() {
            try {
                try ( Scanner sc = new Scanner(new File("p3.in"))) {
                    numarNumere = sc.nextInt();
                    sirNumere = new int[numarNumere];
                    for (int i = 0; i < numarNumere; i++) {
                        sirNumere[i] = sc.nextInt();
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private void scriereFisier(int result) {
            try {
                try ( PrintWriter pw = new PrintWriter(new File("p3.out"))) {
                    pw.printf("%d\n", result);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private int getResult() {

            int[][] dp = new int[sirNumere.length][sirNumere.length];
            
            for (int i = 0; i < sirNumere.length; i++) {
                dp[i][i] = sirNumere[i];
            }
            for (int i = sirNumere.length - 2; i >= 0; i--) {
                for (int j = i + 1; j < sirNumere.length; j++) {
                    dp[i][j] = Math.max(sirNumere[i] - dp[i + 1][j], sirNumere[j] - dp[i][j - 1]);
                }
            }

            return dp[0][sirNumere.length - 1];
        }

        public void rezolvare() {
            citireFisier();
            scriereFisier(getResult());
        }
    }

    public static void main(String[] args) {
        System.out.println();
        new p3().rezolvare();
    }

}
