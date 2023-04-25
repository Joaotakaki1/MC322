import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Seguradora seguradora = new Seguradora("TakakiCorp", "11976804149", "joaotakaki1@gmail.com",
				"Rua Roxo Moreira 13");
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite seu CPF");
		String cpf = sc.nextLine();
		System.out.println("Digite seu CNPJ");
		String cnpj = sc.nextLine();
		sc.close();
		String licenca = "08/10/2434";
		String nascimento = "08/11/2434";
		String fundacao = "08/10/1999";
		Date licencaFormatada = formato.parse(licenca);
		Date nascimentoFormatada = formato.parse(nascimento);
		Date fundacaoFormatada = formato.parse(fundacao);
		ClientePF clientePF = new ClientePF("eu", "ruas", "tive", "masc", "media",
				licencaFormatada, cpf, nascimentoFormatada);
		ClientePJ clientePJ = new ClientePJ("eu", "ruas", "tive", "masc", "media",
				licencaFormatada, cnpj, fundacaoFormatada);
		if (seguradora.cadastrarCliente(clientePJ))
			System.out.println("ClientePJ cadastrado");
		if (seguradora.cadastrarCliente(clientePF))
			System.out.println("ClientePF cadastrado");
		Veiculo corsa = new Veiculo("placa", "marca", "modelo", 2007);
		Veiculo corsa2 = new Veiculo("placa2", "marca2", "modelo2", 2005);
		if (clientePJ.adicionaVeiculo(corsa))
			System.out.println("Veiculo cadastrado com sucesso!");
		if (clientePF.adicionaVeiculo(corsa2))
			System.out.println("Veiculo cadastrado com sucesso!");
		Sinistro teste = new Sinistro("08/10/2003", "Rua s", seguradora, corsa, clientePF);
		if (seguradora.gerarSinistro(teste))
			System.out.println("Sinistro gerado com sucesso!");
		seguradora.toString();
		corsa.toString();
		clientePF.toString();
		clientePJ.toString();
		teste.toString();
		seguradora.listarClientes();
		seguradora.listarSinistros();
		if (seguradora.removeCliente(clientePF.getCpf()))
			System.out.println("ClientePF removido");
		// entrada(seguradora);

	}

	public static void entrada(Seguradora seguradora) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Digite 0 se quiser cadastrar");
		Scanner sc = new Scanner(System.in);
		String entrada = sc.nextLine();
		if (entrada.equals("0")) {
			System.out.println("Digite seu nome completo: ");
			String nome = sc.nextLine();
			System.out.println("Digite seu endereço: ");
			String endereço = sc.nextLine();
			System.out.println("Digite seu grau de educação: ");
			String educacao = sc.nextLine();
			System.out.println("Digite seu gênero: ");
			String genero = sc.nextLine();
			System.out.println("Digite sua classe econômica: ");
			String classeEconomica = sc.nextLine();
			System.out.println("Digite a data da sua licença: ");
			String dataLicenca = sc.nextLine();
			Date licencaFormatada = formato.parse(dataLicenca);
			System.out.println("Se for Pessoa Física, digite 1, se não digite 0: ");
			String tipo = sc.nextLine();
			if (tipo.equals("1")) {
				System.out.println("Digite seu cpf: ");
				String cpf = sc.nextLine();
				System.out.println("Digite sua data de nascimento: ");
				String dataNascimento = sc.nextLine();
				Date nascimentoFormatada = formato.parse(dataNascimento);
				ClientePF clientePF = new ClientePF(nome, endereço, educacao, genero, classeEconomica,
						licencaFormatada, cpf, nascimentoFormatada);
				if (seguradora.cadastrarCliente(clientePF)) {
					System.out.println("Cadastro realizado com sucesso!");
					System.out.println(clientePF.toString());
				} else
					System.out.println("Cadastro não realizado com sucesso!");
				System.out.println("Se quiser remover um cliente, digite 1: ");
				String remover = sc.nextLine();
				if (remover.equals("1")) {
					System.out.println("Digite o CPF: ");
					String x = sc.nextLine();
					System.out.println(seguradora.removeCliente(x));
				}
				System.out.println("Se quiser adicionar um veiculo, digite 1: ");
				String vei = sc.nextLine();
				if (vei.equals("1")) {
					System.out.println("Digite a placa: ");
					String placa = sc.nextLine();
					System.out.println("Digite a marca: ");
					String marca = sc.nextLine();
					System.out.println("Digite o modelo: ");
					String modelo = sc.nextLine();
					System.out.println("Digite o ano de fabricacao: ");
					int fabricacao = sc.nextInt();
					Veiculo corsa = new Veiculo(placa, marca, modelo, fabricacao);
					if (clientePF.adicionaVeiculo(corsa)) {
						System.out.println("Veiculo cadastrado com sucesso!");
					} else
						System.out.println("Veiculo nao cadastrado com sucesso!");
					Sinistro teste = new Sinistro("08/10/2003", "Rua s", seguradora, corsa, clientePF);
					seguradora.gerarSinistro(teste);
				}
			} else {
				System.out.println("Digite seu cnpj: ");
				String cnpj = sc.nextLine();
				System.out.println("Digite sua data de fundação: ");
				String dataFundacao = sc.nextLine();
				Date fundacaoFormatada = formato.parse(dataFundacao);
				ClientePJ clientePJ = new ClientePJ(nome, endereço, educacao, genero, classeEconomica,
						licencaFormatada, cnpj, fundacaoFormatada);
				if (seguradora.cadastrarCliente(clientePJ)) {
					System.out.println("Cadastro realizado com sucesso!");
					System.out.println(clientePJ.toString());
				} else
					System.out.println("Cadastro não realizado com sucesso!");
				System.out.println("Se quiser remover um cliente, digite 1: ");
				String remover = sc.nextLine();
				if (remover.equals("1")) {
					System.out.println("Digite o CNPJ: ");
					String x = sc.nextLine();
					System.out.println(seguradora.removeCliente(x));
				}
				System.out.println("Se quiser adicionar um veiculo, digite 1: ");
				String vei = sc.nextLine();
				if (vei.equals("1")) {
					System.out.println("Digite a placa: ");
					String placa = sc.nextLine();
					System.out.println("Digite a marca: ");
					String marca = sc.nextLine();
					System.out.println("Digite o modelo: ");
					String modelo = sc.nextLine();
					System.out.println("Digite o ano de fabricacao: ");
					int fabricacao = sc.nextInt();
					Veiculo corsa = new Veiculo(placa, marca, modelo, fabricacao);
					if (clientePJ.adicionaVeiculo(corsa)) {
						System.out.println("Veiculo cadastrado com sucesso!");
					} else
						System.out.println("Veiculo nao cadastrado com sucesso!");
					Sinistro teste = new Sinistro("08/10/2003", "Rua s", seguradora, corsa, clientePJ);
					seguradora.gerarSinistro(teste);
				}
			}
		}
		sc.close();
	}
}
