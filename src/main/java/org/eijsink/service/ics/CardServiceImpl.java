package org.eijsink.service.ics;

import org.eijsink.exception.EijsinkException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CardServiceImpl implements CardService{


    @Override
    public boolean checkCard(String cardNumber, double amount) throws EijsinkException {

        int a = 8;
        if( a < 0){
            throw new EijsinkException("Check failed");
        }

        return false;
    }
}
