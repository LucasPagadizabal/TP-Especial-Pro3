package EjA;



public class ListaArreglo extends Lista{

	Usuario arrAux[];
	protected Usuario [] usuarios;

	int contador;

	public ListaArreglo(){
		usuarios = new Usuario[10000];
		contador = 0;
	}

	public void addUser(String [] d){

		if(contador >= usuarios.length){
			Usuario [] aux = new Usuario[usuarios.length*2];

			for (int i = 0; i < usuarios.length; i++) {
				aux[i] = usuarios[i];
			}
			usuarios = aux;
		}

		usuarios[contador] = new Usuario(d);
		contador++;

	}

	public void insertarOrdenado(String [] d){
		
		if(contador >= usuarios.length){
			Usuario [] aux = new Usuario[usuarios.length*2];

			for (int i = 0; i < usuarios.length; i++) {
				aux[i] = usuarios[i];
			}
			usuarios = aux;
		}
		
		Usuario user = new Usuario(d);
		
		int pos = -1;
		int indice= 0;

		while(indice < contador && pos == -1){
			if(Integer.parseInt(usuarios[indice].getDni()) > Integer.parseInt(user.getDni())){
				pos = indice;
			}
			indice++;
		}

		//corrimiento
		if(pos != -1){
			for (int i = contador; i > pos; i--) {
				usuarios[i] = usuarios[i-1];
			}
			usuarios[pos] = user;
		}else{
			usuarios[contador] = user;
		}
		
		contador++;
	}

	public int size(){
		return contador;
	}

	public String toString (int pos){
		if(pos < contador){
			return usuarios[pos].toString();
		}
		return null;
	}

	public boolean existe(String id){

		return this.buscarUsuario(id, 0,contador);

	}

	public boolean buscarUsuario(String id, int min,int max){
		int pos = (max+min)/2;
		if(min != pos){

			if(Integer.parseInt(usuarios[pos].getDni()) < Integer.parseInt(id)){
				//return  paso el de la derecha
				return this.buscarUsuario(id, pos,max);
			}else if(Integer.parseInt(usuarios[pos].getDni()) > Integer.parseInt(id)){
				//return  paso la izq
				return this.buscarUsuario(id, 0, pos);
			}else if(Integer.parseInt(usuarios[pos].getDni()) == Integer.parseInt(id)){
				//es igual return true;
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}

	}

	public void ordenar(){
		arrAux = new Usuario[contador];
		mergesort(0,contador-1);
	}

	public void mergesort(int min, int max){
	
		if(min < max){//si esta condicion no se cumple es porque el arr no se puede dividir mas

			int medio = (min + max)/2;
			
			mergesort(min,medio);

			mergesort(medio+1,max);

			merge(min,medio,max);
		}
	}
	
public void merge(int min,int medio, int max){
		
		for (int i = 0; i < arrAux.length; i++) {
			arrAux[i]= usuarios[i];
		}
		
		int i = min;//indice para recorrer el 1er arr
		int j = medio + 1;//indice para recorrer el 2do arr
		int k = min;//controlar que no se pase del arreglo gral
		
		while(i <= medio && j <= max){
			if(Integer.parseInt(arrAux[i].getDni()) < Integer.parseInt(arrAux[j].getDni())){//comparar las dos partes
				usuarios[k] = arrAux[i];
				i++;
			}else{
				usuarios[k] = usuarios[j];
				j++;
			}
			k++;
		}
		
		while(i <= medio){//paso los que qdaron en en el arreglo aux que ya estan ordenados
			usuarios[k] = arrAux[i];
			k++;
			i++;
		}
	}

}
