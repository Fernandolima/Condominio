var ADMIN = {
	
	esqueciMinhaSenha: function() {
		//ajusta footer na parte inferior do site
		var heightPage = $(window).height();
		
		if(heightPage > 550) {
			$('#main-forgotPassword').css('height', heightPage - 40);
		}
	},
	
	onClickItemMenu: function(e) {
		e.preventDefault();
		$(this).next('.sub-menu').fadeToggle();
	},
	
	onAddOpcao: function(e) {
		e.preventDefault();
		var htmlOpcao = '';
		
		var numEnquete = $('.opcaoEnquete').length;
		
		htmlOpcao += '<label for="listOpcoes">Opção '+ (numEnquete+1) + ':</label>';
		htmlOpcao += '<input class="opcaoEnquete" type="text" autocomplete="off" value="" name="listOpcoes['+numEnquete+']">';
		
		$('#contentFrm').append(htmlOpcao);
	},
	
	loadEnquete: function() {
		//fazer uma requisição ajax para popular o grafico
		var htmlGrafico = '';
		
		htmlGrafico += '<div class="respostas">';
			htmlGrafico += '<p class="labelResposta">Ruim</p>';
			htmlGrafico += '<span class="statusResposta" style="width:100px;"></span>';
			htmlGrafico += '<p class="numPessoas">10</p>';
		htmlGrafico += '</div>';
		
		htmlGrafico += '<div class="respostas">';
			htmlGrafico += '<p class="labelResposta">Bom</p>';
			htmlGrafico += '<span class="statusResposta" style="width:50px;"></span>';
			htmlGrafico += '<p class="numPessoas">5</p>';
		htmlGrafico += '</div>';
		
		htmlGrafico += '<div class="respostas">';
			htmlGrafico += '<p class="labelResposta">Ótimo</p>';
			htmlGrafico += '<span class="statusResposta" style="width:200px;"></span>';
			htmlGrafico += '<p class="numPessoas">20</p>';
		htmlGrafico += '</div>';
		
		$('#graficoEnquete').removeClass('load').html(htmlGrafico);
	}
}

$(function() {
	//valida se está na página de cadastro
	if($('#forgotPassword-view')[0]){
		ADMIN.esqueciMinhaSenha();
	}
	
	$('#list-user-register .link').on('click', function(e) {
		e.preventDefault();
		var user = $(this).find('a').attr('data-link');
		
		$("#loginEdit").attr("value", user);
		
		$("#frmEditarCadastro").submit();
	});
	
	$('.title-menu-drop').on('click', ADMIN.onClickItemMenu);
	
	$('#btn-adiciona-opcao').on('click', ADMIN.onAddOpcao);
	
	if($('#adminView')[0]) {
		ADMIN.loadEnquete();
	}
	
});