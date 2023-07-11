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

public class CadastrarAluno extends JFrame {

	public CadastrarAluno() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1960, 1100);
		setVisible(true);
		//------------------------ CRIAÇÃO DO PAINEL ------------------------------
		JPanel painel = new JPanel();
		painel.setBackground(Color.black);
		add(painel);
		painel.setLayout(null);
		
		// ---------------------- TITULO ---------------------------------
		JLabel titulo = new JLabel ("Painel de cadastro do aluno: ");
		titulo.setBounds(800, 60, 480, 40);
		titulo.setForeground(Color.white);
		Font fonte = titulo.getFont();
		float tamanho = fonte.getSize2D() +20;
		titulo.setFont(fonte.deriveFont(tamanho));
		
		// ---------------------- NOME ----------------------------------------------
		JLabel nome = new JLabel("Nome:");
		nome.setBounds(900, 150, 180, 40);
		nome.setForeground(Color.white);
		JTextField nomeAluno = new JTextField();
		nomeAluno.setBounds(900, 180, 180, 40);
		
		// ---------------------- ID ------------------------------------------------
		JLabel id = new JLabel("ID:");
		id.setBounds(900, 230, 180, 40);
		id.setForeground(Color.white);
		JTextField idAluno = new JTextField();
		idAluno.setBounds(900, 260, 180, 40);
		
		// ---------------------- IDADE ----------------------------------------------
		JLabel idade = new JLabel("Idade:");
		idade.setBounds(900, 310, 180, 40);
		idade.setForeground(Color.white);
		JTextField idadeAluno = new JTextField();
		idadeAluno.setBounds(900, 340, 180, 40);
		
		
		// ----------------------- CURSO --------------------------------------------
		JLabel curso = new JLabel("Curso: ");
		curso.setBounds(900, 390, 180, 40);
		curso.setForeground(Color.white);
		JTextField cursoAluno = new JTextField();
		cursoAluno.setBounds(900, 420, 180, 40);
		
		
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
	            	
	                String nome = nomeAluno.getText();
	                String id = idAluno.getText();
	                Integer idade = Integer.parseInt(idadeAluno.getText());
	              
	                String curso = cursoAluno.getText();
	         

	                // Cria a instância do Aluno com os valores capturados
	               Aluno aluno = new Aluno(id, nome, idade, curso);
	               
	               try {
	                    escreverDadosEmArquivo(aluno);
	                    JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso");
	                   
	                } catch (IOException ex) {
	                    JOptionPane.showMessageDialog(null, "Erro ao gravar os dados do aluno em arquivo.");
	                }
	            }
	        });
		 voltar.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent x) {
				// Fecha a janela atual
			        // Cria uma nova instância do objeto que contém o botão "Voltar"
			        PainelInicial voltarMenu = new PainelInicial();
			        voltarMenu.setExtendedState(JFrame.MAXIMIZED_BOTH); // Define a janela como maximizada
			        voltarMenu.setResizable(false); // Impede o redimensionamento da janela
			        voltarMenu.setVisible(true); // Torna a janela visível
			        dispose(); 
			       
			 }
		 });
		 
		
		painel.add(nomeAluno);
		painel.add(nome);
		painel.add(titulo);
		painel.add(id);
		painel.add(idAluno);
		painel.add(idade);
		painel.add(idadeAluno);
		painel.add(curso);
		painel.add(cursoAluno);
		painel.add(confirmar);
		painel.add(voltar);
		
	}
	private void escreverDadosEmArquivo(Aluno aluno) throws IOException {
        String nomeArquivo = "c:\\Temp\\dados-alunos.txt";
        // Cria o objeto FileWriter para escrever no arquivo
        FileWriter fileWriter = new FileWriter(nomeArquivo, true);

        // Cria o objeto BufferedWriter para escrever os dados
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        // Escreve os dados no arquivo
        bufferedWriter.write("Nome: " + aluno.getNomeAluno());
        bufferedWriter.newLine();
        bufferedWriter.write("ID: " + aluno.getIdadeAluno());
        bufferedWriter.newLine();
        bufferedWriter.write("Idade: " + aluno.getIdadeAluno());
        bufferedWriter.newLine();
        bufferedWriter.write("Curso: " + aluno.getCurso());
        bufferedWriter.newLine();
        bufferedWriter.newLine();

        // Fecha o BufferedWriter e o FileWriter
        bufferedWriter.close();
        fileWriter.close();
    }
}
