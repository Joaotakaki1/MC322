import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		String nome = JOptionPane.showInputDialog("Digite seu nome: ");
		String cpf = JOptionPane.showInputDialog("Digite seu cpf: ");
		String dataNascimento = JOptionPane.showInputDialog("Digite sua data de Nascimento: ");
		String endereco = JOptionPane.showInputDialog("Digite seu endereço: ");
		String idade = JOptionPane.showInputDialog("Digite sua idade: ");
		int idadeInt = Integer.parseInt(idade);
		Cliente cliente1 = new Cliente(nome,cpf,dataNascimento,endereco,idadeInt);
		Seguradora seguradora1 = new Seguradora(null, null, null, null);
		Sinistro sinistro1 = new Sinistro(null, null, 0);
		Veiculo veiculo1 = new Veiculo(null, null, null);
		
		boolean teste = cliente1.validaCPF(cliente1.getCpf());
		System.out.println(cliente1.toString());
		if (teste) {
			System.out.println("Cpf Válido");
		} else {
			System.out.println("Cpf Inválido");
		}
	}
}
