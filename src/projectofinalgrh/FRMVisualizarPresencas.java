

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

public class FRMVisualizarPresencas extends JFrame implements ActionListener{
    JLabel lblTexto,lblCodigo,lblDepartamento,lblFuncionario;
    JButton btnVisualizar,btnVoltar,btnLimpar;
    JTable tabela;
    DefaultTableModel modelo;
    JScrollPane scroll;
    JTextField txtCodigo;
    JComboBox cboDepartamentos,cboFuncionario;
    Departamento dep[];
    Funcionario fu[];
    Presencas pre[];
    public FRMVisualizarPresencas() throws IOException, FileNotFoundException, ClassNotFoundException{
        setTitle("Visualizar Presenças");
        setResizable(false);
        setBounds(300, 140,750, 500);
        getContentPane().setBackground(Color.decode("1000000"));
        Font fonte =new Font("Nirmala UI", Font.BOLD ,14);
        Font fonte1=new Font("Nirmala UI", Font.BOLD ,18);
        
        lblTexto=new JLabel("VISUALIZAR PRESENCAS"); lblTexto.setFont(fonte1); lblTexto.setForeground(Color.white); lblTexto.setBounds(240, 2,400, 30);  add(lblTexto);
        lblCodigo=new JLabel("Codigo"); lblCodigo.setFont(fonte); lblCodigo.setForeground(Color.white); lblCodigo.setBounds(20, 35,80,50); add(lblCodigo);
        txtCodigo=new JTextField();txtCodigo.setFont(fonte); txtCodigo.setEditable(false); txtCodigo.setBounds(78, 50,100, 20); add(txtCodigo);
        lblDepartamento=new JLabel("Departamento"); lblDepartamento.setFont(fonte); lblDepartamento.setForeground(Color.white); lblDepartamento.setBounds(180, 35,100,50); add(lblDepartamento);
        cboDepartamentos=new JComboBox(); cboDepartamentos.setFont(fonte); cboDepartamentos.setForeground(Color.black); cboDepartamentos.setBounds(280, 52,150,20); add(cboDepartamentos);
        lblFuncionario=new JLabel("Funcionario"); lblFuncionario.setFont(fonte); lblFuncionario.setForeground(Color.white); lblFuncionario.setBounds(440, 35,100,50); add(lblFuncionario);
        cboFuncionario=new JComboBox(); cboFuncionario.setFont(fonte);cboFuncionario.setForeground(Color.black); cboFuncionario.setBounds(520, 52,150,20); add(cboFuncionario);
        cboDepartamentos.addActionListener(this); cboFuncionario.addActionListener(this);
        
         tabela=new JTable();
         String conteudos[]={"Nome","Data","Hora Entrada","Hora Saida"};
         modelo=new DefaultTableModel(new Object[][]{},conteudos);
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
                   cboDepartamentos.addItem(dep[i].getNome());
            }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnVisualizar){
            Limpar();
        }
        if(e.getSource()==btnLimpar){
            Limpar();
        }
        if(e.getSource()==btnVoltar){
            dispose();
        }
        if(e.getSource()==cboDepartamentos){
           
            try{
            fu=new Funcionario[ControllerFuncionario.LerFicheiro().length];
                for(int i=0;i<fu.length;i++){
                    fu[i]=new Funcionario();
                    fu[i].setNome(ControllerFuncionario.LerFicheiro()[i].getNome());
                    fu[i].setDepartamento(ControllerFuncionario.LerFicheiro()[i].getDepartamento());
                     if(cboDepartamentos.getSelectedItem().equals(fu[i].getDepartamento())){
                         cboFuncionario.addItem(fu[i].getNome());
                   }
                }
            } catch (IOException ex) {
                  Logger.getLogger(FRMNovaPresenca.class.getName()).log(Level.SEVERE, null, ex);
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(FRMNovaPresenca.class.getName()).log(Level.SEVERE, null, ex);
              }
        }
        if(e.getSource()==cboFuncionario){           
          // cboNomes.removeAllItems();
            try{
                fu=new Funcionario[ControllerFuncionario.LerFicheiro().length];
                for(int i=0;i<fu.length;i++){
                    fu[i]=new Funcionario();
                    fu[i].setDepartamento(ControllerFuncionario.LerFicheiro()[i].getDepartamento());
                    fu[i].setCodigo(ControllerFuncionario.LerFicheiro()[i].getCodigo());
                    fu[i].setNome(ControllerFuncionario.LerFicheiro()[i].getNome());
                         if(cboFuncionario.getSelectedItem().equals(fu[i].getNome())){
                                txtCodigo.setText(Integer.toString(fu[i].getCodigo()));
                                
                         }  
                   }
                
            }
              catch (IOException ex) {
                  Logger.getLogger(FRMNovaPresenca.class.getName()).log(Level.SEVERE, null, ex);
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(FRMNovaPresenca.class.getName()).log(Level.SEVERE, null, ex);
              }
        }
        if(e.getSource()==btnVisualizar){
          
            try {
                pre= new Presencas[ControllerPresencas.LerFicheiro().length];
                
                for(int k=0;k<(ControllerFuncionario.LerFicheiro().length) ;k++){ ///(ControllerFuncionario.LerFicheiro().length)
                for(int i=0;i<pre.length;i++){
                    pre[i]=new Presencas();
                    pre[i].setData(ControllerPresencas.LerFicheiro()[i].getData());
                    pre[i].setHoraEntrada(ControllerPresencas.LerFicheiro()[i].getHoraEntrada());
                    pre[i].setHoraSaida(ControllerPresencas.LerFicheiro()[i].getHoraSaida());
                     pre[i].setFunc(ControllerPresencas.LerFicheiro()[i].getFunc());
                     if(Integer.parseInt(txtCodigo.getText())==ControllerFuncionario.LerFicheiro()[k].getCodigo()){
                          modelo.addRow(new String[]{ControllerFuncionario.LerFicheiro()[k].getNome(),pre[i].getData(),pre[i].getHoraEntrada(),pre[i].getHoraSaida()});  
                     }
                  
                }
                
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
