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
	//valida se está na página de cadastro
	if($('#forgotPassword-view')[0]){
		ESQUECI_SENHA.init();
	}
	
	$('#list-user-register .link').on('click', function(e) {
		e.preventDefault();
		var user = $(this).find('a').attr('data-link');
		
		$.post('editarCadastro', {login: user});
	});
});