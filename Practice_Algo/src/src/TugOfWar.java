//https://www.geeksforgeeks.org/tug-of-war/

public class TugOfWar {
   public static int min_diff=Integer.MAX_VALUE;

    public static void main(String[] args) {
        int arr[] = {23, 45, -34, 12, 0, 98,
                -99, 4, 189, -1, 4};
        getHalfSumIndexes(arr);



        int arr1[] =  {3, 4, 5, -3, 100, 1, 89, 54, 23, 20};
        //getHalfSumIndexes(arr1);
    }

    private static void getHalfSumIndexes(int[] arr) {
        boolean [] finalArrIndex=new boolean[arr.length];
        boolean [] currentArrIndex=new boolean[arr.length];
        int currentSum=0;
        int targetSum=0;

        for(int i=0;i<arr.length;i++){
            targetSum+=targetSum/2;
        }
        targetSum=targetSum/2;

        getFinalHalfSumIndexes(arr,currentArrIndex,finalArrIndex,targetSum,currentSum,0,0);



      //  System.out.println("min_diff = "+min_diff);

        for(int i=0;i<finalArrIndex.length;i++){

            if(finalArrIndex[i])
                System.out.print(i+" ="+arr[i]+"   ");
        }
        System.out.println("===================================");
        for(int i=0;i<finalArrIndex.length;i++){

            if(!finalArrIndex[i])
                System.out.print(i+" ="+arr[i]+"   ");
        }
    }

    private static void getFinalHalfSumIndexes(int[] arr, boolean[] currentArrIndex, boolean[] finalArrIndex,
                                               int targetSum, int currentSum, int count, int currentIndex) {

      //  System.out.println("currentSum ==== "+currentSum+"    and count="+count);

        if(currentIndex>arr.length) return;
        if(arr.length/2-count>arr.length-currentIndex) return;

        getFinalHalfSumIndexes(arr,currentArrIndex,finalArrIndex,targetSum,currentSum,count,currentIndex+1);

        count++;
        currentSum+=arr[currentIndex];
        currentArrIndex[currentIndex]=true;

        if(count==arr.length/2)
        {
        if(Math.abs(targetSum-currentSum)<min_diff){
            min_diff=Math.abs(targetSum-currentSum);
            for(int i=0;i<arr.length;i++){
                finalArrIndex[i]=currentArrIndex[i];
            }
        }
        }
        else{
            getFinalHalfSumIndexes(arr,currentArrIndex,finalArrIndex,targetSum,currentSum,count,currentIndex+1);
        }

        currentArrIndex[currentIndex]=false;

    }



}
