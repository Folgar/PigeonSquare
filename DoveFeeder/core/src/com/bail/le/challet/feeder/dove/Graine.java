package com.bail.le.challet.feeder.dove;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.Date;

public class Graine {
	private Texture myTexture = new Texture(Gdx.files.internal("graine.png"));
	private int xLoc = Gdx.input.getX() - 10;
	private int yLoc = Gdx.input.getY() + 10;
	private boolean isHealthy = true;
	private Date timeOfDrop;
	
	public Graine(Date timeOfDrop) {
		this.timeOfDrop = timeOfDrop;
	}

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

	/**
	 * @return the isHealthy
	 */
	public boolean isHealthy() {
		return isHealthy;
	}

	/**
	 * @param isHealthy the isHealthy to set
	 */
	public void setHealthy(boolean isHealthy) {
		this.isHealthy = isHealthy;
	}

	/**
	 * @return the timeOfDrop
	 */
	public Date getTimeOfDrop() {
		return timeOfDrop;
	}

	/**
	 * @param timeOfDrop the timeOfDrop to set
	 */
	public void setTimeOfDrop(Date timeOfDrop) {
		this.timeOfDrop = timeOfDrop;
	}
}
