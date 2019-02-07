/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HiQ.sudokugenerator;

import com.HiQ.sudokugenerator.Sudoku.SudokuLevel;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class SudokuGeneratorTest {
    @Parameterized.Parameters
	public static List<Object[]> data() {
		return Arrays.asList(new Object[1000][0]);
	}
    
    public SudokuGeneratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of generateRandomSudoku method, of class SudokuGenerator.
     */
   
	

	@Test
	public void testGenerateAndValidateValidSudoku() {
		// Generate a large number of sudoku and checks if each one is valid
		Sudoku s = SudokuGenerator.generateRandomSudoku();
		assertTrue(s.isValid());
		
	}
	@Test
	public void testGenerateaPlaybleEasySudoku() {
		// Generate a large number of sudoku and checks if each one is valid
		Sudoku s = SudokuGenerator.generatePlayableRandomSudoku(SudokuLevel.EASY);
		System.out.println(s);
		assertTrue(s.isValid());
		
	}
	
	@Test
	public void testGenerateaPlaybleMediumSudoku() {
		// Generate a large number of sudoku and checks if each one is valid
		Sudoku s = SudokuGenerator.generatePlayableRandomSudoku(SudokuLevel.MEDIUM);
		System.out.println(s);
		assertTrue(s.isValid());
		
	}
	@Test
	public void testGenerateaPlaybleHardSudoku() {
		// Generate a large number of sudoku and checks if each one is valid
		Sudoku s = SudokuGenerator.generatePlayableRandomSudoku(SudokuLevel.DIFFICULT);
		System.out.println(s);
		assertTrue(s.isValid());
		
	}

	@Test
	public void testGenerateAndInValidateValidSudoku() {

		// Generate a large number of sudoku and checks if they are still valid
		Sudoku s = SudokuGenerator.generateRandomSudoku();
		// System.out.println(SudokuViewUtils.printToASCII(s));
		int randomRow = new Random().nextInt(4);
		int randomCol = new Random().nextInt(4);

		int value = s.getMatrix()[randomRow][randomCol];
		int newValue = 1 + (value) % 3;
		if (!Sudoku.isValidSudokuNumber(newValue)) {
			throw new IllegalArgumentException("Value " + newValue
					+ " is not valid");
		}
		s.getMatrix()[randomRow][randomCol] = newValue;
		assertFalse(s.isValid());

	}

    
}
