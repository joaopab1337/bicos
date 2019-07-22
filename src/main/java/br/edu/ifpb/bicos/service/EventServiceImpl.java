package br.edu.ifpb.bicos.service;

import br.edu.ifpb.bicos.entity.Event;
import br.edu.ifpb.bicos.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public void save(Event event) {
        eventRepository.save(event);
    }

//    @Override
//    public List<Event> findByName(String eventName) {
//        List<Event> events = new ArrayList<>();
//        for(Event e: eventRepository.findByNameContainingIgnoreCase(eventName)) {
//            events.add(e);
//        }
//        return events;
//    }

    @Override
    public List<Event> findByPromoterUsername(String promoterUsername) {
        List<Event> events = new ArrayList<>();
        for(Event e: eventRepository.findAllByPromoter_UsernameContainingIgnoreCase(promoterUsername)){
            events.add(e);
        }
        return events;
    }
}
