package com.junit;

public class Calculator {
	
	public int addition(int a, int b)
	{
		return a+b;
	}
	
	public int additionWithPositiveValue(int a, int b)
	{
		return a+b;
	}
	
	public int additionWithNegativeValue(int a, int b)
	{
		return a+b;
	}
	
	
	public int substraction(int a, int b)
	{
		return a-b;
	}
	
	public int division(int a, int b) {
		
		return a/b;
	}
	
	public int multiplication(int a, int b)
	{
		return a*b;
	}
	
	  
    public int factorial(int n) 
    {
    	if (n == 0)
    		return 1;
    	int num = n;
    	for (int i = n-1; i > 1; i--)
    		n *= i;
    	return n;
    	}
	
	public int maxValue(int[] arr) 
	{
	    if (arr.length == 0)
		    return Integer.MAX_VALUE;
	    int max = arr[0];
	    for (int i = 1; i < arr.length; i++) 
	    {
	    	if (arr[i] > max)
	    		max = arr[i];
	    	}
	    return max;
	    }
	}
