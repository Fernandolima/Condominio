
var POST_COMMENT  = {	
		
		idUser: $('#userSessao').val(),
		isScroll: true,
		colunaInicial: 0,
		
		init: function() {
			$.ajax({
		    	type: 'get',
		      	url:'/WebHomeBeta/notificacaoInicial',
		      	dataType: 'json',	
		      	success: POST_COMMENT.loadNotificacao

		    });
			$.ajax({
		    	type: 'post',
		      	url:'/WebHomeBeta/getPublicacao',
		      	data: {colunaInicial: POST_COMMENT.colunaInicial},
		      	success: POST_COMMENT.loadHome,
		      	error: function(e) {
		      		console.log('erro = ', e);
		      	}

		    });
			
		},
		
		loadNotificacao: function(data) {

			var htmlNotificacao = '';
			if(data.length > 0) {
				$('#alerta-notificacao span').removeClass('glyphicon glyphicon-star-empty');
				$('#alerta-notificacao span').addClass('glyphicon glyphicon-star');
				$('#numeroNotificacao').text(data.length);
				$.each(data, function(i, val){
					htmlNotificacao += '<li class="notificacao notif">';
						htmlNotificacao += '<img src = "'+val.imagem+'">';
						htmlNotificacao += '<p class="mensagemNotificacao"><a href="'+val.url+'">'+val.texto+'</a></p>';
					htmlNotificacao += '</li>';
				});
				$('#main-notificacao').html(htmlNotificacao);
			}			
		},
		
		loadHome: function(data) {
			var htmlHome = '';
			
			$('#carrengandoComentario').remove();
			
			if(data.length > 0) {
				$.each(data, function(e, val){
					htmlHome = '';
					
					htmlHome += '<div class="post" data-id-user="'+val.usuarioPublicacao.idUsuarioPublicacao+'" data-id-post="'+val.idPublicacao+'">';
						if(val.proprietario){
							htmlHome += '<a href="#" class="deletePost"><span class="glyphicon glyphicon-remove"></span></a>';
						}
						htmlHome += '<img src="'+val.imagemPublicacao+'" class="thumb-post" />';
						htmlHome += '<div class="comments-post">';
							htmlHome += '<a href="/WebHomeBeta/perfil/id='+val.usuarioPublicacao.idUsuarioPublicacao+'" class="name-user-comment">'+val.usuarioPublicacao.nome+'</a>';
							htmlHome += '<p class="time-comments">'+val.dataPublicacao+'</p>';
							htmlHome += '<p class="comment-user">'+val.publicacao+'</p>';
							if(val.gostous){
								var auxGostou = false,
									auxNaoGostou = false,
									idGostou = 0;
									idNaoGostou = 0;
								$.each(val.gostous, function(i, gostou){
									if(gostou.idUsuario == POST_COMMENT.idUser){
										auxGostou = true;
										idGostou = gostou.id;
									}
								});
								$.each(val.naoGostous, function(i, naoGostou){
									if(naoGostou.idUsuario == POST_COMMENT.idUser){
										auxNaoGostou = true;
										idNaoGostou = naoGostou.id;
									}
								});
								
								
								
								if(auxGostou){
									htmlHome += '<div class="gosteiPublicacao">';
									htmlHome += '<p class="labelGostei active"> '+((val.quantidadeGostou == 1) ? 'Você'  : 'Você e mais '+(val.quantidadeGostou-1)+'')+'</p><span class="iconGostei active" data-id-gostou="'+idGostou+'" data-gostou="'+val.quantidadeGostou+'"></span>';
									htmlHome += '<p class="labelNaoGostei">'+val.quantidadeNaoGostou+'</p><span class="iconNaoGostei" data-id-nao-gostou="0" data-nao-gostou="'+val.quantidadeNaoGostou+'"></span>';
									htmlHome += '</div>';
								}
								
								else if(auxNaoGostou){ 
									htmlHome += '<div class="gosteiPublicacao">';
									htmlHome += '<p class="labelGostei">'+val.quantidadeGostou+'</p><span class="iconGostei"  data-id-gostou="0" data-gostou="'+val.quantidadeGostou+'"></span>';
									htmlHome += '<p class="labelNaoGostei active">'+((val.quantidadeNaoGostou == 1) ? 'Você'  : 'Você e mais '+(val.quantidadeNaoGostou-1)+'')+'</p><span class="iconNaoGostei active" data-id-nao-gostou="'+idNaoGostou+'" data-nao-gostou="'+val.quantidadeNaoGostou+'"></span>';
									htmlHome += '</div>';									
								} else{
									htmlHome += '<div class="gosteiPublicacao">';
									htmlHome += '<p class="labelGostei">'+val.quantidadeGostou+'</p><span class="iconGostei" data-id-gostou="0" data-gostou="'+val.quantidadeGostou+'"></span>';
									htmlHome += '<p class="labelNaoGostei">'+val.quantidadeNaoGostou+'</p><span class="iconNaoGostei" data-id-nao-gostou="0" data-nao-gostou="'+val.quantidadeNaoGostou+'"></span>';
									htmlHome += '</div>';
								}
						}
								
							
						
						htmlHome += '</div>';
						
						if(val.comentarios.length > 0) {
							htmlHome += '<div class="comments-holder">';
								htmlHome += '<div class="main-comment">';
							$.each(val.comentarios, function(l, comment){							
									htmlHome += '<div class="comments">';
										htmlHome += '<img src="'+comment.imagemUsuario+'" class="thumb-post" />';
										htmlHome += '<a href="/WebHomeBeta/perfil/id='+comment.idUsuarioComentario+'" class="name-user-comment">'+comment.nome+'</a>';
										htmlHome += '<p class="time-comments">'+comment.dataComentario+'</p>';
										htmlHome += '<p>'+comment.comentario+'</p>';
									htmlHome += '</div>';
							});
								htmlHome += '</div>';
								htmlHome += '<form class="frmCommentPost" method="POST">';
									htmlHome += '<div class="form-group">';
										htmlHome += '<input type="text" class="inputComment form-control" placeholder="Comentar" name="comentarioTO.comentario" />';
										htmlHome += '<input type="hidden" class="idPub" name="idPublicacao" />';
									htmlHome += '</div">';
								htmlHome += '</form>';
									
							htmlHome += '</div>';
						} else {
							htmlHome += '<a href="#" class="add-comments btn btn-info">Comentar</a>';
						}
					htmlHome += '</div>';
					$('#main-comments').append(htmlHome);
					POST_COMMENT.isScroll = true;
					POST_COMMENT.colunaInicial = val.colunaInicial;
					
				}); 
			} else {
				$('#carrengandoComentario').hide();
			}
		  
		},
		
		postFocus: function() {
			$('#submitComment').fadeIn(1000);
		},

		addComment: function(e) {
			var htmlComment = '';

			e.preventDefault();
			
			htmlComment += '<div class="comments-holder" style="display:none;">';
				htmlComment += '<div class="main-comment"></div>';
				htmlComment += '<form class="frmCommentPost" method="POST">';
				htmlComment += '<div class="form-group">';
					htmlComment += '<input type="text" class="inputComment form-control" placeholder="Comentar" name="comentarioTO.comentario" />';
					htmlComment += '<input type="hidden" class="idPub" name="idPublicacao" />';
				htmlComment += '</div">';
				htmlComment += '</form>';
			htmlComment += '</div>';

			$(this).closest('.post').append(htmlComment);
			$(this).closest('.post').find('.comments-holder').fadeIn(1500);
			$(this).remove();
		},

		onSubmitPost: function(e) {
			e.preventDefault();
			
			if($('#txtComment').val().length === 0) {
				return false;
			}
			
			$.ajax({
				data: $('#frmComment').serialize(),
		    	type: 'post',
		      	url:'/WebHomeBeta/home/publicar',
		      	dataType: 'json',	
		      	success: POST_COMMENT.successPost
		    });
		},

		successPost: function(e) {
			var htmlInserPost = "";
			
			htmlInserPost += '<div class="post" data-id-user="'+e.idUsuario+'" data-id-post="'+e.idPublicacao+'">';
			htmlInserPost += '<a href="#" class="deletePost"><span class="glyphicon glyphicon-remove"></span></a>';
			htmlInserPost += '<img src="'+e.caminhoImg+'" class="thumb-post" />';
			htmlInserPost += '<div class="comments-post">';
				htmlInserPost += '<a href="/WebHomeBeta/perfil/id='+e.idUsuario+'" class="name-user-comment">'+e.nome+'</a>';
				htmlInserPost += '<p class="time-comments">'+e.dataPublicacao+'</p>';
				htmlInserPost += '<p class="comment-user">'+e.publicacao+'</p>';
				htmlInserPost += '<div class="gosteiPublicacao">';
					htmlInserPost += '<p class="labelGostei">0</p><span class="iconGostei" data-gostou="0"></span>';
					htmlInserPost += '<p class="labelNaoGostei">0</p><span class="iconNaoGostei" data-id-nao-gostou="" data-nao-gostou="0"></span>';
				htmlInserPost += '</div>';
			htmlInserPost += '</div>';
			htmlInserPost += '<a href="#" class="add-comments btn btn-info">Comentar</a>';
			htmlInserPost += '</div>';
			
			
			$('#txtComment').val('');
			$('#main-comments').prepend(htmlInserPost);				
			htmlInserPost += "";
		},
		
		submitComment: function() {
			var el = $(this),
				idPub = $(this).closest('.post').attr('data-id-post'),
				idUserPost = $(this).closest('.post').attr('data-id-user'),
				dataForm = '',
				htmlComment = '',
				dataNotificacao = "tipo=comentou&idPost=" + idPub + '&id=' + idUserPost;
			
			if($.trim(el.closest('.post').find('.inputComment').val()).length === 0) {
				return false;
			}
			
			$(this).closest('.post').find('.idPub').val(idPub);
			
			dataForm = $(this).serialize();
			
			$.ajax({
				data: dataForm,
		    	type: 'post',
		      	url:'home/comentar',
		      	dataType: 'json',	
		      	success: function(e) {
		      		htmlComment += '<div class="comments">';
		      			htmlComment += '<img class="thumb-post" src="'+e.caminhoImagem+'">';
		      			htmlComment += '<a class="name-user-comment" href="#">'+e.nomeUsuario+'</a>';
		      			htmlComment += '<p class="time-comments">'+e.dataComentario+'</p>';
		      			htmlComment += '<p>'+e.comentario+'</p>';
		      		htmlComment += '</div>';
		      		
		      		el.closest('.post').find('.main-comment').append(htmlComment);
		      		el.closest('.post').find('.inputComment').val('');		      		
		      	}
		    });
			
			POST_COMMENT.salvarNotificacao(dataNotificacao);
			 
			return false;			
		},
		
		salvarNotificacao: function(dataNotificacao) {
			
			$.ajax({
	            type: "post",
	            url: "/WebHomeBeta/notificacao",
	            data: dataNotificacao,
	            success: function () {
	            	console.log('sucesso');
	            },
	            error: function () {
	            	console.log('errormessage');
	                //do something else

	            }
	        });
		},
		
		onDeletePost: function(e) {
			e.preventDefault();
			
			var idPostDelete = $(this).closest('.post').attr('data-id-post'),
				el = $(this),
				dataPost = "idPost="+idPostDelete;
			
			$.ajax({
				data: dataPost,
		    	type: 'get',
		      	url:'/WebHomeBeta/home/delete',
		      	dataType: 'json',	
		      	success: function(e) {
		      		if(e) {
		      			el.closest('.post').remove();
		      		}
		      	}
		    });
		},
		verificaNotificacoes: function() {
			$.ajax({
				type: 'post',
		      	url:'/WebHomeBeta/verificaNotificacoes',
		      	dataType: 'json',	
		      	success: function(data) {
		      		if(data.length > 0) {
		      			var num,
		      				htmlNotificacao = '';
		      			
		      			if($('#numeroNotificacao').text().length == 0) {
		      				num = 0;
		      			} else {
		      				num = parseInt($('#numeroNotificacao').text(), 10);
		      			}
		      			
		      			$.each(data, function(i, val) {
		      				if(POST_COMMENT.idUser == val.idUser) {
		      					$('#numeroNotificacao').html(num + data.length);
		      					$('#alerta-notificacao span').removeClass('glyphicon-star-empty');
				      			$('#alerta-notificacao span').addClass('glyphicon-star');
				      			
				      			htmlNotificacao += '<li class="notificacao notif">';
									htmlNotificacao += '<img src = "'+val.imagem+'">';
									htmlNotificacao += '<p class="mensagemNotificacao"><a href="'+val.url+'">'+val.texto+'</a></p>';
								htmlNotificacao += '</li>';
		      				}
		      			});
						
		      			if($('#main-notificacao li.notif').length > 0) {
		      				$('#main-notificacao').append(htmlNotificacao);
		      			} else {
		      				$('#main-notificacao').html(htmlNotificacao);
		      			}
						
		      		}
		      	},
		      	error: function(data) {
		      		console.log('error = ', data);
		      	}
		    });
		},
		visualizaNotificacao: function(e) {
			e.preventDefault();
			$('#main-notificacao').toggle('show', function(){
				if($('#main-notificacao').css('display') == 'block') {
					$('#alerta-notificacao span').removeClass('glyphicon-star');
					$('#alerta-notificacao span').addClass('glyphicon-star-empty');
					$('#numeroNotificacao').text('');
				 	$.post('notificacaoVista');
				} else {
					$('#main-notificacao').html('Nenhuma notificação pendente');
				}				
			});		
			
		},
		
		onClickGostei: function(e) {
			e.preventDefault();
			
			var el = $(this),
				dataCurtir = el.closest('.post').attr('data-id-post'),
				quantidadeGostou = el.attr('data-gostou'),
				idGostou = el.attr('data-id-gostou');
						
			quantidadeGostou = parseInt(quantidadeGostou,10);
			
			if(idGostou != 0){
				$.ajax({
		            type: "post",
		            url: "/WebHomeBeta/removeGostou",
		            data: {id: idGostou, idPost: dataCurtir},
		            success: function (data) {
		            	if(data != 'false'){
		            	el.removeClass('active');
		            	el.attr('data-id-gostou', 0);
		            	el.attr('data-gostou', (quantidadeGostou-1));
		    			el.closest('.gosteiPublicacao').find('.labelGostei').html((quantidadeGostou-1));
		    			
		            	}
		    			
		            },
		            error: function () {
		            	console.log('errormessage');
		                //do something else

		            }
		        });
			}else{
			
			$.ajax({
	            type: "post",
	            url: "/WebHomeBeta/gostou",
	            data: {id: dataCurtir},
	            success: function (data) {
	            	if(data != 'false'){            
	            	el.addClass('active');
	            	el.attr('data-id-gostou', data);
	            	el.attr('data-gostou', (quantidadeGostou+1));
	    			el.closest('.gosteiPublicacao').find('.labelGostei').html(((quantidadeGostou == 0) ? 'Você'  : 'Você e mais '+(quantidadeGostou)));
	            	}    			
	            },
	            error: function () {
	            	console.log('errormessage');
	                //do something else

	            }
	        });
			
			}
		},
		
		onClickNaoGostei: function(e) {
			e.preventDefault();
			
			var el = $(this),
			dataCurtir = el.closest('.post').attr('data-id-post'),
				quantidadeNaoGostou = el.attr('data-nao-gostou'),
				idNaoGostou = el.attr('data-id-nao-gostou');
			
				quantidadeNaoGostou = parseInt(quantidadeNaoGostou,10);
				
			if(idNaoGostou != 0){
				$.ajax({
		            type: "post",
		            url: "/WebHomeBeta/removeNaoGostou",
		            data: {id: idNaoGostou, idPost: dataCurtir},
		            success: function (data) {
		            	if(data != 'false'){
		            	el.removeClass('active');
		            	el.attr('data-id-nao-gostou', 0);
		            	el.attr('data-nao-gostou', (quantidadeNaoGostou-1));
		    			el.closest('.gosteiPublicacao').find('.labelNaoGostei').html((quantidadeNaoGostou-1));
		    			
		            	}
		    			
		            },
		            error: function () {
		            	console.log('errormessage');
		                //do something else

		            }
		        });
			}else{	
			
				
				
			$.ajax({
	            type: "post",
	            url: "/WebHomeBeta/naoGostou",
	            data: {id: dataCurtir},
	            success: function (data) {
	            	if(data != 'false'){
	            	el.addClass('active');
	            	el.attr('data-id-nao-gostou', data);
	            	el.attr('data-nao-gostou', (quantidadeNaoGostou+1));
	    			el.closest('.gosteiPublicacao').find('.labelNaoGostei').html(((quantidadeNaoGostou == 0) ? 'Você'  : 'Você e mais '+(quantidadeNaoGostou)));
	    			
	            	}
	    			
	    			
	            },
	            error: function () {
	            	console.log('errormessage');
	                //do something else

	            }
	        });
		  }
		},
		
		onParticipaEnquete: function(e) {
			
			e.preventDefault();
			
			var el = $(this),
				idOpc='',
				idUser = '',
				idEnquete = '',
				container = '',
				html = '';
			
			idOpc = el.closest('.enquete').find('.opcoesEnquete').find('input:checked').val();
			
			if(idOpc) {
				idUser = $('#userSessao').val();
				idEnquete = el.closest('.enquete').find('.opcoesEnquete').find('.idEnquete').val();
				container = el.closest('.enquete').attr('id');
				
				$.ajax({
		            type: "post",
		            url: "/WebHomeBeta/computarVoto",
		            data: 'idUser=' + idUser + '&idOpcao=' + idOpc + '&idEnquete=' + idEnquete,
		            success: function (data) {
		            	console.log('**********', data);
		            	html += '<div class="enquete">';
		            	html += '<h5 class="text-info"><b>Enquete: '+data.enquete+'</b></h5>';
		            		html += '<div class="opcoesEnquete">';
		            			$.each(data.opcoes, function(i, val){
		            				console.log('----------------', val);
			            			html += '<p class="text-danger">'+val.opcao+'</p>';
		            				html += '<div class="progress">';
		            					html += '<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="'+val.porcentagemVotos+'" aria-valuemin="0" aria-valuemax="100" style="width:'+val.porcentagemVotos+'%">';
		            						html += '<span class="sr-only">'+val.porcentagemVotos+' Votos</span>';
		            					html += ' </div>';
		            				html += '</div>';
												
		            			});		            								
		            		html += '</div>';
						html+= '</div>';
		            
						$('#' + container).hide('slow');
						
						$('#enquetesPariticipadas').prepend(html);
		            },
		            error: function () {
		            	console.log('errormessage');
		                //do something else

		            }
		        });
			} else {
				alert('escolha uma opcao para votar =)');
			}
			
		}
}

$(function() {
	
	POST_COMMENT.init();
	//enquete
	$('.participarEnquete').on('click', POST_COMMENT.onParticipaEnquete);
	
	$('#txtComment').on('focus', POST_COMMENT.postFocus);	

	$('body').on('click', '.add-comments', POST_COMMENT.addComment);
	$('body').on('submit', '.frmCommentPost', POST_COMMENT.submitComment);
	$('body').on('click', '.deletePost', POST_COMMENT.onDeletePost);
	$('body').on('click', '.iconGostei', POST_COMMENT.onClickGostei);
	$('body').on('click', '.iconNaoGostei', POST_COMMENT.onClickNaoGostei);
	
	$('#alerta-notificacao').on('click', POST_COMMENT.visualizaNotificacao);
	
	setInterval(function(){
		POST_COMMENT.verificaNotificacoes();
	},10000);	
	
	setInterval(function(){
		location.reload();
	},300000);
	
	$('#submitComment').on('click', POST_COMMENT.onSubmitPost);
	var alturaPagina, scroolTop;
	
	$(window).scroll(function(){
		if ($(window).scrollTop() + $(window).height() >= $(document).height()) {
			if(POST_COMMENT.isScroll) {
				POST_COMMENT.isScroll = false;
				$('#main-comments').append('<img src="/WebHomeBeta/img/loadComentario.gif" id="carrengandoComentario" alt="Aguarde, carregando" />');
				$.ajax({
			    	type: 'post',
			      	url:'/WebHomeBeta/getPublicacao',
			      	data: {colunaInicial: POST_COMMENT.colunaInicial},
			      	success: POST_COMMENT.loadHome
				});
			}			
		}
	});	
});