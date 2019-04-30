package com.cyy.report;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class AnalysXML {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		new AnalysXML().xml();

	}

	
	public void xml() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		Document doc=builder.parse(new File("D:\\CYY\\eclipse\\java-2018-12\\eclipse-workspace\\GetReport\\report.xml"));
		
		//获取根节点
		Element root=doc.getDocumentElement();
		
		Node Detail=root.getElementsByTagName("Detail").item(0);	
		
		Node CaseName=((Element)Detail).getElementsByTagName("CaseName").item(0);
		
		System.out.print(CaseName.getTextContent());
		
	}
	
	
}
