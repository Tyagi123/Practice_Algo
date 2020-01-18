import java.util.HashSet;
import java.util.Set;

public class DecodeString {

    public static void main(String[] args) {
        Set<String> result = new HashSet<>();
        decodeString("1123", result, new StringBuilder(" "), 0, 1);

        result.stream().forEach(System.out::println);
    }

    private static StringBuilder decodeString(String str, Set<String> result, StringBuilder currentStr, int start, int end) {

        if (end > str.length()) return currentStr;

        String localStr = str.substring(start, end);

        if (Integer.parseInt(localStr) <= 26) {
            char ch = (char) (Integer.parseInt(localStr) + 64);
            currentStr.append(ch);
        } else {
            return currentStr;
        }

        if (end == str.length()) {
            result.add(currentStr.toString());
            return currentStr;
        }
        currentStr = decodeString(str, result, currentStr, end, end + 1);
        currentStr = decodeString(str, result, currentStr, end, end + 2);
        return currentStr;
    }
}
