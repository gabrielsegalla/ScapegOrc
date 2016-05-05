import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;

public class Coxinha {

	public static final int WIDTH = 32;
	public static final int HEIGHT = 32;
	Random r;
	int ran;
	int ran2;
	private int posX;
	private int posY;
	private Image sprite;
	private int frameX;
	private int frameY;
	private int time;
	private boolean isZiste;
	private int pontos;
	private ListaSimples<Coxinha> coxinhas;

	// Construtor
	public Coxinha() {
		r = new Random();
		ran = r.nextInt(Jogo.getScreenWidth());
		// ran2 = r.nextInt(JogoSonic.getScreenHeight() - 252);
		this.posX = this.ran;
		// this.posY=this.ran2;
		posY = Jogo.getScreenHeight() - 252;
		sprite = loadImage("imagens/coxinha sprite.png");
		frameX = 0;
		this.frameY = frameY;
		time = 0;
		coxinhas = new ListaSimples<Coxinha>();
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

	// Get & Set
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

	public boolean isZiste() {
		return isZiste;
	}

	public void setZiste(boolean isZiste) {
		this.isZiste = isZiste;
	}

	public ListaSimples<Coxinha> getCoxinhas() {
		return coxinhas;
	}

	public void setCoxinhas(ListaSimples<Coxinha> coxinhas) {
		this.coxinhas = coxinhas;
	}

	// Updtae - Animação
	public void update() {
		if (!isZiste()) {
			if (time == 5) {
				time = 0;
				frameX++;
				if (frameX % 2 == 0) {
					frameX = 0;
				}

			} else {
				time++;
			}
		}
	}

	public void draw(Graphics2D g) {

		g.drawImage(sprite, posX, posY, posX + WIDTH, posY + HEIGHT,
				(frameX * WIDTH), (frameY * HEIGHT), (frameX * WIDTH) + WIDTH,
				(frameY * HEIGHT) + HEIGHT, null);
	}

	public void adicionarCoxinhas() {
		Coxinha coxinha = new Coxinha();
		coxinhas.addPrimeiro(coxinha);
	}

}
