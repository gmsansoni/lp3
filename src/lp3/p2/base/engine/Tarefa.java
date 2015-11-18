package lp3.p2.base.engine;

import java.util.TimerTask;


public class Tarefa extends TimerTask{
	
	Jogo2 jogo2;
	
	public Tarefa(Jogo2 jogo)
	{
		this.jogo2 = jogo;
	}

	@Override
	public void run() {
		
		jogo2.encerraJogo();
		
	}

}
