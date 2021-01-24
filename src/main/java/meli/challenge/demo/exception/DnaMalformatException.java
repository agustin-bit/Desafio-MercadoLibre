package meli.challenge.demo.exception;

public class DnaMalformatException extends Exception{

    public DnaMalformatException(){
        super("The dna contains a bad letter to represent a nitrogen base.");
    }

}
