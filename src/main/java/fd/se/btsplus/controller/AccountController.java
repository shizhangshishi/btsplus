package fd.se.btsplus.controller;

import fd.se.btsplus.bts.http.IBtsHttpCaller;
import fd.se.btsplus.bts.model.respnse.BtsLoginRes;
import fd.se.btsplus.model.request.LoginReq;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;

@AllArgsConstructor
@RestController
public class AccountController {
    private final IBtsHttpCaller caller;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginReq request) {
        BtsLoginRes res = null;
        try {
            res = caller.login(request.getUsername(), request.getPassword());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(res);
    }

}
