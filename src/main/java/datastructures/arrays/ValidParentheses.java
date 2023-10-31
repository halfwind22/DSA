package datastructures.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    private final Map<Character, Character> characterCharacterMap;

    public ValidParentheses() {
        this.characterCharacterMap = new HashMap<>();
        this.characterCharacterMap.put('{', '}');
        this.characterCharacterMap.put('[', ']');
        this.characterCharacterMap.put('(', ')');
    }

    public boolean isValid(String s) {
        if (s.length() > 1) {
            Stack<Character> characterStack = new Stack<>();
            char[] charArr = s.toCharArray();
            for (char c : charArr) {
                if (characterCharacterMap.containsKey(c)) {
                    characterStack.push(c);
                } else if (!characterStack.isEmpty() && !characterCharacterMap.containsKey(c) && characterCharacterMap.get(characterStack.peek()) == c) {
                    characterStack.pop();
                } else {
                    return false;
                }
            }
            return characterStack.isEmpty();
        }
        return false;
    }
}
