var CALENDAR  = {	
				
	init: function() {
		
		var idEspaco = $('#idEspaco').val();
		
		$.ajax({
	    	type: 'POST',
	      	url:'/WebHomeBeta/home/calendar',
	      	data: {idEspaco : idEspaco},
	      	success: CALENDAR.loadCalendario,
	      	error: function(e) {
	      		console.log('erro = ', e);
	      	}
	    });
	},
	
	loadCalendario: function(data) {
		var calendar = $('#calendar').fullCalendar({
			header: {
				left: 'prev,next',
				center: 'title',
				right: 'month,basicWeek,basicDay'
			},
			selectable: true,
            selectHelper: true,
            
            dayClick: function(date, allDay, jsEvent, view) {
            	var count = 0,
            		dia = date.getDate(),
            		mes = date.getMonth() + 1,
            		ano = date.getFullYear();
            	
				$('#calendar').fullCalendar('clientEvents', function(event) {
					if(event.start.getTime() == date.getTime()) {
						count++;
						return false;
					}
				});
				
				if(count == 0) {
					count++;
					var title = prompt('Digite o evento para solicitar a reserva para o dia: ' + dia+'/'+mes+'/'+ano + '?\nA reserva será enviada para aprovação');
            
				if (title) {
					console.log('title = ', title);
					console.log('date = ', date);
					console.log('idEspaco = ', $('#idEspaco').val());
					console.log('idUser = ', $('#userSessao').val());
					
					$.ajax({
				    	type: 'POST',
				      	url:'/WebHomeBeta/event/save',
				      	data: {idEspaco : $('#idEspaco').val(), titulo: title, idUser: $('#userSessao').val(), dia: dia, mes: mes, ano:ano},
				      	success: CALENDAR.enviadoSucesso,
				      	error: function(e) {
				      		console.log('erro = ', e);
				      	}
				    });
                
				}
            calendar.fullCalendar('unselect');
				}
				
			},
			events: data
		});
	},
	
	enviadoSucesso: function(data) {
		console.log('enviadooooo = ', data);
	}
}

$(function() {
	
	if($('#calendarView')[0]) {
		CALENDAR.init();
	}
	
});