public class Solution
{
	public int maximalSquare(char [][] matrix)
	{
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int r = matrix.length;
		int c = matrix[0].length;

		int [][] dp = new int [r][c];

		for(int i = 0;i < r;i++)
			if(matrix[i][0] == '1')
				dp[i][0] = 1;

		for(int j = 0;j < c;j++)
			if(matrix[0][j] == '1') 
				dp[0][j] = 1;

		for(int i = 1;i < r;i++)
			for(int j = 1;j < c;j++)
				if(matrix[i][j] == '1')
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;

		int max = 0;

		for(int i = 0;i < r;i++)
			for(int j = 0;j < c;j++)
				max = Math.max(max, dp[i][j]);

		return max * max;
	}
}