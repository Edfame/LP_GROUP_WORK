# alterar para o caminho onde estao os ficheiros
TOOLS=LP_GROUP_WORK/src

JAVA = java
JAVAFLAGS =
JAVAC = javac
JAVACFLAGS =

JCLASSPATH = .:$(TOOLS):$(TOOLS)/argumentos:$(TOOLS)/aritmeticas:$(TOOLS)/funcoes:$(TOOLS)/inteiros:$(TOOLS)/saida:$(TOOLS)/saltos:$(TOOLS)/variaveis

CUP = java -classpath $(JCLASSPATH) java_cup/Main
CUPFLAGS =

JLEX = java -classpath $(JCLASSPATH) JLex/Main
JLEXFLAGS =

CLASSES = parser.class Yylex.class \
			src/Main.class src/TISC.class src/Etiqueta.class src/Instrucao.class\
			src/argumentos/PushArg.class src/argumentos/StoreArg.class \
			src/aritmeticas/Add.class src/aritmeticas/Div.class src/aritmeticas/Exp.class src/aritmeticas/Mod.class src/aritmeticas/Mult.class src/aritmeticas/Sub.class \
			src/funcoes/Call.class src/funcoes/Locals.class src/funcoes/Return.class src/funcoes/SetArg.class \
			src/inteiros/PushInt.class \
			src/saida/Print.class src/saida/PrintNl.class src/saida/PrintString.class \
			src/saltos/Jeq.class src/saltos/Jlt.class src/saltos/Jump.class \
			src/variaveis/PushVar.class src/variaveis/StoreVar.class
	  		# etc ...

INTERMEDIATE_FILES = registos.lex.java sym.java parser.java Yylex.java

.INTERMEDIATE: sym.java
.SECONDARY: registos.lex.java Yylex.java

.PHONY: all clean run

%.class: %.java
	CLASSPATH=$(JCLASSPATH) $(JAVAC) $(JAVACFLAGS) $<

all: $(CLASSES)

Main.class: Main.java TISC.class parser.class

parser.java sym.java: registos.cup
	$(CUP) $(CUPFLAGS) $<
	@[ -s $@ ] || { rm -f $@; exit 1; }

parser.class: parser.java Yylex.class
	CLASSPATH=$(JCLASSPATH) $(JAVAC) $(JAVACFLAGS) $<

sym.class: sym.java

registos.lex.java: registos.lex
	$(JLEX) $(JLEXFLAGS) $<

Yylex.java:
	ln -sf registos.lex.java $@

Yylex.class: Yylex.java registos.lex.java sym.class
	CLASSPATH=$(JCLASSPATH) $(JAVAC) $(JAVACFLAGS) $<

clean:
	$(RM) $(INTERMEDIATE_FILES)
	$(RM) *.class *~

run:
	CLASSPATH=$(JCLASSPATH) $(JAVA) $(JAVAFLAGS) Main
