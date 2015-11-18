package lp3.p2.base.classes;

public class Jogador {

	private String Nome;
	private String Peao;
	private Integer Saldo;
	private Integer PosicaoAtual;
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getPeao() {
		return Peao;
	}
	public void setPeao(String peao) {
		Peao = peao;
	}
	public Integer getSaldo() {
		return Saldo;
	}
	public void setSaldo(Integer saldo) {
		Saldo = saldo;
	}
	public Integer getPosicaoAtual() {
		return PosicaoAtual;
	}
	public void setPosicaoAtual(Integer posicaoAtual) {
		PosicaoAtual = posicaoAtual;
	}
	
}
