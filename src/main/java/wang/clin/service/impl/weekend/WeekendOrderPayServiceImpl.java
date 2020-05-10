package wang.clin.service.impl.weekend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wang.clin.annotation.OrderPay;
import wang.clin.enums.OrderType;
import wang.clin.service.impl.AbstractOrderPayService;
import wang.clin.service.weekend.WeekendOrderPayService;

/**
 * @author wcLin
 * @since 2020/5/9 上午 09:05
 **/
@Slf4j
@Service
@OrderPay(type = OrderType.WEEKEND, isDefault = true)
public class WeekendOrderPayServiceImpl extends AbstractOrderPayService
        implements WeekendOrderPayService {
}
