/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectofinalgrh;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Vanio Macamo
 */
public class FRMRemoverDepartamento  extends JFrame implements  ActionListener{
    JLabel lblCodigo,lblimagem,lblTexto;
    JTextField txtCodigo;
    JButton btnRemover,btnVoltar,btnLimpar;
    JSeparator separador;
    
    public  FRMRemoverDepartamento(){
         setTitle("Remover Departamento");
        setResizable(false);
        setSize(500, 250);
         ImageIcon icon =new ImageIcon(getClass().getResource("laranja.png"));
       getContentPane().setBackground(Color.decode("1000000"));
        
       Font fonte =new Font("Nirmala UI", Font.BOLD ,14);
       Font fonte1=new Font("Nirmala UI", Font.BOLD ,18);
       lblTexto=new JLabel("REMOVER DEPARTAMENTO"); lblTexto.setFont(fonte1); lblTexto.setForeground(Color.white); lblTexto.setBounds(135, 2,400, 30);  add(lblTexto);
       lblCodigo=new JLabel("Codigo: "); lblCodigo.setFont(fonte); lblCodigo.setForeground(Color.white); lblCodigo.setBounds(20, 40,80, 30);  add(lblCodigo);
       txtCodigo=new JTextField(); txtCodigo.setBounds(78, 45,250, 20); add(txtCodigo);
       btnRemover=new JButton("Remover"); btnRemover.setBounds(90, 160, 100, 50); btnRemover.setFont(fonte);btnRemover.setForeground(Color.white); btnRemover.setBackground(Color.darkGray);add(btnRemover);
       btnVoltar=new JButton("Voltar"); btnVoltar.setBounds(250, 160, 100, 50); btnVoltar.setFont(fonte); btnVoltar.setForeground(Color.white); ;btnVoltar.setFont(fonte); btnVoltar.setBackground(Color.darkGray); add(btnVoltar);
       //btnLimpar=new JButton("Limpar"); btnLimpar.setBounds(380, 160, 100, 50); btnLimpar.setFont(fonte); btnLimpar.setFont(fonte); btnLimpar.setBackground(Color.white); lblimagem.add(btnLimpar);
       separador=new JSeparator(); separador.setBounds(0, 150,500, 200); add(separador); 
       btnRemover.addActionListener(this);btnVoltar.addActionListener(this); //btnLimpar.addActionListener(this);
       
      
       setLayout(null);
       setVisible(true);
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       setLocation(400,200);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnVoltar){
            dispose();
        }
      if(e.getSource()==btnRemover){
          try {
              int escolha=JOptionPane.showConfirmDialog(null,"Deseja remover?","Notificacao",JOptionPane.YES_NO_OPTION);
                        if(escolha==JOptionPane.YES_OPTION){
              
              ControllerDepartamento.Remover(Integer.parseInt(txtCodigo.getText()));
                        }
                        else{
                        escolha=JOptionPane.CANCEL_OPTION;
                        dispose();
                        
                        }
          } catch (IOException ex) {
              Logger.getLogger(FRMRemoverDepartamento.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(FRMRemoverDepartamento.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    }
    
}
