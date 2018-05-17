package Chapter4_Divide_and_Conquer;

import java.util.Scanner;

public class SquareMatrixMultiply {

    public static int[][] SquareMatrixMult(int[][] A, int[][] B){
        int n = A.length;
        int[][] C = new int[A.length][A.length];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                //int c_ij = 0;
                for(int k = 0; k < n; k++){
                    //c_ij += (A[i][k] * B[k][j]);
                    C[i][j] += (A[i][k] * B[k][j]);
                }
            }
        }
        return C;
    }



    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns in your square matrices: ");
        int n = scanner.nextInt();
        int[][] matrix1 = new int[n][n];
        int[][] matrix2 = new int[n][n];
        System.out.println("Enter the first matrix one line at a time: ");
        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j < n; j++){
                matrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the second matrix one line at a time: ");
        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j < n; j++){
                matrix2[i][j] = scanner.nextInt();
            }
        }



        int[][] resultMatrix = SquareMatrixMult(matrix1, matrix2);

        System.out.println("The result matrix is: ");
        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j < n; j++){
                if(j == 0){
                    System.out.print("\n" + resultMatrix[i][j] + " ");
                }else{
                    System.out.print(resultMatrix[i][j] + " ");
                }
            }
        }
    }

}
