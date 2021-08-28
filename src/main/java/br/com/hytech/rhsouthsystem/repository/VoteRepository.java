package br.com.hytech.rhsouthsystem.repository;

import br.com.hytech.rhsouthsystem.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
