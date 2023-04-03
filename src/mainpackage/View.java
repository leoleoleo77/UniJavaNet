package mainpackage;

import java.util.Date;

public class View {
    private int viewId;
    private String viewFilm;
    private String viewCinema;
    private Date viewStartDate;
    private Date viewEndDate;
    private int viewNum;
    public View() {
        System.out.println("new View!");
    }

    // Getters Setters
    public int getViewId() {
        return viewId;
    }

    public void setViewId(int viewId) {
        this.viewId = viewId;
    }

    public String getViewFilm() {
        return viewFilm;
    }

    public void setViewFilm(String viewFilm) {
        this.viewFilm = viewFilm;
    }

    public String getViewCinema() {
        return viewCinema;
    }

    public void setViewCinema(String viewCinema) {
        this.viewCinema = viewCinema;
    }

    public Date getViewStartDate() {
        return viewStartDate;
    }

    public void setViewStartDate(Date viewStartDate) {
        this.viewStartDate = viewStartDate;
    }

    public Date getViewEndDate() {
        return viewEndDate;
    }

    public void setViewEndDate(Date viewEndDate) {
        this.viewEndDate = viewEndDate;
    }

    public int getViewNum() {
        return viewNum;
    }

    public void setViewNum(int viewNum) {
        this.viewNum = viewNum;
    }
}
