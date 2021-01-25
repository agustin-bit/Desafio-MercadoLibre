package meli.challenge.demo.converter;

import meli.challenge.demo.validator.DnaValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringListConverter implements AttributeConverter<List<String>, String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringListConverter.class.getName());

    private final String DELIMITER = ";";

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {

        LOGGER.info("Start to parsing to database column");

        return attribute != null ? String.join(DELIMITER, attribute) : "";
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {

        LOGGER.info("Start to parsing to dna list");

        return dbData != null ? Arrays.asList(dbData.split(DELIMITER)) : Collections.emptyList();
    }

}
