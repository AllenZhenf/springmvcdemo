package service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author Allen
 * @create 2018-09-16 下午 5:38
 * @desc
 **/
@Service
public class PushService {
    private DeferredResult<String> deferredResult;

    public DeferredResult<String> getAsyncUpdate(){
        deferredResult =new DeferredResult<String>();
        return deferredResult;
    }

    @Scheduled(fixedDelay = 5000)
    public void refresh(){
        if(deferredResult!=null){
            deferredResult.setResult(new Long(System.currentTimeMillis()).toString());
        }
    }
}
