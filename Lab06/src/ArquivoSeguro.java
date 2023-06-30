import java.io.*;
import java.util.ArrayList;

public class ArquivoSeguro implements I_arquivo{
    public boolean gravarDados(String nome, ArrayList<?> listaObjetos){
        String titulos = "id;dataInicio,;dataFim;seguradora;listaSinistros;listacondutores;veiculo/frota;valorMensal";
        File novo = new File(nome);
        try{
            novo.createNewFile();
            FileWriter escritor = new FileWriter(novo, true);
            escritor.write(titulos);
            for (Seguro seguro : (ArrayList<Seguro>)listaObjetos ) {
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
