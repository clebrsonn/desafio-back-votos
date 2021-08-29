package br.com.hytech.rhsouthsystem.service.session;

import br.com.hytech.rhsouthsystem.model.Session;
import br.com.hytech.rhsouthsystem.resource.v1.dto.EntityRequest;

import java.util.Collection;

public interface ISessionService {
    //Session open(EntityRequest request);

    Collection<Session> findClosedSessions();
}
