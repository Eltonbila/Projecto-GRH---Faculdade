
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
import javax.swing.table.DefaultTableModel;


public class FRMVisualizarFuncionario  extends JFrame implements ActionListener {
    JTextField txtCodigo;
    JComboBox cboDepartamento;
    JLabel lblCodigo, lblTexto,lblDepartamento,lblimagem;
    JTable tabela;
    DefaultTableModel modelo;
    JScrollPane scroll;
    JButton btnVisualizar, btnLimpar,btnVoltar,btnVisualizarTodos;
    Departamento dep[];
    
    public FRMVisualizarFuncionario() throws IOException, FileNotFoundException, ClassNotFoundException{
        setTitle("Visualizar Funcionario");
        setResizable(false);
        setSize(1500, 600);
        getContentPane().setBackground(Color.decode("1000000"));
        
        Font fonte =new Font("Nirmala UI", Font.BOLD ,14);
       Font fonte1=new Font("Nirmala UI", Font.BOLD ,18);
       
       lblTexto=new JLabel("VISUALIZAR FUNCIONARIO"); lblTexto.setFont(fonte1); lblTexto.setForeground(Color.white); lblTexto.setBounds(500, 2,400, 30);  add(lblTexto);
       lblCodigo=new JLabel("Codigo"); lblCodigo.setFont(fonte); lblCodigo.setForeground(Color.white); lblCodigo.setBounds(20, 35,80,50); add(lblCodigo);
       txtCodigo=new JTextField(); txtCodigo.setBounds(78, 50,250, 20); add(txtCodigo);
       lblDepartamento=new JLabel("Departamento"); lblDepartamento.setFont(fonte); lblDepartamento.setForeground(Color.white); lblDepartamento.setBounds(350, 35,100,50); add(lblDepartamento);
      cboDepartamento= new JComboBox();  cboDepartamento.setBounds(450,50, 150,20);  cboDepartamento.setOpaque(false);cboDepartamento.setForeground(Color.black); add(cboDepartamento);
      
      btnVisualizar=new JButton("Visualizar"); btnVisualizar.setFont(fonte); btnVisualizar.setForeground(Color.white); btnVisualizar.setBackground(Color.darkGray);
      btnVisualizar.setBounds(900, 25, 150, 50); add(btnVisualizar); btnVisualizar.addActionListener(this);
      btnVisualizarTodos=new JButton("Visualizar Todos"); btnVisualizarTodos.setFont(fonte); btnVisualizarTodos.setForeground(Color.white); btnVisualizarTodos.setBackground(Color.darkGray);
      btnVisualizarTodos.setBounds(500+250+10, 650, 150, 50); add(btnVisualizarTodos); btnVisualizarTodos.addActionListener(this);
     btnLimpar=new JButton("Limpar"); btnLimpar.setFont(fonte); btnLimpar.setForeground(Color.white); btnLimpar.setBackground(Color.darkGray);
     btnLimpar.setBounds(700+250+10, 650, 150, 50); add(btnLimpar); btnLimpar.addActionListener(this);
      btnVoltar=new JButton("Voltar"); btnVoltar.setFont(fonte); btnVoltar.setForeground(Color.white); btnVoltar.setBackground(Color.darkGray);
     btnVoltar.setBounds(900+200+50+10, 650, 150, 50); add(btnVoltar); btnVoltar.addActionListener(this);
     cboDepartamento.addActionListener(this);
      
      
   //   tabela=new JTable();
      String titulo[]={"CODIGO","NOME", "SALARIO", "SEXO","MORADA", "H. LITERARIAS", "DEPARTAMENTO","PROFISSAO", "BI", "BANCO","NR DE CONTA","ANO CONTRATO", "CONTACTO","CATEGORIA"};
   
      modelo=new DefaultTableModel(new Object[][]{},titulo); 
      tabela=new JTable(modelo);  tabela.setBackground(Color.decode("1000000")); tabela.setFont(fonte); tabela.setForeground(Color.white);
      scroll=new JScrollPane(tabela); scroll.setBounds(5,120, 1350,400); 
      add(scroll);
        setLayout(null);
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        dep = new Departamento[ControllerDepartamento.LerFicheiro().length];
                for(int i=0;i<dep.length;i++){
                    dep[i]=new Departamento();
                    dep[i].setCodigo(ControllerDepartamento.LerFicheiro()[i].getCodigo());
                    dep[i].setNome(ControllerDepartamento.LerFicheiro()[i].getNome());
                   cboDepartamento.addItem(dep[i].getNome());
            }
          
            Limpar();
             VisualizaTodos();
        
    }
    public void VisualizaTodos() throws IOException, FileNotFoundException, ClassNotFoundException{
        Funcionario fu[];
            fu= new Funcionario[ControllerFuncionario.LerFicheiro().length];
                for(int i=0;i<fu.length;i++){
                   
                    fu[i]=new Funcionario();
                    fu[i].setCodigo(ControllerFuncionario.LerFicheiro()[i].getCodigo());
                    fu[i].setNome(ControllerFuncionario.LerFicheiro()[i].getNome());
                    fu[i].setAnoContrato(ControllerFuncionario.LerFicheiro()[i].getAnoContrato());
                    fu[i].setBancoConta(ControllerFuncionario.LerFicheiro()[i].getBancoConta());
                    fu[i].setBancoNome(ControllerFuncionario.LerFicheiro()[i].getBancoNome());
                    fu[i].setBi(ControllerFuncionario.LerFicheiro()[i].getBi());  
                    fu[i].setCategoria(ControllerFuncionario.LerFicheiro()[i].getCategoria()); 
                    fu[i].setContacto(ControllerFuncionario.LerFicheiro()[i].getContacto());
                    fu[i].setDepartamento(ControllerFuncionario.LerFicheiro()[i].getDepartamento());
                    fu[i].setHabili(ControllerFuncionario.LerFicheiro()[i].getHabili()); 
                    fu[i].setMorada(ControllerFuncionario.LerFicheiro()[i].getMorada()); 
                    fu[i].setNuit(ControllerFuncionario.LerFicheiro()[i].getNuit()); 
                    fu[i].setProfissao(ControllerFuncionario.LerFicheiro()[i].getProfissao()); 
                    fu[i].setSalario(ControllerFuncionario.LerFicheiro()[i].getSalario()); 
                    fu[i].setSexo(ControllerFuncionario.LerFicheiro()[i].getSexo());
                    modelo.addRow(new String[]{Integer.toString(fu[i].getCodigo()),fu[i].getNome(),Double.toString(fu[i].getSalario()),fu[i].getSexo(),fu[i].getMorada(),fu[i].getHabili(),fu[i].getDepartamento(),fu[i].getProfissao(),fu[i].getBi(),fu[i].getBancoNome(),Integer.toString(fu[i].getBancoConta()),fu[i].getAnoContrato(),fu[i].getContacto(),fu[i].getCategoria()});
                }
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
       if(e.getSource()==btnVisualizar){
           Limpar();
           Funcionario fu[];
           try {
                fu= new Funcionario[ControllerFuncionario.LerFicheiro().length];
                for(int i=0;i<fu.length;i++){
                   
                    fu[i]=new Funcionario();
                    fu[i].setCodigo(ControllerFuncionario.LerFicheiro()[i].getCodigo());
                    fu[i].setNome(ControllerFuncionario.LerFicheiro()[i].getNome());
                    fu[i].setAnoContrato(ControllerFuncionario.LerFicheiro()[i].getAnoContrato());
                    fu[i].setBancoConta(ControllerFuncionario.LerFicheiro()[i].getBancoConta());
                    fu[i].setBancoNome(ControllerFuncionario.LerFicheiro()[i].getBancoNome());
                    fu[i].setBi(ControllerFuncionario.LerFicheiro()[i].getBi());  
                    fu[i].setCategoria(ControllerFuncionario.LerFicheiro()[i].getCategoria()); 
                    fu[i].setContacto(ControllerFuncionario.LerFicheiro()[i].getContacto());
                    fu[i].setDepartamento(ControllerFuncionario.LerFicheiro()[i].getDepartamento());
                    fu[i].setHabili(ControllerFuncionario.LerFicheiro()[i].getHabili()); 
                    fu[i].setMorada(ControllerFuncionario.LerFicheiro()[i].getMorada()); 
                    fu[i].setNuit(ControllerFuncionario.LerFicheiro()[i].getNuit()); 
                    fu[i].setProfissao(ControllerFuncionario.LerFicheiro()[i].getProfissao()); 
                    fu[i].setSalario(ControllerFuncionario.LerFicheiro()[i].getSalario()); 
                    fu[i].setSexo(ControllerFuncionario.LerFicheiro()[i].getSexo());
                    if(fu[i].getCodigo()==Integer.parseInt(txtCodigo.getText())){
                    modelo.addRow(new String[]{Integer.toString(fu[i].getCodigo()),fu[i].getNome(),Double.toString(fu[i].getSalario()),fu[i].getSexo(),fu[i].getMorada(),fu[i].getHabili(),fu[i].getDepartamento(),fu[i].getNuit(),fu[i].getProfissao(),fu[i].getBi(),fu[i].getBancoNome(),Integer.toString(fu[i].getBancoConta()),"12",fu[i].getContacto(),fu[i].getCategoria()});
                    break;
                    }
                   // else { JOptionPane.showMessageDialog(null, "Nao Existe!");}
                }
            } catch (IOException ex) {
                Logger.getLogger(FRMVisualizarDepartamento.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FRMVisualizarDepartamento.class.getName()).log(Level.SEVERE, null, ex);
            }
           
         }
         if(e.getSource()==btnVisualizarTodos){
             Limpar();
           try {
               VisualizaTodos();
           } catch (IOException ex) {
               Logger.getLogger(FRMVisualizarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(FRMVisualizarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
           }
         }
         if(e.getSource()==btnLimpar){
             Limpar();
         }
         if(e.getSource()==cboDepartamento){
             Limpar();
              
               try{
                    //Funcionario fu[];
                 Funcionario fu[]= new Funcionario[ControllerFuncionario.LerFicheiro().length];
                for(int i=0;i<fu.length;i++){
                   
                    fu[i]=new Funcionario();
                    fu[i].setCodigo(ControllerFuncionario.LerFicheiro()[i].getCodigo());
                    fu[i].setNome(ControllerFuncionario.LerFicheiro()[i].getNome());
                    fu[i].setAnoContrato(ControllerFuncionario.LerFicheiro()[i].getAnoContrato());
                    fu[i].setBancoConta(ControllerFuncionario.LerFicheiro()[i].getBancoConta());
                    fu[i].setBancoNome(ControllerFuncionario.LerFicheiro()[i].getBancoNome());
                    fu[i].setBi(ControllerFuncionario.LerFicheiro()[i].getBi());  
                    fu[i].setCategoria(ControllerFuncionario.LerFicheiro()[i].getCategoria()); 
                    fu[i].setContacto(ControllerFuncionario.LerFicheiro()[i].getContacto());
                    fu[i].setDepartamento(ControllerFuncionario.LerFicheiro()[i].getDepartamento());
                    fu[i].setHabili(ControllerFuncionario.LerFicheiro()[i].getHabili()); 
                    fu[i].setMorada(ControllerFuncionario.LerFicheiro()[i].getMorada()); 
                    fu[i].setNuit(ControllerFuncionario.LerFicheiro()[i].getNuit()); 
                    fu[i].setProfissao(ControllerFuncionario.LerFicheiro()[i].getProfissao()); 
                    fu[i].setSalario(ControllerFuncionario.LerFicheiro()[i].getSalario()); 
                    fu[i].setSexo(ControllerFuncionario.LerFicheiro()[i].getSexo());
                    if(cboDepartamento.getSelectedItem().equals(fu[i].getDepartamento())){
                    modelo.addRow(new String[]{Integer.toString(fu[i].getCodigo()),fu[i].getNome(),Double.toString(fu[i].getSalario()),fu[i].getSexo(),fu[i].getMorada(),fu[i].getHabili(),fu[i].getDepartamento(),fu[i].getNuit(),fu[i].getProfissao(),fu[i].getBi(),fu[i].getBancoNome(),Integer.toString(fu[i].getBancoConta()),"12",fu[i].getContacto(),fu[i].getCategoria()});
                  //  break;
                    } 
               
                }
           }
               catch (IOException ex) {
                Logger.getLogger(FRMVisualizarDepartamento.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FRMVisualizarDepartamento.class.getName()).log(Level.SEVERE, null, ex);
            }
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
