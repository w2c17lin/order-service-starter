package wang.clin.service;

import wang.clin.pojo.bo.OrderBO;
import wang.clin.pojo.dto.OrderReviewDTO;

/**
 * 订单审核相关
 *
 * @author wcLin
 * @since 2020/5/9 上午 08:50
 **/
public interface OrderReviewService {
    /**
     * 执行审核操作
     *
     * @param order 审核数据
     */
    OrderBO review(OrderReviewDTO order);

}
