/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package map;

/**
 *
 * @author jaoles
 */

import exceptions.InproperTableIndexException;
import java.util.ArrayList;

import parser.Node;
import parser.Parser;
import parser.Track;
import postoj.*;

public class Map
{
    
    public Postoj [] map = null;  //mapa Przystankow i KamieniMilowych. Do ustalania trasy tramwai
    //public int [] [] numeracja = new int[2][]; //nie potrzebny, bo mamy w klasie Przystanek pole numer, ktory jest numerem Przystanku (nie postoju)
    public int ilPostojow = 0;
    public int ilPrzystankow = 0;
    public static Map mapInstance=null;
    public Map() throws Exception
    {
    	 if(Map.mapInstance==null){
         	Map.mapInstance=this;
         }
        ArrayList<Postoj> _map = new ArrayList<Postoj>();
        Parser p=new Parser("tram_lines.osm");
        for(Node n:p.nodeRegistry.values()){
        	if(n instanceof Przystanek){
        		_map.add((Przystanek) n);
        		((Przystanek) n).setNumer(_map.size()-1);
        	}
        }
        for(Track t:p.trackRegistry.values()){
        	double distance=0;
        	Przystanek current=t.getStartNode();
        	Przystanek next=current;
        	for(int i=t.startNode;i<=t.stopNode;i++){
        		
        		distance=OsmMercator.getDistance(current.lonlat[1], current.lonlat[0], t.nodes.get(i).lonlat[1], t.nodes.get(i).lonlat[0]);
        		if(t.nodes.get(i) instanceof Przystanek && distance>0){
        			//dodaj polacznia
        			//zeruj
        			next=(Przystanek) t.nodes.get(i);
        			current.AddOdnoga(next.getNumer(),60,distance);
        			distance=0;
        			current=next;
        		}
        	}
        }
        /*int n = 0; //0
        Przystanek bronowiceMale = new Przystanek(n, "Bronowice Male");
        bronowiceMale.AddOdnoga(n+1, 60, 500); //n=0  // 500m
        _map.add(bronowiceMale);
        n++; //1
        Przystanek balickaWiadukt = new Przystanek(n, "Balicka Wiadukt");
        balickaWiadukt.AddOdnoga(n+1, 60, 500); //n=1
        balickaWiadukt.AddOdnoga(n-1, 60, 500); //n=1
        _map.add(balickaWiadukt);
        n++; //2
        Przystanek wesele = new Przystanek(n, "Wesele");
        wesele.AddOdnoga(n+1, 60, 500); //n=2
        wesele.AddOdnoga(n-1, 60, 500); //n=2
        _map.add(wesele);
        n++; //3
        Przystanek bronowice = new Przystanek(n, "Bronowice");
        bronowice.AddOdnoga(n+1, 60, 500); //n=3
        bronowice.AddOdnoga(n-1, 60, 500); //n=3
        _map.add(bronowice);
        n++; //4
        Przystanek glowackiego = new Przystanek(n, "Glowackiego");
        glowackiego.AddOdnoga(n+1, 60, 500); //n=4
        glowackiego.AddOdnoga(n-1, 60, 500); //n=4
        _map.add(glowackiego);
        n++; //5
        Przystanek uniwersytetPedagogiczny = new Przystanek(n, "Uniwersytet Pedagogiczny");
        uniwersytetPedagogiczny.AddOdnoga(n+1, 60, 500); //5
        uniwersytetPedagogiczny.AddOdnoga(n-1, 60, 500); //5
        _map.add(uniwersytetPedagogiczny);
        n++; //6
        Przystanek biprostal = new Przystanek(n, "Biprostal");
        biprostal.AddOdnoga(n+1, 60, 500); //6
        biprostal.AddOdnoga(n-1, 60, 500); //6
        _map.add(biprostal);
        n++;
        Przystanek urzednicza = new Przystanek(n, "Urzednicza");
        urzednicza.AddOdnoga(n+1, 60, 500); //7
        urzednicza.AddOdnoga(n-1, 60, 500); //7
        _map.add(urzednicza);
        n++;
        Przystanek placInwalidow = new Przystanek(n, "Plac Inwalidow");
        placInwalidow.AddOdnoga(n+1, 60, 500); //8
        placInwalidow.AddOdnoga(n-1, 60, 500); //8
        _map.add(placInwalidow);
        n++;
        Przystanek batorego = new Przystanek(n, "Batorego");
        batorego.AddOdnoga(n+1, 60, 500); //9
        batorego.AddOdnoga(n-1, 60, 500); //9
        _map.add(batorego);
        n++;
        Przystanek teatrBagatela = new Przystanek(n, "Teatr Bagatela");
        teatrBagatela.AddOdnoga(n+1, 60, 500); //10
        teatrBagatela.AddOdnoga(n-1, 60, 500); //10
        _map.add(teatrBagatela);
        n++;
        Przystanek filharmonia = new Przystanek(n, "Filharmonia");
        filharmonia.AddOdnoga(n+1, 60, 500); //11
        filharmonia.AddOdnoga(n-1, 60, 500); //11
        _map.add(filharmonia);
        n++;
        Przystanek placWszystkichSwietych = new Przystanek(n, "Plac Wszystkich swietych");
        placWszystkichSwietych.AddOdnoga(n+1, 60, 500); //12
        placWszystkichSwietych.AddOdnoga(n-1, 60, 500); //12
        _map.add(placWszystkichSwietych);
        n++;
        Przystanek swGertrudy = new Przystanek(n, "Swietej Gertrudy");
        swGertrudy.AddOdnoga(n+1, 60, 500); //13
        swGertrudy.AddOdnoga(n-1, 60, 500); //13
        _map.add(swGertrudy);
        n++;
        Przystanek wawel = new Przystanek(n, "Wawel");
        wawel.AddOdnoga(n+1, 60, 500); //14
        wawel.AddOdnoga(n-1, 60, 500); //14
        _map.add(wawel);
        n++;
        Przystanek stradom = new Przystanek(n, "Stradom");
        stradom.AddOdnoga(n+1, 60, 500); //15
        stradom.AddOdnoga(n-1, 60, 500); //15
        _map.add(stradom);
        n++;
        Przystanek placWolnica = new Przystanek(n, "Plac Wolnica");
        placWolnica.AddOdnoga(n+1, 60, 500); //16
        placWolnica.AddOdnoga(n-1, 60, 500); //16
        _map.add(placWolnica);
        n++;
        Przystanek korona = new Przystanek(n, "Korona");
        korona.AddOdnoga(n+1, 60, 500); //17
        korona.AddOdnoga(n-1, 60, 500); //17
        _map.add(korona);
        n++;
        Przystanek smolki = new Przystanek(n, "Smolki");
        smolki.AddOdnoga(n+1, 60, 500); //18
        smolki.AddOdnoga(n-1, 60, 500); //18
        _map.add(smolki);
        n++;
        Przystanek rondoMatecznego = new Przystanek(n, "Rondo Matecznego");
        rondoMatecznego.AddOdnoga(n+1, 60, 500); //19
        rondoMatecznego.AddOdnoga(n-1, 60, 500); //19
        _map.add(rondoMatecznego);
        n++;
        Przystanek rzemieslnicza = new Przystanek(n, "Rzemieslnicza");
        rzemieslnicza.AddOdnoga(n+1, 60, 500); //20
        rzemieslnicza.AddOdnoga(n-1, 60, 500); //20
        _map.add(rzemieslnicza);
        n++;
        Przystanek lagiewniki = new Przystanek(n, "Lagiewniki");
        lagiewniki.AddOdnoga(n+1, 60, 500); //21
        lagiewniki.AddOdnoga(n-1, 60, 500); //21
        _map.add(lagiewniki);
        n++;
        Przystanek sanktuariumBozegoMilosierdzia = new Przystanek(n, "Sanktuarium Bozego Milosierdzia");
        sanktuariumBozegoMilosierdzia.AddOdnoga(n+1, 60, 500); //22
        sanktuariumBozegoMilosierdzia.AddOdnoga(n-1, 60, 500); //22
        _map.add(sanktuariumBozegoMilosierdzia);
        n++;
        Przystanek solvay = new Przystanek(n, "Solvay");
        solvay.AddOdnoga(n+1, 60, 500); //23
        solvay.AddOdnoga(n-1, 60, 500); //23
        _map.add(solvay);
        n++;
        Przystanek borekFalecki1 = new Przystanek(n, "Borek Falecki 1");
        borekFalecki1.AddOdnoga(n+1, 60, 500); //24
        borekFalecki1.AddOdnoga(n-1, 60, 500); //24
        _map.add(borekFalecki1);
        n++;
        Przystanek borekFalecki = new Przystanek(n, "Borek Falecki");
        borekFalecki.AddOdnoga(n-1, 60, 500); //25
        _map.add(borekFalecki);
        
        //do tego miejsca numery komorek sa zgodne z numerami Postojow i Przystankow
        //po tym numery Przystankow nie pokrywaja sie z numerami Przystankow
        //od tego momentu tez odleglosci odnog Przystankow sa odleglosciami od najblizszych Postojow (czyli wliczaja w to KamienieMilowe)
        //a nie tak jak wczesniej odleglosci Przystankow od najblizszych Przystankow
         * 
         */
        uzupelnijMapeOKamienieMilowe(_map);
        
        map = new Postoj [_map.size()];
        map=_map.toArray(map);
        
        this.ilPostojow = getIloscPostojow();
        this.ilPrzystankow = getIloscPrzystankow();
        System.out.println("Nodes:" +p.nodeRegistry.size());
		System.out.println("Ways:" +p.wayRegistry.size());
		System.out.println("Tracks:" +p.trackRegistry.size());
		System.out.println("Stops:" +p.tramStopCounter);
		for(Track t:p.trackRegistry.values()){
			System.out.println(t);
			for(Node n:t.nodes){
				if(n instanceof Przystanek)
					System.out.println(n.id+":"+((Przystanek)n).getNazwa());
			}
		}
		System.out.println("Przystanki po konwersji:"+getIloscPrzystankow());
   }
    
    public int getNumerPostoju(int _numer_przystanku)
    {
        int numer_postoju = -1;
        int temp_numer_postoju = -1;
        
        for(int i=0; i<ilPrzystankow; i++)
        {
            if(map[i] instanceof Przystanek)
            {
                if(map[i].getNumer() == _numer_przystanku)
                {
                    numer_postoju = i;
                    break;
                }
            }
        }
        
        return numer_postoju;
    }
    
    public Postoj getPostoj(int numer_postoju) //troche zbedna metoda
    {
        return map[numer_postoju];
    }
    
    public Przystanek getPrzystanek(int numer_przystanku)
    {
        Przystanek szukany = null;
        int current_numer_przystanku = 0;
        for(int i=0; i<ilPrzystankow; i++)
        {
            if(map[i] instanceof Przystanek)
            {
                if(current_numer_przystanku == numer_przystanku) 
                    { szukany = (Przystanek) map[i]; }
                current_numer_przystanku++;
            }
        }
        
        return szukany;
    }
    
    public int getIloscPostojow()
    {
        return map.length;
    }
    
    public int getIloscPrzystankow()
    {
        int count = 0;
        for(int i=0; i<this.getIloscPostojow(); i++)
        {
            if(map[i] instanceof Przystanek) count++;
        }
        
        return count;
    }
    
    
    //uzupelnia kamienie milowe tylko w jedna storne 0->1->2->...->25, a nie robi tego w druga strone
    public void uzupelnijMapeOKamienieMilowe(ArrayList<Postoj> _map) throws Exception
    {
        Postoj prev = null;
        Postoj current = null;
        Postoj next = null;
        double odleglosc = 0; //odleglosc miedzy Przystankami: current i next
        double max_speed = 0;
        
        //iteracja po calej mapie
        for(int i=0; i+1<_map.size(); i++)
        {
            if(i-1>0){ prev = current; }
            current = _map.get(i);
            next = _map.get(i+1);
            odleglosc = 0;
            //znajdywanie dwoch sasiadujacych przystankow
            if( (current instanceof Przystanek) && (next instanceof Przystanek) )
            {
                /*if(i-1>0)
                {
                    for(int l=0; l<current.getIlOdnog(); l++)
                    {
                        if( current.getOdnogi()[l] == prev.getNumer() ) 
                        {
                            current.setSingleOdlOdnog(l, _map.get(i-1).getSingleOdlOdnog(0)); 
                        }
                        
                    }
                }*/
                for(int j=0; j<current.getIlOdnog(); j++)
                {
                    if(current.getOdnogi()[j] == next.getNumer())
                    {
                        odleglosc = current.getOdlOdnog()[j];
                        max_speed = current.getMaxSpeed()[j];
                        //Ustawianie odleglosci od przystanku do nastepnego (mniejszy->wiekszy)
                        if(odleglosc > 30) current.setSingleOdlOdnog(j, 30);
                        break;
                    }
                }
            
                if(odleglosc > 30)
                {
                    while(odleglosc > 30) 
                    {
                        KamienMilowy nowy_kamien = new KamienMilowy();
                        nowy_kamien.setNumer(i+1);
                        nowy_kamien.addOdnoga(i+2, 30, max_speed);
                        nowy_kamien.addOdnoga(i, 30, max_speed);
                        _map.add(i+1, nowy_kamien);
                        odleglosc = odleglosc - 30;
                        if(odleglosc<=30) nowy_kamien.setSingleOdlOdnog(0, odleglosc);
                        i++;
                    }
                    if(odleglosc <= 30)
                    {
                        for(int k=0; k<next.getIlOdnog(); k++)
                        {
                            if(next.getOdnogi()[k] == current.getNumer())
                            {
                                next.setSingleOdlOdnog(k, odleglosc);
                            }
                        }
                    }//trzeba zmienic tez odleglosc dla next Przystanku
                }
            }
        }
    }
    
    public void wypiszMape() throws Exception
    {
        for(int i=0; i<map.length; i++)
        {
            System.out.println("map["+i+"]: "+map[i].PostojtoString());
        }
    }

}