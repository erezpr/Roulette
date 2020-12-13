function placeBet(event, betType, n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15, n16, n17, n18) {
    if (betType === "CORNER")
        $(event).append("<img class='chip' src='images/5chip.png' width='30' height='30' alt='' style='top: -8px; left: -13px;'/>");
    if (betType === "SPLIT")
        if ((n2 - n1) === 1)
            $(event).append("<img class='chip' src='images/5chip.png' width='30' height='30' alt='' style='top: -8px; left: -5px;'/>");
        else
            $(event).append("<img class='chip' src='images/5chip.png' width='30' height='30' alt='' style='top: 15px; left: -13px;'/>");
    if (betType === "STRAIGHT")
        $(event).append("<img class='chip' src='images/5chip.png' width='30' height='30' alt='' style='top: 15px; left: -6px;'/>");
    if (betType === "COLUMN1" || betType === "COLUMN2" || betType === "COLUMN3")
        $(event).append("<img class='chip' src='images/5chip.png' width='30' height='30' alt='' style='top: 7px; left: -3px;'/>");
    if (betType === "PREMIERE_DOUZAINE" || betType === "MOYENNE_DOUZAINE" || betType === "DERNIERE_DOUZAINE")
        $(event).append("<img class='chip' src='images/5chip.png' width='30' height='30' alt='' style='top: -6px; left: 50px;'/>");
    if (betType === "MANQUE" || betType === "PAIR" || betType === "NOIR" || betType === "ROUGE" || betType === "IMPAIR" || betType === "PASSE")
        $(event).append("<img class='chip' src='images/5chip.png' width='30' height='30' alt='' style='top: -2px; left: 15px;'/>");
    if (betType === "SIX_LINE")
        $(event).append("<img class='chip' src='images/5chip.png' width='30' height='30' alt='' style='top: -13px; left: -13px;'/>");
    if (betType === "STREET")
        $(event).append("<img class='chip' src='images/5chip.png' width='30' height='30' alt='' style='top: -13px; left: -6px;'/>");
    
    $.ajax({
        data: {
            betType: betType,
            moneyOnBet: $("#moneyOnbetLabel").text(),
            num1: n1,
            num2: n2,
            num3: n3,
            num4: n4,
            num5: n5,
            num6: n6,
            num7: n7,
            num8: n8,
            num9: n9,
            num10: n10,
            num11: n11,
            num12: n12,
            num13: n13,
            num14: n14,
            num15: n15,
            num16: n16,
            num17: n17,
            num18: n18
        },
        url: "betting",
        timeout: 3000,
        error: function () {
            console.error("Failed to send ajax");
        },
        success: function (response) {
            if (response === "NOT ENOUGH MONEY") {
                $("#massage").text(response);
            }

        }
    });

}