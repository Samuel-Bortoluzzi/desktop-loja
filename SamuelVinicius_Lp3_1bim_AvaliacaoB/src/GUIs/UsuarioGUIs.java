package GUIs;

import DAOs.DAOUsuario;
import Entidades.Usuario;

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
public class UsuarioGUIs extends JDialog {

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
    JLabel lbId_usuario = new JLabel("Id");
    JTextField tfId_usuario = new JTextField(20);
    JLabel lbNome_completo = new JLabel("Nome");
    JTextField tfNome_completo = new JTextField(45);
    JLabel lbEmail = new JLabel("Email");
    JTextField tfEmail = new JTextField(45);
    JLabel lbSenha = new JLabel("Senha");
    JTextField tfSenha = new JTextField(20);
    JLabel lbNome_usuario = new JLabel("Nome Usuário");
    JTextField tfNome_usuario = new JTextField(20);
    JCheckBox cbAtivo = new JCheckBox("Ativo", false);
    JLabel lbCpf_usuario = new JLabel("CPF");
    JTextField tfCpf_usuario = new JTextField(20);

    DAOUsuario daoUsuario = new DAOUsuario();
    Usuario usuario = new Usuario();

    String[] colunas = new String[]{"idUsuario", "nomeCompleto","email", "senha", "nomeUsuario", "ativo", "cpfUsuario"};
    String[][] dados = new String[0][colunas.length];

    DefaultTableModel model = new DefaultTableModel(dados, colunas);
    JTable tabela = new JTable(model);

    public UsuarioGUIs() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setTitle("CRUD - Usuario");

        cp.add(pnNorte, BorderLayout.NORTH);
        cp.add(pnCentro, BorderLayout.CENTER);
        cp.add(pnSul, BorderLayout.SOUTH);

        pnNorte.setBackground(Color.LIGHT_GRAY);
        pnCentro.setBorder(BorderFactory.createLineBorder(Color.black));

        pnNorte.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnNorte.add(lbId_usuario);
        pnNorte.add(tfId_usuario);
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
        pnCentro.add(lbNome_completo);
        pnCentro.add(tfNome_completo);
        pnCentro.add(lbEmail);
        pnCentro.add(tfEmail);
        pnCentro.add(lbSenha);
        pnCentro.add(tfSenha);
        pnCentro.add(lbNome_usuario);
        pnCentro.add(tfNome_usuario);
        pnCentro.add(lbCpf_usuario);
        pnCentro.add(tfCpf_usuario);
        pnCentro.add(cbAtivo);

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

        tfNome_completo.setEditable(false);
        tfEmail.setEditable(false);
        tfSenha.setEditable(false);
        tfNome_usuario.setEditable(false);
        tfCpf_usuario.setEditable(false);
        cbAtivo.setEnabled(false);

// listener Buscar
        btBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(pnSul, "avisos");
                int valor = 0;
                try {
                    valor = Integer.valueOf(tfId_usuario.getText());
                    usuario = daoUsuario.obter(Integer.valueOf(tfId_usuario.getText()));
                    if (usuario != null) {//achou o usuario na lista
                        //mostrar
                        btAdicionar.setVisible(false);
                        btAlterar.setVisible(true);
                        btExcluir.setVisible(true);

                        tfNome_completo.setText(usuario.getNomeCompleto());
                        tfNome_completo.setEditable(false);
                        tfEmail.setText(usuario.getEmail());
                        tfEmail.setEditable(false);
                        tfSenha.setText(usuario.getSenha());
                        tfSenha.setEditable(false);
                        tfNome_usuario.setText(usuario.getNomeUsuario());
                        tfNome_usuario.setEditable(false);
                        tfCpf_usuario.setText(usuario.getCpfUsuario());
                        tfCpf_usuario.setEditable(false);
                        cbAtivo.setSelected(usuario.getAtivo()==1?true:false);

                    } else {//não achou na lista
                        //mostrar botão incluir
                        btAdicionar.setVisible(true);
                        btAlterar.setVisible(false);
                        btExcluir.setVisible(false);

                       tfNome_completo.setText("");
                        tfNome_completo.setEditable(false);
                        tfEmail.setText("");
                        tfEmail.setEditable(false);
                        tfSenha.setText("");
                        tfSenha.setEditable(false);
                        tfNome_usuario.setText("");
                        tfNome_usuario.setEditable(false);
                        tfCpf_usuario.setText("");
                        tfCpf_usuario.setEditable(false);
                        cbAtivo.setSelected(false);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(cp, "Erro no tipo de dados", "Erro ao buscar", JOptionPane.PLAIN_MESSAGE);
                    tfId_usuario.selectAll();
                    tfId_usuario.requestFocus();
                }
            }
        });

// listener Adicionar
        btAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfId_usuario.setEnabled(false);
                tfNome_completo.requestFocus();
                tfNome_completo.setEditable(true);
                tfEmail.setEditable(true);
                tfSenha.setEditable(true);
                tfNome_usuario.setEditable(true);
                tfCpf_usuario.setEditable(true);
                cbAtivo.setEnabled(true);
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
                Short ativo;
                if (cbAtivo.isSelected()) {
                    ativo = 1;
                } else{
                    ativo = 0;
                }
                
                if (acao.equals("alterar")) {
                    usuario.setIdUsuario(Integer.valueOf(tfId_usuario.getText()));
                    usuario.setNomeCompleto(tfNome_completo.getText());
                    usuario.setEmail(tfEmail.getText());
                    usuario.setSenha(tfSenha.getText());
                    usuario.setNomeUsuario(tfNome_usuario.getText());
                    usuario.setCpfUsuario(tfCpf_usuario.getText());
                    usuario.setAtivo(ativo);
                    daoUsuario.atualizar(usuario);
                } else {//adicionar
                    usuario = new Usuario();
                    usuario.setIdUsuario(Integer.valueOf(tfId_usuario.getText()));
                    usuario.setNomeCompleto(tfNome_completo.getText());
                    usuario.setEmail(tfEmail.getText());
                    usuario.setSenha(tfSenha.getText());
                    usuario.setNomeUsuario(tfNome_usuario.getText());
                    usuario.setCpfUsuario(tfCpf_usuario.getText());
                    usuario.setAtivo(ativo);
                    daoUsuario.inserir(usuario);
                }
                btSalvar.setVisible(false);
                btCancelar.setVisible(false);
                btBuscar.setVisible(true);
                btListar.setVisible(true);
                
                tfId_usuario.setEnabled(true);
                tfId_usuario.setEditable(true);
                tfId_usuario.requestFocus();
                tfId_usuario.setText("");
                tfNome_completo.setText("");
                tfNome_completo.setEditable(false);
                tfEmail.setText("");
                tfEmail.setEditable(false);
                tfSenha.setText("");
                tfSenha.setEditable(false);
                tfNome_usuario.setText("");
                tfNome_usuario.setEditable(false);
                tfCpf_usuario.setText("");
                tfCpf_usuario.setEditable(false);
                cbAtivo.setSelected(false);
                cbAtivo.setEnabled(true);
            }

        });
// listener Alterar
        btAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btBuscar.setVisible(false);
                btAlterar.setVisible(false);
                tfId_usuario.setEditable(false);
                tfNome_completo.requestFocus();
                tfNome_completo.setEditable(true);
                tfEmail.setEditable(true);
                tfSenha.setEditable(true);
                tfNome_usuario.setEditable(true);
                tfCpf_usuario.setEditable(true);
                cbAtivo.setEnabled(true);

                btSalvar.setVisible(true);
                btCancelar.setVisible(true);
                btListar.setVisible(false);
                tfId_usuario.setEnabled(true);
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
                tfId_usuario.setEnabled(true);
                tfId_usuario.setEditable(true);
                tfId_usuario.setText("");
                tfId_usuario.requestFocus();
                tfNome_completo.setText("");
                tfNome_completo.setEditable(false);
                tfEmail.setText("");
                tfEmail.setEditable(false);
                tfSenha.setText("");
                tfSenha.setEditable(false);
                tfNome_usuario.setText("");
                tfNome_usuario.setEditable(false);
                tfCpf_usuario.setText("");
                tfCpf_usuario.setEditable(false);
                cbAtivo.setSelected(false);
                cbAtivo.setEnabled(true);
                btAlterar.setVisible(false);
                if (response == JOptionPane.YES_OPTION) {
                    daoUsuario.remover(usuario);
                }
            }
        });

// listener Listar
        btListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Usuario> listaUsuario = daoUsuario.listInOrderNome();
                String[] colunas = new String[]{"idUsuario", "nomeCompleto","email", "senha", "nomeUsuario", "ativo", "cpfUsuario"};
                String[][] dados = new String[listaUsuario.size()][colunas.length];
                String aux[];
                for (int i = 0; i < listaUsuario.size(); i++) {
                    aux = listaUsuario.get(i).toString().split(";");
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
                
                tfId_usuario.setText("");
                tfId_usuario.requestFocus();
                tfId_usuario.setEnabled(true);
                tfId_usuario.setEditable(true);
                tfNome_completo.setText("");
                tfNome_completo.setEditable(false);
                tfEmail.setText("");
                tfEmail.setEditable(false);
                tfSenha.setText("");
                tfSenha.setEditable(false);
                tfNome_usuario.setText("");
                tfNome_usuario.setEditable(false);
                tfCpf_usuario.setText("");
                tfCpf_usuario.setEditable(false);
                cbAtivo.setSelected(false);
                cbAtivo.setEnabled(false);
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
