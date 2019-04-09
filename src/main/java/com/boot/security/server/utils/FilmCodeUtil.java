package com.boot.security.server.utils;

import java.util.List;

import org.assertj.core.util.Arrays;

public class FilmCodeUtil {
	private static String[] _3DFlagsArray={"2", "4", "9", "c", "e", "j", "m", "o", "t", "w", "y", "D"};
	private static List<Object> _3DFlags = Arrays.asList(_3DFlagsArray);
	
	public static String GetFilmDimensional(String FilmCode) throws Exception
    {
        if (FilmCode.isEmpty())
        {
            throw new Exception(FilmCode);
        }

        String DimensionalFlag = FilmCode.substring(3,4);
        if (_3DFlags.contains(DimensionalFlag))
        {
            return "3D";
        }
        else
        {
            return "2D";
        }
    }
	
	public static String GetFilmLanguage(String FilmCode)
    {
        try
        {
            String CountryCode = FilmCode.substring(0, 3);
            switch (CountryCode)
            {
                case "001":
                case "002":
                case "003":
                case "004":
                    return "国语";
                case "010":
                    return "韩语";
                case "012":
                    return "日语";
                case "013":
                    return "越南语";
                case "014":
                    return "泰语";
                case "019":
                    return "印度语";
                default:
                    return "英语";
            }
        }
        catch (Exception e)
        {
            return "国语";
        }
    }

}
