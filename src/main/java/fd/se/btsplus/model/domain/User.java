package fd.se.btsplus.model.domain;

import fd.se.btsplus.bts.model.response.BtsCurrUserRes;
import fd.se.btsplus.model.consts.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private long id;
    private String username;
    private String nickname;
    private int sex;
    private String phone;
    private String email;
    private String address;
    private String branchNum;
    private List<Role> roles;

    public static User from(BtsCurrUserRes res) {
        return new User(res.getId(), res.getUsername(), res.getNickname(), res.getSex(),
                res.getPhone(), res.getEmail(), res.getAddress(), res.getBranchNum(),
                res.getRoles().stream().map(
                        r -> Role.of(r.getRoleType())
                ).collect(Collectors.toList())
        );
    }
}
