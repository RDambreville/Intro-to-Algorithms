package Chapter2_Getting_Started;

import java.util.Scanner;

public class InsertionSort {

    public static int[] InsertSort(int[] array){

        //int[] sortedArray = new int[array.length];
        for(int j = 1; j < array.length; j++){
            int key = array[j];
            //sortedArray[j-1] = array[j];
            //Insert array[j] into sorted sequence array[0...j-1]
            int i = j -1;
            while(i >= 0 && array[i] > key){
                array[i+1] = array[i];
                i--;
            }
            array[i+1] = key;
        }
        return array;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of integers in the sequence: ");
        int[] sequence = new int[scanner.nextInt()];
        System.out.println("Enter the sequence one integer at a time with a single space between consecutive characters: \n");
        for(int i = 0; i < sequence.length; i++){
            sequence[i] = scanner.nextInt();
        }

        int[] sortedArray = InsertSort(sequence);

        System.out.print("\nThe sorted sequence is: " );
        for(int i = 0; i < sortedArray.length; i++){
            System.out.print(sortedArray[i] + " ");
        }

    }
}
