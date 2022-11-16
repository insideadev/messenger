package com.epam.ld.module2.testing.entity;

import java.io.Serializable;

/**
 * The type Client.
 */
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    private String addresses;
    private String email;
    private String message;

    /**
     * Gets addresses.
     *
     * @return the addresses
     */
    public String getAddresses() {
        return addresses;
    }

    /**
     * Sets addresses.
     *
     * @param addresses the addresses
     */
    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Client{" +
                "addresses='" + addresses + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
