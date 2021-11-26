package main;

import entities.Client;
import entities.Service;
import structures.HashTable;

public class Main {

	public static void main(String[] args) {
		
		HashTable<String, Client> clients = new HashTable<String, Client>();
		
		//O cliente precisa de pelo menos um servico para ser cadastradp
		// Entao é criado um primeiro servico para esse cliente 
		Service c1s1 = new Service(1, "banner", 1, "em andamento");
		
		//Criando o cliente e atrelando o servico 1 a ele
		Client c1 = new Client("Wellington Araujo", "Crateus CE", "67834590012", c1s1);
		
	
		//Cadastrando o cliente 1 na base de dados
		clients.put("67834590012", c1);
		
		//Buscando o cliente 1 pelo CPF 
		Client c = clients.get("67834590012");
		
		
		//Criando um segundo servico 2 e ao cliente 1
		Service c1s2 = new Service(2,  "logo", 1, "em andamento");
		c.addService(c1s2);
		
		
		//Buscando o servico 2 pelo numero identificador e alterando a quantidade do mesmo
		Service s = clients.get("67834590012").getService(2);
		s.setQuantity(4);

		//Exibindo todos os serviços do cliente 1
		clients.get("67834590012").getServices().inOrder();
		
	}

}
