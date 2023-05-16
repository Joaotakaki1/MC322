import java.util.ArrayList;

public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private ArrayList<Sinistro> listaSinistros;
	private ArrayList<Cliente> listaClientes;

	// Contrutor
	public Seguradora(String nome, String telefone, String email, String endereco) {
		ArrayList<Sinistro> listaSinistros = new ArrayList<Sinistro>();
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaSinistros = listaSinistros;
		this.listaClientes = listaClientes;
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

	public ArrayList<Sinistro> getListaSinistros() {
		return listaSinistros;
	}

	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	// Setters
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	@Override
	public String toString() {
		return "Seguradora [nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", endereco=" + endereco
				+ ", listaSinistros=" + listaSinistros + ", listaClientes=" + listaClientes + "]";
	}

	public boolean cadastrarCliente(Cliente cliente) {
		if (!listaClientes.contains(cliente)) {
			return listaClientes.add(cliente);
		} else {
			return false;
		}
	}

	public void listarClientes() {
		if (listaClientes.size() != 0) {
			for (Cliente c : listaClientes)
				System.out.println(c);
		} else {
			System.out.println("Nenhum cliente cadastrado!");
		}
	}

	public boolean removeCliente(String c) {
		if (listaClientes.size() == 0) {
			System.out.println("Não há cleintes cadastrados");
			return false;
		}
		/// CPF
		for (Cliente cliente : listaClientes) {
			try {
				if ((((ClientePF) cliente).getCpf()).equals(c)) {
					for (Sinistro sinistro : listaSinistros) {
						if (sinistro.getCliente() == (cliente))
							listaSinistros.remove(sinistro);
					}
					return listaClientes.remove(cliente);
				}
			} catch (Exception e) {
				if ((((ClientePJ) cliente).getCnpj()).equals(c)) {
					for (Sinistro sinistro : listaSinistros) {
						if (sinistro.getCliente() == (cliente))
							listaSinistros.remove(sinistro);
					}
					return listaClientes.remove(cliente);
				}
			}
		}
		return false;
	}

	public boolean gerarSinistro(Sinistro sinistro) {
		if (listaSinistros.contains(sinistro))
			return false;
		else {
			return listaSinistros.add(sinistro);
		}
	}

	public boolean vizualizarSinistro(int id) {
		for (Sinistro s : listaSinistros) {
			if (s.getId() == id)
				return true;
		}
		return false;
	}

	public boolean removeSinistro(Sinistro sinistro) {
		if (listaSinistros.contains(sinistro)) {
			return listaSinistros.remove(sinistro);
		} else {
			return false;
		}
	}

	public void listarSinistros() {
		if (listaSinistros.size() != 0) {
			for (Sinistro s : listaSinistros)
				System.out.println(s);
		} else {
			System.out.println("Nenhum sinistro gerado!");
		}
	}

	public double calcularPrecoSeguroCliente(Cliente cliente) {
		int contador = 0;
		double seguro = 0;
		for (Sinistro s : listaSinistros) {
			if (s.getCliente().equals(cliente))
				contador++;
		}
		seguro = (cliente.calculaScore() * (1 + contador));
		cliente.setValorSeguro(seguro);
		return seguro;
	}

	public int calcularReceita() {
		int receita = 0;
		for (Cliente cliente : listaClientes) {
			receita += cliente.getValorSeguro();
		}
		return receita;
	}

	public void transferirSeguro(Cliente cliente1, Cliente cliente2) {
		/// Cliente 1 transferiá todos os veículos para o cliente 2
		for (Veiculo v : cliente1.getListaVeiculos()) {
			cliente2.getListaVeiculos().add(v);
		}
		cliente1.getListaVeiculos().clear();
	}

}
