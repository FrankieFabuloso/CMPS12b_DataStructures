#------------------------------------------------------------------------------
# makefile for IntegerStackClient.c with macros
#------------------------------------------------------------------------------

FLAGS   = -std=c99 -Wall
SOURCES = Dictionary.c DictionaryClient.c DictionaryTest.c
FILES = makefile README
OBJECTS = Dictionary.o DictionaryClient.o
HEADERS = Dictionary.h
EXEBIN  = Dictionary
SUBMIT = submit cmps012b-pt.u13 lab5

all: $(EXEBIN)

$(EXEBIN) : $(OBJECTS) $(HEADERS)
	gcc -o $(EXEBIN) $(OBJECTS)

$(OBJECTS) : $(SOURCES) $(HEADERS)
	gcc -c $(FLAGS) $(SOURCES)

clean :
	rm -f $(EXEBIN) $(OBJECTS)

check:
	valgrind --leak-check=full $(EXEBIN) 
	
submit:
	$(SUBMIT) $(SOURCES) $(FILES) $(HEADERS)
