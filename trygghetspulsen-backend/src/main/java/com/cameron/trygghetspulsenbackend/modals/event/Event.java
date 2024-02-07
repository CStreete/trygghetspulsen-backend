package com.cameron.trygghetspulsenbackend.modals.event;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue
    private Integer id;
    private String event_name;
    private String event_summary;
    private String event_date;
    private String event_url;
    private String event_type;
    private EventLocation event_location;
}
