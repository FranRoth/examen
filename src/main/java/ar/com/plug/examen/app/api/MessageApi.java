package ar.com.plug.examen.app.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "message")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageApi {
	
	//private final static Logger logger = LoggerFactory.getLogger();

    @JsonProperty
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
