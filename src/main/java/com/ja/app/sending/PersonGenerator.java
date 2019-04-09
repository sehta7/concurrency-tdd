package com.ja.app.sending;

import io.codearte.jfairy.Fairy;

import java.util.Locale;

/**
 * @author Ola Podorska
 */
class PersonGenerator {

    Fairy fairy = Fairy.create(Locale.forLanguageTag("pl"));

    String getMail(){
        return fairy.person().getEmail();
    }
}
