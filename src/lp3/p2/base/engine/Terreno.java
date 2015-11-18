package lp3.p2.base.engine;


public class Terreno{
	
	private int id;
	private String nome;
	private String tipo;
	private int valor_de_compra;
	private int valor_do_aluguel;
	private boolean tem_casa;
	private Jogador dono;
	private String regiao;
	
	
	public Terreno(int id, String nome, String tipo, int valor_de_compra, int valor_de_aluguel, String regiao)
	{
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.valor_de_compra = valor_de_compra;
		this.valor_do_aluguel = valor_de_aluguel;
		this.regiao = regiao;
		tem_casa = false;
		dono = null;
	}

	public int getValorDoAluguel()
	{
		if(tem_casa) return valor_do_aluguel*4;
		else return valor_do_aluguel;
	}	
	
	public Jogador getDono()
	{
		return dono;
	}

	public boolean isTem_casa() {
		return tem_casa;
	}

	public void setTem_casa(boolean tem_casa) {
		this.tem_casa = tem_casa;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getValor_de_compra() {
		return valor_de_compra;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setDono(Jogador dono) {
		this.dono = dono;
	}

	public String getTipo() {
		return tipo;
	}
	
	
	
	
}
