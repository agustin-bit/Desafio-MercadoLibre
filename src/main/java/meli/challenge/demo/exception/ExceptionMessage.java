package meli.challenge.demo.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionMessage {

    private String message;
    @JsonProperty("status_code")
    private int status;
    private String uri;

}
