package fd.se.btsplus.bts.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import fd.se.btsplus.auth.Subject;
import fd.se.btsplus.bts.model.respnse.BtsLoginRes;
import fd.se.btsplus.model.consts.Constant;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;

import static fd.se.btsplus.model.consts.Constant.HTTP_POST;
import static java.net.HttpURLConnection.HTTP_OK;

@Profile("prod")
@Slf4j
@Service
@AllArgsConstructor
public final class BtsHttpCallerImpl implements IBtsHttpCaller {

    private final Subject subject;
    private final OkHttpClient client = new OkHttpClient();

    @Override
    public BtsLoginRes login(String username, String password) {
        final RequestBody body = new FormBody.Builder().
                add("username", username).
                add("password", password).build();
        final Request request = buildRequest(HTTP_POST,
                "/sys/login/restful", body, false);
        BtsLoginRes res = new BtsLoginRes();
        try (Response response = client.newCall(request).execute()) {
            if (response.code() == HTTP_OK) {
                res = readJSON(response.body().string(), BtsLoginRes.class);
            }
            res.setCode(response.code());
        } catch (IOException e) {
            log.error("bts http call: login", e);
        }
        return res;
    }


    @SneakyThrows
    private Request buildRequest(String method, String path, RequestBody body, boolean withToken) {
        final Request.Builder builder = new Request.Builder();
        if (withToken) {
            builder.header(Constant.LOGIN_TOKEN_HEADER, subject.getLoginToken());
        }
        return builder.url(new URL(new URL(BTS_URL), path)).method(method, body).build();
    }

    private static <T> T readJSON(String json, Class<T> clazz) throws JsonProcessingException {
        return MAPPER.readValue(json, clazz);
    }

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.registerModule(new JavaTimeModule());
    }
}
