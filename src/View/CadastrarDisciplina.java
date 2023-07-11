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

import Model.Disciplina;
import Model.Professor;

public class CadastrarDisciplina extends JFrame {
	
	public CadastrarDisciplina() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1960, 1100);
		setVisible(true);
		//------------------------ CRIAÇÃO DO PAINEL ------------------------------
		JPanel painel = new JPanel();
		painel.setBackground(Color.black);
		add(painel);
		painel.setLayout(null);
		
		// ---------------------- BOTÕES E CAMPOS ---------------------------------
		JLabel titulo = new JLabel ("Painel de cadastro da disciplina: ");
		titulo.setBounds(800, 60, 580, 40);
		titulo.setForeground(Color.white);
		Font fonte = titulo.getFont();
		float tamanho = fonte.getSize2D() +20;
		titulo.setFont(fonte.deriveFont(tamanho));
		
		// ---------------------- NOME ----------------------------------------------
		JLabel nome = new JLabel("Nome:");
		nome.setBounds(900, 150, 180, 40);
		nome.setForeground(Color.white);
		JTextField nomeDisciplina = new JTextField();
		nomeDisciplina.setBounds(900, 180, 180, 40);
		
		// ---------------------- ID ------------------------------------------------
		JLabel id = new JLabel("ID:");
		id.setBounds(900, 230, 180, 40);
		id.setForeground(Color.white);
		JTextField idDisciplina = new JTextField();
		idDisciplina.setBounds(900, 260, 180, 40);
		
		// ---------------------- DEPARTAMENTO ----------------------------------------------
		JLabel departamento = new JLabel("Departamento:");
		departamento.setBounds(900, 310, 180, 40);
		departamento.setForeground(Color.white);
		JTextField deptProfessor = new JTextField();
		deptProfessor.setBounds(900, 340, 180, 40);
		
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
	            	
	                String nome = nomeDisciplina.getText();
	                String id = idDisciplina.getText();
	                String departamento = deptProfessor.getText();
	         
	                // Cria a instância do professor com os valores capturados
	                Disciplina disciplina = new Disciplina(nome, departamento, id);
	               
	                try {
	                    escreverDadosEmArquivo(disciplina);
	                    JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso");
	                  
	                    
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
		 
		
		painel.add(nomeDisciplina);
		painel.add(nome);
		painel.add(titulo);
		painel.add(id);
		painel.add(idDisciplina);
		painel.add(departamento);
		painel.add(deptProfessor);
		painel.add(confirmar);
		painel.add(voltar);
		
	}
	private void escreverDadosEmArquivo(Disciplina disciplina) throws IOException {
        String nomeArquivo = "c:\\Temp\\dados-disciplina.txt";
        // Cria o objeto FileWriter para escrever no arquivo
        FileWriter fileWriter = new FileWriter(nomeArquivo, true);

        // Cria o objeto BufferedWriter para escrever os dados
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        // Escreve os dados no arquivo
        bufferedWriter.write("Nome: " + disciplina.getNome());
        bufferedWriter.newLine();
        bufferedWriter.write("ID: " + disciplina.getId());
        bufferedWriter.newLine();
        bufferedWriter.write("Departamento: " + disciplina.getDepartamento());
        bufferedWriter.newLine();
        bufferedWriter.newLine();

        // Fecha o BufferedWriter e o FileWriter
        bufferedWriter.close();
        fileWriter.close();
    }

	


}
