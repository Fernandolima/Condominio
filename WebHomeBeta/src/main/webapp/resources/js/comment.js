var POST_COMMENT  = {	
		
		idUser: $('#userSessao').val(),
		
		init: function() {
			$.ajax({
		    	type: 'get',
		      	url:'notificacaoInicial',
		      	dataType: 'json',	
		      	success: POST_COMMENT.loadNotificacao

		    });
			
			$.ajax({
		    	type: 'post',
		      	url:'home/getPublicacao',
		      	dataType: 'json',	
		      	success: POST_COMMENT.loadHome

		    });
			
		},
		
		loadNotificacao: function(data) {
			var htmlNotificacao = '';
			if(data.length > 0) {
				$('#alerta-notificacao').addClass('temNotificacao');
				$('#numeroNotificacao').text(data.length);
				$.each(data, function(i, val){
					htmlNotificacao += '<div class="notificacao">';
						htmlNotificacao += '<p class="mensagemNotificacao">'+val.texto+'</p>';
					htmlNotificacao += '</div>';
				});
				$('#main-notificacao').html(htmlNotificacao);
			}			
		},
		
		loadHome: function(data) {
			var htmlHome = '';
			$.each(data, function(e, val){
				htmlHome = '';
				
				htmlHome += '<div class="post" data-id-user="'+val.usuarioPublicacao.idUsuarioPublicacao+'" data-id-post="'+val.idPublicacao+'">';
					if(val.proprietario){
						htmlHome += '<a href="#" class="deletePost hidden">Excluir</a>';
					}
					htmlHome += '<img src="'+val.imagemPublicacao+'" class="thumb-post" />';
					htmlHome += '<div class="comments-post">';
						htmlHome += '<a href="#" class="name-user-comment">'+val.usuarioPublicacao.nome+'</a>';
						htmlHome += '<p class="time-comments">'+val.dataPublicacao+'</p>';
						htmlHome += '<p class="comment-user">'+val.publicacao+'</p>';
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
								htmlHome += '<input type="text" class="inputComment" placeholder="Comentar" name="comentarioTO.comentario" />';
								htmlHome += '<input type="hidden" class="idPub" name="idPublicacao" />';
							htmlHome += '</form>';
								
						htmlHome += '</div>';
					} else {
						htmlHome += '<a href="#" class="add-comments">>> Comentar</a>';
					}
				htmlHome += '</div>';
				
				$('#main-comments').append(htmlHome);
			});			
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
					htmlComment += '<input type="text" class="inputComment" placeholder="Comentar" name="comentarioTO.comentario" />';
					htmlComment += '<input type="hidden" class="idPub" name="idPublicacao" />';
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
		      	url:'home/publicar',
		      	dataType: 'json',	
		      	success: POST_COMMENT.successPost
		    });
		},

		successPost: function(e) {
			var htmlInserPost = "";
			
			htmlInserPost += '<div class="post" data-id-user="'+e.idUsuario+'" data-id-post="'+e.idPublicacao+'">';
			htmlInserPost += '<a href="#" class="deletePost hidden">Excluir</a>';
			htmlInserPost += '<img src="'+e.caminhoImg+'" class="thumb-post" />';
			htmlInserPost += '<div class="comments-post">';
				htmlInserPost += '<a href="#" class="name-user-comment">'+e.nome+'</a>';
				htmlInserPost += '<p class="time-comments">'+e.dataPublicacao+'</p>';
				htmlInserPost += '<p class="comment-user">'+e.publicacao+'</p>';
			htmlInserPost += '</div>';
			htmlInserPost += '<a href="#" class="add-comments">>> Comentar</a>';
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
	            url: "notificacao/",
	            data: dataNotificacao,
	            success: function () {
	               
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
		      	url:'home/delete',
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
		      	url:'verificaNotificacoes',
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
				      			$('#alerta-notificacao').addClass('temNotificacao');
				      			
		      					htmlNotificacao += '<div class="notificacao">';
									htmlNotificacao += '<p class="mensagemNotificacao">'+val.texto+'</p>';
								htmlNotificacao += '</div>';
		      				}
		      			});
						
						$('#main-notificacao').append(htmlNotificacao);
		      		}
		      	},
		      	error: function(data) {
		      		console.log('error = ', e);
		      	}
		    });
		},
		visualizaNotificacao: function(e) {
			e.preventDefault();
			$('#main-notificacao').toggle('show', function(){
				if($('#main-notificacao').css('display') == 'block') {
					$('#alerta-notificacao').removeClass('temNotificacao');
					$('#numeroNotificacao').text('');
				} else {
					$('#main-notificacao').html('');
				}				
			});		
			
		}
}

$(function() {
	
	POST_COMMENT.init();
	
	$('#txtComment').on('focus', POST_COMMENT.postFocus);	

	$('body').on('click', '.add-comments', POST_COMMENT.addComment);
	$('body').on('submit', '.frmCommentPost', POST_COMMENT.submitComment);
	$('body').on('click', '.deletePost', POST_COMMENT.onDeletePost);
	
	$('#alerta-notificacao').on('click', POST_COMMENT.visualizaNotificacao);
	
	setInterval(function(){
		POST_COMMENT.verificaNotificacoes();
	},10000);	
	
	$('#submitComment').on('click', POST_COMMENT.onSubmitPost);
});