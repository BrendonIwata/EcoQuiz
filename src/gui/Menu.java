package gui;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Menu extends JFrame {
	
	private Image bImage;
	
	private JLabel nomeDoJogo;
	private JButton jogar;
	private JButton sair;
	private static JFrame frame;
	
	public Menu () {
		inicializarComponentes();
		definirEventos();
		setResizable(false);
	}
	
	private void inicializarComponentes () {
		setTitle("Eco Quiz");
		setBounds(0, 0, 300, 300);
		setLayout(null);
		
		nomeDoJogo = new JLabel("Eco Quiz");
		nomeDoJogo.setBounds(125, 10, 100, 20);
		jogar = new JButton("jogar");
		jogar.setBounds(100, 50, 100, 20);
		sair = new JButton("Sair");
		sair.setBounds(100, 80, 100, 20);
		
		add(nomeDoJogo);
		add(jogar);
		add(sair);
	}
	
	private void definirEventos () {
		jogar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				Game.abrir();
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
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Menu.abrir();
			}
		});
	}
	
	public static void abrir () {
		frame = new Menu();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((tela.width - frame.getSize().width) / 2, 
				(tela.height - frame.getSize().height) / 2);
		frame.setVisible(true);
	}
}
