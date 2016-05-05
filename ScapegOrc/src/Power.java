


public class Power extends ObjetoAnimado {

	public Power(int posX, int posY, int frameX, int frameY) {
		super(posX, posY, 15, 15, "imagens/punch sprite.png", frameX, frameY, 160, 80);
		
	}

	@Override
	public void update() {
		if (getTime() == 5){
			setTime(0);
			setFrameX(getFrameX()+1);
			if (getFrameX()%4 == 0){
				setFrameX(0);
			}
			setPosX(getPosX()+getVelX());
		} else {
			setTime(getTime()+1);
		}
		
	}

	
	
	
	
	
}
