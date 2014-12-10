package parser;

import postoj.Przystanek;
import map.Map;

public class ParserTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Map m=new Map();
			/*Parser p=new Parser("tram_lines.osm");
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
			}*/
			
			m.wypiszMape();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
