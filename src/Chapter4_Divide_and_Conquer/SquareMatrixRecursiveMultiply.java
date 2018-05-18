package Chapter4_Divide_and_Conquer;

/* Strassen's method for multiplying square matrices.
    Runs in O(n^2.81) time, not O(n^3).
 */
public class SquareMatrixRecursiveMultiply {

    public static int[][] recursiveMult(int[][] A, int[][] B){

        int n = A.length;
        int[][] C = new int[n][n];
        if(n == 1){
            C[n-1][n-1] = (A[n][n] * B[n][n]);
        }else{
            int[][] a1 = new int[n/2][n/2];
            int[][] a2 = new int[n/2][n/2];
            int[][] a3 = new int[n/2][n/2];
            int[][] a4 = new int[n/2][n/2];

            int[][] b1 = new int[n/2][n/2];
            int[][] b2 = new int[n/2][n/2];
            int[][] b3 = new int[n/2][n/2];
            int[][] b4 = new int[n/2][n/2];

            int[][] c1 = new int[n/2][n/2];
            int[][] c2 = new int[n/2][n/2];
            int[][] c3 = new int[n/2][n/2];
            int[][] c4 = new int[n/2][n/2];

            for(int i = 1; i <= n*n; i++){

            }
        }

        return C;
    }
}
