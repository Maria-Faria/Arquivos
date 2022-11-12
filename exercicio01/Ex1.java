package exercicio01;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ex1 {

    public static File CriarArquivo(String nomeArq) throws IOException{
        
        File f = new File(nomeArq);
        
        boolean success = f.createNewFile();  
    
        if (success) {  
            JOptionPane.showMessageDialog(null,"Arquivo '" + nomeArq + "' criado com sucesso!");  
        } else {  
            JOptionPane.showMessageDialog(null,"Arquivo '" + nomeArq + "' já existe!");
        }  
        
        return f;
    }

    public static ArrayList<String> LerArquivo (File nomeArq){
        
        ArrayList <String> strList = new ArrayList<>();
        try {
            
            FileReader fr = new FileReader(nomeArq);
            BufferedReader in = new BufferedReader(fr);    
            String str = in.readLine();

            while (str != null) {
                strList.add(str);
                str = in.readLine();
            }
            
            in.close();
        
        }
        catch (IOException e) {
            System.out.println("Não foi possível ler dados do arquivo! " + e);
        }
        
        return strList;
    }

    //----------------------------- MAIN ---------------------------------------------------
    public static void main(String[] args) {
        
        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<String> enderecos = new ArrayList<>();
        ArrayList<String> cidades = new ArrayList<>();
        ArrayList<String> datas = new ArrayList<>();
        ArrayList<String> telefones = new ArrayList<>();

        try{
            File f = CriarArquivo("nome.txt");
            nomes = LerArquivo(f);

            File f1 = CriarArquivo("endereco.txt");
            enderecos = LerArquivo(f1);

            File f2 = CriarArquivo("cidade.txt");
            cidades = LerArquivo(f2);

            File f3 = CriarArquivo("datanascimento.txt");
            datas = LerArquivo(f3);

            File f4 = CriarArquivo("telefone.txt");
            telefones = LerArquivo(f4);
        
        }catch(IOException e) {
            System.out.println("Arquivo não criado! " + e);
        } 

        novoArquivo();
        escrever(nomes, enderecos, cidades, datas, telefones);
    }

    public static void novoArquivo() {
        String nomeArq = "cadastroIntegral.txt";

        try{
            CriarArquivo(nomeArq);

        }catch(IOException e) {
            System.out.println("Não foi possível criar o arquivo! " + e);
        }
    }

    public static void escrever(ArrayList<String> nomes, ArrayList<String> enderecos, ArrayList<String> cidades, ArrayList<String> datas, ArrayList<String> telefones) {

        try{
            FileWriter writer = new FileWriter("cadastroIntegral.txt");
            PrintWriter printWriter = new PrintWriter(writer);

            for(int i = 0; i < nomes.size(); i++) {
                printWriter.println(nomes.get(i) + ", " + enderecos.get(i) + ", " + cidades.get(i) + ", " + datas.get(i) + ", " + telefones.get(i) + "\n");

            }

            printWriter.close();
        }catch (IOException e) {

        }  
    }
}