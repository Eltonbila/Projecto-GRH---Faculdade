package projectofinalgrh;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.event.AncestorListener;

public class FRMLogin extends JFrame implements ActionListener {
    
    JLabel lblTexto;
    JLabel exit;
    JButton sair, btnEntrar;
    
    public FRMLogin() {
        setTitle("LOGIN");
        setResizable(false);
        setSize(750, 500);
        setBounds(300, 100, 750, 550);
        getContentPane().setBackground(Color.decode("1000000"));
        
        Font fonte1 = new Font("Nirmala UI", Font.BOLD, 12);
        Font fonte2=new Font("Franklin Gothic Heavy",Font.PLAIN,14);
        
         // lblTexto=new JLabel("SIGRH"); lblTexto.setFont(fonte2); lblTexto.setForeground(Color.white); lblTexto.setBounds(250, 50,400, 30);  add(lblTexto);
     
         ////////////  Painel com campos usuario e senha 
        JPanel Log = new JPanel();
        Log.setLayout(null);
        Log.setOpaque(false);
        Log.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), "", 0, PROPERTIES, null, Color.white));
        Log.setBounds(250, 150, 380, 230);
        add(Log);
        
      /////////// Painel com Imagem e texo 6
        JPanel pn = new JPanel();
        pn.setLayout(null);
        pn.setOpaque(false);
        pn.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), "________________________________________________________________", 0, PROPERTIES, null, Color.white));
        pn.setBounds(80, 150, 170, 230);
        //pn.setBackground(Color.decode("10000000"));
        add(pn);
        
        //////     Icone do usuario do lado esquerdo
        
        ImageIcon image = new ImageIcon("src/projectofinalgrh/icones Projecto/nox.png");
        JLabel img = new JLabel(image);
        img.setBounds(35, 30, 100, 100);
        pn.add(img);
        
       
       
       
        ////////////// texto por baixo do icone
        
        JLabel Login = new JLabel("Menu De Acesso");
        Login.setBounds(28, 150, 100, 100);
        Login.setFont(fonte1);
        Login.setForeground(Color.white);
        pn.add(Login);
      
        ///////////////////// Label Senha
        JLabel user = new JLabel("Usuario:");
        user.setFont(new Font("Arial", Font.BOLD, 12));
        user.setBounds(60, 94, 85, 20);
        user.setForeground(Color.white);
        Log.add(user);
        
        /////////////// Campo  Usuario
        
        JTextField usuario = new JTextField();
        usuario.setBounds(110, 90, 230, 22);
        usuario.setForeground(Color.white);
        usuario.setFont(fonte1);
        usuario.setOpaque(false);
        Log.add(usuario);
        
        //////////JLabel Senha
        
        JLabel senh = new JLabel("Senha:");
        senh.setFont(new Font("Arial", Font.BOLD, 12));
        senh.setBounds(60, 145, 85, 20);
        senh.setForeground(Color.white);
        senh.setFont(fonte1);
        Log.add(senh);
        
         
       
        ///////        JLabel com Mensagem
        
        JLabel Mensgem = new JLabel("Caso Ainda Nao Tenhas Uma Conta Clique");
        Mensgem.setFont(new Font("Nirmala UI", Font.PLAIN, 12));
        Mensgem.setBounds(5, 530, 240, 20);
        Mensgem.setForeground(Color.white);
        add(Mensgem);
 
        //////////////   JLabel Com mensagem Aqui
        JLabel Mensgem1 = new JLabel("Aqui");
        Mensgem1.setFont(new Font("Nirmala UI", Font.PLAIN, 12));
        Mensgem1.setBounds(240, 530, 85, 20);
        Mensgem1.setForeground(Color.green);
        Mensgem1.setCursor(null);
        Mensgem1.addMouseListener(new MouseAdapter() {    /////////////   Accao do label Aqui
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    FRMCadastrarUser a=new FRMCadastrarUser();
                } catch (IOException ex) {
                    Logger.getLogger(FRMLogin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FRMLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
                dispose();
                //JOptionPane.showMessageDialog(null, "Relaxa Ainda Nao Foi Programado");
            }
            
        });
        add(Mensgem1);  
        
        ////// Campo de senha
        
        JPasswordField Senha = new JPasswordField();
        Senha.setBounds(110, 141, 230, 22);
        Senha.setForeground(Color.white);
        Senha.setOpaque(false);
        Log.add(Senha);
         Font fonte =new Font("Nirmala UI", Font.BOLD ,14);
        ImageIcon imagem = new ImageIcon("src/projectofinalgrh/icones Projecto/exit.png");
        exit = new JLabel(imagem);
        btnEntrar=new JButton("Entrar");  btnEntrar.setFont(fonte); ; btnEntrar.setBackground(Color.darkGray); btnEntrar.setForeground(Color.white);// add(btnLimpar);
        btnEntrar.addMouseListener(new MouseAdapter() {     ////////////// Acao do boatao Entrar
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                  //ControllerUser.LerFicheiro()[i].getNome().equals(usuario.getText())&& ControllerUser.LerFicheiro()[i].getPassword().equals(senh.getText())
                     boolean logica=false;
                    for(int i=0; i<ControllerUser.LerFicheiro().length; i++){
               //JOptionPane.showMessageDialog(null, ControllerUser.LerFicheiro()[i].getNome()+" "+ControllerUser.LerFicheiro()[i].getPassword());
              //&& ControllerUser.LerFicheiro()[i].getPassword().equals(senh.getText()         
                        if(ControllerUser.LerFicheiro()[i].getNome().equals(usuario.getText())&& ControllerUser.LerFicheiro()[i].getPassword().equals(Senha.getText())){
                             JOptionPane.showMessageDialog(null, "Bem Vindo");
                             dispose();
                             FRMMenuPrincipal a= new FRMMenuPrincipal();
                             logica=true;
                        }
                    }
                    if(logica==false){
                        JOptionPane.showMessageDialog(null, "Nao permitido!");
                        
                    }
                } catch (IOException ex) {
                    Logger.getLogger(FRMLogin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FRMLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
         btnEntrar.setBounds(280-4, 195, 100, 30);
        Log.add(btnEntrar);
        
        
        ///// Botao Sair Personalizado
        
        ImageIcon imagemsair = new ImageIcon("src/projectofinalgrh/icones Projecto/power-button-outline.png");
        sair = new JButton(imagemsair);
        sair.setBackground(Color.decode("1000000"));
        sair.setForeground(Color.white);
        sair.addActionListener(this);
        sair.setBounds(720, 520, 30, 29);
        add(sair);
        
      

        //  lblTexto=new JLabel("CADASTRAR CONCORRENTE"); lblTexto.setFont(fonte1); lblTexto.setForeground(Color.white); lblTexto.setBounds(230, 2,400, 30);  add(lblTexto);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sair) {
            int confirmar = JOptionPane.showConfirmDialog(null, "Terminar A Seccao?", "Atencao", JOptionPane.YES_NO_OPTION);
            if (confirmar == JOptionPane.YES_OPTION) {
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "Boa Escolha Continue");
            }
            
        }
    }
    
}
