package config;

import entity.DemoObj;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author Allen
 * @create 2018-09-15 上午 11:36
 * @desc
 **/
//实现自定义的HttpMessageConverter
public class MyMessgaeConverter extends AbstractHttpMessageConverter<DemoObj> {

    public MyMessgaeConverter(){
        //新建自定义的媒体类型application/x-wisely
        super(new MediaType("application","x-wisely", Charset.forName("UTF-8")));
    }

    /**
     * 表明本HttpessageConverter只处理DemoObj这个类
     * @param aClass
     * @return
     */
    @Override
    protected boolean supports(Class<?> aClass) {
        return DemoObj.class.isAssignableFrom(aClass);
    }

    /**
     * 处理请求的数据   处理由“-”隔开的数据,并转成DemoObj对象
     * @param aClass
     * @param httpInputMessage
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    @Override
    protected DemoObj readInternal(Class<? extends DemoObj> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        String temp= StreamUtils.copyToString(httpInputMessage.getBody(),Charset.forName("UTF-8"));
        String []tempArr=temp.split("-");
        return new DemoObj(new Long(tempArr[0]),tempArr[1]);
    }

    /**
     *处理如何输出数据到response。
     * @param demoObj
     * @param httpOutputMessage
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    @Override
    protected void writeInternal(DemoObj demoObj, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        String out="hello:"+ demoObj.getId()+"-"+demoObj.getName();
        httpOutputMessage.getBody().write(out.getBytes());
    }

}
