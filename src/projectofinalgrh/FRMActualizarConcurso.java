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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Vanio Macamo
 */
public class FRMActualizarConcurso extends JFrame implements ActionListener {
     JLabel lblTexto,lblDepartamento, lblCodigo, lblQuantidade;
    JTextField txtCodigo,txtQuantidade;
    JComboBox cboDepartamento;
    JButton btnSalvar,btnVoltar;
    Departamento dep[];
    int codigoDep=0;
    public FRMActualizarConcurso() throws IOException, FileNotFoundException, ClassNotFoundException{
        setTitle("Actualizar Concurso");
        setResizable(false);
         setBounds(300, 200,710, 350);
        getContentPane().setBackground(Color.decode("1000000"));
        
       Font fonte =new Font("Nirmala UI", Font.BOLD ,14);
       Font fonte1=new Font("Nirmala UI", Font.BOLD ,18);
       lblTexto=new JLabel("ACTUALIZAR CONCURSO"); lblTexto.setFont(fonte1); lblTexto.setForeground(Color.white); lblTexto.setBounds(210, 2,400, 30);  add(lblTexto);
       lblCodigo=new JLabel("Codigo: "); lblCodigo.setFont(fonte); lblCodigo.setForeground(Color.white); lblCodigo.setBounds(20, 40,80, 30);  add(lblCodigo);
       txtCodigo=new JTextField(); txtCodigo.setBounds(78, 45,100, 20);add(txtCodigo);
       lblDepartamento=new JLabel("Departamento: "); lblDepartamento.setFont(fonte); lblDepartamento.setForeground(Color.white); lblDepartamento.setBounds(190, 40,110, 30);  add(lblDepartamento);
       cboDepartamento=new JComboBox(); cboDepartamento.setFont(fonte); cboDepartamento.setForeground(Color.black); cboDepartamento.setBounds(295, 45, 150, 20); add(cboDepartamento);
       lblQuantidade=new JLabel("Quantidade: "); lblQuantidade.setFont(fonte); lblQuantidade.setForeground(Color.white); lblQuantidade.setBounds(455, 40,250, 30);  add(lblQuantidade);
       txtQuantidade=new JTextField(); txtQuantidade.setBounds(540, 45,120, 20);add(txtQuantidade);
       cboDepartamento.addActionListener(this);
        btnSalvar=new JButton("Actualizar"); btnSalvar.setBounds(150, 250, 120, 50); btnSalvar.setFont(fonte); btnSalvar.setForeground(Color.white);btnSalvar.setBackground(Color.darkGray); add(btnSalvar);
       btnVoltar=new JButton("Voltar"); btnVoltar.setBounds(350, 250, 120, 50); btnVoltar.setFont(fonte); btnVoltar.setFont(fonte);btnVoltar.setForeground(Color.white); btnVoltar.setBackground(Color.darkGray); add(btnVoltar);
        btnSalvar.addActionListener(this); btnVoltar.addActionListener(this);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        dep = new Departamento[ControllerDepartamento.LerFicheiro().length];
                for(int i=0;i<dep.length;i++){
                    dep[i]=new Departamento();
                    dep[i].setCodigo(ControllerDepartamento.LerFicheiro()[i].getCodigo());
                    dep[i].setNome(ControllerDepartamento.LerFicheiro()[i].getNome());
                   cboDepartamento.addItem(dep[i].getNome());
                   
            }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==btnVoltar){
           dispose();
       }
       if(e.getSource()==btnSalvar){
           try {
                
           ////    for(int i=0; i<ControllerConcurso.LerFicheiro().length; i++){
              //     if(cboDepartamento.getSelectedItem().toString().equals(ControllerDepartamento.LerFicheiro()[i].getNome())){
                //       codigoDep=ControllerDepartamento.LerFicheiro()[i].getCodigo();
               //    }
             //  }
               JOptionPane.showMessageDialog(null, "2");
               ControllerConcurso.Actualizar(Integer.parseInt(txtCodigo.getText()),cboDepartamento.getSelectedItem().toString(),Integer.parseInt(txtCodigo.getText()));
              
           } catch (IOException ex) {
               Logger.getLogger(FRMActualizarConcurso.class.getName()).log(Level.SEVERE, null, ex);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(FRMActualizarConcurso.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }
}
