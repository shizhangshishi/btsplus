package fd.se.btsplus.bts.model.response;

import fd.se.btsplus.bts.model.domain.BtsRole;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class BtsCurrUserRes extends BtsBaseRes {
    private long id;
    private long creator;
    private String username;
    private String nickname;
    private int sex;
    private String phone;
    private String email;
    private String address;
    private String branchNum;
    private int status;
    private List<BtsRole> roles;
}
