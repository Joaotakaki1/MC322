import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Condutor {
    private final String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private Date dataNasc;
    private ArrayList<Sinistro> listaSinistros;

    

    public Condutor(String cpf, String nome, String endereco, String email, Date dataNasc, String telefone) {
        ArrayList<Sinistro> listaSinistros = new ArrayList<Sinistro>();
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.dataNasc = dataNasc;
        this.telefone = telefone;
        this.listaSinistros = listaSinistros;
    }

    //Getters
    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    //Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public boolean adicionarSinistro(Sinistro sinistro) {
        if (!listaSinistros.contains(sinistro)) {
            return listaSinistros.add(sinistro);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return "Condutor: " + nome + "\nCPF: " + cpf + "\nTelefone: " + telefone + "\nEndereco: " + endereco
                + "\nEmail: " + email + "\nData de Nascimento: " + formato.format(dataNasc) + "\nLista de Sinistros: " + listaSinistros;
    }
}

    

    