public class Solution
{
	public int maxArea(int [] height)
	{
		if(height == null || height.length < 2)
			return 0;

		int l = 0;
		int r = height.length - 1;

		int max = 0;

		while(l < r)
		{
			max = Math.max(max, Math.min(height[l], height[r]) * (r - l));

			if(height[l] > height[r])
				r--;
			else
				l++;
		}

		return max;
	}
}