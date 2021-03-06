/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HiQ.sudokugenerator;

/**
 *
 * @author Chandru
 */
public class SodukuViewUtils {
    public static String printToASCII(Sudoku s) {
		return printMatrix(s.getMatrix());
	}

	public static String printToASCII(Integer[][] matrix) {
		return printMatrix(matrix);
	}

	private static String printMatrix(Integer[][] matrix) {
		StringBuilder sb = new StringBuilder();
		sb.append(printLine());
		for (int i = 0; i < Sudoku.MAX_VALID_SUDOKU_NUMBER; i++) {
			for (int j = 0; j < Sudoku.MAX_VALID_SUDOKU_NUMBER; j++) {
				sb.append(" ");

				Integer obj = matrix[i][j];
				if (obj > 0) {

					sb.append(obj);
				} else {
					sb.append(" ");

				}
				sb.append(" ");
				if (j != Sudoku.MAX_VALID_SUDOKU_NUMBER - 1
						&& (j != 4 && j != 8)) {
					sb.append("|");
				}
				if ((j + 1) % 8 == 0) {
					sb.append(" ");
				}
			}

			sb.append("\n");
			if (i == 4|| i == 8) {
				sb.append("\n");
				
			}
			
		}
		sb.append(printLine());
		return sb.toString();
	}
	
	private static String printLine(){
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0;i<Sudoku.MAX_VALID_SUDOKU_NUMBER*(2 +Sudoku.SIZE_OF_EACH_SQUARE)-2 ;i++){
			 sb.append("-");
		}
		sb.append("\n");
		return sb.toString();
	}

    
}
