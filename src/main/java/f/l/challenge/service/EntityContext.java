package f.l.challenge.service;

import java.util.HashMap;
import java.util.Map;

public class EntityContext {

    private final Map<String, Object> args;

    public EntityContext(Map<String, Object> args) {
        this.args = new HashMap<>(args);
    }

    Integer getUser() {
        return (int) args.get("userId");
    }

}
