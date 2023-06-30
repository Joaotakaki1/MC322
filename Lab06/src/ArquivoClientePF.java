import java.util.ArrayList;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ArquivoClientePF implements I_arquivo {
    @Override
    
    public boolean gravarDados(String nome, ArrayList<?> listaObjetos){
        return false;
    }

    @Override

    public ArrayList<?> lerDados(String nome){
        ArquivoVeiculo arqVei = new ArquivoVeiculo();
        ArrayList<Veiculo> veiculos = (ArrayList<Veiculo>) arqVei.lerDados("./lab06-seguradora_arquivos_v2/veiculos.csv");
        ArrayList<ClientePF> entradaClientesPF = new ArrayList<ClientePF>();
        File novo = new File(nome);
        ClientePF var;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
        try{
            BufferedReader leitor = new BufferedReader(new FileReader(novo));
            //Como a primeira liha do arquivo contém os títulos, devemos ler ela primeiro
            String linha = leitor.readLine(); 
            while ((linha = leitor.readLine())!= null){
                String dados[] = linha.split(",");
                Date dataNascimento = formato.parse(dados[7]);
                try{
                    //(String nome, String endereco, String educacao, String genero, String cpf, Date dataNascimento, String email, String telefone)
                    //CPF_CLIENTE,NOME_CLIENTE,TELEFONE_CLIENTE,ENDERECO_CLIENTE,EMAIL_CLIENTE,SEXO,ENSINO,DATA_NASCIMENTO,PLACA_VEICULO_CLIENTE1
                    var = new ClientePF(dados[1], dados[3], dados[6],dados[5],dados[0], dataNascimento, dados[4], dados[2]);
                    entradaClientesPF.add(var);
                    for (Veiculo v : veiculos){
                        if (v.getPlaca().equals(dados[8])){
                            var.cadastrarVeiculo(v);
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
        return entradaClientesPF;
    }
}
