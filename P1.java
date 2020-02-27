
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 *
 * @author Vladimir
 */
public class P1 {

    static class p1 {

       // public final static String FISIER_INTRARE = args[0];
       // public final static String FISIER_IESIRE = "out";

        int numarNumere;
        ArrayList<Integer> sirNumere;

        private void citireFisier()  {
           
            try {
                try (Scanner sc = new Scanner(new File("p1.in"))) {
                    numarNumere = sc.nextInt();
                    sirNumere = new ArrayList();
                    for (int i = 1; i <= numarNumere; i++) {
                        sirNumere.add(sc.nextInt());
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private void scriereFisier(int result) {
            try {
                try (PrintWriter pw = new PrintWriter(new File( "p1.out"))) {
                    pw.printf("%d\n", result);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private int getResult(){
            int Tuzgu = 0, Ritza = 0, count = 0;
            
            Collections.sort(sirNumere, Collections.reverseOrder());
            for (int i = 0; i < numarNumere; i++) {
                if(count == 0){
                    Tuzgu += sirNumere.get(i);
                    count = 1;
                }else{
                    Ritza += sirNumere.get(i);
                    count = 0;
                }
                
            }
            
            
            System.out.println(Tuzgu - Ritza);
            return Tuzgu - Ritza;
        }

        public void rezolvare() {
            citireFisier();
            scriereFisier(getResult());
        }
    }

    public static void main(String[] args) {
        System.out.println();
        new p1().rezolvare();
    }

}
