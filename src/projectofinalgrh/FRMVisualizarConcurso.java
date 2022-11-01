
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;


public class FRMVisualizarConcurso  extends JFrame implements ActionListener {
    
      JLabel lblTexto,lblCodigo,lblFuncionario,lblDepartamento;
    JTextField txtCodigo;
    JComboBox cboDepartamento;
    JTable tabela;
    DefaultTableModel  modelo;
    JScrollPane scroll;
    JButton btnVisualizar,btnLimpar,btnVoltar;
     Departamento dep[];
     Concurso conc;
    
 public FRMVisualizarConcurso() throws IOException, FileNotFoundException, ClassNotFoundException{
     setTitle("Visualizar Concurso");
        setResizable(false);
        setBounds(300, 140,750, 500);
        getContentPane().setBackground(Color.decode("1000000"));
        Font fonte =new Font("Nirmala UI", Font.BOLD ,14);
        Font fonte1=new Font("Nirmala UI", Font.BOLD ,18);
        
        lblTexto=new JLabel("VISUALIZAR CONCURSO"); lblTexto.setFont(fonte1); lblTexto.setForeground(Color.white); lblTexto.setBounds(240, 2,400, 30);  add(lblTexto);
         //   lblCodigo=new JLabel("Codigo"); lblCodigo.setFont(fonte); lblCodigo.setForeground(Color.white); lblCodigo.setBounds(20, 35,80,50); add(lblCodigo);
       //   txtCodigo=new JTextField(); txtCodigo.setBounds(78, 50,100, 20); add(txtCodigo);
     //   lblFuncionario=new JLabel("Funcionario"); lblFuncionario.setFont(fonte); lblFuncionario.setForeground(Color.white); lblFuncionario.setBounds(190, 35,80,50); add(lblFuncionario);
   //   cboFuncionario=new JComboBox(); cboFuncionario.setFont(fonte); cboFuncionario.setForeground(Color.white); cboFuncionario.setBounds(270, 50,150,20); add(cboFuncionario);
    //  lblDepartamento=new JLabel("Departamento"); lblDepartamento.setFont(fonte); lblDepartamento.setForeground(Color.white); lblDepartamento.setBounds(350-100-50-100-50, 35,100,50); add(lblDepartamento);
   //   cboDepartamento= new JComboBox();  cboDepartamento.setBounds(450-100-100-50-50,50, 150,20);  cboDepartamento.setOpaque(false);cboDepartamento.setForeground(Color.black); add(cboDepartamento);
  //   cboDepartamento.addActionListener(this);
        
         tabela=new JTable();
         String conteudos[]={"Codigo","Nome","Quantidade"};
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
         if(e.getSource()==btnLimpar){
               Limpar();
            }
            if(e.getSource()==btnVoltar){
                dispose();
            }
            if(e.getSource()==btnVisualizar){
                Limpar();        
            try {
                for(int i=0; i<ControllerConcurso.LerFicheiro().length; i++){
                    //JOptionPane.showMessageDialog(null, ControllerConcurso.LerFicheiro().length);
                        modelo.addRow(new String[]{Integer.toString(ControllerConcurso.LerFicheiro()[i].getCodigo()),(ControllerConcurso.LerFicheiro()[i].getNomeDep()),Integer.toString(ControllerConcurso.LerFicheiro()[i].getQuantidade())});
                }
            } catch (IOException ex) {
                Logger.getLogger(FRMVisualizarDepartamento.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FRMVisualizarDepartamento.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }
    }
     public void Limpar(){
         while(modelo.getRowCount()!=0){
                modelo.removeRow(modelo.getColumnCount()-modelo.getColumnCount());
                }
            
        } 
    }

