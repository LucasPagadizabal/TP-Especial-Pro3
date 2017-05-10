package EjC;

import EjA.ABMcsv;
import EjB.ListaVinculada;

public class Main3 {

	public static void main(String[] args) {
		///este main trabaja sobre un set de 3000000 con una lista vinculada

		ListaVinculada lista = new ListaVinculada();

		ABMcsv abm = new ABMcsv();

		abm.cargar(lista, "dataset_3000000");
		abm.insert(lista);
		abm.busqueda(lista);


	}

}
