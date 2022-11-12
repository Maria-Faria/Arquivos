package exercicio03;

public class PessoaTelefone extends PessoaNome{

    public PessoaTelefone(String nome, String endereco, String cidade, String data, String telefone) {
        super(nome, endereco, cidade, data, telefone);
    }

    @Override
    public int compareTo(PessoaNome pessoa) {
        return (this.telefone.compareTo(pessoa.getTelefone()));
    }
    
}
