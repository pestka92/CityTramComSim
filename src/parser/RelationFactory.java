package parser;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class RelationFactory {

	public static Track factory(Element el, Parser parser) {
		NodeList tags=el.getElementsByTagName("tag");

        for(int i=0;i<tags.getLength();i++){
            org.w3c.dom.Node n=tags.item(i);
            if(n.getNodeType()==org.w3c.dom.Node.ELEMENT_NODE) {
                Element e = (Element) n;
                switch(e.getAttribute("k"))
                {
                case "type":
                	if(!e.getAttribute("v").equals("route")){
                		System.out.println("Not track relation");
                		return null;
                	}
                	break;
                }
            }
        }
        //track relations
       Track result=new Track(el,parser);
       
       return result;
	}

}
