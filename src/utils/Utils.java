/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

/**
 *
 * @author jaoles
 */
public class Utils
{
    public static double [] appendDoubleArray(double [] array, double osobnik)
    {
        int old_length;
        if(array == null) old_length = 0;
        else old_length = array.length;
        
        double [] new_array = new double [old_length+1];
        for(int i=0; i<old_length; i++)
        {
            new_array[i] = array[i];
        }
        new_array[new_array.length-1] = osobnik;
        return new_array;
    }
    
    public static int [] appendIntArray(int [] array, int osobnik)
    {
        int old_length;
        if(array == null) old_length = 0;
        else old_length = array.length;
        
        int [] new_array = new int [old_length+1]; //do utils
        for(int i=0; i<old_length; i++)
        {
            new_array[i] = array[i];
        }
        new_array[new_array.length-1] = osobnik;
        return new_array;
    }
    
    public static int [] reverseIntArray(int [] array)
    {
        int [] new_array = new int [array.length];
        for(int i=0; i<array.length; i++)
        {
            new_array[i] = array[array.length-i-1];
            
        }
        return new_array;
    }
    
    public static int [] stringToIntArray(String _string)
    {
        int [] new_array = null;
        
        if (_string != null)
        {
            new_array = new int [_string.length()];
            //new_array[0] = Integer.parseInt(_string);
            
            char [] new_string = _string.toCharArray();
            
            for(int i=0; i<_string.length(); i++)
            {
                new_array[i] = new_string[i]-48;
            }
        }        
        return new_array;
    }
    public static void printIntArray(int [] array)
    {
        System.out.print("[");
        for(int i=0; i<array.length; i++)
        {
            System.out.print(array[i]);
        }
        System.out.print("]");
    }
    
    /*(public static int [] copyIntArray(int [] _array)
    {
        int [] newArray;
        int newArray_length = _array.length;
        newArray = new int[newArray_length];
        
        for(int i=0; i<_array.length; i++)
        {
            newArray[i] = _array[i];
        }
        
        return newArray;
    }*/
    
}
