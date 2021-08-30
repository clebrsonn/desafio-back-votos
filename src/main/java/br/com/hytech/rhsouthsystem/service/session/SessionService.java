package br.com.hytech.rhsouthsystem.service.session;

import br.com.hytech.rhsouthsystem.enums.VoteChoice;
import br.com.hytech.rhsouthsystem.model.Rulling;
import br.com.hytech.rhsouthsystem.model.Session;
import br.com.hytech.rhsouthsystem.model.Vote;
import br.com.hytech.rhsouthsystem.repository.SessionRepository;
import br.com.hytech.rhsouthsystem.resource.v1.dto.SessionResultDTO;
import br.com.hytech.rhsouthsystem.service.AbstractService;
import br.com.hytech.rhsouthsystem.service.rulling.RullingService;
import br.com.hytech.rhsouthsystem.service.vote.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class SessionService extends AbstractService<Session, Long, SessionRepository> {

    private final RullingService rullingService;
    @Autowired
    private VoteService voteService;


    protected SessionService(SessionRepository repository, RullingService rullingService) {
        super(repository);
        this.rullingService = rullingService;
    }

    @Override
    public Session validateSave(Session session) {
        if(!Objects.nonNull(session.getRulling())){
            throw new RuntimeException("Não há seção pauta aberta");
        }

        Rulling rulling = rullingService.findById(session.getRulling().getId()).orElseThrow();
        session.setRulling(rulling);
        session.setDuration(session.getDuration());

        return session;
    }

    public Collection<Session> findClosed() {
        return getRepository().findByClosedTimeBefore(LocalDateTime.now());
    }

    public SessionResultDTO totalVotes(Long id){
        Collection<Vote> votes = voteService.getRepository().findBySessionId(id);
        Map<VoteChoice, Long> voteByChoice = new HashMap<>();
        voteByChoice.put(VoteChoice.SIM, votes.parallelStream().filter(vote -> vote.getChoice().equals(VoteChoice.SIM)).count());
        voteByChoice.put(VoteChoice.NAO, votes.parallelStream().filter(vote -> vote.getChoice().equals(VoteChoice.NAO)).count());
        Long total = voteByChoice.values().parallelStream().mapToLong(Long::longValue).sum();
        return new SessionResultDTO(id, total, voteByChoice);
    }
}
