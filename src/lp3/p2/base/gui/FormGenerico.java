package lp3.p2.base.gui;

import java.awt.Container;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SpringLayout;

import lp3.p2.base.util.Messages;



public class FormGenerico extends JFrame{

	// Form
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JFrame frame = null;
	public Container contentPane = null;
	public SpringLayout layout = new SpringLayout();
	protected FormMenuGenerico Menu = null;
	private URL urlPath = FormGenerico.class.getResource("images/bug.png");
	protected ImageIcon icon = new ImageIcon(urlPath);
	    
	public FormGenerico(){
		this.initiate();	
	}
	
	protected void initiate(){
		frame = new JFrame(Messages.getString("SYSTEM_NAME"));
		JFrame.setDefaultLookAndFeelDecorated(false);
		
		frame.setIconImage(icon.getImage());
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	   
	    contentPane = frame.getContentPane();
		contentPane.setLayout(layout);
		Menu = new FormMenuGenerico(frame);
	}
	protected void createGUI(String strWindowTitle){
		
		frame.setTitle(Messages.getString("SYSTEM_NAME") + " - " + strWindowTitle);
        
        contentPane.setLayout(layout);  
    }
    protected void showGUI(boolean exibeMenu){
        
        frame.pack();
        Menu.showMenu(exibeMenu);		
        frame.setVisible(true);
       
    }
    
   
		
}
