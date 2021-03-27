package fd.se.btsplus.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import fd.se.btsplus.bts.model.respnse.BtsLoginRes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class LoginRes extends BaseRes {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime expireTime;
    private String token;

    public static LoginRes from(BtsLoginRes res) {
        return new LoginRes(res.getExpireTime(), res.getToken());
    }

}
