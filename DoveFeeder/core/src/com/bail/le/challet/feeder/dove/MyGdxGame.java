package com.bail.le.challet.feeder.dove;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Date;
import com.badlogic.gdx.ApplicationListener;

public class MyGdxGame implements ApplicationListener {
	
 private Graine graine;
 private Pigeon pigeon;
 private ArrayList<Graine> graines;
 private ArrayList<Pigeon> pigeons;
 private SpriteBatch batch;
 private OrthographicCamera camera;
 private int x;
 private int y;
  
 @Override
 public void create() {
  batch=new SpriteBatch();
  camera=new OrthographicCamera();
  pigeons = new ArrayList<Pigeon>();
  graines = new ArrayList<Graine>();

  for(int i = 0; i < 4 ; i++) {
	  
	  pigeon = new Pigeon(3,3, this);
	  
	  pigeon.setxLoc(ThreadLocalRandom.current().nextInt(10, 1000));
	  pigeon.setyLoc(ThreadLocalRandom.current().nextInt(10, 1000));
	  
	  pigeon.setGdxWidth(Gdx.graphics.getWidth());
	  pigeon.setGdxHeight(Gdx.graphics.getHeight());
	  pigeons.add(pigeon);
	  
	 
  }
  

 }
 
 @Override
 public void render() {    
	 Gdx.gl.glClearColor(1,1,1, 1);
  Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
  batch.setProjectionMatrix(camera.combined);
  batch.begin();
  if(Gdx.input.isTouched()){
      Vector3 touchPos = new Vector3();
      touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
      camera.unproject(touchPos);
      x=(int) touchPos.x-75; 
      y=(int) touchPos.y-75;
      graine=new Graine(new Date()); 
      graine.setxLoc(x);
      graine.setyLoc(y);
      graines.add(graine);
  }
  
  Date date;
  
  Iterator<Graine> rectIter = graines.iterator();
  while(rectIter.hasNext()){
      Graine myObject = rectIter.next();
      myObject.Update();
      date = new Date();
      if(date.getTime() - myObject.getTimeOfDrop().getTime() > 10000) 
    	  myObject.setHealthy(false);
      
      if(myObject.isHealthy())
    	  batch.draw(myObject.getMyTexture(), myObject.getxLoc(), myObject.getyLoc(), 100, 100);
      else
    	  batch.draw(myObject.getMyTexture(), myObject.getxLoc(), myObject.getyLoc(), 50, 50);
    	  
  }
  
  Iterator<Pigeon> rectIter2 = pigeons.iterator();
  
  while(rectIter2.hasNext()){
      Pigeon pigeon = rectIter2.next();
      pigeon.run();
      }
  
  
  
  batch.end();
  
 }
 
 @Override
 public void resize(int width, int height) {
  camera.setToOrtho(false,width,height);
 }
 
 @Override
 public void pause() {
 }
 
 @Override
 public void resume() {
 }
 
 @Override
 public void dispose() {
  batch.dispose();
 }

/**
 * @return the graines
 */
public ArrayList<Graine> getGraines() {
	return graines;
}

/**
 * @param graines the graines to set
 */
public void setGraines(ArrayList<Graine> graines) {
	this.graines = graines;
}

/**
 * @return the pigeons
 */
public ArrayList<Pigeon> getPigeons() {
	return pigeons;
}

/**
 * @param pigeons the pigeons to set
 */
public void setPigeons(ArrayList<Pigeon> pigeons) {
	this.pigeons = pigeons;
}

/**
 * @return the batch
 */
public SpriteBatch getBatch() {
	return batch;
}

/**
 * @param batch the batch to set
 */
public void setBatch(SpriteBatch batch) {
	this.batch = batch;
}
}
