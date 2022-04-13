set projectpath=D:\eclipse_1\Test_Automation_Lab
cd %projectpath%

set classpath=%projectpath%\bin;%projectpath%\lib\*
java org.testng.TestNG %projectpath%\testng.xml
pause