/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import static projectofinalgrh.ControllerDepartamento.escreverDepartamentos;


public class ControllerUser {
    public static void escreverUsers(ArrayList <User> ListaUsers) throws FileNotFoundException, IOException{
        FileOutputStream fos=new FileOutputStream("FicheiroUser.dat",false);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(ListaUsers);
        oos.close();
       }
      public static void escreverUser(User us) throws FileNotFoundException, IOException, ClassNotFoundException{
      FileInputStream fis=new FileInputStream("FicheiroUser.dat");
       try (ObjectInputStream ois = new ObjectInputStream(fis)) {
            ArrayList<User> ListaUsers = (ArrayList<User>)ois.readObject();
            
            ListaUsers.add(us);
            escreverUsers(ListaUsers);
              JOptionPane.showMessageDialog(null, "User Inserido Com Sucesso");
        }
      }
       public static User[] LerFicheiro() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis=new FileInputStream("FicheiroUser.dat");
        ObjectInputStream ois=new ObjectInputStream(fis);
        
        ArrayList<User>ListaUser=(ArrayList<User>)ois.readObject();
        Iterator <User> it=ListaUser.iterator();
        User use[]=new User[ListaUser.size()];
      
        int i=0;
        while(it.hasNext()){
            User user=it.next();
         
            use[i]=new User();
            
             use[i].setCodigo(user.getCodigo());
             use[i].setNome(user.getNome());
             use[i].setPassword(user.getPassword());
             i++;
           }
        
        return use;
    }
    public static void Remover(int codigo) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis=new FileInputStream("FicheiroUser.dat");
        try (ObjectInputStream ois = new ObjectInputStream(fis)) {
            ArrayList<User> ListaUser = (ArrayList<User>)ois.readObject();
            Iterator <User> it=ListaUser.iterator();
            while(it.hasNext()){
            User use=it.next();
            
             if(use.getCodigo()==codigo){
                 ListaUser.remove(ListaUser.indexOf(use));
                 escreverUsers(ListaUser);
                 JOptionPane.showMessageDialog(null, "User  Eliminado Com Sucesso");
                 break;
             }
           }
        }
    }
    public static void Actualizar(int codigo,String Password) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis=new FileInputStream("FicheiroDep.dat");
        ObjectInputStream ois=new ObjectInputStream(fis);
        
        ArrayList<User>ListaUsers=(ArrayList<User>)ois.readObject();
        Iterator <User> it=ListaUsers.iterator();
        
        while(it.hasNext()){
            User use=it.next();
            if(use.getCodigo()==codigo){
                use.setNome(Password);
                escreverUsers(ListaUsers);
                JOptionPane.showMessageDialog(null, "User Actualizado com Sucesso");
            }  
        }
    }
}
