.DEFAULT_GOAL := jar

classes: 
	ant compile

jar: 
	ant jar

run: 
	java -jar build/jar/Sansastone.jar

clean: 
	ant clean