public class Solution
{
	public int minCut(String s)
	{
		if(s == null || s.length() == 0)
			return 0;

		boolean [][] dp = new boolean [s.length()][s.length()];
		int [] cut = new int [s.length()];

		for(int r = 0; r < s.length();r++)
		{
			cut[r] = r;

			for(int l = 0;l <= r;l++)
			{
				if(s.charAt(l) == s.charAt(r) && (r - l <= 1 || dp[l + 1][r - 1]))
				{
					dp[l][r] = true;

					if(l != 0)
						cut[r] = Math.min(cut[r], cut[l - 1] + 1);
					else
						cut[r] = 0;
				}
			}
		}

		return cut[s.length() - 1];
	}
}