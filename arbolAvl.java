import myExceptions.ExceptionNoFound;

public class arbolAVL<E extends Comparable<E>> {
	private NodeAVL<E> root;
	private boolean height; // bandera la cual nos indicara si debe realizarse modificaciones
	
	public arbolAVL() {
		this.root = null;
	}
	public boolean isEmpty() {
		return this.root == null;
	}
	public E getRoot() {
		return this.root.getData();
	}
	public void insert(E x) throws ExceptionNoFound {
		this.root = insert(x, this.root);	
		this.height = false;
	}
	private NodeAVL<E> insert(E x, NodeAVL<E> current) throws ExceptionNoFound{
		NodeAVL<E> res = current;
		if (current == null) {
			res = new NodeAVL<E>(x);
			this.height = true;
		}
		else {
			int resC = current.getData().compareTo(x);
			if (resC == 0)
				throw new ExceptionNoFound("El elemento ya se encuentra en el arbol");
			if (resC < 0) {
				res.setRight(insert(x, current.getRight()));
				if (this.height) {
					switch(res.getBf()) {
					case -1: res.setBf(0); //-1+1
							this.height = false;
							break;
					case 0: res.setBf(1); //0+1
							break;
					case 1: //res.setBf(2); 1+1
							// metodo balance izq
							this.height = false;
							break;
					}
				}
				
			}
			else { // resC > 0
				res.setLeft(insert(x, current.getLeft()));
				// rotacion der
			}
		}
		return res;	
	}
	



}
