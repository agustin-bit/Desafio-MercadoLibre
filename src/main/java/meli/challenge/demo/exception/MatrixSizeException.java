package meli.challenge.demo.exception;

public class MatrixSizeException extends Exception{

    public MatrixSizeException(){
        super("The size of the matrix are incorrect. Check the length of the columns and rows are equals. [NxN]");
    }

    public MatrixSizeException(String message){
        super(message);
    }

}
