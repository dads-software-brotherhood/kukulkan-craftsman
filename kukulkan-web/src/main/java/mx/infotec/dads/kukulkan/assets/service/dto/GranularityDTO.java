package mx.infotec.dads.kukulkan.assets.service.dto;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Granularity entity.
 */
public class GranularityDTO implements Serializable {

    private String id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String briefDescription;

    private Integer order;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GranularityDTO granularityDTO = (GranularityDTO) o;
        if(granularityDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), granularityDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "GranularityDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", briefDescription='" + getBriefDescription() + "'" +
            ", order='" + getOrder() + "'" +
            "}";
    }
}
