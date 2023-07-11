package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelInicial extends JFrame {

	public PainelInicial() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1920, 1080);
		setTitle("Cadastro UESB");

		// ------------------- CRIAÇÃO DO PAINEL ------------------
		JPanel painel = new JPanel();
		painel.setBackground(Color.black);
		add(painel);
		painel.setLayout(null);
		getContentPane().add(painel);
		
		// -------------------- CRIAÇÃO DOS BOTÕES DE CADASTRO -------------------
		JButton cadastroProfessor = new JButton("Cadastrar Professor");
		cadastroProfessor.setBounds(1600, 300, 200, 70);
		painel.add(cadastroProfessor);
		
		JButton cadastroAluno = new JButton("Cadastrar Aluno");
		cadastroAluno.setBounds(1600, 700, 200, 70);
		painel.add(cadastroAluno);
		
		JButton cadastroDisciplina = new JButton ("Cadastrar Disciplina");
		cadastroDisciplina.setBounds(1600, 500, 200, 70);
		painel.add(cadastroDisciplina);
		
		// ---------------------------- TEXTOS -----------------------------------
		JLabel texto = new JLabel("Desenvolvido por Deivid Santos");
		texto.setBounds(850, 950, 200, 90);
		texto.setForeground(Color.white);
		painel.add(texto);
	
		
		JLabel UESB = new JLabel("Universidade Estadual do Sudoeste Da Bahia");
		UESB.setBounds(500, 400, 500, 200);
		UESB.setForeground(Color.white);
		painel.add(UESB);
		Font fonte = UESB.getFont();
		float tamanho = fonte.getSize2D() +10;
		UESB.setFont(fonte.deriveFont(tamanho));
		/*ImageIcon imagemUESB = new ImageIcon("C:\\Users\\deivi\\Documents\\faculdade\\LPII\\logo-uesb.png");
		int largura = 300;
        int altura = 200;
		Image image = imagemUESB.getImage();
		Image imagemRedimensionada = image.getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
		JLabel Imagemuesb = new JLabel(new ImageIcon (imagemRedimensionada));
		
		painel.add(Imagemuesb);*/
		
		setVisible(true);
		
		
		// ----------------------------- EVENTOS DOS BOTÕES -------------------------
		cadastroAluno.addActionListener(new ActionListener() {
		    @Override
			 public void actionPerformed(ActionEvent x) {
				// Fecha a janela atual
			        // Cria uma nova instância do objeto que contém o botão "Voltar"
			        CadastrarAluno cadastroAluno = new CadastrarAluno();
			        cadastroAluno.setExtendedState(JFrame.MAXIMIZED_BOTH); // Define a janela como maximizada
			        cadastroAluno.setResizable(false); // Impede o redimensionamento da janela
			        cadastroAluno.setVisible(true); // Torna a janela visível
			        dispose(); 
			       
			 }
		 });
		
		cadastroProfessor.addActionListener(new ActionListener() {
		    @Override
			 public void actionPerformed(ActionEvent x) {
				
			        // Cria uma nova instância do objeto que contém o botão "Voltar"
			        CadastrarProfessor cadastroProfessor = new CadastrarProfessor();
			        cadastroProfessor.setExtendedState(JFrame.MAXIMIZED_BOTH); // Define a janela como maximizada
			        cadastroProfessor.setResizable(false); // Impede o redimensionamento da janela
			        cadastroAluno.setVisible(true); // Torna a janela visível
			        dispose(); 
			       
			 }
		 });
		cadastroDisciplina.addActionListener(new ActionListener() {
		    @Override
			 public void actionPerformed(ActionEvent x) {
				
			        // Cria uma nova instância do objeto que contém o botão "Voltar"
			        CadastrarDisciplina cadastroDisciplina = new CadastrarDisciplina();
			        cadastroDisciplina.setExtendedState(JFrame.MAXIMIZED_BOTH); // Define a janela como maximizada
			        cadastroDisciplina.setResizable(false); // Impede o redimensionamento da janela
			        cadastroAluno.setVisible(true); // Torna a janela visível
			        dispose(); 
			       
			 }
		 });
	}

	}

