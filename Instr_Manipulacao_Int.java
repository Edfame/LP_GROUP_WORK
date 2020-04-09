public class Instr_Manipulacao_Int{
	private String instr;
	private int arg;

	public Instr_Manipulacao_Int(String instr, int arg){
		this.instr = instr;
		this.arg = arg;

	}

	public String getInstr(){
		return instr;
	}

	public void setInstr(String instr){
		this.instr = instr;
	}

	public int getArg(){
		return arg;
	}

	public void setArg(int arg){
		return this.arg;
	}
}