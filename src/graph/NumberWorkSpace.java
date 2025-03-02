/**
 * Graph Search Patterns
 * Example implementing Numbering algorithm
 * @author Roberto E. Lopez-Herrejon
 * ETS-LOGTI
 */
package graph;

public class NumberWorkSpace extends WorkSpace {
	int vertexCounter;
	int vertexPostCounter;
	
	public NumberWorkSpace(Graph g) {
		vertexCounter = 1;
		vertexPostCounter = g.vertices.size();
	}
	
	
	
	public void nextRegionAction( Vertex v ) {
		if (GraphMain.BFS) {
			//System.out.println("BFT Numbered Search : ");
			v.bftNodeSearch( this );
		}
		
		if (GraphMain.DFS) {
			//System.out.println("DFT Numbered Search : ");
			v.dftNodeSearch( this );
		}
	}

	 
	 
	public void preVisitAction( Vertex v ) {
		// This assigns the values on the way in
	    if (v.visited!=true) {
	    	v.VertexNumber = vertexCounter++;
	    }
	}

	//DFT only
	public void checkNeighborAction( Vertex vsource,Vertex vtarget ) {
		
	}
	 
	public void postVisitAction( Vertex v ) {
		v.VertexPostNumber = vertexPostCounter--;
		
	}
	

	 

}
