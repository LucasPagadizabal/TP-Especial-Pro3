package EjA;

public class Main2 {

	public static void main(String[] args) {
		//este main se trabaja sobre el set de 1000000 con una lista de array

		ListaArreglo lista = new ListaArreglo();

		ABMcsv abm = new ABMcsv();

		long time_start, time_end;

		time_start = System.nanoTime();
		abm.cargarInicial(lista, "dataset_1000000");
		time_end = System.nanoTime();
		System.out.println("Tiempo de carga 1millon: "+(time_end - time_start));

		time_start = System.nanoTime();
		abm.insert(lista);
		time_end = System.nanoTime();
		System.out.println("Tiempo de insercion 1millon: "+(time_end - time_start));

		time_start = System.nanoTime();
		abm.busqueda(lista);
		time_end = System.nanoTime();
		System.out.println("Tiempo de busqueda 1millon: "+(time_end - time_start));


	}

}
