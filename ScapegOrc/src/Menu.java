
import java.awt.Graphics2D;

public class Menu extends ElementoComImagem  {

	private Botao newGame ;
	private Botao score;
	private Botao credits;
	private Botao exit;
//	private Botao newGame ;
//	private Botao score;
//	private Botao credits;
//	private Botao exit;


	
//	public Menu(int width, int height) {
//		super("resources/01 - Menu.png");
//		newGame = new Botao("NEW GAME",  width/2-30 , height/2 + height/6 );
//		score = new Botao("SCORE",  width/2 -30, height/2 + height/6 + height/15);
//		credits = new Botao("CREDITS",  width/2-30 , height/2 + height/6 +2*height/15);
//		exit = new Botao("EXIT",  width/2 -30, height/2 + height/6 +3*height/15);
//	}
	
	
	
	public Menu(int width, int height) {	
		super("imagens/01 - Menu.png");
		newGame = new Botao("imagens/botao newgame.png", "New Game", width/2 , height/2 + height/6);
		score = new Botao("imagens/botao score.png", "New Game", width/2 , height/2 + height/6 +80);
		credits = new Botao("imagens/botao credits.png", "New Game",  width/2 , height/2 + height/6 +160);
		exit = new Botao("imagens/botao exit.png", "New Game",  width/2, height/2 + height/6 +240);
		exit.setWidth(248);
		exit.setHeight(50);

//		imagem = loadImage("imagens/background pong.png");
//		imagem = imagem.getScaledInstance(Jogo.getScreenWidth(), Jogo.getScreenHeight(), Image.SCALE_DEFAULT);
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
