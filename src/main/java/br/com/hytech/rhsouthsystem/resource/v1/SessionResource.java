package br.com.hytech.rhsouthsystem.resource.v1;

import br.com.hytech.rhsouthsystem.model.Session;
import br.com.hytech.rhsouthsystem.service.session.SessionService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionResource extends AbstractController<Session, Long, SessionService> {

    public SessionResource(SessionService service) {
        super(service);
    }
}
