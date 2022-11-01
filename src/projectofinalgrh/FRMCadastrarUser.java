
package projectofinalgrh;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class FRMCadastrarUser  extends JFrame implements ActionListener{
    JTextField txtCodigo;
    JTextField txtPass1,txtPass2;
    JComboBox cboFuncionarios;
    JLabel lblCodigo, lblPass1,lblPass2,lblFuncionarios;
    JButton btnVoltar,btnCadastrar;
    
    public FRMCadastrarUser() throws IOException, FileNotFoundException, ClassNotFoundException{
       setTitle("Criar User");
       setResizable(false);
       setBounds(300, 100, 700, 450);
       getContentPane().setBackground(Color.decode("1000000"));
       
       Font fonte =new Font("Nirmala UI", Font.BOLD ,14);
       Font fonte1=new Font("Nirmala UI", Font.BOLD ,18);
       
       ImageIcon image = new ImageIcon("src/projectofinalgrh/icones Projecto/nox.png");
        JLabel img = new JLabel(image);
        img.setBounds(300, 50, 100, 100);
        add(img);
       
       lblCodigo=new JLabel("Codigo: "); lblCodigo.setFont(fonte); lblCodigo.setForeground(Color.white); lblCodigo.setBounds(20, 250-50,80, 30);  add(lblCodigo);
       txtCodigo=new JTextField(); txtCodigo.setFont(fonte);txtCodigo.setBounds(78, 255-50,100, 20);txtCodigo.setEnabled(false); txtCodigo.setForeground(Color.WHITE);txtCodigo.setOpaque(false);add(txtCodigo);
       lblFuncionarios=new JLabel("Funcionario: "); lblFuncionarios.setFont(fonte); lblFuncionarios.setForeground(Color.white); lblFuncionarios.setBounds(220, 250-50,120, 30);  add(lblFuncionarios);
       cboFuncionarios=new JComboBox(); cboFuncionarios.setFont(fonte); cboFuncionarios.setForeground(Color.black); cboFuncionarios.setBounds(310, 250+5-50,120+5, 20);  add(cboFuncionarios);
       lblPass1=new JLabel("Palavra-Passe: "); lblPass1.setFont(fonte); lblPass1.setForeground(Color.white); lblPass1.setBounds(20, 300-50,200, 30);  add(lblPass1);
       txtPass1=new JPasswordField(); txtPass1.setBounds(120, 305-50,200, 20);txtPass1.setEnabled(true); txtPass1.setForeground(Color.WHITE);txtPass1.setOpaque(false);add(txtPass1);
       lblPass2=new JLabel("Reintroduza a Palavra-Passe: "); lblPass2.setFont(fonte); lblPass2.setForeground(Color.white); lblPass2.setBounds(20, 350-50,200, 30);  add(lblPass2);
       txtPass2=new JPasswordField(); txtPass2.setBounds(120+100, 355-50,205, 20);txtPass2.setEnabled(true); txtPass2.setForeground(Color.WHITE);txtPass2.setOpaque(false);add(txtPass2); 
       btnCadastrar=new JButton("Cadastrar"); btnCadastrar.setBounds(150, 440-50, 100, 50); btnCadastrar.setFont(fonte); btnCadastrar.setForeground(Color.white);btnCadastrar.setBackground(Color.darkGray); add(btnCadastrar);
       btnVoltar=new JButton("Voltar"); btnVoltar.setBounds(400-50, 440-50, 100, 50); btnVoltar.setFont(fonte); btnVoltar.setFont(fonte);btnVoltar.setForeground(Color.white); btnVoltar.setBackground(Color.darkGray); add(btnVoltar); 
       btnCadastrar.addActionListener(this); btnVoltar.addActionListener(this);
       cboFuncionarios.addActionListener(this);
       
       setLayout(null);
       setUndecorated(true);
       setVisible(true);
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       
      Funcionario  fun[]= new Funcionario[ControllerFuncionario.LerFicheiro().length];
                for(int i=0;i<fun.length;i++){
                    fun[i]=new Funcionario();
                    fun[i].setNome(ControllerFuncionario.LerFicheiro()[i].getNome());
                    cboFuncionarios.addItem(fun[i].getNome());
                   
            }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnVoltar){
            FRMLogin j=new FRMLogin();
            dispose();
        }
        if(e.getSource()==cboFuncionarios){
            Funcionario fu[];
            try {
                fu = new Funcionario[ControllerFuncionario.LerFicheiro().length];
                for(int i=0;i<fu.length;i++){
                    fu[i]=new Funcionario();
                    fu[i].setDepartamento(ControllerFuncionario.LerFicheiro()[i].getDepartamento());
                    fu[i].setCodigo(ControllerFuncionario.LerFicheiro()[i].getCodigo());
                    fu[i].setNome(ControllerFuncionario.LerFicheiro()[i].getNome());
                         if(cboFuncionarios.getSelectedItem().equals(fu[i].getNome())){
                                txtCodigo.setText(Integer.toString(fu[i].getCodigo()));
                         }  
                   }
            } catch (IOException ex) {
                Logger.getLogger(FRMCadastrarUser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FRMCadastrarUser.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
        if(e.getSource()==btnCadastrar){
            //int codigo, String password, String nome
            int codigo=Integer.parseInt(txtCodigo.getText());
            String Pass=txtPass1.getText();
            String Pass2=txtPass2.getText();
             try {
            if(Pass.equals(Pass2)){
                for(int i=0; i<ControllerFuncionario.LerFicheiro().length;i++){
                    if(ControllerFuncionario.LerFicheiro()[i].getCodigo()==codigo && ControllerFuncionario.LerFicheiro()[i].getCategoria().equals("User")){
                        User u=new User(codigo, Pass2, cboFuncionarios.getSelectedItem().toString());
                       ControllerUser.escreverUser(u);
                       FRMLogin log=new FRMLogin();
                       dispose();
                    } 
                }
            }else JOptionPane.showMessageDialog(null, "Palavra Passe Diferente");
                } catch (IOException ex) {
                    Logger.getLogger(FRMCadastrarUser.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FRMCadastrarUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
}
