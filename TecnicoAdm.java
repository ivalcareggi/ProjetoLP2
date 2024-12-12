import java.time.LocalDate;

public class TecnicoAdm extends Pessoa implements Funcionario{
    private Nivel niveltecnico;
    private Formacao formacaoTecnico;
    private Boolean insalubridade;
    private Boolean funcaoGratificada;
    private Long matricula;
    private Double salario;
    private String departamento;
    private Integer cargaHoraria;
    private LocalDate dataIngresso;
    public Nivel getNiveltecnico() {
        return niveltecnico;
    }
    public void setNiveltecnico(Nivel niveltecnico) {
        this.niveltecnico = niveltecnico;
    }
    public Formacao getformacaoTecnico(){
        return formacaoTecnico;
    }
    public void setformacaoTecnico(Formacao formacaoTecnico){
        this.formacaoTecnico = formacaoTecnico;
    }
    public Boolean getInsalubridade() {
        return insalubridade;
    }
    public void setInsalubridade(Boolean insalubridade) {
        this.insalubridade = insalubridade;
    }
    public Boolean getFuncaoGratificada() {
        return funcaoGratificada;
    }
    public void setFuncaoGratificada(Boolean funcaoGratificada) {
        this.funcaoGratificada = funcaoGratificada;
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
    public TecnicoAdm(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco,
            Nivel niveltecnico, Formacao formacaoTecnico, Boolean insalubridade, Boolean funcaoGratificada, Long matricula, Double salario,
            String departamento, Integer cargaHoraria, LocalDate dataIngresso) {
        super(nome, cpf, dataNascimento, genero, endereco);
        this.niveltecnico = niveltecnico;
        this.formacaoTecnico = formacaoTecnico;
        this.insalubridade = insalubridade;
        this.funcaoGratificada = funcaoGratificada;
        this.matricula = matricula;
        this.salario = salario;
        this.departamento = departamento;
        this.cargaHoraria = cargaHoraria;
        this.dataIngresso = dataIngresso;
    }
    public Double calculaSalario() {
        // O cálculo do salário do Técnico leva em conta o nível e a formação
        // (acrescente 3% a cada nível e 25% para especialização, 50% para mestrado e 75% para doutorado)
        // acrescente 25% caso tenha insalubridade e 50% caso tenha função gratificada.
        final double salario_base = 2500;
        int nivelAumento = niveltecnico.ordinal(); 
        double aumentoNivel = nivelAumento * 0.03; 
        double aumentoformacao;
    
      
        switch (formacaoTecnico) {
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
                aumentoformacao = 0.0;
                break;
        }
    
     
        double aumento = 0.0;
    
        if (insalubridade) {
            aumento += salario_base * 0.25; 
        }
    
        if (funcaoGratificada) {
            aumento += salario_base * 0.5; 
        }
    
     
        double salario = salario_base 
                         + (salario_base * aumentoNivel) 
                         + (salario_base * aumentoformacao) 
                         + aumento;
    
        return salario;
    }

}
