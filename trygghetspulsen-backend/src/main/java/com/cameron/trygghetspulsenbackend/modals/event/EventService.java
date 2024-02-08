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
    public Event getEventById(Integer id)
    {
        return eventRepository.findById(id).orElse(null);
    }
    public Event updateEvent(Event event)
    {
        Event existingEvent = eventRepository.findById(event.getId()).orElse(null);
        if (existingEvent != null)
        {
            existingEvent.setId(event.getId());
            existingEvent.setEvent_name(event.getEvent_name());
            existingEvent.setEvent_summary(event.getEvent_summary());
            existingEvent.setEvent_type(event.getEvent_type());
            existingEvent.setEvent_date(event.getEvent_date());
            existingEvent.setEvent_url(event.getEvent_url());
            existingEvent.setEvent_location(event.getEvent_location());
            return  eventRepository.save(existingEvent);
        }else {
            return null;
        }
    }

    public void deleteEvent(Integer id)
    {
        eventRepository.deleteById(id);
    }


}
