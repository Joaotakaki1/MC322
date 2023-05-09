public enum SubMenu {
    CADASTRAR_CLIENTE("Cadastrar cliente"),
    CADASTRAR_VEICULO("Cadastrar veiculo"),
    CADASTRAR_SEGURADORA("Cadastrar seguradora"),
    LISTAR_CLIENTES("Listar cliente"),
    LISTAR_SINISTROS("Listar sinistros"),
    LISTAR_VEICULOS("Listar veiculo"),
    EXCLUIR_CLIENTE("Excluir cliente"),
    EXCLUIR_VEICULO("Excluir veiculo"),
    EXCLUIR_SINISTRO("Excluir sininstro"),
    VOLTAR("Voltar");

    private final String descricao;

    SubMenu(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
