public class Main {
	public static void main(String[] args) {
		Cliente cliente1 = new Cliente(null, "384.288.278-50", null, 0);
		Seguradora seguradora1 = new Seguradora(null, null, null, null);
		Sinistro sinistro1 = new Sinistro(null, null, 0);
		Veiculo veiculo1 = new Veiculo(null, null, null);
		
		boolean teste = cliente1.validaCPF(cliente1.getCpf());
		System.out.println(teste);
	}
}
