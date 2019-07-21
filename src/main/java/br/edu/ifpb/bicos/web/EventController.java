package br.edu.ifpb.bicos.web;

import br.edu.ifpb.bicos.entity.Event;
import br.edu.ifpb.bicos.entity.Job;
import br.edu.ifpb.bicos.entity.User;
import br.edu.ifpb.bicos.service.EventService;
import br.edu.ifpb.bicos.service.SecurityService;
import br.edu.ifpb.bicos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class EventController {
    @Autowired
    private EventService eventService;

    @Autowired
    private SecurityService securityService;

    private static final String AJAX_HEADER_NAME = "X-Requested-With";
    private static final String AJAX_HEADER_VALUE = "XMLHttpRequest";

    @GetMapping("/create")
    public String newEventPage(Model model) {
        Event eventObj = new Event();
        List<Job> jobs = eventObj.getJobs();
        jobs.add(new Job());
        eventObj.setJobs(jobs);
        model.addAttribute("eventForm", eventObj);
        return "create";
    }

    @PostMapping(params = "save", path = "/create")
    public String newEventForm(@ModelAttribute("eventForm") Event eventForm) {
        // TODO
        // Adicionar notificação ao retornar
        // Adicionar timestamps
        eventService.save(eventForm);
        return "/";
    }

    @PostMapping(params = "addJob", path = {"/create"})
    public String addJob(Event event, HttpServletRequest request) {
        event.getJobs().add(new Job());
        if (AJAX_HEADER_VALUE.equals(request.getHeader(AJAX_HEADER_NAME))) {
            // It is an Ajax request, render only #items fragment of the page.
            return "create::#jobs";
        } else {
            // It is a standard HTTP request, render whole page.
            return "create";
        }
    }

    @PostMapping(params = "removeJob", path = {"/create", "/create/{id}"})
    public String removeJob(Event event, @RequestParam("removeJob") int index, HttpServletRequest request) {
        event.getJobs().remove(index);
        if (AJAX_HEADER_VALUE.equals(request.getHeader(AJAX_HEADER_NAME))) {
            return "create::#jobs";
        } else {
            return "create";
        }
    }


}
