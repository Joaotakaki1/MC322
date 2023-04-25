import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ClientePF extends Cliente {
    private final String cpf;
    private Date dataNascimento;
    private String genero;
    private Date dataLicenca;
    private String educacao;
    private String classeEconomica;

    public ClientePF(String nome, String endereco, String educacao, String genero, String classeEconomica,
            Date dataLicenca, String cpf, Date dataNascimento) {
        super(nome, endereco);
        try {
            if (!validaCPF(cpf)) {
                throw new Exception("Cpf Inválido");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.cpf = cpf.replaceAll("[^0-9]", "");
            this.genero = genero;
            this.dataLicenca = dataLicenca;
            this.educacao = educacao;
            this.dataNascimento = dataLicenca;
            this.classeEconomica = classeEconomica;
        }
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

    // public String toString() {
    // SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    // return super.toString() + "cpf=" + cpf + ", dataNacimento=" +
    // formato.format(dataNascimento);
    // }
    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return "ClientePF [cpf=" + cpf + ", dataNascimento=" + formato.format(dataNascimento) + ", genero=" + genero
                + ", dataLicenca="
                + formato.format(dataLicenca) + ", educacao=" + educacao + ", classeEconomica=" + classeEconomica + "]";
    }

    public boolean validaCPF(String cpf) {
        String cpfNumerico = cpf.replaceAll("[^0-9]", "");
        if (cpfNumerico.length() == 11) {
            if (verificaDigitosIguais(cpfNumerico)) {
                return false;
            } else {
                int primeiroVerificador = 0;
                int multiplicador = 2;
                for (int i = 8; i >= 0; i--) {
                    primeiroVerificador += Character.digit(cpfNumerico.charAt(i), 10) * multiplicador;
                    multiplicador++;
                }
                if (primeiroVerificador % 11 < 2) {
                    primeiroVerificador = 0;
                } else {
                    primeiroVerificador = 11 - (primeiroVerificador % 11);
                }
                if (primeiroVerificador == Character.digit(cpfNumerico.charAt(9), 10)) {
                    int segundoVerificador = 0;
                    int multiplicador2 = 2;
                    for (int j = 9; j >= 0; j--) {
                        segundoVerificador += Character.digit(cpfNumerico.charAt(j), 10) * multiplicador2;
                        multiplicador2++;
                    }
                    if (segundoVerificador % 11 < 2) {
                        segundoVerificador = 0;
                    } else {
                        segundoVerificador = 11 - (segundoVerificador % 11);
                    }
                    if (segundoVerificador == Character.digit(cpfNumerico.charAt(10), 10)) {
                        return true;
                    } else {
                        return false;
                    }

                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }
}
