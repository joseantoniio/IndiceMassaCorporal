package fernandowirtz.indicemasacorporal_v2;

public class IndiceMasaCorporalException extends Exception {
	boolean errorPeso = false;
	boolean errorAltura = false;
	
	/**
	 * 
	 */
	public IndiceMasaCorporalException(boolean errorPeso, boolean errorAltura) {
		super();
		// TODO Auto-generated constructor stub
		this.errorPeso = errorPeso;
		this.errorAltura = errorAltura;		
	}
	
	/**
	 * @return the errorPeso
	 */
	public boolean isErrorPeso() {
		return errorPeso;
	}
	
	/**
	 * @return the errorAltura
	 */
	public boolean isErrorAltura() {
		return errorAltura;
	}
}