import java.util.ArrayList;
import java.util.Random;

public class Sinistro {
	private String data;
	private String endereco;
	private final int id;
	private Seguradora seguradora;
	private Veiculo veiculo;
	private Cliente cliente;

	// Construtor
	public Sinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
		Random gerador = new Random();
		int ver = gerador.nextInt();
		try {
			for (Sinistro i : seguradora.getListaSinistros()) {
				if (i.id == ver)
					throw new Exception();
			}
		} catch (Exception ex) {
			ArrayList<Integer> ids = new ArrayList<Integer>();
			for (Sinistro i : seguradora.getListaSinistros()) {
				ids.add(i.id);
			}
			while (ids.contains(ver)) {
				ver = gerador.nextInt();
			}
		}
		this.data = data;
		this.id = ver;
		this.endereco = endereco;
		this.seguradora = seguradora;
		this.veiculo = veiculo;
		this.cliente = cliente;
	}

	// Getters
	public String getData() {
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
	public void setData(String data) {
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
