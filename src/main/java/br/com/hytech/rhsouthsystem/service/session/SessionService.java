package br.com.hytech.rhsouthsystem.service.session;

import br.com.hytech.rhsouthsystem.model.Session;
import br.com.hytech.rhsouthsystem.repository.SessionRepository;
import br.com.hytech.rhsouthsystem.resource.EntityRequest;
import br.com.hytech.rhsouthsystem.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SessionService extends AbstractService<Session, Long, SessionRepository> implements ISessionService{

    protected SessionService(SessionRepository repository) {
        super(repository);
    }

    @Override
    public Session open(EntityRequest request) {
        return null;
    }

    @Override
    public Collection<Session> findClosedSessions() {
        return null;
    }
}
