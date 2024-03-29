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

	public boolean cadastrarCliente(Cliente cliente) {
		if (!listaClientes.contains(cliente)) {
			return listaClientes.add(cliente);
		} else {
			return false;
		}
	}

	public void listarClientes() {
		for (Cliente c : listaClientes)
			System.out.println(c);
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
		else
			return listaSinistros.add(sinistro);
	}

	public boolean vizualizarSinistro(int id) {
		for (Sinistro s : listaSinistros) {
			if (s.getId() == id)
				return true;
		}
		return false;
	}

	public void listarSinistros() {
		for (Sinistro s : listaSinistros)
			System.out.println(s.toString());
	}
	
	@Override
	public String toString() {
		return "Seguradora [nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", endereco=" + endereco
				+ ", listaSinistros=" + listaSinistros + ", listaClientes=" + listaClientes + "]";
	}
}
