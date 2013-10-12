var ADMIN = {
	
	init: function(){
		
		$.ajax({
	    	type: 'post',
	      	url:'loadEnquetes',
	      	dataType: 'json',	
	      	success: ADMIN.loadEnquete
		});
	},	
		
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
	
	loadEnquete: function(data) {
		//fazer uma requisição ajax para popular o grafico
		var htmlGrafico = '';
		
		$.each(data, function(b, enquete){
			htmlGrafico += '<div id = "statusEnquete">';
			htmlGrafico += '<span id="iconEnquete"></span><h2>Enquete</h2>';
			htmlGrafico += '<p><b>Enquete ativa no momento:</b>'+enquete.titulo+'<br/>';
			htmlGrafico += '<b>Números de pessoas participando:</b>'+enquete.totalVotos+'<p>';
			htmlGrafico += '<div id="graficoEnquete" class="load">';
				
			
			$.each(enquete.opcoes, function(o, opc){
				
					htmlGrafico += '<div class="respostas">';
					htmlGrafico += '<p class="labelResposta">'+opc.opcao+'</p>';
					htmlGrafico += '<span class="statusResposta" style="width:100px;"></span>';
					htmlGrafico += '<p class="numPessoas">'+opc.quantidadeVotos+'</p>';
					htmlGrafico += '</div>';
			});
			htmlGrafico += '</div>';
		$('#graficoEnquete').removeClass('load').html(htmlGrafico);
		$('#enquetes').append(htmlGrafico);
		htmlGrafico = '';
		});
		
	}
}

$(function() {
	console.log("a");
	ADMIN.init();
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
	}
	
	if($('#cadastrar-atasView')[0]) {
		var wrapper = $('<div/>').css({height:0,width:0,'overflow':'hidden'});
		var fileInput = $(':file').wrap(wrapper);

		fileInput.change(function(){
		    $this = $(this);
		    $('#file').text($this.val());
		})

		$('#file').click(function(){
		    fileInput.click();
		}).show();
	}
	
});