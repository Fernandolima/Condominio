var ESQUECI_SENHA = {
	
	init: function() {
		//ajusta footer na parte inferior do site
		var heightPage = $(window).height();
		
		if(heightPage > 550) {
			$('#main-forgotPassword').css('height', heightPage - 40);
		}
	}	
}

$(function() {
	//valida se est� na p�gina de cadastro
	if($('#forgotPassword-view')[0]){
		ESQUECI_SENHA.init();
	}
});