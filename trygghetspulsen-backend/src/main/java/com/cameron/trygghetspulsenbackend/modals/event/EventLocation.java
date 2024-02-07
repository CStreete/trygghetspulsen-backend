package com.cameron.trygghetspulsenbackend.modals.event;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Embeddable
public class EventLocation {
    private String location_name;
    private String location_gps;
}
