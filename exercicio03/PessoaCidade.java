package exercicio03;

public class PessoaCidade extends PessoaNome{

    public PessoaCidade(String nome, String endereco, String cidade, String data, String telefone) {
        super(nome, endereco, cidade, data, telefone);
    }

    @Override
    public int compareTo(PessoaNome pessoa) {
        return (this.cidade.compareTo(pessoa.getCidade()));
    }
    
}
