import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public abstract class ObjetoAnimado {

	private int posX;
	private int posY;
	private int velX;
	private int velY;
	private Image sprite;
	private int frameX;
	private int frameY;
	private int time;

	private int width;
	private int height;

	public ObjetoAnimado(int posX, int posY, int velX, int velY, String url,
			int frameX, int frameY, int width, int height) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.velX = velX;
		this.velY = velY;
		this.sprite = loadImage(url);
		this.frameX = frameX;
		this.frameY = frameY;
		this.width = width;
		this.height = height;

	}

	public Image loadImage(String fileName) {
		URL imgUrl = getClass().getClassLoader().getResource(fileName);
		if (imgUrl == null) {
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

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public Image getSprite() {
		return sprite;
	}

	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}

	public int getFrameX() {
		return frameX;
	}

	public void setFrameX(int frameX) {
		this.frameX = frameX;
	}

	public int getFrameY() {
		return frameY;
	}

	public void setFrameY(int frameY) {
		this.frameY = frameY;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void draw(Graphics2D g) {

		// 1-imagem
		// 2- posçao x da tela onde ira iniciar o desenho da imagem
		// 3- posçao y da tela onde ira iniciar o desenho da imagem
		// 4- posçao x da tela onde ira terminar o desenho da imagem
		// 5- posçao y da tela onde ira terminar o desenho da imagem
		// 6- posçao x do sprite onde ira iniciar o recorte da imagem
		// 7- posçao y do sprite onde ira iniciar o recorte da imagem
		// 8- posçao x do sprite onde ira terminar o recorte da imagem
		// 9 -posçao y do sprite onde ira terminar o recorte da imagem
		// 10 - ImageObserver que será sempre null
		g.drawImage(sprite, posX, posY, posX + width, posY + height,
				(frameX * width), (frameY * height), (frameX * width) + width,
				(frameY * height) + height, null);
	}

	public abstract void update();

}
