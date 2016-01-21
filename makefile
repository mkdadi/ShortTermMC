install: src/makefile install.java
	javac install.java
	@echo "Proceeding to installation!"
	@sleep 5
	java install
	cd src;make
clean:
	cd src;make clean
