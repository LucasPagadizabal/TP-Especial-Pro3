package EjC;

import EjA.ABMcsv;
import EjB.ListaVinculada;

public class Main1 {

	public static void main(String[] args) {

		//este main trabaja sobre un set de 500000 con una lista vinculada

		ListaVinculada lista = new ListaVinculada();

		ABMcsv abm = new ABMcsv();

		abm.cargar(lista, "dataset_500000");
		abm.insert(lista);
		abm.busqueda(lista);

	}

}
