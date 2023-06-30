import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ArquivoFrota implements I_arquivo {
    public boolean gravarDados(String nome, ArrayList<?> listaObjetos){
        return false;
    }
    public ArrayList<?> lerDados(String nome){
        ArquivoVeiculo arqVei = new ArquivoVeiculo();
        ArrayList<Veiculo> veiculos = (ArrayList<Veiculo>) arqVei.lerDados("./lab06-seguradora_arquivos_v2/veiculos.csv");
        ArrayList<Frota> frotas = new ArrayList<Frota>();
        File arquivo = new File(nome);
        Frota f;
        try{
            BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
            //Como a primeira liha do arquivo contém os títulos, devemos ler ela primeiro
            String linha = leitor.readLine(); 
            while ((linha = leitor.readLine())!= null){
                String dados[] = linha.split(",");
                try{
                    //ID_FROTA,PLACA_VEICULO1,PLACA_VEICULO2,PLACA_VEICULO3
                    f = new Frota(dados[0]); 
                    frotas.add(new Frota(dados[0]));
                    for (int i = 1; i < 4; i++){
                        for (Veiculo v : veiculos){
                            if (v.getPlaca().equals(dados[i])){
                                f.addVeiculo(v);
                            }
                        }
                    }
                    frotas.add(f);
                } catch (Exception e){
                    System.out.println(e);
                }
            }
            leitor.close();
        } catch (Exception e){
            System.out.println(e);
        }
        return frotas;
    }
}
