public class Cliente {
	private String nome;
	private String cpf;
	private String dataNascimento;
	private String endereco;
	private int idade;

	// Construtor
	public Cliente (String nome, String cpf, String dataNascimento, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento =dataNascimento;
		this.endereco = endereco;
		this.idade = idade;
	}
	
	//Getters
	public String getNome(){
		return nome;
	}
	
	public String getCpf(){
		return cpf;
		
	}public String getDataNascimento(){
		return dataNascimento;
	}
	
	public String getEndereco(){
		return endereco;
	}
	
	public int getIdade () {
		return idade;
	}
	
	//Setters
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	public void setIdade (int idade) {
		this.idade = idade;
	}
	
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", endereco="
				+ endereco + ", idade=" + idade + "]";
	}
	
	//Validacao de cpf
	public boolean verificaDigitosIguais (String cpf) {
		int n = cpf.length();
		char inicial = cpf.charAt(0);
		for (int i = 1; i < n; i++) {
			if (cpf.charAt(i) != inicial) {
				return false;
			}
		}
		return true;
	}
	
	public boolean validaCPF(String cpf) {
		String cpfNumerico = cpf.replaceAll("[^0-9]","" );
		System.out.println(cpfNumerico);
		if (cpfNumerico.length() == 11){
			if (verificaDigitosIguais (cpfNumerico)) {
				return false;
			} else {
				int primeiroVerificador = 0;
				int multiplicador = 2;
				for (int i = 8; i >= 0; i--) {
					primeiroVerificador += Character.digit(cpfNumerico.charAt(i),10) * multiplicador;
					multiplicador++;
				}
				if (primeiroVerificador % 11 < 2) {
					primeiroVerificador = 0;
				} else {
					primeiroVerificador = 11 - (primeiroVerificador % 11);
				}
				if (primeiroVerificador == Character.digit(cpfNumerico.charAt(9),10)) {
					int segundoVerificador = 0;
					int multiplicador2 = 2;
					for (int j = 9; j >= 0; j--) {
						segundoVerificador += Character.digit(cpfNumerico.charAt(j),10) * multiplicador2;
						multiplicador2++;
					}
					if (segundoVerificador % 11 < 2) {
						segundoVerificador = 0;
					} else {
						segundoVerificador = 11 - (segundoVerificador % 11);
					}
					if (segundoVerificador == Character.digit(cpfNumerico.charAt(10),10)) {
						return true;
					} else {
						return false;
						}
					
				} else {
					return false;
				}	
			}
		} else {
			return false;
		}
	}
}
