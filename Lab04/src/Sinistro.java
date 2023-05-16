import java.util.Date;
import java.util.ArrayList;
import java.util.Random;

public class Sinistro {
	private Date data;
	private String endereco;
	private final int id;
	private static ArrayList<Integer> ids = new ArrayList<Integer>();
	private Seguradora seguradora;
	private Veiculo veiculo;
	private Cliente cliente;

	// Construtor
	public Sinistro(Date data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
		Random gerador = new Random();
		int ver = 0;
		do {
			ver = gerador.nextInt();
		} while (ids.contains(ver));
		ids.add(ver);
		this.data = data;
		this.id = ver;
		this.endereco = endereco;
		this.seguradora = seguradora;
		this.veiculo = veiculo;
		this.cliente = cliente;
	}

	// Getters
	public Date getData() {
		return data;
	}

	public String getEndereco() {
		return endereco;
	}

	public int getId() {
		return id;
	}

	public Seguradora getSeguradora() {
		return seguradora;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	// Setters
	public void setData(Date data) {
		this.data = data;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Sinistro [data=" + data + ", endereco=" + endereco + ", id=" + id + ", seguradora="
				+ seguradora.getNome()
				+ ", veiculo=" + veiculo + ", cliente=" + cliente + "]";
	}

}
