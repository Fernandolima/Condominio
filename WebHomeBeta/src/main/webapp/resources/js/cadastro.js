var CADASTRO = {
	
	init: function() {
		//ajusta footer na parte inferior do site
		var heightPage = $(window).height();
		
		if(heightPage > 550) {
			$('#main-register').css('height', heightPage - 40);
		}

		//inicializa plugin alphanumeric nos inputs do formulário
		$('#dt_nascimento').numeric();
		$("#dt_nascimento").mask("99/99/9999",{placeholder:" "});

		$('#cpf').numeric();
		$("#cpf").mask("999.999.999-99",{placeholder:" "});
	},
	
	notificar: function(e) {
		e.preventDefault();
		
		$.ajax({
			url: 'add',
			type: 'POST',
			data : $('#frm-register').serialize(),
			success: function(data) {
				if(data.allCorrect){
				
					$.ajax({
					url: '/WebHomeBeta/notificacaoNovoUsuario',
					type: 'POST',
					dataType: 'json',
					success: function(data2){
							window.location.replace("/WebHomeBeta/cadastroRealizado");
						}
					});
					
				}else{
					$('#nome').addClass(data.validName ? '' : 'error');
					$('#email').addClass(data.validEmail ? '' : 'error');
					$('#senha').addClass(data.validSenha ? '' : 'error');
					$('#confSenha').addClass(data.confSenha ? '' : 'error');
					$('#dt_nascimento').addClass(data.validDataNascimento ? '' : 'error');
					$('#cpf').addClass(data.validCpf ? '' : 'error');
					$('#bloco').addClass(data.validBloco ? '' : 'error');
					$('#apartamento').addClass(data.validApartamento ? '' : 'error');
					
					$('#senha').val('');
					$('#confSenha').val('');
				}
			}
		});
	}
}

$(function() {
	//valida se está na página de cadastro
	if($('#register-view')[0]){
		CADASTRO.init();
	}
	
	//verifica se há erro no formulário
	$('#btSubmitRegister').on('click', CADASTRO.notificar);
	//quando o form for submetido exibe o load e esconde o botão
	$('#frmLogin').on('submit', function(){
		$('#btSubmitLogin').css('display', 'none');
		$('#load-login').css('display', 'block');
	});
});