package projectofinalgrh;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FRMMenuPrincipal extends JFrame implements ActionListener {

    JLabel lblimagem, FrameLabel, lblBloco;
    JMenuBar Menu;
    JMenuItem JMIFuncionario, JMIDepartamento, JMIPresencas, JMIConcurso,JMIPSaida;
    JInternalFrame FrameInternal;
    JMenuItem JMIRFuncionario, JMIAjuda, JMIRDepartamento,JMINovo,JMIExistente, JMIRConcurso, JMIAFuncionario, JMIADepartamento, JMIAConcurso, JMIAPresencas, JMICFuncionario, JMICDepartamento, JMIPEntrada, JMINova;
    JPanel panBarra, panBarra2;
    JButton btnWha, btnFace, btnTwi,btnGmail,btnPresencas,btnRelatorios,btnEstatisticas;
    ArrayList <Departamento> ListaDepartamentos=new ArrayList();
    JButton btnSair;
    JMenu menuAjuda;
  
    public FRMMenuPrincipal() {
        setTitle("Menu Principal");
        setResizable(false);
        setSize(700, 600);
        getContentPane().setBackground(Color.CYAN);
       
        ImageIcon icon = new ImageIcon(getClass().getResource("icon2.jpg"));
        lblimagem = new JLabel(icon);
        lblimagem.setBounds(-10, 0, 1500, 745);
        add(lblimagem);
        ImageIcon iconFace = new ImageIcon(getClass().getResource("facebook.png"));
        btnFace = new JButton(iconFace);
        btnFace.setBounds(15, 5, 50, 47);
        btnFace.setBorder(null);
        add(btnFace);
        ImageIcon iconTwi = new ImageIcon(getClass().getResource("twitter1.png"));
        btnTwi = new JButton(iconTwi);
        btnTwi.setBounds(80, 5, 50, 47);
        btnTwi.setBorder(null);
        add(btnTwi);
        ImageIcon iconWha = new ImageIcon(getClass().getResource("12.png"));
        btnWha = new JButton(iconWha);
        btnWha.setBounds(150, 5,50, 47);
        btnWha.setBorder(null);
        add(btnWha);
       // ImageIcon inconG=new ImageIcon(getClass().getResource("123.jpg"));
       // btnGmail=new JButton( inconG);
     //   btnGmail.setBounds(215, 5,50,70);
       // add(btnGmail);
     //   btnGmail.addActionListener(this);
        btnFace.addActionListener(this);
        btnTwi.addActionListener(this);
        btnWha.addActionListener(this);
        Font fonte = new Font("Nirmala UI", Font.BOLD, 14);
        
        panBarra=new JPanel(); panBarra.setBackground(Color.darkGray); panBarra.setBounds(50,150,300,400);  
        btnPresencas=new JButton("        PRESENÇAS        "); btnPresencas.setForeground(Color.white); 
        btnPresencas.setBackground(Color.decode("1000000"));btnPresencas.setFont(fonte); panBarra.add(btnPresencas);
        lblimagem.add(panBarra);
        btnPresencas.addActionListener(this);
        panBarra2=new JPanel(); panBarra2.setBackground(Color.darkGray); panBarra2.setBounds(1000,150,300,400); 
        btnRelatorios=new JButton("        RELATORIOS        "); btnRelatorios.setForeground(Color.white); btnRelatorios.addActionListener(this);
        btnRelatorios.setBackground(Color.decode("1000000"));btnRelatorios.setFont(fonte); panBarra2.add(btnRelatorios);
        btnEstatisticas=new JButton("       ESTATISTICAS       "); btnEstatisticas.setForeground(Color.white);  btnEstatisticas.addActionListener(this);
        btnEstatisticas.setBackground(Color.decode("1000000"));btnEstatisticas.setFont(fonte); panBarra2.add(btnEstatisticas); 
        btnSair=new JButton("               SAIR               "); btnSair.setFont(fonte); panBarra2.add(btnSair);
        btnSair.setForeground(Color.white); btnSair.setBackground(Color.decode("1000000"));btnSair.addActionListener(this);
        lblimagem.add(panBarra2);
        
        
        
        Menu = new JMenuBar();
        Menu.setBackground(Color.cyan);
        lblimagem.add(Menu);
        setJMenuBar(Menu);
        JMenu menuCadastrar = new JMenu("Cadastrar");
        menuCadastrar.setFont(fonte);
        JMenu menuRemover = new JMenu("Remover");
        menuRemover.setFont(fonte);
        JMenu menuActualizar = new JMenu("Actualizar");
        menuActualizar.setFont(fonte);
        JMenu menuVisualizar = new JMenu("Visualizar");
        menuVisualizar.setFont(fonte);
        JMenu menuPresencas = new JMenu("Presenças ");
        menuPresencas.setFont(fonte);
        JMenu menuConcurso = new JMenu("Concurso");
        menuConcurso.setFont(fonte);
         menuAjuda = new JMenu("Ajuda"); menuAjuda.addActionListener(this);
        menuAjuda.setFont(fonte);
        JMenu menuSobre = new JMenu("Sobre");
        menuSobre.setFont(fonte);

        JMIFuncionario = new JMenuItem("Funcionario");            JMIFuncionario.addActionListener(this);
        JMIFuncionario.setBackground(Color.darkGray);
        JMIFuncionario.setForeground(Color.white);
        JMIFuncionario.setFont(fonte);
        JMIDepartamento = new JMenuItem("Departamento"); JMIDepartamento.addActionListener(this);
        JMIDepartamento.setBackground(Color.darkGray);
        JMIDepartamento.setForeground(Color.white);
        JMIDepartamento.setFont(fonte);
        JMIPresencas = new JMenuItem("Presenças ");                    JMIPresencas.addActionListener(this);
        JMIPresencas.setBackground(Color.darkGray);
        JMIPresencas.setForeground(Color.white);
        JMIPresencas.setFont(fonte);
        JMIConcurso = new JMenuItem("Concurso");                       JMIConcurso.addActionListener(this);
        JMIConcurso.setBackground(Color.darkGray);
        JMIConcurso.setForeground(Color.white);
        JMIConcurso.setFont(fonte);

        JMIRFuncionario = new JMenuItem("Funcionario");          JMIRFuncionario.addActionListener(this);
        JMIRFuncionario.setBackground(Color.darkGray);
        JMIRFuncionario.setForeground(Color.white);
        JMIRFuncionario.setFont(fonte);
        JMIRDepartamento = new JMenuItem("Departamento");  JMIRDepartamento.addActionListener(this);
        JMIRDepartamento.setBackground(Color.darkGray);
        JMIRDepartamento.setForeground(Color.white);
        JMIRDepartamento.setFont(fonte);
        JMIRConcurso = new JMenuItem("Concurso");                      JMIRConcurso.addActionListener(this);
        JMIRConcurso.setBackground(Color.darkGray);
        JMIRConcurso.setForeground(Color.white);
        JMIRConcurso.setFont(fonte);

        JMIAFuncionario = new JMenuItem("Funcionario");            JMIAFuncionario.addActionListener(this);
        JMIAFuncionario.setBackground(Color.darkGray);
        JMIAFuncionario.setForeground(Color.white);
        JMIAFuncionario.setFont(fonte);
        JMIADepartamento = new JMenuItem("Departamento");  JMIADepartamento.addActionListener(this);
        JMIADepartamento.setBackground(Color.darkGray);
        JMIADepartamento.setForeground(Color.white);
        JMIADepartamento.setFont(fonte);
        JMIAPresencas = new JMenuItem("Presencas");                    JMIAPresencas.addActionListener(this);
        JMIAPresencas.setBackground(Color.darkGray);
        JMIAPresencas.setForeground(Color.white);
        JMIAPresencas.setFont(fonte);
        JMIAConcurso = new JMenuItem("Concurso");                       JMIAConcurso.addActionListener(this);
        JMIAConcurso.setBackground(Color.darkGray);
        JMIAConcurso.setForeground(Color.white);
        JMIAConcurso.setFont(fonte);

        JMICFuncionario = new JMenuItem("Funcionario");               JMICFuncionario.addActionListener(this); 
        JMICFuncionario.setBackground(Color.darkGray); 
        JMICFuncionario.setForeground(Color.white);
        JMICFuncionario.setFont(fonte);
        JMICDepartamento = new JMenuItem("Departamento");    JMICDepartamento.addActionListener(this);
        JMICDepartamento.setBackground(Color.darkGray);
        JMICDepartamento.setForeground(Color.white);
        JMICDepartamento.setFont(fonte);
       

        JMIPEntrada = new JMenuItem("Presenca");                             JMIPEntrada.addActionListener(this);
        JMIPEntrada.setBackground(Color.darkGray);
        JMIPEntrada.setForeground(Color.white);
        JMIPEntrada.setFont(fonte);
        JMINova = new JMenuItem("Nova");                                          JMINova.addActionListener(this);
        JMINova.setBackground(Color.darkGray);
        JMINova.setForeground(Color.white);
        JMINova.setFont(fonte);
       
        JMINovo = new JMenuItem("Novo");                                          JMINovo.addActionListener(this);
        JMINovo.setBackground(Color.darkGray);
        JMINovo.setForeground(Color.white);
        JMINovo.setFont(fonte);
        
         JMIExistente = new JMenuItem("Existente");                                          JMIExistente.addActionListener(this);
        JMIExistente.setBackground(Color.darkGray);
        JMIExistente.setForeground(Color.white);
        JMIExistente.setFont(fonte);
        
         JMIAjuda = new JMenuItem("Ajuda");                                          JMIAjuda.addActionListener(this);
        JMIAjuda.setBackground(Color.darkGray);
        JMIAjuda.setForeground(Color.white);
        JMIAjuda.setFont(fonte);

        FrameInternal = new JInternalFrame();
        FrameInternal.setLayout(null);
        FrameInternal.setClosable(true);
        FrameInternal.setResizable(true);
        FrameInternal.setIconifiable(true);
        FrameInternal.setSize(700, 500);
        FrameInternal.setVisible(true);

        menuCadastrar.add(JMICFuncionario); 
        menuCadastrar.add(JMICDepartamento);

        menuRemover.add(JMIRFuncionario);
        menuRemover.add(JMIRDepartamento);
        menuRemover.add(JMIRConcurso);

        menuActualizar.add(JMIAFuncionario);
        menuActualizar.add(JMIADepartamento);
        menuActualizar.add(JMIAPresencas);
        menuActualizar.add(JMIAConcurso);

        menuVisualizar.add(JMIFuncionario);
        menuVisualizar.add(JMIDepartamento);
        menuVisualizar.add(JMIPresencas);
        menuVisualizar.add(JMIConcurso);

        menuPresencas.add(JMINova);
        menuConcurso.add(JMINovo);
        menuConcurso.add(JMIExistente);
        menuAjuda.add(JMIAjuda);

        Menu.add(menuCadastrar);
        Menu.add(menuRemover);
        Menu.add(menuActualizar);
        Menu.add(menuVisualizar);
        Menu.add(menuPresencas);
        Menu.add(menuConcurso);
        Menu.add(menuAjuda);
        Menu.add(menuSobre);
        
       
        
        
       setUndecorated(true);
        setLayout(null);
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
   }
    
    //===============================================================================================================
    //Area de Trabalho
   public void Link(String url){
       try{
           URI link =new URI(url);
           Desktop.getDesktop().browse(link);
       }
       catch(Exception erro){
           JOptionPane.showMessageDialog(null, erro+"Proble com a ligacao");
       }
       
       
   }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == JMICFuncionario) {
            try {
                FRMCadastrarFuncionario FRMCadFunc = new FRMCadastrarFuncionario();
            } catch (IOException ex) {
                Logger.getLogger(FRMMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FRMMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == btnFace) {
            Link("https://www.facebook.com");
           // JOptionPane.showMessageDialog(rootPane, "ERROR 345, FALHA HA CONEXAO COM A INTERNET", null, WIDTH);
        }
        if(e.getSource()==btnWha){
            Link("https://www.gmail.com");
        }
        if(e.getSource()==btnTwi){
            Link("https://www.twitter.com");
        }
        if(e.getSource()==JMICDepartamento){
            try {
             FRMCadastrarDepartamento   FRMCadDep = new FRMCadastrarDepartamento();
            } catch (IOException ex) {
                Logger.getLogger(FRMMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FRMMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==JMIRFuncionario){
            FRMRemoverFuncionario FRMRFu = new FRMRemoverFuncionario();
        }
        if(e.getSource()==JMIRDepartamento){
            FRMRemoverDepartamento F=new FRMRemoverDepartamento();
         }
        if((e.getSource()==JMIRConcurso)/* ||(e.getSource()== btnPresencas)*/){
            FRMRemoverConcurso kjas=new FRMRemoverConcurso();
        }
        if(e.getSource()==JMIFuncionario){
            try {
                FRMVisualizarFuncionario bZ=new FRMVisualizarFuncionario();
            } catch (IOException ex) {
                Logger.getLogger(FRMMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FRMMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==JMINova){
            try {
                FRMNovaPresenca sd=new FRMNovaPresenca();
            } catch (IOException ex) {
                Logger.getLogger(FRMMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FRMMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
        if(e.getSource()==btnPresencas){
            try {
                FRMNovaPresenca n=new FRMNovaPresenca();
            } catch (IOException ex) {
                Logger.getLogger(FRMMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FRMMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==JMIDepartamento){
            FRMVisualizarDepartamento v=new FRMVisualizarDepartamento();
        }
        if(e.getSource()==JMIPresencas){
            try {
                FRMVisualizarPresencas gh=new FRMVisualizarPresencas();
            } catch (IOException ex) {
                Logger.getLogger(FRMMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FRMMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==JMIAFuncionario){
            try {
                FRMActualizarFuncionario as=new FRMActualizarFuncionario();
            } catch (IOException ex) {
                Logger.getLogger(FRMMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FRMMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==JMIADepartamento){
            FRMActualizarDepartamento fgg=new FRMActualizarDepartamento();
        }
        if(e.getSource()==JMIAPresencas){
            try {
                FRMActualizarPresencas fl=new FRMActualizarPresencas();
            } catch (IOException ex) {
                Logger.getLogger(FRMMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FRMMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==JMINovo){
            try {
                FRMCadastrarConcurso o=new FRMCadastrarConcurso();
            } catch (IOException ex) {
                Logger.getLogger(FRMMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FRMMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==JMIExistente){
            try {
                FRMCadastrarConcorrente  a=new FRMCadastrarConcorrente();
            } catch (IOException ex) {
                Logger.getLogger(FRMMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FRMMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==btnSair){
            int confirmar = JOptionPane.showConfirmDialog(null, "Terminar A Seccao?", "Atencao", JOptionPane.YES_NO_OPTION);
            if (confirmar == JOptionPane.YES_OPTION) {
                //System.exit(0);
                FRMLogin log=new FRMLogin();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Boa Escolha Continue");
            }
    }
        if(e.getSource()==JMIAjuda){
            FRMAjuda a=new FRMAjuda();
        }
        if(e.getSource()==JMIAConcurso){
            try {
                FRMActualizarConcurso a=new FRMActualizarConcurso();
            } catch (IOException ex) {
                Logger.getLogger(FRMMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FRMMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==JMIConcurso){
            try {
                FRMVisualizarConcurso o=new FRMVisualizarConcurso();
            } catch (IOException ex) {
                Logger.getLogger(FRMMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FRMMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==btnRelatorios){
            FRMMiniRelatorios a=new FRMMiniRelatorios();
        }
    }
  //  public static void main(String[] args) {
    //    FRMMenuPrincipal a=new FRMMenuPrincipal();
  // }
}
