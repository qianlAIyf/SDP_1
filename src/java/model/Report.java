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
@Scope("prototype")
@Entity
public class Report {
    private int id;
    private String name;
    private Integer userId;
    private Integer modelId;
    private Integer datasetId;
    private String path;
    private Timestamp madeTime;
    private int numberTrue;
    private int numberFalse;

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
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "model_id")
    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    @Basic
    @Column(name = "dataset_id")
    public Integer getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(Integer datasetId) {
        this.datasetId = datasetId;
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

    @Basic
    @Column(name = "number_false")
    public int getNumberFalse() {
        return numberFalse;
    }

    public void setNumberFalse(int numberFalse) {
        this.numberFalse = numberFalse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Report report = (Report) o;

        if (id != report.id) return false;
        if (numberTrue != report.numberTrue) return false;
        if (numberFalse != report.numberFalse) return false;
        if (name != null ? !name.equals(report.name) : report.name != null) return false;
        if (userId != null ? !userId.equals(report.userId) : report.userId != null) return false;
        if (modelId != null ? !modelId.equals(report.modelId) : report.modelId != null) return false;
        if (datasetId != null ? !datasetId.equals(report.datasetId) : report.datasetId != null) return false;
        if (path != null ? !path.equals(report.path) : report.path != null) return false;
        if (madeTime != null ? !madeTime.equals(report.madeTime) : report.madeTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (modelId != null ? modelId.hashCode() : 0);
        result = 31 * result + (datasetId != null ? datasetId.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (madeTime != null ? madeTime.hashCode() : 0);
        result = 31 * result + numberTrue;
        result = 31 * result + numberFalse;
        return result;
    }
}
