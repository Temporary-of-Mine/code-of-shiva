package cn.demo.shiva.api;

import cn.demo.shiva.bo.ApiResp;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shiva   2021/9/2 22:49
 */
@RestController
@RequestMapping("/index")
@Api(tags = "api 登陆相关接口")
public class ApiLoginController {

    @GetMapping
    @ApiOperation(value = "登陆接口", notes = "使用 username、password 登陆，返回 token")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, defaultValue = "wtf?"),
            @ApiImplicitParam(name = "password", value = "密码",required = true, defaultValue = "fk!")
    })
    public ApiResp<String> getByUserName(String username, String password) {
        String token = username + password;
        return new ApiResp<String>(0).complete("登陆成功", token);
    }

}
