/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rozklad;

import tram.Tram;
import utils.Time;
import utils.Utils;

/**
 *
 * @author jaoles
 */
public class Rozklad8
{
    public static void setRozklad8(Tram _tram, int _start_przystanek, int [] _start_time)
    {
        if(_start_time == null)
        {
            System.out.print("(int []) _start_time == null");
        }
        if( (_start_przystanek == 0) && (Time.compareTime(_start_time, Utils.stringToIntArray("81208"))) )
        {
            Time [] rozklad = _tram.getRozklad();
            
            //ustawianie przyjazdu danego tramwaju na numer_przystanku w terminie DHHMM
            //numer_przystanku to index Tram.rozklad, ktory odpowiada przystankowi Tram.route[numer_przystanku]
            //numer_przystanku NIE odpowiada map[numer_przystanku];
            //_tram.setSingleRozklad(numer_rozkladu, Utils.stringToIntArray("DHHMM"));
            //D-dzien(pon-nd(1-7), 0 dowolny, 8 pon-pt), HH-godzina, MM-minuta
            
            _tram.setSingleRozklad(0, Utils.stringToIntArray("81208")); //pon-pt 12:18
            _tram.setSingleRozklad(1, Utils.stringToIntArray("81209"));
            _tram.setSingleRozklad(2,Utils.stringToIntArray("81211"));
            _tram.setSingleRozklad(3,Utils.stringToIntArray("81212"));
            _tram.setSingleRozklad(4,Utils.stringToIntArray("81214"));
            _tram.setSingleRozklad(5,Utils.stringToIntArray("81215"));
            _tram.setSingleRozklad(6,Utils.stringToIntArray("81217"));
            _tram.setSingleRozklad(7,Utils.stringToIntArray("81218"));
            _tram.setSingleRozklad(8,Utils.stringToIntArray("81220"));
            _tram.setSingleRozklad(9,Utils.stringToIntArray("81221"));
            _tram.setSingleRozklad(10,Utils.stringToIntArray("81224"));
            _tram.setSingleRozklad(11,Utils.stringToIntArray("81227"));
            _tram.setSingleRozklad(12,Utils.stringToIntArray("81228"));
            _tram.setSingleRozklad(13,Utils.stringToIntArray("81230"));
            _tram.setSingleRozklad(14,Utils.stringToIntArray("81231"));
            _tram.setSingleRozklad(15,Utils.stringToIntArray("81233"));
            _tram.setSingleRozklad(16,Utils.stringToIntArray("81235"));
            _tram.setSingleRozklad(17,Utils.stringToIntArray("81237"));
            _tram.setSingleRozklad(18,Utils.stringToIntArray("81239"));
            _tram.setSingleRozklad(19,Utils.stringToIntArray("81242"));
            _tram.setSingleRozklad(20,Utils.stringToIntArray("81243"));
            _tram.setSingleRozklad(21,Utils.stringToIntArray("81245"));
            _tram.setSingleRozklad(22,Utils.stringToIntArray("81247"));
            _tram.setSingleRozklad(23,Utils.stringToIntArray("81249"));
            _tram.setSingleRozklad(24,Utils.stringToIntArray("81250"));
            _tram.setSingleRozklad(25,Utils.stringToIntArray("81251"));
        }
    }
    
}
