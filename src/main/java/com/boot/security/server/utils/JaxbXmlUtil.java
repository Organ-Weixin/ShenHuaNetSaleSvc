package com.boot.security.server.utils;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.boot.security.server.api.core.LockSeatQueryXml;
import com.boot.security.server.api.core.LockSeatQueryXml.LockSeatQueryXmlOrder;
import com.boot.security.server.api.core.LockSeatQueryXml.LockSeatQueryXmlOrder.LockSeatQueryXmlSeat;

/**
 * Jaxb工具类 xml和java类相互转换
 */
public class JaxbXmlUtil {

    public static final String DEFAULT_ENCODING = "UTF-8";

    /**
     * pojo转换成xml 默认编码UTF-8
     *
     * @param obj 待转化的对象
     * @return xml格式字符串
     * @throws Exception JAXBException
     */
    public static String convertToXml(Object obj) throws Exception {
        return convertToXml(obj, DEFAULT_ENCODING);
    }

    /**
     * pojo转换成xml
     *
     * @param obj 待转化的对象
     * @param encoding 编码
     * @return xml格式字符串
     * @throws Exception JAXBException
     */
    public static String convertToXml(Object obj, String encoding) throws Exception {
        String result = null;
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        // 指定是否使用换行和缩排对已编组 XML 数据进行格式化的属性名称。
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);

        StringWriter writer = new StringWriter();
        marshaller.marshal(obj, writer);
        result = writer.toString();

        return result;
    }

    /**
     * xml转换成JavaBean
     *
     * @param xml xml格式字符串
     * @param t 待转化的对象
     * @return 转化后的对象
     * @throws Exception JAXBException
     */
    @SuppressWarnings("unchecked")
    public static <T> T convertToJavaBean(String xml, Class<T> t) throws Exception {
        T obj = null;
        JAXBContext context = JAXBContext.newInstance(t);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        obj = (T) unmarshaller.unmarshal(new StringReader(xml));
        return obj;
    }
    
    public static void main(String[] args) throws Exception {
    	/*CxApplyFetchTicketParameter applyParam = new CxApplyFetchTicketParameter();
		applyParam.setAppCode("QJUSER");
		applyParam.setCinemaCode("62549174");
		CxApplyFetchTicketXmlTickets Tickets = new CxApplyFetchTicketParameter.CxApplyFetchTicketXmlTickets();
		List<CxApplyFetchTicketXmlTicket> Ticket = new ArrayList<CxApplyFetchTicketXmlTicket>();
		CxApplyFetchTicketXmlTicket ti = new CxApplyFetchTicketXmlTicket();
		ti.setPrintNo("6254917450251556");
		ti.setVerifyCodeMD5("0622551459517645");
		Ticket.add(ti);
		Tickets.setTicket(Ticket);
		applyParam.setTickets(Tickets);
		
		applyParam.setCompress("0");
		applyParam.setVerifyInfo("1234567889");*/
    	LockSeatQueryXml queryxml=new LockSeatQueryXml();
    	queryxml.setCinemaCode("62549174");
    	LockSeatQueryXmlOrder order=new LockSeatQueryXmlOrder();
    	order.setPayType("0");
    	order.setSessionCode("2423201904240012");
    	order.setCount(1);
    	List<LockSeatQueryXmlSeat> seats=new ArrayList<LockSeatQueryXmlSeat>();
    	LockSeatQueryXmlSeat seat=new LockSeatQueryXmlSeat();
    	seat.setSeatCode("6254917406#03#01");
    	seat.setPrice(45D);
    	seat.setFee(0D);
    	seats.add(seat);
    	order.setSeat(seats);
    	queryxml.setOrder(order);
		String ApplyFetchTicketXml = convertToXml(queryxml);
		System.out.println(ApplyFetchTicketXml);
	}
}