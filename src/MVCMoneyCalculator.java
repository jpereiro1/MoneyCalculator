import controller.Controller;
import model.AllCurrencies;
import view.MoneyCalculatorView;

public class MVCMoneyCalculator {
    
    
    public static void main(String[] args) {
        
        AllCurrencies model = new AllCurrencies();
        
        MoneyCalculatorView view = new MoneyCalculatorView();
        
        Controller controller = new Controller(model,view);
       
        
        controller.setModel();
        controller.setView();
        
    }
}
