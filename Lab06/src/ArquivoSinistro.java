import java.io.*;
import java.util.ArrayList;

public class ArquivoSinistro implements I_arquivo{
    public boolean gravarDados(String nome, ArrayList<?> listaObjetos){
        String titulos = "id;endereco,;data;condutor;seguro";
        File novo = new File(nome);
        try{
            novo.createNewFile();
            FileWriter escritor = new FileWriter(novo, false);
            escritor.write(titulos);
            for (Sinistro seguro : (ArrayList<Sinistro>)listaObjetos ) {
                escritor.write(seguro.toString());
            }
            escritor.close();
        } catch(Exception e){
            System.out.println(e);
        }
        return true;
    }
    public ArrayList<?> lerDados(String nome){
        return null;
    }
}
