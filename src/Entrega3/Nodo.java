package Entrega3;

public class Nodo {
	
	
	String dato;
	TipoDato tipo;
	Nodo next;

	public Nodo(String d,TipoDato t) {
		dato= d;
		tipo = t;
	}
	
	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public TipoDato getTipo() {
		return tipo;
	}

	public void setTipo(TipoDato tipo) {
		this.tipo = tipo;
	}

	public Nodo getNext() {
		return next;
	}

	public void setNext(Nodo next) {
		this.next = next;
	}


}
