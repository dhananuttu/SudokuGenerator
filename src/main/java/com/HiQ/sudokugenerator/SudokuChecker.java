
package com.HiQ.sudokugenerator;

public class SudokuChecker {
    public static boolean checkSudokuSolution(int[][] grid, int subSquareSize)
  {
    final int size = grid.length;
    
    // First make sure all the values are in the right range.
    if (!checkValues(grid, 0, size))
    {
      return false;
    }
    
    // If we made it to this point, everything is correct!
    return true;
  }
  
  /**
   * Returns true if all values in grid are between min and max, inclusive.
   * 
   * @param grid
   *   the 2D array to check
   * @param min
   *   the smallest allowable value
   * @param max
   *   the largest allowable value
   * @return
   *   false if some value in the array is less than min or greater than max, true otherwise
   */
  private static boolean checkValues(int[][] grid, int min, int max)
  {
    for (int row = 0; row < grid.length; ++row)
    {
      for (int col = 0; col < grid[0].length; ++col)
      {
        if (grid[row][col] < min || grid[row][col] > max)
        {
          return false;
        }
      }
    }
    return true;
  }
  
  /**
   * Returns true if the row of grid denoted by whichRow
   * does not contain any duplicate values.
   * Preconditions:
   *   whichRow < number of columns in grid
   *   all values in grid are between 1 and grid.length, inclusive
   *   
   * @param grid
   *   the 2D array to check
   * @param whichRow
   *   the row to check
   * @return
   *   true if the row contains no duplicate values, false otherwise
   */
  private static boolean checkRow(int[][] grid, int whichRow)
  {
    final int size = grid.length;
    boolean[] found = new boolean[size];
    for (int col = 0; col < size; ++col)
    {
      // set found[x - 1] to be true if we find x in the row
      int index = grid[whichRow][col] - 1;
      if (!found[index])
      {
        found[index] = true;
      }
      else
      {
        // found it twice, so return false
        return false;
      }
    }
    
    // didn't find any number twice, so return true
    return true;
  }
  
  /**
   * Returns true if the column of grid denoted by whichCol
   * does not contain any duplicate values.
   * Preconditions:
   *   whichCol < number of columns in grid
   *   all values in grid are between 1 and grid.length, inclusive
   *   
   * @param grid
   *   the 2D array to check
   * @param whichCol
   *   the column to check
   * @return
   *   true if the column contains no duplicate values, false otherwise
   */
  private static boolean checkColumn(int[][] grid, int whichCol)
  {
    final int size = grid.length;
    boolean[] found = new boolean[size];
    for (int row = 0; row < size; ++row)
    {
      // set found[x - 1] to be true if we find x in the row
      int index = grid[row][whichCol] - 1;
      if (!found[index])
      {
        found[index] = true;
      }
      else
      {
        // found it twice, so return false
        return false;
      }
    }
    
    // didn't find any number twice, so return true
    return true;
  }
  
  /**
   * Checks whether a square subarray contains duplicate values.
   * Returns true if the subSquareSize x subSquareSize subarray of grid, 
   * with upper left corner at [baseRow, baseCol], does not contain 
   * any duplicate values.
   * Preconditions: 
   *   baseRow + subSquareSize <= number of columns in grid
   *   baseCol + subSquareSize <= number of rows in grid.
   *   all values in grid are between 1 and grid.length, inclusive
   *   
   * @param grid
   *   the 2D array to check
   * @param baseRow
   *   topmost row of the square
   * @param baseCol
   *   leftmost column of the square
   * @param subSquareSize
   *   the size of the subsquare to be checked
   * @return
   *   true if the square contains no duplicates, false otherwise
   */
  private static boolean checkSquare(int[][] grid, int baseRow, int baseCol, int subSquareSize)
  {
    boolean[] found = new boolean[grid.length];
    for (int row = baseRow; row < (baseRow + subSquareSize); ++row)
    {
      for (int col = baseCol; col < (baseCol + subSquareSize); ++col)
      {
        // set found[x - 1] to be true if we find x in the row
        int index = grid[row][col] - 1;
        if (!found[index])
        {
          found[index] = true;
        }
        else
        {
          // found it twice, so return false
          return false;
        }
      }
    }
    
    return true;
  }
}
