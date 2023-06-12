import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ClientePJ extends Cliente {
    private final String cnpj;
    private Date dataFundacao;
    private ArrayList<Frota> listaFrota;

    public ClientePJ(String nome, String endereco,String telefone, String cnpj, Date dataFundacao, String email) throws Exception {
                //String nome, String endereco, String email, String telefone
        super(nome, endereco, email, telefone);
        if (!Validacao.validaCNPJ(cnpj)) {
            throw new Exception("Cnpj Inválido");
        } else {
            this.cnpj = cnpj.replaceAll("[^0-9]", "");
        }
        ArrayList<Frota> listaFrota = new ArrayList<Frota>();
        this.dataFundacao = dataFundacao;
        this.listaFrota = listaFrota;
    }

    // Getters
    public String getCnpj() {
        return cnpj;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public ArrayList<Frota> getListaFrota() {
        return listaFrota;
    }
    // Setters

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public void setListaFrota (ArrayList<Frota> listaFrota){
        this.listaFrota = listaFrota;
    }

    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return super.toString() + "\nCNPJ: " + cnpj + "\nData de Fundação: " + formato.format(dataFundacao) + "\nLista de Frotas: " + listaFrota;
    }

    public boolean cadastrarFrota(Frota frota){
        // criar uma nova frota
        if (!listaFrota.contains(frota)){
            return listaFrota.add(frota);
        } else {
            return false;
        }
    }

    public boolean atualizarFrota(boolean add, boolean remove, boolean descadastrar, Veiculo veiculo, Frota frota){
        if (add){
            return (frota.getListaVeiculos().add(veiculo));
        } else if (remove){
            return frota.getListaVeiculos().remove(veiculo);
        } else if (descadastrar){
            return listaFrota.removeAll(listaFrota);
        }
        return false;
    }

    public boolean atualizarFrota(Frota frota){
        return listaFrota.remove(frota);
    }

    public ArrayList<Veiculo> getVeiculosPorFrota(Frota frota){
        ArrayList<Veiculo>listaVeiculo = new ArrayList<Veiculo>();
        for (Frota f : listaFrota){
            if (f.equals(frota)){
                for (Veiculo v : f.getListaVeiculos()){
                    listaVeiculo.add(v);
                }
            }
        }
        return listaVeiculo;
    }

}
