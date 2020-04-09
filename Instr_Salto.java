public class Instr_Salto{
	private String instr, etiqueta;

	public Instr_Salto(String instr, String etiqueta){
		this.instr = instr;
		this.etiqueta = etiqueta;
	}

	public String getInstr(){
		return instr;
	}

	public void setInstr(String instr){
		this.instr = instr;
	}

	public String getEtiqueta(){
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta){
		this.etiqueta = etiqueta;
	}
}