package fd.se.btsplus.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import fd.se.btsplus.bts.model.response.BtsLoginRes;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class LoginRes extends BaseRes {
    @Schema(description = "expire time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime expireTime;
    @Schema(description = "login token")
    private String token;

    public static LoginRes from(BtsLoginRes res) {
        return new LoginRes(res.getExpireTime(), res.getToken());
    }

}
