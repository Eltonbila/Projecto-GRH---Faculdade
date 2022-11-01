
package projectofinalgrh;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


public class FRMMiniRelatorios extends JFrame implements ActionListener{
    JButton btnConcurso;
    
    public FRMMiniRelatorios(){
        setTitle("Relatorios");
        setResizable(false);
        setBounds(600-40-10, 180,500, 250);
        getContentPane().setBackground(Color.decode("1000000"));
        
        Font fonte =new Font("Nirmala UI", Font.BOLD ,14);
       Font fonte1=new Font("Nirmala UI", Font.BOLD ,18);
        
        btnConcurso=new JButton("Concurso"); btnConcurso.setBounds(15, 90, 100, 50); btnConcurso.setFont(fonte); btnConcurso.setForeground(Color.white);btnConcurso.setBackground(Color.darkGray); add(btnConcurso);
        
        
        
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
    }
}
