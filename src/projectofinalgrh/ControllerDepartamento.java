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

public class ControllerDepartamento {
  // static ArrayList ListaDepartamentos=new ArrayList();
    
    public static void escreverDepartamentos(ArrayList <Departamento> ListaDepartamentos) throws FileNotFoundException, IOException{
        FileOutputStream fos=new FileOutputStream("FicheiroDep.dat",false);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(ListaDepartamentos);
        oos.close();
      
        }
    public static void escreverDepartamento(Departamento dep) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis=new FileInputStream("FicheiroDep.dat");
        try (ObjectInputStream ois = new ObjectInputStream(fis)) {
            ArrayList<Departamento> ListaDepartamentos = (ArrayList<Departamento>)ois.readObject();
            
            ListaDepartamentos.add(dep);
            escreverDepartamentos(ListaDepartamentos);
              JOptionPane.showMessageDialog(null, "Departamento Inserido Com Sucesso");
        }
        
    }
    public static Departamento [] LerFicheiro() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis=new FileInputStream("FicheiroDep.dat");
        ObjectInputStream ois=new ObjectInputStream(fis);
        
        ArrayList<Departamento>ListaDepartamentos=(ArrayList<Departamento>)ois.readObject();
        Iterator <Departamento> it=ListaDepartamentos.iterator();
        Departamento depart[]=new Departamento[ListaDepartamentos.size()];
      
        int i=0;
        while(it.hasNext()){
            Departamento dep=it.next();
         
            depart[i]=new Departamento();
            
             depart[i].setCodigo(dep.getCodigo());
             depart[i].setNome(dep.getNome());
             i++;
           }
        
        return depart;
    }
    public static void Remover(int codigo) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis=new FileInputStream("FicheiroDep.dat");
        try (ObjectInputStream ois = new ObjectInputStream(fis)) {
            ArrayList<Departamento> ListaDepartamentos = (ArrayList<Departamento>)ois.readObject();
            Iterator <Departamento> it=ListaDepartamentos.iterator();
            while(it.hasNext()){
            Departamento dep=it.next();
            
             if(dep.getCodigo()==codigo){
                 ListaDepartamentos.remove(ListaDepartamentos.indexOf(dep));
                 escreverDepartamentos(ListaDepartamentos);
                 JOptionPane.showMessageDialog(null, "Departamento Eliminado Com Sucesso");
                 break;
             }
           }
        }
    }
    public static void Actualizar(int codigo,String nome) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis=new FileInputStream("FicheiroDep.dat");
        ObjectInputStream ois=new ObjectInputStream(fis);
        
        ArrayList<Departamento>ListaDepartamentos=(ArrayList<Departamento>)ois.readObject();
        Iterator <Departamento> it=ListaDepartamentos.iterator();
        
        while(it.hasNext()){
            Departamento dep=it.next();
            if(dep.getCodigo()==codigo){
                dep.setNome(nome);
                escreverDepartamentos(ListaDepartamentos);
                JOptionPane.showMessageDialog(null, "Departamento Actualizado com Sucesso");
            }  
        }
    }
}
    
