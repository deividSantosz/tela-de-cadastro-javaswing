package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Aluno;
import Model.Professor;

public class CadastrarProfessor extends JFrame {
	
	public CadastrarProfessor() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1960, 1100);
		setVisible(true);
		//------------------------ CRIAÇÃO DO PAINEL ------------------------------
		JPanel painel = new JPanel();
		painel.setBackground(Color.black);
		add(painel);
		painel.setLayout(null);
		
		// ---------------------- TITULO ---------------------------------
		JLabel titulo = new JLabel ("Painel de cadastro do professor: ");
		titulo.setBounds(800, 60, 580, 40);
		titulo.setForeground(Color.white);
		Font fonte = titulo.getFont();
		float tamanho = fonte.getSize2D() +20;
		titulo.setFont(fonte.deriveFont(tamanho));
		
		// ---------------------- NOME ----------------------------------------------
		JLabel nome = new JLabel("Nome:");
		nome.setBounds(900, 150, 180, 40);
		nome.setForeground(Color.white);
		JTextField nomeProfessor = new JTextField();
		nomeProfessor.setBounds(900, 180, 180, 40);
		
		// ---------------------- ID ------------------------------------------------
		JLabel id = new JLabel("ID:");
		id.setBounds(900, 230, 180, 40);
		id.setForeground(Color.white);
		JTextField idProfessor = new JTextField();
		idProfessor.setBounds(900, 260, 180, 40);
		
		// ---------------------- IDADE ----------------------------------------------
		JLabel idade = new JLabel("Idade:");
		idade.setBounds(900, 310, 180, 40);
		idade.setForeground(Color.white);
		JTextField idadeProfessor = new JTextField();
		idadeProfessor.setBounds(900, 340, 180, 40);
		
		
		// ----------------------- DISCIPLINA --------------------------------------------
		JLabel disciplina = new JLabel("Disciplina: ");
		disciplina.setBounds(900, 390, 180, 40);
		disciplina.setForeground(Color.white);
		JTextField disciplinaProfessor = new JTextField();
		disciplinaProfessor.setBounds(900, 420, 180, 40);
		
		
		// ----------------------- BOTÕES --------------------------------------------
		JButton confirmar = new JButton("Confirmar");
		confirmar.setBounds(1300, 800, 180, 50);
		JButton voltar = new JButton ("Voltar");
		voltar.setBounds(500, 800, 180, 50);
		
		// ---------------------- EVENTOS DOS BOTÕES ---------------------------------
		
		 confirmar.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Captura os valores dos campos de texto
	            	
	                String nome = nomeProfessor.getText();
	                String id = idProfessor.getText();
	                Integer idade = Integer.parseInt(idadeProfessor.getText());
	                String disciplina = disciplinaProfessor.getText();
	         
	                // Cria a instância do professor com os valores capturados
	                Professor professor = new Professor(id, nome, idade, disciplina);
	               
	               try {
	                    escreverDadosEmArquivo(professor);
	                    JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso");
	                  
	                    
	                } catch (IOException ex) {
	                    JOptionPane.showMessageDialog(null, "Erro ao gravar os dados do aluno em arquivo.");
	                }
	            }
	        });
		 
		 voltar.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent x) {
				
			        // Cria uma nova instância do objeto que contém o botão "Voltar"
			        PainelInicial voltarMenu = new PainelInicial();
			        voltarMenu.setExtendedState(JFrame.MAXIMIZED_BOTH); // Define a janela como maximizada
			        voltarMenu.setResizable(false); // Impede o redimensionamento da janela
			        voltarMenu.setVisible(true); // Torna a janela visível
			        dispose(); // Fecha a janela atual
			       
			 }
		 });
		 
		
		painel.add(nomeProfessor);
		painel.add(nome);
		painel.add(titulo);
		painel.add(id);
		painel.add(idProfessor);
		painel.add(idade);
		painel.add(idadeProfessor);
		painel.add(disciplina);
		painel.add(disciplinaProfessor);
		painel.add(confirmar);
		painel.add(voltar);
		
	}
	private void escreverDadosEmArquivo(Professor professor) throws IOException {
        String nomeArquivo = "c:\\Temp\\dados-professor.txt";
        // Cria o objeto FileWriter para escrever no arquivo
        FileWriter fileWriter = new FileWriter(nomeArquivo, true);

        // Cria o objeto BufferedWriter para escrever os dados
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        // Escreve os dados no arquivo
        bufferedWriter.write("Nome: " + professor.getNome());
        bufferedWriter.newLine();
        bufferedWriter.write("ID: " + professor.getId());
        bufferedWriter.newLine();
        bufferedWriter.write("Idade: " + professor.getIdade());
        bufferedWriter.newLine();
        bufferedWriter.write("Disciplina: " + professor.getDisciplina());
        bufferedWriter.newLine();
        bufferedWriter.newLine();

        // Fecha o BufferedWriter e o FileWriter
        bufferedWriter.close();
        fileWriter.close();
    }

	
}
