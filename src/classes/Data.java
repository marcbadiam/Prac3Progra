package Classes;

/**
 * Classe per guardar dates.
 * 
 * @author Professores de programació.
 *
 */

 public class Data {
	private int dia;
	private int mes;
	private int any;

	/**
	 * Constructor per defecte, sense paràmetres inicialitza a una data de
	 * referència
	 */
	public Data() {
		this.dia = 1;
		this.mes = 1;
		this.any = 2000;
	}

	/**
	 * Constructor que rep la data per paràmetre
	 * Ha de validar que la data és correcta. Si rep una data incorrecta inicialitza la instància
	 * amb la data de referència.
	 * @param dia
	 * @param mes
	 * @param any
	 */
	public Data(int dia, int mes, int any) {
		if (esDataCorrecta(dia, mes, any)) { // ens asegurem que és una data valida
			this.dia = dia;
			this.mes = mes;
			this.any = any;
		} else { // posem la data de referència com a senyal d'error
			this.dia = 1;
			this.mes = 1;
			this.any = 2000;
		}
	}

	/**
	 * Getter
	 * @return dia de la data
	 */
	public int getDia() {
		return dia;
	}

	/**
	 * Getter
	 * @return mes de la data
	 */
	public int getMes() {
		return mes;
	}

	/**
	 * Getter
	 * @return any de la data
	 */
	public int getAny() {
		return any;
	}

	/**
	 * Setter conjunt per a poder validar la correctesa de la data rebuda.
	 * Només es fa la modificació de la data si que es rep per paràmetre és correcte.
	 * @param dia
	 * @param mes
	 * @param any
	 */
	public void setData(int dia, int mes, int any) {
		if (esDataCorrecta(dia, mes, any)) { // ens asegurem que hi ha una data vàlida
			this.dia = dia;
			this.mes = mes;
			this.any = any;
		}
	}

	/**
	 * Mètode que comprova si la data actual és la mateixa a la que es rep per paràmetre
	 * @param data - valor de data a comparar amb l'actual
	 * @return si són iguals
	 */
	public boolean esIgual(Data data) {
		// diferents formes d'accedir als atributs del paràmetre
		if (this.dia == data.dia && this.mes == data.mes && this.any == data.getAny()) {
			return true;
		}
		return false;
	}

	/**
	 * Mètode que calcula sobre la instància actual el valor del dia següent
	 */
	public void diaSeguent() {
		// el this és opcional en aquest cas
		this.dia++;
		if (this.dia > diesMes(this.mes, this.any)) {
			this.dia = 1;
			this.mes++;
			if (this.mes > 12) {
				this.mes = 1;
				this.any++;
			}
		}
	}

	/**
	 * Mètode que transforma el contingut d'un objecte en una cadena de caracters per ser
	 * mostrat per pantalla
	 */
	public String toString() {
		return("\tDATA => dia "+dia+" mes "+mes+" any "+any);
	}

	// Mètodes de classe (STATIC).
	// no s'apliquen sobre el contingut d'una instància de data sinó sobre valors
	// que es reben per paràmetre.
	// són mètodes auxiliars

	private static boolean esDataCorrecta(int dia, int mes, int any) {
		boolean hoEs=true;
		if (dia < 1 || dia > 31) { // dia incorrecte
			hoEs= false;
		}
		if (mes < 1 || mes > 12) { // mes incorrecte
			hoEs= false;
		}
		if (dia > diesMes(mes, any)) { // dia del mes incorrecte
			hoEs= false;
		}
		return hoEs;
	}

	private static boolean esAnyTraspas(int any) { // ens estalviem crear una instancia de data
		if ((any % 4 == 0) && ((any % 100 != 0) || (any % 400 == 0))) {
			return true;
		} else {
			return false;
		}
	}

	private static int diesMes(int mes, int any) { // per saber quants dies te un mes d'un any
		int diesMes;
		if (mes == 2) {
			if (esAnyTraspas(any)) {
				diesMes = 29;
			} else {
				diesMes = 28;
			}
		} else {
			if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
				diesMes = 30;
			} else {
				diesMes = 31;
			}
		}
		return diesMes;
	}

	/**
	 * Mètode que calcula sobre la instància actual el valor del dia antrior
	 */
	public void diaAnterior() {
		// el this és opcional en aquest cas
		this.dia--;
		if (this.dia < 1 ) {
			this.dia = diesMes(this.mes, this.any);
			this.mes--;
			if (this.mes < 1) {
				this.mes = 12;
				this.any--;
			}
		}
	}

	/**
	 * Mètode que comprova si una data es any de traspas
	 * @param data - valor de data a comprovar si es de traspas
	 * @return si l'any es de traspas
	 */
	public boolean esDataAnyTraspas(Data data) { // ens estalviem crear una instancia de data
		if ((data.any % 4 == 0) && ((data.any % 100 != 0) || (data.any % 400 == 0))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Mètode que comprova si la data actual és inferior o igual  a la que es rep per paràmetre
	 * @param data - valor de data a comparar amb l'actual
	 * @return si és inferior o igual
	 */
	public boolean esDataInferiorOigual(Data data) {
		boolean esInferior; 
		if (any < data.any) esInferior=true;
		else if (any > data.any) esInferior=false;
		else {
			// cas anys iguals
		   if (mes < data.mes) esInferior=true;
		   else if (mes > data.mes) esInferior=false;
		   else {
			   // anys i mes iguals
			   if (dia <= data.dia) esInferior=true;
			   else esInferior = false;
		   }		
		}
		return esInferior; 
	}
	/**
	 * Mètode que calcula quants dies falten per arribar des de la data actual a la
	 * que rebem per paràmetre
	 * 
	 * @param data - valor de data a la que calcular el número de dies que falten
	 * @return si la data que es rep per paràmetre és superior o igual a la data 
	 *         sobre la que es crida el mètode es retorna el número de dies.
	 *         Si la data que es rep per paràmetre és inferior es retorna -1.
	 */
	public int numDiesAData(Data data) {
		Data dataTemp;
		int diesRestants;

		dataTemp = new Data(dia, mes, any);

		if(dataTemp.esDataInferiorOigual(data)){
			diesRestants = 0;

			while (!dataTemp.esIgual(data)) {
				dataTemp.diaSeguent();
				diesRestants++;
			}

		}else{
			diesRestants = -1;
		}

		return diesRestants;
	}

	public Data Copia(Data data){
		data = new Data(dia, mes, any);
		return data;
	}

}
