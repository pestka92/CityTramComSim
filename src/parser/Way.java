package parser;

import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Way {
	ArrayList<Node> nodes=new ArrayList<Node>();
	public Way(Element el, Parser p) {
		NodeList tags=el.getElementsByTagName("tag");

        for(int i=0;i<tags.getLength();i++){
            org.w3c.dom.Node n=tags.item(i);
            if(n.getNodeType()==org.w3c.dom.Node.ELEMENT_NODE) {
                Element e = (Element) n;
                switch(e.getAttribute("k"))
                {
                     
                }
            }
        }
       
        /* tag read finished */

        NodeList nodeRefList=el.getElementsByTagName("nd");
        for(int i=0;i<nodeRefList.getLength();i++){
            org.w3c.dom.Node n=nodeRefList.item(i);
            if(n.getNodeType()==org.w3c.dom.Node.ELEMENT_NODE) {
                Element e = (Element) n;
                Node nn=p.nodeRegistry.get(Long.valueOf(e.getAttribute("ref")));
                if(nn!=null) {
                    nodes.add(nn);
                }
                else
                    System.out.println("Null node ref(problably node outside of region bounds)");
            }
        }
	}

}
