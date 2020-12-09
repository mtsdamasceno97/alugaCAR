package aplicacaoSwing;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Aluguel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JDesktopPane;


public class TelaListarAluguel{


    private JFrame frame;
    private JTextArea textArea;
    private JButton button1;
    private JTextField textField;
    private ArrayList<Aluguel> lista = new ArrayList<Aluguel>();

    public TelaListarAluguel() {
        initialize();
    }


    public void initialize() {
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
        frame.setTitle("Listagem");
        frame.setBounds(100, 100, 700, 350);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);


        textArea = new JTextArea();
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setBounds(24, 29, 650, 140);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        frame.getContentPane().add(scroll);



        button1 = new JButton("Listar Aluguel");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    String lista = Fachada.listarAlugueis();
                    textArea.setText(lista);

                }
                catch(Exception erro){
                    JOptionPane.showMessageDialog(null,erro.getMessage());
                }
            }
        });
        button1.setBounds(300, 180, 115, 23);
        frame.getContentPane().add(button1);

        JList list = new JList();
        list.setBounds(56, 372, 218, -71);
        frame.getContentPane().add(list);

        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setBounds(153, 372, 231, -97);
        frame.getContentPane().add(desktopPane);

        frame.setVisible(true);

    }
}

