<!DOCTYPE HTML>
<html lang="en">
  <head>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700" rel="stylesheet" type="text/css" />
    <link href="resources/css/mystyle.css" rel="stylesheet" type="text/css" />
    <script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
  </head>
  <body ng-app="chatApp">
    <div ng-controller="ChatCtrl" class="container">
      <form ng-submit="addMessage()" name="messageForm">
        <input type="text" placeholder="Compose a new message..." ng-model="message" />
        <div class="info">
          <span class="count" ng-bind="max - message.length" ng-class="{danger: message.length > max}">140</span>
          <button ng-disabled="message.length > max || message.length === 0">Send</button>
        </div>
      </form>
      <hr />
      <p ng-repeat="message in messages | orderBy:'time':true" class="message">
        <time>{{message.time | date:'HH:mm'}}</time>
        <span ng-class="{self: message.self}">{{message.message}}</span>
        {{message.getMessage()}}
      </p>
    </div>

<script>
var app = angular.module('myApp', ["chatApp.controllers",
                                   "chatApp.services"]);

angular.module("chatApp.controllers", []);
angular.module("chatApp.services", []);
app.controller('myCtrl', function($scope) {
    $scope.firstName = "John";
    $scope.lastName = "Doe";
});


</script>
<script>
angular.module("chatApp", [
                           "chatApp.controllers",
                           "chatApp.services"
                         ]);

                         angular.module("chatApp.controllers", []);
                         angular.module("chatApp.services", []);
</script>
<script>
angular.module("chatApp.controllers").controller("ChatCtrl", function($scope, ChatService) {
	  $scope.messages = [];
	  $scope.message = "";
	  $scope.max = 140;

	  $scope.addMessage = function() {
	    ChatService.send($scope.message);
	    $scope.message = "";
	  };

	  ChatService.receive().then(null, null, function(message) {
	    $scope.messages.push(message);
	  });
	});
</script>
<script type="text/javascript">
angular.module("chatApp.services").service("ChatService", function($q, $timeout) {
    
    var service = {}, listener = $q.defer(), socket = {
      client: null,
      stomp: null
    }, messageIds = [];
    
    service.RECONNECT_TIMEOUT = 30000;
    service.SOCKET_URL = "/project2/chat";
    service.CHAT_TOPIC = "/topic/message";
    service.CHAT_BROKER = "/app/chat";
    
    service.receive = function() {
      return listener.promise;
    };
    
    service.send = function(message) {
      var id = Math.floor(Math.random() * 1000000);
      socket.stomp.send(service.CHAT_BROKER, {
        priority: 9
      }, JSON.stringify({
        message: message,
        id: id
      }));
      messageIds.push(id);
    };
    
    var reconnect = function() {
      $timeout(function() {
        initialize();
      }, this.RECONNECT_TIMEOUT);
    };
    
    var getMessage = function(data) {
      var message = JSON.parse(data), out = {};
      out.message = message.message;
      out.time = new Date(message.time);
      if (_.contains(messageIds, message.id)) {
        out.self = true;
        messageIds = _.remove(messageIds, message.id);
      }
      return out;
    };
    
    var startListener = function() {
      socket.stomp.subscribe(service.CHAT_TOPIC, function(data) {
        listener.notify(getMessage(data.body));
      });
    };
    
    var initialize = function() {
      socket.client = new SockJS(service.SOCKET_URL);
      socket.stomp = Stomp.over(socket.client);
      socket.stomp.connect({}, startListener);
      socket.stomp.onclose = reconnect;
    };
    
    initialize();
    return service;
  });
</script>

 <script src="resources/lib/sockjs/sockjs.min.js" type="text/javascript"></script>
     <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.1/sockjs.js" type="text/javascript"></script>-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js" type="text/javascript"></script>
     <script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/3.10.1/lodash.min.js"></script>
</div>
</body>
</html>

