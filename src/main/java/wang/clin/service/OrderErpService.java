package wang.clin.service;

import wang.clin.pojo.bo.OrderBO;
import wang.clin.pojo.dto.OrderPayDTO;

/**
 * 订单ERP相关
 *
 * @author wcLin
 * @since 2020/5/9 上午 08:51
 **/
public interface OrderErpService {

    /**
     * 执行ERP操作
     *
     * @param order 支付数据
     */
    OrderBO erp(OrderPayDTO order);

}
