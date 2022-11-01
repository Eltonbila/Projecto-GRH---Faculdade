package projectofinalgrh;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;


public class FRMCadastrarDepartamento extends JFrame implements ActionListener{
    JLabel lblTexto,lblCodigo,lblnome;
    JButton btnRefresh,btnVoltar,btnCadastrar;
    JTextField txtNome,txtCodigo;
    JSeparator separador;
    
public FRMCadastrarDepartamento() throws IOException, FileNotFoundException, ClassNotFoundException{
         setTitle("Cadastrar Funcionario");
        setResizable(false);
       // setSize(500, 500);
        setBounds(400, 130,500, 500);
       
        getContentPane().setBackground(Color.decode("1000000"));
        
        
       Font fonte =new Font("Nirmala UI", Font.BOLD ,14);
       Font fonte1=new Font("Nirmala UI", Font.BOLD ,18);
       lblTexto=new JLabel("CADASTRAR DEPARTAMENTO"); lblTexto.setFont(fonte1); lblTexto.setForeground(Color.white); lblTexto.setBounds(115, 2,400, 30);  add(lblTexto);
       lblCodigo=new JLabel("Codigo: "); lblCodigo.setFont(fonte); lblCodigo.setForeground(Color.white); lblCodigo.setBounds(20, 30,80, 30);  add(lblCodigo);
       txtCodigo=new JTextField(); txtCodigo.setBounds(78, 35,250, 20); txtCodigo.setFont(fonte);txtCodigo.setEnabled(false);add(txtCodigo);
      // txtCodigo.setText("1111");
       //txtCodigo.setEditable(false);
       lblnome =new JLabel("Nome: "); lblnome.setBounds(20,70, 80, 20);add(lblnome);lblnome.setFont(fonte);lblnome.setForeground(Color.white);
       txtNome=new JTextField(); txtNome.setBounds(78, 70,250, 20); add(txtNome);
       btnCadastrar=new JButton("Cadastrar"); btnCadastrar.setBounds(15, 400, 100, 50); btnCadastrar.setFont(fonte); btnCadastrar.setForeground(Color.white);btnCadastrar.setBackground(Color.darkGray); add(btnCadastrar);
       btnVoltar=new JButton("Voltar"); btnVoltar.setBounds(200, 400, 100, 50); btnVoltar.setFont(fonte); btnVoltar.setFont(fonte);btnVoltar.setForeground(Color.white); btnVoltar.setBackground(Color.darkGray); add(btnVoltar);
        btnRefresh=new JButton("Refresh"); btnRefresh.setBounds(380, 400, 100, 50); btnRefresh.setFont(fonte); btnRefresh.setBackground(Color.darkGray); btnRefresh.setForeground(Color.white); add(btnRefresh);
        btnRefresh.addActionListener(this); btnCadastrar.addActionListener(this); btnVoltar.addActionListener(this);
         separador=new JSeparator(); separador.setBounds(0, 390,500, 200); add(separador); 
          Codigo();
        
     
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    //==================================================================================================================
    //Area De Trabalho
public void Codigo() throws IOException, FileNotFoundException, ClassNotFoundException{
              Departamento dep[]= new Departamento[ControllerDepartamento.LerFicheiro().length];
            int receptor=0;
                for(int i=0;i<dep.length;i++){
                   dep[i]=new Departamento();
                    receptor=(ControllerDepartamento.LerFicheiro()[i].getCodigo())+1;
                  }
                  txtCodigo.setText(Integer.toString(receptor));
}
    
   public void Limpar(){
       txtCodigo.setText(" ");
       txtNome.setText(" ");
   }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnVoltar){
            dispose();
        }
        if(e.getSource()==btnCadastrar){
                 int codigo=Integer.parseInt(txtCodigo.getText());
                  String nome=txtNome.getText(); 
                  Departamento dep=new Departamento(codigo, nome);
                  try {
                         ControllerDepartamento.escreverDepartamento(dep);
                         dispose();
                         FRMCadastrarDepartamento k= new FRMCadastrarDepartamento();
                      } catch (Exception ex) {
                                  JOptionPane.showMessageDialog(null, ex);
                     }
        }
    }
}
