import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scrabble {
    private static final Map<Character, Integer> letterValues = new HashMap<>();
    private String word;
    private List<Character> doubleLetters;
    private List<Character> tripleLetters;
    private boolean doubleWord;
    private boolean tripleWord;

    static {
        String letters = "AEIOULNRSTDGBCMPFHVWYKJXQZ";
        int[] values = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 8, 8, 10, 10};
        for (int i = 0; i < letters.length(); i++) {
            letterValues.put(letters.charAt(i), values[i]);
        }
    }

    public Scrabble(String word) {
        this(word, new Character[]{}, new Character[]{}, false, false);
    }

     public Scrabble(String word, Character[] doubleLetters, Character[] tripleLetters, boolean doubleWord, boolean tripleWord) {
        this.word = word;
        this.doubleLetters = Arrays.asList(doubleLetters);
        this.tripleLetters = Arrays.asList(tripleLetters);
        this.doubleWord = doubleWord;
        this.tripleWord = tripleWord;
    }

    public int score() {
        if (word == null || word.isEmpty()) {
            return 0;
        }
        int score = 0;
        for (char c : word.toUpperCase().toCharArray()) {
            int letterScore = letterValues.getOrDefault(c, 0);
            if (doubleLetters.contains(c)) {
                letterScore *= 2;
            }
            if (tripleLetters.contains(c)) {
                letterScore *= 3;
            }
            score += letterScore;
        }
        if (doubleWord) {
            score *= 2;
        }
        if (tripleWord) {
            score *= 3;
        }
        return score;
    }
}
