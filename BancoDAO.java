import java.util.ArrayList;
import java.io.*;
public class BancoDAO implements Serializable {

    private ArrayList<Pessoa>funcionario;
    private static BancoDAO instance;

    public ArrayList<Pessoa>getArrayPessoa(){

        return funcionario;
    }

    public static BancoDAO getInstance() {
        if (instance == null) {
            instance = carregarDados();
            if (instance == null) {
                instance = new BancoDAO();
            }
        }
        return instance;
    }
    private BancoDAO(){
        funcionario = new ArrayList<>();
    }


    public void salvarDados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("funcionarios.bin"))) {
            oos.writeObject(instance);
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }


    public static BancoDAO carregarDados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("funcionarios.bin"))) {
            return (BancoDAO) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de dados não encontrado. Criando um novo.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar os dados: " + e.getMessage());
        }
        return null;
    }
}