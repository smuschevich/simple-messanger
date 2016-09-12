(function() {
	$(document).ready(function() {
		$('#form').submit(function(e) {
			e.preventDefault();
			if (validateForm()) {
				createWebSocket();
			}
		})
	});

	function validateForm() {
		var valid = $('#form #messagesCount').val() && $('#form #messagesInterval').val();
		if (!valid) {
			$('#formError').removeClass("hidden");
			
		} else {
			$('#formError').addClass("hidden");
		}
		return valid;
	}

	var states = {
		initial: 'initial',
		hello: 'hello',
		messaging: 'messaging'
	}
	
	function createWebSocket() {
		var ws = $.WebSocket('ws://localhost:8081/service/jms');

		ws.onopen = function(e) {
			send(ws, 'hello');
		};

		var state = states.initial;
		ws.onmessage = function(e) {
			if (state === states.initial) {
				if (read(e).data === true) {
					state = states.hello;
					send(ws, 'request', {
						messagesCount: parseInt($('#form #messagesCount').val()),
						messagesInterval: parseInt($('#form #messagesInterval').val())
					})
				}
			} else if (state === states.hello) {
				state = states.messaging;
			} else if (state === states.messaging) {
				
			}
		}

		ws.onerror = function(e) {
			console.log ('Error with WebSocket uid: ' + e.target.uid);
		};

		return ws;
	}

	function send(ws, cmd, args) {
		ws.send(JSON.stringify({
			command: cmd,
			args: args || {}
		}));
	}

	function read(e) {
		return JSON.parse(e.data);
	}
})();