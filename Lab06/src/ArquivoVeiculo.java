import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ArquivoVeiculo implements I_arquivo {
    public boolean gravarDados(String nome, ArrayList<?> listaObjetos){
        return false;
    }
    public ArrayList<?> lerDados(String nome){
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
        File arquivo = new File(nome);
        try{
            BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
            //Como a primeira liha do arquivo contém os títulos, devemos ler ela primeiro
            String linha = leitor.readLine(); 
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            while ((linha = leitor.readLine())!= null){
                String dados[] = linha.split(",");
                try{
                    //String placa, String marca, String modelo, int anoFabricacao
                    veiculos.add(new Veiculo(dados[0], dados[1], dados[2], Integer.parseInt(dados[3])));
                } catch (Exception e){
                    System.out.println(e);
                }
            }
            leitor.close();
        } catch (Exception e){
            System.out.println(e);
        }
        return veiculos;
    }
}
