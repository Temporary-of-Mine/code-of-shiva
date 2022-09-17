package cn.shiva.config.annotation;

import cn.shiva.config.DataMaskingFunc;

import java.lang.annotation.*;

/**
 * @author shiva   2022-09-17 23:05
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataMasking {

    DataMaskingFunc maskFunc() default DataMaskingFunc.NO_MASK;
}

