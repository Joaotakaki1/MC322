import java.util.Date;
import java.time.Duration;
import java.time.Instant;

public class SeguroPJ extends Seguro{
    private Frota frota;
    private ClientePJ clientePJ;
    public SeguroPJ(Date dataInicio, Date dataFim, Seguradora seguradora, Frota frota, ClientePJ clientePJ) {
        super(dataInicio, dataFim, seguradora);
        this.frota = frota;
        this.clientePJ = clientePJ;
        super.setValorMensal(calcularValor());
    }
    //Getters
    public Frota getFrota() {
        return frota;
    }
    public ClientePJ getClientePJ() {
        return clientePJ;
    }
    // Setters
    public void setFrota(Frota frota) {
        this.frota = frota;
    }
    public void setClientePJ(ClientePJ clientePJ) {
        this.clientePJ = clientePJ;
    }
    public int calcularValor(){
        int qntSinistrosCondutores = 0;
        for (Condutor c : super.getListacondutores()){
            qntSinistrosCondutores += c.getListaSinistros().size();
        }
        Duration duration = Duration.between(clientePJ.getDataFundacao().toInstant(), Instant.now());
        long idade = (duration.toDays() / 365);
        return (int) (CalculoSeguro.VALOR_BASE.getFator()*(10 + (getListacondutores().size())/10)*(1 + 1/clientePJ.getVeiculosPorFrota(frota).size()+2)*(1 + 1/(idade + 2))*(2 + super.getListaSinistros().size()/10)*(5 + qntSinistrosCondutores/10));
    }
    @Override
    public String toString() {
        return super.toString() + "\nFrota: " + frota + "\nCliente: " + clientePJ;
    }
}
