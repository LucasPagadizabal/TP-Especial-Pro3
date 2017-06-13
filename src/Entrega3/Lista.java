package Entrega3;

public class Lista {

	private Nodo raiz;
	private int contador;

	public Lista() {
		raiz = null;
		contador = 0;
	}

	public Lista(String s,TipoDato t){
		raiz = new Nodo(s,t);
		contador = 1;
	}

	public void add(String s,TipoDato t){
		Nodo aux = new Nodo(s,t);
		aux.setNext(raiz);
		raiz = aux;
		contador++;
	}

	public boolean vacia(){
		return raiz == null;
	}

	public int size(){
		return contador;
	}

	public String at (int i){

		if(i <= this.size()){
			int cont = 0;
			Nodo aux = raiz;
			while(cont < this.size()){
				if(cont == i){
					return aux.getDato();
				}
				aux = aux.getNext();
				cont++;
			}
			return null;
		}else{
			return null;
		}
	}
	
	public Enum<TipoDato> getTipo (){
		if(raiz!= null)return raiz.getTipo();
		return null;
	}
}
