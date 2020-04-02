package com.example.mqspring.domains;

import javax.validation.constraints.NotNull;

/**
 * @author shubhendu
 * @since 02/04/20
 */
public class Message {
    @NotNull
    private String text;

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }
}
