package Chapter2_Getting_Started;

import java.util.Scanner;

public class MergeSort {

    static int inversions = 0;

    public static long[] Merge(long[] A, int start, int mid, int end){
        int n1 = mid - start + 1;
        int n2 = end - mid;

        long[] L = new long[n1+1];
        long[] R = new long[n2+1];

        // populate the left deck
        for(int i = 0; i < L.length-1; i++){
            L[i] = A[(start + i) /*- 1*/];
        }

        // populate the right deck
        for (int j = 0; j < R.length-1; j++){
            R[j] = A[(mid + 1) + j];
        }

        // set the sentinel values
        L[n1] =/* -1*/ Integer.MAX_VALUE;
        R[n2] = /*-1*/ Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        for(int k = start; k <= end; k++){
            if(L[i] <= R[j] /*&& L[i] != -1*/){
                    A[k] = L[i];
                    i++;
            }else /*if(R[j] != -1)*/{
                A[k] = R[j];
                if(L[i] != Integer.MAX_VALUE){
                    //If R.length is 2, then it contains 1 actual value from A and the sentinel value. Therefore, only subtract 1 from R.length to account for the sentinel
                    // If R.length is greater than 2, then it contains more than 1 value from A and the sentinel value. Therefore, subtract 2 from  R.length to account for the sentinel value at the end of the array
                    int positionOfItemToBeSwapped = mid + (R.length == 2 ? R.length-1 : R.length-2) + j;
                    /*if(mid == 0){
                        positionOfItemToBeSwapped++;
                    }*/
                    inversions += positionOfItemToBeSwapped - k /*mid + (R.length-1) + j*/ /*end-k*/ /*inversions++*/;
                }
                j++;
            }
        }
        return A;
    }


    public static long[] MergeSort(long[] A, int start, int end){
        if(start < end){
            int mid = Math.floorDiv((start + end), 2);
            //Actually split the sequence A in half and pass a local copy of it B to the recursion
            /*long[] B = new int[mid+1];
            for(int i = start; i <= mid; i++){
                B[i] = A[i];
            }*/
            MergeSort(A, start, mid);
            MergeSort(A, mid+1, end);
            Merge(A, start, mid, end);
        }
        return A ;
    }

    public static void main(long[] sequence/*String[] args*/){
        //Scanner scanner = new Scanner(System.in);
        //System.out.print("Enter the number of integers in the sequence: ");
        //long[] sequence = new int[scanner.nextInt()];
        //long[] sequence = new int[args[1].length()];

       /* char[] charSequence = args[1].toCharArray();
        long[]  sequence = new int[charSequence.length];
        //System.out.println("Enter the sequence one integer at a time with a single space between consecutive characters: \n");
        for(int i = 0; i < sequence.length; i++){
            //sequence[i] = scanner.nextInt();
            //sequence[i] = Integer.parseInt(args[1].charAt(i));
            sequence[i] = charSequence[i] - '0';

        }*/

        long[] sortedArray = MergeSort(sequence, 0, sequence.length-1);

        System.out.println("The sorted sequence is: " );
        for(long i: sortedArray) {
            System.out.println(i);
        }

        System.out.println("Inversions: " + inversions);

    }
}
