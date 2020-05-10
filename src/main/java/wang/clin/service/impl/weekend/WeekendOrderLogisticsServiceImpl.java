package wang.clin.service.impl.weekend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wang.clin.annotation.OrderLogistics;
import wang.clin.enums.OrderType;
import wang.clin.service.impl.AbstractOrderLogisticsService;
import wang.clin.service.weekend.WeekendOrderLogisticsService;

/**
 * @author wcLin
 * @since 2020/5/9 上午 09:05
 **/
@Slf4j
@Service
@OrderLogistics(type = OrderType.WEEKEND, isDefault = true)
public class WeekendOrderLogisticsServiceImpl extends AbstractOrderLogisticsService
        implements WeekendOrderLogisticsService {
}
