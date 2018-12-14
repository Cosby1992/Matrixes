package com.company;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * This class contains different methods to "manipulate" int matrixes
 *
 * Including:   1. Showing a matrix in the console
 *              2. Finding the longest row in a matrix
 *              3. Shuffling a rows in a matrix
 *
 *
 * @author Cosby
 * @version 1.0
 * @since 12. december 2018
 */

public class Matrix {


    /*------------------------------------------------------------------------------------------------------------------
    ----------------------------------------->>INTEGER MATRIX METHODS<<-------------------------------------------------
    ------------------------------------------------------------------------------------------------------------------*/

    /**
     * This method takes a int matrix and find the longest row by checking the next row is
     * bigger than the previous using loops.
     *
     * @param matrix --- Takes an integer matrix as input
     * @return --------- Returns an integer containing the largest row number
     */
    public static int largestRow(int[][] matrix){

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

    /**
     * This method shows an Integer matrix in the console. The print is formatted and shows
     * up to 12 digits (max. int size) and prints indexes as well
     *
     *      Example:
     *
     *      Columns    |           0 |           1 |           2 |           3 |
     *      --------------------------------------------------------------------
     *      Row     0  |          10 |          20 |          30 |          40 |
     *      Row     1  |          50 |          60 |          70 |          80 |
     *      Row     2  |          90 |         100 |         110 |         120 |
     *      Row     3  |         130 |         140 |         150 |         160 |
     *
     *
     * @param matrix --- Takes an Integer matrix as input
     */
    public static void showMatrix(int[][] matrix){
        int largestRowInArray_2D = largestRow(matrix);

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


        for (int i = 0; i < matrix.length; i++) {
            System.out.print("Row ");
            System.out.printf("%5d  |", i);
            for (int j = 0; j < largestRowInArray_2D; j++) {
                try {
                    System.out.printf("%12d |", matrix[i][j]);
                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.print("             |");
                }
            }
            System.out.println();
        }
    }

    public static int[][] shuffleRows(int[][] matrix){

        ArrayList<Integer> tempArrayList = new ArrayList<Integer>();


        int x = 0;
        int y = 0;

        while (x<matrix.length){

            for (int i = 0; i < matrix[x].length; i++) {
                tempArrayList.add(matrix[x][i]);
            }

            Collections.shuffle(tempArrayList);

            for (int i = 0; i < tempArrayList.size(); i++) {
                matrix[x][i] = tempArrayList.get(i);
            }
            tempArrayList.clear();
            x++;
        }

        return matrix;
    }

    public static int[][] generateIntMatrix(int numberOfColumns, int numberOfRows, int smallestNumber, int biggestNumber ){

        int[][] intMatrix = new int[numberOfRows][numberOfColumns];

        for (int i = 0; i < intMatrix.length; i++) {
            for (int j = 0; j < intMatrix[i].length; j++) {
                intMatrix[i][j] = (int) ((Math.random()*(biggestNumber-smallestNumber))+smallestNumber);
            }
        }

        return intMatrix;
    }


    /*------------------------------------------------------------------------------------------------------------------
    ----------------------------------------->>STRING MATRIX METHODS<<--------------------------------------------------
    ------------------------------------------------------------------------------------------------------------------*/

    /**
     * This method takes a int matrix and find the longest row by checking the next row is
     * bigger than the previous using loops.
     *
     * @param matrix --- Takes a String matrix as input
     * @return --------- Returns an integer containing the largest row number
     */

    public static int largestRow(String[][] matrix){

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

    public static void showMatrix(String[][] matrix){
        // Finds longest row in matrix
        int largestRow = largestRow(matrix);

        System.out.print("Columns    |");

        for (int i = 0; i < largestRow; i++) {
            System.out.printf("%15d |", i);
        }

        System.out.println();
        System.out.print("------------");

        for (int i = 0; i < largestRow; i++) {
            System.out.print("-----------------");
        }

        System.out.println();

        String stringToCut = "";


        for (int i = 0; i < matrix.length; i++) {
            System.out.print("Row ");
            System.out.printf("%5d  |", i);
            for (int j = 0; j < largestRow; j++) {
                try {
                    if(matrix[i][j].length()<=15) {
                        System.out.printf("%-15s |", matrix[i][j]);
                    } else {
                        stringToCut = matrix[i][j].substring(0,12);
                        System.out.printf(stringToCut + "... |");
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.print("                |");
                }

                /*
                if(j == matrix[i].length-1){
                    System.out.println();
                }
                */
            }
            System.out.println();
        }
    }









}
