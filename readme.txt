Application is available online at http://forexdemo-kirillrublevsky.rhcloud.com/

Project "ForexDemo" is created to emulate real Forex trading.
It is supposed to allow you to buy/sell USD for UAH, store your
balance in UAH, balance in USD and randomly generate exchange rate,
emulating real currency dynamics.

This project has 3 tables in H2 database:
-UAH balance;
-USD balance;
-Exchange rate;

Exchange rate is generated by specific algorithm once in 30sec
(or other timeout, whatever) and then stored in database.
After that the rate is uploaded from database to our web application.

Web page has three fields downloading data from base - UAH balance,
USD balance and rate. It also has two input fields with submit
buttons: "Buy" and "Sell".

Technologies used in this project:
Java 7, Spring, Hibernate, Spring MVC, H2 in-memory database,
Maven, Git, HTML, CSS, JavaScript, jQuery, Ajax.

Test coverage is not finished yet.
