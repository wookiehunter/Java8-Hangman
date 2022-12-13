public class Word {

    private final char[] letters;
    private final boolean[] guessed;

    public Word(String s) {
        String word = s.toUpperCase();
        int wordLength = word.length();

        letters = new char[wordLength];
        guessed = new boolean[wordLength];

        for (int i = 0; i < wordLength; i++) {
            letters[i] = word.charAt(i);
        }
    }

    public boolean guessLetter(char c) {
        char letter = Character.toUpperCase(c);

        // Check all of the letters; remember if at least one of them was correct
        boolean correct = false;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == letter) {
                correct = true;
                guessed[i] = true;
            }
        }

        // Returns true if the guess was correct, false otherwise
        return correct;
    }

    public boolean isGuessed() {
        // If any of the letters in the word is not yet guessed, then return false
        for (boolean element : guessed) {
            if (!element) {
                return false;
            }
        }

        // If we reach this point, then all letters have been guessed
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < letters.length; i++) {
            sb.append(guessed[i] ? letters[i] : '_');
        }
        return sb.toString();
    }
}
