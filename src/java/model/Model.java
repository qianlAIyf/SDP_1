package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Model {
    private int id;
    private String name;
    private String path;
    private Timestamp madeTime;
    private double accuracy;

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
    @Column(name = "accuracy")
    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model model = (Model) o;

        if (id != model.id) return false;
        if (Double.compare(model.accuracy, accuracy) != 0) return false;
        if (name != null ? !name.equals(model.name) : model.name != null) return false;
        if (path != null ? !path.equals(model.path) : model.path != null) return false;
        if (madeTime != null ? !madeTime.equals(model.madeTime) : model.madeTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (madeTime != null ? madeTime.hashCode() : 0);
        temp = Double.doubleToLongBits(accuracy);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
