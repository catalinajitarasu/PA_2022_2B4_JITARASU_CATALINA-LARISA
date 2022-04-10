package game;

import java.util.ArrayList;

public class Board {

   private final ArrayList<String> words;

    public Board(ArrayList<String> words) {
        this.words = words;
    }

    public final void addWord(Player player, String word) {
        //add the word to the collection;
        words.add(word);
        System.out.println(player.getName() + ": " + word);
    }
    @Override
    public String toString() {
        return words.toString();
    }

}
