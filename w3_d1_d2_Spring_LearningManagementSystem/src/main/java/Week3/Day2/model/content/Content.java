package Week3.Day2.model.content;

public abstract class Content {
    protected String name;
    protected Long publishDate;
    protected Long endDate;
    protected Double succesRatio;

    public Content(String name, long publishDate, long endDate, double succesRatio) {
        this.name = name;
        this.publishDate = publishDate;
        this.endDate = endDate;
        this.succesRatio = succesRatio;
    }

    abstract void calculateSucces();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(long publishDate) {
        this.publishDate = publishDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public double getSuccesRatio() {
        return succesRatio;
    }

    public void setSuccesRatio(double succesRatio) {
        this.succesRatio = succesRatio;
    }
}
