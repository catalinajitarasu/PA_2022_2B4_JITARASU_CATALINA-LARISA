package game;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    protected final List<Tile> letters = new ArrayList<>();
    Bag() {
        for (char c = 'a'; c < 'z'; c++) {
            int p = (int)(Math.random()*10);
            Tile tile = new Tile(c,p);
            letters.add(tile);
        }
    }
    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }
            extracted.add(letters.get(i));
        }
        return extracted;
    }

}
