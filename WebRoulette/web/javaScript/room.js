$(function () {
    var intr = window.setInterval(refrashTable, 1000);
});
function refrashTable() {
    jQuery.ajax({
        data: "",
        url: "room",
        timeout: 2000,
        error: function () {
            console.error("Failed to send ajax");
        },
        success: function (response) {
            $("#waitingGamesTable").replaceWith(response);

        }
    });
}
function join(gameName) {
    document.getElementById('gameName').value = gameName;
    document.forms['joinGameForm'].submit();

}

