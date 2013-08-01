var CADASTRO = {
	
	init: function() {
		//ajusta footer na parte inferior do site
		var heightPage = $(window).height();
		
		if(heightPage > 550) {
			$('#main-register').css('height', heightPage - 40);
		}

		//inicializa plugin alphanumeric nos inputs do formul�rio
		$('#dt_nascimento').numeric();
		$("#dt_nascimento").mask("99/99/9999",{placeholder:" "});

		$('#cpf').numeric();
		$("#cpf").mask("999.999.999-99",{placeholder:" "});
	}	
}

$(function() {
	//valida se est� na p�gina de cadastro
	if($('#register-view')[0]){
		CADASTRO.init();
	}
	
	//quando o form for submetido exibe o load e esconde o bot�o
	$('#frmLogin').on('submit', function(){
		$('#btSubmitLogin').css('display', 'none');
		$('#load-login').css('display', 'block');
	});
});