package br.com.xml;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class ReadXML {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		//nome e local do arquivo a ser lido
		File f = new File("d:/mural.xml");
		
		//Criamos uma classe SAXBuilder que vai processar o XML4 
		SAXBuilder sb = new SAXBuilder();
		
		try {
			//Este documento agora possui toda a estrutura do arquivo.
			Document d = sb.build(f);
			
			//Pega o elemento root
			Element mural = d.getRootElement();
			
			//recuperamos os elementos filhos (children)
			List elements = mural.getChildren();
			Iterator i = elements.iterator();
			
			//Iteramos com os elementos filhos, e filhos do dos filhos
			while(i.hasNext()){
				Element element = (Element)i.next();
				System.out.println("Código: "+element.getAttributeValue("id"));
				System.out.println("Prioridade: "+element.getAttributeValue("prioridade"));
				System.out.println("Para: "+element.getChildText("para"));
				System.out.println("De: "+element.getChildText("de"));
				System.out.println("corpo: "+element.getChildText("corpo"));
			}
			
			
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
