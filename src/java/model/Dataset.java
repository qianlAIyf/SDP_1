package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Dataset {
    private int id;
    private String name;
    private byte dataType;
    private String path;
    private Timestamp loadTime;

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
    @Column(name = "data_type")
    public byte getDataType() {
        return dataType;
    }

    public void setDataType(byte dataType) {
        this.dataType = dataType;
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
    @Column(name = "load_time")
    public Timestamp getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(Timestamp loadTime) {
        this.loadTime = loadTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dataset dataset = (Dataset) o;

        if (id != dataset.id) return false;
        if (dataType != dataset.dataType) return false;
        if (name != null ? !name.equals(dataset.name) : dataset.name != null) return false;
        if (path != null ? !path.equals(dataset.path) : dataset.path != null) return false;
        if (loadTime != null ? !loadTime.equals(dataset.loadTime) : dataset.loadTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) dataType;
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (loadTime != null ? loadTime.hashCode() : 0);
        return result;
    }
}
