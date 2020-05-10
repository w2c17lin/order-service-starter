package wang.clin.service.impl.weekend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wang.clin.annotation.OrderBasics;
import wang.clin.enums.OrderType;
import wang.clin.service.impl.AbstractOrderBasicsService;
import wang.clin.service.weekend.WeekendOrderBasicsService;

/**
 * @author wcLin
 * @since 2020/5/9 上午 09:05
 **/
@Slf4j
@Service
@OrderBasics(type = OrderType.WEEKEND, isDefault = true)
public class WeekendOrderBasicsServiceImpl extends AbstractOrderBasicsService
        implements WeekendOrderBasicsService {
}
