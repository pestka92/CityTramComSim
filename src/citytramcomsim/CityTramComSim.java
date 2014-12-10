/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citytramcomsim;

/**
 *
 * @author jaoles
 */
import exceptions.InproperTableIndexException;
import map.*;
import tram.Tram;
import utils.Time;
import utils.Utils;

public class CityTramComSim 
{
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {
        Map map = new Map();
        int dlugosc_mapy = map.ilPostojow;
        
        //Tram(numer, start_przystanek, (int[]) start_time)
        /*
        Tram t8 = new Tram(8, 0, utils.Utils.stringToIntArray("81208"));
        System.out.println("Ilosc przystankow dla tramwaju \"t8\": "+t8.getIlPrzystankow());
        Time present_time = new Time(utils.Utils.stringToIntArray("11207"));
        for(int i=0; i<46; i++)
        {
            System.out.print("Czas: ");
            Utils.printIntArray(present_time.getTime());
            System.out.println();
            
            t8.movesTram(present_time);
            present_time.incrementTime();
        }
        */
        
        //
        map.wypiszMape();
        //
    }
}
