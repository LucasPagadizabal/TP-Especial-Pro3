package EjA;

public class Usuario {
	
	String dni;
	int cantGustos = 5;
	String [] gustos = new String [cantGustos];
	Usuario next;
	
	public Usuario (String [] datos){
		dni = datos[0];
		int j=0;
		for (int i = 1; i < datos.length; i++) {
		
			if(!existe(datos[i])){
				gustos[j] = datos[i];
				j++;
			}
			
		}
		
	}
	
	public boolean existe(String gus){
		
		for (int i = 0; i < gustos.length; i++) {
			if(gustos[i]!= null && gustos[i].equals(gus)){
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		String mjs=dni+" ";
		
		for (int i = 0; i < gustos.length; i++) {
			mjs+= gustos[i]+" ";
		}
		
		return mjs;
	}
	
	public Usuario getNext(){
		return next;
	}
	public void setNext(Usuario u){
		next=u;
	}
	
	public String getDni(){
		return dni;
	}

}
