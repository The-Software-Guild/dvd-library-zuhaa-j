package dvdlibrary.dto;

import java.time.LocalDate;
import java.util.Objects;

public class DVD {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DVD dvd = (DVD) o;
        return Objects.equals(title, dvd.title) && Objects.equals(releaseDate, dvd.releaseDate) && Objects.equals(MPAARating, dvd.MPAARating) && Objects.equals(directorName, dvd.directorName) && Objects.equals(studio, dvd.studio) && Objects.equals(userNote, dvd.userNote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, releaseDate, MPAARating, directorName, studio, userNote);
    }

    @Override
    public String toString() {
        return "DVD{" +
                "title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", MPAARating='" + MPAARating + '\'' +
                ", directorName='" + directorName + '\'' +
                ", studio='" + studio + '\'' +
                ", userNote='" + userNote + '\'' +
                '}';
    }

    private String title;
    private LocalDate releaseDate;
    private String MPAARating;
    private String directorName;
    private String studio;
    private String userNote;

    public DVD(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMPAARating() {
        return MPAARating;
    }

    public void setMPAARating(String MPAARating) {
        this.MPAARating = MPAARating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }
}
