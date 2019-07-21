package br.edu.ifpb.bicos.service;

import br.edu.ifpb.bicos.entity.Event;

import java.util.List;

public interface EventService {
    void save(Event event);
    List<Event> findByName(String name);
    List<Event> findByPromoterName(String promoterName);

}
