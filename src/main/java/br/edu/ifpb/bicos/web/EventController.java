package br.edu.ifpb.bicos.web;

import br.edu.ifpb.bicos.entity.Event;
import br.edu.ifpb.bicos.entity.Job;
import br.edu.ifpb.bicos.entity.User;
import br.edu.ifpb.bicos.service.EventService;
import br.edu.ifpb.bicos.service.SecurityService;
import br.edu.ifpb.bicos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class EventController {

    @Autowired
    private UserService userService;

    @Autowired
    private EventService eventService;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/create")
    public String newEventPage(Model model) {
        Event eventObj = new Event();
        model.addAttribute("eventForm", eventObj);
        return "create";
    }

    @PostMapping("/create")
    public String newEventForm(@ModelAttribute("eventForm") Event eventForm, Model model) {
        // TODO
        // Adicionar notificação ao retornar
        // Adicionar timestamps
        User currentUser = userService.getCurrentUser();
        eventForm.setPromoter(currentUser);
        eventService.save(eventForm);
        model.addAttribute("currentUser", currentUser);
        return "home";
    }

    @GetMapping("/events")
    public String events(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        List<Event> events = eventService.findByPromoterUsername(currentPrincipalName);
        System.out.println(events.size());
        model.addAttribute("events", events);
        return "my-events";
    }

    @GetMapping("/event/{id}")
    public String eventDetails(@PathVariable String id, Model model) {
        Event e = eventService.eventById(Long.parseLong(id));
        model.addAttribute("event", e);
        return "event-details";
    }

    @GetMapping("/event/{id}/jobs")
    public String eventJobs(@PathVariable String id, Model model) {
        Event e = eventService.eventById(Long.parseLong(id));
        model.addAttribute("event", e);
        return "event-jobs";
    }


}
