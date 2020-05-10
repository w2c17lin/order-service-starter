package wang.clin.service;

import wang.clin.pojo.bo.OrderBO;
import wang.clin.pojo.dto.OrderPayDTO;

/**
 * 订单支付相关
 *
 * @author wcLin
 * @since 2020/5/9 上午 08:49
 **/
public interface OrderPayService {

    /**
     * 执行支付操作
     *
     * @param order 支付数据
     */
    OrderBO pay(OrderPayDTO order);
}
