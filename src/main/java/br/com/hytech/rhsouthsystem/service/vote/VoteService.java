package br.com.hytech.rhsouthsystem.service.vote;

import br.com.hytech.rhsouthsystem.exceptions.ClosedSessionException;
import br.com.hytech.rhsouthsystem.model.Session;
import br.com.hytech.rhsouthsystem.model.Vote;
import br.com.hytech.rhsouthsystem.repository.VoteRepository;
import br.com.hytech.rhsouthsystem.service.AbstractService;
import br.com.hytech.rhsouthsystem.service.associate.AssociateService;
import br.com.hytech.rhsouthsystem.service.session.SessionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VoteService extends AbstractService<Vote, Long, VoteRepository> {

    private final SessionService sessionService;
    private final AssociateService associateService;


    protected VoteService(VoteRepository repository, SessionService sessionService, AssociateService associateService) {
        super(repository);
        this.sessionService = sessionService;
        this.associateService = associateService;
    }

    @Override
    public Vote validateSave(Vote entity) {
        Session session = sessionService.findById(entity.getSession().getId()).orElseThrow();

        if(session.getClosedTime().isAfter(LocalDateTime.now())){
            throw new ClosedSessionException("Não é possível votar mais, sessão fechada!");
        }
        var associate = associateService.hableToVote(entity.getAssociate().getCpf());
        return new Vote(associate, session, entity.getChoice());

    }
}
