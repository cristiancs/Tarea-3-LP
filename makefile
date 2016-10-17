NAME=Juego
BUILD_PATH=out
BIN_PATH=$(BUILD_PATH)/bin
JAR_PATH=$(BUILD_PATH)/jar

classes: src/Juego.java
	mkdir -p $(BIN_PATH)
	javac -classpath external/forms_rt.jar -sourcepath src -d $(BIN_PATH) $<

jar: classes
	mkdir $(JAR_PATH)
	jar cfm $(JAR_PATH)/$(NAME).jar manifest -C $(BIN_PATH) .

main: classes

run:
	java -jar $(JAR_PATH)/$(NAME).jar

clean:
	rm -rf $(BUILD_PATH)
