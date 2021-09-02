package cn.demo.shiva.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author shiva   2021/9/2 22:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class ApiResp<T> implements Serializable {
    private static final long serialVersionUID = -8987146499044811408L;
    /**
     * 通用返回状态
     */
    @ApiModelProperty(value = "通用返回状态", required = true)
    private int code;
    /**
     * 通用返回信息
     */
    @ApiModelProperty(value = "通用返回信息", required = true)
    private String msg;
    /**
     * 通用返回数据
     */
    @ApiModelProperty(value = "通用返回数据", required = true)
    private T data;

    /**
     * 失败，不带错误信息
     */
    public static ApiResp<Object> error(String msg) {
        return new ApiResp<>(1, msg, null);
    }

    /**
     * 失败，不带错误信息
     */
    public static ApiResp<Object> error() {
        return new ApiResp<>(1, null, null);
    }

    /**
     * 成功，不带返回数据
     */
    public static ApiResp<Object> success(String msg) {
        return new ApiResp<>(0, msg, null);
    }

    /**
     * 成功，不带返回数据
     */
    public static ApiResp<Object> success() {
        return new ApiResp<>(0, "请求成功", null);
    }

    /**
     * 补全信息和数据体
     */
    public ApiResp<T> complete(String msg, T t){
        this.setMsg(msg);
        this.setData(t);
        return this;
    }

    public ApiResp(int code) {
        this.code = code;
    }
}
