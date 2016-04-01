import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class BotaoTeste {

	private String nome;
	private int posX;
	private int posY;
	private int width;
	private int height;
	
	
	public BotaoTeste(String nome, int posX, int posY){
		this.nome = nome;
		this.posX = posX;
		this.posY = posY;
		this.width = 26 * nome.length();
		this.height = 26 * 2;
	}
	
	public void draw(Graphics2D g){
		g.setFont(new Font("Arial", Font.BOLD, 26));
		g.setColor(Color.black);
		
		g.drawString(nome, posX, posY);
		
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
