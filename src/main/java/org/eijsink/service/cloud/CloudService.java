package org.eijsink.service.cloud;

import org.eijsink.model.Ticket;

import java.io.IOException;

public interface CloudService {
    String login( String url, String user, String password) throws IOException;
    void logout( String url) throws IOException ;
    String callApi( String url, String token, Ticket bon) throws IOException ;
}
