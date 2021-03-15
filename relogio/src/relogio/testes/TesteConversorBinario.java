package relogio.testes;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import relogio.conversor.ConverterDecimalBinario;

public class TesteConversorBinario {
	
	static int valor = -1;

	/**
	 * Teste do Runnable para mostrar o numero convertido
	 *  
	 */
  public static void main(String[] args) {
	  
	  ConverterDecimalBinario conversor = new ConverterDecimalBinario();

	  Runnable runnable = new Runnable() {
		  StringBuilder convertido = new StringBuilder();
		  public void run() {
	    	  // task to run goes here
			  valor++;
	    	  convertido = conversor.converteDecimalParaBinario(valor);
	    	  
	    	  System.out.println("Convertido: " + convertido);
	      }
	  };
    
	ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    executor.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
  }
}
