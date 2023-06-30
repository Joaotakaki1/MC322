public abstract class Cliente {
	private String nome;
	private String telefone;
	private String endereco;
	private String email;

	// Construtor
	public Cliente(String nome, String endereco, String email, String telefone) throws Exception {
		// if (Validacao.validaNome(nome)) {
		// 	this.nome = nome;
		// } else {
		// 	throw new Exception("Nome inválido!");
		// }
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
	}

	// Getters
	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getEndereco() {
		return endereco;
	}

	// Setters
	public void setEmail (String email){
		this.email = email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public String toString() {
		return "Cliente:" + nome + "\nEndereco: " + endereco + "\nTelefone: " + telefone + "\nEmail: " + email;
	}
}