compilar:
	ant run
ejecutar:
	java -jar build/jar/Sansastone.jar
limpiar:
	ant clean
default: compilar
