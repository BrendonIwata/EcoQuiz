package util;

import java.util.ArrayList;
import java.util.List;

import model.Pergunta;

public class Cadastro {
	
	private static List<Pergunta> perguntasList = new ArrayList<>();
 	
	static {
		perguntasList.add(
			new Pergunta(
				"Qual a cor da lixeira do papel", 
				"A - azul", 
				"B - vermelho", 
				"C - amarelo",
				"D - rosa",
				"A - azul"
			)
		);
		perguntasList.add(
			new Pergunta(
				"� feio jogar lixo na rua?", 
				"A - sim", 
				"B - n�o", 
				"C - talvez",
				"D - n�o sei...",
				"A - sim"
			)
		);
		perguntasList.add(
			new Pergunta(
				"O pl�stico � um material:", 
				"A - reciclavel", 
				"B - n�o reciclavel", 
				"C - biodegrad�vel",
				"D - ecol�gico",
				"A - reciclavel"
			)
		);
		perguntasList.add(
			new Pergunta(
				"A reciclagem � :", 
				"A - A reutiliza��o do lixo", 
				"B - O desperdic�o do lixo", 
				"C - O lixo nas praias",
				"D - O lixo nas florestas",
				"A - A reutiliza��o do lixo"
			)
		);
		perguntasList.add(
			new Pergunta(
				"A arara est� :", 
				"A - Amea�ada de estin��o", 
				"B - Muito bem obrigado", 
				"C - Completamente extinta",
				"D - Na floresta",
				"A - Amea�ada de estin��o"
			)
		);
	}
	
	public static List<Pergunta> getPerguntasList () {
		return Cadastro.perguntasList;	
	}
	
	public static Pergunta getPergunta (int index) {
		return perguntasList.get(index);		
	}
	
	public boolean acertou (String opcSelecionada, Integer index) {
		String opcCorreta = Cadastro.getPerguntasList().get(index).getOpcCorreta();
		if (opcSelecionada.equals(opcCorreta)) {
			return true;
		}
		return false;
	}
}
