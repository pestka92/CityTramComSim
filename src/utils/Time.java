/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.util.Arrays;

/**
 *
 * @author jaoles
 */
public class Time
{
    private int day = 1; //(0) dowolny dzien, (8)pon-pt, (9)??, (1)poniedzialek, (2)wtorek, (3)sroda, (4)czwartek, (5)piatek, (6)sobota, 7(niedziela)
    private int hour = 0; //godziny
    private int min = 0; //minuty
    
    public Time(int _day, int _hour, int _min)
    {
        setDay(_day);
        setHour(_hour);
        setMin(_min);
    }
    
    public Time(int [] _time) 
    {
        if(_time.length == 5)
        {
            setDay(_time[0]);
            setHour(10*_time[1]+_time[2]);
            setMin(10*_time[3]+_time[4]);
        }
    }
    
    public void setDay(int _day) { day = _day; }
    public void setHour(int _hour) { hour = _hour; }
    public void setMin(int _min) { min = _min; }
    
    public void setTime(int [] _time) 
    {
        if(_time.length == 5)
        {
            setDay(_time[4]);
            setHour(10*_time[3]+_time[2]);
            setMin(10*_time[1]+_time[0]);
        }
    }
    
    public int [] getTime() 
    {
        int [] _time = new int [5];
        _time[0] = day;
        _time[1] = hour/10;
        _time[2] = hour%10;
        _time[3] = min/10;
        _time[4] = min%10;
        return _time;
    }
    
    public static boolean compareTime(int [] _time1, int [] _time2) //time2 to wzor
    {
        //if(_time1[0] == 0) _time2[0] = 0;
        _time1[0]=0;//
        _time2[0]=0;//
        
        boolean areEqual = Arrays.equals(_time1, _time2);
        return areEqual;
    }
    
    public void incrementTime()
    {
        min++;
        if(min > 59)
        {
            min = 0;
            hour++;
        }
        if(hour > 23)
        {
            hour = 0;
            day++;
        }
        if(day > 7)
        {
            day = 1;
        }
    }
}
