package EjA;

public class Main2 {

	public static void main(String[] args) {
		//este main se trabaja sobre el set de 1000000 con una lista de array
		
		ListaArreglo lista = new ListaArreglo();

		ABMcsv abm = new ABMcsv();

		abm.cargar(lista,"dataset_1000000");
		abm.insert(lista);
		abm.busqueda(lista);
		

	}

}
