package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Report {
    private int id;
    private String name;
    private String path;
    private Timestamp madeTime;
    private int numberTrue;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Basic
    @Column(name = "made_time")
    public Timestamp getMadeTime() {
        return madeTime;
    }

    public void setMadeTime(Timestamp madeTime) {
        this.madeTime = madeTime;
    }

    @Basic
    @Column(name = "number_true")
    public int getNumberTrue() {
        return numberTrue;
    }

    public void setNumberTrue(int numberTrue) {
        this.numberTrue = numberTrue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Report report = (Report) o;

        if (id != report.id) return false;
        if (numberTrue != report.numberTrue) return false;
        if (name != null ? !name.equals(report.name) : report.name != null) return false;
        if (path != null ? !path.equals(report.path) : report.path != null) return false;
        if (madeTime != null ? !madeTime.equals(report.madeTime) : report.madeTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (madeTime != null ? madeTime.hashCode() : 0);
        result = 31 * result + numberTrue;
        return result;
    }
}
