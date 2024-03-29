import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
class ImagePanel extends JPanel {
    private BufferedImage image;

    public ImagePanel() {
        try {
            image = ImageIO.read(new File("BkGr.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
class Gui_main extends JFrame {
    private JTextField input0 = new JTextField(10);
    private JTextField input1 = new JTextField(10);
    private JTextField input2 = new JTextField(10);
    private JRadioButton radioButton1 = new JRadioButton("Посуточная Оплата");
    private JRadioButton radioButton2 = new JRadioButton("Почасовая оплата");
    private JCheckBox checkBox = new JCheckBox("С учетом налогов?");
    private JButton button = new JButton("Рассчитать");

    public Gui_main() {
        super("Расчетный лист");
        this.setBounds(100, 100, 280, 160);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setBackground(Color.PINK); // Изменение цвета на серый
        container.setLayout(new GridLayout(5, 2, 2, 2));
        container.add(new JLabel("Сотрудник:"));
        container.add(input0);
        container.add(new JLabel("Ставка:"));
        container.add(input1);
        container.add(new JLabel("Отработано часов:"));
        container.add(input2);

        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        container.add(radioButton1);
        container.add(radioButton2);
        container.add(checkBox);
        container.add(button);


        button.addActionListener(new ButtonEventListener());
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double stavka = Double.parseDouble(input1.getText());
                double otrabotka = Double.parseDouble(input2.getText());

                if (stavka >= 0 && stavka <= 1000000) {
                    double summ = stavka * otrabotka;
                    double ndfl = checkBox.isSelected() ? summ * 0.13 : 0;
                    double vidacha = summ - ndfl;
                    double strahovoiVznos = summ * 0.3;

// Ограничение на количество выводимых символов после десятичной точки
                    String formattedSum = String.format("%.2f", summ);
                    String formattedNdfl = String.format("%.2f", ndfl);
                    String formattedVidacha = String.format("%.2f", vidacha);
                    String formattedStrahovoiVznos = String.format("%.2f", strahovoiVznos);

                    String message = "";
                    message += "Расчет зарплаты:\n";
                    message += "Сотрудник " + input0.getText() + "\n";
                    message += "Форма труда " + (radioButton1.isSelected() ? "Посуточная Оплата" : "Почасовая оплата") + "\n";
                    message += "С учетом налогов? " + (checkBox.isSelected() ? "Да" : "Нет") + "\n";
                    message += "Зарплата за отработанное время " + formattedSum + "\n";
                    if (checkBox.isSelected()) {
                        message += "НДФЛ " + formattedNdfl + "\n";
                        message += "Удержание страхового взноса " + formattedStrahovoiVznos + "\n";
                    }
                    message += "К выдаче " + formattedVidacha + "\n";
                    JOptionPane.showMessageDialog(null, message, "Вывод", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Введите число от 0 до 100000", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Введите корректное число", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        Gui_main gui = new Gui_main();
        gui.setVisible(true);
    }
}