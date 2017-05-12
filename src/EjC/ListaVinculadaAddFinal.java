package EjC;

import EjA.Usuario;
import EjB.ListaVinculada;

public class ListaVinculadaAddFinal extends ListaVinculada {
	
	public void addUser(String [] d){

		if(contador == 0){
			raiz = new Usuario(d);
		}else{
			Usuario aux = raiz;
			while (aux.getNext()!= null){
				aux = aux.getNext();
			}

			aux.setNext(new Usuario(d));

		}
		contador++;
	}
	
}
