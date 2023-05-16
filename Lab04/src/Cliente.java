import java.util.ArrayList;

public class Cliente {
	private String nome;
	private String endereco;
	private ArrayList<Veiculo> listaVeiculos;
	private double valorSeguro;

	// Construtor
	public Cliente(String nome, String endereco, double valorSeguro) throws Exception {
		ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
		if (Validacao.validaNome(nome)) {
			this.nome = nome;
		} else {
			throw new Exception("Nome inválido!");
		}
		this.endereco = endereco;
		this.listaVeiculos = listaVeiculos;
		this.valorSeguro = valorSeguro;
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

	public double getValorSeguro() {
		return valorSeguro;
	}

	public Veiculo getVeiculo(String placa) {
		for (Veiculo v : listaVeiculos) {
			if (v.getPlaca().equals(placa)) {
				return v;
			}
		}
		return null;
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

	public void setValorSeguro(double valorSeguro) {
		this.valorSeguro = valorSeguro;
	}

	public String toString() {
		return "Cliente=" + nome + ", endereco=" + (endereco)
				+ ", listaVeiculos="
				+ listaVeiculos + valorSeguro + "]";
	}

	public boolean adicionaVeiculo(Veiculo a) {
		if (!listaVeiculos.contains(a)) {
			return listaVeiculos.add(a);
		} else {
			return false;
		}
	}

	public boolean removeVeiculo(Veiculo a) {
		if (listaVeiculos.contains(a)) {
			return listaVeiculos.remove(a);
		} else {
			return false;
		}
	}

	public double calculaScore() {
		return 0;
	}

	public void listarVeiculos() {
		for (Veiculo a : listaVeiculos)
			System.out.println(a);
	}
}
