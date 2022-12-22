import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class App extends JFrame{
    private JPanel pnlMain;
    private JRadioButton rbCustomer;
    private JRadioButton rbClerk;
    private JRadioButton rbManager;
    private JTextField tfName;
    private JTextArea taPersons;
    private JButton btnSave;
    private JTextField tfAge;
    private JTextField tfMonths;
    private JTextField tfSalary;
    private JButton btnClear;
    private JTextField tfLoad;
    private JButton btnLoad;
    private JButton btnSayHi;
    private JButton btnSavePerson;
    private JButton btnLoadPerson;
    private JButton btnReward;

    private List<Person> persons;

    public App() {
        persons = new ArrayList<>();
        ButtonGroup brynt = new ButtonGroup();
        brynt.add(rbManager);
        brynt.add(rbClerk);
        brynt.add(rbCustomer);
        // TODO add implementations for all milestones here

        btnSave.addActionListener(e -> {
            try {
                int ctr = 0;
                if(tfName.getText().isBlank() || tfAge.getText().isBlank())
                    throw new NumberFormatException();
                if(!Character.isDigit(tfAge.getText().charAt(0))) tfAge.setText("");

                if (rbCustomer.isSelected()) {
                    Customer c = new Customer(Integer.parseInt(tfAge.getText()), tfName.getText());
                    persons.add(c);
                    taPersons.append(String.valueOf(persons.indexOf(c)+1 + ". Customer - " + c.getName() + " (" + c.getAge() + ")") + "\n");
                } else if (rbManager.isSelected()) {
                    if(tfMonths.getText().isBlank() || tfSalary.getText().isBlank())
                        throw new NumberFormatException();

                            if(!Character.isDigit(tfMonths.getText().charAt(0))) tfMonths.setText("");
                                if(!Character.isDigit(tfSalary.getText().charAt(0))) tfSalary.setText("");
                                    if(Integer.parseInt(tfSalary.getText()) < 0) {
                        tfSalary.setText("");
                        throw new NumberFormatException();
                    }
                    if(Integer.parseInt(tfAge.getText()) < 0 || Integer.parseInt(tfMonths.getText()) == 0) {
                        tfAge.setText("");
                        throw new NumberFormatException();
                    }
                    if(Integer.parseInt(tfMonths.getText()) < 0) {
                        tfMonths.setText("");
                        throw new NumberFormatException();
                    }
                    Manager m = new Manager(Integer.parseInt(tfAge.getText()), tfName.getText(), Integer.parseInt(tfMonths.getText()), Double.parseDouble(tfSalary.getText()));
                    persons.add(m);
                    taPersons.append(String.valueOf(persons.indexOf(m)+1 + ". Manager - " + m.getName() + " (" + m.getAge() + ")") + "\n");
                } else if (rbClerk.isSelected()) {
                    if(tfMonths.getText().isBlank() || tfSalary.getText().isBlank())
                        throw new NumberFormatException();
                        if(!Character.isDigit(tfMonths.getText().charAt(0))) tfMonths.setText("");
                            if(!Character.isDigit(tfSalary.getText().charAt(0))) tfSalary.setText("");
                                if(Integer.parseInt(tfSalary.getText()) < 0) {
                        tfSalary.setText("");
                        throw new NumberFormatException();
                    }

                    if(Integer.parseInt(tfAge.getText()) < 0 || Integer.parseInt(tfMonths.getText()) == 0) {
                        tfAge.setText("");
                        throw new NumberFormatException();
                    }

                    if(Integer.parseInt(tfMonths.getText()) < 0)
                        throw new NumberFormatException();
                    Clerk cl = new Clerk(Integer.parseInt(tfAge.getText()), tfName.getText(), Integer.parseInt(tfMonths.getText()), Double.parseDouble(tfSalary.getText()));
                    persons.add(cl);
                    taPersons.append(String.valueOf(persons.indexOf(cl)+1 + ". Clerk - " + cl.getName() + " (" + cl.getAge() + ")") + "\n");
                }
                tfSalary.setText("");
                tfMonths.setText("");
                tfAge.setText("");
                tfName.setText("");
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog
                        (pnlMain, "Invalid Input! Please enter a valid number.");

            } catch (IllegalArgumentException i) {
                JOptionPane.showMessageDialog
                        (pnlMain, "Invalid input!");
            }
        });
        btnClear.addActionListener(e -> {
            tfSalary.setText("");
            tfMonths.setText("");
            tfAge.setText("");
            tfName.setText("");
        });
    }

    public static void main(String[] args) {
        // add here how to make GUI visible\
        App app = new App();
        app.setContentPane(app.pnlMain);

        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
            app.setVisible(true);
            app.setSize(500,500);
    }

    static void giveReward(int n) {

    }
}
