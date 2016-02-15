compile: src/makefile
	@echo "Proceeding to Compilation"
	cd src;make
	@sleep 5
	@echo "Run the Program by the command java 'src.STCM'"
clean:
	cd src;make clean
