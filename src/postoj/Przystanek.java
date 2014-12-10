/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package postoj;

import exceptions.InproperTableIndexException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static utils.Utils.*;

/**
 *
 * @author jaoles
 */
public class Przystanek extends Postoj
{
    private  int numer = -1; //numer Przystanku (swiatla = 0, przystanki <1;niesk.+>)
    private String nazwa = null; //nazwa postoju (swiatla = "", przystanki = nazwa przystanku)
    private int il_odnog = 0; //ilosc odnog od tego przystanku
    private int [] odnogi = null;  //odnogi trasy (dla przystankow i swiatel)
    private double [] max_speed = null; //maksymalna predkosc osiagalna na odcinku drogi (usredniona) od tego postoju do nastepnego
    private double [] odl_odnog = null; //odleglosc od kolejnych postojow/odnog
    private int zajety = 0; 
    
    public Przystanek() { super(); }
    public Przystanek(int _numer, String _nazwa)//przystanek
    {
        super();
        setNumer(_numer);
        setNazwa(_nazwa);
    }
    
    public void setNumer(int _numer) { numer = _numer; }
    public int getNumer() { return numer; }
    
    public void setNazwa(String _nazwa) { nazwa = _nazwa; }
    public String getNazwa() { return nazwa; }
    
    public void setIlOdnog(int _il_odnog) { il_odnog = _il_odnog; }
    public int getIlOdnog() { return il_odnog; }
    
    public void setOdnogi(int [] _odnogi) { odnogi = _odnogi; }
    public int [] getOdnogi() { return odnogi; }
    
    public void setMaxSpeed(double [] _max_speed) { max_speed = _max_speed; }
    public double [] getMaxSpeed() { return max_speed; }
    
    public void setSingleMaxSpeed(int _index, double _max_speed) throws InproperTableIndexException
    {
        int i = 0;
        if(_index < getIlOdnog())
        while( (i < getIlOdnog()) && (_index <= i  ) )
        {
            if(i == _index) max_speed[i] = _max_speed;
            i++;
        }
        else throw new InproperTableIndexException();
    }
    
    public double getSingleMaxSpeed(int _index) throws InproperTableIndexException
    {
        double _max_speed = -1;
        
        int i = 0;
        if(_index < getIlOdnog())
        while( (i < getIlOdnog()) && (_index <= i  ) )
        {
            if(i == _index) _max_speed = max_speed[i];
            i++;
        }
        else throw new InproperTableIndexException();
        
        return _max_speed;
    }
    
    public void setOdlOdnog(double [] _odl_odnog) { odl_odnog = _odl_odnog; }
    public double [] getOdlOdnog() { return odl_odnog; }
    
    public void setSingleOdlOdnog(int _index, double _odl_odnogi) throws InproperTableIndexException
    {
        if( (_index < 0) || (_index >= getIlOdnog()) ) throw new InproperTableIndexException();
        else odl_odnog[_index] = _odl_odnogi;
    }
    
    public double getSingleOdlOdnog(int _index) throws InproperTableIndexException
    {
        double _odl_odnogi = -1;
        if( (_index < 0) || (_index >= getIlOdnog()) ) throw new InproperTableIndexException();
        else _odl_odnogi = odl_odnog[_index];
        return _odl_odnogi;
    }
    
    public Przystanek klonuj()
    {
        Przystanek _klon = null;
        
        _klon = new Przystanek();
        _klon.setNumer(getNumer());
        _klon.setNazwa(getNazwa());
        _klon.setIlOdnog(getIlOdnog());
        _klon.setOdnogi(getOdnogi());
        _klon.setMaxSpeed(getMaxSpeed());
        _klon.setOdlOdnog(getOdlOdnog());
        
        return _klon;
    }
    
    public void SetUp(int _il_odnog, int [] _odnogi, double [] _max_speed, double [] _odl_odnog)
    {
        setIlOdnog(_il_odnog);
        setOdnogi(_odnogi);
        setMaxSpeed(_max_speed);
        setOdlOdnog(_odl_odnog);
    }
    
    @Override
    public void AddOdnoga(int _odnoga, double _max_speed, double _odl_odnogi) throws InproperTableIndexException
    {
        //IlOdnog //new_il_odnog
        int new_il_odnog = getIlOdnog() +1;
        //Odnogi //new_odnogi
        int [] new_odnogi = utils.Utils.appendIntArray(getOdnogi(), _odnoga);
        //MaxSpeed //new_max_speed;
        double [] new_max_speed = utils.Utils.appendDoubleArray(getMaxSpeed(), _max_speed);
        //OdlOdnog
        double [] new_odl_odnog = utils.Utils.appendDoubleArray(getOdlOdnog(), _odl_odnogi);
        
        SetUp(new_il_odnog, new_odnogi, new_max_speed, new_odl_odnog);
        
    }
    
    @Override
    public void zwolnijPostoj() { zajety = 0; }
    @Override
    public void zajmijPostoj() { zajety = 1; }
    
}