package fd.se.btsplus.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "wrap")
public class ResWrapper {
    private int code;
    private BaseRes res;
}
