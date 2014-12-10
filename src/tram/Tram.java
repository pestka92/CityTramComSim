/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tram;

import static rozklad.Rozklad8.setRozklad8;
import utils.Time;

/**
 *
 * @author jaoles
 */
public class Tram
{
    private int numer = 0; //numer tramwaju
    private int [] route = null; //trasa tramwaju - numery przystankow, odpowiadaja numerom komorek objektu map
    private Time [] rozklad = null; //rozklad czasowy - o ktorych porach ma sie pojawic na ktorym przystanku
    private int il_przystankow = 0; //ilosc przystankow
    
    private Time start_time;
    private Time finish_time;
    
    private int start_przystanek = -1;
    private int finish_przystanek = -1;
    
    private int current_stop = -1; //obecny przystanek - numer komorki (route,rozklad) w ktorej znajduje sie (numer przystanku, czas przyjazdu na przystanek)
    private int current_index = -1; //obecny index (do route, rozklad itp)
    private double max_accel = 0.001; //km/s^2 maksymalne przyspieszenie
        
    public Tram(int _numer, int _start_przystanek, int [] _start_time)
    {
        setRoute(_numer, _start_przystanek); //il_przystankow, route, start_przystanek, finish_przystanek
        setRozklad(_numer, _start_przystanek, _start_time); //rozklad, stat_time, finish_time
    }
    
    public void setIlPrzystankow(int _il_przystankow) { il_przystankow=_il_przystankow; }
    public int getIlPrzystankow() { return il_przystankow; }
    
    public void setStartPrzystanek(int _start_przystanek) { start_przystanek = _start_przystanek; }
    public int getStartPrzystanek() { return start_przystanek; }
    public void setFinishPrzystanek(int _finish_przystanek) { finish_przystanek = _finish_przystanek; }
    public int getFinishPrzystanek() { return finish_przystanek; }
    
    public void setStartTime(Time _start_time) { start_time = _start_time; }
    public void setStartTime(int [] _start_time) { start_time = new Time(_start_time); }
    public Time getStartTime() { return start_time; }
    public void setFinishTime(Time _finish_time) { finish_time = _finish_time; }
    public void setFinishTime(int [] _finish_time) { finish_time = new Time(_finish_time); }
    public Time getFinishTime() { return finish_time; }
    
    //przed setRozklad musi pojawic sie setRoute
    public void setRozklad(int _numer, int _start_przystanek, int [] _start_time)
    {
        switch(_numer)
        {
            case 8:
                rozklad = new Time [il_przystankow];
                setRozklad8(this, _start_przystanek, _start_time); //import static rozklad.Rozklad8.setRozklad8;
                setStartTime(rozklad[0]);
                setFinishTime(rozklad[il_przystankow-1]);
                break;
            default:
                break;
        }       
    }
    public Time [] getRozklad() { return rozklad; }
    public void setSingleRozklad(int _index, int [] _time)
    {
        if(_index < il_przystankow && _index >= 0)
        {
            rozklad[_index] = new Time(_time);
        }
        else System.out.print("BLAD! za daleko z tym rozkladem wchodzisz");
    }
    public Time getSingleRozklad(int _index)
    {
        Time single_rozklad = rozklad[_index];
        return single_rozklad;
    }
    
    public void setRoute(int _numer, int _start_przystanek)
    {
        setStartPrzystanek(_start_przystanek);
        switch(_numer)
        {
            case 8:
                int [] _route8 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
                route = _route8;
                setIlPrzystankow(26);
                if (start_przystanek==(il_przystankow-1)) reverseRoute();
                finish_przystanek = route[il_przystankow-1];
                break;
            default:
                route = null;
                break;
        }
    }
    public void setRoute(int [] _route) { route = _route; }
    public int [] getRoute() { return route; }
    
    public void setCurrentStop(int _current_stop) { current_stop = _current_stop; }
    public int getCurrentStop() 
    {
        if(route == null) return -1;
        return route[current_stop]; 
    }
    
    public double getMaxAccel() { return max_accel; }
    
    public void reverseRoute() { utils.Utils.reverseIntArray(route); }
    
    public void firstMoveTram(Time present_time)
    {
        if( (current_stop == -1) && (Time.compareTime(present_time.getTime(), getStartTime().getTime())) )
        {            
            current_stop = getStartPrzystanek();
            current_index = 0;
            
            System.out.println("W firstMoveTram");  //
            System.out.println("current_stop: "+current_stop);
            System.out.println("current_index: "+current_index);
            System.out.println();
            
        }
    }
    
    public void moveTram(Time present_time) //brak porownywania czasu
    {
        if( (current_stop > -1) && (current_stop < finish_przystanek-1) )
        {
            current_index++;
            
            int [] czas_dojazdu = getSingleRozklad(current_index).getTime();
            
            if(Time.compareTime(present_time.getTime(), getSingleRozklad(current_index).getTime()))
            {
                current_stop = getRoute()[current_index];
                
                System.out.println("W moveTram");
                System.out.println("current_stop: "+current_stop);
                System.out.println("current_index: "+current_index);
                System.out.println();
                current_index++;
            }
            current_index--;
        }
    }
    
    public void finishMoveTram(Time present_time) //brak porownywania czasu
    {
        if( current_index == (il_przystankow-2) )
        {
            current_index++;
            if(Time.compareTime(present_time.getTime(), getSingleRozklad(current_index).getTime()))
            {
                current_stop = getRoute()[current_index];
                System.out.println("W finishMoveTram");
                System.out.println("DOJECHALIMY!");
                current_index++;
            }
            current_index--;
        }
    }
    
    public void movesTram(Time present_time)
    {
        if(current_index == -1)
        {
            firstMoveTram(present_time);
        }
        if( (current_index > -1) && (current_index < (il_przystankow-1)) )
        {
            moveTram(present_time);
        }
        if( current_index == (il_przystankow-2) )
        {
            finishMoveTram(present_time);
        }
    }
    
}
