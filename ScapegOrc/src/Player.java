public class Player extends ObjetoAnimado {

	private boolean walking;
	private boolean right;
	private boolean isRunning;
	private boolean up;
	private boolean left;
	private boolean down;

	//Construtor
	public Player(int posX, int posY, int velX, int velY, int frameX, int frameY) {
		super(posX, posY, velX, velY, "imagens/sprite orc.png", frameX, frameY,
				160, 200);
		setRight(true);
		setWalking(false);
	}

//Get & Set
	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public boolean isWalking() {
		return walking;
	}

	public void setWalking(boolean walking) {
		if (walking == false) {
			if (right) {
				setFrameY(0);

			} else if(left) {
				setFrameY(3);
			}
			setFrameX(0);
		}
		this.walking = walking;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		if (right) {
			setFrameY(2);
		} else {
			setFrameY(5);
		}

		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		if (up) {
			setFrameY(2);
		} else {
			setFrameY(5);
		}

		this.up = up;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		if (left) {
			setFrameY(5);
		} else {
			setFrameY(2);
		}
		this.left = left;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		if (down) {
			setFrameY(2);
		} else {
			setFrameY(5);
		}
		this.down = down;
	}

	//Update - Animação Sprites
	
	public void update() {
		if (!isWalking()) {
			setTime(0);
		} else {
			if (getTime() == 1) {
				setTime(0);
				setFrameX(getFrameX() + 1);
				if (getFrameX() % 4 == 0) {
					setFrameX(0);
				}
				if (right) {
					setPosX(getPosX() + getVelX());
				} else if (left) {
					setPosX(getPosX() - getVelX());
				}if (up) {
					setPosY(getPosY() - getVelY());
				} else if (down) {
					setPosY(getPosY() + getVelY());
				}

			} else {
				setTime(getTime() + 1);
			}

		}
	}


}
