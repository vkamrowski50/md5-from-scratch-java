run:
	@java Main $(ARGS)

run-debug:
	@java Main_Debug $(ARGS)

compile:
	@javac Main.java
	@javac Main_Debug.java
	@javac Padding.java
	@javac Op_One.java
	@javac Op_Two.java
	@javac Op_Three.java
	@javac Op_Four.java

clean:
	@rm -rf *.class
