package lp3.p2.base.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import lp3.p2.base.util.Messages;
import lp3.p2.gui.forms.FormCadParticipante;
import lp3.p2.gui.forms.FormSobre;

public class FormMenuGenerico implements ActionListener{
	
	private JMenuBar BarraMenu;
	private JFrame theFrame, openerFrame;

	public FormMenuGenerico(JFrame frame) {
		theFrame = frame;
		openerFrame = frame;
	}


	protected void showMenu(boolean Visible){
        
		
         // Criando estrutura 
        
    	
        JMenu mnuJogo,mnuSistema;
        JSeparator mnuSeparador;
        JMenuItem miJogar,miSair; 
        JMenuItem miSobre;
        

        // Criando a Barra de Menu
        BarraMenu = new JMenuBar();
        BarraMenu.setMaximumSize(theFrame.getSize());
        
        // Criando Menu Jogos
        mnuJogo = new JMenu("Jogo");
        mnuJogo.setMnemonic(KeyEvent.VK_J);
        mnuJogo.getAccessibleContext().setAccessibleDescription("Menu para opera��es referentes ao jogo");
        BarraMenu.add(mnuJogo);
        
        
        // Itens do Menu Jogos      
        miJogar = new JMenuItem("Jogar");
        miJogar.addActionListener(this);
        mnuJogo.add(miJogar);        
     
        
        // Criando Menu de Sistema
        mnuSistema = new JMenu("Sistema");
        mnuSistema.setMnemonic(KeyEvent.VK_S);
        mnuSistema.getAccessibleContext().setAccessibleDescription("Menu para Opera��es de Sistema");
        BarraMenu.add(mnuSistema);
       
        // Itens do Menu Sistema
        miSobre = new JMenuItem("Sobre o Sistema");
        miSobre.addActionListener(this);
        mnuSistema.add(miSobre); 

        mnuSeparador = new JSeparator();
        mnuSeparador.setVisible(true);
        mnuSistema.add(mnuSeparador);
        
        miSair = new JMenuItem("Sair");
        miSair.addActionListener(this);
        mnuSistema.add(miSair);
            
        theFrame.setJMenuBar(BarraMenu);
        
        this.setMenuVisible(Visible);
    }
    
    private void setMenuVisible(boolean state)
    {
    	BarraMenu.setVisible(state);
    }
    
    private void miSairClick() {
    	
    	int intAnswer = JOptionPane.showConfirmDialog(
    			theFrame, "Deseja SAIR realmente?",
    			Messages.getString("SYSTEM_NAME"),
                JOptionPane.YES_NO_OPTION);
    	
        if (intAnswer == JOptionPane.YES_OPTION) {
        	theFrame.dispose();
        }
	}
  
    private void miJogarClick(){
    	FormCadParticipante frmCadParticipante = new FormCadParticipante(openerFrame);
		try {
			frmCadParticipante.inicializar();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    private void miSobreClick(){
    	FormSobre frmSobre = new FormSobre(openerFrame);
		try {
			frmSobre.inicializar();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getActionCommand() == "Sair"){
			this.miSairClick();
	    }
		if(arg0.getActionCommand() == "Jogar"){
			this.miJogarClick();
	    }
		if(arg0.getActionCommand() == "Sobre o Sistema"){
			this.miSobreClick();
	    }

	}
}
