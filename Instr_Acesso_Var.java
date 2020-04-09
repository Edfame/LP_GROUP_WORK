public class Instr_Acesso_Var{
	private String instr;
	private int arg1, arg2;

	public Instr_Acesso_Var(String instr, int arg1, int arg2){
		this.instr = instr;
		this.arg1 = arg1;
		this.arg2 = arg2;
	}

	public String getInstr(){
		return instr;
	}

	public void setInstr(String instr){
		this.instr = instr;
	}

	public int getArg1(){
		return arg1;
	}

	public void setArg1(int arg1){
		return this.arg1;
	}

	public int getArg2(){
		return arg2;
	}

	public void setArg2(int arg2){
		return this.arg2;
	}

}
