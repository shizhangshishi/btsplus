package fd.se.btsplus.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginReq {
    @Schema(description = "raw username",required = true)
    @NotBlank
    private String username;

    @Schema(description = "raw password",required = true)
    @NotBlank
    private String password;
}
