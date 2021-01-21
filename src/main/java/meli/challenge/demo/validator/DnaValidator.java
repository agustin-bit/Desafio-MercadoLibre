package meli.challenge.demo.validator;

import meli.challenge.demo.exception.DnaMalformatException;
import meli.challenge.demo.exception.MatrixSizeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DnaValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(DnaValidator.class.getName());
    private static DnaValidator instance;

    private DnaValidator(){

    }

    public void checkMatrix(String [] dna) throws DnaMalformatException, MatrixSizeException {
        LOGGER.info("Start matrix checking");
        int rowsLength = dna.length;
        for (String row: dna) {
            checkDnaComposition(row);
            checkRowWithMatrix(row.length(), rowsLength);
        }
    }

    private void checkRowWithMatrix(int colLength, int rowsLength) throws MatrixSizeException {
        if(colLength != rowsLength){
            LOGGER.info("The size of the matrix are incorrect. Check the length of the columns and rows are equals. [NxN]");
            throw new MatrixSizeException();
        }
    }

    private void checkDnaComposition(String row) throws DnaMalformatException {
        if(!row.matches("^[ATCG]+$")){
            LOGGER.info("The dna contains a bad letter to represent a nitrogen base.");
            throw new DnaMalformatException();
        }
    }

    public static DnaValidator getInstance() {
        LOGGER.info("Getting a DnaValidator instance.");
        if(instance == null){
            instance = new DnaValidator();
        }
        return instance;
    }

}
