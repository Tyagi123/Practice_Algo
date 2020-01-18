//https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
public class MatrixChainMultiplication {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        getMinMultiplication(arr);

        int[] arr1 = {40, 20, 30, 10, 30};
        getMinMultiplication(arr1);

        int[] arr2 = {10, 20, 30, 40, 30};
        getMinMultiplication(arr2);

        int[] arr3 = {10, 20, 30};
        getMinMultiplication(arr3);

    }

    private static void getMinMultiplication(int[] arr) {

        int[][] cache = new int[arr.length - 1][arr.length - 1];

        for (int i = 0; i < cache.length - 1; i++) {
            cache[i][i + 1] = arr[i] * arr[i + 1] * arr[i + 2];
        }

        int k = 2;


        while (k < arr.length) {
            for (int i = 0; i < cache.length; i++) {
                for (int j = i; j + k < cache.length; j++) {
                    cache[i][j + k] = Math.min(cache[i][j + k - 1] + arr[i] * arr[j + k] * arr[j + k + 1],
                            cache[i + 1][j + k] + arr[i] * arr[i + 1] * arr[i + k + 1]);
                }
            }
            k++;
        }
        System.out.println(cache[0][cache.length - 1]);
    }
}
