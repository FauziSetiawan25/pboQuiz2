package quiz2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class HRISGUI extends JFrame {
        private JFrame frame;

        private JComboBox<String> departmentComboBox;
        private JTextField nameField;
        private JTextField birthDateField;
        private JTextField positionField;
        private JButton addEmployeeButton;
        private JButton cancelButton;

        private JTextArea displayArea;
        private JTextField findIdField;

        private JButton addButton;
        private JButton showAllButton;

        public HRISGUI() {
            frame = new JFrame("HRIS");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());
            showMainPanel();
            frame.add(showMainPanel(), BorderLayout.CENTER);
            frame.pack();
            frame.setSize(600, 400);
            frame.setVisible(true);
        }

        private JPanel showMainPanel() {
            addButton = new JButton("Add Data");
            showAllButton = new JButton("Show Data");

            JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
            buttonPanel.add(addButton);
            buttonPanel.add(showAllButton);

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    repaintPanel(showInputPanel());
                }
            });

            showAllButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    repaintPanel(showAllDataPanel());
                }
            });

            return buttonPanel;
        }

        //Complete show all data employee panel
        private JPanel showAllDataPanel() {
            JPanel panel = new JPanel(new BorderLayout());
            JPanel topPanel = new JPanel(new GridLayout(1, 1));

            findIdField = new JTextField(15);
            topPanel.add(findIdField);

            cancelButton = new JButton("Cancel");
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            buttonPanel.add(cancelButton);

            displayArea = new JTextArea(10, 20);
            displayArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(displayArea);

            panel.add(topPanel, BorderLayout.NORTH);
            panel.add(buttonPanel, BorderLayout.CENTER);
            panel.add(scrollPane, BorderLayout.SOUTH);
            return panel;
        }

        // method refresh panel
        private void repaintPanel(JPanel newPanel) {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(newPanel);
            frame.revalidate();
            frame.repaint();
        }

        //Complete show employee input panel
        private JPanel showInputPanel() {
            JPanel inputPanel = new JPanel(new GridLayout(6, 2));

            JLabel nameLabel = new JLabel("Name:");
            nameField = new JTextField(15);

            JLabel birthDateLabel = new JLabel("Birth Date (DDMMYYYY):");
            birthDateField = new JTextField(15);

            JLabel positionLabel = new JLabel("Position:");
            positionField = new JTextField(15);

            JLabel departementLabel = new JLabel("Departement:");
            String[] departments = Employee.getDepartments();
            departmentComboBox = new JComboBox<>(departments);

            addEmployeeButton = new JButton("Add Data");

            inputPanel.add(nameLabel);
            inputPanel.add(nameField);
            inputPanel.add(birthDateLabel);
            inputPanel.add(birthDateField);
            inputPanel.add(positionLabel);
            inputPanel.add(positionField);
            inputPanel.add(departementLabel);
            inputPanel.add(departmentComboBox);
            inputPanel.add(addEmployeeButton);

            //complete add employee logic
            addEmployeeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = nameField.getText();
                    String birthDate = birthDateField.getText();
                    String position = positionField.getText();
                    String department = departmentComboBox.getSelectedItem().toString();

                    Employee employee;
                    if (position.equalsIgnoreCase("Manager")) {
                        employee = new Manager();
                    } else if (position.equalsIgnoreCase("Developer")) {
                        employee = new Developer();
                    } else if (position.equalsIgnoreCase("HR Staff")) {
                        employee = new HRStaff();
                    } else {
                        JOptionPane.showMessageDialog(HRISGUI.this, "Invalid Position!");
                        return;
                    }

                    employee.name = name;
                    employee.birthDate = birthDate;
                    employee.position = position;
                    employee.department = department;
                    employee.employeeID = employee.generateEmployeeID();

                    double salary = employee.calculateSalary();
                    String message = String.format("Employee added:\nName: %s\nBirth Date: %s\nPosition: %s\nDepartment: %s\nEmployee ID: %s\nSalary: %,.2f",
                            employee.name, employee.birthDate, employee.position, employee.department, employee.employeeID, salary);
                    JOptionPane.showMessageDialog(HRISGUI.this, message);
                }
            });

            return inputPanel;
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new HRISGUI();
                }
            });
        }
    }