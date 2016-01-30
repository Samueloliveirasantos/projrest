package br.com.auxiliar.bean;

public enum TipoPessoa {
	
	COOPERADOR(1,"Cooperador"),
	AUXILIAR(2,"Auxiliar"),
	JOVEM(3,"Jovem");
	
	
	
	private TipoPessoa(int code, String description) {
	    this.code = code;
	    this.description = description;
	  }

	
	private final int code;
	private final String description;
	
	
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	  
	  
	  
	
}
