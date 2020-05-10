package wang.clin.service.impl.weekend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wang.clin.annotation.OrderErp;
import wang.clin.enums.OrderType;
import wang.clin.service.impl.AbstractOrderErpService;
import wang.clin.service.weekend.WeekendOrderErpService;

/**
 * @author wcLin
 * @since 2020/5/9 上午 09:05
 **/
@Slf4j
@Service
@OrderErp(type = OrderType.WEEKEND, isDefault = true)
public class WeekendOrderErpServiceImpl extends AbstractOrderErpService
        implements WeekendOrderErpService {
}
