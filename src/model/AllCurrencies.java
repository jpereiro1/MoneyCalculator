package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AllCurrencies {
    
    private final ArrayList<Currency> allCurrencies;

    public AllCurrencies() {
        allCurrencies = new ArrayList<Currency>();
    }
    
    public void loadAllCurrencies(){
        
        
        try{
            File file = new File("currencies.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            String line;
            while((line=br.readLine())!=null){
                String[] parts = line.split(",");
                Currency currency = new Currency(parts[0],parts[1],parts[2]);
                allCurrencies.add(currency);
            }
                    
            
        }catch(IOException e){
            System.out.println(e);
        }
            

    }

    public ArrayList<Currency> getAllCurrencies() {
        return allCurrencies;
    }
    
    
       
    
}
