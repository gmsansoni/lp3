package lp3.p2.base.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

@SuppressWarnings("serial")
public class FrmToolbarGenerico extends JPanel implements ActionListener{
	
	final public String FIRST = "first";
	final public String PREVIOUS = "previous";
    final public String NEXT = "next";
    final public String LAST = "last";

    final public String ADD = "add";
	final public String EDIT = "edit";
    final public String REMOVE = "remove";
    final public String PRINT = "print";
    final public String SEARCH = "search";

    final public String OK = "ok";
    final public String CANCEL = "cancel";
    final public String CLOSE = "close";
    
    final public String DADOS 	= "dados";
	final public String COMPRAR = "comprar";
    final public String ALUGAR 	= "alugar";
    
	private JToolBar toolBar   = new JToolBar();
	private JFrame   theFrame  = null;
	private ActionListener listener = this;
	private String imgsPath = "";
    
    public ActionListener getListener() {
		return listener;
	}
	public void setListener(ActionListener listener) {
		this.listener = listener;
	}
	public String getImgsPath() {
		return imgsPath;
	}
	public void setImgsPath(String imgsPath) {
		this.imgsPath = imgsPath;
	}
	public FrmToolbarGenerico(JFrame frameInstancia) {
    	theFrame  = frameInstancia; 
    }
    public void createToolBar(){

        addButtons(toolBar);
        add(toolBar, BorderLayout.PAGE_START);    
        toolBar.setFloatable(false);
        theFrame.add(toolBar);
    }
    protected void addButtons(JToolBar toolBar) {
        JButton button = null;

        //First button
        button = makeNavigationButton("Up24", getFIRST(),"Primeiro","Primeiro");
        toolBar.add(button);

        
        //Previous button
        button = makeNavigationButton("Back24", getPREVIOUS(),"Anterior","Anterior");
        toolBar.add(button);

        //Next button
        button = makeNavigationButton("Forward24", getNEXT(),"Iniciar Jogo","Iniciar Jogo");
        toolBar.add(button);
        
        //Last button
        button = makeNavigationButton("Down24", getLAST(),"�ltimo","�ltimo");
        toolBar.add(button);
        
        //Add a Separator 
        
        toolBar.addSeparator();
       
        //Add button
        button = makeNavigationButton("Add24", getADD(),"Adicionar","Adicionar");
        toolBar.add(button);
       
        //Edit button
        button = makeNavigationButton("Edit24", getEDIT(),"Editar","Editar");
        toolBar.add(button);

        //Delete button
        button = makeNavigationButton("Delete24", getREMOVE(),"Remover","Remover");
        toolBar.add(button);
        
        //Search button
        button = makeNavigationButton("Search24", getSEARCH(),"Localizar","Localizar");
        toolBar.add(button);

      //print button
      button = makeNavigationButton("Print24", getPRINT(), "Imprimir","Imprimir");
      toolBar.add(button);
      
        //Add a Separator 
        toolBar.addSeparator();

        //OK button
        button = makeNavigationButton("Save24", getOK(),"Confirmar","Confirmar");
        toolBar.add(button);

        //Cancel button
        button = makeNavigationButton("Stop24", getCANCEL(),"Cancelar","Cancelar");
        toolBar.add(button);

        //Close button
        button = makeNavigationButton("Redo24", getCLOSE(),"Fechar Formul�rio","Sair");
        toolBar.add(button);
        
        //Add a Separator 
        toolBar.addSeparator();
        
        //Dados button
        button = makeNavigationButton("Edit24", getDADOS(),"Jogar Dados","Jogar Dados");
        toolBar.add(button);

        //Alugar button
        button = makeNavigationButton("Delete24", getALUGAR(),"Pagar Aluguel","Pagar Aluguel");
        toolBar.add(button);
        
        //Comprar button
        button = makeNavigationButton("Search24", getCOMPRAR(),"Comprar Propriedade","Comprar Propriedade");
        toolBar.add(button);


    }
    protected JButton makeNavigationButton(String imageName,
                                           String actionCommand,
                                           String toolTipText,
                                           String altText) {
        //Look for the image.
    	
        String imgLocation = getImgsPath()
                             + imageName
                             + ".gif";
        URL imageURL = FrmToolbarGenerico.class.getResource(imgLocation);
       
        //Create and initialize the button.
        JButton button = new JButton();
        button.setActionCommand(actionCommand);
        button.setToolTipText(toolTipText);
        button.addActionListener(this.getListener());
        
        if (imageURL != null) {                      //image found
            button.setIcon(new ImageIcon(imageURL, altText));
            button.setText(altText);
        } else {                                     //no image found
            button.setText(altText);
            System.err.println("Resource not found: "
                               + imgLocation);
        }
        return button;
    }
   
	public String getFIRST() {
		return FIRST;
	}
	public String getPREVIOUS() {
		return PREVIOUS;
	}
	public String getNEXT() {
		return NEXT;
	}
	public String getLAST() {
		return LAST;
	}
	public String getADD() {
		return ADD;
	}
	public String getEDIT() {
		return EDIT;
	}
	public String getREMOVE() {
		return REMOVE;
	}
	public String getPRINT() {
		return PRINT;
	}
	public String getSEARCH() {
		return SEARCH;
	}
	public String getCLOSE() {
		return CLOSE;
	}
	public String getOK() {
		return OK;
	}
	public String getCANCEL() {
		return CANCEL;
	}

    public String getDADOS() {
		return DADOS;
	}
	public String getCOMPRAR() {
		return COMPRAR;
	}
	public String getALUGAR() {
		return ALUGAR;
	}

    public void actionPerformed(ActionEvent e) {
    	String cmd = e.getActionCommand();

		if (this.getCLOSE().equals(cmd)) {
		}
		if (this.getADD().equals(cmd)) {
		}
		if (this.getCANCEL().equals(cmd)) {
		}
		if (this.getOK().equals(cmd)) {
		}
		if (this.getREMOVE().equals(cmd)) {
		}
		if(this.getEDIT().equals(cmd)){
		}
		if(this.getFIRST().equals(cmd)){
		}
		if(this.getLAST().equals(cmd)){
		}
		if(this.getPREVIOUS().equals(cmd)){
		}
		if(this.getNEXT().equals(cmd)){
		}
		if(this.getPRINT().equals(cmd)){
		}
		if(this.getSEARCH().equals(cmd)){
		}
		if(this.getDADOS().equals(cmd)){	
		}
		if(this.getCOMPRAR().equals(cmd)){			
		}
		if(this.getALUGAR().equals(cmd)){			
		}
    }
	
	public void enableNavigationButtons(boolean status){
		this.toolBar.getComponentAtIndex(0).setEnabled(status);
		this.toolBar.getComponentAtIndex(1).setEnabled(status);
		this.toolBar.getComponentAtIndex(2).setEnabled(status);
		this.toolBar.getComponentAtIndex(3).setEnabled(status);
		this.toolBar.getComponentAtIndex(4).setEnabled(status);
	}	
	public void visibleNavigationButtons(boolean status){
		this.toolBar.getComponentAtIndex(0).setVisible(status);
		this.toolBar.getComponentAtIndex(1).setVisible(status);
		this.toolBar.getComponentAtIndex(2).setVisible(status);
		this.toolBar.getComponentAtIndex(3).setVisible(status);
		this.toolBar.getComponentAtIndex(4).setVisible(status);
	}
	public void enableEditButtons(boolean status){
		this.toolBar.getComponentAtIndex(5).setEnabled(status);
		this.toolBar.getComponentAtIndex(6).setEnabled(status);
		this.toolBar.getComponentAtIndex(7).setEnabled(status);
	}
	public void visibleEditButtons(boolean status){
		this.toolBar.getComponentAtIndex(5).setVisible(status);
		this.toolBar.getComponentAtIndex(6).setVisible(status);
		this.toolBar.getComponentAtIndex(7).setVisible(status);
	}
	public void enableServiceButtons(boolean status){
		this.toolBar.getComponentAtIndex(8).setEnabled(status);
		this.toolBar.getComponentAtIndex(9).setEnabled(status);
		this.toolBar.getComponentAtIndex(10).setEnabled(status);
	}
	public void visibleServiceButtons(boolean status){
		this.toolBar.getComponentAtIndex(8).setVisible(status);
		this.toolBar.getComponentAtIndex(9).setVisible(status);
		this.toolBar.getComponentAtIndex(10).setVisible(status);
	}
	public void enableOperationButtons(boolean status){
		this.toolBar.getComponentAtIndex(11).setEnabled(status);
		this.toolBar.getComponentAtIndex(12).setEnabled(status);
	}
	public void visibleOperationButtons(boolean status){
		this.toolBar.getComponentAtIndex(11).setVisible(status);
		this.toolBar.getComponentAtIndex(12).setVisible(status);
	}
	
	public void enableJogoButtons(boolean status){
		this.toolBar.getComponentAtIndex(14).setEnabled(status);
		this.toolBar.getComponentAtIndex(15).setEnabled(status);
		this.toolBar.getComponentAtIndex(16).setEnabled(status);
		this.toolBar.getComponentAtIndex(17).setVisible(status);
	}	
	public void visibleJogoButtons(boolean status){
		this.toolBar.getComponentAtIndex(14).setVisible(status);
		this.toolBar.getComponentAtIndex(15).setVisible(status);
		this.toolBar.getComponentAtIndex(16).setVisible(status);
		this.toolBar.getComponentAtIndex(17).setVisible(status);
	}
	public void visibleButton(int index,boolean status){
		if(index<this.toolBar.getComponentCount() && index!=13){
			this.toolBar.getComponentAtIndex(index).setVisible(status);
		}
	}
	public void enableButton(int index,boolean status){
		if(index<this.toolBar.getComponentCount() && index!=13){
			this.toolBar.getComponentAtIndex(index).setEnabled(status);
		}
	}
}

