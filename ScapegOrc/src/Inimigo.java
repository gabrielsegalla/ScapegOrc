


public class Inimigo extends ObjetoAnimado {

	public Inimigo(int posX, int posY) {
		super(posX, posY, 5, 5, "imagens/elf sprite.png", 0, 0, 130, 200);
		limiteInf = posX;
		limiteSup = posX + 500;
		

	}

	private boolean right;
	private int limiteInf;
	private int limiteSup;

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

	public int getLimiteInf() {
		return limiteInf;
	}

	public void setLimiteInf(int limiteInf) {
		this.limiteInf = limiteInf;
	}

	public int getLimiteSup() {
		return limiteSup;
	}

	public void setLimiteSup(int limiteSup) {
		this.limiteSup = limiteSup;
	}

	public void update() {
		if (getTime() == 1) {
			setTime(0);
			setFrameX(getFrameX() + 1);
			if (getFrameX() % 4 == 0) {
				setFrameX(0);
			}
			if (right) {
				setPosX(getPosX() + getVelX());
				if (getPosX() > limiteSup) {
					setRight(false);
				}
			} else {
				setPosX(getPosX() - getVelX());
				if (getPosX() < limiteInf) {
					setRight(true);
				}
			}
		} else {
			setTime(getTime() + 1);
		}
	}

}