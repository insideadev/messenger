package com.epam.ld.module2.testing;

import java.io.IOException;

/**
 * Mail server class.
 */
public interface MailServer {

    /**
     * Send notification.
     *
     * @param addresses  the addresses
     * @param messageContent the message content
     */
    void send(String addresses, String messageContent) throws IOException;
}
