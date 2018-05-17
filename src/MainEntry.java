import Chapter2_Getting_Started.InsertionSort;
import Chapter2_Getting_Started.MergeSort;
import Chapter4_Divide_and_Conquer.FindMaxSubarray;

import java.util.*;
public class MainEntry{
    public static void main(String[] args){
        ArrayList<String> listOfAlgorithms = new ArrayList<>();
        listOfAlgorithms.add("(1) Insertion Sort");
        listOfAlgorithms.add("(2) Merge Sort");
        listOfAlgorithms.add("(3) Max Subarray");
        listOfAlgorithms.trimToSize();

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of integers in your sequence: ");
        int[] sequence = new int[scan.nextInt()];
        System.out.println("Enter the sequence of integers you would like to sort (include a space between integers): ");
        for(int i = 0; i < sequence.length; i++){
            sequence[i] = scan.nextInt();
        }
        System.out.println("Using the list below, enter the number that represents the algorithm you'd like to use: ");
        for(int i = 0; i < listOfAlgorithms.size(); i++){
            System.out.println(listOfAlgorithms.get(i));
        }
        int selection = scan.nextInt();

        switch(selection){
            case 1:
                InsertionSort.main(sequence);
                break;

            case 2:
                MergeSort.main(sequence);
                break;

            case 3:
                FindMaxSubarray.main(sequence);
                break;
        }
    }
}