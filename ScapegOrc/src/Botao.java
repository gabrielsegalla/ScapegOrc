
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Botao extends ElementoComImagem{

	private String nome;
	private int posX;
	private int posY;
	private int width;
	private int height;
	

	
	
	public Botao(String fileName, String nome, int posX, int posY) {
		super(fileName);
		this.width = getImagem().getWidth(null);
		this.height = getImagem().getHeight(null);
		this.nome = nome;
		this.posX = posX- width/2;
		this.posY = posY;
		
	
	}

	public void draw(Graphics2D g){
		//g.setFont(new Font("Arial", Font.BOLD, 26));
		//g.setColor(Color.magenta);
		g.drawImage(getImagem(), posX, posY, null);
		
		
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
	
	
}
