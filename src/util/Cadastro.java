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
				"É feio jogar lixo na rua?", 
				"A - sim", 
				"B - não", 
				"C - talvez",
				"D - não sei...",
				"A - sim"
			)
		);
		perguntasList.add(
			new Pergunta(
				"O plástico é um material:", 
				"A - reciclavel", 
				"B - não reciclavel", 
				"C - biodegradável",
				"D - ecológico",
				"A - reciclavel"
			)
		);
		perguntasList.add(
			new Pergunta(
				"A reciclagem é :", 
				"A - A reutilização do lixo", 
				"B - O desperdicío do lixo", 
				"C - O lixo nas praias",
				"D - O lixo nas florestas",
				"A - A reutilização do lixo"
			)
		);
		perguntasList.add(
			new Pergunta(
				"A arara está :", 
				"A - Ameaçada de estinção", 
				"B - Muito bem obrigado", 
				"C - Completamente extinta",
				"D - Na floresta",
				"A - Ameaçada de estinção"
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
