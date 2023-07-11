package Model;

public class Professor {
	
	private String id;
	private String nome;
	private Integer idade;
	private String disciplina;
	
	public Professor(String id, String nome, Integer idade, String disciplina) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.disciplina = disciplina;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	
}