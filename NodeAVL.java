public class NodeAvl<E> { 
	private E data;
	private NodeAvl<E> left; 
	private NodeAvl<E> right;
	private int bf;
	    
	public NodeAvl(E data, NodeAvl<E> left, NodeAvl<E> right){
		this.data = data;
	    this.left = left;
	    this.right = right;
	    this.bf = 0;
	}
    public NodeAvl(E data){ 
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
    public NodeAvl<E> getLeft() {
		return this.left;
	}

	public void setLeft(NodeAvl<E> left) {
		this.left = left;
	}
    public NodeAvl<E> getRight() {
		return this.right;
	}

	public void setRight(NodeAvl<E> right) {
		this.right = right;
	}




