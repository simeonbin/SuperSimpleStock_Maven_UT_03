========================
BUILD OUTPUT DESCRIPTION
========================

This is a maven project, so you can run these 2 goals:

    mvn test -> to execute the unit tests.
    mvn package -> to generate the executable jar.

USAGE
To run the program just run:
java -jar target/SuperSimpleStock_Maven_UT_03-1.0-SNAPSHOT-jar-with-dependencies.jar

CLASSES
Classes exist in following Directories

\SuperSimpleStock_Maven_UT_03\target\classes\com\simeonbiniatidis\supersimplestock_maven_ut_03
\SuperSimpleStock_Maven_UT_03\target\test-classes

In the 2nd Directory above:
Test class StockTest.class contains a few Unit Tests.
Many more need to be added.

In the 1st Directory above:
Trade is a class that contains a POJO representing a Trade.

Stock is a class managing Operations, calculations on Stocks {e.g. Dividend (on COMMON/PREFFERED), PERatio } 
and GBCE All Share Index.

SuperSimpleStock is a class that contains the main() and uses Trade and Stock classes.

It calculates Stock Price based on Summation Formula given on the Exercise sheet,
using Trades recorded past 15' minutes.
{ Stock_Price = SUM ( Trade_Price(i) * Quantuty(i) ) / SUM (Quantity(i) ) }

It also calls calculation GBCE All Share Index from Stock using 
Geometric Mean of Prices for all Stock {Math.Pow(p1*p2*p3*...*pn, 1/(n))}


