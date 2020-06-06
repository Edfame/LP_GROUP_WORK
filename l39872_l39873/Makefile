# alterar para o caminho onde estao os ficheiros
TOOLS=src

JAVA = java
JAVAFLAGS =
JAVAC = javac
JAVACFLAGS =

JCLASSPATH = .:$(TOOLS):$(TOOLS)/argumentos:$(TOOLS)/aritmeticas:$(TOOLS)/funcoes:$(TOOLS)/inteiros:$(TOOLS)/saida:$(TOOLS)/saltos:$(TOOLS)/variaveis

CUP = java -classpath $(JCLASSPATH) java_cup/Main
CUPFLAGS = -package src -destdir src

JLEX = java -classpath $(JCLASSPATH) JLex/Main
JLEXFLAGS =

CLASSES = src/parser.class src/Yylex.class \
			src/Main.class src/TISC.class src/Etiqueta.class src/Instrucao.class\
			src/argumentos/PushArg.class src/argumentos/StoreArg.class \
			src/aritmeticas/Add.class src/aritmeticas/Div.class src/aritmeticas/Exp.class src/aritmeticas/Mod.class src/aritmeticas/Mult.class src/aritmeticas/Sub.class \
			src/funcoes/Call.class src/funcoes/Locals.class src/funcoes/Return.class src/funcoes/SetArg.class \
			src/inteiros/PushInt.class \
			src/saida/Print.class src/saida/PrintNl.class src/saida/PrintString.class \
			src/saltos/Jeq.class src/saltos/Jlt.class src/saltos/Jump.class \
			src/variaveis/PushVar.class src/variaveis/StoreVar.class
	  		# etc ...

INTERMEDIATE_FILES = registos.lex.java src/sym.java src/parser.java src/Yylex.java

.INTERMEDIATE: src/sym.java
.SECONDARY: src/registos.lex.java src/Yylex.java

.PHONY: all clean run

%.class: %.java
	CLASSPATH=$(JCLASSPATH) $(JAVAC) $(JAVACFLAGS) $<

all: $(CLASSES)

src/Main.class: src/Main.java src/TISC.class src/parser.class

src/parser.java src/sym.java: src/registos.cup
	$(CUP) $(CUPFLAGS) $<
	@[ -s $@ ] || { rm -f $@; exit 1; }

src/parser.class: src/parser.java src/Yylex.class
	CLASSPATH=$(JCLASSPATH) $(JAVAC) $(JAVACFLAGS) $<

src/sym.class: src/sym.java

src/registos.lex.java: src/registos.lex
	$(JLEX) $(JLEXFLAGS) $<

src/Yylex.java: src/registos.lex.java
	ln -sf registos.lex.java $@

src/Yylex.class: src/Yylex.java src/registos.lex.java src/sym.class
	CLASSPATH=$(JCLASSPATH) $(JAVAC) $(JAVACFLAGS) $<

clean:
	$(RM) $(INTERMEDIATE_FILES)
	$(RM) src/*.lex.java
	$(RM) src/*.class *~
	$(RM) $(CLASSES)

run:
	CLASSPATH=$(JCLASSPATH) $(JAVA) $(JAVAFLAGS) src.Main
