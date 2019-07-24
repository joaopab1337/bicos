package br.edu.ifpb.bicos.service;

import br.edu.ifpb.bicos.entity.Event;

import java.util.List;

public interface EventService {
    void save(Event event);
    Event eventById(Long id);
//    List<Event> findByName(String name);
    List<Event> findByPromoterUsername(String promoterName);

}
