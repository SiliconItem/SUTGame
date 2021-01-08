function infoge2() {
    console.log("INFO GATHERING");
    alert("INFO GETHERING");
}



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

function sendMessage(cid) {
    stompClient.send("/app/event", {}, JSON.stringify({'commandName':'tabulator', 'target':cid}));
}

function showMessageOutput(messageOutput) {
    var cid = messageOutput.target;
    var commandName = messageOutput.commandName;
    var color = messageOutput.color;
    var audio = new Audio("/media/s3.mp3");
    document.getElementById(cid).style.backgroundColor  = color;
    document.getElementById(cid).style.opacity = '0.3';
    audio.play()
}