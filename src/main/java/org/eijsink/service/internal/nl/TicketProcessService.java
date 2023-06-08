package org.eijsink.service.internal.nl;

import org.eijsink.exception.EijsinkException;
import org.eijsink.model.Ticket;

public interface TicketProcessService {
    void procesTicket(Ticket ticket) throws EijsinkException;

}
