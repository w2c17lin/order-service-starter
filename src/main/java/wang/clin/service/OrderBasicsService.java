package wang.clin.service;

import wang.clin.pojo.bo.OrderBO;
import wang.clin.pojo.dto.OrderOrderDTO;

/**
 * 订单基础相关
 *
 * @author wcLin
 * @since 2020/5/9 上午 08:52
 **/
public interface OrderBasicsService {

    /**
     * 执行下单操作
     *
     * @param order 下单数据
     */
    OrderBO order(OrderOrderDTO order);
}
