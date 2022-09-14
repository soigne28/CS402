import java.io.*;
import java.util.Arrays;
import java.util.Random;


public class MatrixMultPartB {
    static Random rd = new Random();
    static int [][] MatOne = new int [1000][900];
    static int [][] MatTwo = new int [900][1000];

    public static int MMultCell(int[][] MatOne, int[][] MatTwo, int row, int col){
        int cell = 0;
        for (int i = 0; i<(MatTwo.length);i++){
            cell += MatOne[row][i]*MatTwo[i][col];
        }
        return cell;
    }

    public static int [][] MMult(int[][] MatOne, int[][] MatTwo){
        int[][] result = new int[MatOne.length][MatTwo[0].length];
        int columnLength = result[0].length;
        int rowLength = result.length;
        for (int col=0;col<columnLength;col++){
            for (int row=0;row<rowLength;row++){

                result[row][col] = MMultCell(MatOne,MatTwo,row,col);
            }
        }
        return result;
    }

    public static void main (String[] args){
        long startTime = System.nanoTime();

        Random rd = new Random();
        System.out.println("Matrix one:");
        for (int i=0;i<1000;i++){
            for (int j=0;j<900;j++){
                MatOne[i][j] = rd.nextInt(1000);
                System.out.print(MatOne[i][j]+"\t");
            }
            System.out.print("\n");
        }

        System.out.println();
        System.out.println("Matrix two:");
        for (int k=0;k<900;k++){
            for (int l=0;l<1000;l++){
                MatTwo[k][l] = rd.nextInt(1000);
                System.out.print(MatTwo[k][l]+"\t");
            }
            System.out.print("\n");
        }
        System.out.println();
        System.out.println("Product of the " + MatOne.length + " x " + MatTwo.length + " and " + MatTwo.length + " x " + MatOne.length + " matrix is:");

        int [][] rslt = MMult(MatOne,MatTwo);

        for (int i=0;i< MatOne.length;i++){
            for (int j=0;j<MatOne.length;j++){
                System.out.print(rslt[i][j]+" ");
            }
            System.out.print("\n");
        }
        long endTime = System.nanoTime();
        long duration = (endTime-startTime);
        System.out.println("");
        System.out.println("It took "+duration/1000000000+" seconds");


    }
}
