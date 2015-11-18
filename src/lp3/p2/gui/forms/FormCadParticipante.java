package lp3.p2.gui.forms;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;

import lp3.p2.base.classes.relogioRegressivo;
import lp3.p2.base.engine.Jogador;
import lp3.p2.base.gui.FormGenerico;
import lp3.p2.base.util.Messages;
import lp3.p2.gui.toolbars.FrmToolBarParticipante;

public class FormCadParticipante extends FormGenerico implements ActionListener, 
															 PropertyChangeListener,
															 ItemListener, FocusListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected FrmToolBarParticipante barra = null;
    private JFrame fatherFrame;
    protected String operacaoRealizada = null;
  
    //Formats to format and parse numbers
    private JRadioButton rbParticipant2;
    private JRadioButton rbParticipant3;
    private JRadioButton rbParticipant4;
    private JRadioButton rbParticipant5;
    private JRadioButton rbParticipant6;
    
    
    private JFormattedTextField strParticipante01;
    private JFormattedTextField strParticipante02;
    private JFormattedTextField strParticipante03;
    private JFormattedTextField strParticipante04;
    private JFormattedTextField strParticipante05;
    private JFormattedTextField strParticipante06;
    private JFormattedTextField strTempo;
    
    private String Peoes[] = {"Preto","Branco","Amarelo","Azul","Vermelho","Rosa"};
    private String Horas[] = {"00","01","02","03","04","05","06","07","08","09","10","11"
    						 ,"12","13","14","15","16","17","18","19","20","21","22","23"};
    
    private String Minutos[] = {"00","01","02","03","04","05","06","07","08","09","10","11"
			 				   ,"12","13","14","15","16","17","18","19","20","21","22","23"
			 				   ,"24","25","26","27","28","29","30","31","32","33","34","35"
			 				   ,"36","37","38","39","40","41","42","43","44","45","46","47"
			 				   ,"48","49","50","51","52","53","54","55","56","57","58","59"};
    
    private Dimension 		dimensaoCombos		= new Dimension(100,25);
    private Dimension 		dimensaoTempo		= new Dimension(50,25);
    
    private String strrbParticipante02="02 Participantes";
    private String strrbParticipante03="03 Participantes";
    private String strrbParticipante04="04 Participantes";
    private String strrbParticipante05="05 Participantes";
    private String strrbParticipante06="06 Participantes";
   
	private JLabel  lblTitulo;
	private JLabel  lblParticipante01;
	private JLabel  lblParticipante02;
	private JLabel  lblParticipante03;
	private JLabel  lblParticipante04;    
	private JLabel  lblParticipante05;
	private JLabel  lblParticipante06;
	private JLabel  lblPeao1;
	private JLabel  lblPeao2;
	private JLabel  lblPeao3;
	private JLabel  lblPeao4;
	private	JLabel  lblPeao5;
	private JLabel  lblPeao6;
	private JLabel	lblNomeParticipante;
	private JLabel 	lblTempoJogo;
	private JLabel	lblSeparador1;
	private JLabel	lblSeparador2;

	private JComboBox cmbPeao1;
	private	JComboBox cmbPeao2;
    private JComboBox cmbPeao3;
    private JComboBox cmbPeao4;
    private JComboBox cmbPeao5;
    private JComboBox cmbPeao6;
    
    private JComboBox  		cmbHora;
    private JComboBox  		cmbMinutos;
    private JComboBox  		cmbSegundos;
    
    private Integer intControlaValidacao = 2;
    public 	JLabel 	lblTempoSelecionado = new JLabel();
    
    public relogioRegressivo relogio;
    protected Jogador participante1;
    protected Jogador participante2;
    protected Jogador participante3;
    
	public FormCadParticipante(JFrame Openerframe){
		
		fatherFrame = Openerframe;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {

		String cmd = arg0.getActionCommand();

		if (barra.getCLOSE().equals(cmd)) {
		   	closeButtonClick();
		}
		if (barra.getOK().equals(cmd)) {
		   	okButtonClick();
		}
		if (barra.getNEXT().equals(cmd)) {
			nextButtonClick();
		}
		if(rbParticipant2.getActionCommand().equalsIgnoreCase(cmd)){
			visible2Participants();
			intControlaValidacao = 2;
		}
		if(rbParticipant3.getActionCommand().equalsIgnoreCase(cmd)){
			visible3Participants();
			intControlaValidacao = 3;
		}
		if(rbParticipant4.getActionCommand().equalsIgnoreCase(cmd)){
			visible4Participants();
			intControlaValidacao = 4;
		}
		if(rbParticipant5.getActionCommand().equalsIgnoreCase(cmd)){
			visible5Participants();
			intControlaValidacao = 5;
		}
		
		if(rbParticipant6.getActionCommand().equalsIgnoreCase(cmd)){
			visible6Participants();
			intControlaValidacao = 6;
		}
	}
	private void visible2Participants(){

		lblParticipante01.setVisible(true);
		lblPeao1.setVisible(true);
		strParticipante01.setVisible(true);
		cmbPeao1.setVisible(true);
		
		lblParticipante02.setVisible(true);
		lblPeao2.setVisible(true);
		strParticipante02.setVisible(true);
		cmbPeao2.setVisible(true);

		lblParticipante03.setVisible(false);
		lblPeao3.setVisible(false);
		strParticipante03.setVisible(false);
		cmbPeao3.setVisible(false);

		lblParticipante04.setVisible(false);
		lblPeao4.setVisible(false);
		strParticipante04.setVisible(false);
		cmbPeao4.setVisible(false);

		lblParticipante05.setVisible(false);
		lblPeao5.setVisible(false);
		strParticipante05.setVisible(false);
		cmbPeao5.setVisible(false);

		lblParticipante06.setVisible(false);
		lblPeao6.setVisible(false);
		strParticipante06.setVisible(false);
		cmbPeao6.setVisible(false);

	}
	private void visible3Participants(){
		lblParticipante01.setVisible(true);
		lblPeao1.setVisible(true);
		strParticipante01.setVisible(true);
		cmbPeao1.setVisible(true);
		
		lblParticipante02.setVisible(true);
		lblPeao2.setVisible(true);
		strParticipante02.setVisible(true);
		cmbPeao2.setVisible(true);

		lblParticipante03.setVisible(true);
		lblPeao3.setVisible(true);
		strParticipante03.setVisible(true);
		cmbPeao3.setVisible(true);

		lblParticipante04.setVisible(false);
		lblPeao4.setVisible(false);
		strParticipante04.setVisible(false);
		cmbPeao4.setVisible(false);

		lblParticipante05.setVisible(false);
		lblPeao5.setVisible(false);
		strParticipante05.setVisible(false);
		cmbPeao5.setVisible(false);

		lblParticipante06.setVisible(false);
		lblPeao6.setVisible(false);
		strParticipante06.setVisible(false);
		cmbPeao6.setVisible(false);

	}
	private void visible4Participants(){
		lblParticipante01.setVisible(true);
		lblPeao1.setVisible(true);
		strParticipante01.setVisible(true);
		cmbPeao1.setVisible(true);
		
		lblParticipante02.setVisible(true);
		lblPeao2.setVisible(true);
		strParticipante02.setVisible(true);
		cmbPeao2.setVisible(true);

		lblParticipante03.setVisible(true);
		lblPeao3.setVisible(true);
		strParticipante03.setVisible(true);
		cmbPeao3.setVisible(true);

		lblParticipante04.setVisible(true);
		lblPeao4.setVisible(true);
		strParticipante04.setVisible(true);
		cmbPeao4.setVisible(true);

		lblParticipante05.setVisible(false);
		lblPeao5.setVisible(false);
		strParticipante05.setVisible(false);
		cmbPeao5.setVisible(false);

		lblParticipante06.setVisible(false);
		lblPeao6.setVisible(false);
		strParticipante06.setVisible(false);
		cmbPeao6.setVisible(false);

	}
	private void visible5Participants(){
		lblParticipante01.setVisible(true);
		lblPeao1.setVisible(true);
		strParticipante01.setVisible(true);
		cmbPeao1.setVisible(true);
		
		lblParticipante02.setVisible(true);
		lblPeao2.setVisible(true);
		strParticipante02.setVisible(true);
		cmbPeao2.setVisible(true);

		lblParticipante03.setVisible(true);
		lblPeao3.setVisible(true);
		strParticipante03.setVisible(true);
		cmbPeao3.setVisible(true);

		lblParticipante04.setVisible(true);
		lblPeao4.setVisible(true);
		strParticipante04.setVisible(true);
		cmbPeao4.setVisible(true);

		lblParticipante05.setVisible(true);
		lblPeao5.setVisible(true);
		strParticipante05.setVisible(true);
		cmbPeao5.setVisible(true);

		lblParticipante06.setVisible(false);
		lblPeao6.setVisible(false);
		strParticipante06.setVisible(false);
		cmbPeao6.setVisible(false);
	}
	private void visible6Participants(){
		lblParticipante01.setVisible(true);
		lblPeao1.setVisible(true);
		strParticipante01.setVisible(true);
		cmbPeao1.setVisible(true);
		
		lblParticipante02.setVisible(true);
		lblPeao2.setVisible(true);
		strParticipante02.setVisible(true);
		cmbPeao2.setVisible(true);

		lblParticipante03.setVisible(true);
		lblPeao3.setVisible(true);
		strParticipante03.setVisible(true);
		cmbPeao3.setVisible(true);

		lblParticipante04.setVisible(true);
		lblPeao4.setVisible(true);
		strParticipante04.setVisible(true);
		cmbPeao4.setVisible(true);

		lblParticipante05.setVisible(true);
		lblPeao5.setVisible(true);
		strParticipante05.setVisible(true);
		cmbPeao5.setVisible(true);

		lblParticipante06.setVisible(true);
		lblPeao6.setVisible(true);
		strParticipante06.setVisible(true);
		cmbPeao6.setVisible(true);
	}
	@Override
	
public void propertyChange(PropertyChangeEvent arg0) {
	}
	@Override
	public void itemStateChanged(ItemEvent arg0) {	
	}
	@Override
	public void focusGained(FocusEvent arg0) {
	}
	@Override
	public void focusLost(FocusEvent arg0) {
	}
	
	public void inicializar() throws ParseException{
		
		this.createGUI("Cadastrar Participante");
		this.conteudoForm();
		this.showGUI(false);
	
		// ToolBar
		barra = new FrmToolBarParticipante(this.frame);
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
	    barra.enableButton(2, false);
	    barra.enableButton(11, true);

	    barra.visibleJogoButtons(false);
	    fatherFrame.setVisible(false);
	}
	private void conteudoForm() throws ParseException{
		
		lblTitulo			= new JLabel("Selecione os Participantes");
		lblParticipante01	= new JLabel("Nome do Participante 01");
        lblParticipante02  	= new JLabel("Nome do Participante 02");
        lblParticipante03	= new JLabel("Nome do Participante 03");
        lblParticipante04	= new JLabel("Nome do Participante 04");    
        lblParticipante05	= new JLabel("Nome do Participante 05");
        lblParticipante06   = new JLabel("Nome do Participante 06");
        lblPeao1    		= new JLabel("Cor do Peao 01");
        lblPeao2    		= new JLabel("Cor do Peao 02");
        lblPeao3   		  	= new JLabel("Cor do Peao 03");
        lblPeao4	    	= new JLabel("Cor do Peao 04");
        lblPeao5    		= new JLabel("Cor do Peao 05");
        lblPeao6	    	= new JLabel("Cor do Peao 06");
        lblNomeParticipante = new JLabel("Imdique o Nome dos Participantes");
        lblTempoJogo		= new JLabel("Tempo de Jogo (HH:MM:SS)");
        lblSeparador1		= new JLabel(":");
        lblSeparador2		= new JLabel(":");
        
        rbParticipant2 = new JRadioButton(strrbParticipante02);
        rbParticipant2.setActionCommand(strrbParticipante02);
        rbParticipant2.addActionListener(this);
       
        
        rbParticipant3 = new JRadioButton(strrbParticipante03);
        rbParticipant3.setActionCommand(strrbParticipante03);
        rbParticipant3.addActionListener(this);
        
        rbParticipant4 = new JRadioButton(strrbParticipante04);
        rbParticipant4.setActionCommand(strrbParticipante04);
        rbParticipant4.addActionListener(this);
        rbParticipant4.setVisible(false);
        
        rbParticipant5 = new JRadioButton(strrbParticipante05);
        rbParticipant5.setActionCommand(strrbParticipante05);
        rbParticipant5.addActionListener(this);
        rbParticipant5.setVisible(false);
        
        rbParticipant6 = new JRadioButton(strrbParticipante06);
        rbParticipant6.setActionCommand(strrbParticipante06);
        rbParticipant6.addActionListener(this);
        rbParticipant6.setVisible(false);
        
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rbParticipant2);
        buttonGroup.add(rbParticipant3);
        buttonGroup.add(rbParticipant4);
        buttonGroup.add(rbParticipant5);
        buttonGroup.add(rbParticipant6);
        
        strParticipante01 = new JFormattedTextField();
        strParticipante01.setColumns(30);
        strParticipante01.setText("");           

        strParticipante02 = new JFormattedTextField();
        strParticipante02.setColumns(30);
        strParticipante02.setText("");           
        
        strParticipante03 = new JFormattedTextField();
        strParticipante03.setColumns(30);
        strParticipante03.setText("");           
        
        strParticipante04 = new JFormattedTextField();
        strParticipante04.setColumns(30);
        strParticipante04.setText("");           
        strParticipante04.setVisible(false);

        strParticipante05 = new JFormattedTextField();
        strParticipante05.setColumns(30);
        strParticipante05.setText("");           
        strParticipante05.setVisible(false);
        
        strParticipante06 = new JFormattedTextField();
        strParticipante06.setColumns(30);
        strParticipante06.setText("");
        strParticipante06.setVisible(false);

        strTempo = new JFormattedTextField();
        strTempo.setColumns(3);
        strTempo.setText("");

        cmbPeao1        	= new JComboBox(Peoes);
        cmbPeao2        	= new JComboBox(Peoes);
        cmbPeao3        	= new JComboBox(Peoes);
        cmbPeao4       		= new JComboBox(Peoes);
        cmbPeao5        	= new JComboBox(Peoes);
        cmbPeao6        	= new JComboBox(Peoes);
        
    	cmbHora        		= new JComboBox(Horas);
    	cmbMinutos        	= new JComboBox(Minutos);
        cmbSegundos        	= new JComboBox(Minutos);
        
     // Configurar Combo box
        cmbPeao1.setMaximumRowCount(6);
        cmbPeao2.setMaximumRowCount(6);
        cmbPeao3.setMaximumRowCount(6);
        cmbPeao4.setMaximumRowCount(6);
        cmbPeao5.setMaximumRowCount(6);
        cmbPeao6.setMaximumRowCount(6);
        
        cmbPeao4.setVisible(false);
        cmbPeao5.setVisible(false);
        cmbPeao6.setVisible(false);
        
        cmbHora.setMaximumRowCount(10);
        cmbMinutos.setMaximumRowCount(10);
        cmbSegundos.setMaximumRowCount(10);
        
        cmbPeao1.setPreferredSize(dimensaoCombos);
        cmbPeao2.setPreferredSize(dimensaoCombos);
        cmbPeao3.setPreferredSize(dimensaoCombos);
        cmbPeao4.setPreferredSize(dimensaoCombos);
        cmbPeao5.setPreferredSize(dimensaoCombos);
        cmbPeao6.setPreferredSize(dimensaoCombos);

        cmbHora.setPreferredSize(dimensaoTempo);
        cmbMinutos.setPreferredSize(dimensaoTempo);
        cmbSegundos.setPreferredSize(dimensaoTempo);
        
        contentPane.add(lblTitulo);
        contentPane.add(lblParticipante01);
        contentPane.add(lblParticipante02);
        contentPane.add(lblParticipante03);
        contentPane.add(lblParticipante04);
        contentPane.add(lblParticipante05);
        contentPane.add(lblParticipante06);
        contentPane.add(lblPeao1);
        contentPane.add(lblPeao2);
        contentPane.add(lblPeao3);
        contentPane.add(lblPeao4);
        contentPane.add(lblPeao5);
        contentPane.add(lblPeao6);
        contentPane.add(lblNomeParticipante);
        contentPane.add(lblTempoJogo);
        contentPane.add(strParticipante01);
        contentPane.add(strParticipante02);
        contentPane.add(strParticipante03);
        contentPane.add(strParticipante04);
        contentPane.add(strParticipante05);
        contentPane.add(strParticipante06);

        
        contentPane.add(cmbPeao1);
        contentPane.add(cmbPeao2);
        contentPane.add(cmbPeao3);
        contentPane.add(cmbPeao4);
        contentPane.add(cmbPeao5);
        contentPane.add(cmbPeao6);
        
        contentPane.add(cmbHora);
        contentPane.add(cmbMinutos);
        contentPane.add(cmbSegundos);
        
        contentPane.add(rbParticipant2);
        contentPane.add(rbParticipant3);
        contentPane.add(rbParticipant4);
        contentPane.add(rbParticipant5);
        contentPane.add(rbParticipant6);
        
        contentPane.add(lblSeparador1);
        contentPane.add(lblSeparador2);

        lblParticipante04.setVisible(false);
        lblParticipante06.setVisible(false);
        lblParticipante05.setVisible(false);
        lblPeao4.setVisible(false);
        lblPeao5.setVisible(false);
        lblPeao6.setVisible(false);
        
        layout.putConstraint(SpringLayout.WEST,lblTitulo,480,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblTitulo,55,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,rbParticipant2,20,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,rbParticipant2,80,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,rbParticipant3,180,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,rbParticipant3,80,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,rbParticipant4,340,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,rbParticipant4,80,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,rbParticipant5,500,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,rbParticipant5,80,SpringLayout.NORTH, contentPane);
                
        layout.putConstraint(SpringLayout.WEST,rbParticipant6,660,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,rbParticipant6,80,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,lblNomeParticipante,480,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblNomeParticipante,120,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,lblParticipante01,20,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblParticipante01,140,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,strParticipante01,20,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,strParticipante01,160,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,lblPeao1,420,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblPeao1,140,SpringLayout.NORTH, contentPane);
	
        layout.putConstraint(SpringLayout.WEST,cmbPeao1,420,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,cmbPeao1,160,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,lblParticipante02,20,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblParticipante02,200,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,strParticipante02,20,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,strParticipante02,220,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,lblPeao2,420,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblPeao2,200,SpringLayout.NORTH, contentPane);
	
        layout.putConstraint(SpringLayout.WEST,cmbPeao2,420,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,cmbPeao2,220,SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.WEST,lblParticipante03,20,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblParticipante03,260,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,strParticipante03,20,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,strParticipante03,280,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,lblPeao3,420,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblPeao3,260,SpringLayout.NORTH, contentPane);
	
        layout.putConstraint(SpringLayout.WEST,cmbPeao3,420,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,cmbPeao3,280,SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.WEST,lblParticipante04,20,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblParticipante04,320,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,strParticipante04,20,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,strParticipante04,340,SpringLayout.NORTH, contentPane);
      
        layout.putConstraint(SpringLayout.WEST,lblPeao4,420,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblPeao4,320,SpringLayout.NORTH, contentPane);
	
        layout.putConstraint(SpringLayout.WEST,cmbPeao4,420,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,cmbPeao4,340,SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.WEST,lblParticipante05,20,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblParticipante05,380,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,strParticipante05,20,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,strParticipante05,400,SpringLayout.NORTH, contentPane);
      
        layout.putConstraint(SpringLayout.WEST,lblPeao5,420,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblPeao5,380,SpringLayout.NORTH, contentPane);
	
        layout.putConstraint(SpringLayout.WEST,cmbPeao5,420,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,cmbPeao5,400,SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.WEST,lblParticipante06,20,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblParticipante06,440,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,strParticipante06,20,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,strParticipante06,460,SpringLayout.NORTH, contentPane);
      
        layout.putConstraint(SpringLayout.WEST,lblPeao6,420,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblPeao6,440,SpringLayout.NORTH, contentPane);
	
        layout.putConstraint(SpringLayout.WEST,cmbPeao6,420,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,cmbPeao6,460,SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.WEST,lblTempoJogo,20,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblTempoJogo,320,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,cmbHora,20,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,cmbHora,340,SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST,cmbMinutos,80,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,cmbMinutos,340,SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST,cmbSegundos,140,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,cmbSegundos,340,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,lblSeparador1,73,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblSeparador1,340,SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST,lblSeparador2,133,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblSeparador2,340,SpringLayout.NORTH, contentPane);

	}
	private void closeButtonClick(){
		fatherFrame.setVisible(true);
    	frame.dispose();
	}
	private void okButtonClick(){
		confirmaInclusao();
	}
	private void nextButtonClick(){
		barra.enableButton(2, false);
		if(rbParticipant2.isSelected()){	
			FormJogo frmJogo = new FormJogo(this.frame,participante1,participante2);
			try {
				frmJogo.inicializar();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			FormJogo frmJogo = new FormJogo(this.frame,participante1,participante2,participante3);
			try {
				frmJogo.inicializar();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	protected void confirmaInclusao(){
	  if(!this.validarCampos()){
		JOptionPane.showMessageDialog(null, "Favor checar nome dos participantes, peoes selecionados ou tempo selecionado.",Messages.getString("SYSTEM_NAME"), JOptionPane.INFORMATION_MESSAGE);
		return;
	  }
	  if(rbParticipant2.isSelected()){
			rbParticipant2.setEnabled(false);
			rbParticipant3.setEnabled(false);
			cmbPeao1.setEnabled(false);
			cmbPeao2.setEnabled(false);
			strParticipante01.setEnabled(false);
			strParticipante02.setEnabled(false);
			cmbHora.setEnabled(false);
			cmbMinutos.setEnabled(false);
			cmbSegundos.setEnabled(false);
		
		  participante1 = new Jogador(1,strParticipante01.getText(),cmbPeao1.getSelectedItem().toString());
		  participante2 = new Jogador(2,strParticipante02.getText(),cmbPeao2.getSelectedItem().toString());		  
	  }
	  if(rbParticipant3.isSelected()){
			rbParticipant2.setEnabled(false);
			rbParticipant3.setEnabled(false);
			cmbPeao1.setEnabled(false);
			cmbPeao2.setEnabled(false);
			cmbPeao3.setEnabled(false);
			strParticipante01.setEnabled(false);
			strParticipante02.setEnabled(false);
			strParticipante03.setEnabled(false);
			cmbHora.setEnabled(false);
			cmbMinutos.setEnabled(false);
			cmbSegundos.setEnabled(false);
			barra.enableButton(11, false);
		
		  participante1 = new Jogador(1,strParticipante01.getText(),cmbPeao1.getSelectedItem().toString());
		  participante2 = new Jogador(2,strParticipante02.getText(),cmbPeao2.getSelectedItem().toString());
		  participante3 = new Jogador(3,strParticipante03.getText(),cmbPeao3.getSelectedItem().toString());
	  }
   }
	protected boolean validarCampos(){
	   if(cmbHora.getSelectedIndex()== 0 && cmbMinutos.getSelectedIndex()==0){
		   barra.enableButton(2, false);
		   barra.enableButton(11, true);
		   return false;
		   
	   }
	   if(intControlaValidacao==2){
		   if(!validar2Participants()){
			   barra.enableButton(2, false);
			    barra.enableButton(11, true);
			   return false;
			}
	   }
	   if(intControlaValidacao==3){
		   if(!validar3Participants()){
			   barra.enableButton(2, false);
			    barra.enableButton(11, true);
			   return false;
			}
	   }
	   barra.enableButton(2, true);
	   barra.enableButton(11, false);
	   return true;
	}
	private boolean validar2Participants(){
		if(strParticipante01.getText().isEmpty() || strParticipante02.getText().isEmpty()){
			return false;
		}
		if(cmbPeao1.getSelectedIndex()==cmbPeao2.getSelectedIndex()){
			return false;
		}
		return true;
	}
	private boolean validar3Participants(){
		if(strParticipante01.getText().isEmpty() || strParticipante02.getText().isEmpty()
		   || strParticipante03.getText().isEmpty()){
			return false;
		}
		if(cmbPeao1.getSelectedIndex()==cmbPeao2.getSelectedIndex() || cmbPeao1.getSelectedIndex()==cmbPeao3.getSelectedIndex()
		   || cmbPeao2.getSelectedIndex()==cmbPeao3.getSelectedIndex()){
			return false;
		}
		return true;
	}
}
