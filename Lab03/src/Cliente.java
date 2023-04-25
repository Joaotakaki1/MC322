import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Cliente {
	private String nome;
	private String endereco;
	private ArrayList<Veiculo> listaVeiculos;

	// Construtor
	public Cliente(String nome, String endereco) {
		ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
		this.nome = nome;
		this.endereco = endereco;
		this.listaVeiculos = listaVeiculos;
	}

	// Getters
	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public ArrayList<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}

	// Setters
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}

	public String toString() {
		return "Cliente=" + nome + ", endereco=" + (endereco)
				+ ", listaVeiculos="
				+ listaVeiculos + "]";
	}

	// Validacao de cpf
	public boolean verificaDigitosIguais(String cpf) {
		int n = cpf.length();
		char inicial = cpf.charAt(0);
		for (int i = 1; i < n; i++) {
			if (cpf.charAt(i) != inicial) {
				return false;
			}
		}
		return true;
	}

	public boolean adicionaVeiculo(Veiculo a) {
		if (!listaVeiculos.contains(a)) {
			return listaVeiculos.add(a);
		} else {
			return false;
		}
	}
}
