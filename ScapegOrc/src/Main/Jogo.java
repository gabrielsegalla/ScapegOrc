package Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Objetos.Botao;
import Telas.Credits;
import Telas.Historia;
import Telas.Menu;
import Telas.Pause;
import Telas.Score;
import Telas.fase1;

public class Jogo extends Canvas {

	private static int screenWidth;
	private static int screenHeight;

	private boolean gameRunning;
	private BufferStrategy strategy;

	private boolean isPlaying;

	private Menu menu;
	private Pause pause;
	private Credits credits;
	private fase1 fase1;
	private Score score;
	private Historia historia;
	private boolean isMenu;
	private boolean isPause;
	private boolean isStory;
	private boolean isCredits;
	private boolean isScore;
	private boolean isHist;

	private Botao botao;

	public static int getScreenWidth() {
		return screenWidth;
	}

	public static int getScreenHeight() {
		return screenHeight;
	}

	public Jogo() {
		JFrame container = new JFrame();
		container.setUndecorated(true);
		JPanel panel = (JPanel) container.getContentPane();

		Dimension fullScreen = Toolkit.getDefaultToolkit().getScreenSize();

		screenWidth = fullScreen.width;
		screenHeight = fullScreen.height;

		panel.setPreferredSize(new Dimension(screenWidth, screenHeight));
		panel.setLayout(null);
		setBounds(0, 0, screenWidth, screenHeight);
		panel.add(this);

		setIgnoreRepaint(true);
		container.pack();
		container.setResizable(false);
		container.setVisible(true);

		requestFocus();
		gameRunning = true;

		createBufferStrategy(2);
		strategy = getBufferStrategy();

		addKeyListener(new KeyInputHandler());
		addMouseListener(new MouseInputHandler());

		isPlaying = false;
		isCredits = false;
		isMenu = true;
		isCredits = false;
		isHist = false;
		menu = new Menu(this.getWidth(), this.getHeight());
		fase1 = new fase1(this.getWidth(), this.getHeight());
		pause = new Pause(this.getWidth(), this.getHeight());
		credits = new Credits(this.getWidth(), this.getHeight());
		score = new Score(this.getWidth(), this.getHeight());
		historia = new Historia(this.getWidth(), this.getHeight());
		isPause = false;

	}

	public void gameLoop() {
		while (gameRunning) {
			Graphics2D g = (Graphics2D) strategy.getDrawGraphics();

			g.setColor(Color.black);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());

			if (isMenu) {
				menu.draw(g);

			} else if (isPause) {

				pause.draw(g);

			} else if (isCredits) {

				credits.draw(g);

			} else if (isHist) {
				historia.draw(g);
				
			} else if (isScore) {
				score.draw(g);
			}else if (isPlaying) {
				fase1.draw(g);
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			g.dispose(); // precisa ficar no fim do while pra atualizar a tela
			strategy.show();
		}

	}

	public static void main(String[] args) {
		Jogo jogo = new Jogo();
		jogo.gameLoop();
	}

	private class MouseInputHandler extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {

			if (isMenu) {

				if (e.getX() >= menu.getExit().getPosX()
						&& e.getX() <= menu.getExit().getPosX()
								+ menu.getExit().getWidth()
						&& e.getY() <= menu.getExit().getPosY()
						&& e.getY() >= menu.getExit().getPosY()
								- menu.getExit().getHeight()) {
					System.out.println("Sair");
					System.exit(0);
				} else if (e.getX() >= menu.getNewGame().getPosX()
						&& e.getX() <= menu.getNewGame().getPosX()
								+ menu.getNewGame().getWidth()
						&& e.getY() <= menu.getNewGame().getPosY()
						&& e.getY() >= menu.getNewGame().getPosY()
								- menu.getNewGame().getHeight()) {
					isPlaying = false;
					isHist = true;
					isMenu = false;
					isCredits = false;
					isScore = false;
					System.out.println("Jogo");

				} else if (e.getX() >= menu.getCredits().getPosX()
						&& e.getX() <= menu.getCredits().getPosX()
								+ menu.getCredits().getWidth()
						&& e.getY() <= menu.getCredits().getPosY()
						&& e.getY() >= menu.getCredits().getPosY()
								- menu.getCredits().getHeight()) {
					System.out.println("creditos");
					isCredits = true;
					isPlaying = false;
					isMenu = false;
					isScore = false;
				} else if (e.getX() >= menu.getScore().getPosX()
						&& e.getX() <= menu.getScore().getPosX()
								+ menu.getScore().getWidth()
						&& e.getY() <= menu.getScore().getPosY()
						&& e.getY() >= menu.getScore().getPosY()
								- menu.getScore().getHeight()) {
					System.out.println("Score");
					isScore = true;
					isCredits = false;
					isPlaying = false;
					isMenu = false;
				}
			}
		}
	}

	private class KeyInputHandler extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println(e.getKeyCode());
			if (isPlaying) {

				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					isPlaying = false;
					isPause = true;
				}
			} else if (isPause) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					System.exit(0);
				} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					isPause = false;
					isPlaying = true;
				} else if (e.getKeyCode() == KeyEvent.VK_END) {
					isPause = false;
					isPlaying = false;
					isMenu = true;
				}

			} else if (isMenu) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					System.exit(0);
				}
			} else if (isScore) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					isMenu = true;
					isPlaying = false;
					isPause = false;
					isCredits = false;
					isScore = false;
					isHist = false;
				}
			} else if (isCredits) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					isMenu = true;
					isPlaying = false;
					isPause = false;
					isCredits = false;
					isScore = false;
					isHist = false;
				}
			}else if(isHist){
				if(e.getKeyCode() == KeyEvent.VK_SPACE){
					isHist = false;
					isPlaying = true;
					isPause = false;
					isCredits = false;
					isScore = false;
					isMenu = false;
					
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {

			if (e.getKeyCode() == KeyEvent.VK_W) {

			} else if (e.getKeyCode() == KeyEvent.VK_S) {

			}

			if (e.getKeyCode() == KeyEvent.VK_O) {

			} else if (e.getKeyCode() == KeyEvent.VK_L) {

			}

		}
	}

}
