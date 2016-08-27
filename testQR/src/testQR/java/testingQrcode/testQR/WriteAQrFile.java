package testingQrcode.testQR;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

public class WriteAQrFile {
    private static JTextField textField;

    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(400, 400));

        // ImageIcon icon = new ImageIcon("androidBook.jpg");
        final JPanel panel = new JPanel() {
        };
        frame.setBounds(new Rectangle(100, 100, 600, 600));
        ;

        frame.getContentPane().add(panel);
        panel.setLayout(null);

        textField = new JTextField();
        textField.setBounds(10, 5, 364, 20);
        panel.add(textField);
        textField.setColumns(10);

        JButton generateButton = new JButton("Generate");
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                BufferedImage image = null;
                try {
                    image = ImageIO.read(QRCode.from("Nikolai Kosevaaaaaaaaaaaaaaaaaaaaaaa").to(ImageType.PNG).file());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                panel.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters

            }
        });
        generateButton.setActionCommand("");
        generateButton.setBounds(146, 25, 89, 20);
        panel.add(generateButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}