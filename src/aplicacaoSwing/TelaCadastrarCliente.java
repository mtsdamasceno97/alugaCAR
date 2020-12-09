package aplicacaoSwing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fachada.Fachada;

public class TelaCadastrarCliente {
    private JFrame frame;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel label_3;
    private JLabel label_4;
    private JLabel label_5;

    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JButton button;

    public TelaCadastrarCliente() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
        frame.setTitle("Cadastro");
        frame.setBounds(100, 100, 263, 211);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        label_1 = new JLabel("nome:");
        label_1.setHorizontalAlignment(SwingConstants.RIGHT);
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        label_1.setBounds(5, 25, 71, 14);
        frame.getContentPane().add(label_1);

        textField = new JTextField();
        textField.setBounds(91, 25, 121, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        label_2 = new JLabel("nasc:");
        label_2.setHorizontalAlignment(SwingConstants.RIGHT);
        label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        label_2.setBounds(5, 50, 71, 14);
        frame.getContentPane().add(label_2);

        textField_1 = new JTextField();
        textField_1.setBounds(91, 50, 121, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);


        label_3 = new JLabel("endereco:");
        label_3.setHorizontalAlignment(SwingConstants.RIGHT);
        label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
        label_3.setBounds(5, 75, 71, 14);
        frame.getContentPane().add(label_3);

        textField_2 = new JTextField();
        textField_2.setBounds(91, 75, 121, 20);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);


        label_4 = new JLabel("cpf:");
        label_4.setHorizontalAlignment(SwingConstants.RIGHT);
        label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
        label_4.setBounds(5, 100, 71, 14);
        frame.getContentPane().add(label_4);

        textField_3 = new JTextField();
        textField_3.setBounds(91, 100, 121, 20);
        frame.getContentPane().add(textField_3);
        textField_3.setColumns(10);


        label_5 = new JLabel("");
        label_5.setBounds(5, 125, 227, 14);
        frame.getContentPane().add(label_5);

        button = new JButton("Cadastrar");
        button.setFont(new Font("Tahoma", Font.PLAIN, 12));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    String nome = textField.getText();
                    String nascimento = textField_1.getText();
                    String endereco = textField_2.getText();
                    String cpf = textField_3.getText();

                    Fachada.cadastrarCliente(nome, nascimento, endereco, cpf);
                    textField.setText("");
                    textField_1.setText("");
                    textField_2.setText("");
                    textField_3.setText("");
                    label_2.setText("cadastro realizado");
                }
                catch(Exception e) {
                    label_2.setText(e.getMessage());
                }
            }
        });
        button.setBounds(69, 150, 108, 23);
        frame.getContentPane().add(button);

        frame.setVisible(true);
    }
}
