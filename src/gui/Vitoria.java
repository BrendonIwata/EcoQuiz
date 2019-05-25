package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Vitoria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel vitoria;
	private JButton sair;
	private JButton menu;
	private static JFrame frame;
	
	public Vitoria () {
		inicializarComponentes();
		definirEventos();
	}
	
	private void inicializarComponentes () {
		setLayout(null);
		setTitle("Eco Quiz");
		setBounds(0, 0, 300, 300);
		setResizable(false);
		
		vitoria = new JLabel("Parabéns voce venceu");
		vitoria.setBounds(75, 10, 250, 20);
		sair = new JButton("sair");
		sair.setBounds(95, 80, 100, 20);
		menu = new JButton("menu");
		menu.setBounds(95, 50, 100, 20);
		add(vitoria);
		add(sair);
		add(menu);
	}
	
	private void definirEventos () {
		menu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				Menu.abrir();
			}
		});
		
		sair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
	
	public static void abrir() {
		frame = new Vitoria();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((tela.width - frame.getSize().width) / 2, (tela.height - frame.getSize().height) / 2);
		frame.setVisible(true);
	}
}
