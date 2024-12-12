import java.util.ArrayList;
public class BancoDAO {
    private ArrayList<Pessoa>funcionario;
    private static BancoDAO instance;

    public ArrayList<Pessoa>getArrayPessoa(){
        
        return funcionario;
    }
  
    public static BancoDAO getInstance(){
      if(instance == null){
        instance = new BancoDAO();

      }
      return instance;
    }
    private BancoDAO(){
        funcionario = new ArrayList<>();
    }


}

//rever todo esse arquivo depois.
