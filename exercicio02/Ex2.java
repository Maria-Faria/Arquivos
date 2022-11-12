package exercicio02;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class Ex2 {

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

        ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
        gerarDados(lista, nomes, enderecos, cidades, datas, telefones);
        organizar(lista);
        novoArquivo();
        escrever(lista);
    }

    public static void gerarDados(ArrayList<Pessoa> lista, ArrayList<String> nomes, ArrayList<String> enderecos, ArrayList<String> cidades, ArrayList<String> datas, ArrayList<String> telefones) {
        
        Pessoa p1 = new Pessoa(nomes.get(0), enderecos.get(0), cidades.get(0), datas.get(0), telefones.get(0));
        lista.add(p1);

        Pessoa p2 = new Pessoa(nomes.get(1), enderecos.get(1), cidades.get(1), datas.get(1), telefones.get(1));
        lista.add(p2);
        
        Pessoa p3 = new Pessoa(nomes.get(2), enderecos.get(2), cidades.get(2), datas.get(2), telefones.get(2));
        lista.add(p3);

        Pessoa p4 = new Pessoa(nomes.get(3), enderecos.get(3), cidades.get(3), datas.get(3), telefones.get(3));
        lista.add(p4);

        Pessoa p5 = new Pessoa(nomes.get(4), enderecos.get(4), cidades.get(4), datas.get(4), telefones.get(4));
        lista.add(p5);
    }

    public static void organizar(ArrayList<Pessoa> lista) {
        Collections.sort(lista);
    }

    public static void novoArquivo() {
        String nomeArq = "cadastroPersonalizadoNome.txt";

        try{
            CriarArquivo(nomeArq);

        }catch(IOException e) {
            System.out.println("Não foi possível criar o arquivo! " + e);
        }
    }

    public static void escrever(ArrayList<Pessoa> lista) {

        try{
            FileWriter writer = new FileWriter("cadastroPersonalizadoNome.txt");
            PrintWriter printWriter = new PrintWriter(writer);

            for(int i = 0; i < lista.size(); i++) {
                printWriter.println(lista.get(i).getNome() + ", " + lista.get(i).getEndereco() + ", " + lista.get(i).getCidade() + ", " + lista.get(i).getData() + ", " + lista.get(i).getTelefone() + "\n");

            }

            printWriter.close();
        }catch (IOException e) {

        }  
    }
}