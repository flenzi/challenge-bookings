package f.l.challenge.service;

import f.l.challenge.mapper.EntityMapper;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class EntityContext {

    private final Map<String, Object> args;
    private Integer searchFrom;
    private Integer searchTo;
    private Integer propertyId;

    public EntityContext(Map<String, Object> args) {
        this.args = new HashMap<>(args);
    }

    public Integer getUser() {
        return (int) args.get("userId");
    }

    public Integer getSearchFrom() {
        return searchFrom;
    }

    public void setSearchFrom(LocalDate searchFrom) {
        this.searchFrom = EntityMapper.localDateToInt(searchFrom);
    }

    public Integer getSearchTo() {
        return searchTo;
    }

    public void setSearchTo(LocalDate searchTo) {
        this.searchTo = EntityMapper.localDateToInt(searchTo);
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }
}
