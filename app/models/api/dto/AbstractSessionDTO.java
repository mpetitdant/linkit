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

    private String start;   // String to avoid default obscure DateTime serialization
    private String end;
    private String room;

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

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
