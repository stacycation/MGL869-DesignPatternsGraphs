package graph;

public class PrintWorkSpace{
	WorkSpace w = new WorkSpace();
	
	PrintWorkSpace(WorkSpace w){
		this.w = w;
	}
	public void print(Vertex v) {
		System.out.printf( v.name + ", pre-order number " + v.VertexNumber);
	}

}
