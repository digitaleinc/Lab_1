You should have preinstalled Java 17+
https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html

1. Install Maven - https://maven.apache.org/download.cgi
2. Make mvn to run in path
3. Install sources:
git clone https://github.com/digitaleinc/Lab_1.git
4. Run:
cd Lab_1
5. Run:
mvn clean package
6. Run new created Java (jar) file:
java -jar target/(generated_file).jar

Additional:

If you have some unknown sybmols in console - just write down in console before running app:
chcp 65001

This will change default encoding in console
