package com.cameron.trygghetspulsenbackend.modals.event;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventService {

    private final IEventRepository eventRepository;

    public Event createEvent(Event event)
    {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents()
    {
        return eventRepository.findAll();
    }

    public Event updateEvent(Event event)
    {
        return eventRepository.save(event);
    }

    public void deleteEvent(Integer id)
    {
        eventRepository.deleteById(id);
    }


}
