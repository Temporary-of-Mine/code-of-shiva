package cn.demo.shiva.front;

import cn.demo.shiva.bo.ApiResponse;
import com.sun.prism.PixelFormat;
import com.sun.xml.internal.ws.wsdl.writer.document.ParamType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shiva   2021/9/2 22:08
 */
@RestController
@RequestMapping("/user")
@Api(tags = "front 用户相关接口")
public class FrontUserController {

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除用户（DONE）", notes = "注意幂等性哦")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true)
    public ApiResponse<String> delete(@PathVariable Integer id) {
        return ApiResponse.<String>builder().code(0).message("删除成功").data(String.valueOf(id)).build();
    }

}
