package abc.sound;

/*
 * Class to help find the lowest common multiple and greatest common denominator of two or more numbers.
 */
public class LCM {

/**
 * Find greatest common denominator of two numbers
 * @param a a is not zero
 * @param b b is not zero
 * @return the greatest common denominator of a and b
 */
public static int gcd(int a, int b)
{
    while (b > 0)
    {
        int temp = b;
        b = a % b; // % is remainder
        a = temp;
    }
    return a;
}

/**
 * Find the lowest common multiple of a and b
 * @param a a is not zero
 * @param b b is not zero
 * @return the lowest common multiple of a and b
 */
public static int lcm(int a, int b)
{
    return a * (b / gcd(a, b));
}

/**
 * Find the lowest common multiple of all the numbers in input
 * @param input length > 2, all numbers in input are not zero
 * @return the lowest common multiple of all numbers in input
 */
public static int lcm(int[] input)
{
    int result = input[0];
    for(int i = 1; i < input.length; i++) result = lcm(result, input[i]);
    return result;
}
}