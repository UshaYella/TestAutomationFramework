package com.qa.web.componenthelper;
//import org.apache.log4j.Logger;
public class NavigationHelper {
    //final static Logger logger = Logger.getLogger(NavigationHelper.class);

    public static void NavigateToUrl(String Url) {
        ObjectRepository.Driver.manage().deleteAllCookies();
        ObjectRepository.Driver.navigate().to(Url);
        //	logger.info(" Navigate To Page " + Url);
    }
}
