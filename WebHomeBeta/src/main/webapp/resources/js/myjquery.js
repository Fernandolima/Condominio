$(document).ready(function() {

        $.atmosphere.subscribe(
                "dates",
                callback,
                $.atmosphere.request = { transport:"websocket"});
        
        //Function to be invoked when there is a response from the server
        function callback(response) {
            $.atmosphere.log("info", ["response.state: " + response.state]);
            $.atmosphere.log("info", ["response.transport: " + response.transport]);
            $.atmosphere.log("info", ["response.status: " + response.status]);
          
            
            $("#transport").text("Transport used: " + response.transport);
            
            if(response.state=='messageReceived'){
            	if(response.status == 200){
            		var data = response.responseBody;
            		if(data){
            			$("#time").text(data);
            		}
            	}
            } else {
            	alert(response.state);
            }    
        }
}

$(function(){
	$("#inputNome").on("click")
});


