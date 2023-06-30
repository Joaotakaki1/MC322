import java.util.ArrayList;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ArquivoClientePJ implements I_arquivo {
    public boolean gravarDados(String nome, ArrayList<?> listaObjetos){
        return false;
    }
    public ArrayList<?> lerDados(String nome){
        ArquivoFrota arqVei = new ArquivoFrota();
        ArrayList<Frota> frotas = (ArrayList<Frota>) arqVei.lerDados("./lab06-seguradora_arquivos_v2/frotas.csv");
        ArrayList<ClientePJ> entradaCilentesPJ = new ArrayList<ClientePJ>();
        File novo = new File(nome);
        ClientePJ var;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
        try{
            BufferedReader leitor = new BufferedReader(new FileReader(novo));
            //Como a primeira liha do arquivo contém os títulos, devemos ler ela primeiro
            String linha = leitor.readLine(); 
            while ((linha = leitor.readLine())!= null){
                String dados[] = linha.split(",");
                Date dataFundacao = formato.parse(dados[5]);
                try{
                    var = new ClientePJ(dados[1], dados[3], dados[2],dados[0], dataFundacao, dados[4]);
                    entradaCilentesPJ.add(var);
                    for (Frota f : frotas ){
                        if (f.getCode().equals(dados[0])){
                            var.cadastrarFrota(f);
                        }
                    }
                } catch (Exception e){
                    System.out.println(e);
                }
            }
            leitor.close();
        } catch (Exception e){
            System.out.println(e);
        }
        return entradaCilentesPJ;
    }
}
