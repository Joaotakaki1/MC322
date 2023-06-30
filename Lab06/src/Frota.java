import java.util.ArrayList;
import java.util.Random;
public class Frota {
    private String code;
    private ArrayList<Veiculo> listaVeiculos;
    private static ArrayList<String> codes = new ArrayList<String>();
    public Frota() {
        ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
        Random gerador = new Random();
		int ver = 0;
		do {
			ver = gerador.nextInt();
		} while (codes.contains(Integer.toString(ver)));
        this.code = Integer.toString(ver);
        this.listaVeiculos = listaVeiculos;
    }

    public Frota (String code){
        ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
        this.code = code;
        this.listaVeiculos = listaVeiculos;     
    }
    //getters
    public String getCode() {
        return code;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }
    //Setters
    public void setCode(String code) {
        this.code = code;
    }
    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public boolean addVeiculo(Veiculo veiculo){
        if (!listaVeiculos.contains(veiculo)){
            return listaVeiculos.add(veiculo);
        } else{
            return false;
        }
    }
    public boolean removeVeiculo(Veiculo veiculo){
        if (listaVeiculos.contains(veiculo)){
            return listaVeiculos.remove(veiculo);
        } else{
            return false;
        }
    }
    @Override
    public String toString() {
        return "Frota: " + code + "\nLista de Veiculos: " + listaVeiculos ;
    }
}
