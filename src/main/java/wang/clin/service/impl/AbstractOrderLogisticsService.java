package wang.clin.service.impl;

import wang.clin.pojo.bo.OrderBO;
import wang.clin.pojo.dto.OrderLogisticsDTO;
import wang.clin.service.OrderLogisticsService;

/**
 * 接口调度器
 *
 * @author wcLin
 * @since 2020/5/9 上午 08:49
 **/
public abstract class AbstractOrderLogisticsService implements OrderLogisticsService {
    @Override
    public OrderBO logistics(OrderLogisticsDTO order) {
        return null;
    }
}
