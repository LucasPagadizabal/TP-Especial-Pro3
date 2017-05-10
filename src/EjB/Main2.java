package EjB;

import EjA.ABMcsv;

public class Main2 {

	public static void main(String[] args) {
		//este main trabaja sobre un set de 1000000 con una lista vinculada

		ListaVinculada lista = new ListaVinculada();

		ABMcsv abm = new ABMcsv();

		abm.cargar(lista, "dataset_1000000");
		abm.insert(lista);
		abm.busqueda(lista);

	}

}
