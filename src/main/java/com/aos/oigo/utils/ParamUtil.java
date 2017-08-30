package com.aos.oigo.utils;

import javax.servlet.http.HttpServletRequest;
/**
* @author 黄浩新
* @since 2017-7-21
*/

public class ParamUtil
{
	/**
	 * @param _req
	 * @param _name
	 * @param _nullValue
	 * @return
	 */
	public static String getString(HttpServletRequest _req, String _name, String _nullValue)
	{
		if (_req.getParameter(_name) == null)
		{
			return _nullValue;
		}
		return _req.getParameter(_name).trim();
	}



	/**
	 * @param
	 * @param
	 * @param
	 * @return
	 */
	public static String getString2(HttpServletRequest _req, String _name, String _nullValue)
	{
		if (_req.getParameter(_name) == null || _req.getParameter(_name).trim().equals(""))
		{
			return _nullValue;
		}
		return _req.getParameter(_name).trim();
	}



	/**
	 * @param
	 * @param
	 * @param
	 * @return
	 */
	public static int getInt(HttpServletRequest _req, String _name, int _nullValue)
	{
		try
		{
			return Integer.parseInt(_req.getParameter(_name));
		} catch (Exception e)
		{
			return _nullValue;
		}
	}



	/**
	 * @param
	 * @param
	 * @param
	 * @return
	 */
	public static long getLong(HttpServletRequest _req, String _name, long _nullValue)
	{
		try
		{
			return Long.parseLong(_req.getParameter(_name));
		} catch (Exception e)
		{
			return _nullValue;
		}
	}



	/**
	 * @param
	 * @param
	 * @return
	 */
	public static boolean getBoolean(HttpServletRequest _req, String _name)
	{
		if (_req.getParameter(_name) != null)
		{
			return true;
		}
		return false;
	}



	/**
	 * @param
	 * @param
	 * @param
	 * @return
	 */
	public static boolean getBoolean(HttpServletRequest _req, String _name, String _trueValues)
	{
		if (_req.getParameter(_name) == null || _trueValues == null)
		{
			return false;
		}
		if (_trueValues.indexOf(_req.getParameter(_name)) >= 0)
		{
			return true;
		}
		return false;
	}



	/**
	 * @param
	 * @param
	 * @param
	 * @return
	 */
	public static float getFloat(HttpServletRequest _req, String _name, float _nullValue)
	{
		try
		{
			return Float.parseFloat(_req.getParameter(_name));
		} catch (Exception e)
		{
			return _nullValue;
		}
	}



	/**
	 * @param
	 * @param
	 * @param
	 * @return
	 */
	public static double getDouble(HttpServletRequest _req, String _name, double _nullValue)
	{
		try
		{
			return Double.parseDouble(_req.getParameter(_name));
		} catch (Exception e)
		{
			return _nullValue;
		}
	}
}