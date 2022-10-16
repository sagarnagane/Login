package Array;

import java.util.Arrays;

public class EvenOddNumber 
{
    public static void main(String args[])
    {
    	int a[]= {45,10,89,18,9};
    	Arrays.sort(a);
    	System.out.print("even numbers: ");
    	for(int i=0;i<a.length;i++)
    	{
    		if(a[i]%2==0)
    		{   
    			System.out.print(a[i]+",");
    		}
    		
    	}
    	System.out.println();
    	
    	System.out.print("odd numbers:");
    	for(int i=0;i<a.length;i++)
    	{
    		if(a[i]%2!=0)
    		{   
    			System.out.print(a[i]+",");
    		}
    		
    	}
    	
    }
}
