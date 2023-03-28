public class Main {
    public static void main(String[] args) {
        HashTable table = new HashTable(5, 0.5f);
        table.put(1, "1");
        table.put(2, "1");
        table.put(3, "1");
        table.put(4, "1");
        table.put(5, "1");
        System.out.println(table.toString());
        System.out.println(SolveProblemsWithHashTable.findTheFirstNonRepeatedCharacter("a b c a b "));
        System.out.println(SolveProblemsWithHashTable.findTheFirstRepeatedCharacter("abcab"));
    }
}