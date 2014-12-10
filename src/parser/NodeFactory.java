package parser;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import postoj.Przystanek;
import static map.Map.mapInstance;
/**
 * Created by GT on 2014-11-16.
 */
public class NodeFactory {
    public static Node factory(Element el,Parser p)
    {
    	
        double lon = Double.valueOf(el.getAttribute("lon"));
        double lat = Double.valueOf(el.getAttribute("lat"));
        /* outside of bounds - skip */
        /*if(lon>map.maxLon || lon < map.minLon || lat < map.minLat || lat > map.maxLat)
            return null;*/
        
        String nazwa="";
        boolean isTramStop=false;
        NodeList tags=el.getElementsByTagName("tag");
        for(int i=0;i<tags.getLength();i++){
            org.w3c.dom.Node n=tags.item(i);
            if(n.getNodeType()==org.w3c.dom.Node.ELEMENT_NODE) {
                Element e = (Element) n;
                switch(e.getAttribute("k"))
                {
                    case "railway":
                        switch(e.getAttribute("v"))
                        {
                            case "tram_stop":
                                isTramStop=true;
                                break;
                            default:

                        }
                    break;
                    case "name":
                    	nazwa=e.getAttribute("v");
                    	break;
                }
            }
        }
        Node result;
        if(isTramStop){
        	result=new Przystanek(-1, nazwa);
        	p.tramStopCounter++;
        }
        else
        {
        	result=new Node();
        }
        
        result.lonlat[0]=lon;
        result.lonlat[1]=lat;
        result.id=Long.valueOf(el.getAttribute("id"));
        return result;
    }
}

