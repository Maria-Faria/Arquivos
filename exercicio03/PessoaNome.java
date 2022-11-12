package exercicio03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PessoaNome implements Comparable<PessoaNome>{
    protected String nome, endereco, cidade, telefone;
    protected Date data;
    private int op;

    public PessoaNome(String nome, String endereco, String cidade, String data, String telefone) {
        SimpleDateFormat d1 = new SimpleDateFormat("dd/MM/yyyy");
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;

        try {
            this.data = d1.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public Date getData() {
        return data;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }

    @Override
    public int compareTo(PessoaNome pessoa) {
        /*if(this.op == 0) {
            return (this.nome.compareTo(pessoa.getNome()));

        }else if(this.op == 1) {
            return (this.endereco.compareTo(pessoa.getEndereco()));
        
        }else if(this.op == 2) {
            return (this.cidade.compareTo(pessoa.getCidade()));
        
        }else if(this.op == 3) {
            return (this.data.compareTo(pessoa.getData()));
        
        }else if(this.op == 4) {
            return (this.telefone.compareTo(pessoa.getTelefone()));
        }
        
        return 0;*/
        return (this.nome.compareTo(pessoa.getNome()));

    }
}
