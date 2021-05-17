package com.qa.web.confighelper;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    public static Properties p = new Properties();

    // this method is to be called to load the properties
    public static void PopulateSettings() throws IOException {
        ConfigReader reader = new ConfigReader();
        reader.ReadProperty();
    }

    private void ReadProperty() throws IOException {
        //Load the Property file
        InputStream inputStream = new FileInputStream("src/main/resources/Config.properties");
        p.load(inputStream);
        /**Get Website /
         *
         */
        Settings.Website = p.getProperty("Website");
        /** User Name**/
        Settings.Username = p.getProperty("Username");
        /** Password**/
        Settings.Password = p.getProperty("Password");
        /** Browser**/
        Settings.browser = BrowserTypes.valueOf(p.getProperty("Browser"));
        /** Extent report path**/
        Settings.ReportConfigPath = p.getProperty("ReportConfigPath");
    }
}