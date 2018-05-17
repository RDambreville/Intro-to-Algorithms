package Chapter4_Divide_and_Conquer;
import java.util.*;

public class FindMaxSubarray{

    public static int[] FindMaxCrossingSub(int[] A, int low, int mid, int high){
        int[] returnValues = new int[3];
        int maxLeft = 0;
        int maxRight = 0;

        int leftSum = -Integer.MAX_VALUE;
        int sum = 0;
        for(int i = mid; i >= low; i--){
            sum += A[i];
            if(sum > leftSum){
                leftSum = sum;
                maxLeft = i;
            }
        }

        int rightSum = -Integer.MAX_VALUE;
        sum = 0;
        for(int j = (mid + 1); j <= high; j++){
            sum += A[j];
            if(sum > rightSum){
                rightSum = sum;
                maxRight = j;
            }
        }
        returnValues[0] = maxLeft;
        returnValues[1] = maxRight;
        returnValues[2] = leftSum + rightSum;

        return returnValues;
    }


    public static int[] FindMaxSub(int[] A, int low, int high){
        int[] defaultSet = new int[3];
        defaultSet[0] = low;
        defaultSet[1] = high;
        defaultSet[2] = A[low];
        int[] right_lowHighSum;
        int[] left_lowHighSum;
        int[] cross_lowHighSum;

        if(high == low){
            return defaultSet;
        }else{
            int mid = Math.floorDiv((low + high), 2);
            left_lowHighSum = FindMaxSub(A, low, mid);
            right_lowHighSum = FindMaxSub(A, mid+1, high);
            cross_lowHighSum = FindMaxCrossingSub(A, low, mid, high);
            if(left_lowHighSum[2] >= right_lowHighSum[2] && left_lowHighSum[2] >= cross_lowHighSum[2]){
                return left_lowHighSum;
            }else if(right_lowHighSum[2] >= left_lowHighSum[2] && right_lowHighSum[2] >= cross_lowHighSum[2]){
                return right_lowHighSum;
            }else{
                return cross_lowHighSum;
            }


        }
    }



    public static void main(int[] sequence /*String[] args*/){
       /* Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of integers in your sequence: ");
        int[] sequence = new int[scan.nextInt()];
        System.out.println("Enter the sequence of integers you would like to sort (include a space between integers): ");
        for(int i = 0; i < sequence.length; i++){
            sequence[i] = scan.nextInt();
        }*/

        int[] maxSubAndSum = FindMaxSub(sequence, 0, sequence.length-1);
        System.out.println("The maximum subarray is: ");
        /*for(int i = 0; i <maxSubAndSum.length-1; i++){
            System.out.print(sequence[i]);
        }*/
        for(int i = maxSubAndSum[0]; i <= maxSubAndSum[1]; i++){
            System.out.print(sequence[i] + " ");
        }
        System.out.println("\nThe sum of all the elements in the maximum subarray is: " + maxSubAndSum[2]);

    }
}