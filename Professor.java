import java.time.LocalDate;
import java.util.List;
public class Professor extends Pessoa implements Funcionario {
    private Nivel nivelProfessor;
    private Formacao formacaoProfessor;
    private List<String> disciplinas;
    private Long matricula;
    private Double salario;
    private String departamento;
    private Integer cargaHoraria;
    private LocalDate dataIngresso;
    public Nivel getNivelProfessor() {
        return nivelProfessor;
    }
    public void setNivelProfessor(Nivel nivelProfessor) {
        this.nivelProfessor = nivelProfessor;
    }
    public Formacao getFormacaoProfessor() {
        return formacaoProfessor;
    }
    public void setFormacaoProfessor(Formacao formacaoProfessor) {
        this.formacaoProfessor = formacaoProfessor;
    }
    public List<String> getDisciplinas() {
        return disciplinas;
    }
    public void setDisciplinas(List<String> disciplinas) {
        this.disciplinas = disciplinas;
    }
    public Long getMatricula() {
        return matricula;
    }
    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }
    public Double getSalario() {
        return salario;
    }
    public void setSalario(Double salario) {
        this.salario = salario;
    }
    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public Integer getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    public LocalDate getDataIngresso() {
        return dataIngresso;
    }
    public void setDataIngresso(LocalDate dataIngresso) {
        this.dataIngresso = dataIngresso;
    }
    public Professor(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco,
            Nivel nivelProfessor, Formacao formacaoProfessor, List<String> disciplinas, Long matricula, Double salario,
            String departamento, Integer cargaHoraria, LocalDate dataIngresso) {
        super(nome, cpf, dataNascimento, genero, endereco);
        this.nivelProfessor = nivelProfessor;
        this.formacaoProfessor = formacaoProfessor;
        this.disciplinas = disciplinas;
        this.matricula = matricula;
        this.salario = salario;
        this.departamento = departamento;
        this.cargaHoraria = cargaHoraria;
        this.dataIngresso = dataIngresso;
    }
@Override
    public Double calculaSalario(){
        //salario base do professor é 4000. Deve ser levado o nivel e formaçao em conta. 5% de aumento a cada nivel, 25% para especializaçao, 50% para mestrado e 75% para doutorado 
        final double salario_base = 4000;
        int nivelAumento = nivelProfessor.ordinal();
        double aumentoNivel = nivelAumento * 0.05;
        double aumentoformacao;
       
        switch (formacaoProfessor) {
            case ESPECIALIZACAO:
                aumentoformacao = 0.25;
                
                break;
            case MESTRADO:
                aumentoformacao = 0.5;
                break;

            case DOUTORADO:
                aumentoformacao = 0.75;
                break;
        
            default:
                aumentoformacao = 0.0; // sem aumento 
                break;
        }
        double salario = salario_base + (salario_base * aumentoNivel) + (salario_base * aumentoformacao); 

        return salario;
        
    }
    
}
// ver o uso do SUPER e dos metodos @OVERRIDE