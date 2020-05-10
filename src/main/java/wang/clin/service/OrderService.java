package wang.clin.service;

import wang.clin.pojo.bo.OrderBO;
import wang.clin.pojo.dto.OrderLogisticsDTO;
import wang.clin.pojo.dto.OrderOrderDTO;
import wang.clin.pojo.dto.OrderPayDTO;
import wang.clin.pojo.dto.OrderReviewDTO;

/**
 * 接口调度器
 *
 * @author wcLin
 * @since 2020/5/9 上午 08:49
 **/
public interface OrderService {

    /**
     * 执行下单操作
     *
     * @param order 下单数据
     */
    OrderBO order(OrderOrderDTO order);

    /**
     * 执行支付操作
     *
     * @param order 支付数据
     */
    OrderBO pay(OrderPayDTO order);

    /**
     * 执行审核操作
     *
     * @param order 审核数据
     */
    OrderBO review(OrderReviewDTO order);

    /**
     * 执行物流操作
     *
     * @param order 物流数据
     */
    OrderBO logistics(OrderLogisticsDTO order);

}
