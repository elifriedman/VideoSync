compile: server/src/*.java
	rm -rf ./server/out
	mkdir server/out
	javac  server/src/* -d server/out/
	echo root=$(shell pwd) >> props/www-server.properties

run:
	java -classpath server/out/ WebServer

clean:
	rm -rf ./server/out/



