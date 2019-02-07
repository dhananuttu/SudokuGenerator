
package com.HiQ.sudokugenerator;
import java.util.Random;

public class SudokuGenerator {
    private static final int NUM_CELLS = Sudoku.MAX_VALID_SUDOKU_NUMBER
			* Sudoku.MAX_VALID_SUDOKU_NUMBER;
    public static Sudoku generateRandomSudoku() {
    Integer[] array = Sudoku.SUDOKU_NUMBERS.toArray(new Integer[] {});
    _shuffleArray(array);
    Sudoku _sudoku = new Sudoku();
    for (int row = 0; row < Sudoku.SIZE_OF_EACH_SQUARE; row++) {
	populateRow(_sudoku.getMatrix(), row, array);
    }
    return _sudoku;
    }

    private static void populateRow(Integer[][] matrix, int row,Integer shuffledArray[]) {
		
    for (int j = 0; j < Sudoku.SIZE_OF_EACH_SQUARE; j++) {
			
        for (int i = 0; i < Sudoku.MAX_VALID_SUDOKU_NUMBER; i++) {
	int r = i / Sudoku.SIZE_OF_EACH_SQUARE
		+ (Sudoku.SIZE_OF_EACH_SQUARE * row);
	int columnOrder = Sudoku.SIZE_OF_EACH_SQUARE * j;
	int c = i % Sudoku.SIZE_OF_EACH_SQUARE + columnOrder;
	int k = (i + columnOrder) % Sudoku.MAX_VALID_SUDOKU_NUMBER + 1;
	k = shuffledArray[k - 1];
	if (row > 0) {
	int _rowUpperBandToBeCopied = r	- Sudoku.SIZE_OF_EACH_SQUARE * row;
	int _columnUpperBandToBeCopied = (c + row)
		% Sudoku.MAX_VALID_SUDOKU_NUMBER;
	k = matrix[_rowUpperBandToBeCopied][_columnUpperBandToBeCopied];
	}
	matrix[r][c] = k;
	}
    }
    }

    public static Sudoku generatePlayableRandomSudoku(Sudoku.SudokuLevel level) {
	Sudoku s = generateRandomSudoku();
	Integer n[] = new Integer[NUM_CELLS];
	for (int i = 0; i < NUM_CELLS; i++) {
	   n[i] = i;
	}
	_shuffleArray(n);
	for (int i = 0; i < NUM_CELLS-level.getValorizedCells(); i++) {
	int row_cols = n[i];
	int r = row_cols/4;
	int c = row_cols%4;
	s.getMatrix()[r][c] =0;
	}
	return s;
	}

    private static void _shuffleArray(Integer[] array) {
	int index, temp;
	Random random = new Random();
	for (int i = array.length - 1; i > 0; i--) {
	    index = random.nextInt(i + 1);
	    temp = array[index];
	    array[index] = array[i];
	    array[i] = temp;
	}
    }
}
