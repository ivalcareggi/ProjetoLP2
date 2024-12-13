import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class Operacoes {
    private static Scanner scan = new Scanner(System.in);

    public void cadastrarProfessor(){
        BancoDAO banco = BancoDAO.getInstance();

        System.out.println("Digite o nome do professor");
        String nome = scan.nextLine();

        System.out.println("Digite o CPF do professor");
        String cpf = scan.nextLine();

        System.out.println("Digite a data de nascimento (yyyy-mm-dd)");
        LocalDate dataNascimento = LocalDate.parse(scan.nextLine());

        System.out.println("Digite o gênero (MASC, FEM OU OUTRO");
        Genero genero = Genero.valueOf(scan.nextLine().toUpperCase());

        System.out.println("Digite o endereço(rua, número, bairro, cidade,cep) aperte enter a cada dado diferente");
        String rua = scan.nextLine();

        int numero = Integer.parseInt(scan.nextLine());
        String bairro = scan.nextLine();
        String cidade = scan.nextLine();
        String cep = scan.nextLine();

        Endereco endereco = new Endereco(rua, numero, bairro, cidade, cep);

        System.out.println("Digite o nível (I, II, III, IV, V, VI, VII, VIII)");
        Nivel nivel = Nivel.valueOf(scan.nextLine().toUpperCase());

        System.out.println("Digite a formação (ESPECIALIZACAO, MESTRADO, DOUTORADO)");
        Formacao formacao = Formacao.valueOf(scan.nextLine().toUpperCase());

        System.out.println("Digite as disciplinas ministradas(separe por vírgulas)");
        List<String>disciplinas = List.of(scan.nextLine().split(","));

        System.out.println("Digite o número da matrícula:");
        long matricula = Long.parseLong(scan.nextLine());

        System.out.println("Digite o departamento:");
        String departamento = scan.nextLine();

        System.out.println("Digite a carga horária semanal:");
        int cargaHoraria = Integer.parseInt(scan.nextLine());

        System.out.println("Digite a data de ingresso (formato: yyyy-mm-dd):");
        LocalDate dataEntrada = LocalDate.parse(scan.nextLine());

        Professor professor = new Professor(nome, cpf, dataNascimento, genero, endereco, nivel, formacao, disciplinas, matricula, departamento, cargaHoraria, dataEntrada);
        professor.setSalario(professor.calculaSalario());

        banco.getArrayPessoa().add(professor);
        banco.salvarDados();

        System.out.println("Professor cadastrado com sucesso!");

    }


    public void cadastrarTecnicoADM(){
        BancoDAO banco = BancoDAO.getInstance();
        System.out.println("Digite o nome do técnico:");
        String nome = scan.nextLine();

        System.out.println("Digite o CPF do técnico:");
        String cpf = scan.nextLine();

        System.out.println("Digite a data de nascimento (formato: yyyy-mm-dd):");
        LocalDate dataNascimento = LocalDate.parse(scan.nextLine());

        System.out.println("Digite o gênero (MASC, FEM, OUTRO):");
        Genero genero = Genero.valueOf(scan.nextLine().toUpperCase());

        System.out.println("Digite o endereço (rua, número, bairro, cidade, cep):");
        String rua = scan.nextLine();
        int numero = Integer.parseInt(scan.nextLine());
        String bairro = scan.nextLine();
        String cidade = scan.nextLine();
        String cep = scan.nextLine();
        Endereco endereco = new Endereco(rua, numero, bairro, cidade, cep);

        System.out.println("Digite o nível (I, II, III, IV, VI, VII, VIII):");
        Nivel nivel = Nivel.valueOf(scan.nextLine().toUpperCase());

        System.out.println("Digite a formação (MESTRADO, DOUTORADO, ESPECIALIZACAO):");
        Formacao formacao = Formacao.valueOf(scan.nextLine().toUpperCase());

        System.out.println("Insalubridade? (true/false):");
        boolean insalubre = Boolean.parseBoolean(scan.nextLine());

        System.out.println("Tem função gratificada (true/false):");
        boolean gratif = Boolean.parseBoolean(scan.nextLine());

        System.out.println("Digite o número da matrícula:");
        long matricula = Long.parseLong(scan.nextLine());


        System.out.println("Digite o setor:");
        String setor = scan.nextLine();

        System.out.println("Digite a carga horária semanal:");
        int cargaHoraria = Integer.parseInt(scan.nextLine());

        System.out.println("Digite a data de ingresso (formato: yyyy-mm-dd):");
        LocalDate dataEntrada = LocalDate.parse(scan.nextLine());


        TecnicoAdm tecnicoAdm = new TecnicoAdm(nome, cpf, dataNascimento, genero, endereco, nivel, formacao, insalubre, gratif, matricula, setor, cargaHoraria, dataEntrada);
        tecnicoAdm.setSalario(tecnicoAdm.calculaSalario());
        banco.getArrayPessoa().add(tecnicoAdm);
        banco.salvarDados();
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

    public void calcularSalarioProfessor(){
        System.out.println("Digite a matrícula do professor:");
        int matricula = scan.nextInt();
        Professor prof = acharProfessor(matricula);
        if(prof == null){
            System.out.println("Professor não encontrado");
            return;
        }
        Double salario = prof.calculaSalario();
        System.out.println("O salário do professor" + prof.getNome()+ "é R$" + salario);
    }
    public void calcularSalarioTecnicoAdm() {
        System.out.println("Digite a matrícula do técnico administrativo:");
        int matricula = scan.nextInt();
        TecnicoAdm tecnicoAdm = acharTecnico(matricula);
        if(tecnicoAdm == null){
            System.out.println("Técnico não encontrado");
            return;
        }
        Double salario = tecnicoAdm.calculaSalario();
        System.out.println("O salário do técnico administrativo " + tecnicoAdm.getNome() + " é R$ " + salario);
    }




}
