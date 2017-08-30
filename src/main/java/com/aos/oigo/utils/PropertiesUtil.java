package com.aos.oigo.utils;

import java.io.*;
import java.util.Properties;

/**
 * @author 黄浩新
 * @since 2017-7-21
 */

public class PropertiesUtil
{
    public static String getProperties(String key)
    {
        Properties prop = new Properties();
        try
        {
            InputStream in = new BufferedInputStream(new FileInputStream("build.properties"));
            prop.load(in);
            if(key != null || key != "")
            {
                return prop.getProperty(key);
            }
            in.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    //
    /*
    public static void setProperties(String newfilename,String key,String value) throws IOException
    {
        Properties prop = new Properties();
        FileOutputStream oFile = new FileOutputStream(newfilename,true);
        prop.setProperty(key, value);
        prop.store(oFile, "The New properties file");
        oFile.close();
    }
    */
}
