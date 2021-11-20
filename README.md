 FreeleticsRepo
Automation project created using selenium automation tool written in testng Java.

# Technologies Used:
1.  Selenium WebDriver with Java Language binding
2.  JDK 1.8
3.  Maven (Build tool) dependencies
4.  Maven Plugins
5.  Allure report
6.  TestNG library
7.  GIT HUB - Git Repo
8.  Eclipse (IDE)

# Project Components
I have design different components in this Framework:
1. Base page class is used to have all methods
2. BaseTest class with before and after scenarios
3. Allure Listener
4. TestNG xml
5. Driver factory
6. ElementUtil
7. Constant file
8. Maven with pom.xml with different dependencies and plugins
9. Screenshot will be saved in /screenshots folder for Failed tests
10. log4j

# Pre-requisite
      Ensure following plugins installed else follow below methods
      
      [1]Use Eclipse IDE
      
      [2]Download Maven from <http://maven.apache.org/download.cgi>
        download binray,zip file and extract to your local folder after that set 2 new environement variables
        ( M2_HOME and MAVEN_HOME with following path [C:\Program Files\apache-maven-3.8.1]
        and add following path in path variable [C:\Program Files\apache-maven-3.8.1\bin]
        
      [3]Steps to add TestNG plugin:
         From Eclipse, go to menu Help then select Install New software
         Work with: <[https://testng.org/testng-eclipse-update-site/6.14.3]>
         Select the check-box for TestNG Plugin
         Select Next as per the instruction shown during installation.
         Restart your Eclipse after completion of instruction.
      
      [4]Add TestNG library from Project
         Click on project Properties-> [Java Build Path]-> Libraries->Add Library->
         select [TestNG] latest version and click on [Apply] button then [Apply & Close] button

# How to use
1.  You can clone this project
2.  open project in eclipse
3.  Access <b>pom.xml</b> file
4.  Update project as maven to install all depenendencies
5.  Open command prompt and use following command to execute test [<b>mvn clean install</b>]
6.  Execute Allure report by using following command [<b> allure serve allure-results </b>]
7.  you can see the log in log file generated after test, just refresh the project in eclipse.
