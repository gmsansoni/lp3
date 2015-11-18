package lp3.p2.base.engine;

import java.util.ArrayList;


public class Tabuleiro {

	private ArrayList<Terreno> tabuleiro;
	private Terreno terreno;
	
	
	public Tabuleiro()
	{
		tabuleiro = new ArrayList<Terreno>();
		
		terreno = new Terreno(0, "Inicio", "Inicio", 0, 0, "Inicio");
		tabuleiro.add(0, terreno);
		
		terreno = new Terreno(1, "Liberdade", "Imovel", 400, 70, "Japao");
		tabuleiro.add(1, terreno);
		
		terreno = new Terreno(2, "Prisao", "Prisao", 0, 0, "Prisao");
		tabuleiro.add(2, terreno);
		
		terreno = new Terreno(3, "Parada Inglesa", "Imovel", 500, 75, "Inglaterra");
		tabuleiro.add(3, terreno);
		
		terreno = new Terreno(4, "Saude", "Imovel", 400, 70, "Japao");
		tabuleiro.add(4, terreno);
		
		terreno = new Terreno(5, "Noticia", "Noticia", 0, 0, "Noticia");
		tabuleiro.add(5, terreno);
		
		terreno = new Terreno(6, "Va para Prisao", "Prisao", 0, 0, "Prisao");
		tabuleiro.add(6, terreno);
		
		terreno = new Terreno(7, "Alto da Boa Vista", "Imovel", 300, 65, "Inglaterra");
		tabuleiro.add(7, terreno);
		
		//mostraTerrenos();
	}
	
	/*
	public void mostraTerrenos()
	{
		for(int i=0;i<tabuleiro.size();i++)
		{
			System.out.println(tabuleiro.get(i).getNome());
		}
	}
	*/

	public ArrayList<Terreno> getTabuleiro() {
		return tabuleiro;
	}


	public void setTabuleiro(ArrayList<Terreno> tabuleiro) {
		this.tabuleiro = tabuleiro;
	}


	public Terreno getTerreno() {
		return terreno;
	}


	public void setTerreno(Terreno terreno) {
		this.terreno = terreno;
	}
	
}
