package fd.se.btsplus.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class BaseRes {
    public static BaseRes empty() {
        return new BaseRes();
    }
}
