package parser;

import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import static map.Map.mapInstance;
import postoj.Postoj;
import postoj.Przystanek;

public class Track {
	int linia=0;
	public ArrayList<Node> nodes=new ArrayList<>();
	public int startNode=-1;
	public int stopNode=-1;
	int stopCount=0;
	public Track(Element el, Parser parser) {
		NodeList tags=el.getElementsByTagName("tag");
		 /**	
	      	<tag k="from" v="Dworzec Towarowy"/>
			<tag k="name" v="Tram 7: Dworzec Towarowy =&#62; Mały Płaszów"/>
			<tag k="network" v="Komunikacja Miejska w Krakowie"/>
			<tag k="operator" v="MPK Kraków"/>
			<tag k="ref" v="7"/>
			<tag k="route" v="tram"/>
			<tag k="to" v="Mały Płaszów"/>
			<tag k="type" v="route"/>
		  */
        for(int i=0;i<tags.getLength();i++){
            org.w3c.dom.Node n=tags.item(i);
            if(n.getNodeType()==org.w3c.dom.Node.ELEMENT_NODE) {
                Element e = (Element) n;
               
                switch(e.getAttribute("k"))
                {
                case "ref":
                	linia=Integer.valueOf(e.getAttribute("v"));
                	break;
                }
            }
        }
        NodeList members=el.getElementsByTagName("member");
        for(int i=0;i<members.getLength();i++){
            org.w3c.dom.Node n=members.item(i);
            if(n.getNodeType()==org.w3c.dom.Node.ELEMENT_NODE) {
                Element e = (Element) n;
               
                switch(e.getAttribute("type"))
                {
                case "way":
                	Long wayId=Long.valueOf(e.getAttribute("ref"));
                	Way w=parser.wayRegistry.get(wayId);
                	if(w!=null&&!e.getAttribute("role").equals("platform")&&!e.getAttribute("role").equals("platform_exit_only")&&!e.getAttribute("role").equals("platform_entry_only"))
            		{
	            		for(Node nn:w.nodes)
	            		{
	            			if(!nodes.contains(nn))
	            				nodes.add(nn);
	            		}
            		}
                	break;
                case "node":
                	Long nodeId=Long.valueOf(e.getAttribute("ref"));
                	Node nn=parser.nodeRegistry.get(nodeId);
                	if(nn!=null&&!nodes.contains(nn)){              			
                			nodes.add(nn);
                		if(e.getAttribute("role").equals("stop_entry_only"))
                        	startNode=nodes.size()-1;
                		if(e.getAttribute("role").equals("stop_exit_only"))
                        	stopNode=nodes.size()-1;
                	}
                		
                }
            }
        }
        int pC=0;
        for(int i=0;i<nodes.size();i++){
        	if(nodes.get(i) instanceof Przystanek){
        		pC=i;
        		stopCount++;
    			if(startNode==-1)
    				startNode=pC;
        	}
        }
        if(stopNode==-1)
        	stopNode=pC;
	}
	@Override
	public String toString(){
		String start=(startNode!=-1)?((Przystanek)nodes.get(startNode)).getNazwa():"#";
		String stop=(stopNode!=-1)?((Przystanek)nodes.get(stopNode)).getNazwa():"#";
	return "Linia "+linia+": "+	start+"->"+	stop + "["+stopCount+"/"+nodes.size()+"]";
	}
	
	public Przystanek getStartNode(){
		return (Przystanek) nodes.get(startNode);	
	}
	public Przystanek getStopNode(){
		return (Przystanek) nodes.get(stopNode);	
	}
}
