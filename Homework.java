import java.util.Arrays;
import java.util.Random;

public class Homework {
    public static void main(String[] args) {
        Homework app = new Homework();
        if (args.length < 3) {
            System.err.println("Not enough arguments!");
            System.exit(-1);
        }
        long start = System.nanoTime(); //incep sa calculez cat timp imi ia
        int n = Integer.parseInt(args[0]);
        int p = Integer.parseInt(args[1]);
        int m = args.length - 2;
        char[] alphabet = new char[m];
        for (int i = 0; i < m; i++) {
            alphabet[i] = args[i + 2].charAt(0);
        }
        String[] words = app.generate(p, alphabet, n);
        System.out.println(Arrays.toString(words));
        int[][] matrixBoolean = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (neighborsVerif(words[i], words[j],m,alphabet)) {
                    matrixBoolean[i][j] = 1;
                    matrixBoolean[j][i] = 1;
                } else {
                    matrixBoolean[i][j] = 0;
                    matrixBoolean[j][i] = 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(matrixBoolean[i][j]+" ");
                System.out.println();
        }
        String[][] neighbors = new String[n][n];
        for(int i=0;i<n;i++) {
            int nbNeighbors=0;
            for(int j=1;j<n;j++)
                if(i!=j)
                   if(neighborsVerif(words[i],words[j],m,alphabet)) {
                     neighbors[i][nbNeighbors++]=words[j];
                   }
            }
        long end = System.nanoTime();
        if (n <=30000) System.out.println(Arrays.deepToString(neighbors));
        else
            if (n >= 30000) {//daca n>30000 atunci afisez timpul in nanosecunde
              System.out.println("Time of the application in nanoseconds is " + (end - start));
            }
    }
    public String[] generate(int p, char[] alphabet, int n) {
        String[] words = new String[n];
        for (int j = 0; j < n; j++) {
            StringBuilder word = new StringBuilder();
            Random rand = new Random();
            for (int i = 0; i < p; i++) {
                int k = rand.nextInt(alphabet.length);
                word.append(alphabet[k]);
            }
            words[j] = word.toString();
        }
        return words;
    }
    static boolean neighborsVerif(String s1, String s2,int m, char [] alphabet) {
        for(int k=0;k<m;k++)
           if(s1.indexOf(alphabet[k])!=-1 && s2.indexOf(alphabet[k])!=-1) return true;
            return false;
    }
}