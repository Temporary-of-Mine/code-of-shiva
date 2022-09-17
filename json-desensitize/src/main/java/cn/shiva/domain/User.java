package cn.shiva.domain;

import cn.shiva.config.DataMaskingFunc;
import cn.shiva.config.annotation.DataMasking;
import cn.shiva.config.annotation.ReadableSensitiveVerify;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author shiva   2022-09-17 16:10
 */
@Data
@Builder
public class User implements Serializable {
    @DataMasking(maskFunc = DataMaskingFunc.NAME)
    @ReadableSensitiveVerify(type = "name")
    private String name;
    @DataMasking(maskFunc = DataMaskingFunc.IDCARD)
    @ReadableSensitiveVerify(type = "idCard")
    private String idCard;
    @DataMasking(maskFunc = DataMaskingFunc.MOBILE)
    @ReadableSensitiveVerify(type = "mobile")
    private String mobile;
}
