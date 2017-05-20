package EjB;

import EjA.ABMcsv;

public class Main1 {

	public static void main(String[] args) {

		//este main trabaja sobre un set de 500000 con una lista vinculada

		ListaVinculada lista = new ListaVinculada();

		ABMcsv abm = new ABMcsv();

		long time_start, time_end;

		time_start = System.nanoTime();
		abm.cargarInicial(lista, "dataset_500000");
		time_end = System.nanoTime();
		System.out.println("Tiempo de carga 500000: "+(time_end - time_start));

		time_start = System.nanoTime();
		abm.insert(lista);
		time_end = System.nanoTime();
		System.out.println("Tiempo de insercion 500000: "+(time_end - time_start));

		time_start = System.nanoTime();
		abm.busqueda(lista);
		time_end = System.nanoTime();
		System.out.println("Tiempo de busqueda 500000: "+(time_end - time_start));

	}

}
