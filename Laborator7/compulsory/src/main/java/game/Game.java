package game;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class Game {
    private final Bag bag = new Bag();
    private ArrayList<String> words;
    private final Board board = new Board(words);
    private final Dictionary dictionary = new MockDictionary();
    private final List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }
    public void play() {
        for (Player player : players) {
            Thread thread = new Thread(){
                public void run(){
                    System.out.println("Thread Running " + player.getName());
                    System.out.println(bag.extractTiles(10));
                    System.out.println(words);
                }

            };
            thread.start();
        }
    }
    public static void main(String args[]) {
        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();
    }

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }
}
