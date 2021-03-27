package fd.se.btsplus.model.consts;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum Role {
    ANY(-1),
    TELLER(4),
    ADMIN(3);

    private final int roleType;

    Role(int roleType) {
        this.roleType = roleType;
    }

    public static Role of(int roleType) {
        for (Role role : Role.values()) {
            if (role.roleType == roleType) {
                return role;
            }
        }
        return null;
    }

    @JsonValue
    public int value() {
        return roleType;
    }
}
