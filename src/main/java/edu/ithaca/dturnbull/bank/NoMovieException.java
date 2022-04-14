package edu.ithaca.dturnbull.bank;

public class NoMovieException extends Exception{
    private static final long serialVersionUID = 1l;

    public NoMovieException(String s){
        super(s);
    }

    public NoMovieException(){
        super("Error: no movies in library");
    }
}
