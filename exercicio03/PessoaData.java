package exercicio03;

public class PessoaData extends PessoaNome{

    public PessoaData(String nome, String endereco, String cidade, String data, String telefone) {
        super(nome, endereco, cidade, data, telefone);
    }

    @Override
    public int compareTo(PessoaNome pessoa) {
        return (this.data.compareTo(pessoa.getData()));
    }
    
}
