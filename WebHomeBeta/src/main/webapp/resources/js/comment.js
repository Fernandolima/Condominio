var POST_COMMENT  = {	
		
		init: function() {
			$.ajax({
		    	type: 'post',
		      	url:'home/getPublicacao',
		      	dataType: 'json',	
		      	success: POST_COMMENT.loadHome

		    });
		},
		
		loadHome: function(data) {
			var htmlHome = '';
			$.each(data, function(e, val){
				htmlHome = '';
				console.log(e);
				htmlHome += '<div class="post" data-id-user="1234">';
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
						$.each(val.comentarios, function(l, comment){							
								htmlHome += '<div class="comments">';
									htmlHome += '<img src="'+comment.imagemUsuario+'" class="thumb-post" />';
									htmlHome += '<a href="#" class="name-user-comment">'+comment.nome+'</a>';
									htmlHome += '<p class="time-comments">30/08/2013 - 18:21</p>';
									htmlHome += '<p>'+comment.comentario+'</p>';
								htmlHome += '</div>';
						});
							htmlHome += '<form class="frmCommentPost">';
								htmlHome += '<input type="text" class="inputComment" placeholder="Comentar" name="comment-post" />';
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
				htmlComment += '<form class="frmCommentPost">';
					htmlComment += '<input type="text" class="inputComment" placeholder="Comentar" name="comment-post" />';
				htmlComment += '</form>';
			htmlComment += '</div>';

			console.log('html = ', htmlComment);
			console.log('el = ', $(this));

			$(this).closest('.post').append(htmlComment);
			$(this).closest('.post').find('.comments-holder').fadeIn(1500);
			$(this).remove();
		},

		onSubmitPost: function(e) {
			e.preventDefault();

			$.ajax({
				data: $('#frmComment').serialize(),
		    	type: 'post',
		      	url:'home/getPublicacao',
		      	dataType: 'json',	
		      	success: POST_COMMENT.successPost
		    });
		},

		successPost: function(e) {
			var htmlInserPost = '',
				data = e.content;
				console.log('success');
				
			$.each(data, function(i, val){
				htmlInserPost += '<div class="post" data-id-user="1234">';
				htmlInserPost += '<a href="#" class="deletePost hidden">Excluir</a>';
				htmlInserPost += '<img src="img/thumb-post.jpg" class="thumb-post" />';
				htmlInserPost += '<div class="comments-post">';
					htmlInserPost += '<a href="#" class="name-user-comment">'+val.nameUser+'</a>';
					htmlInserPost += '<p class="time-comments">'+val.timePost+'</p>';
					htmlInserPost += '<p class="comment-user">'+val.message+'</p>';
				htmlInserPost += '</div>';
				htmlInserPost += '<a href="#" class="add-comments">>> Comentar</a>';
			htmlInserPost += '</div>';
			});
			
			$('#txtComment').val('');
			$('#main-comments').prepend(htmlInserPost);				
			
		}
}

$(function() {
	
	POST_COMMENT.init();
	
	$('#txtComment').on('focus', POST_COMMENT.postFocus);	

	$('.add-comments').on('click', POST_COMMENT.addComment);

	$('#submitComment').on('click', POST_COMMENT.onSubmitPost);
});