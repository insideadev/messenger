package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TemplateEngineTest {

    TemplateEngine templateEngine;

    @BeforeEach
    void setUp(){
        templateEngine = new TemplateEngine();
    }

    @Test
    void sendHelloMessageShouldReturnHelloMessage() {
        Client client = new Client();
        String address = "Hanoi";
        client.setMessage("#{address}:" + address);
        String msg = templateEngine.generateMessage(client);
        assertEquals("Hello from " + address, msg);
    }

    @Test
    void sendEmailMessageShouldReturnEmailMessage() {
        Client client = new Client();
        String email = "kenny@epam.com";
        client.setMessage("#{email}:" + email);
        String msg = templateEngine.generateMessage(client);
        assertEquals("Please send me an email to " + email, msg);
    }

    @Test
    void sendMessageMissingMsgShouldThrowNullPointerException() {
        Client client = new Client();
        assertThrows(NullPointerException.class, () -> templateEngine.generateMessage(client));
    }

    @Test
    void sendMessageMissingValueShouldThrowIllegalArgumentException() {
        Client client = new Client();
        client.setMessage("#{address}:   ");
        assertThrows(IllegalArgumentException.class, () -> templateEngine.generateMessage(client));
    }

    @Test
    void sendMessageNotFoundFromTemplateShouldReturnNull() {
        Client client = new Client();
        String email = "kenny@epam.com";
        client.setMessage("#{emails}:" + email);
        String msg = templateEngine.generateMessage(client);
        assertNull(msg);
    }

}
