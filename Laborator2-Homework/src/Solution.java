/**
 * @author Catalina
 */
public class Solution {
    /**
     * constructor empty pentru obiecte de tipul Solution
     * nu am nevoie sa il initializez
     */
    public Solution() { //un constructor gol pentru obiecte de tipul Solution,nu am nevoie sa il initializez
    }

    /**
     *un string pentru a afisa informatii despre solution
     * @return stringul cu informatii
     */
    @Override
    public String toString() {
        return "Solution{}";
    }
    Problem pb = new Problem();
    public void solutionProblem() {
        pb.rezolvProblem();
    }
}
