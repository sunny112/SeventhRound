public class Solution
{
	public int removeDuplicates(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return 0;

		int i = 1;
		int j = 0;

		while(i < nums.length)
		{
			if(nums[i] != nums[j])
				nums[++j] = nums[i];

			i++;
		}

		return ++j;
	}
}