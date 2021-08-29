package br.com.hytech.rhsouthsystem.repository;

import br.com.hytech.rhsouthsystem.model.Session;
import br.com.hytech.rhsouthsystem.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Collection;

public interface SessionRepository extends JpaRepository<Session, Long> {
    Collection<Session> findByClosedTimeBefore(LocalDateTime now);
}
