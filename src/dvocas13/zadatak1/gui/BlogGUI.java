package dvocas13.zadatak1.gui;

import dvocas13.zadatak1.poslovna_logika.Blog;
import dvocas13.zadatak1.poslovna_logika.BlogPost;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

public class BlogGUI extends JFrame {

    private JPanel mojPanel;
    private JTextField textFieldNaslov;
    private JButton dodajPostButton;
    private JButton prikaziSveButton;
    private JTextField textFieldPutanja;
    private JComboBox comboBox1;
    private JButton sacuvajButton;
    private JButton izadjiButton;
    private JTextArea textAreaSadrzaj;

    private Blog blog;

    public BlogGUI(){
        setContentPane(mojPanel);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setTitle("Program za pisanje blog-a");

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                    izadji();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        blog = new Blog();

        prikaziSveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaSadrzaj.setText(null);

                List<BlogPost> postovi = blog.getPostovi();

                for(BlogPost post: postovi)
                    textAreaSadrzaj.append(post.toString());
            }
        });
        izadjiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                izadji();
            }
        });
        dodajPostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BlogPost post = new BlogPost();

                    post.setNaslov(textFieldNaslov.getText());
                    post.setSadrzaj(textAreaSadrzaj.getText());

                    blog.dodajPost(post);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,
                            ex.getMessage(),
                            "Greska",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        sacuvajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String fajl = textFieldPutanja.getText();

                    String format = (String) comboBox1.getSelectedItem();

                    if (format.equals("TXT"))
                        blog.sacuvajBlogTXT(fajl);

                    if (format.equals("BINARNI"))
                        blog.serijalizujBlog(fajl);

                    if (format.equals("JSON"))
                        blog.sacuvajBlogJSON(fajl);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,
                            ex.getMessage(),
                            "Greska",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }




    private static void izadji() {
        int opcija = JOptionPane.showConfirmDialog(null,
                "Da li zaista zelite da izadjete iz programa?",
                "Potvrda", JOptionPane.YES_NO_CANCEL_OPTION);

        if (opcija == JOptionPane.YES_OPTION)
            System.exit(0);
    }

    public static void main(String[] args) {
        new BlogGUI().setVisible(true);
    }
}
