package wang.clin.service.impl;

import wang.clin.pojo.bo.OrderBO;
import wang.clin.pojo.dto.OrderOrderDTO;
import wang.clin.service.OrderBasicsService;

/**
 * 接口调度器
 *
 * @author wcLin
 * @since 2020/5/9 上午 08:49
 **/
public abstract class AbstractOrderBasicsService implements OrderBasicsService {

    @Override
    public OrderBO order(OrderOrderDTO order) {
        /* 模拟执行下单操作 */
        return null;
    }
}
