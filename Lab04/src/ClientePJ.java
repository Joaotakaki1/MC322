import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ClientePJ extends Cliente {
    private final String cnpj;
    private Date dataFundacao;

    public ClientePJ(String nome, String endereco, String educacao, String genero, String classeEconomica,
            Date dataLicenca, String cnpj, Date dataFundacao) {
        super(nome, endereco);
        try {
            if (!validaCNPJ(cnpj)) {
                throw new Exception("Cnpj Inválido");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            this.cnpj = cnpj.replaceAll("[^0-9]", "");
            this.dataFundacao = dataFundacao;
        }
    }

    // Getters
    public String getCnpj() {
        return cnpj;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    // Setters

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return super.toString() + "cnpj=" + cnpj + ", dataFundacao=" + formato.format(dataFundacao);
    }

    public boolean validaCNPJ(String cnpj) {
        String cnpjNumerico = cnpj.replaceAll("[^0-9]", "");
        if (cnpjNumerico.length() == 14) {
            if (verificaDigitosIguais(cnpjNumerico)) {
                return false;
            } else {
                List<Integer> list = new ArrayList<Integer>() {
                    {
                        add(6);
                        add(5);
                        add(4);
                        add(3);
                        add(2);
                        add(9);
                        add(8);
                        add(7);
                        add(6);
                        add(5);
                        add(4);
                        add(3);
                        add(2);
                    }
                };
                int soma1 = 0;
                int primeiroVerificador = 0;
                for (int i = 1; i < list.size(); i++) {
                    soma1 += list.get(i) * Character.digit(cnpjNumerico.charAt(i - 1), 10);
                }
                if (soma1 % 11 < 2)
                    primeiroVerificador = 0;
                else
                    primeiroVerificador = 11 - (soma1 % 11);
                if (primeiroVerificador == Character.digit(cnpjNumerico.charAt(12), 10)) {
                    int segundoVerificador = 0;
                    int soma2 = 0;
                    for (int i = 0; i < list.size(); i++) {
                        soma2 += list.get(i) * Character.digit(cnpjNumerico.charAt(i), 10);
                    }
                    if (soma2 % 11 < 2)
                        segundoVerificador = 0;
                    else
                        segundoVerificador = 11 - (soma2 % 11);
                    if (segundoVerificador == Character.digit(cnpjNumerico.charAt(13), 10))
                        return true;
                    else
                        return false;
                } else
                    return false;
            }
        } else {
            return false;
        }
    }

    public double calculaScore(int qntFuncionarios, int qntCarros) {
        return (1000 * (1 + (qntFuncionarios) / 100) * qntCarros);
    }
}
