package characters;

import java.util.*;
import items.*;


public class Personagem extends Entidade{
	

	public class Mochila{
		int capacidade = 40;
		int usado = 0;
		ArrayList<Item> items = new ArrayList <Item>();
		
		
		public void adicionarItem(Item item){
			if(usado < capacidade) {
				items.add(item);
				usado++;
			}
		}
		
		public void deletarItem(Item item) {
			for(Item i : items) {
				if (i.id == item.id) {
					items.remove(i);
				}
			}
			
		}
		
		public void listar() {
			for(Item i : items) {
				System.out.println("Name: " + i.name);
				System.out.println("Description: " + i.description);
			}
		}
		public Mochila() {
			
		}
	}
	
	
	public Mochila mochila;
	
	public Personagem(String nome, String genero) {
		super(nome);
		this.gender = genero;
		this.mochila = new Mochila();
		// TODO Auto-generated constructor stub
	}

	String gender;
	int experiencia;
	
	
	
	
	
	

}
