package wang.clin.service;

import wang.clin.pojo.bo.OrderBO;
import wang.clin.pojo.dto.OrderLogisticsDTO;

/**
 * 订单物流相关
 *
 * @author wcLin
 * @since 2020/5/9 上午 08:51
 **/
public interface OrderLogisticsService {
    /**
     * 执行物流操作
     *
     * @param order 物流数据
     */
    OrderBO logistics(OrderLogisticsDTO order);
}
