package edu.ithaca.dturnbull.bank;

public class NoTransactionHistoryException extends Exception{
    private static final long serialVersionUID = 1l;

    public NoTransactionHistoryException(String s){
        super(s);
    }

    public NoTransactionHistoryException(){
        super("Error: no transaction history available");
    }
}
