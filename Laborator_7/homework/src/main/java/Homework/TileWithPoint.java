package Homework;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TileWithPoint {
    private char letter;
    private int occurrences;
    private int points;

    public void decreaseOccurrences() {
        this.occurrences --;
    }
}

