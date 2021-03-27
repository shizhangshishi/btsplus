package fd.se.btsplus.bts.model.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BtsRole {
    private long id;
    private long creator;
    private String name;
    private int roleType;
    private String description;
}
