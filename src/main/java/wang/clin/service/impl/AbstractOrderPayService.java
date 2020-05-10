package wang.clin.service.impl;

import wang.clin.pojo.bo.OrderBO;
import wang.clin.pojo.dto.OrderPayDTO;
import wang.clin.service.OrderPayService;

/**
 * 接口调度器
 *
 * @author wcLin
 * @since 2020/5/9 上午 08:49
 **/
public abstract class AbstractOrderPayService implements OrderPayService {

    @Override
    public OrderBO pay(OrderPayDTO order) {
        /* 模拟执行支付操作 */
        return null;
    }
}
