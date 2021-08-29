package br.com.hytech.rhsouthsystem.resource.v1;

import br.com.hytech.rhsouthsystem.model.Session;
import br.com.hytech.rhsouthsystem.service.session.SessionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/session")
public class SessionResource extends AbstractController<Session, Long, SessionService> {

    public SessionResource(SessionService service) {
        super(service);
    }
}
