'use strict';

var usernamePage = document.querySelector('#username-page');
var chatPage = document.querySelector('#chat-page');
var usernameForm = document.querySelector('#usernameForm');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');
var connectingElement = document.querySelector('.connecting');

var stompClient = null;
var username = null;
var username2=null

var colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];
var token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJBNTU1NTUiLCJpYXQiOjE2OTI1MjM1MDQsImV4cCI6MTY5MzYwMzUwNH0.GlvwpWzrudAHZ8vd0vCL7UFMFsGzANwrvvjblq0AqQI";
        var headers = {
            Authorization: token
        };

function connect(event) {
    username = document.querySelector('#name').value.trim();

    if(username) {
        usernamePage.classList.add('hidden');
        chatPage.classList.remove('hidden');

        var socket = new SockJS('http://localhost:8081/ws-food');
        stompClient = Stomp.over(socket);
        console.log(stompClient)
        stompClient.connect({}, onConnected, onError);
    }
    event.preventDefault();
}


function onConnected() {
    // Subscribe to the Public Topic
    stompClient.subscribe(' topic/use-voucher', onMessageReceived); 
    // Tell your username to the server
    stompClient.send("app/use-voucher",
        // JSON.stringify()
    )

    connectingElement.classList.add('hidden');
}


function onError(error) {
    connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
    connectingElement.style.color = 'red';
}


function sendMessage(event) {
    stompClient.subscribe('/public/send-mess', onMessageSend); 
    var messageContent = messageInput.value.trim();
    if(messageContent && stompClient) {
        var chatMessage = {
            userId: 3,
            content: messageInput.value,
            roomId:3
        };
        stompClient.send("/topic/send-mess", {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
    event.preventDefault();
}

function onMessageSend(payload) {
    // console.log(payload)
  }

function onMessageReceived(payload) {
  console.log(payload)
}


function getAvatarColor(messageSender) {
    var hash = 0;
    for (var i = 0; i < messageSender.length; i++) {
        hash = 31 * hash + messageSender.charCodeAt(i);
    }
    var index = Math.abs(hash % colors.length);
    return colors[index];
}

usernameForm.addEventListener('submit', connect, true)
messageForm.addEventListener('submit', sendMessage, true)
