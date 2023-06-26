import myExceptions.ExceptionNoFound;

public class testAVL {
	public static void main(String[] args) throws ExceptionNoFound {
		arbolAVL<Character> b = new arbolAVL<Character>();
		
		b.insert('E');
		b.inOrden();
		System.out.println("root: " + b.getRoot());
		b.insert('A');
		b.inOrden();
		System.out.println("root: " + b.getRoot());
		b.insert('B');
		b.inOrden();
		System.out.println("root: " + b.getRoot());
		b.insert('C');
		b.inOrden();
		System.out.println("root: " + b.getRoot());
		b.insert('D');
		b.inOrden();
		System.out.println("root: " + b.getRoot());
		b.insert('F');
		b.inOrden();
		System.out.println("root: " + b.getRoot());
		b.insert('Z');
		b.inOrden();
		System.out.println("root: " + b.getRoot());
		b.insert('K');
		b.inOrden();
		System.out.println("root: " + b.getRoot());
		//b.remove('K');
		
		System.out.println();
		System.out.println("Hijos de Z: " + b.son('Z'));
		
		System.out.println();
		System.out.println("Padre de K: " + b.parent('K'));
		
		System.out.println();
		System.out.println("minimo valor: " + b.getMin());
		
		System.out.println();
		System.out.println("maximo valor: " + b.getMax());
		
		System.out.println();
		System.out.println("buscando a Z: " + b.search('Z'));
		
		
		
		


	
	}

}
