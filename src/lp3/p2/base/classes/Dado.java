package lp3.p2.base.classes;
//guilherme esteve aqui
//testesde alteracao
import java.util.Random;

public class Dado {
	
	private Integer valorDado = 0;
	public Integer getValorDado() {
		return valorDado;
	}
	public void setValorDado(Integer valorDado) {
		this.valorDado = valorDado;
	}
	private String valorExibido = "";

	public String getValorExibido() {
		return valorExibido;
	}
	public void setValorExibido(String valorExibido) {
		this.valorExibido = valorExibido;
	}
	public void obterValor(){
		Random random = new Random();
	
       	setValorDado(random.nextInt(7));
       	if(getValorDado()>0){
          setValorExibido(Integer.toString(getValorDado()));	
        }
        else{
        	setValorDado(1);
        	setValorExibido(Integer.toString(getValorDado()));
        }
	}
}
