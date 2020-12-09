package aplicacaoSwing;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import fachada.Fachada;
import java.awt.Cursor;

public class TelaPrincipal {

    private JFrame frame;
    private JMenu mnConsulta;
    private JMenu mnTelefone;
    private JMenu mnCliente;
    private JMenuItem mntmCadastrarCliente;
    private JMenuItem mntmApagarPessoa;
    private JMenuItem mntmListarPessoa;
    private JMenuItem mntmCadastrarTelefone;
    private JMenuItem mntmApagarTelefone;
    private JMenuItem mntmListarTelefone;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaPrincipal window = new TelaPrincipal();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public TelaPrincipal() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent arg0) {
                frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

                Fachada.inicializar();

                frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                JOptionPane.showMessageDialog(frame, "sistema inicializado !");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                Fachada.finalizar();
                JOptionPane.showMessageDialog(frame, "sistema finalizado !");
            }
        });
        frame.setTitle("ALUGACAR");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);


        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        mnCliente = new JMenu("Cliente");
        menuBar.add(mnCliente);

        mntmCadastrarCliente = new JMenuItem("Cadastrar");
        mntmCadastrarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                TelaCadastrar tela = new TelaCadastrar();
            }

        });
        mnCliente.add(mntmCadastrarCliente);

//        mntmApagarPessoa = new JMenuItem("Apagar");
//        mntmApagarPessoa.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                TelaApagar tela = new TelaApagar();
//            }
//        });
//        mnPessoa.add(mntmApagarPessoa);
//
//
//        mntmListarPessoa = new JMenuItem("Listar");
//        mntmListarPessoa.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                TelaListarConsultar tela = new TelaListarConsultar();
//            }
//        });
//        mnPessoa.add(mntmListarPessoa);
//
//        //-----------------------------------------------------------------
//        mnTelefone = new JMenu("Telefone");
//        menuBar.add(mnTelefone);
//
//        mntmCadastrarTelefone = new JMenuItem("Cadastrar");
//        mntmCadastrarTelefone.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                TelaCadastrar tela = new TelaCadastrar();
//            }
//        });
//        mnTelefone.add(mntmCadastrarTelefone);
//
//        mntmApagarTelefone = new JMenuItem("Apagar");
//        mntmApagarTelefone.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                TelaApagar tela = new TelaApagar();
//            }
//        });
//        mnTelefone.add(mntmApagarTelefone);
//
//
//        mntmListarTelefone = new JMenuItem("Listar");
//        mntmListarTelefone.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                TelaListarConsultar tela = new TelaListarConsultar();
//            }
//        });
//        mnTelefone.add(mntmListarTelefone);
//
//
//        mnConsulta = new JMenu("Consultas");
//        menuBar.add(mnConsulta);
//        mnConsulta.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent arg0) {
//                TelaListarConsultar tela = new TelaListarConsultar();
//            }
//        });
//
//    }
    }
}
