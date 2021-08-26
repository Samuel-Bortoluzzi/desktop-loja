package GUIs;

import DAOs.DAOProduto;
import Entidades.Produto;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import tools.DateTextField;
import javax.swing.JCheckBox;

/**
 *
 * @author Samuel 26/07/2021 - 12:44:01
 */
public class ProdutoGUIs extends JDialog {

    Container cp;
    JPanel pnNorte = new JPanel();
    JPanel pnCentro = new JPanel();
    JPanel pnSul = new JPanel();
    JButton btBuscar = new JButton("Buscar");
    JButton btAdicionar = new JButton("Adicionar");
    JButton btSalvar = new JButton("Salvar");
    JButton btAlterar = new JButton("Alterar");
    JButton btExcluir = new JButton("Excluir");
    JButton btListar = new JButton("Listar");
    JButton btCancelar = new JButton("Cancelar");
    String acao = "";
    private JScrollPane scrollTabela = new JScrollPane();

    private JPanel pnAvisos = new JPanel(new GridLayout(1, 1));
    private JPanel pnListagem = new JPanel(new GridLayout(1, 1));
    private JPanel pnVazio = new JPanel(new GridLayout(6, 1));

    private CardLayout cardLayout;

//////////////////// - mutável - /////////////////////////
    JLabel lbId_produto = new JLabel("Id");
    JTextField tfId_produto = new JTextField(20);
    JLabel lbNome_produto = new JLabel("Nome");
    JTextField tfNome_produto = new JTextField(45);
    JLabel lbCategoria = new JLabel("Categoria");
    JTextField tfCategoria = new JTextField(45);
    JLabel lbPreco = new JLabel("Preço");
    JTextField tfPreco = new JTextField(20);
    JLabel lbData_cadastro = new JLabel("Cadastro");
    DateTextField tfData_cadastro = new DateTextField();
    JLabel lbQtd_estoque = new JLabel("Estoque");
    JTextField tfQtd_estoque = new JTextField(20);

    DAOProduto daoProduto = new DAOProduto();
    Produto produto = new Produto();

    String[] colunas = new String[]{" idProduto", " nomeProduto", " categoria", " preco", " dataCadastro", " qtdEstoque"};
    String[][] dados = new String[0][colunas.length];

    DefaultTableModel model = new DefaultTableModel(dados, colunas);
    JTable tabela = new JTable(model);

    public ProdutoGUIs() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setTitle("CRUD - Produto");

        cp.add(pnNorte, BorderLayout.NORTH);
        cp.add(pnCentro, BorderLayout.CENTER);
        cp.add(pnSul, BorderLayout.SOUTH);

        pnNorte.setBackground(Color.LIGHT_GRAY);
        pnCentro.setBorder(BorderFactory.createLineBorder(Color.black));

        pnNorte.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnNorte.add(lbId_produto);
        pnNorte.add(tfId_produto);
        pnNorte.add(btBuscar);
        pnNorte.add(btAdicionar);
        pnNorte.add(btAlterar);
        pnNorte.add(btExcluir);
        pnNorte.add(btListar);
        pnNorte.add(btSalvar);
        pnNorte.add(btCancelar);

        btSalvar.setVisible(false);
        btAdicionar.setVisible(false);
        btAlterar.setVisible(false);
        btExcluir.setVisible(false);
        btCancelar.setVisible(false);

        pnCentro.setLayout(new GridLayout(colunas.length - 1, 2));
        pnCentro.add(lbNome_produto);
        pnCentro.add(tfNome_produto);
        pnCentro.add(lbCategoria);
        pnCentro.add(tfCategoria);
        pnCentro.add(lbPreco);
        pnCentro.add(tfPreco);
        pnCentro.add(lbData_cadastro);
        pnCentro.add(tfData_cadastro);
        pnCentro.add(lbQtd_estoque);
        pnCentro.add(tfQtd_estoque);

        cardLayout = new CardLayout();
        pnSul.setLayout(cardLayout);

        for (int i = 0; i < 5; i++) {
            pnVazio.add(new JLabel(" "));
        }
        pnSul.add(pnVazio, "vazio");
        pnSul.add(pnAvisos, "avisos");
        pnSul.add(pnListagem, "listagem");
        tabela.setEnabled(false);

        pnAvisos.add(new JLabel("Avisos"));

        tfNome_produto.setEditable(false);
        tfCategoria.setEditable(false);
        tfPreco.setEditable(false);
        tfData_cadastro.setEnabled(false);
        tfData_cadastro.setEditable(false);
        tfQtd_estoque.setEditable(false);

// listener Buscar
        btBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(pnSul, "avisos");
                int valor = 0;
                try {
                    valor = Integer.valueOf(tfId_produto.getText());
                    produto = daoProduto.obter(Integer.valueOf(tfId_produto.getText()));
                    if (produto != null) {//achou o produto na lista
                        //mostrar
                        btAdicionar.setVisible(false);
                        btAlterar.setVisible(true);
                        btExcluir.setVisible(true);

                        tfNome_produto.setText(produto.getNomeProduto());
                        tfNome_produto.setEditable(false);
                        tfCategoria.setText(produto.getCategoria());
                        tfCategoria.setEditable(false);
                        tfPreco.setText(String.valueOf(produto.getPreco()));
                        tfPreco.setEditable(false);
                        tfData_cadastro.setText(String.valueOf(produto.getDataCadastro()));
                        tfData_cadastro.setEditable(false);
                        tfData_cadastro.setEnabled(false);
                        tfQtd_estoque.setText(String.valueOf(produto.getQtdEstoque()));
                        tfQtd_estoque.setEditable(false);

                    } else {//não achou na lista
                        //mostrar botão incluir
                        btAdicionar.setVisible(true);
                        btAlterar.setVisible(false);
                        btExcluir.setVisible(false);

                        tfNome_produto.setText("");
                        tfNome_produto.setEditable(false);
                        tfCategoria.setText("");
                        tfCategoria.setEditable(false);
                        tfPreco.setText("");
                        tfPreco.setEditable(false);
                        tfData_cadastro.setEditable(false);
                        tfQtd_estoque.setEditable(false);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(cp, "Erro no tipo de dados", "Erro ao buscar", JOptionPane.PLAIN_MESSAGE);
                    tfId_produto.selectAll();
                    tfId_produto.requestFocus();
                }
            }
        });

// listener Adicionar
        btAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfId_produto.setEnabled(false);
                tfNome_produto.requestFocus();
                tfNome_produto.setEditable(true);
                tfCategoria.setEditable(true);
                tfPreco.setEditable(true);
                tfData_cadastro.setEditable(true);
                tfQtd_estoque.setEditable(true);
                btAdicionar.setVisible(false);
                btSalvar.setVisible(true);
                btCancelar.setVisible(true);
                btBuscar.setVisible(false);
                btListar.setVisible(false);
                acao = "adicionar";
            }
        });


        btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (acao.equals("alterar")) {
                    Produto produtoAntigo = produto;
                    produto.setIdProduto(Integer.valueOf(tfId_produto.getText()));
                    produto.setNomeProduto(tfNome_produto.getText());
                    produto.setCategoria(tfCategoria.getText());
                    produto.setPreco(Double.valueOf(tfPreco.getText()));
                    produto.setDataCadastro(tfData_cadastro.getDate());
                    produto.setQtdEstoque(Integer.valueOf(tfQtd_estoque.getText()));
                    daoProduto.atualizar(produto);
                } else {//adicionar
                    produto = new Produto();
                    produto.setIdProduto(Integer.valueOf(tfId_produto.getText()));
                    produto.setNomeProduto(tfNome_produto.getText());
                    produto.setCategoria(tfCategoria.getText());
                    produto.setPreco(Double.valueOf(tfPreco.getText()));
                    produto.setDataCadastro(tfData_cadastro.getDate());
                    produto.setQtdEstoque(Integer.valueOf(tfQtd_estoque.getText()));
                    daoProduto.inserir(produto);
                }
                btSalvar.setVisible(false);
                btCancelar.setVisible(false);
                btBuscar.setVisible(true);
                btListar.setVisible(true);
                
                tfId_produto.setEnabled(true);
                tfId_produto.setEditable(true);
                tfId_produto.requestFocus();
                tfId_produto.setText("");
                tfNome_produto.setText("");
                tfNome_produto.setEditable(false);
                tfCategoria.setText("");
                tfCategoria.setEditable(false);
                tfPreco.setText("");
                tfPreco.setEditable(false);
                tfData_cadastro.setText("");
                tfData_cadastro.setEditable(false);
                tfQtd_estoque.setText("");
                tfQtd_estoque.setEditable(false);
            }

        });
// listener Alterar
        btAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btBuscar.setVisible(false);
                btAlterar.setVisible(false);
                tfId_produto.setEditable(false);
                tfNome_produto.requestFocus();
                tfNome_produto.setEditable(true);
                tfCategoria.setEditable(true);
                tfPreco.setEditable(true);
                tfData_cadastro.setEditable(true);
                tfQtd_estoque.setEditable(true);

                btSalvar.setVisible(true);
                btCancelar.setVisible(true);
                btListar.setVisible(false);
                tfId_produto.setEnabled(true);
                btExcluir.setVisible(false);
                acao = "alterar";

            }
        });

// listener Excluir
        btExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int response = JOptionPane.showConfirmDialog(cp, "Confirme a exclusão?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                btExcluir.setVisible(false);
                tfId_produto.setEnabled(true);
                tfId_produto.setEditable(true);
                tfId_produto.setText("");
                tfId_produto.requestFocus();
                tfNome_produto.setText("");
                tfNome_produto.setEditable(false);
                tfCategoria.setText("");
                tfCategoria.setEditable(false);
                tfPreco.setText("");
                tfPreco.setEditable(false);
                tfData_cadastro.setText("");
                tfData_cadastro.setEditable(false);
                tfQtd_estoque.setText("");
                tfQtd_estoque.setEditable(false);
                btAlterar.setVisible(false);
                if (response == JOptionPane.YES_OPTION) {
                    daoProduto.remover(produto);
                }
            }
        });

// listener Listar
        btListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Produto> listaProduto = daoProduto.listInOrderNome();
                String[] colunas = new String[]{" idProduto", " nomeProduto", " categoria", " preco", " dataCadastro", " qtdEstoque"};
                String[][] dados = new String[listaProduto.size()][colunas.length];
                String aux[];
                for (int i = 0; i < listaProduto.size(); i++) {
                    aux = listaProduto.get(i).toString().split(";");
                    for (int j = 0; j < colunas.length; j++) {
                        dados[i][j] = aux[j];
                    }
                }
                cardLayout.show(pnSul, "listagem");
                scrollTabela.setPreferredSize(tabela.getPreferredSize());
                pnListagem.add(scrollTabela);
                scrollTabela.setViewportView(tabela);
                model.setDataVector(dados, colunas);

                btAlterar.setVisible(false);
                btExcluir.setVisible(false);
                btAdicionar.setVisible(false);

            }
        });

// listener Cancelar
        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btCancelar.setVisible(false);
                btBuscar.setVisible(true);
                btListar.setVisible(true);
                btSalvar.setVisible(false);
                btCancelar.setVisible(false);
                tfId_produto.setText("");
                tfId_produto.requestFocus();
                tfId_produto.setEnabled(true);
                tfId_produto.setEditable(true);
                tfNome_produto.setText("");
                tfNome_produto.setEditable(false);
                tfCategoria.setText("");
                tfCategoria.setEditable(false);
                tfPreco.setText("");
                tfPreco.setEditable(false);
                tfData_cadastro.setText("");
                tfData_cadastro.setEditable(false);
                tfQtd_estoque.setText("");
                tfQtd_estoque.setEditable(false);
            }
        });

// listener ao fechar o programa
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //antes de sair, salvar a lista em armazenamento permanente
//                btGravar.doClick();
                // Sai da classe
                dispose();
            }
        });

        setModal(true);
        pack();
        setLocationRelativeTo(null);//centraliza na tela
        setVisible(true);
    }//fim do contrutor de GUIs
} //fim da classe
