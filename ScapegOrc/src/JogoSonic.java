
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JogoSonic extends Canvas {

	private static int screenWidth;
	private static int screenHeight;

	private boolean gameRunning;
	private BufferStrategy strategy;
	private boolean isPlaying;
	private Fundo fundo;
	private Player player;
	private Coxinha coxinha;
	private Inimigo inimigo;

	public JogoSonic() {
		JFrame container = new JFrame();

		container.setUndecorated(true);

		JPanel panel = (JPanel) container.getContentPane();
		Dimension fullScreen = Toolkit.getDefaultToolkit().getScreenSize();
		screenWidth = fullScreen.width;
		screenHeight = fullScreen.height;

		panel.setPreferredSize(fullScreen);
		panel.setLayout(null);
		setBounds(0, 0, screenWidth, screenHeight);
		panel.add(this);

		setIgnoreRepaint(true); // atualizaçao sera feita por nós
		container.pack();
		container.setResizable(false);
		container.setVisible(true);

		requestFocus();

		createBufferStrategy(2);
		strategy = getBufferStrategy();

		addKeyListener(new KeyInputHandler());
		addMouseListener(new MouseInputHandler());

		this.gameRunning = true;
		this.isPlaying = true;
		fundo = new Fundo(screenWidth, screenHeight);
		player = new Player(50, screenHeight - 300, 15, 15, 0, 0);
		coxinha = new Coxinha();
		inimigo = new Inimigo(50, screenHeight - 300);

	}

	public static int getScreenWidth() {
		return screenWidth;
	}

	public static int getScreenHeight() {
		return screenHeight;
	}

	public void gameLoop() {
		while (gameRunning) {
			Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
			g.setColor(Color.white);
			g.fillRect(0, 0, screenWidth, screenHeight);
			fundo.draw(g);

		
			player.draw(g);
			player.update();
			inimigo.draw(g);
			inimigo.update();
			for (int i = 0; i < coxinha.getCoxinhas().getSize(); i++) {
				Coxinha p = coxinha.getCoxinhas().buscarPosicao(i);
				p.draw(g);
				p.update();
			}
			g.dispose();
			strategy.show();
		}

	}

	public static void main(String[] args) {
		JogoSonic jogo = new JogoSonic();
		jogo.gameLoop();
	}

	private class KeyInputHandler extends KeyAdapter {
		public void keyPressed(KeyEvent e) {

			if (e.getKeyCode() == KeyEvent.VK_D
					|| e.getKeyCode() == KeyEvent.VK_RIGHT) {
				player.setWalking(true);
				player.setRight(true);
				player.setLeft(false);
			} else if (e.getKeyCode() == KeyEvent.VK_A
					|| e.getKeyCode() == KeyEvent.VK_LEFT) {
				player.setWalking(true);
				player.setLeft(true);
				player.setRight(false);
			} 
			if (e.getKeyCode() == KeyEvent.VK_S
					|| e.getKeyCode() == KeyEvent.VK_DOWN) {
				player.setWalking(true);
				player.setDown(true);
				player.setUp(false);
				
			} else if (e.getKeyCode() == KeyEvent.VK_W
					|| e.getKeyCode() == KeyEvent.VK_UP) {
				player.setUp(true);
				player.setDown(false);
				player.setWalking(true);
				
			} 
			//Para testar  a lista você pode adicionar coxinhas
			if (e.getKeyChar() == KeyEvent.VK_SPACE) {
				coxinha.adicionarCoxinhas();
			}

		}

		public void keyReleased(KeyEvent e) {
			player.setWalking(false);
			player.setRight(false);
			player.setLeft(false);
			player.setDown(false);
			player.setUp(false);
			
		}
	}

	private class MouseInputHandler extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			System.out.println("y="+e.getY());
			System.out.println("x="+e.getX());
			
		}
	}
	
}
