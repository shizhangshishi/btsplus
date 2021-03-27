package fd.se.btsplus.controller;

import fd.se.btsplus.bts.http.IBtsHttpCaller;
import fd.se.btsplus.bts.model.respnse.BtsLoginRes;
import fd.se.btsplus.model.request.LoginReq;
import fd.se.btsplus.model.response.LoginRes;
import fd.se.btsplus.model.response.ResWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
public class AccountController {
    private final IBtsHttpCaller caller;

    @Operation(method = "POST", tags = "Account", summary = "用户登录")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true,
            content = @Content(schema = @Schema(implementation = LoginReq.class)))
    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = LoginRes.class), mediaType = "application/json")
    })
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginReq request) {
        BtsLoginRes res = caller.login(request.getUsername(), request.getPassword());
        return ResponseEntity.
                status(res.getCode()).
                body(ResWrapper.wrap(res.getCode(), LoginRes.from(res)));
    }

}
