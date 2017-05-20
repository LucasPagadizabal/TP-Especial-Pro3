
package EjA;



public class Main1 {

	public static void main(String[] args) {

		//este main se trabaja sobre el set de 500000 con una lista de array
		ListaArreglo lista = new ListaArreglo();

		ABMcsv abm = new ABMcsv();

		abm.cargarInicial(lista, "dataset_500000");
		lista.ordenar();
		
		abm.insert(lista);
	
			
		abm.busqueda(lista);
		
	
	}

}