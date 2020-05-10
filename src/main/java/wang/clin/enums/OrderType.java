package wang.clin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 订单类型
 */
@Getter
@AllArgsConstructor
public enum OrderType {

    WEEKEND(1),
    ;

    private final Integer code;

    public static OrderType of(Integer type) {
        for (OrderType orderType : OrderType.values()) {
            if (orderType.getCode().equals(type)) return orderType;
        }
        throw new IllegalArgumentException("error order type " + type);
    }

}
