package thumbtack;

import java.util.*;

class Event {
    private static final int DEFAULT_DURATION = 10;
    private static int nextId = 0;
    int id;
    int start;
    int end;
    String content;

    public Event(int start, String content) {
        this.id = nextId;
        nextId++;
        this.start = start;
        this.end = start + DEFAULT_DURATION;
        this.content = content;
    }

    public Event(int start, int end, String content) {
        this.id = nextId;
        nextId++;
        this.start = start;
        this.end = end;
        this.content = content;
    }

    public String formatEvent() {
        return "[" + this.start + "," + this.end + "] : " + this.content;
    }
}


public class Calendar {

    private final Map<Integer, Event> map;

    public Calendar() {
        map = new HashMap<>();
    }

    public void addEvent(int start, int end, String content) {
        Event e = new Event(start, end, content);
        addEvent(e);
    }

    public void updateEvent(int id, Event e) {
        if (e == null) {
            removeEvent(id);
            return;
        }
        map.put(e.id, e);
    }

    public Event removeEvent(int id) {
        return map.remove(id);
    }

    public String getEvents() {
        List<Event> events = new ArrayList<>(map.values());
        Collections.sort(events, new Comparator<Event>() {
            @Override
            public int compare(Event e1, Event e2) {
                if (e1.start == e2.start) {
                    return e1.end - e2.end;
                } else {
                    return e1.start - e2.start;
                }
            }
        });
        return getFormattedEvents(events);
    }

    private void addEvent(Event e) {
        if (e == null) {
            return;
        }
        map.put(e.id, e);
    }

    private String getFormattedEvents(List<Event> events) {
        StringBuilder sb = new StringBuilder();
        for (Event e: events) {
            sb.append(e.formatEvent());
        }
        return sb.toString();
    }


}
