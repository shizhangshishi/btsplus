package fd.se.btsplus.auth;

import fd.se.btsplus.bts.http.IBtsHttpCaller;
import fd.se.btsplus.bts.model.response.BtsCurrUserRes;
import fd.se.btsplus.model.consts.Constant;
import fd.se.btsplus.model.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.net.HttpURLConnection.HTTP_OK;

@AllArgsConstructor
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    private final Subject subject;
    private final IBtsHttpCaller caller;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String logInToken = request.getHeader(Constant.LOGIN_TOKEN_HEADER);
        if (logInToken == null || (logInToken = logInToken.trim()).isEmpty()) {
            return false;
        }
        subject.setLoginToken(logInToken);
        final BtsCurrUserRes res = caller.currUser();
        if (res.getCode() != HTTP_OK) {
            return false;
        }
        subject.setCurrUser(User.from(res));
        return true;
    }
}
