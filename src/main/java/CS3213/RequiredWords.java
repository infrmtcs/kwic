package CS3213;

import java.util.HashSet;

/**
 * Created by junchao on 8/23/2014.
 */
public class RequiredWords {
    private HashSet<String> _requiredWords;
    private static RequiredWords _instance;
    private RequiredWords() {
        this._requiredWords = new HashSet<String>();
    }

    public static RequiredWords getRequiredWords() {
        if (_instance == null) {
            _instance = new RequiredWords();
        }

        return _instance;
    }

    public void addRequiredWord(String word) {
        assert(word != null);
        this._requiredWords.add(word);
    }

    public void removeRequiredWord(String word) {
        assert(word != null);
        this._requiredWords.remove(word);
    }

    public boolean isWordRequired(String word) {
        assert(word != null);
        return this._requiredWords.contains(word);
    }
}
