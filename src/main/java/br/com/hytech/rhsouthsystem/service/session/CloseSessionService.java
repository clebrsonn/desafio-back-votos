package br.com.hytech.rhsouthsystem.service.session;

import br.com.hytech.rhsouthsystem.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloseSessionService {

    @Autowired
    private SessionService sessionService;

    public void closeSession(){
        var sessions = sessionService.findClosed();
        sessions.forEach(session -> session.setClosed(true));
        sessionService.saveAll((List<Session>) sessions);
    }
}
