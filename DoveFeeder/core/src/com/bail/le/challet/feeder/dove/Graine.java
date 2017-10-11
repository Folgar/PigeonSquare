package com.bail.le.challet.feeder.dove;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Graine {
	private Texture myTexture = new Texture(Gdx.files.internal("graine.png"));
	private int xLoc = Gdx.input.getX() - 10;
	private int yLoc = Gdx.input.getY() + 10;

    public void Update(){
        this.setxLoc(this.getxLoc() );
        this.setyLoc(this.getyLoc() );
    }
	public int getyLoc() {
		return yLoc;
	}
	public void setyLoc(int yLoc) {
		this.yLoc = yLoc;
	}
	public int getxLoc() {
		return xLoc;
	}
	public void setxLoc(int xLoc) {
		this.xLoc = xLoc;
	}
	public Texture getMyTexture() {
		return myTexture;
	}
	public void setMyTexture(Texture myTexture) {
		this.myTexture = myTexture;
	}
}
