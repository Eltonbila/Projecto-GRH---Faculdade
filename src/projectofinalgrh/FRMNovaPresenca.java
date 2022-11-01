
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
import javax.swing.JSeparator;

public class FRMNovaPresenca extends JFrame implements ActionListener {
    JLabel lblCodigo,HoraSaida,lblDepartamento,lblNomes,lblTexto,lblHoraEntrada, lblData,lblHoraSaida;
    JTextField txtCodigo;
    JComboBox cboDepartamentos,cboNomes,cboMinutos,cboHoras,cboDia,cboMes,cboAno,cboMinutos1,cboHoras1;
    JSeparator separador;
    JButton btnSalvar,btnVoltar;
    Departamento dep[];
    Funcionario fu[];
    
    public FRMNovaPresenca() throws IOException, FileNotFoundException, ClassNotFoundException{
        setTitle("Presencas");
        setTitle("GERIR PRESENCAS");
        setResizable(false);
        setBounds(300, 140, 750,500);
        getContentPane().setBackground(Color.decode("1000000"));
        
         Font fonte =new Font("Nirmala UI", Font.BOLD ,14);
         Font fonte1=new Font("Nirmala UI", Font.BOLD ,18);
         lblTexto=new JLabel("GERIR PRESENCAS"); lblTexto.setFont(fonte1); lblTexto.setForeground(Color.white); lblTexto.setBounds(290, 2,400, 30);  add(lblTexto);
        
           lblCodigo=new JLabel("Codigo: "); lblCodigo.setFont(fonte); lblCodigo.setForeground(Color.white); lblCodigo.setBounds(20, 30,80, 30);  add(lblCodigo);
           txtCodigo=new JTextField(); txtCodigo.setBounds(78, 35,150, 20); add(txtCodigo);
           lblDepartamento=new JLabel("Departamento: "); lblDepartamento.setFont(fonte); lblDepartamento.setForeground(Color.white); lblDepartamento.setBounds(232, 30,120, 30);  add(lblDepartamento);
           cboDepartamentos=new JComboBox(); cboDepartamentos.setFont(fonte); cboDepartamentos.setForeground(Color.white); cboDepartamentos.setBounds(342, 37, 150, 20); add(cboDepartamentos);
           lblNomes=new JLabel("Nome: "); lblNomes.setFont(fonte); lblNomes.setForeground(Color.white); lblNomes.setBounds(496, 30,120, 30);  add(lblNomes);
          cboNomes=new JComboBox(); cboNomes.setFont(fonte); cboNomes.setForeground(Color.white); cboNomes.setBounds(552, 37, 150, 20); add(cboNomes);
          separador=new JSeparator(); separador.setBounds(0, 65, 750,500); add(separador);
          lblData=new JLabel("Data: "); lblData.setFont(fonte); lblData.setForeground(Color.white); lblData.setBounds(20, 100,40, 30);  add(lblData);
          String dia[]=new String[31];
          String mes[]={"1","2","3","4","5","6","7","8","9","10","11","12"};
          cboMes=new JComboBox(mes); cboMes.setFont(fonte); cboMes.setForeground(Color.black); cboMes.setBounds(160, 105, 85, 20); add(cboMes); //CboMes.addActionListener(this);
         for(int i=1; i<=dia.length;i++){dia[i-1]=Integer.toString(i);}
         cboDia=new JComboBox(dia); cboDia.setFont(fonte); cboDia.setForeground(Color.black); cboDia.setBounds(80, 105, 80, 20); add(cboDia);
          String ano[]={"2019"}; cboNomes.setForeground(Color.black);
          cboAno=new JComboBox(ano); cboAno.setFont(fonte); cboAno.setForeground(Color.black); cboAno.setBounds(240, 105, 80, 20); add(cboAno);
          cboDepartamentos.setForeground(Color.black); cboDepartamentos.addActionListener(this);
          lblHoraEntrada=new JLabel("Hora de entrada: "); lblHoraEntrada.setFont(fonte); lblHoraEntrada.setForeground(Color.white); lblHoraEntrada.setBounds(20, 150,120, 30);  add(lblHoraEntrada);
           String horas[]=new String[24];
           for(int i=0;i<24;i++){horas[i]=Integer.toString(i);}
           String minutos[]=new String[59];
           for(int i=1;i<=minutos.length;i++){ minutos[i-1]=Integer.toString(i);}
           cboHoras=new JComboBox((horas)); cboHoras.setBounds(138, 155,40, 20); add(cboHoras);
           cboMinutos=new JComboBox(minutos);cboMinutos.setBounds(178, 155, 40, 20);  add(cboMinutos);
           cboNomes.addActionListener(this);
           lblHoraSaida=new JLabel("Hora de Saida: "); lblHoraSaida.setFont(fonte); lblHoraSaida.setForeground(Color.white); lblHoraSaida.setBounds(20, 190,120, 30);  add(lblHoraSaida);
           cboHoras1=new JComboBox((horas)); cboHoras1.setBounds(138, 195,40, 20); add(cboHoras1);
           cboMinutos1=new JComboBox(minutos);cboMinutos1.setBounds(178, 195, 40, 20);  add(cboMinutos1);
           
           
           btnSalvar=new JButton("Salvar"); btnSalvar.setFont(fonte); btnSalvar.setBackground(Color.darkGray);btnSalvar.setForeground(Color.white); btnSalvar.setBounds(20, 410, 130, 50); add(btnSalvar);
            btnVoltar=new JButton("Voltar"); btnVoltar.setBounds(250, 410, 130, 50); btnVoltar.setFont(fonte); btnVoltar.setFont(fonte); btnVoltar.setBackground(Color.darkGray); btnVoltar.setForeground(Color.WHITE);add(btnVoltar);
           btnSalvar.addActionListener(this); btnVoltar.addActionListener(this);
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
                         cboNomes.addItem(fu[i].getNome());
                   }
                }
            } catch (IOException ex) {
                  Logger.getLogger(FRMNovaPresenca.class.getName()).log(Level.SEVERE, null, ex);
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(FRMNovaPresenca.class.getName()).log(Level.SEVERE, null, ex);
              }
        }
        if(e.getSource()==cboNomes){           
          // cboNomes.removeAllItems();
            try{
                fu=new Funcionario[ControllerFuncionario.LerFicheiro().length];
                for(int i=0;i<fu.length;i++){
                    fu[i]=new Funcionario();
                    fu[i].setDepartamento(ControllerFuncionario.LerFicheiro()[i].getDepartamento());
                    fu[i].setCodigo(ControllerFuncionario.LerFicheiro()[i].getCodigo());
                    fu[i].setNome(ControllerFuncionario.LerFicheiro()[i].getNome());
                         if(cboNomes.getSelectedItem().equals(fu[i].getNome())){
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
        if(e.getSource()==btnSalvar){
            String data=cboDia.getSelectedItem().toString()+"/"+cboMes.getSelectedItem().toString()+"/"+cboAno.getSelectedItem().toString();
            String horaEntrada=cboHoras.getSelectedItem().toString()+":"+cboMinutos.getSelectedItem().toString();
            String horaSaida=cboHoras1.getSelectedItem().toString()+":"+cboMinutos1.getSelectedItem().toString();
            Funcionario fu[];
           
              try {
                  fu = new Funcionario[ControllerFuncionario.LerFicheiro().length];
                   for(int i=0;i<fu.length;i++){
                     fu[i]=new Funcionario();
                     fu[i].setCodigo(ControllerFuncionario.LerFicheiro()[i].getCodigo());
                     if(fu[i].getCodigo()==Integer.parseInt(txtCodigo.getText())){
                             Presencas pre=new Presencas(data, horaEntrada,horaSaida, fu[i]);
                             ControllerPresencas.escreverPresenca(pre);
                             break;
                     }
               }
              } catch (IOException ex) {
                  Logger.getLogger(FRMNovaPresenca.class.getName()).log(Level.SEVERE, null, ex);
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(FRMNovaPresenca.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
           
            
           
        }
        
    }

