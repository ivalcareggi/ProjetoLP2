import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Operacoes {

    public void cadastrarProfessor(){
        BancoDAO banco = BancoDAO.getInstance();
        Professor professor = new Professor(
                "João da Silva",
                "123.456.789-00",
                LocalDate.of(1985, 3, 15),
                Genero.MASC,
                new Endereco("Rua das Flores", 123, "Centro", "São Paulo", "12345-678"),
                Nivel.III,
                Formacao.MESTRADO,
                List.of("Cálculo", "Álgebra Linear"),
                1001L,
                4000.0,
                "Departamento de Matemática",
                20,
                LocalDate.of(2015, 6, 1)
        );
        banco.getArrayPessoa().add(professor);

        System.out.println("Professor cadastrado com sucesso!");

    }


    public void cadastrarTecnicoADM(){
        BancoDAO banco = BancoDAO.getInstance();
        TecnicoAdm tecnicoAdm = new TecnicoAdm(null,null, null, null, null, null, null, null, null, null, null, null, null, null);
        banco.getArrayPessoa().add(tecnicoAdm);
        System.out.println("Tecnico cadastrado com sucesso!");

    }
    public void listarProfessores(){
        BancoDAO banco = BancoDAO.getInstance();
        for(Pessoa p : banco.getArrayPessoa()){
            if(p instanceof Professor){
                System.out.println(p);
            }

        }
    }
    public void listarTecnicos(){
        BancoDAO banco = BancoDAO.getInstance();
        for(Pessoa p : banco.getArrayPessoa()){
            if(p instanceof TecnicoAdm){
                System.out.println(p);
            }

        }
    }

    private Professor acharProfessor(int matricula){
        BancoDAO banco = BancoDAO.getInstance();
        for(Pessoa p : banco.getArrayPessoa()){
            if(p instanceof Professor){
                if(((Professor) p).getMatricula() == matricula){
                    return (Professor)p;

                }
            }

        }
        return null;
    }

    public void deletarProfessor(int matricula){
        BancoDAO banco = BancoDAO.getInstance();
        Professor p = acharProfessor(matricula);
        if(p == null){
            System.out.println("Professor não encontrado");
        }
        banco.getArrayPessoa().remove(p);

    }
    public void buscarProfessor(int matricula){

        Professor p = acharProfessor(matricula);
        if(p == null){
            System.out.println("Professor não encontrado");

        }
        System.out.println(p);
    }

    private TecnicoAdm acharTecnico(int matricula){
        BancoDAO banco = BancoDAO.getInstance();
        for(Pessoa t : banco.getArrayPessoa()){
            if(t instanceof TecnicoAdm){
                if(((TecnicoAdm) t).getMatricula() == matricula){
                    return (TecnicoAdm)t;

                }
            }

        }
        return null;
    }

    public void deletarTecnico(int matricula){
        BancoDAO banco = BancoDAO.getInstance();
        TecnicoAdm t = acharTecnico(matricula);
        if(t == null){
            System.out.println("Tecnico não encontrado");

        }
        banco.getArrayPessoa().remove(t);

    }
    public void buscarTecnico(int matricula){
        TecnicoAdm t = acharTecnico(matricula);
        if(t == null){
            System.out.println("Tecnico não encontrado");
        }
        System.out.println(t);
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        Operacoes operacoes = new Operacoes();
        int opcao;

        do {
            System.out.println("=== Menu Interativo ===");
            System.out.println("1. Cadastrar Professor");
            System.out.println("2. Cadastrar Técnico ADM");
            System.out.println("3. Listar Professores");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    operacoes.cadastrarProfessor();
                    break;
                case 2:
                    operacoes.cadastrarTecnicoADM();
                    break;
                case 3:
                    operacoes.listarProfessores();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
                    break;
            }
        } while (opcao != 4);

        scanner.close();
    }

    public static void main(String[] args) {
        Operacoes operacoes = new Operacoes();
        operacoes.exibirMenu();
    }


}
// pega o professor pela matricula , ou seja, percorre array - matricula -> professor , retorna professor com x matricula 