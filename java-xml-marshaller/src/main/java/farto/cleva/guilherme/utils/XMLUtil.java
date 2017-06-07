package farto.cleva.guilherme.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class XMLUtil {

	public static final String UTF_8 = "UTF-8";
	public static final String ISO_8859_1 = "ISO-8859-1";

	public static Document parse(String xml, String encoding) {
		Document document = null;

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			factory.setValidating(false);

			DocumentBuilder builder = factory.newDocumentBuilder();

			document = builder.parse(new ByteArrayInputStream(xml.getBytes(encoding)));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return document;
	}

	public static Document parse(File xmlFile, String encoding) {
		Document document = null;

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			factory.setValidating(false);

			DocumentBuilder builder = factory.newDocumentBuilder();

			// document = builder.parse(xmlFile);
			document = builder.parse(new FileInputStream(xmlFile), encoding);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return document;
	}

	public static NodeList getNodeList(Element element, String... tagsPath) {
		if (tagsPath == null || tagsPath.length <= 0) {
			return null;
		} else if (tagsPath.length == 1) {
			return element.getElementsByTagName(tagsPath[0]);
		} else {
			String tagName = tagsPath[tagsPath.length - 1];

			return XMLUtil.getNodeList((Element) XMLUtil.getNode(element, Arrays.copyOf(tagsPath, tagsPath.length - 1)), tagName);
		}
	}

	public static Node getNode(Element element, String... tagsPath) {
		if (tagsPath == null || tagsPath.length <= 0) {
			return null;
		} else {
			Node node = null;

			for (String tagName : tagsPath) {
				node = node == null ? element.getElementsByTagName(tagName).item(0) : ((Element) node).getElementsByTagName(tagName).item(0);
			}

			return node;
		}
	}

	public static String getNodeValue(Element element, String tagName, String... tagsPath) {
		if (tagsPath == null || tagsPath.length <= 0) {
			return element.getElementsByTagName(tagName).item(0) != null ? element.getElementsByTagName(tagName).item(0).getTextContent() : null;
		} else {
			return XMLUtil.getNodeValue((Element) XMLUtil.getNode(element, tagsPath), tagName);
		}
	}

	public static String getNodeAttribute(Element element, String attributeName) {
		return element.getAttribute(attributeName);
	}

	public static Element iterateElement(NodeList nodeList, int index) {
		return (Element) nodeList.item(index);
	}

}
