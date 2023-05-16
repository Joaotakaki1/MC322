import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();
		Seguradora seguradora = new Seguradora("JT", "(11) 976890-4149", "jt@gmail.com",
				"Rua da Jse, 001");
		System.out.println("* Nova seguradora criada *");
		System.out.println("****************************************************************");
		listaSeguradoras.add(seguradora);
		System.out.println(seguradora);
		System.out.println("****************************************************************");
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date();
		try {
			data = formato.parse("10/10/2000");
		} catch (Exception e) {
			System.out.println("Data inserida inválida!");
		}

		ClientePF clientePF = new ClientePF("Conpec", "Rua Josue de castro 100", "Classe M", "M", "f", data,
				"384.288.278-50", data, 0);
		seguradora.cadastrarCliente(clientePF);
		System.out.println("* Novo ClientePF criado *");
		System.out.println("****************************************************************");
		System.out.println(clientePF);
		System.out.println("****************************************************************");

		ClientePJ clientePJ = new ClientePJ("Conpec JR", "Rua Roxo Moreira 1272", "26.774.450/0001-25", data, 50, 0);
		seguradora.cadastrarCliente(clientePJ);
		System.out.println("* Novo ClientePJ criado *");
		System.out.println("****************************************************************");
		System.out.println(clientePJ);
		System.out.println("****************************************************************");
		Veiculo x = new Veiculo("DYG4124", "RENAUT", "SUV", 2000);
		clientePF.adicionaVeiculo(x);
		System.out.println("* Veículo cadastrado no ClientePF *");
		Veiculo y = new Veiculo("HJX2131", "PEGAUT", "SASD", 2022);
		clientePJ.adicionaVeiculo(y);
		System.out.println("* Veículo cadastrado no ClientePJ *");
		System.out.println("****************************************************************");
		clientePF.listarVeiculos();
		System.out.println("****************************************************************");

		seguradora.gerarSinistro(new Sinistro(new Date(), "Rua do abc", seguradora,
				x, clientePF));
		System.out.println("* Novo sinistro gerado no ClientePF *");
		System.out.println("****************************************************************");
		System.out.println(seguradora.vizualizarSinistro(45));
		System.out.println("****************************************************************");

		seguradora.gerarSinistro(new Sinistro(new Date(), "Rua do ddfer", seguradora,
				clientePJ.getVeiculo("DIK1234"), clientePJ));
		System.out.println("* Novo sinistro gerado no ClientePF *");
		System.out.println("****************************************************************");
		System.out.println(seguradora.vizualizarSinistro(100));
		System.out.println("****************************************************************");

		System.out.println("* Listar Clientes *");
		System.out.println("****************************************************************");
		seguradora.listarClientes();
		System.out.println("****************************************************************");

		System.out.println("* Visualizar sinistro *");
		System.out.println("****************************************************************");
		seguradora.vizualizarSinistro(2634);
		System.out.println("****************************************************************");

		System.out.println("* Listar Sinistros *");
		System.out.println("****************************************************************");
		seguradora.listarSinistros();
		System.out.println("****************************************************************");

		System.out.println("* Calcula Preço Seguro (Conpec) *");
		System.out.println("****************************************************************");
		System.out.println(seguradora.calcularPrecoSeguroCliente(clientePF));
		System.out.println("****************************************************************");
		clientePF.setValorSeguro(seguradora.calcularPrecoSeguroCliente(clientePF));

		System.out.println("* Calcula Preço Seguro (Conpec JR) *");
		System.out.println("****************************************************************");
		System.out.println(seguradora.calcularPrecoSeguroCliente(clientePJ));
		clientePJ.setValorSeguro(seguradora.calcularPrecoSeguroCliente(clientePJ));
		System.out.println("****************************************************************");

		System.out.println("* Calcula receita *");
		System.out.println("****************************************************************");
		System.out.println(seguradora.calcularReceita());
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

	private static void executaOpcoesMenu(MenuOperacoes opcao, ArrayList<Seguradora> listaSeguradora, Scanner scanner)
			throws Exception {
		switch (opcao) {
			case CADASTRAR:
			case LISTAR:
			case EXCLUIR:
				executaSubMenu(opcao, listaSeguradora, scanner);
				break;
			case GERAR_SINISTRO:
				System.out.println("Informe qual o nome da seguradora que deseja cadastrar o cliente: ");
				String nomeSeg = scanner.nextLine();
				boolean found = false;
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				for (Seguradora variavel : listaSeguradora) {
					if (variavel.getNome().equals(nomeSeg)) {
						found = true;
						boolean achoux = false;
						for (Cliente c : variavel.getListaClientes()) {
							System.out.println("Digite seu nome completo: ");
							String nome = scanner.nextLine();
							if (c.getNome().equals(nome)) {
								System.out.println("Digite a data do ocorrido: ");
								String dataS = scanner.nextLine();
								Date data = new Date();
								try {
									data = formato.parse(dataS);
								} catch (Exception e) {
									System.out.println("Data inserida inválida!");
									break;
								}
								System.out.println("Digite a placa do veículo: ");
								String placa = scanner.nextLine();
								for (Veiculo v : c.getListaVeiculos()) {
									if (v.getPlaca().equals(placa)) {
										Sinistro s = new Sinistro(data, placa, variavel, v, c);
										if (variavel.gerarSinistro(s)) {
											achoux = true;
											System.out.println("Sinistro criado com sucesso!");
											c.setValorSeguro(variavel.calcularPrecoSeguroCliente(c));
										}
									}
								}
								if (!achoux) {
									System.out.println("Nenhum veículo encontrado!");
								}
							}
						}
					}
				}
				if (!found)
					System.out.println("Nenhuma seguradora encontrado");
				break;
			case TRANSFERIR_SEGURO:
				System.out.println("Informe qual o nome da seguradora do cliente a transferir o seguro: ");
				nomeSeg = scanner.nextLine();
				boolean found1 = false;
				boolean achou1 = false;
				boolean achou2 = false;
				for (Seguradora variavel : listaSeguradora) {
					if (variavel.getNome().equals(nomeSeg)) {
						found1 = true;
						System.out.println("Informe qual o nome do cliente que transferirá o seguro: ");
						String clienteDoador = scanner.nextLine();
						for (Cliente c : variavel.getListaClientes()) {
							if (c.getNome().equals(clienteDoador)) {
								Cliente cliente1 = c;
								achou1 = true;
								System.out.println("Informe qual o nome do cliente que transferirá o seguro: ");
								String clienteReceptor = scanner.nextLine();
								for (Cliente s : variavel.getListaClientes()) {
									if (c.getNome().equals(clienteReceptor)) {
										Cliente cliente2 = s;
										achou2 = true;
										variavel.transferirSeguro(cliente1, cliente2);
										cliente1.setValorSeguro(variavel.calcularPrecoSeguroCliente(cliente1));
										cliente2.setValorSeguro(variavel.calcularPrecoSeguroCliente(cliente2));
									}
								}
								if (!achou2) {
									System.out.println("Cliente não encontrada!");
									break;
								}
							}
						}
						if (!achou1) {
							System.out.println("Cliente não encontrada!");
							break;
						}
					}
				}
				if (!found1) {
					System.out.println("Seguradora não encontrada!");
					break;
				}
				System.out.println("Seguro transferido com sucesso!");
				break;
			case CALCULAR_RECEITA:
				System.out.println("Informe qual o nome da seguradora que deseja cadastrar o cliente: ");
				nomeSeg = scanner.nextLine();
				found = false;
				for (Seguradora variavel : listaSeguradora) {
					if (variavel.getNome().equals(nomeSeg)) {
						found = true;
						System.out.println("Receita atual: " + variavel.calcularReceita());
					}
				}
				if (!found)
					System.out.println("Nenhuma seguradora encontrado.");
				break;
			case SAIR:
				break;

		}
	}

	private static void executaOpcoesSubMenu(SubMenu opcaoSub, ArrayList<Seguradora> listaSeguradoras, Scanner scanner)
			throws Exception {
		switch (opcaoSub) {
			case CADASTRAR_CLIENTE:
				System.out.println("Informe qual o nome da seguradora que deseja cadastrar o cliente: ");
				String nomeSeg = scanner.nextLine();
				boolean achou = false;
				for (Seguradora s : listaSeguradoras) {
					if (s.getNome().equals(nomeSeg)) {
						achou = true;
						SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
						System.out.println("0 - PF\n1 - PJ");
						int opcao;
						do {
							System.out.println("Digite uma opção: ");
							opcao = Integer.parseInt(scanner.nextLine());
						} while (opcao < 0 || opcao > 1);
						if (opcao == 0) {
							System.out.println("Digite seu nome completo: ");
							String nome = scanner.nextLine();
							System.out.println("Digite seu endereco: ");
							String endereco = scanner.nextLine();
							System.out.println("Digite sua educacao: ");
							String educacao = scanner.nextLine();
							System.out.println("Digite seu genero: ");
							String genero = scanner.nextLine();
							System.out.println("Digite sua classe econômica: ");
							String classeEconomica = scanner.nextLine();
							System.out.println("Digite sua data de licenca: ");
							String dataL = scanner.nextLine();
							Date dataLicenca = new Date();
							Date datanascimento = new Date();
							try {
								dataLicenca = formato.parse(dataL);
							} catch (Exception e) {
								System.out.println("Data inserida inválida!");
								break;
							}
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
							try {
								ClientePF cliente1 = new ClientePF(nome, endereco, educacao, genero, classeEconomica,
										dataLicenca,
										cpf, datanascimento, 0);
								System.out.println("Cliente cadastrado com sucesso!");
								s.cadastrarCliente(cliente1);
								cliente1.setValorSeguro(s.calcularPrecoSeguroCliente(cliente1));
								System.out.println(cliente1.getValorSeguro());
							} catch (Exception e) {
								System.out.println(e.getMessage());
								System.out.println("Erro ao cadastrar o cliente!");
							}

						} else {
							System.out.println("Digite o nome da empresa: ");
							String nome = scanner.nextLine();
							System.out.println("Digite o endereco da empresa: ");
							String endereco = scanner.nextLine();
							System.out.println("Digite o CNPJ da empresa: ");
							String cnpj = scanner.nextLine();
							System.out.println("Digite a data de fundação da empresa: ");
							String dataF = scanner.nextLine();
							Date dataFundacao = new Date();
							try {
								dataFundacao = formato.parse(dataF);
							} catch (Exception e) {
								System.out.println("Data inserida inválida!");
								break;
							}
							System.out.println("Digite a quantidade de funcionários: ");
							int qntF = Integer.parseInt(scanner.nextLine());
							try {
								ClientePJ cliente2 = new ClientePJ(nome, endereco, cnpj, dataFundacao, qntF, qntF);
								s.cadastrarCliente(cliente2);
								System.out.println("Cliente cadastrado com sucesso!");
								cliente2.setValorSeguro(s.calcularPrecoSeguroCliente(cliente2));
								System.out.println(cliente2.getValorSeguro());
							} catch (Exception e) {
								System.out.println(e.getMessage());
								System.out.println("Erro ao cadastrar o cliente!");
							}
						}
					}

				}
				if (!achou) {
					System.out.println("Seguradora nao encontrada.");
				}

				break;
			case CADASTRAR_VEICULO:
				System.out.println("Informe qual o nome da seguradora que deseja cadastrar o veiculo: ");
				nomeSeg = scanner.nextLine();
				boolean found = false;
				for (Seguradora s : listaSeguradoras) {
					if (s.getNome().equals(nomeSeg)) {
						found = true;
						System.out.println("Digite seu nome completo: ");
						String nome = scanner.nextLine();
						achou = false;
						for (Cliente c : s.getListaClientes()) {
							if (c.getNome().equals(nome)) {
								achou = true;
								System.out.println("Digite sua placa: ");
								String placa = scanner.nextLine();
								System.out.println("Digite a marca do seu carro: ");
								String marca = scanner.nextLine();
								System.out.println("Digite o modelo do seu carro: ");
								String modelo = scanner.nextLine();
								System.out.println("Digite o ano de fabricação do seu carro: ");
								int anoFabricacao = Integer.parseInt(scanner.nextLine());
								Veiculo vei = new Veiculo(placa, marca, modelo, anoFabricacao);
								if (c.adicionaVeiculo(vei)) {
									System.out.println("Veiculo cadastrad com sucesso!");
									c.setValorSeguro(s.calcularPrecoSeguroCliente(c));
								} else {
									System.out.println("Erro ao cadastrar o veículo");
								}
							}
						}
						if (!achou)
							System.out.println("Nenhum cliente encontrado");
					}
				}
				if (!found)
					System.out.println("Seguradora nao encontrada.");
				break;
			case CADASTRAR_SEGURADORA:
				// String nome, String telefone, String email, String endereco
				System.out.println("Digite o nome da seguradora que deseja cadastrar: ");
				String nomeSeguradora = scanner.nextLine();
				System.out.println("Digite o número de telefone da seguradora que deseja cadastrar: ");
				String telefone = scanner.nextLine();
				System.out.println("Digite o email da seguradora que deseja cadastrar: ");
				String email = scanner.nextLine();
				System.out.println("Digite o endereco da seguradora que deseja cadastrar: ");
				String endereco = scanner.nextLine();
				Seguradora newSeguradora = new Seguradora(nomeSeguradora, telefone, email, endereco);
				if (listaSeguradoras.add(newSeguradora)) {
					System.out.println("Seguradora cadastrada com sucesso!");
				} else {
					System.out.println("Erro ao cadastrar a seguradora.");
				}
				break;
			case LISTAR_CLIENTES:
				System.out.println("Informe qual o nome da seguradora que deseja listar os clientes: ");
				nomeSeg = scanner.nextLine();
				found = false;
				for (Seguradora s : listaSeguradoras) {
					if (s.getNome().equals(nomeSeg)) {
						found = true;
						s.listarClientes();
					} else {

					}
				}
				if (!found)
					System.out.println("Seguradora nao encontrada.");
				break;
			case LISTAR_SINISTROS:
				System.out.println("Informe qual o nome da seguradora que deseja listar os sinistros: ");
				nomeSeg = scanner.nextLine();
				found = false;
				for (Seguradora s : listaSeguradoras) {
					if (s.getNome().equals(nomeSeg)) {
						found = true;
						s.listarSinistros();
					}
				}
				if (!found)
					System.out.println("Seguradora nao encontrada.");
				break;
			case LISTAR_VEICULOS:
				System.out.println("Informe qual o nome da seguradora que deseja listar os veiculos: ");
				nomeSeg = scanner.nextLine();
				found = false;
				for (Seguradora s : listaSeguradoras) {
					if (s.getNome().equals(nomeSeg)) {
						found = true;
						System.out.println("Digite seu nome completo: ");
						String n = scanner.nextLine();
						achou = false;
						for (Cliente cliente : s.getListaClientes()) {
							if (cliente.getNome().equals(n)) {
								achou = true;
								try {
									if (cliente.getListaVeiculos().size() == 0) {
										throw new Exception("Não há veículos cadastrados!");
									}
								} catch (Exception ex) {
									System.out.println(ex.getMessage());
								} finally {
									cliente.listarVeiculos();
								}
							}
							if (!achou)
								System.out.println("Nenhum cliente encontrado");
						}
					}
				}
				if (!found)
					System.out.println("Seguradora nao encontrada.");
				break;
			case EXCLUIR_CLIENTE:
				System.out.println("Informe qual o nome da seguradora que deseja excluir o cliente: ");
				nomeSeg = scanner.nextLine();
				found = false;
				for (Seguradora s : listaSeguradoras) {
					if (s.getNome().equals(nomeSeg)) {
						found = true;
						System.out.println("Digite seu CPF ou CNPJ: ");
						String c = scanner.nextLine();
						if (s.removeCliente(c)) {
							System.out.println("Cliente removido com sucesso!");
						} else {
							System.out.println("Erro ao remover o cliente.");
						}
					}
				}
				if (!found)
					System.out.println("Seguradora nao encontrada.");
				break;
			case EXCLUIR_SINISTRO:
				System.out.println("Informe qual o nome da seguradora que deseja excluir o sinistro: ");
				nomeSeg = scanner.nextLine();
				found = false;
				for (Seguradora s : listaSeguradoras) {
					if (s.getNome().equals(nomeSeg)) {
						found = true;
						System.out.println("Digite o id do sinistro a seer removido");
						int id = Integer.parseInt(scanner.nextLine());
						achou = false;
						for (Sinistro sinistro : s.getListaSinistros()) {
							if (sinistro.getId() == id) {
								s.getListaSinistros().remove(sinistro);
								sinistro.getCliente()
										.setValorSeguro(s.calcularPrecoSeguroCliente(sinistro.getCliente()));
								found = true;
								break;
							}
						}
						if (achou)
							System.out.println("Sinistro removido com sucesso!");
						else
							System.out.println("Nenhum sinistro encontrado.");
					}
				}
				if (!found)
					System.out.println("Seguradora nao encontrada.");
				break;
			case EXCLUIR_VEICULO:
				System.out.println("Informe qual o nome da seguradora que deseja excluir o veiculo: ");
				nomeSeg = scanner.nextLine();
				found = false;
				for (Seguradora s : listaSeguradoras) {
					if (s.getNome().equals(nomeSeg)) {
						found = true;
						System.out.println("Digite a placa do carro a ser removido: ");
						String placa = scanner.nextLine();
						for (Cliente c : s.getListaClientes()) {
							for (Veiculo vei : c.getListaVeiculos()) {
								if (vei.getPlaca().equals(placa)) {
									if (c.removeVeiculo(vei)) {
										c.setValorSeguro(s.calcularPrecoSeguroCliente(c));
										System.out.println("Veiculo removido com sucesso!");
									} else {
										System.out.println("Nenhum veiculo encontrado.");
									}
								}
							}
						}
					}
				}
				if (!found)
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
