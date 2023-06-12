public enum SubMenu {
    CADASTRAR_CLIENTE("Cadastrar cliente"),
    CADASTRAR_VEICULO("Cadastrar veiculo"),
    CADASTRAR_SEGURADORA("Cadastrar seguradora"),
    CADASTRAR_SEGUROPF("Cadastrar Seguro Pessoa Física"),
    CADASTRAR_SEGUROPJ("Cadastrar Seguro Pessoa Jurídica"),
    CADASTRAR_FROTA("Cadastrar um condutor"),
    AUTORIZAR_CONDUTOR("Autorizar um condutor"),
    LISTAR_CLIENTES("Listar cliente"),
    LISTAR_SEGUROS("Listar os seguros da seguradora"),
    LISTAR_SINISTROS("Listar sinistros do cliente"),
    LISTAR_VEICULOS("Listar veiculos do cliente"),
    LISTAR_SEGURADORAS("Listar as seguradoras existentes"),
    LISTAR_CONDUTORES("Listar os condutores do seguro"),
    LISTAR_FROTA("Listar as frotas de um cliente"),
    EXCLUIR_CLIENTE("Excluir cliente"),
    EXCLUIR_VEICULO("Excluir veiculo"),
    EXCLUIR_SEGURADORA("Excluir seguradora"),
    EXCLUIR_SINISTRO("Excluir sininstro"),
    EXCLUIR_FROTA("Excluir frota"),
    EXCLUIR_SEGURO("Excluir seguro"),
    EXCLUIR_CONDUTOR("Excluir condutor"),
    VOLTAR("Voltar");

    private final String descricao;

    SubMenu(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
