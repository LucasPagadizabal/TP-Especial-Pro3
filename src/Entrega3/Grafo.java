package Entrega3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;


public class Grafo {

	HashMap<String,Integer> estAux;
	Lista[] vertices;
	int contador;
	public Grafo() {
		estAux = new HashMap<String, Integer>();
		vertices = new Lista[10000];
		contador = 0;
	}

	public void agregarGusto(String dato){

		if(contador > vertices.length){
			this.agrandarEstructura();
		}
		vertices[contador] = new Lista();

		estAux.put(dato, contador);
		contador++;

	}

	public void agregarUsuario(String dato){

		if(contador > vertices.length){
			this.agrandarEstructura();
		}

		if(!existeGusto(dato)){
			vertices[contador] = new Lista();

			estAux.put(dato, contador);
			contador++;
		}

	}

	public boolean existeGusto(String dato){
		return estAux.containsKey(dato);
	}

	private void agrandarEstructura(){
		Lista[] aux = new Lista[vertices.length*2];
		for (int i = 0; i < vertices.length; i++) {
			aux[i] = vertices[i];
		}

		vertices = aux;
	}

	public ArrayList<String> gustosEnComun(String u){
		ArrayList<String> resultado = new ArrayList<String>();
		Integer vert = estAux.get(u);
		ArrayList<String> gustos = new ArrayList<String>();

		for (int i = 0; i < vertices[vert].size(); i++) {
			gustos.add(vertices[vert].at(i));
		}

		for (int i = 0; i < contador; i++) {

			if(vertices[i].getTipo() == TipoDato.gusto && i !=vert){
				int gustComp = 0;
				for (int j = 0; j < vertices[i].size(); j++) {
					if(gustos.contains(vertices[i].at(j))){
						gustComp++;
					}
				}
				if(gustComp > 1){
					resultado.add(this.getValor(i));
				}
			}

		}
		return resultado;
	}

	public void addGustoUser(String g, String u){
		Integer vertUser = estAux.get(u);
		vertices[vertUser].add(g, TipoDato.gusto);
		Integer vertGusto = estAux.get(g);
		vertices[vertGusto].add(u, TipoDato.idUser);
	}

	public String getValor(int value){
		Set set = estAux.keySet();

		Iterator it = set.iterator();

		while(it.hasNext()){
			String key = (String) it.next();
			if(estAux.get(key) == value){
				return key;
			}

		}
		return null;
	}

	public String gustoPopular(){
		int gustoPop = -1;	
		int cantGusto = -1;
		for (int i = 0; i < contador; i++) {

			if(vertices[i].getTipo() == TipoDato.idUser){
				if(cantGusto < vertices[i].size()){
					cantGusto = vertices[i].size();
					gustoPop = i;
				}
			}
			
		}
		return this.getValor(gustoPop);
	}
	
	public String gustoMasLejano(String user){
		
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		
		for (int i = 0; i < contador; i++) {
			if(this.getValor(i) != user){
				res.add(this.getCaminoCorto(user, this.getValor(i)));
			
			}	
		}
		
		
		int mejor = 0;
		for (int i = 1; i < res.size(); i++) {
			if(res.get(i).size()> res.get(mejor).size()){
				if(vertices[estAux.get(res.get(i).get(0))].getTipo() == TipoDato.gusto){
					mejor =i;
				}
			}
		}
		
		//System.out.println(res.get(mejor));
		return res.get(mejor).get(0);
	}
	
	private ArrayList getCaminoCorto(String v1,String v2){

		int[] padres = new int[contador];
		boolean[] visto = new boolean[contador];

		for (int i = 0; i < padres.length; i++) {
			padres[i] = -1;
			visto[i] = false;
		}

		Queue fila = new LinkedBlockingQueue();

		fila.add(v1);

		boolean encontrado = false;

		ArrayList res = new ArrayList();

		while(!fila.isEmpty() && !encontrado){
			
			//System.out.println(fila.print());
			
			for (int i = 0; i < vertices[estAux.get(fila.peek())].size(); i++) {
				visto[estAux.get(fila.peek())] = true;
				
				if(padres[estAux.get(vertices[estAux.get(fila.peek())].at(i))] == -1 && visto[estAux.get(vertices[estAux.get(fila.peek())].at(i))] == false){
					padres[estAux.get(vertices[estAux.get(fila.peek())].at(i))] = estAux.get(fila.peek());//seteo padre
				}
				

				if(vertices[estAux.get(fila.peek())].at(i) == v2){
					encontrado = true;
				}

				fila.add(vertices[estAux.get(fila.peek())].at(i));

			}

			fila.remove();

		}

		int padre = padres[estAux.get(v2)];
		res.add(v2);
		int indice=0;
		while(padre != -1 && indice < padres.length){
			res.add(this.getValor(padre));
			padre = padres[padre];
			indice++;
		}

		return res;
	}
	
	public int getCantVertices(){
		return contador;
	}
	
}
