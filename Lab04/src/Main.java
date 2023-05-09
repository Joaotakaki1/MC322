import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date licencaFormatada = formato.parse("08/10/2007");
		Date nascimento = formato.parse("08/10/2003");
		ClientePF c = new ClientePF("Joao", "Rua Roxo", "EM", "M", "CM",
				licencaFormatada, "38428827850", nascimento);
		System.out.println(c.calculaScore(c));
		MenuOperacoes opcao;
		do {
			Menu();
			opcao = leituraOpcao();
			executaOpcoesMenu(opcao);
		} while (opcao != MenuOperacoes.SAIR);
		System.out.println("Fim do progama");
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

	private static MenuOperacoes leituraOpcao() {
		Scanner scanner = new Scanner(System.in);
		int opcao;
		MenuOperacoes opcaoUsuario;
		do {
			System.out.println("Digite uma opção: ");
			opcao = scanner.nextInt();
		} while (opcao < 0 || opcao > MenuOperacoes.values().length - 1);
		opcaoUsuario = MenuOperacoes.values()[opcao];
		return opcaoUsuario;
	}

	private static SubMenu leituraOpcaoSub(MenuOperacoes selecionado) {
		Scanner scanner = new Scanner(System.in);
		int opcao;
		SubMenu opcaoUsuario;
		do {
			System.out.println("Digite uma opção: ");
			opcao = scanner.nextInt();
		} while (opcao < 0 || opcao > selecionado.getSubmenu().length - 1);
		opcaoUsuario = selecionado.getSubmenu()[opcao];
		return opcaoUsuario;
	}

	private static void executaOpcoesMenu(MenuOperacoes opcao) {
		switch (opcao) {
			case CADASTRAR:
			case LISTAR:
			case EXCLUIR:
				executaSubMenu(opcao);
				break;
			case GERAR_SINISTRO:
				break;
			case TRANSFERIR_SEGURO:
				break;
			case CALCULAR_RECEITA:
				break;
			case SAIR:
				break;

		}
	}

	private static void executaOpcoesSubMenu(SubMenu opcaoSub) {
		switch (opcaoSub) {
			case CADASTRAR_CLIENTE:
				break;
			case CADASTRAR_VEICULO:
				break;
			case CADASTRAR_SEGURADORA:
				break;
			case LISTAR_CLIENTES:
				break;
			case LISTAR_SINISTROS:
				break;
			case LISTAR_VEICULOS:
				break;
			case EXCLUIR_CLIENTE:
				break;
			case EXCLUIR_SINISTRO:
				break;
			case EXCLUIR_VEICULO:
				break;
			case VOLTAR:
				break;

		}
	}

	private static void executaSubMenu(MenuOperacoes opcao) {
		SubMenu opcaoSub;
		do {
			subMenu(opcao);
			opcaoSub = leituraOpcaoSub(opcao);
			executaOpcoesSubMenu(opcaoSub);
		} while (opcaoSub != SubMenu.VOLTAR);
	}
}
