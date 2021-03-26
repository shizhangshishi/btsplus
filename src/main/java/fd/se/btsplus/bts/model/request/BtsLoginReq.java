package fd.se.btsplus.bts.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BtsLoginReq {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
