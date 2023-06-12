import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

public class Sinistro {
	private Date data;
	private String endereco;
	private final int id;
	private static ArrayList<Integer> ids = new ArrayList<Integer>();
	private Condutor condutor;
	private Seguro seguro;

	// Construtor
	public Sinistro(Date data, String endereco, Condutor condutor, Seguro seguro) {
		Random gerador = new Random();
		int ver = 0;
		do {
			ver = gerador.nextInt();
		} while (ids.contains(ver));
		ids.add(ver);
		this.data = data;
		this.id = ver;
		this.endereco = endereco;
		this.condutor = condutor;
		this.seguro = seguro;
	}

	//Getters
	public Date getData() {
		return data;
	}

	public String getEndereco() {
		return endereco;
	}

	public int getId() {
		return id;
	}

	public static ArrayList<Integer> getIds() {
		return ids;
	}

	public Condutor getCondutor() {
		return condutor;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	//Setters
	public void setData(Date data) {
		this.data = data;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public static void setIds(ArrayList<Integer> ids) {
		Sinistro.ids = ids;
	}

	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	@Override
	public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		return "Sinistro: " + id + "\nEndereco: " + endereco + "\nData: " + formato.format(data) ;
	}
	
}
