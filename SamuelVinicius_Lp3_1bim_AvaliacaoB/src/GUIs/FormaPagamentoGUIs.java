package GUIs;

import Entidades.FormaPagamento;
import DAOs.DAOFormaPagamento;
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
 * @author Samuel 30/08/2021 - 11:39:29
 */
public class FormaPagamentoGUIs extends JDialog {

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
    JLabel lbIdFormaPagamento = new JLabel("Id");
    JTextField tfIdFormaPagamento = new JTextField(20);
    JLabel lbNomeFormaPagamento = new JLabel("Nome");
    JTextField tfNomeFormaPagamento = new JTextField(40);
    
    DAOFormaPagamento daoFormaPagamento = new DAOFormaPagamento();
    FormaPagamento formaPagamento = new FormaPagamento();
    
    String[] colunas = new String[]{"idFormaPagamento", "nomeFormaPagamento"};
    String[][] dados = new String[0][colunas.length];

    DefaultTableModel model = new DefaultTableModel(dados, colunas);
    JTable tabela = new JTable(model);

    public FormaPagamentoGUIs() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setTitle("CRUD - Forma Pagamento");

        cp.add(pnNorte, BorderLayout.NORTH);
        cp.add(pnCentro, BorderLayout.CENTER);
        cp.add(pnSul, BorderLayout.SOUTH);

        pnNorte.setBackground(Color.LIGHT_GRAY);
        pnCentro.setBorder(BorderFactory.createLineBorder(Color.black));

        pnNorte.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnNorte.add(lbIdFormaPagamento);
        pnNorte.add(tfIdFormaPagamento);
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
        pnCentro.add(lbNomeFormaPagamento);
        pnCentro.add(tfNomeFormaPagamento);
        cardLayout = new CardLayout();
        pnSul.setLayout(cardLayout);

        for (int i = 0; i < 5; i++) {
            pnVazio.add(new JLabel(" "));
        }
        pnSul.add(pnVazio, "vazio");
        pnSul.add(pnAvisos, "avisos");
        pnSul.add(pnListagem, "listagem");
        tabela.setEnabled(false);

        tfNomeFormaPagamento.setEditable(false);

// listener Buscar
        btBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(pnSul, "avisos");
                int valor = 0;
                try {
                    valor = Integer.valueOf(tfIdFormaPagamento.getText());
                    formaPagamento = daoFormaPagamento.obter(Integer.valueOf(tfIdFormaPagamento.getText()));
                    if (formaPagamento != null) {//achou o formaPagamento na lista
                        //mostrar
                        btAdicionar.setVisible(false);
                        btAlterar.setVisible(true);
                        btExcluir.setVisible(true);
                        tfNomeFormaPagamento.setText(formaPagamento.getNomeFormaPagamento());
                        tfNomeFormaPagamento.setEditable(false);
                    } else {//não achou na lista
                        //mostrar botão incluir
                        btAdicionar.setVisible(true);
                        btAlterar.setVisible(false);
                        btExcluir.setVisible(false);
                        tfNomeFormaPagamento.setText("");
                        tfNomeFormaPagamento.setEditable(false);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(cp, "Erro no tipo de dados", "Erro ao buscar", JOptionPane.PLAIN_MESSAGE);
                    tfIdFormaPagamento.selectAll();
                    tfIdFormaPagamento.requestFocus();
                }
            }
        });

// listener Adicionar
        btAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfIdFormaPagamento.setEnabled(false);
                tfNomeFormaPagamento.requestFocus();
                tfNomeFormaPagamento.setEditable(true);
                btAdicionar.setVisible(false);
                btSalvar.setVisible(true);
                btCancelar.setVisible(true);
                btBuscar.setVisible(false);
                btListar.setVisible(false);
                acao = "adicionar";
            }
        });

// listener Salvar
        btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (acao.equals("alterar")) {
                    FormaPagamento formaPagamentoAntiga = formaPagamento;
                    formaPagamento.setIdPagamento(Integer.valueOf(tfIdFormaPagamento.getText()));
                    formaPagamento.setNomeFormaPagamento(tfNomeFormaPagamento.getText());
                    daoFormaPagamento.atualizar(formaPagamento);
                } else {//adicionar
                    formaPagamento = new FormaPagamento();
                    formaPagamento.setIdPagamento(Integer.valueOf(tfIdFormaPagamento.getText()));
                    formaPagamento.setNomeFormaPagamento(tfNomeFormaPagamento.getText());
                    daoFormaPagamento.inserir(formaPagamento);
                }
                btSalvar.setVisible(false);
                btCancelar.setVisible(false);
                btBuscar.setVisible(true);
                btListar.setVisible(true);
                
                tfIdFormaPagamento.setEnabled(true);
                tfIdFormaPagamento.setEditable(true);
                tfIdFormaPagamento.requestFocus();
                tfIdFormaPagamento.setText("");
                tfNomeFormaPagamento.setText("");
        }

            });

// listener Alterar
        btAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btBuscar.setVisible(false);
                btAlterar.setVisible(false);
                tfIdFormaPagamento.setEditable(false);
                tfNomeFormaPagamento.requestFocus();
                tfNomeFormaPagamento.setEditable(true);
                
                btSalvar.setVisible(true);
                btCancelar.setVisible(true);
                btListar.setVisible(false);
                tfIdFormaPagamento.setEnabled(true);
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
                tfIdFormaPagamento.setEnabled(true);
                tfIdFormaPagamento.setEditable(true);
                tfIdFormaPagamento.requestFocus();
                tfIdFormaPagamento.setText("");
                tfIdFormaPagamento.setEditable(false);
                tfNomeFormaPagamento.setText("");
                tfNomeFormaPagamento.setEditable(false);
                btAlterar.setVisible(false);
                if (response == JOptionPane.YES_OPTION) {
                    daoFormaPagamento.remover(formaPagamento);
                }
            }
        });

// listener Listar
        btListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<FormaPagamento> listaFormaPagamento = daoFormaPagamento.listInOrderNome();
                String[] colunas = new String[]{"id Forma de Pagamento", "nome Forma de Pagamento"};
                String[][] dados = new String[listaFormaPagamento.size()][colunas.length];
                String aux[];
                for (int i = 0; i < listaFormaPagamento.size(); i++) {
                    aux = listaFormaPagamento.get(i).toString().split(";");
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
                tfIdFormaPagamento.setText("");
                tfIdFormaPagamento.requestFocus();
                tfIdFormaPagamento.setEnabled(true);
                tfIdFormaPagamento.setEditable(true);
                tfNomeFormaPagamento.setText("");
                tfNomeFormaPagamento.setEditable(false);
            }
        });

// listener ao fechar o programa
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //antes de sair, salvar a lista em armazenamento permanente
//                controle.gravarLista(caminho);
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
