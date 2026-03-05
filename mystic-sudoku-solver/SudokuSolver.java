/* John Ruiz	
   Mystic Sudoku
   COP3503 Computer Science 2
   SudokuSolver.java
*/

public class SudokuSolver {
	
	//Holds the First Solution
	int firstSolution [][] = new int [9][9];
	
	//Saves Recursion Depth
	int depth = 0;
	
	//Saves The State if First Solution Has Been Recorded
	boolean hasBeenSaved = false;
	
	
	//Solve Method
	
	public int solve(int[][] board, int[][] forbiddenPairs)
	{
		depth++; //Entering Recursion
		int rowLength = board.length;
		int columnLength = board[0].length;
		int sum = 0;
		
		//Traverse Through Sudoku Board
		for (int row = 0; row < rowLength; row++)
		{
			for (int col = 0; col < columnLength; col++)
			{
				//Checks for Empty Cells
				if (board[row][col] == 0)
				{
					//Traverse through All Possible Digits
					for (int digit = 1; digit <= 9; digit ++)
					{
						if (isDigitValid(board, forbiddenPairs, digit, row, col)) //Checks if Digit is Valid
						{
							board[row][col] = digit; //Modifies Board With Digit
							sum += solve(board, forbiddenPairs); //Recursion
							board[row][col] = 0;  //Resets the Board
						}
					}
					
					depth --; //Leaving Recursion
					
					if (depth == 0 && sum == 1)
					{
						copyArray(firstSolution, board);
					}
					
					return sum; //Final Return of All Possible Solutions
				}
			}
		}
		
		//Solution is Found, Add 1 to Sum
		//Saves Solution
		
		if (!hasBeenSaved)
		{
			copyArray(board, firstSolution);
			hasBeenSaved = true;
		}
		
		depth --; //Leaving Recursion
		return 1;
	}
	
	
	//Saves Solution
	
	public void copyArray(int[][] board, int boardToCopy [][])
	{
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[0].length; j++)
			{
				boardToCopy[i][j] = board[i][j];
			}
		}
	}
	
	//Check if Digit is Valid
	
	public boolean isDigitValid (int[][] board, int[][] forbiddenPairs, int digit, int row, int col)
	{
		int rowLength = board.length;
		int columnLength = board[0].length;
		int cornerRow = row / 3;
		int cornerColumn = col / 3;
		
		//Traverses Through Column
		for (int i = 0; i < rowLength; i ++)
		{
			//Returns False if Digit is Already Present
			if (board[i][col] == digit)
			{
				return false;
			}
		}
		
		//Traverses Through Row
		for (int i = 0; i < columnLength; i ++)
		{
			//Returns False if Digit is Already Present
			if (board[row][i] == digit)
			{
				return false;
			}
		}
		
		//Goes Through 3 x 3
		for (int i = cornerRow * 3; i < (cornerRow * 3) + 3; i++)
		{
			for (int j = cornerColumn * 3; j < (cornerColumn * 3) + 3; j++)
			{
				//Returns False if Digit is Already Present
				if (board[i][j] == digit)
				{
					return false;
				}
			}
		}
		
		
		//Checks for All Possible Knight Moves
		//Returns False if Digit is Already Present
		
		if (knightCheck(board,  digit, row, col, 2, 1))
		{
			return false;
		}
		
		if (knightCheck(board,  digit, row, col, 2, -1))
		{
			return false;
		}
		
		if (knightCheck(board,  digit, row, col, -2, 1))
		{
			return false;
		}
		
		if (knightCheck(board,  digit, row, col, -2, -1))
		{
			return false;
		}
		
		if (knightCheck(board,  digit, row, col, 1, 2))
		{
			return false;
		}
		
		if (knightCheck(board,  digit, row, col, 1, -2))
		{
			return false;
		}
		
		if (knightCheck(board,  digit, row, col, -1, 2))
		{
			return false;
		}
		
		if (knightCheck(board,  digit, row, col, -1, -2))
		{
			return false;
		}
		
		//Traverse Through All Possible Pairs
		for (int i = 0; i < forbiddenPairs.length; i ++)
		{
			//Returns False if a Pair is Present
			if (forbiddenPairCheck(board, forbiddenPairs, digit, row, col, i))
			{
				return false;
			}
		}
		
		//The Digit Is Valid, Returns True
		return true;
	}
	
	
	//Checks Knight Moves Validity
	
	public boolean knightCheck (int [][] board, int digit, int row, int col, int knightRow, int knightColumn)
	{
		//Coordinates of a Knights Move
		int checkRow = row + knightRow;
		int checkColumn = col + knightColumn;
		
		//If Out of Bounds, add/subtract 9 accordingly
		if (checkRow < 0)
		{
			checkRow = checkRow + 9;
		}
		
		if (checkRow > 8)
		{
			checkRow = checkRow - 9;
		}
		
		if (checkColumn < 0)
		{
			checkColumn = checkColumn + 9;
		}
		
		if (checkColumn > 8)
		{
			checkColumn = checkColumn - 9;
		}
		
		//If Digit Is Present, Return True to Pass The Case
		//Otherwise, Return False
		return (digit == board[checkRow][checkColumn]);
	}
	
	
	//Checks for Forbidden Pairs
	
	public boolean forbiddenPairCheck (int [][] board, int[][] forbiddenPairs, int digit, int row, int col, int pairIndex)
	{
		//Coordinates of Cells to Check
		int up = row - 1;
		int down = row + 1;
		int left = col - 1;
		int right = col +1;
		
		//Fixes Out of Bound Coordinates
		if (up < 0)
		{
			up = up + 9;
		}
		
		if (down > 8)
		{
			down = down - 9;
		}
		
		if (left < 0)
		{
			left = left + 9;
		}
		
		if (right > 8)
		{
			right = right - 9;
		}
		
		//Checks to See if Digit is in the Pair
		if (digit == forbiddenPairs[pairIndex][0])
		{
			//Compares Cell Above it
			if (board[up][col] == forbiddenPairs[pairIndex][1])
			{
				//Return True if Digit Already Exists
				return true;
			}
			
			//Compares Cell Below It
			if (board[down][col] == forbiddenPairs[pairIndex][1])
			{
				//Return True if Digit Already Exists
				return true;
			}
			
			//Compares Cell Left Of it
			if (board[row][left] == forbiddenPairs[pairIndex][1])
			{
				//Return True if Digit Already Exists
				return true;
			}
			
			//Compares Cell Right Of it
			if (board[row][right] == forbiddenPairs[pairIndex][1])
			{
				//Return True if Digit Already Exists
				return true;
			}
		}
		
		//Checks to See if Digit is in the Pair
		if (digit == forbiddenPairs[pairIndex][1])
		{
			//Compares Cell Above it
			if (board[up][col] == forbiddenPairs[pairIndex][0])
			{
				//Return True to Pass the Case
				return true;
			}
			
			//Compares Cell Below It
			if (board[down][col] == forbiddenPairs[pairIndex][0])
			{
				//Return True to Pass the Case
				return true;
			}
			
			//Compares Cell Left Of it
			if (board[row][left] == forbiddenPairs[pairIndex][0])
			{
				//Return True to Pass the Case
				return true;
			}
			
			//Compares Cell Right Of it
			if (board[row][right] == forbiddenPairs[pairIndex][0])
			{
				//Return True to Pass the Case
				return true;
			}
		}
		
		//No Forbidden Pair is Found
		return false;
	}
}
