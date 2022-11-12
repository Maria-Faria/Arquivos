package exercicio03;

public class PessoaEndereco extends PessoaNome{

    public PessoaEndereco(String nome, String endereco, String cidade, String data, String telefone) {
        super(nome, endereco, cidade, data, telefone);
    }

    @Override
    public int compareTo(PessoaNome pessoa) {
        return (this.endereco.compareTo(pessoa.getEndereco()));
    }
    
}
