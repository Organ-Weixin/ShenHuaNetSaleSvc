package com.boot.security.server.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.List;

import net.sf.json.xml.XMLSerializer;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;



/**
 * xml工具类
 * @author miklchen
 *
 */
public class XmlToJsonUtil {

	/**
	 * 将xml转换为JSON对象
	 * @param xml xml字符串
	 * @return
	 * @throws Exception
	 */
	public static String xmltoJson(String xml,String apiResultName) throws Exception {
		JSONObject jsonObject = new JSONObject();
		Document document = DocumentHelper.parseText(xml);
		//获取根节点元素对象
		Element root = document.getRootElement();
		iterateNodes(root, jsonObject,apiResultName);
		return jsonObject.toString();
	}

	public static void iterateNodes(Element node,JSONObject json,String apiResultName){
		//获取当前元素的名称
		String nodeName = node.getName();
		//判断已遍历的JSON中是否已经有了该元素的名称
		if(json.containsKey(nodeName)){
			//该元素在同级下有多个
			Object Object = json.get(nodeName);
			JSONArray array = null;
			if(Object instanceof JSONArray){
				array = (JSONArray) Object;
			}else {
				array = new JSONArray();
				array.add(Object);
			}
			//获取该元素下所有子元素
			List<Element> listElement = node.elements();
			if(listElement.isEmpty()){
				//该元素无子元素，获取元素的值
				String nodeValue = node.getTextTrim();
				if (!"".equals(nodeValue)){
					array.add(nodeValue);
					json.put(nodeName, array);
				}
				return ;
			}
			//有子元素
			JSONObject newJson = new JSONObject();
			//遍历所有子元素
			for(Element e:listElement){
				//递归
				iterateNodes(e,newJson,apiResultName);
			}
			array.add(newJson);
			json.put(nodeName, array);
			return ;
		}
		//该元素同级下第一次遍历
		//获取该元素下所有子元素
		List<Element> listElement = node.elements();
		if(listElement.isEmpty()){
			//该元素无子元素，获取元素的值
			String nodeValue = node.getTextTrim();
			if (!"".equals(nodeValue)){
				json.put(nodeName, nodeValue);
			}
			return ;
		}
		//有子节点，新建一个JSONObject来存储该节点下子节点的值
		JSONObject object = new JSONObject();
		//遍历所有一级子节点
		for(Element e:listElement){
			//递归
			iterateNodes(e,object,apiResultName);
		}
		json.put(nodeName, object);
		return ;
	}



	public static void main(String[] args) throws Exception{
			String xml = "<QueryCinemaListResult xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n" +
					"   <ResultCode>0</ResultCode>\n" +
					"   <Message>成功</Message>\n" +
					"   <Cinemas>\n" +
					"      <Cinema>\n" +
					"         <CinemaCode>62549174</CinemaCode>\n" +
					"         <CinemaName>130影院</CinemaName>\n" +
					"         <Province>广东省</Province>\n" +
					"         <City>广州市</City>\n" +
					"         <CreateDate>2015-03-19</CreateDate>\n" +
					"         <PriceType>0</PriceType>\n" +
					"      </Cinema>\n" +
					"   </Cinemas>\n" +
					"</QueryCinemaListResult>";
		String jsonObject = xmltoJson(xml,"QueryCinemaListResult");
		System.out.println(jsonObject);
	}



}

