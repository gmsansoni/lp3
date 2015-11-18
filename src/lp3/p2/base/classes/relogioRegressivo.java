package lp3.p2.base.classes;

import javax.swing.JLabel;

public class relogioRegressivo extends Thread{

    private JLabel hr;
    private Integer hora,minuto,segundo =0;
    private boolean isStop=false;

    public relogioRegressivo(JLabel horaSelecionada) {
        this.hr = horaSelecionada;
        
    }

    @Override
    public void run() {
       try {
    	   hora=Integer.parseInt(hr.getText().substring(0,2));
   	       minuto=Integer.parseInt(hr.getText().substring(3,5));
   	       segundo=Integer.parseInt(hr.getText().substring(6));
           while( true ) {   
        	   Thread.sleep(1000);
        	   if(!isStop){
        		   segundo--;
        		   
	               if( segundo < 00 ){
	                   segundo = 59;
	                   minuto = minuto-1;
	               }
	
	               if( minuto == 00 ){
	                   minuto = 59;
	                   hora = hora-1;
	               }
	               
	               String timer = completaComZero(hora) + ":" +
	                              completaComZero(minuto) + ":" +
	                              completaComZero(segundo);
	               this.hr.setText(timer);
	               this.hr.revalidate();
	               if(hora==00 && minuto==00 && segundo==00){
	            	   isStop=true;
	               }
        	   }
           }  
       } catch (InterruptedException ex) {
           ex.printStackTrace();
       }
    }

    private String completaComZero(Integer i) {
        String retorno = null;
        if( i < 10 ) {
            retorno = "0"+i;
        } else {
            retorno = i.toString();
        }
        return retorno;
    }

	public int getHora() {
		return hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public int getSegundo() {
		return segundo;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public void setSegundo(int segundo) {
		this.segundo = segundo;
	}

	public JLabel getHr() {
		return hr;
	}

	public void setHr(JLabel hr) {
		this.hr = hr;
	}

}
