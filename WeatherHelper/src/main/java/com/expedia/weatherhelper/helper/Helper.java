package com.expedia.weatherhelper.helper;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.expedia.weatherhelper.form.City;


public class Helper {
	
	public City getCityInfo(int zipCode){
		String url="http://api.wunderground.com/api/ed044d75b91fb500/conditions/q/"+zipCode+".xml";
		HttpClient client= new HttpClient();
		PostMethod method= new PostMethod(url);
		City outCity= new City();
		try {			
			client.executeMethod(method);
			String response=method.getResponseBodyAsString();
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document doc=builder.parse(new ByteArrayInputStream(response.getBytes("utf-8")));
			NodeList errors=doc.getElementsByTagName("error");
			if(errors!=null && errors.getLength()>0){
				return null;
			}
			NodeList displayLocNodes=doc.getElementsByTagName("display_location");
			if(displayLocNodes!=null && displayLocNodes.getLength()>0){
				Node displayLocNode=displayLocNodes.item(0);
				if(displayLocNode.getNodeType()==Node.ELEMENT_NODE){
					Element element=(Element)displayLocNode;
					String cityName= element.getElementsByTagName("city").item(0).getTextContent();
					String state= element.getElementsByTagName("state_name").item(0).getTextContent();
					outCity.setCityName(cityName);
					outCity.setState(state);
				}
			}
			float tempInF=Float.parseFloat(doc.getElementsByTagName("temp_f").item(0).getTextContent());
			outCity.setTempInF(tempInF);
			outCity.setZipCode(zipCode);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outCity;
	}

}
