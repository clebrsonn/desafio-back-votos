package br.com.hytech.rhsouthsystem.repository;

import br.com.hytech.rhsouthsystem.model.Session;
import br.com.hytech.rhsouthsystem.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
