NAME=Juego
BUILD_PATH=out
BIN_PATH=$(BUILD_PATH)/bin
JAR_PATH=$(BUILD_PATH)/jar
JDK_PATH=readlink -f $(which java)
compilar:
	echo $(JDK_PATH)
main: compilar

run:
	java -jar $(JAR_PATH)/$(NAME).jar

clean:
	rm -rf $(BUILD_PATH)
