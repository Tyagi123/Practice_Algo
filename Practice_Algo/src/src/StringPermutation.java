public class StringPermutation {

    public static void main(String[] args) {
        getPermutation("abcd");
    }

    private static void getPermutation(String str) {

        if (str == null || str.isEmpty()) {
            System.out.println("Invalid String");
            return;
        }

        int len = str.length();
        int[] cache = new int[len];
        for (int i = 0; i < len; i++) {
            cache = new int[len];
            cache[i] = 1;
            getPermutationForSingleChar(cache, len, String.valueOf(str.charAt(i)), i + 1, str);
        }
    }

    private static void getPermutationForSingleChar(int[] cache, int len, String currentString, int currentIndex,
                                                    String str) {

        int index = 0;

        while (index < len - 1) {
            if (currentIndex == len) currentIndex = 0;
            //  System.out.println(currentString+" ----- "+currentIndex);
            printPermutation(cache, len, currentString, currentIndex, str);
            currentIndex++;
            index++;
        }
    }

    private static void printPermutation(int[] cache, int len, String currentString, int currentIndex, String str) {
        // System.out.println(currentString+" ==== "+currentIndex);
        if (currentString.length() == len) {
            System.out.println(currentString);
            return;
        }
        if (currentIndex == len) currentIndex = 0;


        if (cache[currentIndex] == 0) {
            cache[currentIndex] = 1;
            printPermutation(cache, len, currentString + str.charAt(currentIndex),
                    currentIndex + 1, str);
            cache[currentIndex] = 0;
        } else {
            printPermutation(cache, len, currentString, currentIndex + 1, str);
        }


    }
}
