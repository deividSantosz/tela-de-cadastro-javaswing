package Model;

public class Disciplina {
	private String nome;
	private String departamento;
	private String id;
	
	public Disciplina(String nome, String departamento, String id) {
		this.nome = nome;
		this.departamento = departamento;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
