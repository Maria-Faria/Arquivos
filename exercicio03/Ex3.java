package exercicio03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class Ex3 {
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

        ArrayList<PessoaNome> lista = new ArrayList<PessoaNome>();
        
        escolha(lista, nomes, enderecos, cidades, datas, telefones);
    }

    public static void escolha(ArrayList<PessoaNome> lista, ArrayList<String> nomes, ArrayList<String> enderecos, ArrayList<String> cidades, ArrayList<String> datas, ArrayList<String> telefones) {
        String info[] = {"Nomes", "Endereços", "Cidades", "Datas de nascimento", "Telefones", "Todas as informações", "Sair"};
        int op, op2 = 1, op3 = 0, nome = 0, endereco = 0, cidade = 0, data = 0, tel = 0, ct = 0, tudo = 0;

        do{
            op = JOptionPane.showOptionDialog(null, "Quais informações você deseja verificar?", "Selecione uma opção", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, info, 0);

            switch (op) {
                case 0:
                    nome = 1;
                    break;
                
                case 1:
                    endereco = 1;
                    break;
                
                case 2:
                    cidade = 1;
                    break;
                
                case 3:
                    data = 1;
                    break;

                case 4:
                    tel = 1;
                    break;

                case 5:
                    tudo = 1;
                    break;
            }

            if(op != 5 && op != 6) {
                op2 = JOptionPane.showOptionDialog(null, "Deseja verificar outra informação?", "Verificar outra informação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 0);

                if(op2 == JOptionPane.YES_OPTION) {
                    ct++;

                }
            }
        
        }while(op2 == 0);

        if(ct != 0 || tudo == 1) {

            String info2[] = {"Nomes", "Endereços", "Cidades", "Datas de nascimento", "Telefones"};
            op3 = JOptionPane.showOptionDialog(null, "Selecione a informação pela qual você deseja ordenar", "Ordenar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, info2, 0);
        
        }else{
            op3 = op;
        }

        gerarDados(lista, nomes, enderecos, cidades, datas, telefones, op3);
        novoArquivo();
        organizar(lista);
        escrever(lista, nome, endereco, cidade, data, tel, tudo);
    }

    public static void novoArquivo() {
        String nomeArq = "cadastroPersonalizado.txt";

        try{
            CriarArquivo(nomeArq);

        }catch(IOException e) {
            System.out.println("Não foi possível criar o arquivo! " + e);
        }
    }

    public static void gerarDados(ArrayList<PessoaNome> lista, ArrayList<String> nomes, ArrayList<String> enderecos, ArrayList<String> cidades, ArrayList<String> datas, ArrayList<String> telefones, int op3) {
        
        switch(op3) {
            case 0:
                PessoaNome p[] = new PessoaNome[5];

                for(int i = 0; i < 5; i++) {
                    p[i] = new PessoaNome(nomes.get(i), enderecos.get(i), cidades.get(i), datas.get(i), telefones.get(i));
                    lista.add(p[i]);
                }

                break;

            case 1:
                PessoaNome e[] = new PessoaEndereco[5];

                for(int i = 0; i < 5; i++) {
                    e[i] = new PessoaEndereco(nomes.get(i), enderecos.get(i), cidades.get(i), datas.get(i), telefones.get(i));
                    lista.add(e[i]);
                }

                break;

            case 2:
                PessoaNome c[] = new PessoaCidade[5];

                for(int i = 0; i < 5; i++) {
                    c[i] = new PessoaCidade(nomes.get(i), enderecos.get(i), cidades.get(i), datas.get(i), telefones.get(i));
                    lista.add(c[i]);
                }

                break;
            
            case 3:
                PessoaNome d[] = new PessoaData[5];

                for(int i = 0; i < 5; i++) {
                    d[i] = new PessoaData(nomes.get(i), enderecos.get(i), cidades.get(i), datas.get(i), telefones.get(i));
                    lista.add(d[i]);
                }

                break;

            case 4:
                PessoaNome t[] = new PessoaTelefone[5];

                for(int i = 0; i < 5; i++) {
                    t[i] = new PessoaTelefone(nomes.get(i), enderecos.get(i), cidades.get(i), datas.get(i), telefones.get(i));
                    lista.add(t[i]);
                }

                break;
        }
    }

    public static void organizar(ArrayList<PessoaNome> lista) {
        Collections.sort(lista);
    }

    public static void escrever(ArrayList<PessoaNome> lista, int nome, int endereco, int cidade, int data, int tel, int tudo){
        SimpleDateFormat d1 = new SimpleDateFormat("dd/MM/yyyy");

        try{
            FileWriter writer = new FileWriter("cadastroPersonalizado.txt");
            PrintWriter printWriter = new PrintWriter(writer);

            if(tudo == 1 || nome == 1 && endereco == 1 && cidade == 1 || data == 1 && tel == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getNome() + ", " + lista.get(i).getEndereco() + ", " + lista.get(i).getCidade() + ", " + lista.get(i).getData() + ", " + lista.get(i).getTelefone());
                }
            
            }else if (endereco == 1 && cidade == 1 && data == 1 && tel == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getEndereco() + ", " + lista.get(i).getCidade() + ", " + d1.format(lista.get(i).getData()) + ", " + lista.get(i).getTelefone());
                }
            
            }else if(nome == 1 && cidade == 1 && data == 1 && tel == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getNome() + ", " + lista.get(i).getCidade() + ", " + d1.format(lista.get(i).getData()) + ", " + lista.get(i).getTelefone());
                }
            
            }else if(nome == 1 && endereco == 1 && data == 1 && tel == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getNome() + ", " + lista.get(i).getEndereco() + ", " + d1.format(lista.get(i).getData()) + ", " + lista.get(i).getTelefone());
                }
            
            }else if(nome == 1 && endereco == 1 && data == 1 && cidade == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getNome() + ", " + lista.get(i).getEndereco() + ", " + lista.get(i).getCidade() + ", " + d1.format(lista.get(i).getData()));
                }
            
            }else if(nome == 1 && endereco == 1 && tel == 1 && cidade == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getNome() + ", " + lista.get(i).getEndereco() + ", " + lista.get(i).getCidade() + ", " + lista.get(i).getTelefone());
                }
            
            }else if(cidade == 1 && data == 1 && tel == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getCidade() + ", " + d1.format(lista.get(i).getData()) + ", " + lista.get(i).getTelefone());
                }
            }else if(endereco == 1 && data == 1 && tel == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getEndereco() + ", " + d1.format(lista.get(i).getData()) + ", " + lista.get(i).getTelefone());
                }
            
            }else if(endereco == 1 && cidade == 1 && data == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getEndereco() + ", " + lista.get(i).getCidade() + ", " + d1.format(lista.get(i).getData()));
                }
            
            }else if(endereco == 1 && cidade == 1 && tel == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getEndereco() + ", " + lista.get(i).getCidade() + ", " + lista.get(i).getTelefone());
                }

            }else if(nome == 1 && data == 1 && tel == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getNome() + ", " + d1.format(lista.get(i).getData()) + ", " + lista.get(i).getTelefone());
                }
            
            }else if(nome == 1 && data == 1 && cidade == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getNome() + ", " + lista.get(i).getCidade() + ", " + d1.format(lista.get(i).getData()));
                }
            
            }else if(nome == 1 && tel == 1 && cidade == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getNome() + ", " + lista.get(i).getCidade() + ", " + lista.get(i).getTelefone());
                }
            
            }else if(nome == 1 && endereco == 1 && data == 1) {
                for(int i = 0; i < lista.size(); i++) {
                        printWriter.println(lista.get(i).getNome() + ", " + lista.get(i).getEndereco() + ", " + d1.format(lista.get(i).getData()));
                }
                
            }else if(nome == 1 && tel == 1 && endereco == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getNome() + ", " + lista.get(i).getEndereco() + ", " + lista.get(i).getTelefone());
                }
            
            }else if(nome == 1 && endereco == 1 && cidade == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getNome() + ", " + lista.get(i).getEndereco() + ", " + lista.get(i).getCidade());
                }
            
            }else if(tel == 1 && data == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(d1.format(lista.get(i).getData()) + ", " + lista.get(i).getTelefone());
                }

            }else if(cidade == 1 && data == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getCidade() + ", " + d1.format(lista.get(i).getData()));
                }

            }else if(cidade == 1 && tel == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getCidade() + ", " + lista.get(i).getTelefone());
                }
            }else if(endereco == 1 && data == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getEndereco() + ", " + d1.format(lista.get(i).getData()));
                }

            }else if(endereco == 1 && tel == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getEndereco() + ", " + lista.get(i).getTelefone());
                }
            
            }else if(endereco == 1 && cidade == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getEndereco() + ", " + lista.get(i).getCidade());
                }
            
            }else if(nome == 1 && data == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getNome() + ", " + d1.format(lista.get(i).getData()));
                }
            
            }else if(nome == 1 && tel == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getNome() + ", " + lista.get(i).getTelefone());
                }
            
            }else if(nome == 1 && cidade == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getNome() + ", " + lista.get(i).getCidade());
                }
            
            }else if(nome == 1 && endereco == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getNome() + ", " + lista.get(i).getEndereco());
                }
            }else if(nome == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getNome());
                }

            }else if(endereco == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getEndereco());
                }

            }else if(cidade == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getCidade());
                }

            }else if(data == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(d1.format(lista.get(i).getData()));
                }

            }else if(tel == 1) {
                for(int i = 0; i < lista.size(); i++) {
                    printWriter.println(lista.get(i).getTelefone());
                }
            }
         
            printWriter.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }  
    }
}