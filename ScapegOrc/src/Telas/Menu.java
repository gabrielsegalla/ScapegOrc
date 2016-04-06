package Telas;
import java.awt.Color;
import Objetos.DemoFonts;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import Objetos.BotaoTeste;
import Objetos.ElementoComImagem;

public class Menu extends ElementoComImagem  {

//	private Botao newGame ;
//	private Botao score;
//	private Botao credits;
//	private Botao exit;
	private BotaoTeste newGame ;
	private BotaoTeste score;
	private BotaoTeste credits;
	private BotaoTeste exit;


	
	public Menu(int width, int height) {
		super("resources/01 - Menu.png");
		newGame = new BotaoTeste("NEW GAME",  width/2-30 , height/2 + height/6 );
		score = new BotaoTeste("SCORE",  width/2 -30, height/2 + height/6 +80);
		credits = new BotaoTeste("CREDITS",  width/2-30 , height/2 + height/6 +160);
		exit = new BotaoTeste("EXIT",  width/2 -30, height/2 + height/6 +240);
	}
	
	
	
//	public Menu(int width, int height) {	
//		super("resources/01 - Menu.png");
//		newGame = new Botao("resources/botao newgame.png", "New Game", width/2 , height/2 + height/6);
//		score = new Botao("resources/botao score.png", "New Game", width/2 , height/2 + height/6 +80);
//		credits = new Botao("resources/botao credits.png", "New Game",  width/2 , height/2 + height/6 +160);
//		exit = new Botao("resources/botao exit.png", "New Game",  width/2, height/2 + height/6 +240);
////		exit.setWidth(248);
////		exit.setHeight(50);
//
//		//imagem = loadImage("imagens/background pong.png");
//		//imagem = imagem.getScaledInstance(Jogo.getScreenWidth(), Jogo.getScreenHeight(), Image.SCALE_DEFAULT);
//	}
//	
	
	
	

	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		
			
		newGame.draw(g);
		score.draw(g);
		credits.draw(g);
		exit.draw(g);
	
			
	}
	
	

	public BotaoTeste getNewGame() {
		return newGame;
	}

	public void setNewGame(BotaoTeste newGame) {
		this.newGame = newGame;
	}

	public BotaoTeste getScore() {
		return score;
	}

	public void setScore(BotaoTeste score) {
		this.score = score;
	}

	public BotaoTeste getCredits() {
		return credits;
	}

	public void setCredits(BotaoTeste credits) {
		this.credits = credits;
	}

	public BotaoTeste getExit() {
		return exit;
	}

	public void setExit(BotaoTeste exit) {
		this.exit = exit;
	}



	
}
