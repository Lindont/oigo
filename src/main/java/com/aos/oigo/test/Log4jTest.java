package com.aos.oigo.test;

import org.apache.log4j.Logger;
import org.junit.Test;

public class Log4jTest {
    @Test
    public void test1() {
        Logger logger = Logger.getLogger(this.getClass());
        logger.info(" This is info!!!");
        logger.warn(" This is warn!!!");
        logger.error(" This is error!!!");
        logger.fatal(" This is fatal!!!");
        logger.debug(" This is debug!!!");
        logger.trace(" This is trace!!!");
    }
}
