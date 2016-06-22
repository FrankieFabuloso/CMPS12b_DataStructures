# makefile for pa2 FileSearch
JAVASRC = FileSearch.java
SOURCES = README makefile ${JAVASRC}
MAINCLASS = FileSearch
CLASSES = FileSearch.class 
JARFILE = Search
JARCLASSES = ${CLASSES}
SUBMIT = submit cmps012b-pt.u13 pa2

all: ${JARFILE}

${JARFILE}: ${CLASSES}
	echo Main-class: ${MAINCLASS} > Manifest
	jar cvfm ${JARFILE} Manifest ${JARCLASSES}
	rm Manifest
	chmod +x ${JARFILE}

${CLASSES}: ${JAVASRC}
	javac -Xlint ${JAVASRC}

clean:
	rm ${CLASSES} ${JARFILE}

submit: ${SOURCES}
	${SUBMIT} ${SOURCES}