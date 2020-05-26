package model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Component
@Scope("singleton")
@Entity
public class Model {
    private int id;
    private String name;
    private Integer userId;
    private Integer datasetId;
    private String method;
    private String path;
    private Timestamp madeTime;
    private double accuracy;
    private double precisiona;
    private double recall;
    private double f1Score;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 55)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "user_id", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "dataset_id", nullable = true)
    public Integer getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(Integer datasetId) {
        this.datasetId = datasetId;
    }

    @Basic
    @Column(name = "method", nullable = true, length = 55)
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Basic
    @Column(name = "path", nullable = false, length = 100)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Basic
    @Column(name = "made_time", nullable = false)
    public Timestamp getMadeTime() {
        return madeTime;
    }

    public void setMadeTime(Timestamp madeTime) {
        this.madeTime = madeTime;
    }

    @Basic
    @Column(name = "accuracy", nullable = false, precision = 0)
    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    @Basic
    @Column(name = "precisiona", nullable = false, precision = 0)
    public double getPrecisiona() {
        return precisiona;
    }

    public void setPrecisiona(double precisiona) {
        this.precisiona = precisiona;
    }

    @Basic
    @Column(name = "recall", nullable = false, precision = 0)
    public double getRecall() {
        return recall;
    }

    public void setRecall(double recall) {
        this.recall = recall;
    }

    @Basic
    @Column(name = "f1_score", nullable = false, precision = 0)
    public double getF1Score() {
        return f1Score;
    }

    public void setF1Score(double f1Score) {
        this.f1Score = f1Score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model model = (Model) o;

        if (id != model.id) return false;
        if (Double.compare(model.accuracy, accuracy) != 0) return false;
        if (Double.compare(model.precisiona, precisiona) != 0) return false;
        if (Double.compare(model.recall, recall) != 0) return false;
        if (Double.compare(model.f1Score, f1Score) != 0) return false;
        if (name != null ? !name.equals(model.name) : model.name != null) return false;
        if (userId != null ? !userId.equals(model.userId) : model.userId != null) return false;
        if (datasetId != null ? !datasetId.equals(model.datasetId) : model.datasetId != null) return false;
        if (method != null ? !method.equals(model.method) : model.method != null) return false;
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
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (datasetId != null ? datasetId.hashCode() : 0);
        result = 31 * result + (method != null ? method.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (madeTime != null ? madeTime.hashCode() : 0);
        temp = Double.doubleToLongBits(accuracy);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(precisiona);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(recall);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(f1Score);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
