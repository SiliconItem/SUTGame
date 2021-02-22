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

    if (messageOutput.configured){
        var imageEl = document.getElementById('IMG'+cid);
        imageEl.src = messageOutput.image;
        imageEl.style.opacity = 1;
        var audio = new Audio(messageOutput.sound);
        audio.play()
    } else {
        var node = document.getElementById(cid);
        node.removeChild(node.lastChild);
        document.getElementById(cid).style.backgroundColor = messageOutput.color;
        document.getElementById(cid).style.opacity = '0.5';

    }


}


