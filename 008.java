public class Solution
{
	private static final int MAX = Integer.MAX_VALUE / 10;

	public int myAtoi(String str)
	{
		if(str == null || str.length() == 0)
			return 0;

		int i = 0;
		int l = str.length();

		while(i < l && Character.isWhitespace(str.charAt(i)))	i++;

		int sign = 1;

		if(str.charAt(i) == '+')
			i++;
		else if(str.charAt(i) == '-')
		{
			sign = -1;
			i++;
		}

		int digits = 0;

		while(i < l && Character.isDigit(str.charAt(i)))
		{
			int digit = Character.getNumericValue(str.charAt(i));

			if(digits > MAX || digits == MAX && digit >= 8)
				return sign == 1 ? Integer.MAX_VALUE:Integer.MIN_VALUE;

			digits = digits * 10 + digit;

			i++;
		}

		return sign * digits;
	}
}