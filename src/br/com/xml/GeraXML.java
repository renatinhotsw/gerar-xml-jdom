package br.com.xml;

import java.io.IOException;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

public class GeraXML {

	public static void main(String[] args) {
		
		//Declara elementos que irao compor o xml
		Element mural = new Element("mural");
		
		Element mensagem = new Element("mensagem");
		Element para = new Element("para");
		Element de = new Element("de");
		Element corpo = new Element("corpo");
		
		//setando os atributos
		mensagem.setAttribute("id","01");
		
		//"Setando" outro atributo agora utilizando da classe Attribute  
		Attribute priori = new Attribute("prioridade", "-1");
		mensagem.setAttribute(priori);
		
		de.setText("Fernanda@gmail.com");
		para.setText("renato@gmail.com");
		corpo.setText("Estou precisando do relatório 87/17, aguardo retorno");
		
		mensagem.addContent(para);
		mensagem.addContent(de);
		mensagem.addContent(corpo);
		
		mural.addContent(mensagem);
		
		//criando o documento xml montado
		Document doc = new Document();
		doc.setRootElement(mural); //define o elemento root (principal)
		
		try {
			//Imprime o xml
			XMLOutputter xout = new XMLOutputter();
			xout.output(doc, System.out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
