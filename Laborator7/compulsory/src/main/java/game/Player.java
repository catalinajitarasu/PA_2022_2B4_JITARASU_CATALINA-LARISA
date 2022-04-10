package game;

import java.util.List;

import static java.lang.Thread.sleep;

public class Player implements Runnable{
    private String name;
    private Game game;
    private boolean running;
    public Player(String name) { this.name = name; }

    private boolean submitWord() {
        List<Tile> extracted;
        extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }
        //create a word with all the extracted tiles;

        String word = new String();
        for (int i=0; i< extracted.size();i++) {
            word+=extracted.get(i);
        }

        game.getBoard().addWord(this, word);

        //make the player sleep 50ms;
        run();
        return true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Game getGame() {
        return game;
    }

    public boolean isRunning() {
        return running;
    }

    @Override
    public void run() {
        try {
            while(true) {
                submitWord();
                Thread.sleep(50);
            }
        } catch (InterruptedException e){ System.err.println("Oops..." + e);}

    }

    public void setGame(Game game) {
        this.game=game;
    }
}
