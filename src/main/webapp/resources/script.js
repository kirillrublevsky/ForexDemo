$(document).ready(function(){

    setInterval(function(){
        $.get("/getRate", function (data) {
            var oldRate = $("#rate").text();
            var newRate = $.parseJSON(data).rate;
            var max = ($("#balance").text() / newRate).toFixed(2);
            $("#rate").text(newRate);
            $("#max").text(max);

            if(newRate > oldRate){
                $("#trend").text("is growing").css("color", "green");
            } else {
                $("#trend").text("is falling").css("color", "red");
            }
        })
    },30000);

    $("#buyButton").click(function(){
        var text = "";
        var dollarsToBuy = $("#dollarsToBuy").val();
        var rate = $("#rate").text();
        var maxToBuy = ($("#balance").text() / rate).toFixed(2);

        if (isNaN(dollarsToBuy)) {
            text = "Wrong input, please type a number";
        } else if (dollarsToBuy == "") {
            text = "The input field can't be empty";
        } else {
            dollarsToBuy = parseFloat(dollarsToBuy);
            if (dollarsToBuy < 1) {
                text = "Amount to buy can't be less than 1 USD";
            } else if (dollarsToBuy > maxToBuy) {
                text = "Amount to buy can't be larger than " + maxToBuy;
            } else if (!(/^(([0-9]+)|([0-9]+)\.([0-9]{0,2}))$/.test(dollarsToBuy))) {
                text = "Only dollars and cents are allowed";
            } else {
                text = dollarsToBuy + " dollars successfully purchased for " +
                (dollarsToBuy * rate).toFixed(2) + " UAH";
                $.post("/buyDollars", {"amount": dollarsToBuy}, function (data) {
                    var JSONobject = $.parseJSON(data);
                    $("#balance").text(JSONobject.balance);
                    $("#dollars").text(JSONobject.dollars);
                })
            }
        }
            $("#console").text(text);
            setTimeout(function(){$("#console").text("");}, 2000);
    });

    $("#sellButton").click(function(){
        var text = "";
        var dollarsToSell = $("#dollarsToSell").val();
        var maxToSell = $("#dollars").text();

        if (isNaN(dollarsToSell)) {
            text = "Wrong input, please type a number";
        } else if (dollarsToSell == "") {
            text = "The input field can't be empty";
        } else {
            dollarsToSell = parseFloat(dollarsToSell);
            if (dollarsToSell < 1) {
                text = "Amount to sell can't be less than 1 USD";
            } else if (dollarsToSell > maxToSell) {
                text = "Amount to sell can't be larger than " + maxToSell;
            } else if (!(/^(([0-9]+)|([0-9]+)\.([0-9]{0,2}))$/.test(dollarsToSell))) {
                text = "Only dollars and cents are allowed";
            } else {
                text = dollarsToSell + " dollars successfully sold for " +
                (dollarsToSell * $("#rate").text()).toFixed(2) + " UAH";
                $.post("/sellDollars", {"amount" : dollarsToSell}, function (data) {
                    var JSONobject = $.parseJSON(data);
                    $("#balance").text(JSONobject.balance);
                    $("#dollars").text(JSONobject.dollars);
                })
            }
        }
        $("#console").text(text);
        setTimeout(function(){$("#console").text("");}, 2000);
    });

});


