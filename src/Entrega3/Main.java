package Entrega3;

public class Main {

	public static void main(String[] args) {
		
		Grafo grafo = new Grafo();
		
		grafo.agregarUsuario("11");
		grafo.agregarGusto("Tenis");
		grafo.agregarGusto("Futbol");
		grafo.agregarUsuario("22");
		grafo.agregarGusto("Hockey");
		grafo.agregarUsuario("33");
		
		grafo.addGustoUser("Hockey", "33");
		grafo.addGustoUser("Futbol", "11");
		grafo.addGustoUser("Tenis", "11");
		grafo.addGustoUser("Tenis", "22");
		grafo.addGustoUser("Futbol", "22");
		grafo.addGustoUser("Hockey", "22");
		
		//System.out.println(grafo.gustosEnComun("11").toString());
		
		//System.out.println("Gusto Popular "+grafo.gustoPopular());
		
		System.out.println(grafo.gustoMasLejano("11"));


	}

}
