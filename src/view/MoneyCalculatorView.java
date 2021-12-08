package view;

import controller.Controller;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Currency;
import view.persistance.ExchangeRates;


public class MoneyCalculatorView extends javax.swing.JFrame{
    
    private JComboBox cbCurrency1;
    private JComboBox cbCurrency2;
    
    private JPanel panelUp;
    private JPanel panelDown;
    private JPanel panelFrom;
    private JPanel panelTo;
    private JPanel panelAmount;
    private JPanel panelResult;
    
    private JLabel labelAmount;
    private JLabel labelFrom;
    private JLabel labelTo;
    private JLabel labelResult;
    
    private JTextField jTextFieldAmount;
    private JTextField jTextFieldResult;
    
    private JButton buttonConvert;
    
    
    
    public MoneyCalculatorView() {
        initComponents();
        
        this.setTitle("Currency Converter");
    }
    
    public void execute(){
        this.setVisible(true);
    }

    private void initComponents() {
        
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(500, 150));
        setPreferredSize(new Dimension(500, 150));
        setResizable(false);
        
        
        panelUp = new JPanel();
        panelUp.setLayout(new FlowLayout(FlowLayout.CENTER,30, 5));
        panelDown = new JPanel();
        panelDown.setLayout(new FlowLayout());
        panelFrom = new JPanel();
        panelFrom.setLayout(new BoxLayout(panelFrom, BoxLayout.Y_AXIS));
        panelTo = new JPanel();
        panelTo.setLayout(new BoxLayout(panelTo, BoxLayout.Y_AXIS));
        panelAmount = new JPanel();
        panelAmount.setLayout(new BoxLayout(panelAmount, BoxLayout.Y_AXIS));
        panelResult = new JPanel();
        panelResult.setLayout(new BoxLayout(panelResult, BoxLayout.Y_AXIS));
        
        labelAmount = new JLabel("Amount:");
        labelFrom = new JLabel("From:");
        labelTo = new JLabel("To:");
        labelResult = new JLabel("Result:");
        
        jTextFieldAmount = new JTextField("0");
        jTextFieldAmount.setPreferredSize(new Dimension(20,24));
        addFunctionsEscAndEnter(jTextFieldAmount);
        
        jTextFieldResult = new JTextField("0.0");
        jTextFieldResult.setEditable(false);
        jTextFieldResult.setPreferredSize(new Dimension(60,24));
        
        buttonConvert = new JButton("Convert");
        
        buttonConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrencies();
            }
        });
        addFunctionsEscAndEnter(buttonConvert);
        
        panelAmount.add(labelAmount);
        panelAmount.add(jTextFieldAmount);
        
        panelFrom.add(labelFrom);
        
        panelTo.add(labelTo);
        
        panelResult.add(labelResult);
        panelResult.add(jTextFieldResult);
        
        
        panelUp.add(panelAmount);
        panelUp.add(panelFrom);
        panelUp.add(panelTo);
        panelUp.add(panelResult);
        
        panelDown.add(buttonConvert);
        
        getContentPane().add(panelUp);
        getContentPane().add(panelDown);
        
        
        
        pack();
        
        
        
        
    }

    public void setComboBox(ArrayList<Currency> currencies) {
        cbCurrency1 = new JComboBox();
        addFunctionsEscAndEnter(cbCurrency1);
        cbCurrency2 = new JComboBox();
        addFunctionsEscAndEnter(cbCurrency2);
        
        
        Iterator <Currency> it = currencies.iterator();
        while(it.hasNext()){
            Currency currentCurrency = it.next();
            cbCurrency1.addItem(currentCurrency.getCurrencyInitials());
            cbCurrency2.addItem(currentCurrency.getCurrencyInitials());
        }
        
        panelFrom.add(cbCurrency1);
        panelTo.add(cbCurrency2);

    }
    
    private void convertCurrencies(){
        float rate = ExchangeRates.exchangeRate((String)cbCurrency1.getSelectedItem(),
        (String)cbCurrency2.getSelectedItem());
        float amount = Float.parseFloat(jTextFieldAmount.getText());
        jTextFieldResult.setText(Controller.calculateResult(amount,rate));
    }

    private void addFunctionsEscAndEnter(JComponent component) {
        component.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    convertCurrencies();
                }
                if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
                    System.exit(0);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
    }
    
    
    
    
}
