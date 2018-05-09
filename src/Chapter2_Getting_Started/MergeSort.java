package Chapter2_Getting_Started;

import java.util.Scanner;

public class MergeSort {

    public static int[] Merge(int[] A, int start, int mid, int end){
        int n1 = (mid - start) + 1;
        int n2 = end - mid;

        int[] L = new int[n1+1];
        int[] R = new int[n2+1];

        // populate the left deck
        for(int i = 0; i < L.length; i++){
            L[i] = A[(start + i) /*- 1*/];
        }

        // populate the right deck
        for (int j = 0; j < R.length; j++){
            R[j] = A[mid + j];
        }

        // set the sentinel values
        L[n1] = -1;
        R[n2] = -1;

        int i = 0;
        int j = 0;

        for(int k = start; k < end; k++){
            if(L[i] <= R[j]){
                    A[k] = L[i];
                    i++;
            }else{
                A[k] = R[j];
                j++;
            }
        }
        return A;
    }


    public static int[] MergeSort(int[] A, int start, int end){
        if(start < end){
            int mid = Math.floorDiv((start + end), 2);
            MergeSort(A, start, mid);
            MergeSort(A, mid+1, end);
            Merge(A, start, mid, end);
        }
        return A;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of integers in the sequence: ");
        int[] sequence = new int[scanner.nextInt()];
        System.out.println("Enter the sequence one integer at a time with a single space between consecutive characters: \n");
        for(int i = 0; i < sequence.length; i++){
            sequence[i] = scanner.nextInt();
        }

        int[] sortedArray = MergeSort(sequence, 0, sequence.length-1);

        System.out.print("\nThe sorted sequence is: " );
        for(int i = 0; i < sortedArray.length; i++){
            System.out.print(sortedArray[i] + " ");
        }

    }
}
