/*
* Transaction Portal Using Swing JFrame and MySQL Database
* Created By Aditya on 25/11/2020
* Github - https://github.com/adityaxp/TransactionPortal.git
* */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TransactionPortal{


   public void createAccount(String name,int pin, float balance){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
            System.out.println("Database connected.");
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO accounts (Name, Pin, Balance) VALUES('"+name+"',"+pin+","+balance+")");
            System.out.println("Account Created.");
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public float withdrawAmount(int pin, float balance){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
            System.out.println("Database connected.");
            Statement statement = connection.createStatement();
            statement.execute("UPDATE accounts SET Balance = Balance - "+balance+" WHERE Pin = "+pin+"");
            System.out.println("Amount Deposited.");
            ResultSet resultSet = statement.executeQuery("select * from accounts where Pin = "+pin+"");
            resultSet.next();
            float retrievedBalance = resultSet.getFloat(3);
            connection.close();
            return  retrievedBalance;
        }catch (Exception e){
            e.printStackTrace();
            return 0.0F;
        }
    }


    public float depositAmount(int pin, float balance){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
            System.out.println("Database connected.");
            Statement statement = connection.createStatement();
            statement.execute("UPDATE accounts SET Balance = Balance + "+balance+" WHERE Pin = "+pin+"");
            System.out.println("Amount Deposited.");
            ResultSet resultSet = statement.executeQuery("select * from accounts where Pin = "+pin+"");
            resultSet.next();
            float retrievedBalance = resultSet.getFloat(3);
            connection.close();
            return  retrievedBalance;
        }catch (Exception e){
            e.printStackTrace();
            return 0.0F;
        }
    }


     public TransactionPortal(){
         JFrame jFrame = new JFrame();
         jFrame.setLayout(null);

         Container container = jFrame.getContentPane();

         int horizontalConstraint = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
         int verticalConstraint = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;

         JButton jButtonLogin = new JButton("Login");
         JButton jButtonCreateAccount = new JButton("Create Account");
         JButton jButtonShowAllAccountInfo = new JButton("Show Info of All Accounts");

         jButtonLogin.setBounds(600, 200, 150, 30);
         jButtonCreateAccount.setBounds(600, 490,150,35);
         jButtonShowAllAccountInfo.setBounds(360, 10, 200,30);

         JLabel jLabelLogin = new JLabel("Admin Login");
         JLabel jLabelTransaction = new JLabel("Transaction System");
         JLabel jLabelCreateAccount = new JLabel("Create an account");
         JLabel jLabelAmount = new JLabel("Enter Amount: ");
         JLabel jLabelPin = new JLabel("Enter Your Pin: ");
         JLabel jLabelUsername = new JLabel("Username: ");
         JLabel jLabelBalance = new JLabel("Enter balance: ");
         JLabel jLabelPassword = new JLabel("Password: ");
         JLabel jLabelName = new JLabel("Enter a name: ");
         JLabel jLabelEnterPin = new JLabel("Enter a pin: ");

         jLabelLogin.setFont(new Font("Calibri", Font.BOLD, 20));
         jLabelUsername.setFont(new Font("Calibri", Font.BOLD, 15));
         jLabelName.setFont(new Font("Calibri", Font.BOLD, 15));
         jLabelPassword.setFont(new Font("Calibri", Font.BOLD, 15));
         jLabelAmount.setFont(new Font("Calibri", Font.BOLD, 15));
         jLabelPin.setFont(new Font("Calibri", Font.BOLD, 15));
         jLabelTransaction.setFont(new Font("Calibri", Font.BOLD, 20));
         jLabelCreateAccount.setFont(new Font("Calibri", Font.BOLD, 20));
         jLabelEnterPin.setFont(new Font("Calibri", Font.BOLD, 15));
         jLabelBalance.setFont(new Font("Calibri", Font.BOLD, 15));

         jLabelLogin.setBounds(600, 10, 150, 30);
         jLabelUsername.setBounds(600, 50, 150, 30);
         jLabelPassword.setBounds(600, 120, 150, 30);
         jLabelTransaction.setBounds(100, 10, 200,30);
         jLabelAmount.setBounds(80, 65, 200,30);
         jLabelPin.setBounds(80, 100, 200,30);
         jLabelCreateAccount.setBounds(600, 250, 180, 30);
         jLabelName.setBounds(600, 280, 150, 30);
         jLabelEnterPin.setBounds(600, 350, 150, 30);
         jLabelBalance.setBounds(600, 420, 150, 30);

         JTextField jTextFieldUsername = new JTextField();
         JTextField jTextFieldPin = new JTextField();
         SpinnerModel spinnerModel = new SpinnerNumberModel(50,50, 1000000000 , 50);
         JSpinner jSpinnerAmount = new JSpinner(spinnerModel);
         JTextField jTextFieldName = new JTextField();
         JTextField jTextFieldBalance = new JTextField();
         JTextField jTextFieldEnterPin = new JTextField();
         JTextField jPasswordField = new JTextField();

         jTextFieldUsername.setBounds(600, 80, 150, 25);
         jPasswordField.setBounds(600, 150, 150, 25);
         jTextFieldName.setBounds(600, 310, 150, 25);
         jSpinnerAmount.setBounds(180, 65, 100,30);
         jTextFieldPin.setBounds(180, 100, 100,30);
         jTextFieldEnterPin.setBounds(600, 380, 150, 25);
         jTextFieldBalance.setBounds(600, 450, 150, 25);

         JButton jButtonOne = new JButton("1");
         JButton jButtonTwo = new JButton("2");
         JButton jButtonThree = new JButton("3");
         JButton jButtonFour = new JButton("4");
         JButton jButtonFive = new JButton("5");
         JButton jButtonSix = new JButton("6");
         JButton jButtonSeven = new JButton("7");
         JButton jButtonEight = new JButton("8");
         JButton jButtonNine = new JButton("9");
         JButton jButtonZero = new JButton("0");

         jButtonOne.setBounds(70, 150, 45, 35);
         jButtonTwo.setBounds(140, 150, 45, 35);
         jButtonThree.setBounds(210, 150, 45, 35);
         jButtonFour.setBounds(280, 150, 45, 35);

         jButtonFive.setBounds(70, 200, 45, 35);
         jButtonSix.setBounds(140, 200, 45, 35);
         jButtonSeven.setBounds(210, 200, 45, 35);
         jButtonEight.setBounds(280, 200, 45, 35);

         jButtonNine.setBounds(140, 250, 45, 35);
         jButtonZero.setBounds(210, 250, 45, 35);


         JButton jButtonClear = new JButton("clear");
         JButton jButtonWithdraw = new JButton("Withdraw");
         JButton jButtonDeposit = new JButton("Deposit");

         jButtonClear.setBounds(140, 300, 115, 30);
         jButtonWithdraw.setBounds(70, 350, 120, 30);
         jButtonDeposit.setBounds(210, 350, 120, 30);

         DefaultTableModel defaultTableModel = new DefaultTableModel();

         defaultTableModel.addColumn("Name");
         defaultTableModel.addColumn("Pin");
         defaultTableModel.addColumn("Balance");

//         for(int i = 0; i <= 100; i++){
//             defaultTableModel.addRow(new Object[]{"Aditya", 1234, 2131231321});
//         }


         JTable jTable = new JTable(defaultTableModel);
         JScrollPane jScrollPane = new JScrollPane(jTable, verticalConstraint, horizontalConstraint);
         jScrollPane.setBounds(360, 50, 200,350);
         jScrollPane.setVisible(false);

         JLabel jLabelImage = new JLabel(new ImageIcon("C:\\Users\\Aditya\\Desktop\\aesthetic.jpg"));
         jLabelImage.setBounds(10, 400, 200, 150);


         jLabelCreateAccount.setVisible(false);
         jLabelName.setVisible(false);
         jTextFieldName.setVisible(false);
         jLabelEnterPin.setVisible(false);
         jTextFieldEnterPin.setVisible(false);
         jLabelBalance.setVisible(false);
         jTextFieldBalance.setVisible(false);
         jButtonCreateAccount.setVisible(false);
         jButtonShowAllAccountInfo.setVisible(false);

         jLabelAmount.setForeground(Color.WHITE);
         jLabelAmount.setForeground(Color.WHITE);
         jLabelBalance.setForeground(Color.WHITE);
         jLabelCreateAccount.setForeground(Color.WHITE);
         jLabelLogin.setForeground(Color.WHITE);
         jLabelTransaction.setForeground(Color.WHITE);
         jLabelPin.setForeground(Color.WHITE);
         jLabelUsername.setForeground(Color.WHITE);
         jLabelPassword.setForeground(Color.WHITE);
         jLabelName.setForeground(Color.WHITE);
         jLabelEnterPin.setForeground(Color.WHITE);

         jFrame.setContentPane(jLabelImage);
         jFrame.add(jLabelLogin);
         jFrame.add(jScrollPane);
         jFrame.add(jLabelUsername);
         jFrame.add(jTextFieldEnterPin);
         jFrame.add(jLabelAmount);
         jFrame.add(jButtonClear);
         jFrame.add(jLabelName);
         jFrame.add(jLabelEnterPin);
         jFrame.add(jTextFieldName);
         jFrame.add(jLabelPin);
         jFrame.add(jButtonDeposit);
         jFrame.add(jButtonWithdraw);
         jFrame.add(jButtonNine);
         jFrame.add(jLabelCreateAccount);
         jFrame.add(jButtonZero);
         jFrame.add(jButtonEight);
         jFrame.add(jButtonSeven);
         jFrame.add(jButtonSix);
         jFrame.add(jButtonFive);
         jFrame.add(jButtonFour);
         jFrame.add(jButtonThree);
         jFrame.add(jButtonTwo);
         jFrame.add(jButtonOne);
         jFrame.add(jTextFieldPin);
         jFrame.add(jSpinnerAmount);
         jFrame.add(jButtonShowAllAccountInfo);
         jFrame.add(jLabelBalance);
         jFrame.add(jTextFieldBalance);
         jFrame.add(jLabelTransaction);
         jFrame.add(jPasswordField);
         jFrame.add(jButtonCreateAccount);
         jFrame.add(jLabelPassword);
         jFrame.add(jTextFieldUsername);
         jFrame.add(jButtonLogin);

         jButtonLogin.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 if(jTextFieldUsername.getText().toString().equals("aditya") && jPasswordField.getText().toString().equals("aditya12")){
                     JOptionPane.showMessageDialog(jFrame ,"Login Successful!");
                     jLabelCreateAccount.setVisible(true);
                     jLabelName.setVisible(true);
                     jTextFieldName.setVisible(true);
                     jLabelEnterPin.setVisible(true);
                     jTextFieldEnterPin.setVisible(true);
                     jLabelBalance.setVisible(true);
                     jTextFieldBalance.setVisible(true);
                     jButtonCreateAccount.setVisible(true);
                     jButtonShowAllAccountInfo.setVisible(true);

                 }else {
                     JOptionPane.showMessageDialog(jFrame ,"Login Unsuccessful!","Authentication", JOptionPane.ERROR_MESSAGE);
                 }
             }
         });

         jButtonOne.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 jTextFieldPin.setText(jTextFieldPin.getText() + 1);
             }
         });

         jButtonTwo.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 jTextFieldPin.setText(jTextFieldPin.getText() + 2);
             }
         });

         jButtonThree.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 jTextFieldPin.setText(jTextFieldPin.getText() + 3);
             }
         });

         jButtonFour.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 jTextFieldPin.setText(jTextFieldPin.getText() + 4);
             }
         });

         jButtonFive.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 jTextFieldPin.setText(jTextFieldPin.getText() + 5);
             }
         });

         jButtonSix.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 jTextFieldPin.setText(jTextFieldPin.getText() + 6);
             }
         });

         jButtonSeven.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 jTextFieldPin.setText(jTextFieldPin.getText() + 7);
             }
         });

         jButtonEight.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 jTextFieldPin.setText(jTextFieldPin.getText() + 8);
             }
         });

         jButtonNine.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 jTextFieldPin.setText(jTextFieldPin.getText() + 9);
             }
         });

         jButtonZero.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 jTextFieldPin.setText(jTextFieldPin.getText() + 0);
             }
         });

         jButtonClear.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 jTextFieldPin.setText("");
             }
         });

         jButtonShowAllAccountInfo.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 jScrollPane.setVisible(true);
                 defaultTableModel.setRowCount(0);
                 try {
                     Class.forName("com.mysql.jdbc.Driver");
                     Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
                     System.out.println("Database connected.");
                     Statement statement = connection.createStatement();
                     ResultSet resultSet = statement.executeQuery("select * from accounts");
                     while (resultSet.next()) {
                         defaultTableModel.addRow(new Object[]{resultSet.getString(1), resultSet.getInt(2), resultSet.getFloat(3)});
                     }
                     connection.close();
                 }catch (Exception exception){
                     exception.printStackTrace();
                 }
             }
         });

         jButtonCreateAccount.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 if(jTextFieldName.getText().toString().equals("") || jTextFieldEnterPin.getText().toString().equals("") || jTextFieldBalance.getText().toString().equals("")){
                     JOptionPane.showMessageDialog(jFrame ,"Fields can't be empty!","Transaction Portal", JOptionPane.ERROR_MESSAGE);
                 }else {
                     createAccount(jTextFieldName.getText().toString(), Integer.parseInt(jTextFieldEnterPin.getText().toString()), Float.parseFloat(jTextFieldBalance.getText().toString()));
                     JOptionPane.showMessageDialog(jFrame ,"Account created!");
                 }
             }
         });

         jButtonDeposit.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 if(jTextFieldPin.getText().toString().equals("")){
                     JOptionPane.showMessageDialog(jFrame ,"Please enter your pin!","Transaction Portal", JOptionPane.ERROR_MESSAGE);
                 }else{
                   float balance = depositAmount(Integer.parseInt(jTextFieldPin.getText().toString()), Float.parseFloat(jSpinnerAmount.getValue().toString()));
                     if(balance > 0.0) {
                         JOptionPane.showMessageDialog(jFrame, "Amount successfully deposited.\n You're account balance is: " + balance);
                     }else {
                         JOptionPane.showMessageDialog(jFrame ,"Sorry you have entered a wrong pin please try again :)","Transaction Portal", JOptionPane.ERROR_MESSAGE);
                     }
                 }
             }
         });

         jButtonWithdraw.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 if(jTextFieldPin.getText().toString().equals("")){
                     JOptionPane.showMessageDialog(jFrame ,"Please enter your pin!","Transaction Portal", JOptionPane.ERROR_MESSAGE);
                 }else{
                     float balance = withdrawAmount(Integer.parseInt(jTextFieldPin.getText().toString()), Float.parseFloat(jSpinnerAmount.getValue().toString()));
                     if(balance > 0.0) {
                         JOptionPane.showMessageDialog(jFrame, "Amount successfully withdrawn.\n You're account balance is: " + balance);
                     }else {
                         JOptionPane.showMessageDialog(jFrame ,"Sorry you have entered a wrong pin please try again :)","Transaction Portal", JOptionPane.ERROR_MESSAGE);
                     }
                 }
             }
         });

         jFrame.setSize(800, 600);
         jFrame.setTitle("Transaction Portal - Coded By Aditya");
         jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         jFrame.setVisible(true);

     }


    public static void main(String[] args) {
        new TransactionPortal();
    }


}
