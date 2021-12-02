package controller;

import java.util.ArrayList;
import model.AllCurrencies;
import model.Currency;
import view.MoneyCalculatorView;

public class Controller {
    
    private final AllCurrencies model;
    private final MoneyCalculatorView view;
    
    public Controller(AllCurrencies model,MoneyCalculatorView view) {
        this.view = view;
        this.model = model;
        
    }

    public void setView() {
        ArrayList<Currency> currencies = model.getAllCurrencies();
        view.setAllCurrencies(currencies);
        view.execute();
    }

    public void setModel() {
        model.loadAllCurrencies();
    }
    
    public static String calculateResult(float amount,float exchangeRate){
        String result = String.valueOf(amount*exchangeRate);
        return result;
    }
    
    
}
