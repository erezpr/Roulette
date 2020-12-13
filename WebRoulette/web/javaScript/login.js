function reload() {
    $.ajax({
        data: "playerName=" + $("#playerName").val(),
        url: "login",
        timeout: 2000,
        error: function () {
            console.error("Failed to send ajax");
        },
        success: function (response) {
            $("#container").empty();
            $("#container").append(response);
        }
    });
}
$(function () {
    reload();
});
function submit() {
    if ($("#playerName").val() === "") {
        $(".error").text("NAME FIELD IS EMPTY");
    }
    else {
        reload();
    }
}

