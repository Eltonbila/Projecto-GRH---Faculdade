
package projectofinalgrh;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class FRMVisualizarDepartamento extends JFrame implements ActionListener {
    JLabel lblTexto,lblCodigo,lblFuncionario;
    JTextField txtCodigo;
    JComboBox cboFuncionario;
    JTable tabela;
    DefaultTableModel  modelo;
    JScrollPane scroll;
    JButton btnVisualizar,btnLimpar,btnVoltar;
    
 public FRMVisualizarDepartamento(){
     setTitle("Visualizar Departamento");
        setResizable(false);
        setBounds(300, 140,750, 500);
        getContentPane().setBackground(Color.decode("1000000"));
        Font fonte =new Font("Nirmala UI", Font.BOLD ,14);
        Font fonte1=new Font("Nirmala UI", Font.BOLD ,18);
        
        lblTexto=new JLabel("VISUALIZAR DEPARTAMENTO"); lblTexto.setFont(fonte1); lblTexto.setForeground(Color.white); lblTexto.setBounds(240, 2,400, 30);  add(lblTexto);
     //   lblCodigo=new JLabel("Codigo"); lblCodigo.setFont(fonte); lblCodigo.setForeground(Color.white); lblCodigo.setBounds(20, 35,80,50); add(lblCodigo);
     //   txtCodigo=new JTextField(); txtCodigo.setBounds(78, 50,100, 20); add(txtCodigo);
     //   lblFuncionario=new JLabel("Funcionario"); lblFuncionario.setFont(fonte); lblFuncionario.setForeground(Color.white); lblFuncionario.setBounds(190, 35,80,50); add(lblFuncionario);
      //   cboFuncionario=new JComboBox(); cboFuncionario.setFont(fonte); cboFuncionario.setForeground(Color.white); cboFuncionario.setBounds(270, 50,150,20); add(cboFuncionario);
         
         tabela=new JTable();
         String conteudos[]={"Codigo","Nome"};
         modelo=new DefaultTableModel(new Object[][]{ },conteudos); 
          tabela=new JTable(modelo);  tabela.setBackground(Color.decode("1000000")); tabela.setFont(fonte); tabela.setForeground(Color.white);
           scroll=new JScrollPane(tabela); scroll.setBounds(50,120, 600,250); add(scroll);
           
       btnVisualizar=new JButton("Visualizar"); btnVisualizar.setFont(fonte); btnVisualizar.setForeground(Color.white); btnVisualizar.setBackground(Color.darkGray);
      btnVisualizar.setBounds(50, 400, 150, 50); add(btnVisualizar); btnVisualizar.addActionListener(this);
      btnLimpar=new JButton("Limpar"); btnLimpar.setFont(fonte); btnLimpar.setForeground(Color.white); btnLimpar.setBackground(Color.darkGray);
      btnLimpar.setBounds(280, 400, 150, 50); add(btnLimpar); btnLimpar.addActionListener(this);
      btnVoltar=new JButton("Voltar"); btnVoltar.setFont(fonte); btnVoltar.setForeground(Color.white); btnVoltar.setBackground(Color.darkGray);
      btnVoltar.setBounds(500, 400, 150, 50); add(btnVoltar); btnVoltar.addActionListener(this);
         
      setLayout(null);
      setVisible(true);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
 }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnVisualizar){
            Limpar();
            Departamento dep[];
            try {
                dep = new Departamento[ControllerDepartamento.LerFicheiro().length];
                for(int i=0;i<dep.length;i++){
                    dep[i]=new Departamento();
                    dep[i].setCodigo(ControllerDepartamento.LerFicheiro()[i].getCodigo());
                    dep[i].setNome(ControllerDepartamento.LerFicheiro()[i].getNome());
                modelo.addRow(new String[]{Integer.toString(dep[i].getCodigo()),dep[i].getNome()});
            }
            } catch (IOException ex) {
                Logger.getLogger(FRMVisualizarDepartamento.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FRMVisualizarDepartamento.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            if(e.getSource()==btnLimpar){
               Limpar();
            }
            if(e.getSource()==btnVoltar){
                dispose();
            }
    }
     public void Limpar(){
         while(modelo.getRowCount()!=0){
                modelo.removeRow(modelo.getColumnCount()-modelo.getColumnCount());
                }
            
        } 
}
