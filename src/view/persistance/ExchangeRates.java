package view.persistance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class ExchangeRates {
    
    
    public static float exchangeRate(String currency1, String currency2){
        float result = 1;
        try{
            URL url = new URL("https://cdn.jsdelivr.net/gh/fawazahmed0/"
                            + "currency-api@1/latest/currencies/"
                            + currency1.toLowerCase() + "/"
                            + currency2.toLowerCase() +".json");
            
            URLConnection con = url.openConnection();
            InputStream is =con.getInputStream();
            
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while((line = br.readLine()) != null){
                if(line.contains(currency2.toLowerCase())){
                    break;
                }
            }
            String[] parts = line.split(" ");
            result = Float.parseFloat(parts[5]);
            

        }catch(IOException e){
            System.out.println("Se ha producido un error: " + e);
        }
        return result;
    }
}
