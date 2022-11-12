package com.epam.ld.module2.testing.template;

/**
 * The type Template.
 */
public class Template {
    private static final String ADDRESS_PLACE_HOLDER = "#{address}";
    private static final String EMAIL_PLACE_HOLDER = "#{email}";
    public static final String HELLO_FROM = "Hello from " + ADDRESS_PLACE_HOLDER;
    public static final String SEND_EMAIL = "Please send me an email to " + EMAIL_PLACE_HOLDER;
}
