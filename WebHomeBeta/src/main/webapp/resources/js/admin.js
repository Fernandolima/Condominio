var ADMIN = {
		
	numeroEspaco : 1,
	
	init: function(){
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
		
		htmlOpcao += '<div class="control-group">';
			htmlOpcao += '<label for="listOpcoes" name="enquetesTo.opcoes" class="control-label">Opção '+(numEnquete+1)+':</label>';
			htmlOpcao += '<div class="controls">';
				htmlOpcao += '<input type="text" name="listOpcoes['+numEnquete+']" autocomplete="off" class="input-xlarge focused opcaoEnquete" />';
			htmlOpcao += '</div>';
		htmlOpcao += '</div>';
		
		$('#contentOpcao').append(htmlOpcao);
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
	
	inserirEspaco: function(e) {
		
		e.preventDefault();
		
		console.log('a');
		var obj = new Object();
		    obj.novoEspaco = $('#comboEspacoList option:selected').val();
		    obj.idUser = $('#idUser').val();
		    obj.descricao = $('#descricao').val();
		    console.log(obj);
		if(obj.descricao.length > 0) {
			htmlBloco = "";
			var dataForm = JSON.stringify(obj);
			$.ajax({
				data: dataForm,
		    	type: 'post',
		      	url:'/WebHomeBeta/admin/inserirEspaco',
		      	contentType: 'application/json',
		      	mimeType: 'application/json',
		      	success: function(data) {
		      		htmlBloco += '<tr>';
		      			htmlBloco += '<td>'+data.novoEspaco+'</p>';
		      			htmlBloco += '<td>'+data.descricao+'</p>';
		      			htmlBloco += '<td><a href="#div'+data.idEspaco+'" data-toggle="modal" data-id="'+data.idEspaco+'" class="btn btn-danger btn-delete-bloco">Delete</a>';
		      				htmlBloco += '<div id="div'+data.idEspaco+'" class="modal hide">';
		      				htmlBloco += '<div class="modal-header">';
		      					htmlBloco += '<button data-dismiss="modal" class="close" type="button">×</button>';
		      					htmlBloco += '<h3>Exclusão de espaço</h3>';
		      				htmlBloco += '</div>';
		      			  htmlBloco += 	'<div class="modal-body">';
		      			   htmlBloco += '<p>Confirma exclusão do espaço?</p>';
		      			  htmlBloco += '</div>';
		      			 htmlBloco += '<div class="modal-footer">';
		      			 htmlBloco += 	'<a id="hrefExcluir" data-dismiss="modal" class="btn excluirEspaco btn-primary" href="#" data-id="'+data.idEspaco+'">Sim</a>';
		      			 htmlBloco += 	'<a data-dismiss="modal" class="btn" href="#">Não</a>';
		      			htmlBloco += '</div>';
		      			htmlBloco += '</div>';
		      			htmlBloco += '</td>';
					htmlBloco += '</tr>';
				
				if($('.nenhumResultado').css('display') == 'block') {
					$('.nenhumResultado').hide();
				}
				$('#listaEspacos tbody').append(htmlBloco);
				$('input[type="text"]').val('');
				$.jGrowl("Espaço adicionado!");
				$('.excluirEspaco').on('click', ADMIN.excluirEspaco);
		      	}
			});
		}
	},
	
	excluirEspaco: function(e) {
		e.preventDefault();
		console.log('a');
		var idEspaco = $(this).attr('data-id'),
			el = $(this);
		$.ajax({
			url: '/WebHomeBeta/admin/deleteEspaco',
			type: 'POST',
			data: { idEspaco: idEspaco },
			success: function(data) {
					el.closest('tr').remove();
			}
		});
		
//		if($('.lineTabelaBlocos').length === 2) {
//			console.log('entra');
//			$('.nenhumResultado').show();
//			$('#tabelaBlocos').remove();			
//		}
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
	},
	
	ativarEnquete: function(e){
		e.preventDefault();
		
		var data = 'idEnquete='+$(this).attr('data-enquete')+'&ativa=true',
		idEnquete = $(this).attr('data-enquete'),
		id = $(this).attr('data-id'),
		el = $('#'+id+'');
		console.log(id);	
		var html = '';
		$.ajax({
			data: data,
	    	type: 'post',
	      	url:'/WebHomeBeta/admin/enquetes/ativar',
	      	success: function(data) {

	      		html += '<div id="div'+id+'" class="modal hide">';
				html += '<div class="modal-header">';
					 html += '<button data-dismiss="modal" class="close" type="button">×</button>';
					 html += '<h3>Desativação da enquete</h3>';
					html += '</div>';
				html += 	'<div class="modal-body">';
					 html += '<p>Confirma desativação da enquete?</p>';
					html += '</div>';
							html += '<div class="modal-footer">';
								html += 	'<a data-dismiss="modal" class="btn desativarEnquete btn-primary" href="#" data-id="'+id+'" data-enquete="'+idEnquete+'">Sim</a>';
								html += 	'<a data-dismiss="modal" class="btn" href="#">Não</a>';
								html += '</div>';
			     html += '</div>';
			     
			     el.removeClass('btn-success');
			     el.addClass('btn-inverse');
			     el.text('Desativar');
			     el.attr('href','#div'+id+'');
			     el.closest('div.modal').remove();
				 el.after(html);
	      	}
		});
	},
	
	editarEnquete: function(e) {
		e.preventDefault();
		var htmlOpcao = '';
		var el = $('#contentOpcao');
		$.ajax({
			url: '/WebHomeBeta/admin/enquetes/editar',
			type: 'POST',
			data : $('#frmEnquetes').serialize(),
			success: function(data) {
				$('input[type="text"]').val('');
				el.empty();
				
				$.jGrowl("Enquete salva!");
				
				htmlOpcao += '<div class="control-group">';
				htmlOpcao += '<label for="listOpcoes" name="enquetesTo.opcoes" class="control-label">Opção 1:</label>';
					htmlOpcao += '<div class="controls">';
						htmlOpcao += '<input type="text" name="listOpcoes[0]" autocomplete="off" class="input-xlarge focused opcaoEnquete" />';
					htmlOpcao += '</div>';
				htmlOpcao += '</div>';
				
				el.append(htmlOpcao);
				
			}
		
		});
	},
	
	notificarEnqueteSalva: function(e) {
		e.preventDefault();
		var htmlOpcao = '';
		var el = $('#contentOpcao');
		$.ajax({
			url: '/WebHomeBeta/admin/enquetes/salvar',
			type: 'POST',
			data : $('#frmEnquetes').serialize(),
			success: function(data) {
				$('input[type="text"]').val('');
				el.empty();
				
				$.jGrowl("Enquete salva!");
				
				htmlOpcao += '<div class="control-group">';
				htmlOpcao += '<label for="listOpcoes" name="enquetesTo.opcoes" class="control-label">Opção 1:</label>';
					htmlOpcao += '<div class="controls">';
						htmlOpcao += '<input type="text" name="listOpcoes[0]" autocomplete="off" class="input-xlarge focused opcaoEnquete" />';
					htmlOpcao += '</div>';
				htmlOpcao += '</div>';
				
				el.append(htmlOpcao);
				
			}
		
		});
 
	},
    
	desativarEnquete: function(e){
		e.preventDefault();
		
		var data = 'idEnquete='+$(this).attr('data-enquete')+'&ativa=false',
		idEnquete = $(this).attr('data-enquete'),
		id = $(this).attr('data-id'),
		el = $('#'+id+'');
		console.log(id);
		var html = '';
		$.ajax({
			data: data,
	    	type: 'post',
	      	url:'/WebHomeBeta/admin/enquetes/ativar',
	      	success: function(data) {
	      		
	      		
	      		
	      		html += '<div id="div'+id+'" class="modal hide">';
				html += '<div class="modal-header">';
					 html += '<button data-dismiss="modal" class="close" type="button">×</button>';
					 html += '<h3>Ativação de enquete</h3>';
					html += '</div>';
				html += 	'<div class="modal-body">';
					 html += '<p>Confirma ativação da enquete?</p>';
					html += '</div>';
							html += '<div class="modal-footer">';
								html += 	'<a data-dismiss="modal" class="btn ativarEnquete btn-primary" href="#" data-id="'+id+'" data-enquete="'+idEnquete+'">Sim</a>';
								html += 	'<a data-dismiss="modal" class="btn" href="#">Não</a>';
								html += '</div>';
			     html += '</div>';
			     
			     el.removeClass('btn-inverse');
			     el.addClass('btn-success');
			     el.text('Ativar');
			     el.attr('href','#div'+id+'');
			     el.closest('div.modal').remove();
				 el.after(html);
				
	      	}
		});
	},
	
	verificaNotificacao: function() {
		
		$.ajax({
	    	type: 'post',
	      	url:'/WebHomeBeta/verificaNotificacoesNovoUser',
	      	dataType: 'json',
	      	success: function(data) {
	      		if(data.length > 0){
	      		$.each(data, function(i, val) {
	      				$.jGrowl("Um novo morador acabou de realizar o cadastro!", { header: 'Atenção!' },{ sticky: true });
      				});	
	      		
	      	  }
	      	}
		});
	},
	
	inserirGasto: function(e) {
		e.preventDefault();
		
		console.log('data-form: ', $('#frmGasto').serialize());
		
		htmlBloco = "";			
		$.ajax({
			url: '/WebHomeBeta/admin/gastos/add',
			type: 'POST',
			data : $('#frmGasto').serialize(),
			success: function(data) {
				
				htmlBloco += '<tr>';
					htmlBloco += '<td>'+data.gasto+'</p>';
					htmlBloco += '<td>'+data.mes+'</p>';
					htmlBloco += '<td>'+data.ano+'</p>';
					htmlBloco += '<td><a href="#div'+data.idGasto+'" data-toggle="modal" class="btn btn-danger">Delete</a>';
					//Modal
					htmlBloco += '<div id="div'+data.idGasto+'" class="modal hide">';
					htmlBloco += '<div class="modal-header">';
					htmlBloco += '<button data-dismiss="modal" class="close" type="button">×</button>';
					htmlBloco += '<h3>Exclusão de gasto</h3>';
					htmlBloco += '</div>';
					htmlBloco += 	'<div class="modal-body">';
					htmlBloco += '<p>Confirma exclusão?</p>';
					htmlBloco += '</div>';
					htmlBloco += '<div class="modal-footer">';
					htmlBloco += 	'<a data-dismiss="modal" class="btn btn-delete-gasto btn-primary" href="#" data-id="'+data.idGasto+'">Sim</a>';
					htmlBloco += 	'<a data-dismiss="modal" class="btn" href="#">Não</a>';
					htmlBloco += '</div>';
					htmlBloco += '</div>';
					htmlBloco += '</td>';
				htmlBloco += '</tr>';
				
				if($('.nenhumResultado').css('display') == 'block') {
					$('.nenhumResultado').hide();
				}
				
				$('#listaGastos tbody').prepend(htmlBloco);
				$('input[type="text"]').val('');
				$('#mes option').first().attr('selected', 'selected');
				$('body').on('click', '.btn-delete-gasto', ADMIN.excluirGasto);
				$.jGrowl("Gasto contabilizado");
			}
		});		
	},
	
	excluirGasto: function(e) {
		e.preventDefault();
		
		var idGasto = $(this).attr('data-id'),
			el = $(this);
		$.ajax({
			url: '/WebHomeBeta/admin/gastos/delete',
			type: 'POST',
			data: { idGasto: idGasto },
			success: function(data) {
				if(data) {
					el.closest('tr').remove();
				}
			}
		});
	},
	
	deleteEnquete: function(e) {
		e.preventDefault();
		
		var idEnquete = 'idEnquete='+$(this).attr('data-enquete'),
			el = $(this);
			console.log('aaaaa');
		$.ajax({
			data: idEnquete,
	    	type: 'post',
	      	url:'/WebHomeBeta/admin/enquetes/delete',
	      	success: function(data) {
	      			console.log('aaa');
	      			el.closest('tr').remove();
	      		
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
	
	
	$('#btSubmitGasto').on('click', ADMIN.inserirGasto);
	
	$('body').on('click', '.btn-delete-gasto', ADMIN.excluirGasto);
	
	$('#btnDeleteListaEspaco').on('click', ADMIN.excluirEspaco);
	
	$('#btSubmitEspacos').on('click', ADMIN.inserirEspaco);
	
	$('#btEditEnquete').on('click', ADMIN.editarEnquete);
	
	$('#btSubmitEnquete').on('click', ADMIN.notificarEnqueteSalva);
	
	$('.title-menu-drop').on('click', ADMIN.onClickItemMenu);
	
	$('#btn-adiciona-opcao').on('click', ADMIN.onAddOpcao);
	
	$('#addEspaco').on('click', ADMIN.addEspaco);
	
	$('.excluirEspaco').on('click', ADMIN.excluirEspaco);
	
	$('tbody').on('click', '.desativarEnquete', ADMIN.desativarEnquete);
	
	$('tbody').on('click', '.ativarEnquete', ADMIN.ativarEnquete);
	
	$('tbody').on('click', '.excluirEnquete', ADMIN.deleteEnquete);
	
	setInterval(function(){
		ADMIN.verificaNotificacao();
	},10000);	
	
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