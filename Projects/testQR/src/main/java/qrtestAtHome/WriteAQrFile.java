package qrtestAtHome;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class WriteAQrFile {

    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(400, 400));

        final JPanel panel = new JPanel();
        frame.setBounds(new Rectangle(100, 100, 600, 600));

        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JTextField textField = new JTextField();
        textField.setBounds(10, 5, 364, 20);
        textField.setText("Nikolai Kosevaaaaaaaaaaaaaaaaaaaaaaa");
        panel.add(textField);
        textField.setColumns(10);

        JButton generateButton = new JButton("Generate");
        generateButton.addActionListener(arg0 -> {
            BufferedImage image;
            try {
                image = ImageIO.read(QRCode.from(textField.getText()).to(ImageType.PNG).file());
                JLabel picLabel = new JLabel(new ImageIcon(image));
                picLabel.setBounds(50, 50, 100, 100);
                if (panel.getComponentCount() > 2) {
                    panel.remove(2);
                }
                panel.add(picLabel);
                panel.repaint();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //panel.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters

        });
        generateButton.setActionCommand("");
        generateButton.setBounds(146, 25, 89, 20);
        panel.add(generateButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}