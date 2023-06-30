import java.util.ArrayList;

public interface I_arquivo {
    public boolean gravarDados(String nome, ArrayList<?> listaObjetos);
    public ArrayList<?> lerDados(String nome);
}
