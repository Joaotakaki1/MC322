public enum MenuOperacoes {
    CADASTRAR("Cadastros", new SubMenu[] {
            SubMenu.CADASTRAR_CLIENTE,
            SubMenu.CADASTRAR_VEICULO,
            SubMenu.CADASTRAR_SEGURADORA,
            SubMenu.VOLTAR
    }),
    LISTAR("Listar", new SubMenu[] {
            SubMenu.LISTAR_CLIENTES,
            SubMenu.LISTAR_SINISTROS,
            SubMenu.LISTAR_VEICULOS,
            SubMenu.VOLTAR
    }),
    EXCLUIR("Excluir", new SubMenu[] {
            SubMenu.EXCLUIR_CLIENTE,
            SubMenu.EXCLUIR_VEICULO,
            SubMenu.EXCLUIR_SINISTRO,
            SubMenu.VOLTAR
    }),
    GERAR_SINISTRO("Gerar Sinistro", new SubMenu[] { SubMenu.VOLTAR }),
    TRANSFERIR_SEGURO("Transferir Seguro", new SubMenu[] { SubMenu.VOLTAR }),
    CALCULAR_RECEITA("Calcular Receita", new SubMenu[] { SubMenu.VOLTAR }),
    SAIR("SAIR", new SubMenu[] {});

    private final String descricao;
    private final SubMenu[] submenu;

    MenuOperacoes(String descricao, SubMenu[] submenu) {
        this.descricao = descricao;
        this.submenu = submenu;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public SubMenu[] getSubmenu() {
        return this.submenu;
    }
}