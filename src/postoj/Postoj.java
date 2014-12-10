/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package postoj;

/**
 *
 * @author jaoles
 */

import parser.Node;
import exceptions.*;

public class Postoj extends Node
{   
    
    private int numer = -1; //numer postoju (swiatla = -1, przystanki <0;niesk.+>)
    private String nazwa = null; //nazwa postoju (swiatla = "", przystanki = nazwa przystanku)
    private int il_odnog = 0; //ilosc odnog od tego przystanku
    private int [] odnogi = null;  //odnogi trasy (dla przystankow i swiatel)
    private double [] max_speed = null; //maksymalna predkosc osiagalna na odcinku drogi (usredniona) od tego postoju do nastepnego
    private double [] odl_odnog = null; //odleglosc od kolejnych postojow/odnog
    private int zajety = 0; // (0 dla wolnego, 1 dla zajetego przez tramwaj)
    
    public Postoj() {}
    
    /*
    public Przystanek(int _numer, String _nazwa)//przystanek
    {
        setNumer(_numer);
        setNazwa(_nazwa);
    }
    */
    /*
    KamienMilowy() {} //swiatla
    */
    /*
    Swiatla() {} //swiatla
    */
    
    public int getNumer() { return numer; }
    public void setNumer(int _numer) {}
    
    public String getNazwa() { return nazwa; }
    public void setNazwa(String _nazwa) {}
    
    public int getIlOdnog() { return il_odnog; }
    public void setIlOdnog(int _il_odnog) {}
    
    public int [] getOdnogi() { return odnogi; }
    public void setOdnogi(int [] _odnogi) { odnogi = _odnogi; }
    
    public void setMaxSpeed(double [] _max_speed) {}
    public double [] getMaxSpeed() { return max_speed; }
    
    public Postoj klonuj() { return this; }
    public int [] klonujOdnogi() { return odnogi; }
    
    public void setSingleMaxSpeed(int _index, double _max_speed) throws InproperTableIndexException {}
    public double getSingleMaxSpeed(int _index) throws InproperTableIndexException { return max_speed[_index]; }
    
    public void setOdlOdnog(double [] _odl_odnog) {}
    public double [] getOdlOdnog() { return odl_odnog.clone();}
    
    public void setSingleOdlOdnog(int _index, double _odl_odnogi) throws InproperTableIndexException {}
    public double getSingleOdlOdnog(int _index) throws InproperTableIndexException { return odl_odnog[_index]; }
    
    public void SetUp(int _il_odnog, Postoj [] _odnogi, double [] _odl_odnog, double [] _max_speed) {}
    
    public void AddOdnoga(int _odnoga, double _max_speed, double _odl_odnogi) throws InproperTableIndexException {}
    
    public void zwolnijPostoj() {}
    public void zajmijPostoj() {}
    
    public String PostojtoString() throws Exception
    {
        String buffor = null;
        if(this instanceof Przystanek)
        {
            buffor="Przystanek";
            buffor=buffor+" | Numer: "+this.getNumer();
            buffor=buffor+" | Odnogi["+this.getIlOdnog()+"]: [";
            for(int i=0; i<this.getIlOdnog(); i++)
            {
                buffor=buffor+this.getOdnogi()[i];
                if(i+1<this.getIlOdnog()) buffor=buffor+",";
            }
            buffor=buffor+"] | Odleglosci odnog: [";
            for(int i=0; i<this.getIlOdnog(); i++)
            {
                buffor=buffor+this.getOdlOdnog()[i];
                if(i+1<this.getIlOdnog()) buffor=buffor+",";
            }
            buffor=buffor+"]";
        }
        if(this instanceof KamienMilowy)
        {
            buffor="KamienMilowy";
            
            buffor=buffor+" | Numer: "+this.getNumer();
            buffor=buffor+" | Odnogi["+this.getIlOdnog()+"]: [";
            for(int i=0; i<this.getIlOdnog(); i++)
            {
                buffor=buffor+this.getOdnogi()[i];
                if(i+1<this.getIlOdnog()) buffor=buffor+",";
            }
            buffor=buffor+"] | Odleglosci odnog: [";
            for(int i=0; i<this.getIlOdnog(); i++)
            {
                buffor=buffor+this.getOdlOdnog()[i];
                if(i+1<this.getIlOdnog()) buffor=buffor+",";
            }
            buffor=buffor+"]";
        }
        
        return buffor;
    }
    
}
