package Chapter2_Getting_Started;

import java.util.Scanner;

public class MergeSort {

    public static int[] Merge(int[] A, int start, int mid, int end){
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int[] L = new int[n1+1];
        int[] R = new int[n2+1];

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
                j++;
            }
        }
        return A;
    }


    public static int[] MergeSort(int[] A, int start, int end){
        if(start < end){
            int mid = Math.floorDiv((start + end), 2);
            //Actually split the sequence A in half and pass a local copy of it B to the recursion
            /*int[] B = new int[mid+1];
            for(int i = start; i <= mid; i++){
                B[i] = A[i];
            }*/
            MergeSort(A, start, mid);
            MergeSort(A, mid+1, end);
            Merge(A, start, mid, end);
        }
        return A ;
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

        System.out.println("The sorted sequence is: " );
        for(int i: sortedArray) {
            System.out.println(i);
        }

    }
}
