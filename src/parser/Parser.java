package parser;

import org.w3c.dom.Document;
	import org.w3c.dom.Element;
	import org.w3c.dom.NodeList;
	//import sim.app.agenty.TDSSimState;
	//import sim.engine.Steppable;
	//import sim.util.Double2D;
	//import sim.util.MutableDouble2D;

	import javax.xml.parsers.DocumentBuilder;
	import javax.xml.parsers.DocumentBuilderFactory;
	import java.io.File;
	import java.util.HashMap;
import java.util.LinkedHashMap;
public class Parser {
	//package map;



	/**
	 * Created by GT on 2014-11-14.
	 */
	    /* ----------- OSM ---------*/
	    //@todo: wczytywanie z pliku
	    public static double minLat=0;//map to yMin
	    public static double maxLat=0;//map to yMax
	    public static double minLon=0;//map to xMin
	    public static double maxLon=0;//map to xMax

	    public static double areaRatio=-1;
	    /* ----- end of OSM --------*/

	    /* grid constants */
	    public static final double gridSize=1.0;//1x1 grid fragment = gridSize x gridSize real
	    /* -------------- */

	    /* mapInfo */
	    public double heightM=0;
	    public double widthM=0;
	    /* ------*/
	    public HashMap<Long,Node> nodeRegistry;
	    public LinkedHashMap<Long,Way> wayRegistry;
	    public LinkedHashMap<Long,Track> trackRegistry;
	    public int tramStopCounter=0;
	    public Parser(String filename){
	        nodeRegistry=new HashMap<Long, Node>();
	        wayRegistry=new LinkedHashMap<Long, Way>();
	        trackRegistry=new LinkedHashMap<Long, Track>();
	        try {
	            File fXmlFile = new File(filename);
	            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	            Document doc = dBuilder.parse(fXmlFile);
	            doc.getDocumentElement().normalize();
	            NodeList nList;
	            /* ----------------- load area info ---------------------- */
	            /*nList = doc.getElementsByTagName("bounds");
	            if(nList.getLength()>0)
	            {
	                org.w3c.dom.Node nNode = nList.item(0);
	                if (nNode.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE){
	                    Element el=(Element) nNode;
	                    minLon=Double.valueOf(el.getAttribute("minlon"));
	                    maxLon=Double.valueOf(el.getAttribute("maxlon"));
	                    minLat=Double.valueOf(el.getAttribute("minlat"));
	                    maxLat=Double.valueOf(el.getAttribute("maxlat"));
	                    heightM=Haversine.haversine(minLat,minLon,maxLat,minLon)*1000/gridSize;
	                    widthM=Haversine.haversine(minLat,minLon,minLat,maxLon)*1000/gridSize;
	                    areaRatio=widthM/heightM;
	                    System.out.println("AreaInfo:"+widthM+","+heightM+","+areaRatio);
	                }
	            }
	            else
	                throw new Exception("OSM bounds missing!");
	            */
	            /* ----------------- load OSM nodes --------------------- */
	            nList = doc.getElementsByTagName("node");
	            for (int i = 0; i < nList.getLength(); i++) {
	                org.w3c.dom.Node nNode = nList.item(i);
	                if (nNode.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
	                    Element el=(Element) nNode;
	                    Long nid=Long.valueOf(el.getAttribute("id"));
	                    Node newNode=NodeFactory.factory(el, this);
	                    if(newNode != null)
	                        nodeRegistry.put(nid,newNode);
	                    //track reactive nodes on main field - crossings & traffic lights
	                    /*if(newNode instanceof ITrafficLight||newNode instanceof ICrossing) {
	                        state.fieldEnvironment.setObjectLocation(newNode, new Double2D(newNode.loc));
	                        if(newNode instanceof Steppable)
	                            state.schedule.scheduleRepeating((Steppable)newNode);
	                    }*/
	                }
	            }
	            /* ----------------- load OSM ways --------------------- */
	            nList = doc.getElementsByTagName("way");
	            for (int i = 0; i < nList.getLength(); i++) {
	                org.w3c.dom.Node nNode = nList.item(i);
	                if (nNode.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
	                    Element el=(Element) nNode;
	                    Long nid=Long.valueOf(el.getAttribute("id"));
	                    wayRegistry.put(nid,new Way(el,this));
	                }
	            }
	            /* ----------------- load OSM tracks --------------------- */
	            nList = doc.getElementsByTagName("relation");
	            for (int i = 0; i < nList.getLength(); i++) {
	                org.w3c.dom.Node nNode = nList.item(i);
	                if (nNode.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
	                    Element el=(Element) nNode;
	                    Long nid=Long.valueOf(el.getAttribute("id"));
	                    Track newTrack=RelationFactory.factory(el, this);
	                    if(newTrack != null)
	                        trackRegistry.put(nid,newTrack);
	                }
	            }
	            /* ------------------------------------------------------ */
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}	

