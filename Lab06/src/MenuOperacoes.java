public enum MenuOperacoes {
    CADASTRAR("Cadastros", new SubMenu[] {
            SubMenu.CADASTRAR_CLIENTE,
            SubMenu.CADASTRAR_VEICULO,
            SubMenu.CADASTRAR_SEGURADORA,
            SubMenu.CADASTRAR_SEGUROPF,
            SubMenu.CADASTRAR_SEGUROPJ,
            SubMenu.CADASTRAR_FROTA,
            SubMenu.AUTORIZAR_CONDUTOR,
            SubMenu.VOLTAR
    }),
    LISTAR("Listar", new SubMenu[] {
            SubMenu.LISTAR_CLIENTES,
            SubMenu.LISTAR_SEGUROS,
            SubMenu.LISTAR_SINISTROS,
            SubMenu.LISTAR_FROTA,
            SubMenu.LISTAR_CONDUTORES,
            SubMenu.LISTAR_VEICULOS,
            SubMenu.LISTAR_SEGURADORAS,
            SubMenu.VOLTAR
    }),
    EXCLUIR("Excluir", new SubMenu[] {
            SubMenu.EXCLUIR_CLIENTE,
            SubMenu.EXCLUIR_SEGURADORA,
            SubMenu.EXCLUIR_VEICULO,
            SubMenu.EXCLUIR_FROTA,
            SubMenu.EXCLUIR_CONDUTOR,
            SubMenu.EXCLUIR_SEGURO,
            SubMenu.EXCLUIR_SINISTRO,
            SubMenu.VOLTAR
    }),
    GERAR_SINISTRO("Gerar Sinistro", new SubMenu[] { SubMenu.VOLTAR }),
    TRANSFERIR_SEGURO("Transferir Seguro", new SubMenu[] { SubMenu.VOLTAR }),
    CALCULAR_RECEITA("Calcular Receita", new SubMenu[] { SubMenu.VOLTAR }),
    CALCULAR_SEGURO("Calcular Seguro", new SubMenu[] { SubMenu.VOLTAR }),
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