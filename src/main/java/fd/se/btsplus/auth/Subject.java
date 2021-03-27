package fd.se.btsplus.auth;

import fd.se.btsplus.model.domain.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Getter
@Setter
@RequestScope
@Component
public class Subject {
    private String loginToken;
    private User currUser;
}
