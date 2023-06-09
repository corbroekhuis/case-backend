package org.eijsink.service.ics;

import org.eijsink.exception.EijsinkException;

import java.io.IOException;

public interface CardService {
    boolean checkCard( String cardNumber, double amount) throws EijsinkException;
}
