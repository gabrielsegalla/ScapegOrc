import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Menu extends ElementoComImagem {

	private Botao newGame ;
	private Botao score;
	private Botao credits;
	private Botao exit;

	
	public Menu(int width, int height) {	
		super("resources/01 - Menu.png");
		newGame = new Botao("resources/botao newgame.png", "New Game", width/2 , height/2 + height/6);
		score = new Botao("resources/botao score.png", "New Game", width/2 , height/2 + height/6 +80);
		credits = new Botao("resources/botao credits.png", "New Game",  width/2 , height/2 + height/6 +160);
		exit = new Botao("resources/botao exit.png", "New Game",  width/2, height/2 + height/6 +240);
		
		//imagem = loadImage("imagens/background pong.png");
		//imagem = imagem.getScaledInstance(Jogo.getScreenWidth(), Jogo.getScreenHeight(), Image.SCALE_DEFAULT);
	}
	
	
	
	

	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		
			
		newGame.draw(g);
		score.draw(g);
		credits.draw(g);
		exit.draw(g);
	
			
	}
	
	

	public Botao getNewGame() {
		return newGame;
	}

	public void setNewGame(Botao newGame) {
		this.newGame = newGame;
	}

	public Botao getScore() {
		return score;
	}

	public void setScore(Botao score) {
		this.score = score;
	}

	public Botao getCredits() {
		return credits;
	}

	public void setCredits(Botao credits) {
		this.credits = credits;
	}

	public Botao getExit() {
		return exit;
	}

	public void setExit(Botao exit) {
		this.exit = exit;
	}



	
}
