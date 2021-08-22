package Week3.Day2.model.content;

public class VideoContent extends Content{

    public VideoContent(String name, long publishDate, long endDate, double succesRatio) {
        super(name, publishDate, endDate, succesRatio);
    }

    @Override
    void calculateSucces() {

    }
}
