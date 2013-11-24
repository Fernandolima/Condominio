package br.com.webhomebeta.handler;

import java.awt.Dimension;
import java.awt.Toolkit;
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

import com.mortennobel.imagescaling.AdvancedResizeOp.UnsharpenMask;
import com.mortennobel.imagescaling.ResampleOp;

import br.com.webhomebeta.entity.ImagePathAndSize;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.ComentarioService;
import br.com.webhomebeta.service.PerfilService;
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
	@Autowired
	private PerfilService perfilService;

	public ImagePathAndSize getOriginalImagemResized(MultipartFile file,
			Usuario usuario) {

		int width = 0;
		int height = 0;
		// Pega a resolucao do monitor do usuario
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		Dimension screenSize = toolkit.getScreenSize();

		File fileToBrowser = null;

		File caminho = null;

		String caminhoPasta = this.context.getRealPath("") + "/uploadedImgs/"
				+ usuario.getIdUser();

		String resultOriginal = this.context.getRealPath("") + "/uploadedImgs/"
				+ usuario.getIdUser() + "/" + file.getOriginalFilename();

		String imagemOriginal = "/WebHomeBeta/uploadedImgs/"
				+ usuario.getIdUser() + "/" + file.getOriginalFilename();

		if (screenSize.height > 899 && screenSize.width > 1599) {
			width = 500;
			height = 500;

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
					float percent = (500f / originalImage.getWidth()) * 100;
					height = ((originalImage.getHeight() * (int) percent) - originalImage
							.getHeight()) / 100;

					ResampleOp  resampleOp = new ResampleOp (width,height);
					resampleOp.setUnsharpenMask(UnsharpenMask.Normal);
					rescaledImage = resampleOp.filter(originalImage, null);
					
					

					fileToBrowser = new File(resultOriginal);

					if (file.getOriginalFilename().endsWith("jpg"))
						ImageIO.write(rescaledImage, "JPEG", fileToBrowser);
					if (file.getOriginalFilename().endsWith("png"))
						ImageIO.write(rescaledImage, "PNG", fileToBrowser);

				} else {
					float percent = (500f / originalImage.getHeight()) * 100;
					width = ((originalImage.getWidth() * (int) percent) - originalImage
							.getWidth()) / 100;

					ResampleOp  resampleOp = new ResampleOp (width,height);
					resampleOp.setUnsharpenMask(UnsharpenMask.Normal);
					rescaledImage = resampleOp.filter(originalImage, null);
					fileToBrowser = new File(resultOriginal);

					if (file.getOriginalFilename().endsWith("jpg"))
						ImageIO.write(rescaledImage, "JPEG", fileToBrowser);
					if (file.getOriginalFilename().endsWith("png"))
						ImageIO.write(rescaledImage, "PNG", fileToBrowser);

				}

				// salva imagem original

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (screenSize.height == 900 && screenSize.width == 1440) {
			
			width = 400;
			height = 300;
			
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
					float percent = (400f / originalImage.getWidth()) * 100;
					height = ((originalImage.getHeight() * (int) percent) - originalImage
							.getHeight()) / 100;

					ResampleOp  resampleOp = new ResampleOp (width,height);
					resampleOp.setUnsharpenMask(UnsharpenMask.Normal);
					rescaledImage = resampleOp.filter(originalImage, null);

					fileToBrowser = new File(resultOriginal);

					if (file.getOriginalFilename().endsWith("jpg"))
						ImageIO.write(rescaledImage, "JPEG", fileToBrowser);
					if (file.getOriginalFilename().endsWith("png"))
						ImageIO.write(rescaledImage, "PNG", fileToBrowser);

				} else {
					float percent = (300f / originalImage.getHeight()) * 100;
					width = ((originalImage.getWidth() * (int) percent) - originalImage
							.getWidth()) / 100;

					ResampleOp  resampleOp = new ResampleOp (width,height);
					resampleOp.setUnsharpenMask(UnsharpenMask.Normal);
					rescaledImage = resampleOp.filter(originalImage, null);

					fileToBrowser = new File(resultOriginal);

					if (file.getOriginalFilename().endsWith("jpg"))
						ImageIO.write(rescaledImage, "JPEG", fileToBrowser);
					if (file.getOriginalFilename().endsWith("png"))
						ImageIO.write(rescaledImage, "PNG", fileToBrowser);

				}

				// salva imagem original

			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if (screenSize.height == 768 && screenSize.width == 1366) {
			
			width = 300;
			height = 300;
			
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
					float percent = (300f / originalImage.getWidth()) * 100;
					height = ((originalImage.getHeight() * (int) percent) - originalImage
							.getHeight()) / 100;

					ResampleOp  resampleOp = new ResampleOp (width,height);
					resampleOp.setUnsharpenMask(UnsharpenMask.Normal);
					rescaledImage = resampleOp.filter(originalImage, null);

					fileToBrowser = new File(resultOriginal);

					if (file.getOriginalFilename().endsWith("jpg"))
						ImageIO.write(rescaledImage, "JPEG", fileToBrowser);
					if (file.getOriginalFilename().endsWith("png"))
						ImageIO.write(rescaledImage, "PNG", fileToBrowser);

				} else {
					float percent = (300f / originalImage.getHeight()) * 100;
					width = ((originalImage.getWidth() * (int) percent) - originalImage
							.getWidth()) / 100;

					ResampleOp  resampleOp = new ResampleOp (width,height);
					resampleOp.setUnsharpenMask(UnsharpenMask.Normal);
					rescaledImage = resampleOp.filter(originalImage, null);

					fileToBrowser = new File(resultOriginal);

					if (file.getOriginalFilename().endsWith("jpg"))
						ImageIO.write(rescaledImage, "JPEG", fileToBrowser);
					if (file.getOriginalFilename().endsWith("png"))
						ImageIO.write(rescaledImage, "PNG", fileToBrowser);

				}

				// salva imagem original

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (screenSize.height == 720 && screenSize.width == 1280) {
			try {
				
				width = 300;
				height = 300;
				
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
					float percent = (300f / originalImage.getWidth()) * 100;
					height = ((originalImage.getHeight() * (int) percent) - originalImage
							.getHeight()) / 100;

					ResampleOp  resampleOp = new ResampleOp (width,height);
					resampleOp.setUnsharpenMask(UnsharpenMask.Normal);
					rescaledImage = resampleOp.filter(originalImage, null);

					fileToBrowser = new File(resultOriginal);

					if (file.getOriginalFilename().endsWith("jpg"))
						ImageIO.write(rescaledImage, "JPEG", fileToBrowser);
					if (file.getOriginalFilename().endsWith("png"))
						ImageIO.write(rescaledImage, "PNG", fileToBrowser);

				} else {
					float percent = (300f / originalImage.getHeight()) * 100;
					width = ((originalImage.getWidth() * (int) percent) - originalImage
							.getWidth()) / 100;

					ResampleOp  resampleOp = new ResampleOp (width,height);
					resampleOp.setUnsharpenMask(UnsharpenMask.Normal);
					rescaledImage = resampleOp.filter(originalImage, null);

					fileToBrowser = new File(resultOriginal);

					if (file.getOriginalFilename().endsWith("jpg"))
						ImageIO.write(rescaledImage, "JPEG", fileToBrowser);
					if (file.getOriginalFilename().endsWith("png"))
						ImageIO.write(rescaledImage, "PNG", fileToBrowser);

				}

				// salva imagem original

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (screenSize.height > 768 && screenSize.width > 1024) {
			
			width = 300;
			height = 280;
			
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
					float percent = (300f / originalImage.getWidth()) * 100;
					height = ((originalImage.getHeight() * (int) percent) - originalImage
							.getHeight()) / 100;

					ResampleOp  resampleOp = new ResampleOp (width,height);
					resampleOp.setUnsharpenMask(UnsharpenMask.Normal);
					rescaledImage = resampleOp.filter(originalImage, null);
					
					fileToBrowser = new File(resultOriginal);

					if (file.getOriginalFilename().endsWith("jpg"))
						ImageIO.write(rescaledImage, "JPEG", fileToBrowser);
					if (file.getOriginalFilename().endsWith("png"))
						ImageIO.write(rescaledImage, "PNG", fileToBrowser);

				} else {
					float percent = (280f / originalImage.getHeight()) * 100;
					width = ((originalImage.getWidth() * (int) percent) - originalImage
							.getWidth()) / 100;

					ResampleOp  resampleOp = new ResampleOp (width,height);
					resampleOp.setUnsharpenMask(UnsharpenMask.Normal);
					rescaledImage = resampleOp.filter(originalImage, null);

					fileToBrowser = new File(resultOriginal);

					if (file.getOriginalFilename().endsWith("jpg"))
						ImageIO.write(rescaledImage, "JPEG", fileToBrowser);
					if (file.getOriginalFilename().endsWith("png"))
						ImageIO.write(rescaledImage, "PNG", fileToBrowser);

				}

				// salva imagem original

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (screenSize.height > 600 && screenSize.width > 800) {
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
					float percent = (300f / originalImage.getWidth()) * 100;
					height = ((originalImage.getHeight() * (int) percent) - originalImage
							.getHeight()) / 100;

					ResampleOp  resampleOp = new ResampleOp (width,height);
					resampleOp.setUnsharpenMask(UnsharpenMask.Normal);
					rescaledImage = resampleOp.filter(originalImage, null);

					fileToBrowser = new File(resultOriginal);

					if (file.getOriginalFilename().endsWith("jpg"))
						ImageIO.write(rescaledImage, "JPEG", fileToBrowser);
					if (file.getOriginalFilename().endsWith("png"))
						ImageIO.write(rescaledImage, "PNG", fileToBrowser);

				} else {
					float percent = (300f / originalImage.getHeight()) * 100;
					width = ((originalImage.getWidth() * (int) percent) - originalImage
							.getWidth()) / 100;

					ResampleOp  resampleOp = new ResampleOp (width,height);
					resampleOp.setUnsharpenMask(UnsharpenMask.Normal);
					rescaledImage = resampleOp.filter(originalImage, null);

					fileToBrowser = new File(resultOriginal);

					if (file.getOriginalFilename().endsWith("jpg"))
						ImageIO.write(rescaledImage, "JPEG", fileToBrowser);
					if (file.getOriginalFilename().endsWith("png"))
						ImageIO.write(rescaledImage, "PNG", fileToBrowser);

				}

				// salva imagem original

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return new ImagePathAndSize(imagemOriginal, width, height);
	}

	public String cropResizedImage(MultipartFile file, Usuario usuario, int x,
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

			BufferedImage cropedImage = Scalr.crop(rescaledImage, x, y, w, h,
					Scalr.OP_ANTIALIAS);

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
			usuario.setImagemView(imagem43x43);
			usuarioService.update(usuario);
			perfilService.update(imagemPerfil, usuario.getIdUser());

			// redimensiona imagem para o tamanho para 50x50

			
//			ResampleOp  resampleOp = new ResampleOp (120,120);
//			resampleOp.setUnsharpenMask(UnsharpenMask.Normal);
//			BufferedImage imagemRedimensionada120x120 = resampleOp.filter(cropedImage, null);
			
			ResampleOp resampleOp = new ResampleOp (50,50);
			resampleOp.setUnsharpenMask(UnsharpenMask.Normal);
			BufferedImage imagemRedimensionada43x43 = resampleOp.filter(cropedImage, null);
			
			
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

			usuario.setImagemView(imagem43x43);
			usuarioService.update(usuario);
			publicacaoService.update(usuario.getIdUser(), imagem43x43);
			comentarioService.update(usuario.getIdUser(), imagem43x43);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return imagemPerfil;
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
