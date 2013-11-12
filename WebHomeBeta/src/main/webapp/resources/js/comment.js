var POST_COMMENT  = {	
		
		idUser: $('#userSessao').val(),
		isScroll: true,
		
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
		      	dataType: 'json',	
		      	success: POST_COMMENT.loadHome,
		      	error: function(e) {
		      		console.log('erro = ', e);
		      	}

		    });
			
		},
		
		loadNotificacao: function(data) {
			var htmlNotificacao = '';
			if(data.length > 0) {
				$('#alerta-notificacao').addClass('glyphicon glyphicon-star');
				$('#numeroNotificacao').text(data.length);
				$.each(data, function(i, val){
					htmlNotificacao += '<li class="notificacao">';
						htmlNotificacao += '<p class="mensagemNotificacao">'+val.texto+'</p>';
					htmlNotificacao += '</li>';
				});
				$('#main-notificacao').html(htmlNotificacao);
			}			
		},
		
		loadHome: function(data) {
			var htmlHome = '';
			
			if(data.length > 0) {
				$.each(data, function(e, val){
					htmlHome = '';
					
					htmlHome += '<div class="post" data-id-user="'+val.usuarioPublicacao.idUsuarioPublicacao+'" data-id-post="'+val.idPublicacao+'">';
						if(val.proprietario){
							htmlHome += '<a href="#" class="deletePost"><span class="glyphicon glyphicon-remove"></span></a>';
						}
						htmlHome += '<img src="'+val.imagemPublicacao+'" class="thumb-post" />';
						htmlHome += '<div class="comments-post">';
							htmlHome += '<a href="#" class="name-user-comment">'+val.usuarioPublicacao.nome+'</a>';
							htmlHome += '<p class="time-comments">'+val.dataPublicacao+'</p>';
							htmlHome += '<p class="comment-user">'+val.publicacao+'</p>';
							if(val.gostous){
								var aux = false;
								var idGostou = 0;
								$.each(val.gostous, function(i, gostou){
									if(gostou.idUsuario == POST_COMMENT.idUser){
										aux = true;
										idGostou = gostou.id;
									}
								});
								
								if(aux){
									htmlHome += '<div class="gosteiPublicacao">';
									htmlHome += '<p class="labelGostei">'+val.quantidadeGostou+'</p><span class="iconSmile iconGostei active glyphicon glyphicon-thumbs-down" data-id-gostou="'+idGostou+'" data-gostou="'+val.quantidadeGostou+'"></span>';
									htmlHome += '</div>';
								}
								else{
									htmlHome += '<div class="gosteiPublicacao">';
									htmlHome += '<p class="labelGostei">'+val.quantidadeGostou+'</p><span class="glyphicon glyphicon-thumbs-up iconGostar" data-gostou="'+val.quantidadeGostou+'"></span>';
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
										htmlHome += '<a href="#" class="name-user-comment">'+comment.nome+'</a>';
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
					$('#carrengandoComentario').remove();
					$('#main-comments').append(htmlHome);
					POST_COMMENT.isScroll = true;
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
				htmlInserPost += '<a href="#" class="name-user-comment">'+e.nome+'</a>';
				htmlInserPost += '<p class="time-comments">'+e.dataPublicacao+'</p>';
				htmlInserPost += '<p class="comment-user">'+e.publicacao+'</p>';
				htmlInserPost += '<div class="gosteiPublicacao">';
					htmlInserPost += '<p class="labelGostei">0</p><span class="glyphicon glyphicon-thumbs-up iconGostar" data-gostou="0"></span>';
				htmlInserPost += '</div>'
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
				      			$('#alerta-notificacao').addClass('glyphicon glyphicon-star');
				      			
		      					htmlNotificacao += '<li class="notificacao">';
									htmlNotificacao += '<p class="mensagemNotificacao">'+val.texto+'</p>';
								htmlNotificacao += '</li>';
		      				}
		      			});
						
						$('#main-notificacao').append(htmlNotificacao);
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
					$('#alerta-notificacao').removeClass('glyphicon glyphicon-star');
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
				dataCurtir = 'id=' + el.closest('.post').attr('data-id-post');
			var quantidadeGostou = el.attr('data-gostou');
			
			quantidadeGostou = parseInt(quantidadeGostou,10)+1;
			
			$.ajax({
	            type: "post",
	            url: "/WebHomeBeta/gostou",
	            data: dataCurtir,
	            success: function (data) {
	            	el.addClass('active');
	            	el.addClass('iconGostei');
	            	el.addClass('glyphicon-thumbs-down');
	            	el.removeClass('glyphicon-thumbs-up');
	            	el.removeClass('iconGostar');
	            	el.attr('data-id-gostou', data);
	            	el.attr('data-gostou', quantidadeGostou);
	    			el.closest('.gosteiPublicacao').find('.labelGostei').html(quantidadeGostou);
	            },
	            error: function () {
	            	console.log('errormessage');
	                //do something else

	            }
	        });
		},
		
		onClickRemoveGostei: function(e) {
			e.preventDefault();
			var el = $(this),
				dataCurtir = 'idPost=' + $(this).closest('.iconGostei').attr('data-id-gostou');
			var quantidadeGostou = el.attr('data-gostou');
			
			quantidadeGostou = parseInt(quantidadeGostou,10)-1;
			
			$.ajax({
	            type: "post",
	            url: "/WebHomeBeta/removeGostou",
	            data: dataCurtir,
	            success: function () {
	            	el.removeClass('active');
	            	el.removeClass('iconGostei');
	            	el.removeClass('glyphicon-thumbs-down');
	            	el.addClass('iconGostar');
	            	el.addClass('glyphicon-thumbs-up');
	            	el.attr('data-gostou', quantidadeGostou);
	            	el.closest('.gosteiPublicacao').find('.labelGostei').html(quantidadeGostou);
	            },
	            error: function () {
	            	console.log('errormessage');
	                //do something else

	            }
	        });
		},
		
		onParticipaEnquete: function(e) {
			
			e.preventDefault();
			
			var el = $(this),
				idOpc='',
				idUser = '',
				idEnquete = '',
				container = '';
			
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
		            	$('#' + container).hide('slow');
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
	$('body').on('click', '.iconGostar', POST_COMMENT.onClickGostei);
	$('body').on('click', '.iconGostei', POST_COMMENT.onClickRemoveGostei);
	
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
			      	dataType: 'json',	
			      	success: POST_COMMENT.loadHome
				});
			}			
		}
	});	
});