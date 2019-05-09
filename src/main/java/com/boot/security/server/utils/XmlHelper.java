package com.boot.security.server.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.gson.Gson;

public class XmlHelper {
	/**
	 * 
	 * @param document
	 *            Document对象（读xml生成的）
	 * @return String字符串
	 * @throws Throwable
	 */
	public static String xmlToString(Document document) throws Throwable {
		TransformerFactory ft = TransformerFactory.newInstance();
		Transformer ff = ft.newTransformer();
		ff.setOutputProperty("encoding", "GB2312");
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ff.transform(new DOMSource(document), new StreamResult(bos));
		return bos.toString();
	}

	/**
	 * 
	 * @param xml形状的str串
	 * @return Document 对象
	 */
	public static Document StringTOXml(String str) {

		StringBuilder sXML = new StringBuilder();
		sXML.append(str);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		Document doc = null;
		try {
			InputStream is = new ByteArrayInputStream(sXML.toString().getBytes("utf-8"));
			doc = dbf.newDocumentBuilder().parse(is);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doc;
	}

	/**
	 * 
	 * @param document
	 * @return 某个节点的值 前提是需要知道xml格式，知道需要取的节点相对根节点所在位置
	 */
	public static String getNodeValue(Document document, String nodePaht) {
		XPathFactory xpfactory = XPathFactory.newInstance();
		XPath path = xpfactory.newXPath();
		String servInitrBrch = "";
		try {
			servInitrBrch = path.evaluate(nodePaht, document);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return servInitrBrch;
	}

	/**
	 * 
	 * @param document
	 * @param nodePath
	 *            需要修改的节点相对根节点所在位置
	 * @param vodeValue
	 *            替换的值
	 */
	public static void setNodeValue(Document document, String nodePath, String vodeValue) {
		XPathFactory xpfactory = XPathFactory.newInstance();
		XPath path = xpfactory.newXPath();
		Node node = null;
		;
		try {
			node = (Node) path.evaluate(nodePath, document, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		node.setTextContent(vodeValue);
	}

	/**
     * XML格式字符串转换为Map
     *
     * @param strXML XML字符串
     * @return XML数据转换后的Map
     * @throws Exception
     */
	public static Map<String, String> xmlToMap(String strXML) throws Exception {
		Map<String, String> data = new HashMap<String, String>();
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		InputStream stream = new ByteArrayInputStream(strXML.getBytes("UTF-8"));
		org.w3c.dom.Document doc = documentBuilder.parse(stream);
		doc.getDocumentElement().normalize();
		NodeList nodeList = doc.getDocumentElement().getChildNodes();
		for (int idx = 0; idx < nodeList.getLength(); ++idx) {
			Node node = nodeList.item(idx);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				org.w3c.dom.Element element = (org.w3c.dom.Element) node;
				data.put(element.getNodeName(), element.getTextContent());
			}
		}
		stream.close();
		return data;
	}

	/**
     * 将Map转换为XML格式的字符串
     *
     * @param data Map类型数据
     * @return XML格式的字符串
     * @throws Exception
     */
	public static String mapToXml(Map<String, String> data) throws Exception {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		org.w3c.dom.Document document = documentBuilder.newDocument();
		org.w3c.dom.Element root = document.createElement("xml");
		document.appendChild(root);
		for (String key : data.keySet()) {
			String value = data.get(key);
			if (value == null) {
				value = "";
			}
			value = value.trim();
			org.w3c.dom.Element filed = document.createElement(key);
			filed.appendChild(document.createTextNode(value));
			root.appendChild(filed);
		}
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		DOMSource source = new DOMSource(document);
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		transformer.transform(source, result);
		String output = writer.getBuffer().toString(); // .replaceAll("\n\r",// "");
		writer.close();
		return output;
	}

	public static void main(String[] args) throws Throwable {
		String xmlstr = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg><appid><![CDATA[wx2421b1c4370ec43b]]></appid><mch_id><![CDATA[10000100]]></mch_id><nonce_str><![CDATA[IITRi8Iabbblz1Jc]]></nonce_str><openid><![CDATA[oUpF8uMuAJO_M2pxb1Q9zNjWeS6o]]></openid><sign><![CDATA[7921E432F65EB8ED0CE9755F0E86D72F]]></sign><result_code><![CDATA[SUCCESS]]></result_code><prepay_id><![CDATA[wx201411101639507cbf6ffd8b0779950874]]></prepay_id><trade_type><![CDATA[JSAPI]]></trade_type></xml> ";
		// String xmlstr2 = xmlstr.replace("<![CDATA[", "").replace("]]>", "");
		// Document document = StringTOXml(xmlstr2);
		// String nodeValue = getNodeValue(document, "/xml/prepay_id2");
		// System.out.println(nodeValue);
		Map<String, String> map = xmlToMap(xmlstr);
		Map<String, String> signMap=new TreeMap<String, String>();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if(entry.getKey()!="sign"){
				signMap.put(entry.getKey(), entry.getValue());
			}
        }
		
		System.out.println(new Gson().toJson(signMap));

		/*
		 * // 读取xml文件，生成document对象 DocumentBuilder builder =
		 * DocumentBuilderFactory.newInstance().newDocumentBuilder(); //
		 * 文件的位置在工作空间的根目录（位置随意，只要写对就ok） Document document = builder.parse(new
		 * File("a.xml")); XmlHelper t = new XmlHelper(); // XML————》String
		 * String str = t.xmlToString(document); System.out.println("str:" +
		 * str); // String ————》XML Document doc = t.StringTOXml(str); String
		 * nodePath = "/transaction/header/msg/sndMbrCd"; // getNodeValue String
		 * nodeValue = t.getNodeValue(doc, nodePath);
		 * System.out.println("修改前nodeValue：" + nodeValue); // setNodeValue
		 * t.setNodeValue(doc, nodePath, nodeValue + "hello");
		 * System.out.println("修改后nodeValue：" + t.getNodeValue(doc, nodePath));
		 */
	}

}
