package org.eijsink.service.bank;

import org.eijsink.model.MainOrder;
import org.eijsink.model.Ticket;

import java.io.IOException;

public interface BankService {
    void tranferToEijsink(double totalPrices, Ticket ticket) throws IOException;
}
