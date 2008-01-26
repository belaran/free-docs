GCC=g++ -g
TESTS_DIRECTORY=./TESTS/
EXAMPLE_TEST=$(TESTS_DIRECTORY)testexample
STRIKE_TEST=$(TESTS_DIRECTORY)testelement
FACTORY_TEST=$(TESTS_DIRECTORY)testfactory
CONCRETE_ENTITY_TEST=$(TESTS_DIRECTORY)testconcreteentity
SRC=./SRC/

all :  test

test : $(EXAMPLE_TEST) $(STRIKE_TEST) $(FACTORY_TEST) $(CONCRETE_ENTITY_TEST)
        ./$(EXAMPLE_TEST)
        ./$(STRIKE_TEST)
        ./$(FACTORY_TEST)
        ./$(CONCRETE_ENTITY_TEST)

$(CONCRETE_ENTITY_TEST) :  abstractentity.o concreteentity.o testconcreteentity.o factory.o element.o
        $(GCC)  element.o factory.o abstractentity.o testconcreteentity.o concreteentity.o -o $@

$(EXAMPLE_TEST) : testexample.o unittest.o eleve.o
        $(GCC)  testexample.o unittest.o eleve.o -o $@

testexample.o :
        $(GCC)  -c $(SRC)testexample.cxx -o $@

testconcreteentity.o :
        $(GCC) -c $(SRC)testconcreteentity.cxx -o $@

abstractentity.o :
        $(GCC)  -c $(SRC)abstractentity.cxx -o $@

concreteentity.o        :
        $(GCC)  -c $(SRC)concreteentity.cxx -o $@

unittest.o      :
        $(GCC)  -c $(SRC)unittest.cxx -o $@

eleve.o         :
        $(GCC)  -c $(SRC)eleve.cxx -o $@

$(STRIKE_TEST) : testelement.o element.o
        $(GCC) testelement.o element.o -o $@

testelement.o :
        $(GCC) -c $(SRC)testelement.cxx -o $@

element.o :
        $(GCC) -c $(SRC)element.cxx -o $@

$(FACTORY_TEST) : testfactory.o factory.o element.o
        $(GCC) testfactory.o factory.o element.o -o $@

factory.o :
        $(GCC) -c $(SRC)factory.cxx -o $@

testfactory.o :
        $(GCC) -c $(SRC)testfactory.cxx -o $@

clean :
        rm -f *.o
        rm -f $(TESTS_DIRECTORY)/*