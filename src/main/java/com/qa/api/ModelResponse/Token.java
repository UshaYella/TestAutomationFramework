package com.qa.api.ModelResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Token {
    @JsonProperty
    public String token;

    public String getToken() {
        return token;
    }
}
