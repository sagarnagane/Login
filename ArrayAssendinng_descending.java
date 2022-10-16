package Array;

import java.util.Arrays;

public class ArrayAssendinng_descending
{
    public static void main(String[] args)
    {
    	/*int[] a=new int[5];//declaration
    	a[0]=45;           //initialization
    	a[1]=5;
    	a[2]=89;
    	a[3]=17;
    	a[4]=9;*/
    	
    	//int a[]={45,5,89,17,9};
    	
    	int a[]=new int[]{45,5,89,17,9};
    	
      System.out.println("original order");
      for(int i=0;i<a.length;i++)
      {
      System.out.println(a[i]);
      }
      
      Arrays.sort(a);
      System.out.println("ascending order");
      for(int i=0;i<a.length;i++)
      {
    	  System.out.println(a[i]);
      }
      
      System.out.println("descending order");
      for(int i=a.length-1;i>=0;i--)
      {
    	System.out.println(a[i]);
      }
      
    }
    
}