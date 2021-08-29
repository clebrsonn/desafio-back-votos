package br.com.hytech.rhsouthsystem.service.vote;

import br.com.hytech.rhsouthsystem.model.Session;
import br.com.hytech.rhsouthsystem.model.Vote;
import br.com.hytech.rhsouthsystem.repository.VoteRepository;
import br.com.hytech.rhsouthsystem.resource.v1.dto.VoteDTO;
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
    public Vote vote(VoteDTO entity) {

        //tem sessão? -> aberta?
        Session session = sessionService.findById(entity.getSession()).orElseThrow();
        assert session.getClosedTime().isAfter(LocalDateTime.now());
       // associateService.validate()

        //associado -> já votou? CPF válido?

        Vote vote = new Vote();
        return save(vote);
    }
}
