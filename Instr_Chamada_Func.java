public class Instr_Chamada_Func{
	private String instr, etiqueta;
	private int arg1, arg2;

	public Instr_Chamada_Func(String instr, int arg1){
		this.instr = instr;
		this.arg1 = arg1;
	}

	public Instr_Chamada_Func(String instr, int arg1, String etiqueta){
		this.instr = instr;
		this.arg1 = arg1;
		this.etiqueta = etiqueta;
	}

	public Instr_Chamada_Func(String instr, int arg1, int arg2){
		this.instr = instr;
		this.arg1 = arg1;
		this.arg2 = arg2;
	}

	public Instr_Chamada_Func(String instr){
		this.instr = instr;
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