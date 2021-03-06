package com.bail.le.challet.feeder.dove;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Pigeon implements Runnable {

	private Texture myTexture = new Texture(Gdx.files.internal("pigeon.png"));
	private int xLoc = Gdx.input.getX() ;
	private int yLoc = Gdx.input.getY() ;
	private int xSpeed=1;
    private int ySpeed=1;
    private int gdxWidth;
    private int gdxHeight;
    private MyGdxGame environment;
    
    public Pigeon(int xspeed, int yspeed, MyGdxGame environment){
        this.xSpeed = xspeed;
        this.ySpeed = yspeed;
        this.environment = environment;
    }

    public void Update(){

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
	public int getGdxWidth() {
		return gdxWidth;
	}
	public void setGdxWidth(int gdxWidth) {
		this.gdxWidth = gdxWidth;
	}
	public int getGdxHeight() {
		return gdxHeight;
	}
	public void setGdxHeight(int gdxHeight) {
		this.gdxHeight = gdxHeight;
	}
    
	public void move(int destx, int desty)
	{
		if(this.getxLoc()>destx)
			this.setxLoc(this.getxLoc() - xSpeed);
		if(this.getyLoc()>desty)
			this.setyLoc(this.getyLoc() - ySpeed);
		if(this.getxLoc()<destx)
			this.setxLoc(this.getxLoc() + xSpeed);
		if(this.getyLoc()<desty)
			this.setyLoc(this.getyLoc() + ySpeed);
		if(this.getxLoc()-destx < xSpeed && this.getxLoc()-destx >= 0 )
			this.setxLoc(this.getxLoc() - (this.getxLoc()-destx));
		if(this.getyLoc() - desty < ySpeed && this.getyLoc() - desty >= 0)
			this.setyLoc(this.getyLoc() - (this.getyLoc() - desty));
	}
	
	public void findClosestFood(ArrayList<Graine> graines)
	{
		
		int closestX = 10000;
		int closestY = 10000;
		double bestDistance = 10000;
		double distance;
		Graine graine;
		boolean oneGraineIsHealthy = false;
		
		Iterator<Graine> rectIter = graines.iterator();
		
		  while(rectIter.hasNext()){
			  
		     graine = rectIter.next();
		     
		     if(graine.isHealthy()) {
		    	 oneGraineIsHealthy = true;
		    	 distance = Math.sqrt(
		    		 Math.pow(this.getxLoc() - graine.getxLoc(), 2.0)
		    		 + Math.pow(this.getyLoc() - graine.getyLoc(), 2.0)
		    		 );
		     
			     if(distance < bestDistance) {
			    	 bestDistance = distance;
			    	 closestX = graine.getxLoc();
			    	 closestY = graine.getyLoc();
			     }	
		     }
		  
		  }
		  
		  
		  if(oneGraineIsHealthy)
			  move(closestX,closestY);
	}
	
	@Override
	public void run() {
		
		if(environment.getGraines().size() > 0)
	      {
	    	  
	    			this.findClosestFood(environment.getGraines());    	  
	    	  
	      }
	      
	      Iterator<Graine> rectIter3 = environment.getGraines().iterator();
	      while(rectIter3.hasNext()){
	          Graine myObject = rectIter3.next();
	          if(myObject.getxLoc()==this.getxLoc() && myObject.getyLoc() == this.getyLoc() && myObject.isHealthy())
	          {
	        	  environment.getGraines().remove(myObject);
	        	  break;
	          }
	          else
	          {
	        	  move(this.getxLoc(), this.getyLoc());
	          }
	      }
	      
	      environment.getBatch().draw(this.getMyTexture(), this.getxLoc(), this.getyLoc(), 100, 100);
	      
	}
	
}
