package relogio.relogio;

import java.awt.FlowLayout;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import relogio.conversor.ConverterDecimalBinario;

public class Horas extends JFrame{
	
	private static final long serialVersionUID = 7904006713316953181L;
	
	static int minutoInicial = 0;
	static int horaInicial = 1;
	static StringBuilder sbMinuto = new StringBuilder("0");
	static StringBuilder sbHora = new StringBuilder("0");
	static boolean retornoMinuto = false;
	static boolean retornoHora = false;
	
	public static void main(String[] args) {
		
		JLabel jMinuto = new JLabel();
		JLabel sinal = new JLabel(":");
		JLabel jHora = new JLabel();
        JFrame frame = new JFrame("JFrame Example");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Relogio: ");
        panel.add(label);
        
        frame.setSize(200, 100);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
 
		ConverterDecimalBinario conversor = new ConverterDecimalBinario();

		panel.add(jHora);
		panel.add(jMinuto);
		
		Runnable timeRunnable = new Runnable() {
			
			public void run() {
				
				sbMinuto = conversor.converteDecimalParaBinario(minutoInicial++);
				jMinuto.setText(sbMinuto.toString());
				jHora.setText(sbHora.toString());
				
				retornoMinuto = minutoClock(sbMinuto);
				
				if (retornoMinuto) {
					minutoInicial = 0;
					sbHora = conversor.converteDecimalParaBinario(horaInicial++);
					
					retornoHora = horaClock(sbHora);
					
					if (retornoHora) {
						horaInicial = 0;
					}
				}
				
				panel.add(jHora);
				panel.add(sinal);
				panel.add(jMinuto);
				frame.add(panel);
			}
		};
		
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(timeRunnable, 0, 1000, TimeUnit.MILLISECONDS);
	}
	
	public static boolean minutoClock(StringBuilder minuto) {
		
//		System.out.println("Minuto Atual: " + minuto.toString());

//		if (minuto.toString().equals("111100")) {
		if (minuto.toString().equals("100")) {
//			System.out.println("Minuto alterando a hora: " + minuto.toString());
			minuto = new StringBuilder();
			return retornoMinuto = true;
		}
		
		retornoMinuto = false;
		return retornoMinuto;
	}
	
	public static boolean horaClock(StringBuilder hora) {
		
//		System.out.println("Hora Atual: " + hora.toString());

//		if (hora.toString().equals("11000")) {
		if (hora.toString().equals("101")) {
//			System.out.println("Hora alterando a hora: " + hora.toString());
			hora = new StringBuilder();
			return retornoHora = true;
		}

		retornoHora = false;
		return retornoHora;
	}
}
