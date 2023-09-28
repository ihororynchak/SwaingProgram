import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {

    private JTextField name_field, email_field;

    private JRadioButton male, female;

    private JCheckBox checkBox;
    public ContactForm(){
        super("Контактна форма");//Встановлюю назву прогрмами
        super.setBounds(200, 200, 350, 180);//Розміри віконця програми
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Під час виключання вікна буде завершуватись програма

        Container container = super.getContentPane();//Створюю контейнер
        container.setLayout(new GridLayout(5, 2, 2, 10));//Вводжу дані про кількість рядків і кількість стовпців...

        JLabel name = new JLabel("Введіть ім'я");
        name_field = new JTextField("", 1);

        JLabel email = new JLabel("Введіть email:");
        email_field = new JTextField("", 1);

        //Добавляємо об'єкти в контейнер
        container.add(name);
        container.add(name_field);
        container.add(email);
        container.add(email_field);

        //Додаю кнопки
         male = new JRadioButton("Чоловіча");
         female = new JRadioButton("ЖІноча");

        male.setSelected(true);//По дефолту буде вибраним

        //Створюю групу для того щоб був один вибір а не два
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        container.add(male);
        container.add(female);

        //Створив кнопку галочки
         checkBox = new JCheckBox("Погодитись");

        container.add(checkBox);

        //Скорочений варіант
        //container.add(new JCheckBox("Погодитись? "+ true));

        //Створюю звичайну кнопку
        JButton btn = new JButton("Відправити");
        container.add(btn);

        //Обробка кнопки
        btn.addActionListener(new ButtonEventManager());//створили власний клас


    }
    //Створюємо вкладений клас
    class ButtonEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
        String name = name_field.getText();
        String email = email_field.getText();

        String isMale = "Чоловіча";

        if(!male.isSelected())
            isMale = "Жіноча";

        boolean isChek = checkBox.isSelected();

        JOptionPane.showMessageDialog(null, "","Привіт "+name,JOptionPane.PLAIN_MESSAGE);
        }
    }
}
