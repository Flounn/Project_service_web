package fr.dauphine.renderers;

public class ListInteger {
	
	public ListInteger(int begin, int end, int pas) {
		this.begin = begin;
		this.end = end;
		this.pas = pas;
	}
	public ListInteger(int begin, int end, int pas, Integer valueSelected) {
		this.begin = begin;
		this.end = end;
		this.pas = pas;
		this.valueSelected = valueSelected;
	}
	/**
	 * @return the valueSelected
	 */
	public int getValueSelected() {
		return valueSelected;
	}
	/**
	 * @param valueSelected the valueSelected to set
	 */
	public void setValueSelected(int valueSelected) {
		this.valueSelected = valueSelected;
	}
	/**
	 * @return the begin
	 */
	public int getBegin() {
		return begin;
	}
	/**
	 * @return the end
	 */
	public int getEnd() {
		return end;
	}
	public ListInteger(int begin, int end) {
		this.begin = begin;
		this.end = end;
		pas=1;
	}

	/**
	 * @return the pas
	 */
	public int getPas() {
		return pas;
	}

	private final int begin;
	private final int end;
	private final int pas;
	private Integer valueSelected;
	

}
