package lp3.p2.base.engine;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Jogo {
	
	private Tabuleiro tabuleiro;
	private ArrayList<Jogador> listaJogadores;
	private int dado;
	private Noticia noticia;
	private Random rand;
	public boolean rodando = true;
	private final boolean DEBUG = true;
	private ImageIcon imagem_dado;
	public Timer timer;
	public long tempo_de_jogo;
	
	public Jogo (long tempo_de_jogo)
	{
		//this.gui=gui;
		rand = new Random();
		tabuleiro = new Tabuleiro();
		listaJogadores = new ArrayList<Jogador>();
		imagem_dado = new ImageIcon("src/res/dado.jpg");
		timer = new Timer();
		//timer.schedule(new Tarefa(this), tempo_de_jogo);
	}
	
	public void cadastraJogador(Jogador jogador)
	{
		listaJogadores.add(jogador);
	}
	
	public void iniciaJogo()
	{		
		
		Jogador jogadorAtual;
		int posicaoAtual;
		Terreno terrenoAtual;
		
		//ciclo de uma rodada com todos os jogadores jogando uma vez
		//---------------NUCLEO DA EXECUCAO-------------------
		//Todo o fluxo sera seguido aqui
		while(rodando)
		{
			for (int i=0; i<listaJogadores.size(); i++){
				if(!rodando)break;
				//Verificar a��es pr� dado
				jogadorAtual = listaJogadores.get(i);
				if(DEBUG)System.out.println("O jogador atual e: "+jogadorAtual.getNome());
				if(DEBUG)System.out.println("Saldo do jogador "+jogadorAtual.getNome()+": "+jogadorAtual.getSaldo());
				posicaoAtual = jogadorAtual.getPosicao();
				if(DEBUG)System.out.println("A posicao atual e: "+jogadorAtual.getPosicao());
				terrenoAtual = tabuleiro.getTabuleiro().get(posicaoAtual);
				if(DEBUG)System.out.println("O terreno atual e: "+tabuleiro.getTabuleiro().get(posicaoAtual).getNome());
				
				//se o jogador est� preso
				if(jogadorAtual.isEsta_preso())
				{
					jogadorAtual.setEsta_preso(false);
					jogadorAtual.setSaldo(jogadorAtual.getSaldo()-50);
					
					verificaFalencia(jogadorAtual);
				}
				else
				{
					
					//Aguardar aqui at� o jogador clicar no bot�o do dado
					
					//AQUI � A PARTE DE MANIPULAR O DADO. REMOVER ESSE COMENTARIO DEPOIS DE TESTAR!
					/*
					JOptionPane.showMessageDialog(null, "Clique para jogar o dado", "Sua vez", JOptionPane.INFORMATION_MESSAGE, imagem_dado);
					
					passo2(jogadorAtual);
					*/
					
					//INICIO DO TESTE
					
					dado = Integer.parseInt(JOptionPane.showInputDialog("Qual o valor do dado?"));
					anda(dado, jogadorAtual);
					
					//FIM DO TESTE
					
					
					//atualiza a posicaoAtual
					posicaoAtual = jogadorAtual.getPosicao();
					
					//atualiza o terrenoAtual e verifica
					terrenoAtual = tabuleiro.getTabuleiro().get(posicaoAtual);
					
					if(DEBUG)System.out.println("A posicao atual e: "+jogadorAtual.getPosicao());
					
					if(DEBUG)System.out.println("O terreno atual e: "+tabuleiro.getTabuleiro().get(posicaoAtual).getNome());
					
					if(DEBUG)
					{
						System.out.print("Lista de terrenos: [");
						for(int k=0;k<jogadorAtual.getListaTerreno().size();k++)
						{
							System.out.print(jogadorAtual.getlistaTerreno().get(k).getNome());
						}
						System.out.print("]\n");
					}
					
					
					// verificar tipo do terreno
					passo3(jogadorAtual,terrenoAtual);
					
					
					//se o jogador quiser colocar casa
					passo1(jogadorAtual, terrenoAtual);
					
					
				}
				if(DEBUG)System.out.println("Saldo do jogador "+jogadorAtual.getNome()+": "+jogadorAtual.getSaldo());
				if(DEBUG)System.out.println("==============================");
			}
			if(DEBUG)System.out.println("=========================================================");
		}
		
	}
	
	public void encerraJogo()
	{
		rodando = false;
		JOptionPane.showMessageDialog(null, "Acabou o tempo. O jogo acabou!", "Fim do Jogo", JOptionPane.PLAIN_MESSAGE);
		verificaVencedor();
		
	}
	
	public void verificaVencedor()
	{
		Jogador jogadorTemp;
		Terreno terrenoTemp;
		String vencedor = "";
		int acumulador=0;
		int valor = 0;
		
		for(int i=0;i<listaJogadores.size();i++)
		{
			jogadorTemp = listaJogadores.get(i);
			
			acumulador += jogadorTemp.getSaldo();
			
			for(int j=0;j<jogadorTemp.getListaTerreno().size();j++)
			{
				terrenoTemp = jogadorTemp.getListaTerreno().get(j);
				if(terrenoTemp.isTem_casa()) acumulador += 100;
				acumulador += terrenoTemp.getValor_de_compra();
			}
			
			if(acumulador >= valor)
				{
					valor = acumulador;
					vencedor = jogadorTemp.getNome();
				}
			acumulador = 0;
		}
		JOptionPane.showMessageDialog(null, "O jogador "+vencedor+" foi o vencedor!", "Fim do Jogo", JOptionPane.PLAIN_MESSAGE);
	}
	
	//se o jogador quer comprar a casa
	public boolean passo1(Jogador jogadorAtual, Terreno terrenoAtual)
	{
		if(!terrenoAtual.isTem_casa())
		{
			if(jogadorAtual.possuiTerrenosDaMesmaRegiao(terrenoAtual.getRegiao()))
			{
				// verifica se o jogador tem saldo para a compra
				if(verificaSaldoJogador(200, jogadorAtual)){
					//verifica se o jogador quer efetuar a compra da casa
					if (jogadorAceitaCompra()){
						colocaCasa(terrenoAtual);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	//Lancar dado para andar
	public void passo2(Jogador jogadorAtual){
		dado = (rand.nextInt(5))+1;
		
		if(DEBUG)System.out.println("Jogador "+jogadorAtual.getNome()+" jogou o dado e tirou "+dado);
		
		//TODO Aqui ter� que ser feito o objeto 3d se deslocando
		anda(dado, jogadorAtual);
	}
	
	public void passo3(Jogador jogadorAtual, Terreno terrenoAtual)
	{
		String tipo = terrenoAtual.getTipo();
		Jogador jogadorAlvo = null;
		
		if(tipo.contentEquals("Noticia"))
		{
			noticia = new Noticia();
			if(noticia.isSorte())
			{
				//mostra a mensagem na tela (chama-se a gui e passa a String mensagem)
				JOptionPane.showMessageDialog(null, noticia.getMensagem(), "Noticia", JOptionPane.PLAIN_MESSAGE);
				jogadorAtual.setSaldo(jogadorAtual.getSaldo()+noticia.getValor());
			}
			if(!noticia.isSorte())
			{
				//mostra a mensagem na tela (chama-se a gui e passa a String mensagem)
				JOptionPane.showMessageDialog(null, noticia.getMensagem(), "Noticia", JOptionPane.PLAIN_MESSAGE);
				jogadorAtual.setSaldo(jogadorAtual.getSaldo()-noticia.getValor());
				verificaFalencia(jogadorAtual);
			}
		}
		if(tipo.contentEquals("Prisao"))
		{
			// va para a prisao
			if(jogadorAtual.getPosicao() == 6)
			{
				JOptionPane.showMessageDialog(null, "Va para a prisao", "Prisao", JOptionPane.PLAIN_MESSAGE);
				vaParaPrisao(jogadorAtual);
				jogadorAtual.setEsta_preso(true);
			}
			// somente visitando
			else
			{
				JOptionPane.showMessageDialog(null, "Voce esta visitando a prisao", "Prisao", JOptionPane.PLAIN_MESSAGE);
			}
		}
		if(tipo.contentEquals("Imovel"))
		{
			int debito = 0;

			// verifica o dono do im�vel
			for(int i=0;i<listaJogadores.size();i++)
			{
				if(listaJogadores.get(i).possuiTerreno(terrenoAtual.getId()))
				{
					jogadorAlvo = listaJogadores.get(i);
				}
			}
			
			// terreno nao possui dono
			if(jogadorAlvo == null)
			{
				//pergunta se o jogadorAtual quer comprar
				jogadorCompraTerreno(jogadorAtual, terrenoAtual);
			}
			else
			{
				//jogadorAlvo possui o terreno. Cobra-se Aluguel
				if(jogadorAtual.getId() != jogadorAlvo.getId())
				{
					debito = terrenoAtual.getValorDoAluguel();
					
					if(DEBUG) System.out.println("Jogador "+jogadorAlvo.getNome()+" possui o terreno "+terrenoAtual.getNome());
					
					if(DEBUG)System.out.println("Saldo do jogador "+jogadorAlvo.getNome()+": "+jogadorAlvo.getSaldo());
					if(DEBUG)System.out.println("Saldo do jogador "+jogadorAtual.getNome()+": "+jogadorAtual.getSaldo());
					
					jogadorAtual.setSaldo(jogadorAtual.getSaldo()-debito);
					jogadorAlvo.setSaldo(jogadorAlvo.getSaldo()+debito);
					
					if(DEBUG)System.out.println("Saldo do jogador "+jogadorAlvo.getNome()+": "+jogadorAlvo.getSaldo());
					if(DEBUG)System.out.println("Saldo do jogador "+jogadorAtual.getNome()+": "+jogadorAtual.getSaldo());
					
					
					verificaFalencia(jogadorAtual);
				}
				else
				{
					//jogadorAtual j� possui o terreno!
				}
			}
		}
	}
	
	public void hipotecaCasa(Jogador jogadorAtual, Terreno terrenoAtual)
	{
		for(int i=0;i<jogadorAtual.getlistaTerreno().size();i++)
		{
			if(jogadorAtual.getlistaTerreno().get(i).getId() == terrenoAtual.getId())
			{
				jogadorAtual.getlistaTerreno().get(i).setTem_casa(false);
				jogadorAtual.setSaldo(jogadorAtual.getSaldo()+150);
			}
		}
	}
	
	public void hipotecaTerreno(Jogador jogadorAtual, Terreno terrenoAtual)
	{
		int temp;
		for(int i=0;i<jogadorAtual.getlistaTerreno().size();i++)
		{
			if(jogadorAtual.getlistaTerreno().get(i).getId() == terrenoAtual.getId())
			{
				jogadorAtual.getlistaTerreno().remove(i);
				temp = (int) (jogadorAtual.getSaldo()+((terrenoAtual.getValor_de_compra())*0.75));
				jogadorAtual.setSaldo(temp);
			}
		}
	}
	
	public boolean verificaSaldoJogador(int saldo, Jogador jogador){
		if (jogador.getSaldo()>=saldo) return true;
		else return false;
	}
	
	public void colocaCasa(Terreno terrenoAtual)
        {
		
		terrenoAtual.setTem_casa(true);
	}
	
	public boolean jogadorAceitaCompra(){
		int valor = -1;
		valor = JOptionPane.showConfirmDialog(null,  "Mensagem", "Titulo", JOptionPane.YES_NO_OPTION);
		if (valor == 0) return true;
		else return false;
	}
	
	public void jogadorCompraTerreno(Jogador jogadorAtual, Terreno terrenoAtual)
	{
		// verifica se o jogador tem saldo para a compra
		if(jogadorAtual.getSaldo() >= terrenoAtual.getValor_de_compra())
		{
			int resposta = JOptionPane.showConfirmDialog(null,  "Voce deseja comprar este Terreno?", "Compra de Terreno", JOptionPane.YES_NO_OPTION);
			
			//Comprou o Terreno
			if(resposta == 0)
			{
				jogadorAtual.setSaldo(jogadorAtual.getSaldo()-terrenoAtual.getValor_de_compra());
				jogadorAtual.getlistaTerreno().add(terrenoAtual);
			}
		}
	}
	
	public String[] casasParaHipoteca(Jogador jogadorAtual)
	{
		ArrayList<String> lista = new ArrayList<String>();
		
		for(int i=0;i<jogadorAtual.getlistaTerreno().size();i++)
		{
			if(jogadorAtual.getListaTerreno().get(i).isTem_casa())lista.add(jogadorAtual.getListaTerreno().get(i).getNome());
		}
		
		String[] temp = new String[lista.size()];
		for(int i=0;i<lista.size();i++)
		{
			temp[i] = lista.get(i);
		}
		
		if(temp.length>0) return temp;
		else return null;
	}
	
	public String[] terrenosParaHipoteca(Jogador jogadorAtual)
	{
		ArrayList<String> lista = new ArrayList<String>();
		
		for(int i=0;i<jogadorAtual.getlistaTerreno().size();i++)
		{
			lista.add(jogadorAtual.getListaTerreno().get(i).getNome());
		}
		
		String[] temp = new String[lista.size()];
		for(int i=0;i<lista.size();i++)
		{
			temp[i] = lista.get(i);
		}
		
		if(temp.length>0) return temp;
		else return null;
	}
	
	public Terreno terrenoPorNome(Jogador jogadorAtual, String nome)
	{
		for(int i=0;i<jogadorAtual.getListaTerreno().size();i++)
		{
			if(jogadorAtual.getListaTerreno().get(i).getNome() == nome) return jogadorAtual.getListaTerreno().get(i); 
		}
		return null;
	}
	
	public int verificaHipotecaCasas(Jogador jogadorAtual)
	{
		boolean temp = true;
		
		//Hipoteca de Casas
		while(temp)
		{
			if(jogadorAtual.getSaldo()<0)
			{
				//verifica se o jogador possui terrenos para serem hipotecados
				if(jogadorAtual.getlistaTerreno().size()>0)
				{
					String[] lista = casasParaHipoteca(jogadorAtual);
					String selecaoLista;
					Terreno terrenoTemp;
					if(lista!=null)
					{
						selecaoLista = (String) JOptionPane.showInputDialog(null, "Casas dos Terrenos a serem hipotecadas", "Hipoteca de Casa", JOptionPane.OK_OPTION, null, lista, null);
						terrenoTemp = terrenoPorNome(jogadorAtual, selecaoLista);
						if(terrenoTemp!= null) hipotecaCasa(jogadorAtual, terrenoTemp);
					}
					else temp = false;
				}
				//FALENCIA
				else return 666;
			}
			else temp = false;
		}
		return 0;
	}
	
	public int verificaHipotecaTerrenos(Jogador jogadorAtual)
	{
		boolean temp = true;
		
		//Hipoteca de Terrenos
		while(temp)
		{
			if(jogadorAtual.getSaldo()<0)
			{
				if(jogadorAtual.getlistaTerreno().size()>0)
				{
					String[] lista = terrenosParaHipoteca(jogadorAtual);
					String selecaoLista;
					Terreno terrenoTemp;
					if(lista!=null)
					{
						selecaoLista = (String) JOptionPane.showInputDialog(null, "Terrenos a serem hipotecados", "Hipoteca de Terreno", JOptionPane.OK_OPTION, null, lista, null);
						terrenoTemp = terrenoPorNome(jogadorAtual, selecaoLista);
						if(terrenoTemp!= null) hipotecaTerreno(jogadorAtual, terrenoTemp);
					}
					else temp = false;
				}
				//FALENCIA
				else return 666;
			}
			else temp = false;
		}
		return 0;
	}
	
	public void faliu(Jogador jogadorAtual)
	{
		JOptionPane.showMessageDialog(null, "Jogador "+jogadorAtual.getNome()+" faliu!", "Falencia", JOptionPane.PLAIN_MESSAGE);
		listaJogadores.remove(jogadorAtual);
		verificaContinuabilidadeDoJogo();
	}
	
	public void verificaFalencia(Jogador jogadorAtual)
	{
		if(verificaHipotecaCasas(jogadorAtual)== 666)
		{
			faliu(jogadorAtual);
		}
		
		if(verificaHipotecaTerrenos(jogadorAtual)==666)
		{
			faliu(jogadorAtual);
		}
	}
	
	public void verificaContinuabilidadeDoJogo()
	{
		if(listaJogadores.size()==1)
		{
			JOptionPane.showMessageDialog(null, "Jogador "+listaJogadores.get(0).getNome()+" venceu o jogo! Parabens!", "Fim do Jogo", JOptionPane.PLAIN_MESSAGE);
			rodando = false;
		}
	}
	
	public void anda(int valorDado, Jogador jogadorAtual){
		int posicaoAtual;

posicaoAtual = jogadorAtual.getPosicao();

//TODO fazer aqui a anima��o 3d se movimentar

for(int i=0;i<valorDado;i++)
{
posicaoAtual++;

if(posicaoAtual == 8 )
{
posicaoAtual = 0;
jogadorAtual.setSaldo(jogadorAtual.getSaldo()+30);

}

}
jogadorAtual.setPosicao(posicaoAtual);
	}
	
	public void vaParaPrisao(Jogador jogadorAtual){
		//TODO fazer aqui a anima��o 3d se movimentar
		jogadorAtual.setPosicao(2);
	}

}
