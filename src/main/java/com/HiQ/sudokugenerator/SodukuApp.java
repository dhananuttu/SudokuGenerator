package com.HiQ.sudokugenerator;

import static com.HiQ.sudokugenerator.Sudoku.MAX_VALID_SUDOKU_NUMBER;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SodukuApp {
    public static void main(String[] args) {
        if (args.length == 0) {

	    System.out.println("Welcome to Sudoku Generator");
	    System.out.print(SudokuGenerator.generateRandomSudoku());
            reinitializeInstructions();
	} else {
		System.out.println("Please enter valid Input");
		}
    }
    private static void reinitializeInstructions() {
        printInstructions();
	try {
	String readInput = readInput();
	if (readInput.equalsIgnoreCase("a")) {
	System.out.print(SudokuGenerator.generateRandomSudoku());
	reinitializeInstructions();
	} else if (readInput.equalsIgnoreCase("b")) {
	System.out.print(SudokuGenerator.generatePlayableRandomSudoku(Sudoku.SudokuLevel.MEDIUM));
	reinitializeInstructions();
	} else if (readInput.equalsIgnoreCase("c")) {    
            Scanner scan = new Scanner(System.in);
            int[][] matrix = new int[MAX_VALID_SUDOKU_NUMBER][MAX_VALID_SUDOKU_NUMBER];
            Sudoku.board = enterMatrixData(scan, matrix, MAX_VALID_SUDOKU_NUMBER, MAX_VALID_SUDOKU_NUMBER);
            boolean checkSudokuSolution = SudokuChecker.checkSudokuSolution( Sudoku.board, 2);
            if (checkSudokuSolution)            {
                if (Sudoku.solve()) {
                System.out.println("Sudoku Board solved");
                Sudoku.display();
                }
            }
            else {
		System.out.println("Invalid Input , Number should not exceed 4");
                reinitializeInstructions();
                 }
	    } 
	} catch (Exception e) {
			System.out.println("Invalid Input");
			reinitializeInstructions();
		}
	}
    public static int[][] enterMatrixData(Scanner scan, int[][] matrix, int matrixRow, int matrixCol){
     System.out.println("Enter Board Data");
          
        for (int i = 0; i < matrixRow; i++){
        for (int j = 0; j < matrixCol; j++){
         matrix[i][j] = scan.nextInt();
        }
        }
       return matrix;
  }
    private static void printInstructions() {
    System.out.println("Please enter the following options:");
    System.out.println("[a] Randomly Generated Sudoku Board");
    System.out.println("[b] Generate a Sudoku playable Board ");
    System.out.println("[c] Enter 4x4 SudokuChecker");
	}
    private static String readInput() {
    try {
	BufferedReader bufferedReader = new BufferedReader(
	new InputStreamReader(System.in));
	return bufferedReader.readLine();
	} catch (Exception e) {
	return null;
	}
    }
}
