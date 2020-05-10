package wang.clin.service.impl.weekend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import wang.clin.service.impl.AbstractOrderService;
import wang.clin.service.weekend.WeekendOrderService;

/**
 * @author wcLin
 * @since 2020/5/9 上午 09:05
 **/
@Slf4j
@Service
public class WeekendOrderServiceImpl extends AbstractOrderService implements WeekendOrderService {

    public WeekendOrderServiceImpl(ApplicationContext applicationContext) {
        super(applicationContext);
    }
}
