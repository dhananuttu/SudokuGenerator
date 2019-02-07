package com.HiQ.sudokugenerator;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {
    public static final int MIN_VALID_SUDOKU_NUMBER = 1;
    public static final int MAX_VALID_SUDOKU_NUMBER = 4;
    public static final int SIZE_OF_EACH_SQUARE = 2;
    public static final int VALUE_FOR_EMPTY_CELL = 0;
    public static int[][] board;
    public static final Set<Integer> SUDOKU_NUMBERS = new HashSet<Integer>(
			MAX_VALID_SUDOKU_NUMBER);
    private boolean[][] numbersSetPerRow = new boolean[MAX_VALID_SUDOKU_NUMBER][MAX_VALID_SUDOKU_NUMBER];
    private boolean[][] numbersSetPerColumns = new boolean[MAX_VALID_SUDOKU_NUMBER][MAX_VALID_SUDOKU_NUMBER];

    public enum SudokuLevel {
    EASY(12), MEDIUM(8), DIFFICULT(4);
    private int valorizedCells;

    private SudokuLevel(int valorizedCells) {
    this.valorizedCells = valorizedCells;
    }
		
    public int getValorizedCells() {
    return valorizedCells;}
    }
    static {
    for (int i = MIN_VALID_SUDOKU_NUMBER; i <= MAX_VALID_SUDOKU_NUMBER; i++) {
    SUDOKU_NUMBERS.add(i);
    }
    }

    private Integer[][] matrix = new Integer[MAX_VALID_SUDOKU_NUMBER][MAX_VALID_SUDOKU_NUMBER];
    public static boolean isValidSudokuNumber(int number) {
    return (number >= MIN_VALID_SUDOKU_NUMBER - 1 && number <= MAX_VALID_SUDOKU_NUMBER);
    }
       
    public Integer[][] getMatrix() {
    return matrix;
    }

    public void setMatrix(Integer[][] matrix) {
    this.matrix = matrix;
    }
     public boolean isValid() {
	numbersSetPerRow = new boolean[MAX_VALID_SUDOKU_NUMBER][MAX_VALID_SUDOKU_NUMBER];
	numbersSetPerColumns = new boolean[MAX_VALID_SUDOKU_NUMBER][MAX_VALID_SUDOKU_NUMBER];

	for (int row = 0; row < MAX_VALID_SUDOKU_NUMBER; row++) {
	for (int col = 0; col < MAX_VALID_SUDOKU_NUMBER; col++) {
	int n = matrix[row][col];
	    if (n > VALUE_FOR_EMPTY_CELL
		&& (numbersSetPerRow[row][n - 1] || numbersSetPerColumns[col][n - 1])) {
       	return false;
	} else {
	    if (n > VALUE_FOR_EMPTY_CELL) {
	    numbersSetPerRow[row][n - 1] = true;
	    numbersSetPerColumns[col][n - 1] = true;	
            }
	}
	}
	}
	return true;
	}  
    public static boolean isInRow(int row, int number) {
    for (int i = 0; i < MAX_VALID_SUDOKU_NUMBER; i++)
	if (board[row][i] == number)
	    return true;
		
	return false;
    }
	
    public static boolean isInCol(int col, int number) {
    for (int i = 0; i < MAX_VALID_SUDOKU_NUMBER; i++)
	if (board[i][col] == number)
	    return true;
		
	return false;
    }
	
    private static boolean isInBox(int row, int col, int number) {
	int r = row - row % 2;
	int c = col - col % 2;
		
	for (int i = r; i < r + 2; i++)
            for (int j = c; j < c + 2; j++)
		if (board[i][j] == number)
		return true;
	return false;
	}
	
    private static boolean isOk(int row, int col, int number) {
		return !isInRow(row, number)  &&  !isInCol(col, number)  &&  !isInBox(row, col, number);
	}
	
    public static boolean solve() {
    for (int row = 0; row < MAX_VALID_SUDOKU_NUMBER; row++) {
        for (int col = 0; col < MAX_VALID_SUDOKU_NUMBER; col++) {
        if (board[row][col] == VALUE_FOR_EMPTY_CELL) {
            for (int number = 1; number <= MAX_VALID_SUDOKU_NUMBER; number++) {
              if (isOk(row, col, number)) {
              board[row][col] = number;

                if (solve()) { 
                  return true;
                } else { 
                  board[row][col] = VALUE_FOR_EMPTY_CELL;
                }
             }
            }
            return false; 
        }
       }
    }

         return true; // sudoku solved
    }
	
    public static void display() {
    for (int i = 0; i < MAX_VALID_SUDOKU_NUMBER; i++) {
    for (int j = 0; j < MAX_VALID_SUDOKU_NUMBER; j++) {
	System.out.print(" " + board[i][j]);
    }
	System.out.println();
    }
	System.out.println();
        }
	@Override
	public String toString() {
		return SodukuViewUtils.printToASCII(this);
	}
       
}
