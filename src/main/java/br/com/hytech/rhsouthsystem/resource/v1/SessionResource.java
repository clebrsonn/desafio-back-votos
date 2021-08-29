package br.com.hytech.rhsouthsystem.resource.v1;

import br.com.hytech.rhsouthsystem.model.Session;
import br.com.hytech.rhsouthsystem.resource.v1.dto.SessionResultDTO;
import br.com.hytech.rhsouthsystem.service.session.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/sessions")
public class SessionResource extends AbstractController<Session, Long, SessionService> {

    public SessionResource(SessionService service) {
        super(service);
    }

    @Override
    protected ResponseEntity<Session> delete(Long aLong) {
        return new ResponseEntity<>(null, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Override
    protected ResponseEntity<Session> update(Long aLong, Session user) {
        return new ResponseEntity<>(null, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @GetMapping("/{id}/votes")
    public ResponseEntity<SessionResultDTO> totalVotes(@PathVariable Long id){
        return ResponseEntity.ok(getService().totalVotes(id));
    }
}
