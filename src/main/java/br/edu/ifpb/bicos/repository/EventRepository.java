package br.edu.ifpb.bicos.repository;

import br.edu.ifpb.bicos.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByNameContainingIgnoreCase(String name);
    List<Event> findAllByPromoter_UsernameContainingIgnoreCase(String promoterName);
}
