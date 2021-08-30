package GUIs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Samuel
 */
public class MenuPrincipal extends JFrame{
    
    private Container cp;
    JPanel pnNorte = new JPanel();
    JPanel pnCentro = new JPanel();
    JLabel lbTitulo = new JLabel("Gerenciador ");
    
    Font fonte = new Font("Monotype Corsiva", Font.BOLD, 30);

    JLabel labelComImagemDeTamanhoDiferente = new JLabel();

    JMenuBar menuBar = new JMenuBar();
    JMenu menuCadastros = new JMenu("Cadastros");
    JMenuItem cadProduto = new JMenuItem("Produto");
    JMenuItem cadUsuario = new JMenuItem("Usuário");
    JMenuItem cadFormaPagamento = new JMenuItem("Forma de Pagamento");
    
    Point p;
    
    public MenuPrincipal(Dimension dimensao) {
        cp= getContentPane();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(dimensao);
        setTitle(lbTitulo.getText());
        
        pnNorte.add(lbTitulo);
        lbTitulo.setFont(fonte);
        pnNorte.setBackground(Color.LIGHT_GRAY);
        
        //para ajustar o tamanho de uma imagem
         try {
            ImageIcon icone = new ImageIcon(getClass().getResource("/imagens/Coala.jpg"));
            Image imagemAux;
            imagemAux = icone.getImage();
            icone.setImage(imagemAux.getScaledInstance((int) dimensao.getWidth()-20, (int) dimensao.getHeight()-80, Image.SCALE_FAST));

            labelComImagemDeTamanhoDiferente = new JLabel();
            labelComImagemDeTamanhoDiferente.setIcon(icone);
        } catch (Exception e) {
            System.out.println("erro ao carregar a imagem");
        }
         
         pnCentro.add(labelComImagemDeTamanhoDiferente);
        pnCentro.setBackground(Color.BLACK);

        cp.add(pnNorte, BorderLayout.NORTH);
        cp.add(pnCentro, BorderLayout.CENTER);

        setJMenuBar(menuBar);
        menuBar.add(menuCadastros);

        menuCadastros.add(cadProduto);
        menuCadastros.add(cadUsuario);
        menuCadastros.add(cadFormaPagamento);
         
        cadProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ProdutoGUIs produtoGUIs = new ProdutoGUIs();
            }
        });
        
        cadUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                UsuarioGUIs usuarioGUIs = new UsuarioGUIs();
            }
        });
        cadFormaPagamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FormaPagamentoGUIs formaPagamentoGUIs = new FormaPagamentoGUIs();
            }
        });
        
        setSize(200,200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public MenuPrincipal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
