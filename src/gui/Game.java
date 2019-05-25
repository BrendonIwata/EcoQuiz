package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import constants.Constants;
import util.Cadastro;

public class Game extends JFrame {

	private Container contentPane;

	private JLabel pergunta;
	private JRadioButton opc1, opc2, opc3, opc4;
	private JLabel resultadoResposta;
	private JButton responder;
	private JButton proximaQuestao;
	private ButtonGroup buttonGroup;
	private Integer index = 0;
	private static JFrame frame;
	Cadastro cadastro = new Cadastro();

	public Game() {
		inicializarComponentes();
		definirEventos();
		setResizable(false);
	}

	private void inicializarComponentes() {
		setTitle("Eco Quiz");

		setBounds(0, 0, 400, 400);
		setLayout(null);

		contentPane = getContentPane();

		pergunta = new JLabel(Cadastro.getPergunta(index).getTitulo());
		pergunta.setBounds(125, 20, 400, 20);
		opc1 = new JRadioButton(Cadastro.getPergunta(index).getA());
		opc1.setBounds(10, 60, 400, 40);
		opc1.setActionCommand(Cadastro.getPergunta(index).getA());
		opc1.setSelected(true);
		opc1.setActionCommand(Cadastro.getPergunta(index).getA());
		opc2 = new JRadioButton(Cadastro.getPergunta(index).getB());
		opc2.setBounds(10, 90, 400, 40);
		opc2.setActionCommand(Cadastro.getPergunta(index).getB());
		opc3 = new JRadioButton(Cadastro.getPergunta(index).getC());
		opc3.setBounds(10, 120, 400, 40);
		opc3.setActionCommand(Cadastro.getPergunta(index).getC());
		opc4 = new JRadioButton(Cadastro.getPergunta(index).getD());
		opc4.setBounds(10, 150, 400, 40);
		opc4.setActionCommand(Cadastro.getPergunta(index).getD());
		resultadoResposta = new JLabel();
		resultadoResposta.setBounds(170, 200, 400, 40);
		buttonGroup = new ButtonGroup();
		buttonGroup.add(opc1);
		buttonGroup.add(opc2);
		buttonGroup.add(opc3);
		buttonGroup.add(opc4);
		responder = new JButton("Responder");
		responder.setBounds(100, 300, 100, 20);
		responder.setActionCommand("responder");
		proximaQuestao = new JButton("Próxima questão");
		proximaQuestao.setBounds(200, 300, 100, 20);
		proximaQuestao.setEnabled(false);

		contentPane.add(opc1);
		contentPane.add(opc2);
		contentPane.add(opc3);
		contentPane.add(opc4);
		contentPane.add(resultadoResposta);
		contentPane.add(responder);
		contentPane.add(proximaQuestao);
		contentPane.add(pergunta);
	}

	private void definirEventos() {
		proximaQuestao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				proximaQuestao();
				proximaQuestao.setEnabled(false);
				resultadoResposta.setText("");
			}
		});
		responder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cadastro.acertou(buttonGroup.getSelection().getActionCommand(), index)) {
					resultadoResposta.setText(Constants.ACERTOU);
					if (index < Cadastro.getPerguntasList().size() - 1) {
						proximaQuestao.setEnabled(true);
					} else {
						frame.setVisible(false);
						Vitoria.abrir();
					}
				} else {
					resultadoResposta.setText(Constants.ERROU);
				}
			}
		});
	}

	public static void abrir() {
		frame = new Game();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((tela.width - frame.getSize().width) / 2, (tela.height - frame.getSize().height) / 2);
		frame.setVisible(true);
	}

	public void proximaQuestao() {
		if (index < Cadastro.getPerguntasList().size() - 1) {
			index++;
		}

		pergunta.setText(Cadastro.getPergunta(index).getTitulo());
		opc1.setText(Cadastro.getPergunta(index).getA());
		opc1.setActionCommand(Cadastro.getPergunta(index).getA());
		opc2.setText(Cadastro.getPergunta(index).getB());
		opc2.setActionCommand(Cadastro.getPergunta(index).getB());
		opc3.setText(Cadastro.getPergunta(index).getC());
		opc3.setActionCommand(Cadastro.getPergunta(index).getC());
		opc4.setText(Cadastro.getPergunta(index).getD());
		opc4.setActionCommand(Cadastro.getPergunta(index).getD());
	}
}
