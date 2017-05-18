package EjA;



public class ListaArreglo extends Lista{

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
		//this.insertarOrdenado(new Usuario(d)); //2da etapa del tp
		contador++;
	}

	public void insertarOrdenado(Usuario user){
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
}
