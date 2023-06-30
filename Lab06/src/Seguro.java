import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public abstract class Seguro {
    private final int id;
    private Date dataInicio;
    private Date dataFim;
    private Seguradora seguradora;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Condutor> listacondutores;
    private int valorMensal;
    private static ArrayList<Integer> ids = new ArrayList<Integer>();

    public Seguro( Date dataInicio, Date dataFim, Seguradora seguradora) {
        Random gerador = new Random();
		int ver = 0;
		do {
			ver = gerador.nextInt();
		} while (ids.contains(ver));
        ArrayList<Sinistro> listaSinistros = new ArrayList<Sinistro>();
        ArrayList<Condutor> listacondutores = new ArrayList<Condutor>();
        this.id = ver;
        ids.add(ver);
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.listaSinistros = listaSinistros;
        this.listacondutores = listacondutores;
        this.valorMensal = 0;
    }

    //Getters
    public int getId() {
        return id;
    }
    public Date getDataInicio() {
        return dataInicio;
    }
    public Date getDataFim() {
        return dataFim;
    }
    public Seguradora getSeguradora() {
        return seguradora;
    }
    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }
    public ArrayList<Condutor> getListacondutores() {
        return listacondutores;
    }
    public int getValorMensal() {
        return valorMensal;
    }

    //Setters

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public void setListacondutores(ArrayList<Condutor> listacondutores) {
        this.listacondutores = listacondutores;
    }

    public void setValorMensal(int valorMensal) {
        this.valorMensal = valorMensal;
    }

    public boolean autorizarCondutor(Condutor condutor){
        if (!listacondutores.contains(condutor)){
            return listacondutores.add(condutor);
        } else{
            return false;
        }
    }
    public boolean desautorizarCondutor(Condutor condutor){
        if (listacondutores.contains(condutor)){
            return listacondutores.remove(condutor);
        } else{
            return false;
        }
    }
    public abstract int calcularValor();

    public boolean gerarSinistro(Sinistro sinistro){
        if (!listaSinistros.contains(sinistro)){
            return listaSinistros.add(sinistro);
        } else{
            return false;
        }    
    }

    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return "Seguro: " + id + "\nData de Inicio: " + formato.format(dataInicio) + "\nData de Fim: " + formato.format(dataFim) + "\nQuantidade de Sinistros: " + listaSinistros.size() + "\nQuantidade de Condutores: " + listacondutores.size() + "\nValor Mensal: "
                + valorMensal;
    }
}
