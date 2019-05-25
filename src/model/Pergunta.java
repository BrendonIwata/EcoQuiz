package model;

public class Pergunta {
	
	private String titulo;
	private String A, B, C, D;
	private String opcCorreta;
	
	public Pergunta () {
		
	}
	
	public Pergunta(String titulo, String a, String b, String c, String d, String opcCorreta) {
		this.titulo = titulo;
		A = a;
		B = b;
		C = c;
		D = d;
		this.opcCorreta = opcCorreta;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public String getA() {
		return A;
	}
	
	public String getB() {
		return B;
	}
	
	public String getC() {
		return C;
	}
	
	public String getD() {
		return D;
	}

	public String getOpcCorreta() {
		return opcCorreta;
	}
}
