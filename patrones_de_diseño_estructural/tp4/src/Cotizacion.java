public class Cotizacion {

	private float costo;
	private int diasEntrega;

	public Cotizacion() {
	}

	public Cotizacion(float costo, int diasEntrega) {
		this.costo = costo;
		this.diasEntrega = diasEntrega;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public int getDiasEntrega() {
		return diasEntrega;
	}

	public void setDiasEntrega(int diasEntrega) {
		this.diasEntrega = diasEntrega;
	}

	@Override
	public String toString() {
		return "Cotizacion{costo=" + costo + ", diasEntrega=" + diasEntrega + '}';
	}

}
