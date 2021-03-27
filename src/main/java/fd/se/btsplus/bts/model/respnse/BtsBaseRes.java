package fd.se.btsplus.bts.model.respnse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BtsBaseRes {
    private int code;
}
