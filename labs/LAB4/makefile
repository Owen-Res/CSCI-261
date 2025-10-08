MAIN_FILE = Tester
BUILD_FOLDER = classfiles
.PHONY: run

build:
	javac -d $(BUILD_FOLDER) $(MAIN_FILE).java

run: build
	java -classpath $(BUILD_FOLDER) $(MAIN_FILE)
