package EjA;

public class Main3 {

	public static void main(String[] args) {
		//este main se trabaja sobre el set de 3000000 con una lista de array

		ListaArreglo lista = new ListaArreglo();

		ABMcsv abm = new ABMcsv();
		
		long time_start, time_end;
		
		time_start = System.nanoTime();
		abm.cargar(lista, "dataset_3000000");
		time_end = System.nanoTime();
		System.out.println("Tiempo de carga 3millones: "+(time_end - time_start));
		
		time_start = System.nanoTime();
		abm.insert(lista);
		time_end = System.nanoTime();
		System.out.println("Tiempo de insercion 3millones: "+(time_end - time_start));
		
		time_start = System.nanoTime();
		abm.busqueda(lista);
		time_end = System.nanoTime();
		System.out.println("Tiempo de busqueda 3millones: "+(time_end - time_start));
		
		
	}

}
