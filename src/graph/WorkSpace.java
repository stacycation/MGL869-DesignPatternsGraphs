/**
 * Graph Search Patterns
 * Example implemeting searches
 * @author Roberto E. Lopez-Herrejon
 * ETS-LOGTI
 */
package graph;

//supply template actions
public class WorkSpace { 

 //called by Graph.GraphSearch()
 public void init_vertex( Vertex v ) {} //defined in Vertex class
 public void nextRegionAction( Vertex v ) {}
 
 //used by Vertex.dftNodeSearch & Vertex.bftNodesearch()
 public void preVisitAction( Vertex v ) {}
 public void checkNeighborAction( Vertex vsource,Vertex vtarget ) {} //only used by Vertex.dftNodeSearch()
 public void postVisitAction( Vertex v ) {}


}
