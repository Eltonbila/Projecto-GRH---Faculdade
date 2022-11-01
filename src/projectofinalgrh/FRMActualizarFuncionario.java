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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class FRMActualizarFuncionario extends JFrame implements ActionListener{
    JLabel lblTexto,lblimagem,  lblCodigo,lblSalario,lblnome,lblSexo,lblMorada,lblHabili,lblDepartamento,lblNuit,lblProfissao,lblBi,lblBancoNome,lblBancoConta,lblAnoContrato,lblContacto,lblCategoria;
    JTextField txtCodigo, txtSalario,txtNome,txtMorada,txtHabili,txtNuit,txtBi,txtBancoConta,txtAnoContrato,txtContacto,txtProfissao;
    JComboBox cboDep,cboBancoNome, cboProfiisao,cboCategoria,cboDia,cboMes,cboAno;
    JRadioButton radM, radF;
    JInternalFrame frame;
    JLayeredPane layRad,layCbo;
    JSeparator separador, separador1;
    JButton btnActualizar, btnRefresh,btnVoltar;
    ButtonGroup RadioGroupo =new ButtonGroup();
    Departamento dep[];
    
    public FRMActualizarFuncionario() throws IOException, FileNotFoundException, ClassNotFoundException{
            setTitle("Actualizar Funcionario");
        setResizable(false);
        setSize(750, 500);
        ImageIcon icon =new ImageIcon(getClass().getResource("laranja.png"));
        setBounds(300, 140, 750,500);
         getContentPane().setBackground(Color.decode("1000000"));
       // lblimagem.setBounds(0,0, 800,800);
        
        //JDesktopPane desk=new JDesktopPane(); 
       Font fonte =new Font("Nirmala UI", Font.BOLD ,14);
       Font fonte1=new Font("Nirmala UI", Font.BOLD ,18);
       lblTexto=new JLabel("ACTUALIZAR FUNCIONARIO"); lblTexto.setFont(fonte1); lblTexto.setForeground(Color.white); lblTexto.setBounds(230, 2,400, 30);  add(lblTexto);
       lblCodigo=new JLabel("Codigo: "); lblCodigo.setFont(fonte); lblCodigo.setForeground(Color.white); lblCodigo.setBounds(20, 30,80, 30);  add(lblCodigo);
       txtCodigo=new JTextField(); txtCodigo.setFont(fonte); txtCodigo.setBounds(78, 35,250, 20); txtCodigo.setEnabled(true);add(txtCodigo);
       lblnome =new JLabel("Nome: "); lblnome.setBounds(20,70, 80, 20);add(lblnome);lblnome.setFont(fonte);lblnome.setForeground(Color.white);
       txtNome=new JTextField(); txtNome.setBounds(78, 70,250, 20); add(txtNome);
       lblSalario= new JLabel("Salario: "); lblSalario.setFont(fonte); lblSalario.setForeground(Color.white); lblSalario.setBounds(20,110,80,20); add(lblSalario);
       txtSalario=new JTextField(); txtSalario.setBounds(78, 110,250, 20); add(txtSalario);
       // layRad=new JLayeredPane(); layRad.setBounds(450, 45, 100, 100);layRad.setToolTipText("Sexo"); layRad.setForeground(Color.red); lblimagem.add(layRad);
       lblSexo=new JLabel("Sexo: "); lblSexo.setFont(fonte); lblSexo.setForeground(Color.white); lblSexo.setBounds(450, 45, 80, 30); add(lblSexo);
       radM=new JRadioButton(" Masculino "); radM.setFont(fonte); radM.setForeground(Color.white); radM.setOpaque(false);radM.setBounds(470, 70, 100, 30);  add(radM);
       radF=new JRadioButton(" Feminino "); radF.setFont(fonte); radF.setForeground(Color.white); radF.setOpaque(false);radF.setBounds(470, 100, 100, 30);  add(radF);
       RadioGroupo.add(radM); RadioGroupo.add(radF);
       separador=new JSeparator(); separador.setBounds(450, 140,200, 200); add(separador); 
       lblMorada=new JLabel("Morada: "); lblMorada.setFont(fonte); lblMorada.setForeground(Color.white);lblMorada.setBounds(20, 150, 80, 20); add(lblMorada);
       txtMorada=new JTextField(); txtMorada.setBounds(78, 150, 250,20); add(txtMorada);
       lblHabili=new JLabel("Nivel: "); lblHabili.setFont(fonte); lblHabili.setForeground(Color.white);lblHabili.setBounds(20, 190, 80, 20); add(lblHabili);
       txtHabili=new JTextField(); txtHabili.setBounds(78, 190, 250,20); lblHabili.add(txtHabili); add(txtHabili);
        lblDepartamento=new JLabel("Departamento: "); lblDepartamento.setFont(fonte); lblDepartamento.setForeground(Color.white);lblDepartamento.setBounds(450, 160, 150, 20); add(lblDepartamento);
        cboDep= new JComboBox();  cboDep.setBounds(450,190, 150,20); cboDep.setOpaque(false); cboDep.setForeground(Color.black); cboDep.setFont(fonte);add(cboDep);
        lblProfissao=new JLabel("Profissao: "); lblProfissao.setFont(fonte); lblProfissao.setForeground(Color.white);lblProfissao.setBounds(450, 220, 100, 20); add(lblProfissao);
        txtProfissao= new JTextField();  txtProfissao.setBounds(450,250, 150,20);add(txtProfissao);
        lblBi=new JLabel("BI: "); lblBi.setFont(fonte); lblBi.setForeground(Color.white);lblBi.setBounds(20, 230, 80, 20); add(lblBi);
        txtBi=new JTextField(); txtBi.setBounds(78, 230, 250,20);add(txtBi);
        lblBancoNome=new JLabel("Nome do banco: "); lblBancoNome.setFont(fonte); lblBancoNome.setForeground(Color.white);lblBancoNome.setBounds(450, 280, 120, 20); add(lblBancoNome);
        String BancoNomes[]={"--Selecione--", "BCI", "Millenium", "Banco Unico", "Standard Bank","Moza Banco","Barcleys"};
        cboBancoNome= new JComboBox(BancoNomes);  cboBancoNome.setBounds(450,305, 150,20);cboBancoNome.setFont(fonte);  cboBancoNome.setOpaque(false); cboBancoNome.setForeground(Color.black); add(cboBancoNome);
        lblBancoConta=new JLabel("Numero de Conta"); lblBancoConta.setFont(fonte); lblBancoConta.setForeground(Color.white);lblBancoConta.setBounds(450, 325, 120, 20); add(lblBancoConta);
        txtBancoConta=new JTextField(); txtBancoConta.setBounds(450, 350, 250,20); add(txtBancoConta);
        lblAnoContrato=new JLabel("Ano Contrato: "); lblAnoContrato.setFont(fonte); lblAnoContrato.setForeground(Color.white);lblAnoContrato.setBounds(20, 270, 100, 20); add(lblAnoContrato);
          String dia[]=new String[31];
          String mes[]={"01","02","03","04","05","06","07","08","09","10","11","12"};
          cboMes=new JComboBox(mes); cboMes.setFont(fonte); cboMes.setForeground(Color.black); cboMes.setBounds(170, 270, 85, 20); add(cboMes); //CboMes.addActionListener(this);
         for(int i=1; i<=dia.length;i++){dia[i-1]=Integer.toString(i);}
         cboDia=new JComboBox(dia); cboDia.setFont(fonte); cboDia.setForeground(Color.black); cboDia.setBounds(120, 270, 50, 20); add(cboDia);
         int k=0;
          String ano[]=new String[26];
          for(int i=1994;i<=2019;i++){ano[k]=Integer.toString(i); k++;  }
          cboAno=new JComboBox(ano); cboAno.setFont(fonte); cboAno.setForeground(Color.black); cboAno.setBounds(250, 270, 80, 20); add(cboAno);
        lblContacto=new JLabel("Contacto: "); lblContacto.setFont(fonte); lblContacto.setForeground(Color.white);lblContacto.setBounds(20, 310, 100, 20); add(lblContacto);
        txtContacto=new JTextField("+258 "); txtContacto.setBounds(120, 310, 207, 20); add(txtContacto);
        lblCategoria=new JLabel("Categoria: "); lblCategoria.setFont(fonte); lblCategoria.setForeground(Color.white);lblCategoria.setBounds(20, 340, 90, 20); add(lblCategoria);
        String Categoria[]={"--Selecione--","User", "Normal"};
        cboCategoria= new JComboBox(Categoria);  cboCategoria.setBounds(120,340, 150,20); cboCategoria.setOpaque(false); cboCategoria.setForeground(Color.black); add(cboCategoria);
         separador1=new JSeparator(); separador.setBounds(0, 380,1000, 1000);add(separador1); 
         btnActualizar=new JButton("Actualizar"); btnActualizar.setBounds(15, 400, 130, 50); btnActualizar.setFont(fonte);btnActualizar.setBackground(Color.DARK_GRAY); btnActualizar.setForeground(Color.white);add(btnActualizar);
         btnVoltar=new JButton("Voltar"); btnVoltar.setBounds(300, 400, 130, 50); btnVoltar.setFont(fonte); btnVoltar.setFont(fonte); btnVoltar.setBackground(Color.darkGray); btnVoltar.setForeground(Color.white); add(btnVoltar);
         btnRefresh=new JButton("Refresh"); btnRefresh.setBounds(600, 400, 130, 50); btnRefresh.setFont(fonte); btnRefresh.setFont(fonte); btnRefresh.setBackground(Color.darkGray); btnRefresh.setForeground(Color.white); add(btnRefresh);
         btnRefresh.addActionListener(this); btnActualizar.addActionListener(this); btnVoltar.addActionListener(this);
         cboCategoria.setFont(fonte); 
       
     
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
                dep = new Departamento[ControllerDepartamento.LerFicheiro().length];
                for(int i=0;i<dep.length;i++){
                    dep[i]=new Departamento();
                    dep[i].setCodigo(ControllerDepartamento.LerFicheiro()[i].getCodigo());
                    dep[i].setNome(ControllerDepartamento.LerFicheiro()[i].getNome());
                   cboDep.addItem(dep[i].getNome());
            }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnRefresh){
            Funcionario fu[];
            try {
                fu= new Funcionario[ControllerFuncionario.LerFicheiro().length];
                for(int i=0;i<fu.length;i++){
                   
                    fu[i]=new Funcionario();
                    fu[i].setCodigo(ControllerFuncionario.LerFicheiro()[i].getCodigo());
                    if(Integer.parseInt(txtCodigo.getText())==fu[i].getCodigo()){
                    txtNome.setText((ControllerFuncionario.LerFicheiro()[i].getNome()));
                    txtProfissao.setText(ControllerFuncionario.LerFicheiro()[i].getProfissao()); 
                    txtSalario.setText(Double.toString(ControllerFuncionario.LerFicheiro()[i].getSalario())); 
                    txtBancoConta.setText((Integer.toString(ControllerFuncionario.LerFicheiro()[i].getBancoConta())));
                    txtBi.setText(((ControllerFuncionario.LerFicheiro()[i].getBi())));  
                    txtContacto.setText((ControllerFuncionario.LerFicheiro()[i].getContacto()));
                    txtHabili.setText(ControllerFuncionario.LerFicheiro()[i].getHabili()); 
                    txtMorada.setText(ControllerFuncionario.LerFicheiro()[i].getMorada()); 
//                    txtNuit.setText(ControllerFuncionario.LerFicheiro()[i].getNuit()); 
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(FRMActualizarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FRMActualizarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
        if(e.getSource()==btnActualizar){
            int codigo=Integer.parseInt(txtCodigo.getText());
        String nome=txtNome.getText();
//        String AnoContrato=LocalDate.parse(cboDia.getSelectedItem().toString()+"-"+cboMes.getSelectedItem().toString()+"-"+cboAno.getSelectedItem().toString()).toString();
        String  AnoContacto=cboDia.getSelectedItem().toString()+"/"+cboMes.getSelectedItem().toString()+"/"+cboAno.getSelectedItem().toString();
        int bancoConta=Integer.parseInt(txtBancoConta.getText());
        String bi=txtBi.getText();
        String categoria=cboCategoria.getSelectedItem().toString();
        String contacto=txtContacto.getText();
        String departamento=cboDep.getSelectedItem().toString();
        String habili=txtHabili.getText();
        String morada=txtMorada.getText();
       String nuit="121";
        String profissao=txtProfissao.getText();
        double salario=Double.parseDouble(txtSalario.getText());
        String sexo=null;
        if(radF.isSelected()){
           sexo=radF.getText();
        }
        else if(radM.isSelected()){
            sexo=radM.getText();
        }
      
        String bancoNome=cboBancoNome.getSelectedItem().toString();
            try {
                ControllerFuncionario.Actualizar(codigo, salario, nome, sexo, morada, habili, departamento, nuit, profissao, bi,bancoNome , bancoConta, AnoContacto, contacto, categoria);
            } catch (IOException ex) {
                Logger.getLogger(FRMActualizarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FRMActualizarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        if(e.getSource()==btnVoltar){
            dispose();
        }
    }
    
    
}
