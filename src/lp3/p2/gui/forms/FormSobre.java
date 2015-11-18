package lp3.p2.gui.forms;

import java.awt.Color;
import java.awt.Font;
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

import lp3.p2.base.gui.FormGenerico;
import lp3.p2.gui.toolbars.FormToolbarSobre;

public class FormSobre extends FormGenerico implements ActionListener, PropertyChangeListener,ItemListener, FocusListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected FormToolbarSobre barra = null;
    private JFrame fatherFrame;
    
    public FormSobre(JFrame Openerframe){
		
		fatherFrame = Openerframe;
	}

    public void inicializar() throws ParseException{
    	
    	this.createGUI("Sobre o Sistema");
		this.conteudoForm();
		this.showGUI(false);
	
		// ToolBar
		barra = new FormToolbarSobre(this.frame);
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
	    barra.visibleJogoButtons(false);
	    
	    
	    fatherFrame.setVisible(false);

    }
    
	private void conteudoForm() throws ParseException{
		
		Font fonte 					= new Font("Serif", Font.BOLD,22);
		
		JLabel lblFaculdade			= new JLabel("Funda��o Santo Andr�");
		JLabel lblCurso				= new JLabel("Curso de Engenharia da Computa��o");
		JLabel lblTCC			  	= new JLabel("Trabalho de Conclus�o de Curso");
		JLabel lblTituloTrabalho	= new JLabel("Banco Imobili�rio Simplificado em Realidade Aumentada");
		JLabel lblIntegrantes		= new JLabel("Integrantes do Grupo:");    
		JLabel lblIntegrante01		= new JLabel("Adriana Kaoru Takagi � 04577-7");
		JLabel lblIntegrante02   	= new JLabel("Aline Martins Moreira � 04583-6");
		JLabel lblIntegrante03   	= new JLabel("Iris Milena Barberi Donega � 04568-6");
		JLabel lblIntegrante04   	= new JLabel("Livia Martins Zeferino � 04648-6");
		JLabel lblIntegrante05   	= new JLabel("Mariana Martins Pedro � 04606-6");
		
		lblFaculdade.setForeground(Color.BLUE);
		lblFaculdade.setFont(fonte);
		lblCurso.setForeground(Color.BLUE);
		lblTCC.setForeground(Color.BLUE);
		lblTituloTrabalho.setForeground(Color.BLUE);
		lblIntegrantes.setForeground(Color.RED);
		lblIntegrante01.setForeground(Color.RED);
		lblIntegrante02.setForeground(Color.RED);
		lblIntegrante03.setForeground(Color.RED);
		lblIntegrante04.setForeground(Color.RED);
		lblIntegrante05.setForeground(Color.RED);
		
		contentPane.add(lblFaculdade);
        contentPane.add(lblCurso);
        contentPane.add(lblTCC);
        contentPane.add(lblTituloTrabalho);
        contentPane.add(lblIntegrantes);
        contentPane.add(lblIntegrante01);
        contentPane.add(lblIntegrante02);
        contentPane.add(lblIntegrante03);
        contentPane.add(lblIntegrante04);
        contentPane.add(lblIntegrante05);
        
        layout.putConstraint(SpringLayout.WEST,lblFaculdade,480,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblFaculdade,55,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,lblCurso,480,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblCurso,100,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,lblTCC,480,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblTCC,145,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,lblTituloTrabalho,480,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblTituloTrabalho,190,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,lblIntegrantes,480,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblIntegrantes,235,SpringLayout.NORTH, contentPane);
        
        
        layout.putConstraint(SpringLayout.WEST,lblIntegrante01,480,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblIntegrante01,280,SpringLayout.NORTH, contentPane);
                
        layout.putConstraint(SpringLayout.WEST,lblIntegrante02,480,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblIntegrante02,325,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,lblIntegrante03,480,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblIntegrante03,370,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,lblIntegrante04,480,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblIntegrante04,415,SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.WEST,lblIntegrante05,480,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH,lblIntegrante05,460,SpringLayout.NORTH, contentPane);

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String cmd = arg0.getActionCommand();

		if (barra.getCLOSE().equals(cmd)) {
		   	closeButtonClick();
		}

	}
	private void closeButtonClick(){
		fatherFrame.setVisible(true);
    	frame.dispose();
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

}
