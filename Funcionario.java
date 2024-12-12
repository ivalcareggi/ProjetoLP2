import java.time.LocalDate;
public interface Funcionario {

    Long getMatricula();
    Double getSalario();
    String getDepartamento();
    Integer getCargaHoraria();
    LocalDate getDataIngresso();
    Double calculaSalario();
}