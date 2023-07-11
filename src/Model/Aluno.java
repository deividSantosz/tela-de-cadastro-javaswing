package Model;

public class Aluno {
	
	private String idAluno;
	private String nomeAluno;
	private Integer idadeAluno;
	private String curso;

	

	
	public Aluno(String idAluno, String nomeAluno, Integer idadeAluno, String curso) {
		this.idAluno = idAluno;
		this.nomeAluno = nomeAluno;
		this.idadeAluno = idadeAluno;
		this.curso = curso;
	
	}


	public String getIdAluno() {
		return idAluno;
	}


	public void setIdAluno(String idAluno) {
		this.idAluno = idAluno;
	}


	public String getNomeAluno() {
		return nomeAluno;
	}


	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}


	public Integer getIdadeAluno() {
		return idadeAluno;
	}


	public void setIdadeAluno(Integer idadeAluno) {
		this.idadeAluno = idadeAluno;
	}



	public String getCurso() {
		return curso;
	}


	public void setCurso(String curso) {
		this.curso = curso;
	}


	
}
