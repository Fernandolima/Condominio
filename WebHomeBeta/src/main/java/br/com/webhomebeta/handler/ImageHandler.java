package br.com.webhomebeta.handler;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.ComentarioService;
import br.com.webhomebeta.service.PublicacaoService;
import br.com.webhomebeta.service.UsuarioService;

public class ImageHandler {

	private BufferedImage rescaledImage;
	@Autowired
	private ServletContext context;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private ComentarioService comentarioService;
	@Autowired
	private PublicacaoService publicacaoService;

	public String getOriginalImagemResized(MultipartFile file, Usuario usuario) {

		// tamanho que a imagem ira ficar
		int width = 1024;
		int height = 1024;

		File fileToBrowser = null;

		File caminho = null;

		String caminhoPasta = this.context.getRealPath("") + "/uploadedImgs/"
				+ usuario.getIdUser();

		String resultOriginal = this.context.getRealPath("") + "/uploadedImgs/"
				+ usuario.getIdUser() + "/" + file.getOriginalFilename();

		String imagemOriginal = "/WebHomeBeta/uploadedImgs/"
				+ usuario.getIdUser() + "/" + file.getOriginalFilename();

		try {

			caminho = new File(caminhoPasta);
			if (!caminho.isDirectory()) {
				caminho.mkdirs();
			}

			BufferedImage originalImage = ImageIO
					.read(new ByteArrayInputStream(file.getBytes()));

			if (originalImage.getWidth() < width
					&& originalImage.getHeight() < height) {

				fileToBrowser = new File(resultOriginal);
				if (file.getOriginalFilename().endsWith("jpg"))
					ImageIO.write(originalImage, "JPEG", fileToBrowser);
				if (file.getOriginalFilename().endsWith("png"))
					ImageIO.write(originalImage, "PNG", fileToBrowser);

			} else if (originalImage.getWidth() > originalImage.getHeight()) {
				float percent = (1024f / originalImage.getWidth()) * 100;
				height = ((originalImage.getHeight() * (int) percent) - originalImage
						.getHeight()) / 100;

			} else {
				float percent = (1024f / originalImage.getHeight()) * 100;
				width = ((originalImage.getWidth() * (int) percent) - originalImage
						.getWidth()) / 100;

			}

			rescaledImage = Scalr.resize(originalImage, Method.ULTRA_QUALITY,
					Scalr.Mode.AUTOMATIC, width, height, Scalr.OP_ANTIALIAS);
			// salva imagem original

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "{'url':" + imagemOriginal + ",'width':" + width + ",'height':" + height + "}";
	}

	public void cropResizedImage(MultipartFile file, Usuario usuario, int x,
			int y, int w, int h) {
		File fileToDisk = null;
		File fileToDiskRedimensionada = null;
		File caminho = null;

		String caminhoPasta = this.context.getRealPath("") + "/uploadedImgs/"
				+ usuario.getIdUser();

		String resultPerfil = this.context.getRealPath("") + "/uploadedImgs/"
				+ usuario.getIdUser() + "/perfil-" + file.getOriginalFilename();

		String resultRedimensionada = this.context.getRealPath("")
				+ "/uploadedImgs/" + usuario.getIdUser() + "/r-"
				+ file.getOriginalFilename();

		String imagemPerfil = "/WebHomeBeta/uploadedImgs/"
				+ usuario.getIdUser() + "/perfil-" + file.getOriginalFilename();
		String imagem43x43 = "/WebHomeBeta/uploadedImgs/" + usuario.getIdUser()
				+ "/r-" + file.getOriginalFilename();

		try {

			BufferedImage cropedImage = Scalr.crop(rescaledImage, x, y, w, h, Scalr.OP_ANTIALIAS);

			caminho = new File(caminhoPasta);
			if (!caminho.isDirectory()) {
				caminho.mkdirs();
			}

			// salva imagem cropada

			if (file.getOriginalFilename().endsWith("jpg")) {
				fileToDisk = new File(resultPerfil);
				ImageIO.write(cropedImage, "JPEG", fileToDisk);
			}
			if (file.getOriginalFilename().endsWith("png")) {
				fileToDisk = new File(resultPerfil);
				ImageIO.write(cropedImage, "PNG", fileToDisk);
			}

			usuario.setImagem(imagemPerfil);
			usuarioService.update(usuario);

			// redimensiona imagem para o tamanho para 43x43
			
			BufferedImage imagemRedimensionada43x43 = Scalr.resize(
					cropedImage, Scalr.Method.ULTRA_QUALITY,
					Scalr.Mode.FIT_EXACT, 43, 43, Scalr.OP_ANTIALIAS);
			if (file.getOriginalFilename().endsWith("jpg")) {
				fileToDiskRedimensionada = new File(resultRedimensionada);
				ImageIO.write(imagemRedimensionada43x43, "JPEG",
						fileToDiskRedimensionada);
			}
			if (file.getOriginalFilename().endsWith("png")) {
				fileToDiskRedimensionada = new File(resultRedimensionada);
				ImageIO.write(imagemRedimensionada43x43, "PNG",
						fileToDiskRedimensionada);
			}

			publicacaoService.update(usuario.getIdUser(), imagem43x43);

			comentarioService.update(usuario.getIdUser(), imagem43x43);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getRescaledImage() {
		return rescaledImage;
	}

	public void setRescaledImage(BufferedImage rescaledImage) {
		this.rescaledImage = rescaledImage;
	}

	public ServletContext getContext() {
		return context;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

}
