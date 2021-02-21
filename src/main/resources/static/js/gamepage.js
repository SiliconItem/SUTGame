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

function sendMessage(field, cid) {
    stompClient.send("/app/event", {}, JSON.stringify({'commandName':field, 'target':cid}));
}

function showMessageOutput(messageOutput) {
    var cid = messageOutput.target;
    var color = messageOutput.color;
    var image = messageOutput.image;
    var audio = new Audio(messageOutput.sound);

    var qAction = messageOutput.action;
    if (qAction) {
        var ff1 = messageOutput.actionData;
        var ff2 = messageOutput.actionReq1;
        var ff3 = messageOutput.actionReq2;
        var ff4 = messageOutput.actionReq3;

        var modal = $modal({
            title: ff1,
            content: ff2 +'<br>' + ff3 + '<br>' + ff4,
         /*   footerButtons: [
                { class: 'btn modal__btn-close', text: 'Отмена', handler: 'modalHandlerCancel' },
                { class: 'btn btn__ok', text: 'ОК', handler: 'modalHandlerOk' }
            ]*/
        });
        modal.show();
    }

    if (image != null){
        document.getElementById(cid).style.background = image;
        document.getElementById(cid).style.backgroundImage = image;
        document.getElementById(cid).style.opacity = '0.5';
    } else {
        document.getElementById(cid).style.backgroundColor = "red"
        document.getElementById(cid).style.opacity = '0.5';
    }
    audio.play()
}


