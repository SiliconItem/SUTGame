var stompClient = null;
function setConnected(connected) {

}
function infoge() {
    console.log("INFO GATHERING");
    alert("INFO GETHERING");
}
function connect() {
    var socket = new SockJS('/event');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/messages', function(messageOutput) {
            showMessageOutput(JSON.parse(messageOutput.body));
        });
    });
}

function disconnect() {
    if(stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage(field, cid) {
    stompClient.send("/app/event", {}, JSON.stringify({'commandName':field, 'target':cid}));
}

function infoge2() {
    console.log("INFO GATHERING");
    alert("INFO GETHERING");
}


btn.onclick = function () {
    modal.style.display = "block";
}

document.getElementsByClassName("close_modal_window")[0].onclick = function () {
    modal.style.display = "none";
}

window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}


function showMessageOutput(messageOutput) {
    var cid = messageOutput.target;
    var commandName = messageOutput.commandName;
    var color = messageOutput.color;
    var audio = new Audio("/media/s3.mp3");

    var qAction = messageOutput.action;
    if (qAction) {
        var modal = $modal({
            title: 'Текст заголовка',
            content: '<p>Содержимое модального окна...</p>',
            footerButtons: [
                { class: 'btn btn__cancel', text: 'Отмена', handler: 'modalHandlerCancel' },
                { class: 'btn btn__ok', text: 'ОК', handler: 'modalHandlerOk' }
            ]
        });
        modal.show();
    }


    document.getElementById(cid).style.backgroundColor  = color;
    document.getElementById(cid).style.opacity = '0.3';
    audio.play()
}


