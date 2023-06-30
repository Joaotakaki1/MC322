import java.text.SimpleDateFormat;

public class Veiculo {
	private String placa;
	private String marca;
	private String modelo;
	private int anoFabricacao;

	// Construtor
	public Veiculo(String placa, String marca, String modelo, int anoFabricacao) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
	}

	// Getters
	public String getPlaca() {
		return placa;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	// Setters
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	@Override
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		return "Veiculo\nPlaca: " + placa + "\nMarca: " + marca + "\nModelo: " + modelo + "\nAno de Fabricacao: "
				+ formato.format(anoFabricacao);
	}

}
