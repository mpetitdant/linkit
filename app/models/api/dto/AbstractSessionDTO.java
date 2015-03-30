package models.api.dto;

import models.TalkLanguage;
import models.planning.Room;
import org.joda.time.DateTime;

public class AbstractSessionDTO {

    private Long id;
    private String title;
    private String summary;
    private String description;
    private TalkLanguage language;

    private DateTime start;
    private DateTime end;
    private Room room;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TalkLanguage getLanguage() {
        return language;
    }

    public void setLanguage(TalkLanguage language) {
        this.language = language;
    }

    public DateTime getStart() {
        return start;
    }

    public void setStart(DateTime start) {
        this.start = start;
    }

    public DateTime getEnd() {
        return end;
    }

    public void setEnd(DateTime end) {
        this.end = end;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
