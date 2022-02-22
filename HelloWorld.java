package lab1;

public class HelloWorld {
    public static void main(String args[]) {
        System.out.println("Hello World!");
        HelloWorld lab1 = new HelloWorld();
        lab1.compulsory();
    }

    void compulsory() {

        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n *= 3;
        n += 0b1001;
        n += 0xFF;
        n *= 6;
        int nou=0;
        while (n>9)
        {
            nou=0;
            while (n>0)
            {
                nou+=n%10;
                n/=10;
            }
            n=nou;
        }
        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);
    }

}
