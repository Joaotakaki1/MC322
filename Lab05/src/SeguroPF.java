import java.util.Date;
import java.time.Duration;
import java.time.Instant;

public class SeguroPF extends Seguro {
    private Veiculo veiculo;
    private ClientePF cliente;

    public SeguroPF(Date dataInicio, Date dataFim, Seguradora seguradora, Veiculo veiculo,
            ClientePF cliente) {
        super(dataInicio, dataFim, seguradora);
        this.veiculo = veiculo;
        this.cliente = cliente;
        super.setValorMensal(calcularValor());
    }

    //Getters
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public ClientePF getCliente() {
        return cliente;
    }

    //Setters
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setCliente(ClientePF cliente) {
        this.cliente = cliente;
    }
    public int calcularValor(){
        Duration duration = Duration.between(cliente.getDataNacimento().toInstant(), Instant.now());
        long idade = (duration.toDays() / 365);
        double fIdade = 0;
        if (idade > 18 && idade < 30) {
            fIdade = CalculoSeguro.FATOR_18_30.getFator();
        } else if (idade >= 30 && idade < 30) {
            fIdade = CalculoSeguro.FATOR_30_60.getFator();
        } else {
            fIdade = CalculoSeguro.FATOR_60_90.getFator();
        }
        int qntSinistrosCondutores = 0;
        for (Condutor condutor : getListacondutores()){
            qntSinistrosCondutores += condutor.getListaSinistros().size();
        }
        return (int)(CalculoSeguro.VALOR_BASE.getFator()*fIdade*(1+1/(cliente.getListaVeiculos().size()))*(2+(super.getListaSinistros().size()/10))*(5+qntSinistrosCondutores/10));
    }

    @Override
    public String toString() {
        return super.toString() + "\nVeiculo: " + veiculo + "\nCliente: " + cliente ;
    }
}
