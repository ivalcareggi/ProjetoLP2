import java.util.Scanner;

public class Main {
    public static void showMenu() {
        System.out.println("1. Cadastrar professor");
        System.out.println("2. Cadastrar técnico administrativo");
        System.out.println("3. Listar professores");
        System.out.println("4. Listar técnico administrativo");
        System.out.println("5. Apagar professor");
        System.out.println("6. Apagar técnico administrativo");
        System.out.println("7. Procurar professor por matrícula");
        System.out.println("8. Procurar técnico administrativo por matrícula");
        System.out.println("9. Calcular salário do professor");
        System.out.println("10. Calcular salário do técnico administrativo");
        System.out.println("0. Encerrar programa");
        System.out.println("Digite a opção escolhida:");
    }

    public static void main(String[] args) {
        Operacoes operacoes = new Operacoes();
        Scanner scan = new Scanner(System.in);
        boolean running = true;

        while (running) {
            showMenu();
            int answer = scan.nextInt();
            scan.nextLine(); // Consumir a linha restante

            switch (answer) {
                case 0:
                    running = false;
                    break;
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
                    operacoes.listarTecnicos();
                    break;
                case 5:
                    System.out.println("Digite a matrícula do professor para apagar:");
                    int matriculaProfessor = scan.nextInt();
                    operacoes.deletarProfessor(matriculaProfessor);
                    break;
                case 6:
                    System.out.println("Digite a matrícula do técnico administrativo para apagar:");
                    int matriculaTecnico = scan.nextInt();
                    operacoes.deletarTecnico(matriculaTecnico);
                    break;
                case 7:
                    System.out.println("Digite a matrícula do professor para buscar:");
                    int matriculaBuscarProfessor = scan.nextInt();
                    operacoes.buscarProfessor(matriculaBuscarProfessor);
                    break;
                case 8:
                    System.out.println("Digite a matrícula do técnico administrativo para buscar:");
                    int matriculaBuscarTecnico = scan.nextInt();
                    operacoes.buscarTecnico(matriculaBuscarTecnico);
                    break;
                case 9:
                    operacoes.calcularSalarioProfessor();
                    break;
                case 10:
                    operacoes.calcularSalarioTecnicoAdm();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
