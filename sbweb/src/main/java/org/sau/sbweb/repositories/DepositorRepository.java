package org.sau.sbweb.repositories;

import org.sau.sbweb.models.Depositor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositorRepository extends JpaRepository<Depositor, Long> {
}