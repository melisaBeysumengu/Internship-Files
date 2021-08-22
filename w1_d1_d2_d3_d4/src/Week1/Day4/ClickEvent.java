package Week1.Day4;

import java.util.EventObject;

public class ClickEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ClickEvent(Object source) {
        super(source);
    }

}
