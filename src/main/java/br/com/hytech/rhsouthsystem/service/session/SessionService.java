package br.com.hytech.rhsouthsystem.service.session;

import br.com.hytech.rhsouthsystem.model.Rulling;
import br.com.hytech.rhsouthsystem.model.Session;
import br.com.hytech.rhsouthsystem.repository.SessionRepository;
import br.com.hytech.rhsouthsystem.service.AbstractService;
import br.com.hytech.rhsouthsystem.service.rulling.RullingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

@Service
public class SessionService extends AbstractService<Session, Long, SessionRepository> implements ISessionService{

    private final RullingService rullingService;


    protected SessionService(SessionRepository repository, RullingService rullingService) {
        super(repository);
        this.rullingService = rullingService;
    }

    @Override
    public Session validateSave(Session session) {
        Rulling rulling = rullingService.findById(session.getRulling().getId()).orElseThrow();
        session.setRulling(rulling);
        session.setOpenTime(LocalDateTime.now());

        var duration = Objects.isNull(session.getDuration()) || session.getDuration() <= 0 ? 1L : session.getDuration();
        session.setDuration(duration);
        session.setClosedTime(session.getOpenTime().plusMinutes(duration));

        return session;
    }

    @Override
    public Collection<Session> findClosedSessions() {
        return null;
    }
}
