var ADMIN = {
		
	numeroEspaco : 1,
	
	init: function(){
		
		if($('#adminView')[0]) {
			$.ajax({
		    	type: 'post',
		      	url:'loadEnquetes',
		      	dataType: 'json',	
		      	success: ADMIN.loadEnquete
			});
		}
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
		var htmlGrafico = '',
			numTotalVotos = ''
			result = '';
		
		if(data.length > 0) {
		
			$.each(data, function(b, enquete){
				htmlGrafico += '<div class="dataEnquete">';
					htmlGrafico += '<p><b>Enquete ativa no momento:</b> '+enquete.titulo+'<br/>';
					htmlGrafico += '<b>Números de pessoas participando:</b> '+enquete.totalVotos+'<p>';
					numTotalVotos = enquete.totalVotos;
					
				$.each(enquete.opcoes, function(o, opc){
						result = opc.quantidadeVotos * 100;
						result = result / numTotalVotos;
						htmlGrafico += '<div class="respostas">';
							htmlGrafico += '<p class="labelResposta">'+opc.opcao+'</p>';
							htmlGrafico += '<span class="statusResposta" style="width:'+result+'px;"></span>';
							htmlGrafico += '<p class="numPessoas">'+opc.quantidadeVotos+'</p>';
						htmlGrafico += '</div>'; 				
				});
				htmlGrafico += '</div>';
			
				$('#graficoEnquete').removeClass('load').append(htmlGrafico);
				htmlGrafico = '';
			});
		} else {
			$('#graficoEnquete').removeClass('load').html('<p>Nenhuma enquete ativa no momento</p>');
		}
		
	},
	
	espacos: function(e) {
		var el = $(e).attr('value'),
			divPai = $(e).closest('.espacos').find('.outroEspaco'),
			descricao = $(e).closest('.espacos').find('.descricaoArea');
		
		descricao.val('');
				
		if(el === 'Outro') {
			divPai.html('<label>Outro Espaço: </label><input type="text" name="novoespao" />');
		} else {
			divPai.html('');			
		}
	},
	
	addEspaco: function(e) {
		e.preventDefault();
		
		var htmlEspaco = '';
		
		htmlEspaco += '<div class="espacos" data-posicao="'+ADMIN.numeroEspaco+'">';
			htmlEspaco += '<div class="comboEspaco '+ADMIN.numeroEspaco+'">';
				htmlEspaco += '<label>Espaço:</label>';
				htmlEspaco += '<select onchange="ADMIN.espacos(this)" class="selectArea '+ADMIN.numeroEspaco+'" name="listaArea['+ADMIN.numeroEspaco+']"></select>';
			htmlEspaco += '</div>';
			htmlEspaco += '<div class="outroEspaco"></div>';
				htmlEspaco += '<div class="elInput">';
				htmlEspaco += '<label>Descrição: </label>';
				htmlEspaco += '<input type="text" class="descricaoArea" name="descricao['+ADMIN.numeroEspaco+']" />';
			htmlEspaco += '</div>';
		htmlEspaco += '</div>';
		
		$('#content-espaco').append(htmlEspaco);
		
		var criado = $('.selectArea'),
			espacos = '';
					
		$('#comboEspacoList option').each(function(e, val) {
			criado.append(val);			
		});
		
		ADMIN.numeroEspaco++;
	},
	
	submitEspaco: function(e) {
		e.preventDefault();
		
		var array = new Array();

		$('.espacos').each(function(e){
		var obj = new Object();
		    obj.novoEspaco = $(this).find('.selectArea option:selected').val();
		    obj.idUser = $('#idUser').val();
		    obj.descricao = $(this).find('.descricaoArea').val();
		    array.push(obj);
		    
		});

		var dataForm = JSON.stringify(array);
		$.ajax({
			data: dataForm,
	    	type: 'post',
	      	url:'inserirEspaco',
	      	contentType: 'application/json',
	      	mimeType: 'application/json',
	      	success: function(e) {
	      		//to do: redirect para listar areas
	      		console.log('resposta -', e);
	      	}
		});
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
	
	$('#btSubmitBlocos').on('click', ADMIN.submitEspaco);
	
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