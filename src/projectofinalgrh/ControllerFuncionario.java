
package projectofinalgrh;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class ControllerFuncionario {
    public static void escreverFuncionarios(ArrayList <Funcionario> ListaFuncionarios) throws FileNotFoundException, IOException{
        
        FileOutputStream fos=new FileOutputStream("FicheiroFun.dat",false);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(ListaFuncionarios);
        oos.close();
    }
    public static void escreverFuncionario(Funcionario fun) throws FileNotFoundException, IOException, ClassNotFoundException{
       FileInputStream fis=new FileInputStream("FicheiroFun.dat");
        ObjectInputStream ois=new ObjectInputStream(fis);
        ArrayList <Funcionario> ListaFuncionarios=(ArrayList<Funcionario>)ois.readObject();
        ListaFuncionarios.add(fun);
        escreverFuncionarios(ListaFuncionarios);
         ois.close();
         JOptionPane.showMessageDialog(null, "Funcionario inserido com sucesso");
        //Para Cadastrar Pela primeira vez tem k comentar o fis e o ois e criar um novo array
    }
    public static Funcionario [] LerFicheiro() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis=new FileInputStream("FicheiroFun.dat");
        ObjectInputStream ois=new ObjectInputStream(fis);
        
        ArrayList<Funcionario>ListaFuncionarios=(ArrayList<Funcionario>)ois.readObject();
        Iterator <Funcionario> it=ListaFuncionarios.iterator();
        Funcionario[] fun=new Funcionario[ListaFuncionarios.size()];
      
        int i=0;
        while(it.hasNext()){
            Funcionario fu=it.next();
         
            fun[i]=new Funcionario();
            
             fun[i].setCodigo(fu.getCodigo()); fun[i].setNome(fu.getNome()); fun[i].setAnoContrato(fu.getAnoContrato());
             fun[i].setBancoConta(fu.getBancoConta()); fun[i].setBancoNome(fu.getBancoNome()); fun[i].setBi(fu.getBi());
             fun[i].setCategoria(fu.getCategoria()); fun[i].setContacto(fu.getContacto()); fun[i].setDepartamento(fu.getDepartamento());
             fun[i].setHabili(fu.getHabili()); fun[i].setMorada(fu.getMorada()); fun[i].setNuit(fu.getNuit()); fun[i].setPresencas(fu.getPresencas());
             fun[i].setProfissao(fu.getProfissao()); fun[i].setSalario(fu.getSalario()); fun[i].setSexo(fu.getSexo());
             i++;
           }
        return fun;
    }
    public static void Remover(int codigo) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis=new FileInputStream("FicheiroFun.dat");
        ObjectInputStream ois=new ObjectInputStream(fis);
        
        ArrayList<Funcionario>ListaFuncionarios=(ArrayList<Funcionario>)ois.readObject();
        Iterator <Funcionario> it=ListaFuncionarios.iterator();
        
        while(it.hasNext()){
            Funcionario fu=it.next();
            if(fu.getCodigo()==codigo){
                ListaFuncionarios.remove(ListaFuncionarios.indexOf(fu));
                escreverFuncionarios(ListaFuncionarios);
                JOptionPane.showMessageDialog(null, "Funcionario Removido com sucesso!");
                break;
           }        
        }
    }
    public static void Actualizar(int codigo,double salari, String nome, String sexo, String morada, String habili, String departamento, String nuit, String profissao, String bi, String bancoNome,int bancoConta,String AnoContrato, String c, String categoria) throws FileNotFoundException, IOException, ClassNotFoundException{
         FileInputStream fis=new FileInputStream("FicheiroFun.dat");
        ObjectInputStream ois=new ObjectInputStream(fis);
        
        ArrayList<Funcionario>ListaFuncionarios=(ArrayList<Funcionario>)ois.readObject();
        Iterator <Funcionario> it=ListaFuncionarios.iterator();
        
        while(it.hasNext()){
            Funcionario fu=it.next();
            if(fu.getCodigo()==codigo){
                fu.setNome(nome); fu.setSalario(salari); fu.setSexo(sexo); fu.setMorada(morada); fu.setHabili(habili); fu.setDepartamento(departamento);  fu.setNuit(nuit);
                fu.setProfissao(profissao); fu.setBi(bi); fu.setBancoNome(bancoNome); fu.setBancoConta(bancoConta); fu.setAnoContrato(AnoContrato); fu.setContacto(c);
                fu.setCategoria(categoria);
                escreverFuncionarios(ListaFuncionarios);
                JOptionPane.showMessageDialog(null, "Funcionario Actualizado com sucesso!");
           }        
        }
    }
}
