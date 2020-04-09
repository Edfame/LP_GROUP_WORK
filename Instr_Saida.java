public class Instr_Saida{
	private String instr, frase;

	public Instr_Salto(String instr, String frase){
		this.instr = instr;
		this.frase = frase;
	}

	public String getInstr(){
		return instr;
	}

	public void setInstr(String instr){
		this.instr = instr;
	}

	public String getFrase(){
		return frase;
	}

	public void setFrase(String frase){
		this.frase = frase;
	}
}