import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolveProblemsWithHashTable {

    public static Character findTheFirstNonRepeatedCharacter(String string) {
        Map<Character, Integer> hashTable = new HashMap<>();


        char[] charArray = string.toCharArray();

        for (var character : charArray) {
            if (hashTable.containsKey(character))
                hashTable.put(character, 1);
            else
                hashTable.put(character, 0);
        }

        for (var character : charArray) {
            if (hashTable.get(character) == 0)
                return character;
        }

        return null;
    }

    public static Character findTheFirstRepeatedCharacter(String string) {
        Set<Character> set = new HashSet<>();

        char[] charArray = string.toCharArray();

        for (var character : charArray) {
            if (set.contains(character))
                return character;
            else
                set.add(character);
        }

        return null;
    }

}