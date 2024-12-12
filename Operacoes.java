public class Operacoes {

    public void cadastrarProfessor(){
      
        BancoDAO banco = BancoDAO.getInstance();
        Professor professor = new Professor(null, null, null, null, null, null, null, null, null, null, null, null, null);
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
    
}
// pega o professor pela matricula , ou seja, percorre array - matricula -> professor , retorna professor com x matricula 