/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postoj;

import exceptions.*;

/**
 *
 * @author jaoles
 */
public class KamienMilowy extends Postoj
{
    private int zajety = 0; //numer kamienia milowego odpowiada komorce w ktorej jest w mapie
    private int numer = -1; //musi byc nummer kamienia milowego i lista odnog(przednia i tylnia odnoga)
    private int il_odnog = 0;
    private int [] odnogi = null;
    private double [] max_speed = null; //maksymalna predkosc osiagalna na odcinku drogi (usredniona) od tego postoju do nastepnego
    private double [] odl_odnog = null; //odleglosc od kolejnych postojow/odnog
    
    public KamienMilowy() 
    { 
        super();
        zajety = 0;
        numer = -1;
        il_odnog = 0;
        odnogi = null;
        max_speed = null;
        odl_odnog = null;
    }
    
    public KamienMilowy(double _odleglosc, double _max_speed)
    {
        super();
        il_odnog = 1;
        odnogi = new int[1];
        odl_odnog = new double[1];
        max_speed = new double[1];
        setSingleOdlOdnogi(_odleglosc);
        setSingleMaxSpeed(0, _max_speed);
    }
    
    public KamienMilowy(int _numer, double [] _odleglosc, double [] _max_speed)
    {
        super();
        il_odnog = 2;
        odnogi = new int[2];
        odl_odnog = new double[2];
        max_speed = new double[2];
        setSingleOdlOdnog(0, _odleglosc[0]);
        setSingleOdlOdnog(1, _odleglosc[1]);
        setSingleMaxSpeed(0, _max_speed[0]);
        setSingleMaxSpeed(1, _max_speed[1]);
    }
    
    @Override
    public void setNumer(int _numer) { numer = _numer; }
    @Override
    public int getNumer() { return numer; }
    
    @Override
    public void setIlOdnog(int _il_odnog) { il_odnog = _il_odnog; }
    @Override
    public int getIlOdnog() { return il_odnog; }
    
    @Override
    public void setOdnogi(int [] _odnogi) { odnogi = _odnogi; }
    @Override
    public int [] getOdnogi() { return odnogi; }
    
    @Override
    public void setMaxSpeed(double [] _max_speed) { max_speed = _max_speed; }
    @Override
    public double [] getMaxSpeed() { return max_speed; }
    @Override
    public void setSingleMaxSpeed(int _index, double _max_speed) { max_speed[_index] = _max_speed; }
    @Override
    public double getSingleMaxSpeed(int _index) { return max_speed[_index]; }
    
    @Override
    public void setOdlOdnog(double [] _odl_odnog) { odl_odnog = _odl_odnog; }
    @Override
    public double [] getOdlOdnog() { return odl_odnog; }
    @Override
    public void setSingleOdlOdnog(int _index, double _odl_odnog) { odl_odnog[_index] = _odl_odnog; }
    @Override
    public double getSingleOdlOdnog(int _index) { return odl_odnog[_index]; }
    public void setSingleOdlOdnogi(double _odl_odnog) { odl_odnog[0] = _odl_odnog; }
    public double getSingleOdlOdnogi() { return odl_odnog[0]; }
    
    public void addOdnoga(int _numer, double _odleglosc, double _max_speed) throws Exception
    {
        if(il_odnog==0) 
        {
            il_odnog++;
            odnogi = new int[1];
            odl_odnog = new double[1];
            max_speed = new double[1];
            odnogi[0] = _numer;
            odl_odnog[0] = _odleglosc;
            max_speed[0] = _max_speed;
        }
        else
        {
            if(il_odnog==1)
            {
                il_odnog++;
                int [] old_odnogi = odnogi;
                double [] old_odl_odnog = odl_odnog;
                double [] old_max_speed = max_speed;
                odnogi = new int[2];
                odl_odnog = new double[2];
                max_speed = new double[2];
                odnogi[0] = old_odnogi[0];
                odl_odnog[0] = old_odl_odnog[0];
                max_speed[0] = old_max_speed[0];
                odnogi[1] = _numer;
                odl_odnog[1] = _odleglosc;
                max_speed[1] = _max_speed;
            }
            else
            {
                if(il_odnog==2) throw new KamienMilowyZaDuzoOdnogException();
            }
        }
    }
    
    @Override
    public void zwolnijPostoj() { zajety = 0; }
    @Override
    public void zajmijPostoj() { zajety = 1; }
}
