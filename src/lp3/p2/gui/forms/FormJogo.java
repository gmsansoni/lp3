package lp3.p2.gui.forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import lp3.p2.base.classes.Dado;
import lp3.p2.base.engine.Jogador;
import lp3.p2.base.engine.Jogo2;
import lp3.p2.base.gui.FormGenerico;
import lp3.p2.gui.toolbars.FormToolbarJogo;


public class FormJogo extends FormGenerico implements ActionListener,PropertyChangeListener,ItemListener, FocusListener  {

	private static final long serialVersionUID = 1L;
	protected FormToolbarJogo barra = null;
    private JFrame fatherFrame;
    protected String operacaoRealizada = null;
    
	private JLabel lblTitulo;
	private JLabel lblNomeJogadorAtual;
	private JLabel lblJogadorAtual;
	private JLabel lblCorPeaoAtual;
	private JLabel lblCorAtual;    
	private JLabel lblSaldoJogAtual;
	private JLabel lblSaldo;
	private JLabel ibiTerreno;
	private JLabel lblVlrTerreno;
	private JLabel lblDado;
	private JLabel lblValorDado;
	private JLabel lblVlrPosicao;
	private JLabel lblPosicao;
	private Jogador jogador1,jogador2,jogador3;
	private Integer qtdeJog=0;
	private Integer controlaJogador=0;
	protected Jogo2 engine;
	protected Dado dadinho = new Dado();
	
	public FormJogo(JFrame Openerframe,Jogador jog1,Jogador jog2){
		
		fatherFrame = Openerframe;
		jogador1 = jog1;
		jogador2 = jog2;
		qtdeJog=2;
	    engine = new Jogo2(300000);
	    engine.cadastraJogador(jogador1);
	    engine.cadastraJogador(jogador2);
	    
}

	public FormJogo(JFrame Openerframe,Jogador jog1,Jogador jog2,Jogador jog3){
		
		fatherFrame = Openerframe;
		jogador1 = jog1;
		jogador2 = jog2;
		jogador3 = jog3;
		qtdeJog=3;
		engine = new Jogo2(300000);
	    engine.cadastraJogador(jogador1);
	    engine.cadastraJogador(jogador2);
	    engine.cadastraJogador(jogador3);
	    
}

    public void inicializar() throws ParseException{
    	
    	this.createGUI("Jogo");
		this.conteudoForm();
		this.showGUI(false);
	
		// ToolBar
		barra = new FormToolbarJogo(this.frame);
		barra.setImgsPath("images/");
	    barra.setListener(this);
	    barra.createToolBar();
	    barra.visibleNavigationButtons(true);
	    barra.visibleServiceButtons(false);
	    barra.visibleEditButtons(false);
	    
	    barra.visibleButton(0, false);
	    barra.visibleButton(1, false);
	    barra.visibleButton(3, false);
	    barra.visibleButton(12, false);
	    barra.visibleButton(2, false);
	    barra.visibleButton(11, false);
	    barra.visibleJogoButtons(true);
	    barra.visibleButton(16, false);
	    barra.visibleButton(17, false);
	    fatherFrame.setVisible(false);
	    
	    engine.setupInfo(controlaJogador);
	    //engine.iniciaJogo();
	    this.preencherParticipanteAtual();
    }

	private void conteudoForm() {
		lblTitulo				= new JLabel("Console de Jogo");
		lblJogadorAtual			= new JLabel("Nome do Jogador Atual");
        lblNomeJogadorAtual  	= new JLabel();
        lblCorPeaoAtual			= new JLabel("Cor do Pe�o Atual");
        lblCorAtual				= new JLabel();    
        lblSaldoJogAtual		= new JLabel("Saldo do Jogador");
        lblSaldo		   		= new JLabel();
        ibiTerreno	   			= new JLabel("Terreno Atual");
        lblVlrTerreno				= new JLabel();
        lblDado   			  	= new JLabel("Valor do Dado");
        lblValorDado	    	= new JLabel();
        lblVlrPosicao  			= new JLabel();
        lblPosicao    			= new JLabel("Posi��o");

        contentPane.add(lblTitulo);
        contentPane.add(lblJogadorAtual);
        contentPane.add(lblNomeJogadorAtual);
        contentPane.add(lblCorPeaoAtual);
        contentPane.add(lblCorAtual);
        contentPane.add(lblSaldoJogAtual);
        contentPane.add(lblSaldo);
        contentPane.add(lblVlrTerreno);
        contentPane.add(ibiTerreno);
        contentPane.add(lblDado);
        contentPane.add(lblValorDado);
        contentPane.add(lblVlrPosicao);
        contentPane.add(lblPosicao);
        
        layout.putConstraint(SpringLayout.WEST,lblTitulo,480,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblTitulo,55,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,lblJogadorAtual,20,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblJogadorAtual,80,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,lblNomeJogadorAtual,20,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblNomeJogadorAtual,100,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,lblCorPeaoAtual,250,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblCorPeaoAtual,80,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,lblCorAtual,250,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblCorAtual,100,SpringLayout.NORTH, contentPane);
                
        layout.putConstraint(SpringLayout.WEST,lblSaldoJogAtual,480,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblSaldoJogAtual,80,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,lblSaldo,480,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblSaldo,100,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,ibiTerreno,20,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,ibiTerreno,600,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,lblVlrTerreno,20,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblVlrTerreno,620,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,lblDado,250,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblDado,600,SpringLayout.NORTH, contentPane);
	
        layout.putConstraint(SpringLayout.WEST,lblValorDado,250,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblValorDado,620,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,lblPosicao,480,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblPosicao,600,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,lblVlrPosicao,480,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblVlrPosicao,620,SpringLayout.NORTH, contentPane);

	}
	
	private void closeButtonClick(){
		engine.timer.cancel();
		engine.encerraJogo();
		fatherFrame.setVisible(true);
    	frame.dispose();
	}
	
	private void dadosButtonClick(){
		
		dadinho.obterValor();
		lblValorDado.setText(dadinho.getValorExibido());
		engine.anda(dadinho.getValorDado(), engine.getJogadorAtual());
		engine.setupInfo(controlaJogador);
		this.preencherParticipanteAtual();
		//engine.listaTerrenos();
		engine.passo3(engine.getJogadorAtual(), engine.getTerrenoAtual());
		engine.passo1(engine.getJogadorAtual(), engine.getTerrenoAtual());
		this.preencherParticipanteAtual();
		
		if(qtdeJog==2){
			if(controlaJogador==0){
				controlaJogador++;
				engine.setupInfo(controlaJogador);
				this.preencherParticipanteAtual();
				this.lblValorDado.setText("");
			}
			else{
				controlaJogador=0;
				engine.setupInfo(controlaJogador);
				this.preencherParticipanteAtual();
				this.lblValorDado.setText("");
			}
		}
		if(qtdeJog==3){
			if(controlaJogador<2){
				controlaJogador++;
				engine.setupInfo(controlaJogador);
				this.preencherParticipanteAtual();
				this.lblValorDado.setText("");
			}
			else{
				controlaJogador=0;
				engine.setupInfo(controlaJogador);
				this.preencherParticipanteAtual();
				this.lblValorDado.setText("");
			}
		}
		
	
		
		
	}
	
	private void comprarButtonClick(){
		
		
	}
	
	private void alugarButtonClick(){
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String cmd = arg0.getActionCommand();

		if (barra.getCLOSE().equals(cmd)) {
		   	closeButtonClick();
		}
		if (barra.getDADOS().equals(cmd)) {
		   	dadosButtonClick();
		}
		if (barra.getCOMPRAR().equals(cmd)) {
		   	comprarButtonClick();
		}
		if (barra.getALUGAR().equals(cmd)) {
		   	alugarButtonClick();
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}
		
	
	public void preencherParticipanteAtual(){
	   lblNomeJogadorAtual.setText(engine.getJogadorAtual().getNome());
	   lblSaldo.setText(String.valueOf(engine.getJogadorAtual().getSaldo()));
	   lblCorAtual.setText(engine.getJogadorAtual().getPino());
	   lblVlrPosicao.setText(String.valueOf(engine.getPosicaoAtual()));
	   lblVlrTerreno.setText(String.valueOf(engine.getTerrenoAtual().getNome()));
	   
	}

}
