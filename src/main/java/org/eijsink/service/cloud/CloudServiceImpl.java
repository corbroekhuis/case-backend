package org.eijsink.service.cloud;

import org.eijsink.model.Ticket;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class CloudServiceImpl implements CloudService {

    public String login( String url, String user, String password) throws IOException {
        // call login, return token
        int a = 8;
        if( a < 0){
            throw new IOException("Unable to logon");
        }

        return UUID.randomUUID().toString();
    }

    public void logout( String url) throws IOException {
        // call logout
        int a = 8;
        if( a < 0){
            throw new IOException("Unable to logout");
        }
        return;
    }

    public String callApi( String url, String token, Ticket bon) throws IOException {
        // Call url and pass token in request
        int a = 8;
        if( a < 0){
            throw new IOException("Api call failed");
        }
        return "Ok";
    }
}
