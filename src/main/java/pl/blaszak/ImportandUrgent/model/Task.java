package pl.blaszak.ImportandUrgent.model;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;

public class Task {

    @Id
    private String id;
    @NotBlank
    private String name;
    private Float important;
    private Float urgent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getImportant() {
        return important;
    }

    public void setImportant(Float important) {
        this.important = important;
    }

    public Float getUrgent() {
        return urgent;
    }

    public void setUrgent(Float urgent) {
        this.urgent = urgent;
    }
}
