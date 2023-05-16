import java.util.Date;
import java.text.SimpleDateFormat;

public class ClientePJ extends Cliente {
    private final String cnpj;
    private Date dataFundacao;
    private int qntFuncionarios;

    public ClientePJ(String nome, String endereco, String cnpj, Date dataFundacao, int qntFuncionarios,
            int valorSeguro) throws Exception {
        super(nome, endereco, valorSeguro);
        if (!Validacao.validaCNPJ(cnpj)) {
            throw new Exception("Cnpj Inválido");
        } else {
            this.cnpj = cnpj.replaceAll("[^0-9]", "");
        }
        this.dataFundacao = dataFundacao;
        this.qntFuncionarios = qntFuncionarios;
    }

    // Getters
    public String getCnpj() {
        return cnpj;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public int getQntFuncionarios() {
        return qntFuncionarios;
    }
    // Setters

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public void setQntFuncionarios(int qntFuncionarios) {
        this.qntFuncionarios = qntFuncionarios;
    }

    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return super.toString() + "cnpj=" + cnpj + ", dataFundacao=" + formato.format(dataFundacao)
                + ", qntFuncionarios=" + qntFuncionarios;
    }

    @Override
    public double calculaScore() {
        return (CalculoSeguro.VALOR_BASE.getFator() * (1 + (getQntFuncionarios()) / 100) * getListaVeiculos().size());
    }
}
