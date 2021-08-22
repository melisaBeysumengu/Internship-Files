package Week1.Day4;

import java.util.ArrayList;
import java.util.List;

public class Button {
    List<MouseListener> mouseListeners;

    public Button() {
        this.mouseListeners = new ArrayList<MouseListener>();
    }

    void addMouseClickListener(MouseListener ml){
        mouseListeners.add(ml);
    }

    void removeMouseClickListener(MouseListener ml){
        mouseListeners.remove(ml);
    }

    void click(){
        for (int i = 0; i < mouseListeners.size(); i++) {
            mouseListeners.get(i).mouseClicked(new ClickEvent(this));
        }
    }
}
