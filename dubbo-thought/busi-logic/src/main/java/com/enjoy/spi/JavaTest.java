package com.enjoy.spi;

import com.enjoy.infoService.impl.InfoServiceAImpl;
import com.enjoy.infoService.impl.InfoServiceBImpl;
import com.enjoy.service.InfoService;
import org.junit.Test;

public class JavaTest {

    /**
     * java 编码引入实现，显示引入InfoServiceAImpl
     * 若实现类有了改动，比如切换另一个实现，使用者必须得重新编码
     */
    @Test
    public void javaSPI() {
        InfoService infoService = new InfoServiceBImpl();
        infoService.sayHello("peter");
    }

}
