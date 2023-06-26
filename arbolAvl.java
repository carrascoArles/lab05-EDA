import myExceptions.ExceptionNoFound;

public class arbolAvl<E extends Comparable<E>> {
	private NodeAvl<E> root;
	private boolean height; // bandera la cual nos indicara si debe realizarse modificaciones
	
	public arbolAvl() {
		this.root = null;
	}
	public boolean isEmpty() {
		return this.root == null;
	}
	public E getRoot() {
		return this.root.getData();
	}



}
