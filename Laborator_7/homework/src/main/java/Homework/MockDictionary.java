package Homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MockDictionary extends Dictionary {

    List<String> acceptedWords;

    public MockDictionary() {
        acceptedWords = new ArrayList<>();
        try {
            Scanner s = new Scanner(new File("src/main/resources/words.txt"));
            while (s.hasNext()){
                acceptedWords.add(s.next());
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //is checked if the list contains a specific word
    public boolean isWord(String str) {
        return acceptedWords.contains(str);
    }

    @Override
    public int size() {
        return acceptedWords.size();
    }

    @Override
    public boolean isEmpty() {
        return acceptedWords.isEmpty();
    }

    @Override
    public Enumeration keys() {
        return null;
    }

    @Override
    public Enumeration elements() {
        return null;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }
}
