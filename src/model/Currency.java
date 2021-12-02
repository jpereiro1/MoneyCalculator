package model;


public class Currency {
    private final String currencyInitials;
    private final String currencyName;
    private final String currencySymbol;

    public Currency(String currencyName, String currencyInitials, String currencySymbol) {
        this.currencyInitials = currencyInitials;
        this.currencyName = currencyName;
        this.currencySymbol = currencySymbol;
    }

    public String getCurrencyInitials() {
        return currencyInitials;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

}
