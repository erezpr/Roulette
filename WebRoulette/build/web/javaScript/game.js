
var intr;
var timerIntr;
var stopUpdate;
var secends = 31;
$(function () {
    $("#doneButton").hide();
    getboardGrid();
    playerInfoIntr = window.setInterval(updatePlayerTable, 1000);
    var eventIntr = window.setInterval(getEvent, 1000);
    stopUpdate = window.setInterval(stopUpdatePlayerTable, 500);


});

function stopUpdatePlayerTable() {
    var str = $("#massage").text();
    if (str === "GAME_START") {
        clearInterval(playerInfoIntr);
        clearInterval(stopUpdate);
    }
}
function getEvent() {
    $.ajax({
        data: "",
        url: "event",
        timeout: 3000,
        error: function () {
            console.error("Failed to send ajax");
        },
        success: function (eventList) {
            $.each(eventList || [], events);
        }
    });
}
function events(index, event) {
    var eventType = event.type;
    switch (eventType) {
        case 'GAME_START':
            {
                $("#doneButton").show();
                $("#massage").text("GAME_START");
                enableTable();
                startTimer();
            }
            break;
        case 'PLAYER_BET':
            {
                updatePlayerTable();
            }
            break;
        case 'WINNING_NUMBER':
            {
                rotate();
                $("#winningNumbers").append("<tr><td>" + event.winningNumber + "</td></tr>");
            }
            break;
        case 'RESULTS_SCORES':
        {
            updatePlayerTable();
            getboardGrid();
            enableTable();
        }
        case 'PLAYER_RESIGNED':
        {

        }
    }

}
function updatePlayerTable() {
    $.ajax({
        data: "",
        url: "playerInfo",
        timeout: 3000,
        error: function () {
            console.error("Failed to send ajax");
        },
        success: function (response) {
            $(".playerInfoTable").empty();
            $(".playerInfoTable").append(response);
        }
    });
}
function getboardGrid() {
    $.ajax({
        data: "",
        url: "boardGenerator",
        timeout: 3000,
        error: function () {
            console.error("Failed to send ajax");
        },
        success: function (response) {
            $("#rouletteBoard").empty();
            $("#rouletteBoard").append(response);
        }
    });

}


function finnishBetting() {
    $.ajax({
        data: "",
        url: "finnishBetting",
        timeout: 3000,
        error: function () {
            console.error("Failed to send ajax");
        },
        success: function (response) {

        }
    });
}
function updateMoneyLabel(value) {
    $("#moneyOnbetLabel").val(value);
    $("#moneyOnbetLabel").text(value);
}
function timer() {
    secends--;
    if (secends > -1) {
        document.getElementById("timer").innerHTML = "TIMER:" + secends;
    }
    else {
        clearInterval(timerIntr);
    }
}
function startTimer() {
    clearInterval(timerIntr);
    secends = 31;
    timerIntr = window.setInterval(timer, 1000);
}
function disableTable() {
    $("#rouletteBoardTable-1").hide();
    $("#rouletteBoardTable-2").hide();
    $("#rouletteBoardTable-3").hide();
    $("#rouletteBoardTable-4").hide();
}
function enableTable() {
    $("#rouletteBoardTable-1").show();
    $("#rouletteBoardTable-2").show();
    $("#rouletteBoardTable-3").show();
    $("#rouletteBoardTable-4").show();
}
function rotate() {
    $(".rouletteWheel").toggleClass("rotated");
}