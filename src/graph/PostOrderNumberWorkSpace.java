package graph;

public class PostOrderNumberWorkSpace{
	WorkSpace w = new WorkSpace();
	
	PostOrderNumberWorkSpace(WorkSpace w){
		this.w = w;
	}
	
	public void print(Vertex v) {
		System.out.println(", post-order number " + v.VertexPostNumber);
	}
	
}
