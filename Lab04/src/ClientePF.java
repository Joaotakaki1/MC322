import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;

public class ClientePF extends Cliente {
    private final String cpf;
    private Date dataNascimento;
    private String genero;
    private Date dataLicenca;
    private String educacao;
    private String classeEconomica;

    public ClientePF(String nome, String endereco, String educacao, String genero, String classeEconomica,
            Date dataLicenca, String cpf, Date dataNascimento, int valorSeguro) throws Exception {
        super(nome, endereco, valorSeguro);
        if (Validacao.validaCPF(cpf)) {
            this.cpf = cpf.replaceAll("[^0-9]", "");
        } else {
            throw new Exception("Cpf Inválido");
        }
        this.genero = genero;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.classeEconomica = classeEconomica;

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

    public Date getDataLicenca() {
        return dataLicenca;
    }

    public String getEducacao() {
        return educacao;
    }

    public String getClasseEconomica() {
        return classeEconomica;
    }
    // Setters

    public void setDataNacimento(Date dataNacimento) {
        this.dataNascimento = dataNacimento;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDataLicenca(Date dataLicenca) {
        this.dataLicenca = dataLicenca;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }

    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return "ClientePF: " + super.getNome() + "\nCPF: " + cpf + "\nData de Nascimento: "
                + formato.format(dataNascimento)
                + "\nGenero: "
                + genero
                + "\nData de Licenca: "
                + formato.format(dataLicenca) + "\nEducacao: " + educacao + "\nClasse Economica: " + classeEconomica
                + "\n";
    }

    @Override

    public double calculaScore() {
        Duration duration = Duration.between(getDataNacimento().toInstant(), Instant.now());
        long idade = (duration.toDays() / 365);
        double fIdade = 0;
        if (idade > 0 && idade < 30) {
            fIdade = CalculoSeguro.FATOR_18_30.getFator();
        } else if (idade >= 30 && idade < 30) {
            fIdade = CalculoSeguro.FATOR_30_60.getFator();
        } else {
            fIdade = CalculoSeguro.FATOR_60_90.getFator();
        }
        return (CalculoSeguro.VALOR_BASE.getFator() * fIdade * getListaVeiculos().size());
    }
}
