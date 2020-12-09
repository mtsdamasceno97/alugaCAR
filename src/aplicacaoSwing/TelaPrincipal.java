package aplicacaoSwing;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import antlr.collections.List;
import aplicacaoSwing.TelaListarCliente;
import fachada.Fachada;
import java.awt.Cursor;

public class TelaPrincipal {

    private JFrame frame;

    private JMenu mnVeiculo;
    private JMenu mnCliente;
    private JMenu mnAluguel;
    private JMenuItem mntmCadastrarCliente;
    private JMenuItem mntmListarCliente;
    private JMenuItem mntmCadastrarVeiculo;
    private JMenuItem mntmListarVeiculo;
    private JMenuItem mntmCadastrarAluguel;
    private JMenuItem mntmListarAluguel;

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
        mnVeiculo = new JMenu("Veiculo");
        menuBar.add(mnVeiculo);
        mnAluguel = new JMenu("Aluguel");
        menuBar.add(mnAluguel);



        mntmCadastrarCliente = new JMenuItem("Cadastrar");
        mntmCadastrarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                TelaCadastrarCliente tela = new TelaCadastrarCliente();
            }

        });
        mnCliente.add(mntmCadastrarCliente);

        mntmListarCliente = new JMenuItem("Listar");
        mntmListarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) { TelaListarCliente tela = new TelaListarCliente();}

        });

        mnCliente.add(mntmListarCliente);


        mntmCadastrarVeiculo = new JMenuItem("Cadastrar");
        mntmCadastrarVeiculo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                TelaCadastrarVeiculo tela = new TelaCadastrarVeiculo();
            }

        });
        mnVeiculo.add(mntmCadastrarVeiculo);

        mntmListarVeiculo = new JMenuItem("Listar");
        mntmListarVeiculo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) { TelaListarVeiculo tela = new TelaListarVeiculo();}

        });

        mnVeiculo.add(mntmListarVeiculo);

        mntmCadastrarAluguel = new JMenuItem("Cadastrar");
        mntmCadastrarAluguel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                TelaCadastrarAluguel tela = new TelaCadastrarAluguel();
            }

        });
        mnAluguel.add(mntmCadastrarAluguel);

        mntmListarAluguel = new JMenuItem("Listar");
        mntmListarAluguel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) { TelaListarAluguel tela = new TelaListarAluguel();}

        });

        mnAluguel.add(mntmListarAluguel);
    }
}
