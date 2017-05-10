
package EjA;



public class Main1 {

	public static void main(String[] args) {
		
		//este main se trabaja sobre el set de 500000 con una lista de array
		ListaArreglo lista = new ListaArreglo();

		ABMcsv abm = new ABMcsv();

		abm.cargar(lista,"dataset_500000");
		abm.insert(lista);
		abm.busqueda(lista);
		
	}

}