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

public class ControllerPresencas {
    
    public static void escreverPresencas(ArrayList <Presencas> ListaPresencas) throws FileNotFoundException, IOException{
        FileOutputStream fos=new FileOutputStream("FicheiroPrese.dat",false);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(ListaPresencas);
        oos.close();
    }
    public static void escreverPresenca(Presencas pre) throws FileNotFoundException, IOException, ClassNotFoundException{
     FileInputStream fis=new FileInputStream("FicheiroPrese.dat");
    ObjectInputStream ois=new ObjectInputStream(fis);
        ArrayList <Presencas> ListaPresencas=(ArrayList<Presencas>)ois.readObject();
        ListaPresencas.add(pre);
        escreverPresencas(ListaPresencas);
        JOptionPane.showMessageDialog(null, "Sucesso"); 
    }
    public static Presencas[] LerFicheiro() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis=new FileInputStream("FicheiroPrese.dat");
        ObjectInputStream ois=new ObjectInputStream(fis);
        
        ArrayList <Presencas> ListaPresencas=(ArrayList<Presencas>)ois.readObject();
         Iterator <Presencas> it=ListaPresencas.iterator();
         Presencas prese[]=new Presencas[ListaPresencas.size()];
         
         int i=0;
         while(it.hasNext()){
             Presencas pre=it.next();
             prese[i]=new Presencas();
             prese[i].setData(pre.getData());
             prese[i].setFunc(pre.getFunc());
             prese[i].setHoraEntrada(pre.getHoraEntrada());
             prese[i].setHoraSaida(pre.getHoraSaida());
             i++;
         }
         return prese;
    }
    public static void Actualizar(String data, String horaEntrada,String horaSaida) throws FileNotFoundException, IOException, ClassNotFoundException{
           FileInputStream fis=new FileInputStream("FicheiroPrese.dat");
        ObjectInputStream ois=new ObjectInputStream(fis);
        
        ArrayList <Presencas> ListaPresencas=(ArrayList<Presencas>)ois.readObject();
         Iterator <Presencas> it=ListaPresencas.iterator();
      
         while(it.hasNext()){
             Presencas pre=it.next();
             if(pre.getData().equals(data)){
                 pre.setHoraEntrada(horaEntrada);
                 pre.setHoraSaida(horaSaida);
                 escreverPresencas(ListaPresencas);
                 JOptionPane.showMessageDialog(null, "Presenca Actualizada com Sucesso");
             }
         }
    }
}
