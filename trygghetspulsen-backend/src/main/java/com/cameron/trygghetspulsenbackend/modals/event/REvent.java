package com.cameron.trygghetspulsenbackend.modals.event;

public record Event(Integer id, String datetime, String name, String summary, String type, String url, Location location  ) {
}


