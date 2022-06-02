import java.util.*;

public class Main {
    private boolean[][] neighbors = new boolean[100][100];
    private String[] aNeighbors = new String[100];
    private String[] words = new String[100];

    //--bonus-- declarari
    private LinkedList<Integer> adjLists[];
    private boolean visited[];
    private List<Integer> solution=new ArrayList<>();
    private List<Integer> nrNeighbors=new ArrayList<>();


    public static void main(String[] args) {
        Main mainProgram = new Main();
        long startTime = System.currentTimeMillis();
        for(String arg : args) {
            System.out.println(arg);
        }

        int n = 0,p = 0;
        String letters = "";
        String[] words = new String[10001];


        if(ValidateArguments.validateArgumentsList(args)) {
            System.out.println("You are good to go!");
            n = Integer.parseInt(args[0]);
            p = Integer.parseInt(args[1]);
            letters = CharOperations.getLettersFromParams(args);
            words = CharOperations.randomWords(letters, n, p).toArray(new String[0]);
        } else {
            System.out.println("Invalid list of arguments, change the input");
        }

        mainProgram.bonus(args);
    }

    //parcurgere DFS in care marcam vecinii vizitati din listele de vecini adjLists
    void DFS(int vertex) {
        visited[vertex] = true;
        solution.add(vertex);

        Iterator<Integer> interator = adjLists[vertex].listIterator();
        while (interator.hasNext()) {
            int adj = interator.next();
            if (!visited[adj]) {
                DFS(adj);
            }
        }
    }
    void bonus(String[] args) {

        int n = Integer.parseInt(args[0]);
        int p = Integer.parseInt(args[1]);
        int m = args.length - 2;
        char[] alphabet = new char[m];
        for (int i = 0; i < m; i++) {
            alphabet[i] = args[i + 2].charAt(0);}
        System.out.println("\n");

        for (int j = 0; j < n; j++) {
            words[j] = CharOperations.randomWords(p, alphabet);
            System.out.println(words[j]);
        }

        int ok;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ok=0;
                for (int k = 0; k < m; k++) {
                    if (words[i].indexOf(alphabet[k]) != -1 && words[j].indexOf(alphabet[k]) != -1) {
                        if (ok == 0) {
                            neighbors[i][j] = true;
                            ok = 1;
                        }
                    }
                    else {
                        if (ok == 0) {
                            neighbors[i][j] = false;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(neighbors[i][j]==true){
                    if(i!=j) {
                        if (aNeighbors[i] == null) {
                            aNeighbors[i] = words[j];
                            aNeighbors[i] += " ";
                        } else {
                            aNeighbors[i] += words[j];
                            aNeighbors[i] += " ";
                        }
                    }
                }
            }
        }

        for (int index = 0; index < n; index++) {
            System.out.println("Vecinii cuvantului " + words[index] + " sunt: " + aNeighbors[index]);
        }

       ////---bonus----

        adjLists = new LinkedList[n];
        visited = new boolean[n];

        //initializam adjLists
        for (int index = 0; index < n; index++) {
            adjLists[index] = new LinkedList<Integer>();
        }

        //calcualm nr de vecini
        for(int index=0; index<n; index++) {
            int nr=0;
            for(int j=0; j<n; j++) {
                if(neighbors[index][j])
                    nr++;
            }
            nrNeighbors.add(nr);
        }

        //adaugam in lista fiecarui vecin, vecinii
        for(int index=0; index<n; index++) {
            if(nrNeighbors.get(index)>=2) {
                for (int index2 = 0; index2 < n; index2++) {
                    if (neighbors[index][index2] && nrNeighbors.get(index2)>2) {
                        adjLists[index].add(index2);
                    }
                }
            }
        }

        //cautam cea mai buna solutie folosind parcurgerea DFS
        boolean sol=false;
        for(int index=0;index<n;index++){
            DFS(index);
            ok=1;
            for(int index2=0;index2<solution.size()-1;index2++){
                if(!neighbors[solution.get(index2)][solution.get(index2+1)])
                    ok=0;
                if(index2==solution.size()-2 && !neighbors[solution.get(solution.size()-1)][solution.get(0)])
                    ok=0;
            }
            //daca am gasit solutia atunci o afisam  si k>=3
            if (ok == 1 && solution.size() >= 3) {
                System.out.println("k-ul maxim este: " + solution.size());
                for (int index3 = 0; index3 < solution.size(); index3++) {
                    System.out.println(words[solution.get(index3)]);
                }
                sol=true;
                break;
            }

            solution.removeAll(solution);
            for(int j=0;j<n;j++) {
                visited[j]=false;
            }
        }
        if(!sol) {
            System.out.println("NU AM GASIT NICIO SOLUTIE");
        }

    }


}
