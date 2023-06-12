import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ClientePF extends Cliente {
    private final String cpf;
    private Date dataNascimento;
    private String genero;
    private String educacao;
    private ArrayList<Veiculo> listaVeiculos;

    public ClientePF(String nome, String endereco, String educacao, String genero, String cpf, Date dataNascimento, String email, String telefone) throws Exception {
        super(nome, endereco, email, telefone);
        ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
        if (Validacao.validaCPF(cpf)) {
            this.cpf = cpf.replaceAll("[^0-9]", "");
        } else {
            throw new Exception("Cpf Inválido");
        }
        this.genero = genero;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.listaVeiculos = listaVeiculos;
    }

    // Getters
    public String getCpf() {
        return cpf;
    }

    public Date getDataNacimento() {
        return dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public String getEducacao() {
        return educacao;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }
    // Setters

    public void setDataNacimento(Date dataNacimento) {
        this.dataNascimento = dataNacimento;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return super.toString() + "\nCPF: " + cpf + "\nData de Nascimento: "
                + formato.format(dataNascimento)
                + "\nGenero: "
                + genero + "\nEducacao: " + educacao 
                + "\nLista Veiculos: " + listaVeiculos;
    }

    public boolean cadastrarVeiculo (Veiculo veiculo){
        if (!listaVeiculos.contains(veiculo)){
            return listaVeiculos.add(veiculo);
        } else{
            return false;
        }
    }
    public boolean removerVeiculo (Veiculo veiculo){
        if (listaVeiculos.contains(veiculo)){
            return listaVeiculos.remove(veiculo);
        } else{
            return false;
        }
    }


}
