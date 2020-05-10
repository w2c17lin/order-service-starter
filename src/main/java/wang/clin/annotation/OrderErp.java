package wang.clin.annotation;

import wang.clin.enums.OrderType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 订单ERP处理器
 *
 * @author wcLin
 * @since 2020/4/12 上午 09:28
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface OrderErp {

    /**
     * 在找不到其它处理器的时候 是否作为默认处理器处理
     */
    boolean isDefault() default false;

    /**
     * 处理的订单类型
     */
    OrderType type();


}
