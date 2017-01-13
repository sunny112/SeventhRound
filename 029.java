public class Solution
{
	public int divide(int dividend, int divisor)
	{
		if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;

		int result = 0;

		long pDividend = Math.abs((long)dividend);
		long pDivisor = Math.abs((long)divisor);

		while(pDividend >= pDivisor)
		{
			int shift = 0;

			while(pDividend >= (pDivisor << shift))
				shift++;

			result += 1 << (shift - 1);
			pDividend -= pDivisor << (shift - 1);
		}

		if(dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0)
			return -1 * result;

		return result;
	}
}