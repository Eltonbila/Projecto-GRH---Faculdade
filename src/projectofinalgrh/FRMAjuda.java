
package projectofinalgrh;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class FRMAjuda extends JFrame {
    JLabel lblImagem;
    public FRMAjuda(){
        setTitle("Ajuda");
        setResizable(false);
        setSize(750, 500);
        setBounds(300, 100, 750, 600-50);
        ImageIcon icon = new ImageIcon(getClass().getResource("Ajuda.png"));
        lblImagem=new JLabel(icon); lblImagem.setBounds(0, 0, 750, 550); add(lblImagem);
        
        
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
        
    }
  
    
    
}
