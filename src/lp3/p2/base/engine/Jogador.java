package lp3.p2.base.engine;

import java.util.ArrayList;


public class Jogador {
	
	private int id;
	private String nome;
	private int saldo;
	private String pino;
	private ArrayList<Terreno> listaTerreno;
	private int posicao;
	private boolean esta_preso;
	
	public Jogador(int id, String nome, String pino)
	{
		this.id = id;
		this.nome = nome;
		this.pino = pino;
		saldo = 700;
		listaTerreno = new ArrayList<Terreno>();
		posicao = 0;
		esta_preso = false;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public ArrayList<Terreno> getlistaTerreno() {
		return listaTerreno;
	}

	public void setlistaTerreno(ArrayList<Terreno> listaTerreno) {
		this.listaTerreno = listaTerreno;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public boolean isEsta_preso() {
		return esta_preso;
	}

	public void setEsta_preso(boolean esta_preso) {
		this.esta_preso = esta_preso;
	}
	
	public boolean possuiTerrenosDaMesmaRegiao(String regiao){		
		int c =0;
		for (int i=0; i<listaTerreno.size(); i++){
			if(listaTerreno.get(i).getRegiao().contains(regiao))c++;
		}
		if(c==2){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean possuiTerreno(int id)
	{
		for (int i=0; i<listaTerreno.size(); i++){
			if(listaTerreno.get(i).getId() == id)return true;
		}
		return false;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public ArrayList<Terreno> getListaTerreno() {
		return listaTerreno;
	}

	public String getPino() {
		return pino;
	}

	public void setPino(String pino) {
		this.pino = pino;
	}

	
}
