package br.com.caelum.goodbuy;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Resource;

@Resource
public class Mundo {
	
	public String boasVindas() {
		return "ol� mundo!";
	   }
	
	public void teste(){
		System.out.println("teste agora");
	}
	
	 public List<String> paises() {
	     List<String> result = new ArrayList<String>();
	     result.add("Brasil");
	     result.add("Portugal");
	     result.add("Jap�o");
	     result.add("Canad�");
	     result.add("Paraguai");
	     return result;
	   }
	 
	 public int testeInteiros(){
		 return 52;
	 }
}
