
public class AdjListNode {
	int v;//vertex to which the edge leads
	int w;//weight of edge
	AdjListNode next;
	public AdjListNode(int i, int j, AdjListNode n){
		v=i;
		w=j;
		next=n;
	}
}
