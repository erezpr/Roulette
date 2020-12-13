

window.onload = function () {
    var fileInput = document.getElementById('fileInput');
    var fileDisplayArea = document.getElementById('fileDisplayArea');

    fileInput.addEventListener('change', function (e) {
        var file = fileInput.files[0];
        var textType = /text.*/;

        if (file.type.match(textType)) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $.ajax({
                    data: {fileContent:reader.result},
                    url: "loadGame",
                    timeout: 3000,
                    error: function () {
                        console.error("Failed to send ajax");
                    },
                    success: function (response) {
                        if (response === "")
                            $("#massage").text("GAME HAS LOADED SECCESFULLY GO TO ROOM TO JOIN THE GAME")
                        else
                            $("#massage").text(response);
                    }
                });
            };

            reader.readAsText(file);
        } else {
            fileDisplayArea.innerText = "File not supported!";
        }
    });
};
