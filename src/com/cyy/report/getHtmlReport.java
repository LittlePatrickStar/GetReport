package com.cyy.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class getHtmlReport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringBuilder sb=new StringBuilder();
		PrintStream pw=null;
		try {
			pw=new PrintStream(new File("report.html"));//Ĭ��·������Ŀ��Ŀ¼
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>���Ա���</title>");
		sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\" />");
	    //��ʽ����
        sb.append("<style type=\"text/css\">");
        sb.append(".summaryTable table th {background:#8FBC8F}");
        sb.append(".summaryTable table tr{ background:#FAEBD7;text-align:center}");    
        sb.append(".detailTable table th {background:#8FBC8F}");
        sb.append(".detailTable table tr{ background:#FAEBD7;text-align:center}");  
        sb.append("</style></head>");
        //��ʽ��β

        sb.append("<body>");
        //���岿��һ��div
        sb.append("<div id=\"report\">");
        sb.append("<h1>CameraTestReport</h1>");
        sb.append("</div>");
        //���岿�ֶ���div
        sb.append("<div id=\"device\">");
        sb.append("<p>DeviceName��</p>");
        sb.append("<p>AndroidVersion��</p>");
        sb.append("<p>SWVersion��</p>");
        sb.append("<p>HWVersion��</p>");
        sb.append("<p>Report��<a href=\"D:\\CYY\\Android\">ReportLocation</a></p>");//�ĳ��Լ����Ա����ļ�λ��
        sb.append("</div>");
        //���岿������div
        sb.append("<div id=\"summary\">");
        sb.append("<h3>Summary</h3>");
        sb.append("</div>");
        //���岿���ĸ�div����һ��Table
        sb.append("<div class=\"summaryTable\">");
        sb.append("<table width=\"800\"  height=\"50\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;\">");
        sb.append("<th>TestCase</th><th>Total</th><th>Pass</th><th>Fail</th><th>Pass Rate</th><th>Detail</th><tr>");        
        sb.append("<td>test����</td><td>10</td><td>8</td><td>2</td><td>80%</td> <td>���Ҳ鿴����</td></tr>");         
        sb.append("</table></div>");
        //���岿�����div
        sb.append("<div id=\"detail\">");
        sb.append("<h3>Detail</h3>");
        sb.append("</div>");
        //���岿������div���ڶ���Table
        sb.append("<div class=\"detailTable\">");
        sb.append("<table width=\"800\"  height=\"50\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;\">");
        sb.append("<th>CaseName</th><th>StartTime</th><th>EndTime</th><th>Result</th><th>FailReason</th><th>LogPath</th><tr>");        
        sb.append("<td>test_01_Camera</td><td>2019/4/11 16:33</td><td>2019/4/11 17:33</td><td>Pass</td><td>NA</td> <td>D:\\CYY\\Android</td></tr>");         
        sb.append("<td>test_02_Camera</td><td>2019/4/11 16:33</td><td>2019/4/11 17:33</td><td>Pass</td><td>NA</td> <td>D:\\CYY\\Android</td></tr>");  
        sb.append("</table></div>");
        
        //
        sb.append("</div></body></html>");       
        pw.println(sb.toString());
	}
	

	public void xml() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		Document doc=builder.parse(new File("D:\\CYY\\eclipse\\java-2018-12\\eclipse-workspace\\GetReport\\report.xml"));
		
		//��ȡ���ڵ�
		Element root=doc.getDocumentElement();
		
		Node Detail=root.getElementsByTagName("Detail").item(0);	
		
		Node CaseName=((Element)Detail).getElementsByTagName("CaseName").item(0);
		
		System.out.print(CaseName.getTextContent());
		
	}
	
	public String xml1(Element root,String name,int index) {
		String a;
		a=root.getElementsByTagName(name).item(index).getBaseURI();
		return a;
	}

	
	
}
