import java.util.Random;

public class Sinistro {
	private String data;
	private String endereco;
	private int id;
	
	//Construtor
	public Sinistro(String data, String endereco, int id) {
		Random gerador = new Random();
		this.data = data;
		this.id = gerador.nextInt();
		this.endereco =endereco;
	}
	
	//Getters
	public String getData() {
		return data;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public int getId() {
		return id;
	}
	
	//Setters
	public void setData(String data) {
		this.data = data;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
}
