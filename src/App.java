import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        brynt.add(rbCustomer);
        brynt.add(rbManager);
        brynt.add(rbClerk);
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
                } else if (rbManager.isSelected())
                {
                    if(tfMonths.getText().isBlank() || tfSalary.getText().isBlank())
                        throw new NumberFormatException();
                    if(!Character.isDigit(tfMonths.getText().charAt(0)))
                        tfMonths.setText("");
                        if(!Character.isDigit(tfSalary.getText().charAt(0)))
                            tfSalary.setText("");
                            if(Integer.parseInt(tfSalary.getText()) < 0) {
                        tfSalary.setText("");
                        throw new NumberFormatException();
                    }
                    if(Integer.parseInt(tfAge.getText()) < 0 || Integer.parseInt(tfMonths.getText()) == 0)
                        {
                        tfAge.setText("");
                        throw new NumberFormatException();
                    }
                    if(Integer.parseInt(tfMonths.getText()) < 0)
                    {
                        tfMonths.setText("");
                        throw new NumberFormatException();
                    }
                    Manager m = new Manager(Integer.parseInt(tfAge.getText()),
                    tfName.getText(), Integer.parseInt(tfMonths.getText()),
                    Double.parseDouble(tfSalary.getText()));


                    persons.add(m);
                    taPersons.append(String.valueOf(persons.indexOf(m)+1 + ". Manager - " + m.getName() + " (" + m.getAge() + ")") + "\n");
                } else if (rbClerk.isSelected())
                {
                    if(tfMonths.getText().isBlank() || tfSalary.getText().isBlank())
                        throw new NumberFormatException();
                        if(!Character.isDigit(tfMonths.getText().charAt(0))) tfMonths.setText("");
                            if(!Character.isDigit(tfSalary.getText().charAt(0))) tfSalary.setText("");
                                if(Integer.parseInt(tfSalary.getText()) < 0) {
                        tfSalary.setText("");
                        throw new NumberFormatException();
                    }
                    if(Integer.parseInt(tfAge.getText()) < 0 || Integer.parseInt(tfMonths.getText()) == 0)
                    {
                        tfAge.setText("");
                        throw new NumberFormatException();
                    }
                    if(Integer.parseInt(tfMonths.getText()) < 0)
                        throw new NumberFormatException();

                    Clerk cl = new Clerk(Integer.parseInt(tfAge.getText()),
                    tfName.getText(), Integer.parseInt(tfMonths.getText()),
                    Double.parseDouble(tfSalary.getText()));

                    persons.add(cl);
                    taPersons.append(String.valueOf(persons.indexOf(cl)+1 + ". Clerk - " + cl.getName() + " (" + cl.getAge() + ")") + "\n");
                }
                tfSalary.setText("");
                    tfMonths.setText("");
                        tfAge.setText("");
                            tfName.setText("");


            } catch
                (NumberFormatException n)
            {
                JOptionPane.showMessageDialog
                        (pnlMain, "Invalid Input! Please enter a valid number.");
            } catch (IllegalArgumentException i)
            {
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
        btnLoad.addActionListener(e -> {
            try {
                int num = Integer.parseInt(tfLoad.getText());
                if(num < 1 || num > persons.size())
                {
                    throw new ArrayIndexOutOfBoundsException("Invalid index!");
                }
                int ctr = 0;
                for (Person p : persons)
                {
                    ctr++;
                    if (ctr == num) {
                        tfAge.setText(Integer.toString(p.getAge()));
                        tfName.setText(p.getName());

                        if (p instanceof Employee) {
                            Employee em = (Employee) p;
                            tfMonths.setText(Integer.toString(em.getMonths_worked()));
                            tfSalary.setText(Double.toString(em.getSalary()));
                                if (p instanceof Manager) rbManager.setSelected(true);

                                    if (p instanceof Clerk) rbClerk.setSelected(true);
                        }
                        if (p instanceof Customer) {
                            rbCustomer.setSelected(true);
                        }
                    }
                }
            } catch(NumberFormatException n)
            {
                JOptionPane.showMessageDialog
                        (pnlMain, "Invalid input!");
            } catch(IndexOutOfBoundsException i)
            {
                JOptionPane.showMessageDialog
                        (pnlMain, i.getMessage());
            }
        });
        btnSayHi.addActionListener(e ->
        {
            for (Person p : persons) {
                System.out.println(p);
            }
        });
        rbCustomer.addChangeListener(e ->
        {
            if(rbCustomer.isSelected()) {
                tfMonths.setEnabled(false);
                tfMonths.setEditable(false);
                tfSalary.setEditable(false);
                tfSalary.setEnabled(false);
            }
        });
        rbClerk.addChangeListener(e ->
        {
            if(rbClerk.isSelected()) {
                tfMonths.setEnabled(true);
                tfMonths.setEditable(true);
                tfSalary.setEditable(true);
                tfSalary.setEnabled(true);
            }
        });
        rbManager.addChangeListener(e ->
        {
            if(rbManager.isSelected()) {
                tfMonths.setEnabled(true);
                tfMonths.setEditable(true);
                tfSalary.setEditable(true);
                tfSalary.setEnabled(true);
            }
        });
        btnReward.addActionListener(e ->
        {
            giveReward(Integer.parseInt(tfLoad.getText()));
        });
        btnSavePerson.addActionListener(e ->
        {
            try(BufferedWriter bw = new BufferedWriter(new FileWriter
                    ("C:\\Users\\Dador\\IdeaProjects\\CSIT227Finals-Dador\\src\\persons"))) {
                bw.write("-----Database-----");
                for(Person p : persons) {
                    if(p instanceof Customer) {
                        bw.write("\n" + (persons.indexOf(p) + 1) + ". " + p.getName()
                                + " - Customer" + "\n\tAge: " + p.getAge());
                        } else if(p instanceof Clerk) {
                            bw.write("\n" + (persons.indexOf(p) + 1) + ". " + p.getName() + " - Clerk" + "\n\tAge: " + p.getAge()
                                + "\n\tMonths worked: " + ((Employee) p).getMonths_worked() + "\n\tSalary: " + ((Employee) p).getSalary());
                            }else if(p instanceof Manager) {
                                bw.write("\n" + (persons.indexOf(p) + 1) + ". " + p.getName() + " - Manager" + "\n\tAge: " + p.getAge()
                                    + "\n\tMonths worked: " + ((Employee) p).getMonths_worked() + "\n\tSalary: " + ((Employee) p).getSalary());
                    }
                    bw.newLine();
                }
            } catch (IOException ee) {
                throw new RuntimeException(ee);
            }
        });
        btnLoadPerson.addActionListener(e -> {
            try(BufferedReader br = new BufferedReader
                    (new FileReader("C:\\Users\\Dador\\IdeaProjects\\CSIT227Finals-Dador\\src\\persons"))) {
                String str;
                while((str = br.readLine()) != null) {
                    taPersons.append(str + "\n");
                }
                String str1;
                int pos = 0;
            } catch (IOException ii) {

            }
        });
    }

    public static void main(String[] args) {
        // add here how to make GUI visible
        App app = new App();
        app.setContentPane(app.pnlMain);
        app.setSize(500, 500);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
        app.setTitle("Finals");
    }

    void giveReward(int num) {
        try {
            if(persons.get(num-1) instanceof Employee)
            {
                Employee emp = (Employee) persons.get(num-1);
                if(emp.getMonths_worked() == 0)
                    throw new ArithmeticException("Person is AWOL!!");
                JOptionPane.showMessageDialog
                        (pnlMain, emp.getName() + " will receive " + "Php " + String.format("%.2f", emp.thirteenthmonth())  + ".");
            } else
                throw new IllegalArgumentException("Person is a customer.");
        } catch(NumberFormatException k) {
            JOptionPane.showMessageDialog
                    (pnlMain, "Input invalid!");
        } catch (ArithmeticException | IllegalArgumentException e)
        {
            JOptionPane.showMessageDialog
                    (pnlMain, e.getMessage());
        }
    }
}