
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



public class ControllerConcurso {
    
    public static void EscreverConcursos(ArrayList <Concurso> ListaConcurso) throws FileNotFoundException, IOException{
         FileOutputStream fos=new FileOutputStream("FicheiroConcurso.dat",false);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(ListaConcurso);
        oos.close();
        
    }
    public static void escreverConcurso(Concurso co) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis=new FileInputStream("FicheiroConcurso.dat");
       ObjectInputStream ois=new ObjectInputStream(fis);
        ArrayList<Concurso> ListaConcurso= (ArrayList<Concurso>)ois.readObject();
        
        ListaConcurso.add(co);
        EscreverConcursos(ListaConcurso);
      //  JOptionPane.showMessageDialog(null, "Concurso Inserido com Sucesso");
    }
    public static Concurso[] LerFicheiro() throws FileNotFoundException, IOException, ClassNotFoundException{
         FileInputStream fis=new FileInputStream("FicheiroConcurso.dat");
         ObjectInputStream ois=new ObjectInputStream(fis);
         
         ArrayList<Concurso> ListaConcurso= (ArrayList<Concurso>)ois.readObject();
        Iterator <Concurso>it=ListaConcurso.iterator();
        
        Concurso [] con=new Concurso[ListaConcurso.size()];
        
        
        int i=0;
        while(it.hasNext()){
            Concurso co=it.next();
            con[i]=new Concurso();
            con[i].setCodigo(co.getCodigo());
            con[i].setNomeDep(co.getNomeDep());
            con[i].setQuantidade(co.getQuantidade());
            i++;
        }
        return con;
    }
    public static void Remover(int codigo) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis=new FileInputStream("FicheiroConcurso.dat");
         ObjectInputStream ois=new ObjectInputStream(fis);
         
         ArrayList<Concurso> ListaConcurso= (ArrayList<Concurso>)ois.readObject();
         Iterator <Concurso>it=ListaConcurso.iterator();
         
          while(it.hasNext()){
            Concurso co=it.next();
            
            if(co.getCodigo()==codigo){
                ListaConcurso.remove(ListaConcurso.indexOf(co));
                EscreverConcursos(ListaConcurso);
                JOptionPane.showMessageDialog(null, "Concurso Elimanado com Sucesso");
                break;
            }
        }
         
    }
    public static void Actualizar(int codigo, String NomeDep, int quantidade) throws FileNotFoundException, IOException, ClassNotFoundException{
         FileInputStream fis=new FileInputStream("FicheiroConcurso.dat");
         ObjectInputStream ois=new ObjectInputStream(fis);
        
          ArrayList<Concurso> ListaConcurso= (ArrayList<Concurso>)ois.readObject();
         Iterator <Concurso>it=ListaConcurso.iterator();
         while(it.hasNext()){
             Concurso co=it.next();
             if(co.getCodigo()==codigo){
                 co.setNomeDep(NomeDep);
                 co.setQuantidade(quantidade);
                 
                 EscreverConcursos(ListaConcurso);
                 JOptionPane.showMessageDialog(null, "Concurso Actualizado com Sucesso");
             }
             
         }
    }
    
    
}
