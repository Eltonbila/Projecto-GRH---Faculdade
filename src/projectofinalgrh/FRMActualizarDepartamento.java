
package projectofinalgrh;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class FRMActualizarDepartamento extends JFrame implements ActionListener{
    JLabel lblimagem, lblTexto,lblCodigo,lblnome;
    JButton btnRefresh,btnVoltar,btnActualizar;
    JTextField txtNome,txtCodigo;
    JSeparator separador;
    public FRMActualizarDepartamento(){
         setTitle("Actualizar Departamento");
        setResizable(false);
        setBounds(400, 130,500, 500);
        getContentPane().setBackground(Color.decode("1000000"));
        
        
       Font fonte =new Font("Nirmala UI", Font.BOLD ,14);
       Font fonte1=new Font("Nirmala UI", Font.BOLD ,18);
       lblTexto=new JLabel("ACTUALIZAR DEPARTAMENTO"); lblTexto.setFont(fonte1); lblTexto.setForeground(Color.white); lblTexto.setBounds(115, 2,400, 30);  add(lblTexto);
       lblCodigo=new JLabel("Codigo: "); lblCodigo.setFont(fonte); lblCodigo.setForeground(Color.white); lblCodigo.setBounds(20, 30,80, 30);  add(lblCodigo);
       txtCodigo=new JTextField(); txtCodigo.setBounds(78, 35,250, 20);add(txtCodigo);
      // txtCodigo.setText("1111");
       //txtCodigo.setEditable(false);
       lblnome =new JLabel("Nome: "); lblnome.setBounds(20,70, 80, 20);add(lblnome);lblnome.setFont(fonte);lblnome.setForeground(Color.white);
       txtNome=new JTextField(); txtNome.setBounds(78, 70,250, 20); add(txtNome);
       btnActualizar=new JButton("Actualizar"); btnActualizar.setBounds(15, 400, 100, 50); btnActualizar.setFont(fonte); btnActualizar.setForeground(Color.white);btnActualizar.setBackground(Color.darkGray); add(btnActualizar);
       btnVoltar=new JButton("Voltar"); btnVoltar.setBounds(200, 400, 100, 50); btnVoltar.setFont(fonte); btnVoltar.setFont(fonte);btnVoltar.setForeground(Color.white); btnVoltar.setBackground(Color.darkGray); add(btnVoltar);
        btnRefresh=new JButton("Refresh"); btnRefresh.setBounds(380, 400, 100, 50); btnRefresh.setFont(fonte); btnRefresh.setBackground(Color.darkGray); btnRefresh.setForeground(Color.white); add(btnRefresh);
        btnRefresh.addActionListener(this); btnActualizar.addActionListener(this); btnVoltar.addActionListener(this);
         separador=new JSeparator(); separador.setBounds(0, 390,500, 200); add(separador); 
       
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
        
    }
    public void Limpar(){
       txtCodigo.setText(" ");
       txtNome.setText(" ");
   }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnActualizar){
            try {
                ControllerDepartamento.Actualizar(Integer.parseInt(txtCodigo.getText()), txtNome.getText());
            } catch (IOException ex) {
                Logger.getLogger(FRMActualizarDepartamento.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FRMActualizarDepartamento.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         if(e.getSource()==btnActualizar){
             Limpar();
         }
    }
    
}
