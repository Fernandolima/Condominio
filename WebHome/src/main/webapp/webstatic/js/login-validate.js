var LOGIN = {
	hash: null,
	
	init: function() {
		hash = location.href.split('?');
		hash = hash[1];
		
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
	if($('#login-view')[0]){
		LOGIN.init();
	}
	
	$('#frmLogin').on('submit', function(){
		$('#frmLogin').display('block');
	});
});