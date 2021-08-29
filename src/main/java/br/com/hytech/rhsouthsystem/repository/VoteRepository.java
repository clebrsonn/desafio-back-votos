package br.com.hytech.rhsouthsystem.repository;

import br.com.hytech.rhsouthsystem.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    Collection<Vote> findBySessionId(Long id);
}
