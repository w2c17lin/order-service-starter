package wang.clin.service.impl;

import wang.clin.pojo.bo.OrderBO;
import wang.clin.pojo.dto.OrderReviewDTO;
import wang.clin.service.OrderReviewService;

/**
 * 接口调度器
 *
 * @author wcLin
 * @since 2020/5/9 上午 08:49
 **/
public abstract class AbstractOrderReviewService implements OrderReviewService {
    @Override
    public OrderBO review(OrderReviewDTO order) {
        return null;
    }
}
