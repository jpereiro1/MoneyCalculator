package view;

import controller.Controller;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JComboBox;
import model.Currency;
import view.persistance.ExchangeRates;

public class MoneyCalculatorView extends javax.swing.JFrame {
    
    private JComboBox cbCurrency1;
    private JComboBox cbCurrency2;

    public MoneyCalculatorView() {
        initComponents();
    }

    public void execute(){
        setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        amount = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        amountTF = new javax.swing.JTextField();
        from = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        to = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        result = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        resultTF = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        Convert = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 200));
        setPreferredSize(new java.awt.Dimension(500, 200));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 5));

        amount.setLayout(new javax.swing.BoxLayout(amount, javax.swing.BoxLayout.Y_AXIS));

        jLabel1.setText("Amount");
        amount.add(jLabel1);

        amountTF.setText("0");
        amount.add(amountTF);

        jPanel1.add(amount);

        from.setLayout(new javax.swing.BoxLayout(from, javax.swing.BoxLayout.Y_AXIS));

        jLabel2.setText("From:");
        from.add(jLabel2);

        jPanel1.add(from);

        to.setLayout(new javax.swing.BoxLayout(to, javax.swing.BoxLayout.Y_AXIS));

        jLabel3.setText("To:");
        to.add(jLabel3);

        jPanel1.add(to);

        result.setLayout(new javax.swing.BoxLayout(result, javax.swing.BoxLayout.Y_AXIS));

        jLabel4.setText("Result");
        result.add(jLabel4);

        resultTF.setEditable(false);
        resultTF.setMinimumSize(new java.awt.Dimension(40, 20));
        resultTF.setPreferredSize(new java.awt.Dimension(40, 20));
        result.add(resultTF);

        jPanel1.add(result);

        getContentPane().add(jPanel1);

        Convert.setText("Convert");
        Convert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConvertMouseClicked(evt);
            }
        });
        jPanel2.add(Convert);

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConvertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConvertMouseClicked
     
        float rate = ExchangeRates.exchangeRate((String)cbCurrency1.getSelectedItem(),
                (String)cbCurrency2.getSelectedItem());
        float amount = Float.parseFloat(amountTF.getText());
        resultTF.setText(Controller.calculateResult(amount,rate));
        
    }//GEN-LAST:event_ConvertMouseClicked

    public void setAllCurrencies(ArrayList<Currency> currencies) {
        
        
        cbCurrency1 = new JComboBox();
        cbCurrency2 = new JComboBox();
        
        
        Iterator <Currency> it = currencies.iterator();
        while(it.hasNext()){
            Currency currentCurrency = it.next();
            cbCurrency1.addItem(currentCurrency.getCurrencyInitials());
            cbCurrency2.addItem(currentCurrency.getCurrencyInitials());
        }
        
        from.add(cbCurrency1);
        to.add(cbCurrency2);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Convert;
    private javax.swing.JPanel amount;
    private javax.swing.JTextField amountTF;
    private javax.swing.JPanel from;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel result;
    private javax.swing.JTextField resultTF;
    private javax.swing.JPanel to;
    // End of variables declaration//GEN-END:variables
}
