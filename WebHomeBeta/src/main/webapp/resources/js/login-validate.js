var LOGIN = {
	hash: null,
	init: function() {
		//pega par�metro da URL
		hash = location.href.split('?');
		hash = hash[1];
		
		//faz os tratamentos de erros conforme hash passada por par�metro
		if(hash !== '') {
			switch (hash) {
				case 'error':
					$('body').addClass('error');
					$('#warnningMessage').html('<p>Usu&aacute;rio ou senha inv&aacute;lido</p>');
				break;
				case 'userBlock':
					$('body').addClass('error');
					$('#warnningMessage').html('<p>Usu&aacute;rio bloqueado.<br/>Contate o administrador</p>');
				break;
			}
		}
	}
}

$(function() {
	//valida se est� na p�gina de login
	if($('#login-view')[0]){
		LOGIN.init();
	}
	//quando o form for submetido exibe o load e esconde o bot�o
	$('#frmLogin').on('submit', function(){
		$('#btSubmitLogin').css('display', 'none');
		$('#load-login').css('display', 'block');
	});
});