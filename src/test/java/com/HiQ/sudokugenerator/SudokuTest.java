/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HiQ.sudokugenerator;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Sudoku.class})
public class SudokuTest {
    
    public SudokuTest() {
    }
   private Sudoku checker;
    private int[][] sudoku = {
			{0,0,3,2},
			{0,2,0,1},
			{1,0,2,0},
			{0,3,0,0},
	};
	 
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
	 public void setUp() {
           checker = new Sudoku();
           PowerMockito.mockStatic(Sudoku.class);
            //check.setMatrix(sudoku);
            PowerMockito.when(Sudoku.isInRow(3, 1)).thenReturn(Boolean.TRUE);
            PowerMockito.when(Sudoku.isInCol(3, 2)).thenReturn(Boolean.TRUE);
            PowerMockito.when(Sudoku.solve()).thenReturn(Boolean.TRUE);
	}
    
    @After
    public void tearDown() {
    }

//    @Test
//    public void testisValid() {
//     
//       assertTrue(checker.isValid());
//    }
   
   
    
}
