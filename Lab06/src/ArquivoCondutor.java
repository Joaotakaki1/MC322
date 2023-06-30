import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ArquivoCondutor implements I_arquivo{
    public boolean gravarDados(String nome, ArrayList<?> listaObjetos){
        return false;
    }
    public ArrayList<?> lerDados(String nome){
        ArrayList<Condutor> entradaCondutores = new ArrayList<Condutor>();
        File novo = new File(nome);
        Condutor var;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
        try{
            BufferedReader leitor = new BufferedReader(new FileReader(novo));
            //Como a primeira liha do arquivo contém os títulos, devemos ler ela primeiro
            String linha = leitor.readLine(); 
            while ((linha = leitor.readLine())!= null){
                String dados[] = linha.split(",");
                Date dataNascimento = formato.parse(dados[5]);
                try{
                    var = new Condutor(dados[0],dados[1], dados[3], dados[4], dataNascimento, dados[2]);
                    entradaCondutores.add(var);
                } catch (Exception e){
                    System.out.println(e);
                }
            }
            leitor.close();
        } catch (Exception e){
            System.out.println(e);
        }
        return entradaCondutores;
    }
}
