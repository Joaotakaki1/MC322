import java.util.ArrayList;
import java.util.Date;

public class Seguradora {
	private final String cnpj;
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private ArrayList<Seguro> listaSeguros;
	private ArrayList<Cliente> listaClientes;

	// Contrutor
	public Seguradora(String cnpj, String nome, String telefone, String email, String endereco) throws Exception {
		ArrayList<Seguro> listaSeguros = new ArrayList<Seguro>();
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		if (!Validacao.validaCNPJ(cnpj)) {
            throw new Exception("Cnpj Inválido");
        } else {
            this.cnpj = cnpj.replaceAll("[^0-9]", "");
        }
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaSeguros = listaSeguros;
		this.listaClientes = listaClientes;
	}

	// Getters
	public String getCnpj(){
		return cnpj;
	}
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

	public ArrayList<Seguro> getListaSeguros() {
		return listaSeguros;
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

	public void setListaSeguros(ArrayList<Seguro> listaSeguros) {
		this.listaSeguros = listaSeguros;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	@Override
	public String toString() {
		return "Seguradora: " + nome + "\nCNPJ: " + cnpj + "\nTelefone: " + telefone + "\nEmail: " + email + "\nEndereco: " + endereco
				+ "\nListade Seguros: " + listaSeguros + "\nLista de Clientes: " + listaClientes;
	}

	public void listarClientes() {
		if (listaClientes.size() != 0) {
			for (Cliente c : listaClientes)
				System.out.println(c);
		} else {
			System.out.println("Nenhum cliente cadastrado!");
		}
	}

	public boolean gerarSeguro(ClientePJ cliente, Date dataInicio, Date dataFim, Frota frota, Seguradora seguradora){
		SeguroPJ seguro = new SeguroPJ(dataInicio, dataFim, seguradora,frota, cliente);
		return listaSeguros.add(seguro);
	}

	public boolean gerarSeguro(ClientePF cliente, Date dataInicio, Date dataFim, Veiculo veiculo, Seguradora seguradora){
		SeguroPF seguro = new SeguroPF(dataInicio, dataFim, seguradora, veiculo, cliente);
		return listaSeguros.add(seguro);
	}

	public boolean cancelarSeguro(SeguroPF seguro ){
		if (listaSeguros.contains(seguro)){
			return listaSeguros.remove(seguro);
		} else {
			return false;
		}
	}
	public boolean cancelarSeguro(SeguroPJ seguro){
		if (listaSeguros.contains(seguro)){
			return listaSeguros.remove(seguro);
		} else {
			return false;
		}
	}

	public boolean cadastrarCliente(Cliente cliente) {
		if (!listaClientes.contains(cliente)) {
			return listaClientes.add(cliente);
		} else {
			return false;
		}
	}

	public boolean removeCliente(String c) {
		if (listaClientes.size() == 0) {
			System.out.println("Não há cleintes cadastrados");
			return false;
		}
		for (Seguro s : listaSeguros) { 
			try {
				if ((((SeguroPF) s).getCliente().getCpf()).equals(c)) {
					listaSeguros.remove(s);
				}
			} catch (Exception e) {
				if ((((SeguroPJ) s).getClientePJ().getCnpj()).equals(c)) {
					listaSeguros.remove(s);
				}
			}
		}
		for (Cliente cliente : listaClientes){
			try{
				if (((ClientePF)cliente).getCpf().equals(c)){
					return listaClientes.remove(cliente);
				}
			} catch (Exception e){
				if (((ClientePJ)cliente).getCnpj().equals(c)){
					return listaClientes.remove(cliente);
				}
			}
		}
		return false;
	}


	public int calcularReceita() {
		int receita = 0;
		for (Seguro s : listaSeguros) {
			receita += s.getValorMensal();
		}
		return receita;
	}

	public ArrayList<SeguroPF> getSeguroPorCliente(ClientePF cliente){
		ArrayList<SeguroPF> segurosCliente = new ArrayList<SeguroPF>();
		for (Seguro s : listaSeguros){
			if (s instanceof SeguroPF || ((SeguroPF) s).getCliente() instanceof ClientePF){
				if (((SeguroPF) s).getCliente().equals(cliente)){
					segurosCliente.add(((SeguroPF) s));
				}
			}
		}
		return segurosCliente;
	}

	public ArrayList<SeguroPJ> getSeguroPorCliente(ClientePJ cliente){
		ArrayList<SeguroPJ> segurosCliente = new ArrayList<SeguroPJ>();
		for (Seguro s : listaSeguros){
			if (s instanceof SeguroPJ || ((SeguroPJ) s).getClientePJ() instanceof ClientePJ){
				if (((SeguroPJ) s).getClientePJ().equals(cliente)){
					segurosCliente.add(((SeguroPJ) s));
				}
			}
		}
		return segurosCliente;
	}

	public ArrayList<Sinistro> getSinistroPorCliente(ClientePF cliente){
		ArrayList<Sinistro> sinistrosCliente = new ArrayList<Sinistro>();
		for (Seguro s : listaSeguros){
			try{
				if (((SeguroPF) s).getCliente() instanceof ClientePF){
						sinistrosCliente.addAll(0, s.getListaSinistros());
				}
			}catch (Exception e){
			}
		}
		return sinistrosCliente;
	}

	public ArrayList<Sinistro> getSinistroPorCliente(ClientePJ cliente){
		ArrayList<Sinistro> sinistrosCliente = new ArrayList<Sinistro>();
		for (Seguro s : listaSeguros){
			try{
				if (((SeguroPJ) s).getClientePJ() instanceof ClientePJ){
						sinistrosCliente.addAll(0, s.getListaSinistros());
					}
			}catch (Exception e){
			}
		}
		return sinistrosCliente;
	}
}
