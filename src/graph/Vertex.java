/**
 * Vertex class 
 * @author Roberto E. Lopez-Herrejon
 * ETS MGL869
 */
package graph;

// undirected and Directed have the same code


import java.util.LinkedList;
import java.util.List;

public class Vertex {
    public List<Neighbor> neighbors;
    public String name;
    public boolean visited;

    public Vertex() {
        name      = null;
        neighbors = new LinkedList<Neighbor>();
        
    }

    
    public  Vertex assignName( String name ) {
        this.name = name;
        return this;
    }
   
    public void addNeighbor( Neighbor n ) {
        neighbors.add( n );
    }

    public boolean equals(Object o) {
    	boolean result = false;
    	    	if (!(o instanceof Vertex)) return result;
    	Vertex v = (Vertex) o;
    	if (v.name==this.name) result = true;
    	return result;
    }
   
    public void display() {
    	
        System.out.print( " Node " + name + " connected to: " );

        for (Neighbor theNeighbor : neighbors) {

        	if (GraphMain.UNDIRECTED) System.out.print( theNeighbor.end.name + ", " );
        	
            Vertex v = theNeighbor.end;
            System.out.print( v.name + ", " );
            
        } // for all the vertices
        
        System.out.println();
    } // of display
    
    public void init_vertex( WorkSpace w ) {
    	  visited = false;
    	  w.init_vertex(this);
   }
   // ---

   // @feature BFS
   static LinkedList<Vertex> Queue =  new LinkedList<Vertex>();

   public void bftSimpleNodeSearch() {
	   Vertex v;
	   Vertex header;
	   
	   if (visited) return;
	   
	   // Step 1. Action displays the vertex name
	   System.out.println("Simple BFT search " + name);
	   
	   // Step 2: Mark as visited
	   visited = true;
	   
	   // Step 3: put the unvisited neighbors in the queue make the call
	   // on the first element of the queue
	   for (Neighbor n : neighbors) {
		   v = n.end;
		   if (!v.visited) Queue.add(v);
	   }
	   
	   // while there are nodes in the queue to visit
	   while(Queue.size()!=0) {
		   header = Queue.get(0); Queue.remove(0);
		   header.bftSimpleNodeSearch();
	   	} // while
	   } // of bfsSimpleNodeSearch
   
   public void bftNodeSearch( WorkSpace w ) {
    Vertex  v;
    Vertex  header;

    // Step 1: if preVisitAction is true or if we've already
    //         visited this node
    w.preVisitAction(this);
    if (visited) return;

    // Step 2: Mark as visited, put the unvisited neighbors in the queue
    //     and make the recursive call on the first element of the queue
    //     if there is such if not you are done
    visited = true;

    // Step 3: do postVisitAction now, you are no longer going through the
    // node again
    w.postVisitAction(this);

    // enqueues the vertices not visited
    for (Neighbor n : neighbors) {
     v = n.end;

     // if the neighbor has not been visited then enqueue
     if (!v.visited) Queue.add(v);
    }


    // while there is something in the queue
    while(Queue.size()!=0) {
     header = Queue.get(0);
     Queue.remove(0);
     header.bftNodeSearch( w );
    } // while there is a vertex pending to visit

   } // of bfsNodeSearch
   // ---
   
   
   public void dftSimpleNodeSearch() {
   	
	Vertex v;   
	
   	if (visited) return;
   	
   	// Step 1. Action displays the vertex name
   	System.out.println("Simple DFT search " + name);
   	
   	// Step 2: Remember that we've visited and visit all neighbors
   	visited = true;
   	
   	// Step 3: visit all neighbors
   	for (Neighbor n : neighbors) {
   		v = n.end;
   		v.dftSimpleNodeSearch();
   	}
   } // of dftSimpleNodeSearch

   
   // @feature DFS
   public void dftNodeSearch( WorkSpace w ) {
    Vertex v;

    // Step 1: Do preVisitAction.
    // If we've already visited this node return
    w.preVisitAction(this);
    if (visited) return;

    // Step 2: else remember that we've visited and
    //         visit all neighbors
    visited = true;

    for (Neighbor n : neighbors) {
     v = n.end;
     w.checkNeighborAction(this,v);
     v.dftNodeSearch(w);
    }

    // Step 3: do postVisitAction now
    w.postVisitAction(this);
   } // of dftNodeSearch
   // ---

   // @feature NUMBER
   public int VertexNumber;
   // ----    
    
    
} // class Vertex
