package wang.clin.service.impl;

import wang.clin.pojo.bo.OrderBO;
import wang.clin.pojo.dto.OrderPayDTO;
import wang.clin.service.OrderErpService;

/**
 * 接口调度器
 *
 * @author wcLin
 * @since 2020/5/9 上午 08:49
 **/
public abstract class AbstractOrderErpService implements OrderErpService {
    @Override
    public OrderBO erp(OrderPayDTO order) {
        return null;
    }
}
