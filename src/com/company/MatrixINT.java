package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class MatrixINT {


    /**
     * This method takes a int matrix and find the longest row by checking the next row is
     * bigger than the previous using loops.
     *
     * @param matrix --- Takes an integer matrix as input
     * @return --------- Returns an integer containing the largest row number
     */

    public static int largestRowInIntMatrix(int[][] matrix){

        // Initialize integer with zero
        int largestRow = 0;

        //For loop running through each row
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                /*Checking if a row length is bigger than a previous checked row, assigning new highest row
                 *number to variable "largestRow"
                 */
                 if(matrix[i].length>largestRow){
                    largestRow = matrix[i].length;
                }
            }
        }

        return largestRow;
    }

    public static void showMatrix(int[][] intMatrix){
        int largestRowInArray_2D = largestRowInIntMatrix(intMatrix);

        int x = 0;

        System.out.print("Columns    |");

        for (int i = 0; i < largestRowInArray_2D; i++) {
            System.out.printf("%12d |", i);
        }

        System.out.println();
        System.out.print("------------");

        for (int i = 0; i < largestRowInArray_2D; i++) {
            System.out.print("--------------");
        }

        System.out.println();


        for (int i = 0; i < intMatrix.length; i++) {
            System.out.print("Row ");
            System.out.printf("%5d", i);
            System.out.print("   ");
            for (int j = 0; j < intMatrix[i].length; j++) {
                System.out.printf("%12d |", intMatrix[i][j]);
                if(j == intMatrix[i].length-1){
                    System.out.println();
                }
            }
        }
    }

    public static int[][] shuffleMatrixRows(int[][] intMatrix){

        ArrayList<Integer> tempArrayList = new ArrayList<Integer>();


        int x = 0;
        int y = 0;

        while (x<intMatrix.length){

            for (int i = 0; i < intMatrix[x].length; i++) {
                tempArrayList.add(intMatrix[x][i]);
            }

            Collections.shuffle(tempArrayList);

            for (int i = 0; i < tempArrayList.size(); i++) {
                intMatrix[x][i] = tempArrayList.get(i);
            }
            tempArrayList.clear();
            x++;
        }

        return intMatrix;
    }

    public static int[][] createRandomIntMatrix(int numberOfColumns, int numberOfRows, int smallestNumber, int biggestNumber ){

        int[][] intMatrix = new int[numberOfRows][numberOfColumns];

        for (int i = 0; i < intMatrix.length; i++) {
            for (int j = 0; j < intMatrix[i].length; j++) {
                intMatrix[i][j] = (int) ((Math.random()*(biggestNumber-smallestNumber))+smallestNumber);
            }
        }

        return intMatrix;
    }


}
