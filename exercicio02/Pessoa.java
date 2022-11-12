package exercicio02;

public class Pessoa implements Comparable<Pessoa>{
    private String nome, endereco, cidade, data, telefone;

    public Pessoa(String nome, String endereco, String cidade, String data, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.data = data;
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

    public String getData() {
        return data;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public int compareTo(Pessoa pessoa) {
        
        return (this.nome.compareTo(pessoa.getNome()));
    }
}
