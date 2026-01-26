package dvocas12.zadatak1.gui;

import dvocas12.zadatak1.poslovna_logika.Osoba;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ImenikGUI extends JFrame {
    private JPanel mojPanel;
    private JTextField textFieldIme;
    private JTextField textFieldAdresa;
    private JTextField textFieldPrezime;
    private JTextField textFieldTelefon;
    private JButton dodajButton;
    private JButton obrisiButton;
    private JButton prikaziButton;
    private JButton izadjiButton;
    private JTextArea textAreaImenik;

    private List<Osoba> osobe = new ArrayList<>();

    public ImenikGUI(){
        setContentPane(mojPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBounds(500, 500, 600, 300);
        //pack();
        setSize(800, 300);
        setLocationRelativeTo(null);
        setTitle("Telefonski imenik");
        //setResizable(false);
        izadjiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        obrisiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textAreaImenik.setText(null);
                textFieldAdresa.setText(null);
                textFieldIme.setText(null);
                textFieldPrezime.setText(null);
                textFieldTelefon.setText(null);
            }
        });
        prikaziButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textAreaImenik.setText(null);

                for (Osoba o: osobe)
                    textAreaImenik.append( o.toString()  + System.lineSeparator() );
            }
        });
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String ime = textFieldIme.getText();
                    String prezime = textFieldPrezime.getText();
                    String adresa = textFieldAdresa.getText();
                    int telefon = Integer.parseInt(textFieldTelefon.getText());

                    Osoba novaOsoba = new Osoba();
                    novaOsoba.setIme(ime);
                    novaOsoba.setPrezime(prezime);
                    novaOsoba.setAdresa(adresa);
                    novaOsoba.setTelefon(telefon);

                    if (osobe.contains(novaOsoba))
                        throw new IllegalArgumentException("Osoba vec postoji u imeniku");

                    osobe.add(novaOsoba);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(mojPanel,
                            e.getMessage(),
                            "Greska " + e.getClass().toString(),
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        ImenikGUI ig = new ImenikGUI();

        ig.setVisible(true);
    }

}
