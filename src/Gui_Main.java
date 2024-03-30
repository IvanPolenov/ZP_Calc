import javax.swing.*;
import java.awt.*;

class Gui_main extends JFrame {
    private JTextField input0 = new JTextField(10);
    private JTextField input1 = new JTextField(10);
    private JTextField input2 = new JTextField(10);
    private JRadioButton radioButton1 = new JRadioButton("Посуточная Оплата");
    private JRadioButton radioButton2 = new JRadioButton("Почасовая оплата");
    private JCheckBox checkBox = new JCheckBox("С учетом налогов?");
    private JButton button = new JButton("Рассчитать");

    public Gui_main() {
        System.out.println("Расчетный лист");
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
    }
}
