package pl.blaszak.ImportandUrgent.model;

import org.springframework.data.annotation.Id;

public class Settings {

    @Id
    private String id;
    private Float importantFactor;
    private Float urgentFactor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getImportantFactor() {
        return importantFactor;
    }

    public void setImportantFactor(Float importantFactor) {
        this.importantFactor = importantFactor;
    }

    public Float getUrgentFactor() {
        return urgentFactor;
    }

    public void setUrgentFactor(Float urgentFactor) {
        this.urgentFactor = urgentFactor;
    }
}
