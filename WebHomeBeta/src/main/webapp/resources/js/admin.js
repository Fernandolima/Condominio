var ADMIN = {
		
	numeroEspaco : 1,
	
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
		
	},
	
	espacos: function(e) {
		
		var el = $(e).attr('value'),
			divPai = $(e).closest('.espacos').find('.outroEspaco'),
			descricao = $(e).closest('.espacos').find('.descricaoArea');
		
		descricao.val('');
				
		if(el === 'outro') {
			divPai.html('<label>Outro Espaço: </label><input type="text" name="novoespao" />');
		} else {
			divPai.html('');			
		}
	},
	
	addEspaco: function(e) {
		e.preventDefault();
		
		var htmlEspaco = '';
		
		htmlEspaco += '<div class="espacos">';
			htmlEspaco += '<div class="comboEspaco '+ADMIN.numeroEspaco+'"></div>';
			htmlEspaco += '<div class="outroEspaco"></div>';
				htmlEspaco += '<div class="elInput">';
				htmlEspaco += '<label>Descrição: </label>';
				htmlEspaco += '<input type="text" class="descricaoArea" />';
			htmlEspaco += '</div>';
		htmlEspaco += '</div>';
		
		$('#content-espaco').append(htmlEspaco);
		
		var criado = $('.comboEspaco.'+ADMIN.numeroEspaco);
		
		$('#comboEspacoList').clone().appendTo(criado);	
		
		ADMIN.numeroEspaco++;
	}
}

$(function() {

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
	
	$('#addEspaco').on('click', ADMIN.addEspaco);
	
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