public class Solution
{
	private static final char [] key = {'0', '1', '6', '8', '9'};
	private static final char [] val = {'0', '1', '9', '8', '6'};

	public List<String> findStrobogrammatic(int n)
	{
		List<String> result = new ArrayList<>();

		if(n < 1)
			return result;

		char [] t = new char [n];

		traversal(n, 0, t, result);

		return result;
	}

	private void traversal(int n, int idx, char [] t, List<String> result)
	{
		if(idx > n / 2 || idx == n / 2 && n % 2 == 0)
			result.add(new String(t));
		else
		{
			for(int i = 0;i < key.length;i++)
			{
				if(idx == 0 && key[i] == '0' && n > 1 || idx == n - 1 - idx && (key[i] == '6' || key[i] == '9'))
					continue;

				t[idx] = key[i];
				t[n - 1 - idx] = val[i];

				traversal(n, idx + 1, t, result);
			}
		}
	}
}