package Objetos;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import Main.Jogo;

public class ElementoComImagem {

	private Image imagem;
	
	public ElementoComImagem(String fileName) {
		imagem = loadImage(fileName);
		//imagem = imagem.getScaledInstance(Jogo.getScreenWidth(), Jogo.getScreenHeight(), Image.SCALE_DEFAULT);
		
	}
	
	
	
	public Image loadImage(String fileName){
		URL imgUrl = getClass().getClassLoader().getResource(fileName);
		if(imgUrl == null){
			System.out.println("Erro ao carregar a imagem:" + fileName);
		} else {
			try {
				return ImageIO.read(imgUrl);
			} catch (IOException e) {
					e.printStackTrace();
			}
		}
		return null;
	}
	
	
	public void draw(Graphics2D g){
		g.drawImage(imagem, 0, 0, null);
		imagem = imagem.getScaledInstance(Jogo.getScreenWidth(), Jogo.getScreenHeight(), Image.SCALE_DEFAULT);
		
		//provavelmente o problema de resize e escala vai ser aqui
		
		
		
		
	}



	public synchronized Image getImagem() {
		return imagem;
	}



	public synchronized void setImagem(Image imagem) {
		this.imagem = imagem;
	}
	
	
	
	
	
	
	
	
}
