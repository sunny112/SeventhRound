public class Solution
{
	public boolean isValidSudoku(char [][] board)
	{
		if(board == null || board.length != 9 || board[0].length != 9)
			return false;

		int r = board.length;
		int c = board[0].length;

		for(int i = 0;i < r;i++)
		{
			boolean [] exist = new boolean [9];

			for(int j = 0;j < c;j++)
			{
				if(board[i][j] != '.')
				{
					if(exist[board[i][j] - '1'])
						return false;

					exist[board[i][j] - '1'] = true;
				}
			}
		}

		for(int j = 0;j < c;j++)
		{
			boolean [] exist = new boolean [9];

			for(int i = 0;i < r;i++)
			{
				if(board[i][j] != '.')
				{
					if(exist[board[i][j] - '1'])
						return false;

					exist[board[i][j] - '1'] = true;
				}
			}
		}

		for(int block = 0;block < 9;block++)
		{
			boolean [] exist = new boolean [9];

			for(int i = block / 3 * 3;i < block / 3 * 3 + 3;i++)
			{
				for(int j = block % 3 * 3;j < block % 3 * 3 + 3;j++)
				{
					if(board[i][j] != '.')
					{
						if(exist[board[i][j] - '1'])
							return false;

						exist[board[i][j] - '1'] = true;
					}
				}
			}
		}

		return true;
	}
}