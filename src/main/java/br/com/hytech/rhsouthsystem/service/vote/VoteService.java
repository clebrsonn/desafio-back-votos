package br.com.hytech.rhsouthsystem.service.vote;

import br.com.hytech.rhsouthsystem.model.Session;
import br.com.hytech.rhsouthsystem.model.Vote;
import br.com.hytech.rhsouthsystem.repository.VoteRepository;
import br.com.hytech.rhsouthsystem.service.AbstractService;
import br.com.hytech.rhsouthsystem.service.associate.AssociateService;
import br.com.hytech.rhsouthsystem.service.session.SessionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VoteService extends AbstractService<Vote, Long, VoteRepository> implements IVoteService{

    private final SessionService sessionService;
    private final AssociateService associateService;


    protected VoteService(VoteRepository repository, SessionService sessionService, AssociateService associateService) {
        super(repository);
        this.sessionService = sessionService;
        this.associateService = associateService;
    }

    @Override
    public Vote validateSave(Vote entity) {
        //tem sessão? -> aberta?
        Session session = sessionService.findById(entity.getSession().getId()).orElseThrow();
        assert session.getClosedTime().isAfter(LocalDateTime.now());
        //associado -> já votou? CPF válido?
        var associate = associateService.hableToVote(entity.getAssociate().getCpf());
        return new Vote(associate, session, entity.getChoice());

    }
}
