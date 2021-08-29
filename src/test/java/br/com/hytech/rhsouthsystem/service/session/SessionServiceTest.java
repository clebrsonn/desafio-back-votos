package br.com.hytech.rhsouthsystem.service.session;

import br.com.hytech.rhsouthsystem.model.Rulling;
import br.com.hytech.rhsouthsystem.model.Session;
import br.com.hytech.rhsouthsystem.service.rulling.RullingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

@SpringBootTest
@ActiveProfiles("test")
class SessionServiceTest {
    @Autowired
    private SessionService sessionService;
    @Autowired
    private RullingService rullingService;

    @Test
    void validateSave() {
        Rulling rulling = new Rulling();
        rulling.setName("pauta 1");
        rulling = rullingService.save(rulling);

        var session = new Session();
        session.setDuration(10L);
        session.setRulling(rulling);

        Session session1 = sessionService.validateSave(session);
        Assertions.assertEquals(session.getDuration(), session1.getDuration());
        Assertions.assertEquals(session.getRulling(), session1.getRulling());

    }

    @Test
    void findClosed() {
        Rulling rulling = new Rulling();
        rulling.setName("pauta 1");
        rulling = rullingService.save(rulling);

        var session = new Session();
        session.setDuration(-1L);
        session.setRulling(rulling);
        LocalDateTime localDateTime = LocalDateTime.now();
        session.setOpenTime(localDateTime);
        Assertions.assertEquals(1L, session.getDuration());
        Assertions.assertEquals(localDateTime.plusMinutes(1), session.getClosedTime());
        sessionService.save(session);
        Assertions.assertEquals(0, sessionService.findClosed().size());
    }

    @Test
    void totalVotes() {
    }
}