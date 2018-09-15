package config;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @create 2018-09-12 上午 11:05
 * @desc 自定义拦截器
 **/
public class DemoInterceptor extends HandlerInterceptorAdapter {



    /**
     * 请求发生前执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime=System.currentTimeMillis();
        request.setAttribute("startTime",startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime= (long) request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime=System.currentTimeMillis();
        System.out.println("本次请求处理时间"+(endTime-startTime)+"ms");
        request.setAttribute("handlingTime",endTime-startTime);
    }


}
