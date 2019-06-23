/**
 * Copyright (C) 2011 ZHEJIANG SUPCON TECHNOLOGY CO.,LTD.
 * All rights reserved.
 */
package com.boot.security.server.utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DoubleUtil {
    public static String HOSTNAME = "www.spzuo.com";
    public static final String allChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String numChar = "0123456789";
//    public static Map<String, List<IQiYiSale>> IQiYimap = new HashMap<String, List<IQiYiSale>>();
//    public static Map<String, List<IQiYiSale>> YouKumap = new HashMap<String, List<IQiYiSale>>();

    /**
     * 私有构造方法，防止类的实例化，因为工具类不需要实例化。
     */
    private DoubleUtil() {
    }

    /**
     * 查询条件去除前后的空格。
     */
    public static String FilterParam(String param) {
        return param == null ? "" : param.trim();
    }

    /**
     * 判断是否null
     */
    public static String Null2String(String param) {
        return param == null ? "" : param.trim();
    }

    //add by ljx from scw
    //得到当前日期 没有时分秒的
    public static String getFormatDate(Date date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        String str = "";
        try {
            str = df.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    //默认小数保留的位数
    public static int scale = 2;

    /**
     * 提供精确的加法运算。
     *
     * @param v1
     * @param v2
     * @return 两个参数的和
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确的减法运算。
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */

    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确的乘法运算。
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */

    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
     * 小数点以后10位，以后的数字四舍五入。
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */

    public static double div(double v1, double v2) {
        return div(v1, v2, 8);
    }


    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */

    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The   scale   must   be   a   positive   integer   or   zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */

    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The   scale   must   be   a   positive   integer   or   zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * nowUser  目前登陆人的商家		businessid
     * beModify 被修改对象的所属商家	businessid
     *
     * @return
     */
    public static boolean isCorrectUser(String nowUser, String beModify) {
        //如果两者之一为null就代表没权限操作。
        if (nowUser == null || beModify == null) {
            return false;
        } else if ("-1".equals(nowUser)) {//管理员默认权限全部开通
            return true;
        }
        return nowUser.equals(beModify);
    }
    
    /**
     * yyyyMMddHHmmss
     * @return
     */
    public static String getTimeStamp2() {
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sd.format(new Date());
        return timestamp;
    }
    
    /**
     * yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getTimeStamp() {
    	SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = sd.format(new Date());
        return timestamp;
    }

    //判断时间是否过期 min 分钟数。
    public static boolean isOver(Date sendtime, int min) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sendt = sd.format(sendtime);
        Date nowDate = new Date();
        String nowtime = sd.format(nowDate);
        Long diff = 0l;
        try {
            //获得两个时间的毫秒时间差异
            diff = sd.parse(nowtime).getTime() - sd.parse(sendt).getTime();
            //System.out.println(sendt+"    "+diff/1000);
            //输出结果
            if (diff - (min * 1000 * 60) < 0) {
                return false;
            }
        } catch (Exception e) {
            return true;
        }
        return true;
    }

    /**
     * 获取随机6位的验证码
     *
     * @return code
     */
    public static String getNumCode() {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        int len = 6;
        for (int i = 0; i < len; i++) {
            sb.append(allChar.charAt(random.nextInt(numChar.length())));
        }
        return sb.toString();
    }

    //当前日期增加几天 正数是增加 负数是减少几天  11月1号 增加一天的话是 11月1号 23:59:59
    public static Date countDate(int days) {
        Calendar cla = Calendar.getInstance();
        cla.set(Calendar.AM_PM, Calendar.AM);
        cla.set(Calendar.HOUR_OF_DAY, 0);
        cla.set(Calendar.MINUTE, 0);
        cla.set(Calendar.SECOND, -1);
        cla.add(Calendar.DAY_OF_YEAR, days);
        return cla.getTime();
    }

    //获取当前月的第一天 当前月 0  上一月 -1  下一月 1
    public static Date getFirstDay(int month) {
        Calendar cla = Calendar.getInstance();
        cla.add(Calendar.MONTH, month);
        cla.set(Calendar.AM_PM, Calendar.AM);
        cla.set(Calendar.HOUR_OF_DAY, 0);
        cla.set(Calendar.SECOND, 0);
        cla.set(Calendar.MINUTE, 0);
        cla.set(Calendar.DAY_OF_MONTH, 1);
        return cla.getTime();
    }

    //获取前、后一个月的时间   上一月 -1  下一月 1
    public static Date getMonthDay(int difference) {
        Calendar cla = Calendar.getInstance();
        cla.add(Calendar.MONTH, difference);
        return cla.getTime();
    }

    //根据参数日期  （年月日 ）增加几天 正数是增加 负数是减少几天
    public static Date countDate(Date beginDate, int days) {
        Calendar cla = Calendar.getInstance();
        cla.setTime(beginDate);

        cla.set(Calendar.AM_PM, Calendar.AM);
        cla.set(Calendar.HOUR_OF_DAY, 0);
        cla.set(Calendar.MINUTE, 0);
        cla.set(Calendar.SECOND, -1);
        cla.add(Calendar.DAY_OF_YEAR, days);
        return cla.getTime();
    }

    /**
     * 指定时间增加或者减少几分钟后的时间
     *
     * @param beginDate
     * @param minute
     * @return
     */
    public static Date countDateByMinute(Date beginDate, int minute) {
        Calendar cla = Calendar.getInstance();
        cla.setTime(beginDate);
        cla.set(Calendar.MINUTE, cla.get(Calendar.MINUTE) + minute);
        return cla.getTime();
    }

    /**
     * 指定时间增加或者减少几小时后的时间
     *
     * @param beginDate
     * @param hour
     * @return
     */
    public static Date countDateByHour(Date beginDate, int hour) {
        Calendar cla = Calendar.getInstance();
        cla.setTime(beginDate);
        cla.set(Calendar.HOUR_OF_DAY, cla.get(Calendar.HOUR_OF_DAY) + hour);
        return cla.getTime();
    }

    //增加一年，如果是null  当前日期增加一年  2016 5 12缴费 2017-5 13号凌晨到期
    public static Date getNextYear(Date expiredtime) {
        Calendar cla = Calendar.getInstance();
        if (expiredtime != null) {
            cla.setTime(expiredtime);
        }
        cla.set(Calendar.AM_PM, Calendar.AM);
        cla.set(Calendar.HOUR_OF_DAY, 0);
        cla.set(Calendar.MINUTE, 0);
        cla.set(Calendar.SECOND, -1);
        cla.add(Calendar.DAY_OF_YEAR, 1);
        cla.add(Calendar.YEAR, 1);
        return cla.getTime();
    }

    /**
     * 当天时间 00:00:00点 与 n小时对应的毫秒数；
     * 0点输入0；
     * 例：n=24;结果为23:59:59
     *
     * @param n 毫秒数
     * @return
     */
    public static Long zero(int n) {
        long current = System.currentTimeMillis();
        long zero = current / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();
        if (n == 0) {//返回00:00:00；
            return zero;
        } else {//返回n-1:59:59；
            long endn = zero + n * 60 * 60 * 1000 - 1;
            return endn;
        }
    }

    //判断字符串是否是数字
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /**
     * 判断时间是否在时间段内
     *
     * @param date         当前时间 yyyy-MM-dd HH:mm:ss
     * @param strDateBegin 开始时间 00:00:00
     * @param strDateEnd   结束时间 00:05:00
     * @return
     */
    public static boolean isInDate(Date date, String strDateBegin,
                                   String strDateEnd) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = sdf.format(date);
        // 截取当前时间时分秒
        int strDateH = Integer.parseInt(strDate.substring(11, 13));
        int strDateM = Integer.parseInt(strDate.substring(14, 16));
        int strDateS = Integer.parseInt(strDate.substring(17, 19));
        // 截取开始时间时分秒
        int strDateBeginH = Integer.parseInt(strDateBegin.substring(0, 2));
        int strDateBeginM = Integer.parseInt(strDateBegin.substring(3, 5));
        int strDateBeginS = Integer.parseInt(strDateBegin.substring(6, 8));
        // 截取结束时间时分秒
        int strDateEndH = Integer.parseInt(strDateEnd.substring(0, 2));
        int strDateEndM = Integer.parseInt(strDateEnd.substring(3, 5));
        int strDateEndS = Integer.parseInt(strDateEnd.substring(6, 8));
        if ((strDateH >= strDateBeginH && strDateH <= strDateEndH)) {
            // 当前时间小时数在开始时间和结束时间小时数之间
            if (strDateH > strDateBeginH && strDateH < strDateEndH) {
                return true;
                // 当前时间小时数等于开始时间小时数，分钟数在开始和结束之间
            } else if (strDateH == strDateBeginH && strDateM >= strDateBeginM
                    && strDateM <= strDateEndM) {
                return true;
                // 当前时间小时数等于开始时间小时数，分钟数等于开始时间分钟数，秒数在开始和结束之间
            } else if (strDateH == strDateBeginH && strDateM == strDateBeginM
                    && strDateS >= strDateBeginS && strDateS <= strDateEndS) {
                return true;
            }
            // 当前时间小时数大等于开始时间小时数，等于结束时间小时数，分钟数小等于结束时间分钟数
            else if (strDateH >= strDateBeginH && strDateH == strDateEndH
                    && strDateM <= strDateEndM) {
                return true;
                // 当前时间小时数大等于开始时间小时数，等于结束时间小时数，分钟数等于结束时间分钟数，秒数小等于结束时间秒数
            } else if (strDateH >= strDateBeginH && strDateH == strDateEndH
                    && strDateM == strDateEndM && strDateS <= strDateEndS) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    //返回距离最近的还没到的几点钟（aimhour点，24小时制）
    public static Date getDate(int aimhour) {
        Calendar cal = Calendar.getInstance();
        Date aimdate = new Date();
        int hour = aimdate.getHours();//小时
        if (hour >= aimhour) {//小时数超过，第二天的aimhour点
            cal.add(Calendar.DAY_OF_MONTH, 1);
            aimdate = cal.getTime();
        }
        aimdate.setHours(aimhour);
        aimdate.setMinutes(0);
        aimdate.setSeconds(0);
        return aimdate;
    }

    /**
     * 生成订单号28位
     *
     * @return
     */
    public static String createBusinessNo() {
        String s = UUID.randomUUID().toString().replace("-", "").substring(0, 14);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String str = df.format(new Date());
        return str + s;
    }

    /**
     * 生成随机字符串
     *
     * @return
     */
    public static String getNonceStr() {
        Random random = new Random();
        return MD5Util.MD5Encode(String.valueOf(random.nextInt(10000)), "UTF-8");
    }

    /**
     * 生成签名
     *
     * @param rmap
     * @param appkey
     * @return
     */
    public static String createSign(SortedMap<String, Object> rmap, String appkey) {
        StringBuilder sb = new StringBuilder();
        Set es = rmap.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k).append("=").append(v).append("&");
            }
        }
        sb.append("key=").append(appkey);
        return MD5Util.MD5Encode(sb.toString(), "UTF-8").toUpperCase();
    }

    /**
     * 生成请求参数
     *
     * @param parameters
     * @return
     */
    public static String getRequestXml(SortedMap parameters) {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        String sign = "";
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if ("attach".equalsIgnoreCase(k) || "body".equalsIgnoreCase(k) || "sign".equalsIgnoreCase(k)) {
                sb.append("<").append(k).append(">").append("<![CDATA[").append(v).append("]]></").append(k).append(">");
            } else {
                sb.append("<").append(k).append(">").append(v).append("</").append(k).append(">");
            }

        }
        sb.append("</xml>");
        return sb.toString();
    }
    /**
     * 获取支付宝POST过来反馈信息
     *
     * @param paramMap 参数列表
     * @return
     */
    public static Map<String, String> getAliPayParams(Map paramMap) {
        Map<String, String> aliMap = new HashMap<String, String>();
        for (Iterator iter = paramMap.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) paramMap.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            aliMap.put(name, valueStr);
        }
        return aliMap;
    }

    /**
     * 将元为单位的数额转换为分
     *
     * @param amount
     * @return
     */
    public static String yuanToFee(String amount) {
        String currency = amount.replaceAll("\\$|\\￥|\\,", "");  //处理包含, ￥ 或者$的金额
        int index = currency.indexOf(".");
        int length = currency.length();
        Long amLong;
        if (index == -1) {
            amLong = Long.valueOf(currency + "00");
        } else if (length - index >= 3) {
            amLong = Long.valueOf((currency.substring(0, index + 3)).replace(".", ""));
        } else if (length - index == 2) {
            amLong = Long.valueOf((currency.substring(0, index + 2)).replace(".", "") + 0);
        } else {
            amLong = Long.valueOf((currency.substring(0, index + 1)).replace(".", "") + "00");
        }
        return amLong.toString();
    }

    /**
     * 计算总价
     * @param quantity 个数
     * @param price 单价
     * @return
     */
    public static BigDecimal calPrice(Integer quantity, Double price) {
        return new BigDecimal(quantity).multiply(new BigDecimal(price));
    }
    
    /**
     * 传入的参数是不是同一个月份的
     * @param time
     * @return
     */
    public static  boolean isThisMonth(Date time1,Date time2){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String strDate1 = sdf.format(time1);
        String strDate2 = sdf.format(time2);
        System.out.println(strDate1.substring(0, 6));
    	return strDate1.substring(0, 6).equals(strDate2.substring(0, 6));
    }
    
    public static void main(String[] args) {
    	System.out.print(isThisMonth(new Date(),new Date()));
	}
    
}
