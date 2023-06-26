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
	private boolean isLeaf(NodeAVL<E> current) { // elemento es hoja
		return current.getLeft() == null && current.getRight() == null;
	}
	public NodeAvl<E> parent(E x) throws ExceptionNoFound {
		 NodeAvl<E> aux = parent(x, this.root);
		 if (aux == null)
			throw new ExceptionNoFound("Elemento no se encuentra en el arbol");
                 System.out.println(aux.getData());
		 return aux;
	}
	private NodeAvl<E> parent(E x, NodeAvl<E> current) throws ExceptionNoFound{
		   if (current == null) {
        throw new ExceptionNoFound("El árbol está vacío");
    }
    
    NodeAvl<E> parent = null;
    NodeAvl<E> node = current;
    
    while (node != null) {
        int comparison = x.compareTo(node.getData());
        
        if (comparison == 0) {
            if (parent == null) {
                throw new ExceptionNoFound("El nodo insertado es la raíz del árbol");
            }
            return parent;
        } else if (comparison < 0) {
            parent = node;
            node = node.getLeft();
        } else {
            parent = node;
            node = node.getRight();
        }
    }
    
    throw new ExceptionNoFound("El elemento no se encuentra en el árbol");}
	
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
							res = balanceToLeft(res);
							this.height = false;
							break;
					}
				}
				
			}
			else { // resC > 0
				res.setLeft(insert(x, current.getLeft()));
				if (this.height) {
					switch(res.getBf()) {
					case -1: //res.setBf(-2); //-1-1
							res = balanceToRight(res);
							this.height = false;
							break;
					case 0: res.setBf(-1); //0-1
							break;
					case 1: res.setBf(0); // 1-1
							this.height = false;
							break;
					}
				}
			}
		}
		return res;	
	}
	private NodeAVL<E> balanceToLeft(NodeAVL<E> node){
		NodeAVL<E> son = node.getRight();
		if (son.getBf() == 1){
			node.setBf(0);
			son.setBf(0);
			node = rotateRSL(node);
		}
		else if (son.getBf() == -1) {
			NodeAVL<E> gSon = son.getLeft();
			switch(gSon.getBf()) {
			case -1: 
				node.setBf(0); 
				son.setBf(-1); 
				break;
			case 0: 
				node.setBf(0); 
				son.setBf(0); 
				break;
			case 1: 
				node.setBf(1); 
				son.setBf(0); 
				break;
			}
			gSon.setBf(0);
			node.setRight(rotateRSR(son));
			node = rotateRSL(node);
		}
		return node;
	}
    private NodeAVL<E> balanceToRight(NodeAVL<E> node){
		NodeAVL<E> son = node.getLeft();
		if (son.getBf() == -1){
			node.setBf(0);
			son.setBf(0);
			node = rotateRSR(node);
		}
		else if (son.getBf() == 1) {
			NodeAVL<E> gSon = son.getRight();
			switch(gSon.getBf()) {
			case 1: 
				node.setBf(0); 
				son.setBf(-1); 
				break;
			case 0: 
				node.setBf(0); 
				son.setBf(0); 
				break;
			case -1: 
				node.setBf(1); 
				son.setBf(0); 
				break;
			}
			gSon.setBf(0);
			
			node.setLeft(rotateRSL(son));
			node = rotateRSR(node);
		}
		return node;
}
	private NodeAVL<E> rotateRSL(NodeAVL<E> node){
		NodeAVL<E> son = node.getRight();
		node.setRight(son.getLeft());
		son.setLeft(node);
		node = son;
		return node;
	}
	
	private NodeAVL<E> rotateRSR(NodeAVL<E> node){
		NodeAVL<E> son = node.getLeft();
		node.setLeft(son.getRight());
		son.setRight(node);
		node = son;
		return node;
	}
	
	public NodeAVL<E> search(E x) throws ExceptionNoFound {
		 NodeAVL<E> aux = search(x, this.root);
		 if (aux == null) {
			throw new ExceptionNoFound("Elemento no se encuentra en el arbol");
		 }
		 return aux;
	}
	private NodeAVL<E> search(E x, NodeAVL<E> current) throws ExceptionNoFound{
		if (current == null) { // deja la recursividad si ya no hay elementos
			return null; 
		}
		else {
			int resC = current.getData().compareTo(x);
			if (resC == 0) // deja la recursividad hasta encontrar el elemento
				return current;
			if (resC < 0)
				return search(x, current.getRight());
			else
				return search(x, current.getLeft());
		}
	}
	public void remove(E x) throws ExceptionNoFound {
		this.root = remove(x, this.root);	
	}
	private NodeAVL<E> remove(E x, NodeAVL<E> current) throws ExceptionNoFound{
		NodeAVL<E> res = current;
		if (current == null) {
			throw new ExceptionNoFound("Elemento no se encuentra en el arbol");
		}
		else {
			
		}
		return res;

	}
	public NodeAVL<E> getMin(){
		return getMin(root);
	}
	public NodeAVL<E> getMin(NodeAVL<E> nodo){
	        if (nodo.getLeft()== null) {
	            return nodo;
	        }
        	return getMin(nodo.getLeft());
	}
	
	public NodeAVL<E> getMax(){
		return getMax(root);
	}
	public NodeAVL<E> getMax(NodeAVL<E> nodo){
	        if (nodo.getRight()== null) {
	            return nodo;
	        }
       		return getMax(nodo.getRight());
	}
	
	
	



}
