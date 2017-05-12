package EjB;

import EjA.Lista;
import EjA.Usuario;


public class ListaVinculada extends Lista{

	protected Usuario raiz;
	protected int contador;

	public ListaVinculada(){
		contador=0;
	}

	public void addUser(String []d){

		if(contador == 0){
			raiz = new Usuario(d);
		}else{
			Usuario aux =new Usuario(d);
			aux.setNext(raiz);
			raiz=aux;
		}
		contador++;
	}

	public String toString(int pos) {

		int indice = 0;
		if(raiz!=null){

			if(pos==0){
				return raiz.toString();
			}else{
				Usuario aux = raiz;
				while(indice!= pos){
					indice++;
					aux=aux.getNext();
				}
				return aux.toString();
			}
		}else{
			return null;
		}

		
	}

	public int size() {
		return contador;
	}

	@Override
	public boolean existe(String id) {
		
		if(raiz != null){
			
			Usuario aux = raiz;
			
			while(aux != null){
				if(aux.getDni().equals(id)){
					return true;
				}
				aux= aux.getNext();
			}
			
		}
		return false;
	}
}
