package GUIs;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Samuel
 */
public class MenuPrincipal extends JFrame{
    
    private Container cp;
    private JButton btProduto = new JButton("Produto");
    private JButton btUsuario = new JButton("Usuário");
    
    
    public MenuPrincipal() {
        cp= getContentPane();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Menu Principal");
        
        cp.setLayout(new GridLayout(2,1));
        
        cp.add(btProduto);
        cp.add(btUsuario);
        
        btProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ProdutoGUIs produtoGUIs = new ProdutoGUIs();
            }
        });
        
        btUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                UsuarioGUIs usuarioGUIs = new UsuarioGUIs();
            }
        });
        
        setSize(200,200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    

 
    
    
    
}
