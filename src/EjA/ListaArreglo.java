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
		for (int i = 0; i < contador; i++) {
			if(usuarios[i].getDni().equals(id)){
				return true;
			}
		}
		return false;
	}
}
