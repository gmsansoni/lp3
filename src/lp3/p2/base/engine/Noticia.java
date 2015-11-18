package lp3.p2.base.engine;

import java.util.Random;

public class Noticia {
	
	private String mensagem;
	private int valor = 100;
	private boolean sorte;
	
	public Noticia()
	{
		Random rand = new Random();
		int temp = rand.nextInt(2);
		if(temp == 0)
			{
				sorte = true;
				mensagem = "Você tirou Sorte. Ganhe "+valor;
			}
		else
			{
				sorte = false;
				mensagem = "Você tirou Azar. Perca "+valor;
			}
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public int getValor_aleatorio() {
		return valor;
	}

	public void setValor_aleatorio(int valor_aleatorio) {
		this.valor = valor_aleatorio;
	}

	public boolean isSorte() {
		return sorte;
	}

	public void setSorte(boolean sorte) {
		this.sorte = sorte;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	

}
