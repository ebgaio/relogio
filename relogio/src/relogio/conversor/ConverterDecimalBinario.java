package relogio.conversor;

public class ConverterDecimalBinario {

	/**
	 * Converte decimal para binario. A regra eh ficar dividindo o valor por 2,
	 * pegar o resto de cada divisao e inserir o valor da direita para a
	 * esquerda na String de retorno.
	 * O algoritmo eh executado ate que o valor que foi sucessivamente 
	 * dividido se torne 0. Obs.: assume que o valor passado eh inteiro positivo.
	 * 
	 * Exemplo: 13 13/2 = 6 -> resto 1 -> Resultado:
	 * 1 6/2 = 3 -> resto 0 -> Resultado: 01 3/2 = 1 -> resto 1 -> Resultado:
	 * 101 1/2 = 0 -> resto 1 -> Resultado: 1101
	 *
	 * Resultado: 1101
	 *
	 * @param valor
	 *            numero decimal a ser convertido
	 * @return String contendo o valor em binario
	 */
	public StringBuilder converteDecimalParaBinario(int valor) {
		int resto = 0;
		StringBuilder sb = new StringBuilder();

		if (valor == 0) {
			return sb.insert(0, "0");
		}

		// enquanto o resultado da divisao por 2 for maior
		// que 0 adiciona o resto ao inicio da String de retorno
		while (valor > 0) {
			resto = valor % 2;
			valor = valor / 2;
			sb.insert(0, resto);
		}
		return sb;
	}
}
