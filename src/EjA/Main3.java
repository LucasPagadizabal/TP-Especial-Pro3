package EjA;

public class Main3 {

	public static void main(String[] args) {
		//este main se trabaja sobre el set de 3000000 con una lista de array

		ListaArreglo lista = new ListaArreglo();

		ABMcsv abm = new ABMcsv();

		abm.cargar(lista,"dataset_3000000");
		abm.insert(lista);
		abm.busqueda(lista);

	}

}
