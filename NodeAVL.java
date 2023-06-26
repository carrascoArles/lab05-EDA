public class NodeAVL<E> { 
	private E data;
	private NodeAVL<E> left; 
	private NodeAVL<E> right;
	private int bf;
	    
	public NodeAVL(E data, NodeAVL<E> left, NodeAVL<E> right){
		this.data = data;
	    this.left = left;
	    this.right = right;
	    this.bf = 0;
	}
    public NodeAVL(E data){ 
		this(data,null, null);
	}
	public int getBf() {
		return bf;
	}
	public void setBf(int bf) {
		this.bf = bf;
	}
    public E getData() {
		return this.data;
	}

	public void setData(E data) {
		this.data = data;
	}
    public NodeAVL<E> getLeft() {
		return this.left;
	}

	public void setLeft(NodeAVL<E> left) {
		this.left = left;
	}
    public NodeAVL<E> getRight() {
		return this.right;
	}

	public void setRight(NodeAVL<E> right) {
		this.right = right;
	}
    public String toString() {
		return this.data.toString() + "(" + this.bf + ")";
	}
}



