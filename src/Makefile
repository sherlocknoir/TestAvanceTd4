JMLC = jmlc -O -Q
RM = rm
JAVA = java
JAVAC = javac
JUNIT4 = /usr/share/java/junit4.jar
JMLRUNTIME = /usr/share/jml/bin/jmlruntime.jar
JMLCLASSPATH = .:$(JMLRUNTIME)
JMLJUNITCLASSPATH = $(JMLCLASSPATH):$(JUNIT4)

run : ExplosivesMain.class
	$(JAVA) -cp $(JMLCLASSPATH) ExplosivesMain

Explosives.class : Explosives.java
	$(JMLC) Explosives.java

ExplosivesMain.class : Explosives.class ExplosivesMain.java
	$(JAVAC) ExplosivesMain.java

TestExplosivesJUnit4.class : Explosives.class TestExplosivesJUnit4.java
	$(JAVAC) -classpath $(JMLJUNITCLASSPATH)  TestExplosivesJUnit4.java

TestExplosivesJUnit4.run : TestExplosivesJUnit4.class
	 java -cp $(JMLJUNITCLASSPATH) TestExplosivesJUnit4

TestExplosivesJUnit4Public.class : Explosives.class TestExplosivesJUnit4Public.java
	$(JAVAC) -classpath $(JMLJUNITCLASSPATH)  TestExplosivesJUnit4Public.java

TestExplosivesJUnit4Public.run : TestExplosivesJUnit4Public.class
	 java -cp $(JMLJUNITCLASSPATH) TestExplosivesJUnit4Public

TestExplosivesFindBat.class : Explosives.class TestExplosivesFindBat.java
	$(JAVAC) -classpath $(JMLJUNITCLASSPATH)  TestExplosivesFindBat.java

TestExplosivesFindBat.run : TestExplosivesFindBat.class
	 java -cp $(JMLJUNITCLASSPATH) TestExplosivesFindBat

eclipseBin :
	cp *.class ../bin
	
clean : 
	$(RM) *.class

