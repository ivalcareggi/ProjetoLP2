import java.io.Serializable;
import java.time.LocalDate;

public class Pessoa implements Serializable{
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private Genero genero;
    private Endereco endereco;

    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public Genero getGenero() {
        return genero;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public Pessoa(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.endereco = endereco;
    }
}
