package Entrega3;

public class Main {

	public static void main(String[] args) {
		
		Grafo grafo = new Grafo();
		CargaCSV carga = new CargaCSV();
		
		carga.cargarInicial(grafo, "dataset_insert_10000");
		
		System.out.println(grafo.gustosEnComun("1").toString());
		
		System.out.println("Gusto Popular "+grafo.gustoPopular());
		
		System.out.println(grafo.gustoMasLejano("18096546"));


	}

}
