import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class AppMain {
	public static void main(String[] args) throws Exception {
		ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();
		Seguradora seguradoraProto = new Seguradora("66070178000117", "Proto", "11934830482", "proto@gmail.com", "Rua proto 200");
		listaSeguradoras.add(seguradoraProto);
		Veiculo vei1 = new Veiculo("DYG-2932", "Chevrolet", "S10", 2006);
		Veiculo vei2 = new Veiculo("DYG-2933", "JEEP", "Renegade", 2005);
		Veiculo vei3 = new Veiculo("DYG-2934", "Toyota", "Corolla", 2007);
		Veiculo vei4 = new Veiculo("DYG-2936", "Hyundai", "HB20", 2010);
		System.out.println("Seguradora adicionada com sucesso!");
		System.out.println("****************************************************************");
		System.out.println(seguradoraProto);
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date dataPadrao = new Date();
		dataPadrao = formato.parse("10/10/2000");
		ClientePF clientePF1 = new ClientePF("Joao", "Rua do Joao", "EM  completo", "Masc", "38428827850", dataPadrao, "joao@gmail.com", "11457392745");
		seguradoraProto.cadastrarCliente(clientePF1);
		clientePF1.cadastrarVeiculo(vei1);
		System.out.println("Cliente adicionado com sucesso!");
		System.out.println(clientePF1);
		System.out.println("****************************************************************");
		ClientePF clientePF2 = new ClientePF("Joaoo", "Rua do Joao2", "EM  completo", "Fem", "00443734909", dataPadrao, "joao2@gmail.com", "11457392745");
		seguradoraProto.cadastrarCliente(clientePF2);
		clientePF2.cadastrarVeiculo(vei2);
		System.out.println("Cliente adicionado com sucesso!");
		System.out.println(clientePF2);
		System.out.println("****************************************************************");
		ClientePJ clientePJ1 = new ClientePJ("Conpec", "Rua Josue de castro 11", "119354850385", "66070178000117", dataPadrao,"conpec@gmail.com");
		seguradoraProto.cadastrarCliente(clientePJ1);
		System.out.println("Cliente adicionado com sucesso!");
		System.out.println(clientePJ1);
		System.out.println("****************************************************************");
		ClientePJ clientePJ2 = new ClientePJ("Conpecccc", "Rua Josue de castro 112", "112345850385", "22.472.132/0001-59", dataPadrao,"conpec2@gmail.com");
		seguradoraProto.cadastrarCliente(clientePJ2);
		System.out.println("Cliente adicionado com sucesso!");
		System.out.println(clientePJ2);
		System.out.println("****************************************************************");
		seguradoraProto.gerarSeguro(clientePF1, dataPadrao, dataPadrao, vei1, seguradoraProto);
		System.out.println("Seguro gerado com sucesso!");
		System.out.println("****************************************************************");
		seguradoraProto.gerarSeguro(clientePF2, dataPadrao, dataPadrao, vei2, seguradoraProto);
		System.out.println("Seguro gerado com sucesso!");
		System.out.println("****************************************************************");
		Frota frota1 = new Frota();
		Frota frota2 = new Frota();
		frota1.addVeiculo(vei3);
		clientePJ1.cadastrarFrota(frota1);
		clientePJ1.atualizarFrota(true, false, false, vei3, frota1);
		frota1.addVeiculo(vei4);
		clientePJ2.cadastrarFrota(frota2);
		clientePJ2.atualizarFrota(true, false, false, vei4, frota2);
		System.out.println(frota1);
		seguradoraProto.gerarSeguro(clientePJ1, dataPadrao, dataPadrao, frota1, seguradoraProto);
		seguradoraProto.gerarSeguro(clientePJ2, dataPadrao, dataPadrao, frota2, seguradoraProto);
		System.out.println(seguradoraProto.getListaSeguros());
		Condutor c1 = new Condutor("38428827850", "c1", "Endereco 1", "email1@gmail.com", dataPadrao, "11234567432");
		Condutor c2 = new Condutor("28483210240", "c2", "Endereco 2", "email2@gmail.com", dataPadrao, "11234567432");
		Condutor c3 = new Condutor("71367545188", "c3", "Endereco 3", "email3@gmail.com", dataPadrao, "11234567432");
		Condutor c4 = new Condutor("75438583200", "c4", "Endereco 4", "email4@gmail.com", dataPadrao, "11234567432");
		seguradoraProto.getListaSeguros().get(0).autorizarCondutor(c1);
		System.out.println("Condutor autorizado com sucesso gerado com sucesso!");
		System.out.println(seguradoraProto.getListaSeguros().get(0).getListacondutores());
		System.out.println("****************************************************************");
		seguradoraProto.getListaSeguros().get(1).autorizarCondutor(c2);
		System.out.println("Condutor autorizado com sucesso gerado com sucesso!");
		System.out.println(seguradoraProto.getListaSeguros().get(1).getListacondutores());
		System.out.println("****************************************************************");
		seguradoraProto.getListaSeguros().get(2).autorizarCondutor(c3);
		System.out.println("Condutor autorizado com sucesso gerado com sucesso!");
		System.out.println(seguradoraProto.getListaSeguros().get(2).getListacondutores());
		System.out.println("****************************************************************");
		seguradoraProto.getListaSeguros().get(3).autorizarCondutor(c4);
		System.out.println("Condutor autorizado com sucesso gerado com sucesso!");
		System.out.println(seguradoraProto.getListaSeguros().get(3).getListacondutores());
		System.out.println("****************************************************************");
		Sinistro s1 = new Sinistro(dataPadrao, "rua 2r", c1, seguradoraProto.getListaSeguros().get(0));
		Sinistro s2 = new Sinistro(dataPadrao, "rua 223r", c2, seguradoraProto.getListaSeguros().get(1));
		Sinistro s3 = new Sinistro(dataPadrao, "rua 2r4234", c3, seguradoraProto.getListaSeguros().get(2));
		Sinistro s4 = new Sinistro(dataPadrao, "rua 2r42qewq", c4, seguradoraProto.getListaSeguros().get(3));
		seguradoraProto.getListaSeguros().get(0).gerarSinistro(s1);
		System.out.println("Sinistro gerado com sucesso!!");
		System.out.println(seguradoraProto.getListaSeguros().get(0).getListaSinistros());
		System.out.println("****************************************************************");
		seguradoraProto.getListaSeguros().get(1).gerarSinistro(s2);
		System.out.println("Sinistro gerado com sucesso!!");
		System.out.println(seguradoraProto.getListaSeguros().get(1).getListaSinistros());
		System.out.println("****************************************************************");
		seguradoraProto.getListaSeguros().get(2).gerarSinistro(s3);
		System.out.println("Sinistro gerado com sucesso!!");
		System.out.println(seguradoraProto.getListaSeguros().get(2).getListaSinistros());
		System.out.println("****************************************************************");
		seguradoraProto.getListaSeguros().get(3).gerarSinistro(s4);
		System.out.println("Sinistro gerado com sucesso!!");
		System.out.println(seguradoraProto.getListaSeguros().get(3).getListaSinistros());
		System.out.println("****************************************************************");

		System.out.println("****************************************************************");
		System.out.println("IMPORTANDO DADOS!");
		System.out.println("****************************************************************");

		System.out.println("Importando ClientesPF: ");
		ArquivoClientePF arquivoClientePF = new ArquivoClientePF();
		ArrayList<ClientePF> novosClientes = (ArrayList<ClientePF>) arquivoClientePF.lerDados("./lab06-seguradora_arquivos_v2/clientesPF.csv");
		System.out.println(novosClientes);
		for (ClientePF c : novosClientes) {
			seguradoraProto.cadastrarCliente(c);
		}
		System.out.println("****************************************************************");
		System.out.println("Importadno ClientesPJ: ");
		ArquivoClientePJ arquivoClientePJ = new ArquivoClientePJ();
		ArrayList<ClientePJ> novosClientesPJ = (ArrayList<ClientePJ>) arquivoClientePJ.lerDados("./lab06-seguradora_arquivos_v2/clientesPJ.csv");
		System.out.println(novosClientesPJ);
		for (ClientePJ c : novosClientesPJ) {
			seguradoraProto.cadastrarCliente(c);
		}
		System.out.println("****************************************************************");
		System.out.println("Importadno Condutores: ");
		ArquivoCondutor arqCon = new ArquivoCondutor();
		ArrayList<Condutor> novosCondutores = (ArrayList<Condutor>) arqCon.lerDados("./lab06-seguradora_arquivos_v2/condutores.csv");
		System.out.println(novosCondutores);
		System.out.println("****************************************************************");

		Scanner scanner = new Scanner(System.in);
		MenuOperacoes opcao;
		do {
			Menu();
			opcao = leituraOpcao(scanner);
			executaOpcoesMenu(opcao, listaSeguradoras, scanner);
		} while (opcao != MenuOperacoes.SAIR);
		System.out.println("Fim do progama");
		scanner.close();
		System.out.println("****************************************************************");
		System.out.println("Exportando Seguros: ");
		ArquivoSeguro arqSeg = new ArquivoSeguro();
		if(arqSeg.gravarDados("./dados/seguros.csv", seguradoraProto.getListaSeguros())){
			System.out.println("Seguros Exportados com sucesso!");
		}
		System.out.println("****************************************************************");
		System.out.println("Exportando Sinistros: ");
		ArquivoSinistro arqSin = new ArquivoSinistro();
		for (Seguro s : seguradoraProto.getListaSeguros()){
			arqSin.gravarDados("./dados/sinistros.csv", s.getListaSinistros());
		}
		System.out.println("****************************************************************");
	}

	private static void Menu() {
		MenuOperacoes menu[] = MenuOperacoes.values();
		System.out.println("Menu Principal");
		for (MenuOperacoes opcao : menu) {
			System.out.println(opcao.ordinal() + " - " + opcao.getDescricao());
		}
	}

	private static void subMenu(MenuOperacoes opcao) {
		SubMenu submenu[] = opcao.getSubmenu();
		System.out.println(opcao.getDescricao());
		for (int i = 0; i < submenu.length; i++)
			System.out.println(i + " - " + submenu[i].getDescricao());
	}

	private static MenuOperacoes leituraOpcao(Scanner scanner) {
		int opcao;
		MenuOperacoes opcaoUsuario;
		do {
			System.out.println("Digite uma opção: ");
			opcao = Integer.parseInt(scanner.nextLine());
		} while (opcao < 0 || opcao > MenuOperacoes.values().length - 1);
		opcaoUsuario = MenuOperacoes.values()[opcao];
		return opcaoUsuario;
	}

	private static SubMenu leituraOpcaoSub(MenuOperacoes selecionado, Scanner scanner) {
		int opcao;
		SubMenu opcaoUsuario;
		do {
			System.out.println("Digite uma opção: ");
			opcao = Integer.parseInt(scanner.nextLine());
		} while (opcao < 0 || opcao > selecionado.getSubmenu().length - 1);
		opcaoUsuario = selecionado.getSubmenu()[opcao];
		return opcaoUsuario;
	}

	private static Seguradora encontraSeguradora(Scanner scanner, ArrayList<Seguradora> listaSeguradora){
		System.out.println("Informe qual o nome da seguradora escolhida: ");
		String nomeSeg = scanner.nextLine();
		for (Seguradora variavel : listaSeguradora) {
			if (variavel.getNome().equals(nomeSeg)) {
				return variavel;
			}
		}
		return null;
	}

	private static boolean adicionaSeguradora(Scanner scanner, ArrayList<Seguradora> listaSeguradora){
		System.out.println("Digite o cnpj da seguradora que deseja cadastrar: ");
		String cnpj2 = scanner.nextLine();
		System.out.println("Digite o nome da seguradora que deseja cadastrar: ");
		String nomeSeg1 = scanner.nextLine();
		System.out.println("Digite o número de telefone da seguradora que deseja cadastrar: ");
		String telefone = scanner.nextLine();
		System.out.println("Digite o email da seguradora que deseja cadastrar: ");
		String email = scanner.nextLine();
		System.out.println("Digite o endereco da seguradora que deseja cadastrar: ");
		String endereco = scanner.nextLine();
		try{
			Seguradora newSeguradora = new Seguradora(cnpj2, nomeSeg1, telefone, email,endereco);
			listaSeguradora.add(newSeguradora);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private static ClientePF encontraClientePF(Seguradora seguradora, Scanner scanner){
		System.out.println("Digite seu cpf: ");
		String cpf = scanner.nextLine();
		for (Cliente c : seguradora.getListaClientes()) {
			try {
				if (((ClientePF)c).getCpf().equals(cpf)) {
					return ((ClientePF)c);
				}
			} catch (Exception e) {
			}
		}
		return null;
	}
	private static ClientePJ encontraClientePJ(Seguradora seguradora, Scanner scanner){
		System.out.println("Digite seu cnpj: ");
		String cnpj = scanner.nextLine();
		for (Cliente c : seguradora.getListaClientes()) {
			try {
				if (((ClientePJ)c).getCnpj().equals(cnpj)) {
					return ((ClientePJ)c);
				}
			} catch (Exception e) {
			}
		}
		return null;
	}

	private static Frota encontraFrota ( Scanner scanner, ClientePJ cliente){
		System.out.println("Digite qual o code da frota você deseja adicionar o veículo: ");
		String code = scanner.nextLine();
		for (Frota f : ((ClientePJ)cliente).getListaFrota()){
			if (f.getCode().equals(code)){
				return f;
			}
		}
		return null;
	}

	public static int tipoCliente (Scanner scanner){
		System.out.println("0 - PF\n1 - PJ");
		int opcao;
		do {
			System.out.println("Digite uma opção: ");
			opcao = Integer.parseInt(scanner.nextLine());
		} while (opcao < 0 || opcao > 1);
		return opcao;
	}

	private static Seguro encontraSeguro (Scanner scanner, Seguradora seguradora){
		System.out.println("Informe o id do seguro: ");
		String entrada = scanner.nextLine();
		int id = Integer.parseInt(entrada);
		for (Seguro seguro : seguradora.getListaSeguros()){
			if (seguro.getId() == id){
				return seguro;
			}
		}
		return null;
	}

	private static boolean removeSinistro (Scanner scanner, Seguradora seguradora){
		System.out.println("Digite o id do sinistro a ser removido");
		int id = Integer.parseInt(scanner.nextLine());
		for (Seguro s : seguradora.getListaSeguros()){
			for (Condutor c : s.getListacondutores()){
				for (Sinistro sinistro : c.getListaSinistros()){
					if (sinistro.getId() == id){
						return c.getListaSinistros().remove(sinistro);
					}
				}
			}
		}
		return false;
	}

	private static Veiculo encontraVeiculo (String placa, ClientePF cliente){
		for (Veiculo v : cliente.getListaVeiculos()){
			if ( v.getPlaca().equals(placa))
				return v;
		}
		return null;
	}
	private static Veiculo encontraVeiculo (Frota frota, Scanner scanner,String placa, ClientePJ cliente){
		for (Veiculo v : frota.getListaVeiculos()){
			if (v.getPlaca().equals(placa)){
				return v;
			}
		}
		return null;
	}

	private static void executaOpcoesMenu(MenuOperacoes opcao, ArrayList<Seguradora> listaSeguradora, Scanner scanner)
			throws Exception {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Seguradora seguradora;
		Seguro seguro;
		switch (opcao) {
			case CADASTRAR:
			case LISTAR:
			case EXCLUIR:
				executaSubMenu(opcao, listaSeguradora, scanner);
				break;
			case GERAR_SINISTRO:
				seguradora = encontraSeguradora(scanner, listaSeguradora);
				if (seguradora != null){
					seguro = encontraSeguro(scanner, seguradora);
					if (seguro != null) {
						System.out.println("Informe a data do ocorrido: ");
						String date = scanner.nextLine();
						Date dateFormat = new Date();
						try {
							dateFormat = formato.parse(date);
						} catch (Exception e) {
							System.out.println("Data inserida inválida!");
							break;
						}
						System.out.println("Informe o endereço do ocorrido: ");
						String enderecoSt = scanner.nextLine();
						System.out.println("Informe o cpf do condutor do ocorrido: ");
						String cpfCond = scanner.nextLine();
						for (Condutor condutor : seguro.getListacondutores()){
							if (condutor.getCpf().equals(cpfCond)){
								Sinistro s = new Sinistro(dateFormat, enderecoSt, condutor, seguro);
								if (seguro.gerarSinistro(s)){
									seguro.setValorMensal(seguro.calcularValor());
									System.out.println("Sinistro gerado com sucesso!");
								} else
									System.out.println("Erro ao gerar o sinistro!");
							}
						}
					} else
						System.out.println("Nenhum seguro encontrado");
				} else
					System.out.println("Nenhuma seguradora encontrada");
				break;
			case TRANSFERIR_SEGURO:
				break;
			case CALCULAR_RECEITA:
				seguradora = encontraSeguradora(scanner, listaSeguradora);
				if (seguradora != null) {
					System.out.println("Receita atual: " + seguradora.calcularReceita());
				} else
					System.out.println("Nenhuma seguradora encontrada.");
				break;
			case CALCULAR_SEGURO: 
				seguradora = encontraSeguradora(scanner, listaSeguradora);
				if (seguradora != null) {
					seguro = encontraSeguro(scanner, seguradora);
					if (seguro != null){
						System.out.println(seguro.getValorMensal());
					} else
						System.out.println("Nenhuma seguro encontrado.");
				} else
					System.out.println("Nenhuma seguradora encontrada.");
				break;
			case SAIR:
				break;
		}
	}

	private static void executaOpcoesSubMenu(SubMenu opcaoSub, ArrayList<Seguradora> listaSeguradoras, Scanner scanner)
			throws Exception {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Seguradora seguradora;
		Cliente cliente;
		Frota frota;
		int opcao;
		Seguro seguro;
		Veiculo veiculo;
		switch (opcaoSub) {
			case CADASTRAR_CLIENTE:
				seguradora = encontraSeguradora(scanner, listaSeguradoras);
				if (seguradora != null){
					opcao = tipoCliente(scanner);
					if (opcao == 0) {
						System.out.println("Digite seu nome completo: ");
						String nome = scanner.nextLine();
						System.out.println("Digite seu endereco: ");
						String endereco = scanner.nextLine();
						System.out.println("Digite sua educacao: ");
						String educacao = scanner.nextLine();
						System.out.println("Digite seu genero: ");
						String genero = scanner.nextLine();
						Date datanascimento = new Date();
						System.out.println("Digite seu cpf: ");
						String cpf = scanner.nextLine();
						System.out.println("Digite sua data de nascimento: ");
						String dataN = scanner.nextLine();
						try {
							datanascimento = formato.parse(dataN);
						} catch (Exception e) {
							System.out.println("Data inserida inválida!");
							break;
						}
						System.out.println("Digite seu e-mail: ");
						String email = scanner.nextLine();
						System.out.println("Digite seu telefone: ");
						String tel = scanner.nextLine();
						try {
							ClientePF cliente1 = new ClientePF(nome, endereco, educacao, genero, cpf, datanascimento, email, tel);
							System.out.println("Cliente cadastrado com sucesso!");
							seguradora.cadastrarCliente(cliente1);
						} catch (Exception e) {
							System.out.println(e.getMessage());
							System.out.println("Erro ao cadastrar o cliente!");
						}
					} else {
						System.out.println("Digite o nome da empresa: ");
						String nome = scanner.nextLine();
						System.out.println("Digite o endereco da empresa: ");
						String endereco = scanner.nextLine();
						System.out.println("Digite o telefone da empresa: ");
						String tel = scanner.nextLine();
						System.out.println("Digite o CNPJ da empresa: ");
						String cnpj = scanner.nextLine();
						System.out.println("Digite a data de fundação da empresa: ");
						String dataF = scanner.nextLine();
						System.out.println("Digite o e-mail da empresa: ");
						String email = scanner.nextLine();
						Date dataFundacao = new Date();
						try {
							dataFundacao = formato.parse(dataF);
						} catch (Exception e) {
							System.out.println("Data inserida inválida!");
							break;
						}
						try {
							ClientePJ cliente2 = new ClientePJ(nome, endereco, tel, cnpj, dataFundacao, email);
							seguradora.cadastrarCliente(cliente2);
							System.out.println("Cliente cadastrado com sucesso!");
						} catch (Exception e) {
							System.out.println(e.getMessage());
							System.out.println("Erro ao cadastrar o cliente!");
						}
					}
				} else{
					System.out.println("Seguradora nao encontrada.");
				}
				break;
			case CADASTRAR_VEICULO:
				seguradora = encontraSeguradora(scanner, listaSeguradoras);
				if (seguradora != null){
					opcao = tipoCliente(scanner);
					if (opcao == 0){
						cliente = encontraClientePF(seguradora, scanner);
					} else {
						cliente = encontraClientePJ(seguradora, scanner);
					}
					if (cliente != null){
						System.out.println("Digite sua placa: ");
						String placa = scanner.nextLine();
						System.out.println("Digite a marca do seu carro: ");
						String marca = scanner.nextLine();
						System.out.println("Digite o modelo do seu carro: ");
						String modelo = scanner.nextLine();
						System.out.println("Digite o ano de fabricação do seu carro: ");
						int anoFabricacao = Integer.parseInt(scanner.nextLine());
						Veiculo vei = new Veiculo(placa, marca, modelo, anoFabricacao);
						if (cliente instanceof ClientePF) {
							((ClientePF)cliente).cadastrarVeiculo(vei);
							for (Seguro s : seguradora.getListaSeguros()){
								try{
									if (((SeguroPF)s).getCliente().equals((ClientePF)cliente)){
										s.setValorMensal(((SeguroPF)s).calcularValor());
									}
								} catch (Exception e) {
								}
							}
							System.out.println("Veiculo cadastrado com sucesso!");
						} else {
							frota = encontraFrota(scanner, ((ClientePJ)cliente));
							if (frota != null){
								frota.addVeiculo(vei);
								for (Seguro s : seguradora.getListaSeguros()){
									try{
										if (((SeguroPJ)s).getClientePJ().equals((ClientePJ)cliente)){
											s.setValorMensal(((SeguroPJ)s).calcularValor());
										}
									} catch (Exception e) {
									}
								}
								System.out.println("Veiculo cadastrado com sucesso!");
							} else
								System.out.println("Nenhuma frota encontrada.");
						}
					}else
						System.out.println("Nenhum cliente encontrado.");
				} else
					System.out.println("Seguradora nao encontrada.");	
				break;
			case CADASTRAR_SEGURADORA:
				if (adicionaSeguradora(scanner, listaSeguradoras)) {
					System.out.println("Seguradora cadastrada com sucesso!");
				} else {
					System.out.println("Erro ao cadastrar a seguradora.");
				}
				break;

            case CADASTRAR_SEGUROPF:
                seguradora = encontraSeguradora(scanner, listaSeguradoras);
				if (seguradora != null){
					cliente = encontraClientePF(seguradora, scanner);
					if (cliente != null){
						System.out.println("Informe a placa do veículo: ");
						String placa = scanner.nextLine();
						veiculo = encontraVeiculo(placa, (ClientePF)cliente);
						if (veiculo != null){
							Date dataIni = new Date();
							System.out.println("Digite a data de início do seguro: ");
							String ini = scanner.nextLine();
							Date dataFim = new Date();
							System.out.println("Digite a data de término do seguro: ");
							String fim = scanner.nextLine();
							try {
								dataIni = formato.parse(ini);
								dataFim = formato.parse(fim);
								if (seguradora.gerarSeguro(((ClientePF) cliente), dataIni, dataFim, veiculo, seguradora)){
									System.out.println("Seguro gerado com sucesso");
								} else{
									System.out.println("Erro ao cadastrar o seguro.");
								}
							} catch (Exception e) {
								System.out.println("Erro de formatação das datas");
							}
						} else 
							System.out.println("Nenhum veiculo encontrado.");
					} else
						System.out.println("Nenhum cliente encontrado.");
				} else
					System.out.println("Seguradora nao encontrada.");
                break;
            case CADASTRAR_SEGUROPJ:
				seguradora =  encontraSeguradora(scanner, listaSeguradoras);
				if (seguradora != null){
					cliente = encontraClientePJ(seguradora, scanner);
					if (cliente != null){
						frota = encontraFrota(scanner, (ClientePJ)cliente);
						Date dataIni = new Date();
						System.out.println("Digite a data de início do seguro: ");
						String ini = scanner.nextLine();
						Date dataFim = new Date();
						System.out.println("Digite a data de término do seguro: ");
						String fim = scanner.nextLine();
						try {
							dataIni = formato.parse(ini);
							dataFim = formato.parse(fim);
							if (seguradora.gerarSeguro(((ClientePJ) cliente), dataIni, dataFim, frota, seguradora)){
								System.out.println("Seguro gerado com sucesso");
							} else{
								System.out.println("Erro ao cadastrar o seguro.");
							}
						} catch (Exception e) {
							System.out.println("Erro de formatação das datas");
						}
					} else
						System.out.println("Nenhum cliente encontrado.");
				} else
					System.out.println("Seguradora nao encontrada.");
                break;
            case CADASTRAR_FROTA:
                seguradora = encontraSeguradora(scanner, listaSeguradoras);
                if (seguradora != null){
					cliente = encontraClientePJ(seguradora, scanner);
					if (cliente != null){
						Frota f = new Frota();
						System.out.println("Informe quantos veículos deseja cadastrar na Frota:");
						Integer n = scanner.nextInt();
						for (int i = 0; i < n; i++){
							System.out.println("Digite sua placa: ");
							String placa = scanner.nextLine();
							System.out.println("Digite a marca do seu carro: ");
							String marca = scanner.nextLine();
							System.out.println("Digite o modelo do seu carro: ");
							String modelo = scanner.nextLine();
							System.out.println("Digite o ano de fabricação do seu carro: ");
							int anoFabricacao = Integer.parseInt(scanner.nextLine());
							Veiculo vei = new Veiculo(placa, marca, modelo, anoFabricacao);
							f.getListaVeiculos().add(vei);
						}
						if (((ClientePJ)cliente).getListaFrota().add(f)){
							// for (Seguro s : seguradora.getListaSeguros()){
							// 	try{
							// 		if (((SeguroPJ)s).getClientePJ().equals((ClientePJ)cliente)){
							// 			s.setValorMensal(((SeguroPJ)s).calcularValor());
							// 		}
							// 	} catch (Exception e) {
							// 	}
							// }
							System.out.println("Frota cadastrada com sucesso!");
						} else
							System.out.println("Erro ao cadastrar a frota.");
					} else
						System.out.println("Nenhum cliente encontrado.");
				} else
					System.out.println("Seguradora nao encontrada.");	
				break;
            case AUTORIZAR_CONDUTOR:
                seguradora = encontraSeguradora(scanner, listaSeguradoras);
				if (seguradora != null){
					seguro = encontraSeguro(scanner, seguradora);
					if (seguro != null){
						System.out.println("Informe o cpf do condutor: ");
						String cpf = scanner.nextLine();
						System.out.println("Informe o nome do condutor: ");
						String nome = scanner.nextLine();
						System.out.println("Informe o telefone do condutor: ");
						String telefone = scanner.nextLine();
						System.out.println("Informe o endereço do condutor: ");
						String endereco = scanner.nextLine();
						System.out.println("Informe o email do condutor: ");
						String email = scanner.nextLine();
						System.out.println("Informe a data de nascimento do condutor: ");
						String data = scanner.nextLine();
						Date dataNascimento = new Date();
						try {
							dataNascimento = formato.parse(data);
							Condutor cond = new Condutor(cpf, nome, endereco, email, dataNascimento, telefone);
							if (seguro.autorizarCondutor(cond)){
								System.out.println("Condutor cadastrado com sucesso!");
							} else
								System.out.println("Erro ao cadastrar o condutror.");
						} catch (Exception e) {
							System.out.println("Erro de formatação da data");
						}
					} else
						System.out.println("Seguro nao encontrado.");	
                } else
					System.out.println("Seguradora nao encontrada.");	
                break;
			case LISTAR_CLIENTES:
				seguradora = encontraSeguradora(scanner, listaSeguradoras);
				if (seguradora != null){
					seguradora.listarClientes();
				} else 
					System.out.println("Seguradora nao encontrada.");	
				break;
            case LISTAR_SEGUROS:
				seguradora = encontraSeguradora(scanner, listaSeguradoras);
				if (seguradora != null){
					for (Seguro seg : seguradora.getListaSeguros()){
						System.out.println(seg);
					}
                } else
                    System.out.println("Seguradora nao encontrada.");
                break;

			case LISTAR_FROTA: 
				seguradora = encontraSeguradora(scanner, listaSeguradoras);
				if (seguradora != null){
					cliente = encontraClientePJ(seguradora, scanner);
					if (cliente != null){
						System.out.println(((ClientePJ)cliente).getListaFrota());
					} else 
						System.out.println("Cliente nao encontrada.");
				} else
					System.out.println("Seguradora nao encontrada.");
				break;
			case LISTAR_SINISTROS:
				seguradora = encontraSeguradora(scanner, listaSeguradoras);
				if (seguradora != null){
					opcao = tipoCliente(scanner);
					if (opcao == 0){
						cliente = encontraClientePF(seguradora, scanner);
						if (cliente != null){
							System.out.println(seguradora.getSinistroPorCliente((ClientePF)cliente));
						} else 
							System.out.println("Cliente nao encontrada.");
					} else {
						cliente = encontraClientePJ(seguradora, scanner);
						if (cliente != null){
							System.out.println(seguradora.getSinistroPorCliente((ClientePJ)cliente));
						} else 
							System.out.println("Cliente nao encontrada.");
					}
				} else
					System.out.println("Seguradora nao encontrada.");
				break;
			case LISTAR_SEGURADORAS:
				for (Seguradora s : listaSeguradoras){
					System.out.println(s.getNome());
				}
				break;
			case LISTAR_VEICULOS:
				seguradora = encontraSeguradora(scanner, listaSeguradoras);
				if (seguradora != null){
					opcao = tipoCliente(scanner);
					if (opcao == 0){
						cliente = encontraClientePF(seguradora, scanner);
						if (cliente != null){
							System.out.println(((ClientePF)cliente).getListaVeiculos());
						} else 
							System.out.println("Cliente nao encontrada.");
					} else {
						cliente = encontraClientePJ(seguradora, scanner);
						if (cliente != null){
							for (Frota f : ((ClientePJ)cliente).getListaFrota())
								System.out.println(f.getListaVeiculos());
						} else 	
							System.out.println("Cliente nao encontrada.");
					}
				} else 
					System.out.println("Seguradora nao encontrada.");
				break;
            case LISTAR_CONDUTORES:
                seguradora = encontraSeguradora(scanner, listaSeguradoras);
                if (seguradora != null){
                    seguro = encontraSeguro(scanner, seguradora);
                    if (seguro != null) {
						for (Condutor c : seguro.getListacondutores())
							System.out.println(c);
					} else 
						System.out.println("Seguro nao encontrado.");
                } else
                    System.out.println("Seguradora nao encontrada.");
                break;
			case EXCLUIR_CLIENTE:
				seguradora = encontraSeguradora(scanner, listaSeguradoras);
				if (seguradora != null){
					System.out.println("Digite seu CPF ou CNPJ: ");
					String c = scanner.nextLine();
					if (seguradora.removeCliente(c)) {
						System.out.println("Cliente removido com sucesso!");
					} else {
						System.out.println("Erro ao remover o cliente.");
					}
				} else
					System.out.println("Seguradora nao encontrada.");
				break;
			case EXCLUIR_SINISTRO:
				seguradora  = encontraSeguradora(scanner, listaSeguradoras);
				if (seguradora != null){
					if (removeSinistro(scanner, seguradora)){	
						System.out.println("Sinistro removido com sucesso!");
					} else 
						System.out.println("Erro ao remover o sinistro.");
				}else
					System.out.println("Seguradora nao encontrada.");
				break;
			case EXCLUIR_VEICULO:
				seguradora = encontraSeguradora(scanner, listaSeguradoras);
				if (seguradora != null){
						System.out.println("Digite a placa do carro a ser removido: ");
						String placa = scanner.nextLine();
						opcao = tipoCliente(scanner);
						if (opcao == 0){
							cliente = encontraClientePF(seguradora, scanner);
							veiculo = encontraVeiculo(placa, (ClientePF) cliente);
							if (veiculo != null){
								if (((ClientePF) cliente).getListaVeiculos().remove(veiculo)){
									System.out.println("Veículo removido com sucesso!.");
								} else
									System.out.println("Erro ao excluir o veículo."); 
							} else 
								System.out.println("Nenhum veículo encontrado.");
						} else {
							cliente = encontraClientePJ(seguradora, scanner);
							frota = encontraFrota(scanner, (ClientePJ) cliente);
							if (frota != null){
								veiculo = encontraVeiculo(frota ,scanner, placa, (ClientePJ) cliente);
								if (veiculo != null){
									if (frota.getListaVeiculos().remove(veiculo)){
										System.out.println("Veiculo removido com sucesso!");
									} else	
										System.out.println("Erro ao remover o veículo.");
								}
							} else 
								System.out.println("Nenhuma frota encontrada.");
						}
					} else
						System.out.println("Seguradora nao encontrada.");
				break;
            case EXCLUIR_SEGURADORA:
                seguradora = encontraSeguradora(scanner, listaSeguradoras);
				if (seguradora != null){
					if (listaSeguradoras.remove(seguradora)){
						System.out.println("Seguradora removida com sucesso!");
					} else
						System.out.println("Erro ao remover a seguradora.");
                } else 
					System.out.println("Seguradora nao encontrada.");
				break;
            case EXCLUIR_CONDUTOR:
                seguradora = encontraSeguradora(scanner, listaSeguradoras);
				if (seguradora != null){
                    seguro = encontraSeguro(scanner, seguradora);
					if (seguro != null){
						System.out.println("Informe o cpf do condutor a ser removido: ");
						String cpf = scanner.nextLine();
						for (Condutor cond : seguro.getListacondutores()){
							if (cond.getCpf().equals(cpf)){
								if (seguro.desautorizarCondutor(cond)){
									System.out.println("Condutor excluído com sucesso!");
								} else{
									System.out.println("Erro ao desautorizar o condutor.");
								}
							}
						}
					} else
                    	System.out.println("Seguro nao encontrado.");
                        
                    }else 
                    	System.out.println("Seguradora nao encontrada.");
				break;
            case EXCLUIR_FROTA:
                seguradora = encontraSeguradora(scanner, listaSeguradoras);
				if (seguradora != null){
					cliente = encontraClientePJ(seguradora, scanner);
					if (cliente != null){
                        frota = encontraFrota(scanner, (ClientePJ) cliente);
						if (frota != null){
							if (((ClientePJ) cliente).getListaFrota().remove(frota)){
								System.out.println("Frota removida com sucesso!.");
							} else 
								System.out.println("Erro ao remover a frota.");
						} else
                    		System.out.println("Frota nao encontrada.");
					} else
                    	System.out.println("Cliente nao encontrado.");
                } else
                    System.out.println("Seguradora nao encontrada.");
				break;
            case EXCLUIR_SEGURO:
                seguradora =  encontraSeguradora(scanner, listaSeguradoras);
				if (seguradora != null){
					seguro = encontraSeguro(scanner, seguradora);
					if (seguro != null){
						if (seguradora.getListaSeguros().remove(seguro)){
							System.out.println("Seguro removido com sucesso!");
						} else
							System.out.println("Erro ao remover o seguro.");
					} else
						System.out.println("Seguro nao encontrado.");
				} else
					System.out.println("Seguradora nao encontrada.");
				break;
			case VOLTAR:
				break;

		}

	}

	private static void executaSubMenu(MenuOperacoes opcao, ArrayList<Seguradora> seguradora, Scanner scanner)
			throws Exception {
		SubMenu opcaoSub;
		do {
			subMenu(opcao);
			opcaoSub = leituraOpcaoSub(opcao, scanner);
			executaOpcoesSubMenu(opcaoSub, seguradora, scanner);
		} while (opcaoSub != SubMenu.VOLTAR);
	}
}
