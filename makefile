NAME=Juego
BUILD_PATH=out
BIN_PATH=$(BUILD_PATH)/bin
JAR_PATH=$(BUILD_PATH)/jar

classes: src/Juego.java
	mkdir -p $(BIN_PATH)
	javac -sourcepath src -d $(BIN_PATH) $<

jar: classes
	mkdir -p out/jar/
	jar cfm $(JAR_PATH)/$(NAME).jar manifest -C $(BIN_PATH) .

main: jar

run:
	java -jar $(JAR_PATH)/$(NAME).jar

clean:
	rm -rf $(BUILD_PATH)
