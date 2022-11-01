
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

public class ControllerConcorrente {
    
    public static void escreverConcorrentes(ArrayList<Concorrente> ListaConcorrentes ) throws FileNotFoundException, IOException{
        FileOutputStream fos=new FileOutputStream("FicheiroCo.dat",false);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(ListaConcorrentes);
        oos.close();
    }
    public static void escreverConcorrente(Concorrente co) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis=new FileInputStream("FicheiroCo.dat");
        ObjectInputStream ois=new ObjectInputStream(fis);
        ArrayList<Concorrente> ListaConcorrentes= (ArrayList<Concorrente>)ois.readObject();
        
        ListaConcorrentes.add(co);
        escreverConcorrentes(ListaConcorrentes);
        JOptionPane.showMessageDialog(null, "Concorrente Inserido com Sucesso");
        }
        public static Concorrente [] LerFicheiro() throws FileNotFoundException, IOException, ClassNotFoundException{
            FileInputStream fis=new FileInputStream("FicheiroCo.dat");
            ObjectInputStream ois=new ObjectInputStream(fis);
            
             ArrayList<Concorrente> ListaConcorrentes= (ArrayList<Concorrente>)ois.readObject();
             Iterator <Concorrente>it=ListaConcorrentes.iterator();
             Concorrente[] conc=new Concorrente[ListaConcorrentes.size()];
             
             int i=0;
             while(it.hasNext()){
                 Concorrente co=it.next();
                 conc[i]=new Concorrente();
                 conc[i].setCodigo(co.getCodigo()); conc[i].setNome(co.getNome()); conc[i].setAnoContrato(co.getAnoContrato());
                 conc[i].setBancoConta(co.getBancoConta()); conc[i].setBancoNome(co.getBancoNome()); conc[i].setBi(co.getBi());
                 conc[i].setCategoria(co.getCategoria()); conc[i].setContacto(co.getContacto()); conc[i].setDepartamento(co.getDepartamento());
                 conc[i].setHabili(co.getHabili()); conc[i].setMorada(co.getMorada()); conc[i].setNuit(co.getNuit()); conc[i].setPresencas(co.getPresencas());
                 conc[i].setProfissao(co.getProfissao()); conc[i].setSalario(co.getSalario()); conc[i].setSexo(co.getSexo());
                 conc[i].setNota1(co.getNota1()); conc[i].setNota2(co.getNota2());
                 
                 i++;
             }
             return conc;
      }
      
        
    
    
}
