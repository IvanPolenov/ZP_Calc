import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
    class Gui_main extends JFrame {
        private JTextField input0 = new JTextField(10);
        private JTextField input1 = new JTextField(10);
        private JTextField input2 = new JTextField(10);
        private JRadioButton radioButton1 = new JRadioButton("Посуточная Оплата");
        private JRadioButton radioButton2 = new JRadioButton("Почасовая оплата");
        private JCheckBox checkBox = new JCheckBox("С учетом налогов?");
        private JButton button = new JButton("Рассчитать");

        Gui_main() {

    }
}
