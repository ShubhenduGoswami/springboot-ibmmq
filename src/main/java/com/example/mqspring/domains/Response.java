package com.example.mqspring.domains;

/**
 * @author shubhendu
 * @since 02/04/20
 */
public class Response {
    private Boolean response;

    public Response(final Boolean response) {
        this.response = response;
    }

    public Boolean getResponse() {
        return response;
    }

    public void setResponse(final Boolean response) {
        this.response = response;
    }
}
