package Week1.Day4;

public class Form implements MouseListener{
    Button button;

    @Override
    public void mouseClicked(ClickEvent clickEvent) {
        System.out.println("button is clicked!!!");
    }

    public void setButton(Button button) {
        this.button = button;
        button.addMouseClickListener(this);
    }
}
