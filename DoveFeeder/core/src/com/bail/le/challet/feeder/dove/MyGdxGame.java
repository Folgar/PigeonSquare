package com.bail.le.challet.feeder.dove;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import java.util.ArrayList;
import java.util.Iterator;

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
  pigeon = new Pigeon(3,3);
  pigeon.setxLoc(500);
  pigeon.setyLoc(500);
  pigeon.setGdxWidth(Gdx.graphics.getWidth());
  pigeon.setGdxHeight(Gdx.graphics.getHeight());
  pigeons.add(pigeon);

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
      graine=new Graine(); 
      graine.setxLoc(x);
      graine.setyLoc(y);
      graines.add(graine);
  }
    
  Iterator<Graine> rectIter = graines.iterator();
  while(rectIter.hasNext()){
      Graine myObject = rectIter.next();
      myObject.Update();
      batch.draw(myObject.getMyTexture(), myObject.getxLoc(), myObject.getyLoc(), 100, 100);
  }
  
  Iterator<Pigeon> rectIter2 = pigeons.iterator();
  
  while(rectIter2.hasNext()){
      Pigeon pigeon = rectIter2.next();
      if(graines.size() > 0)
      {
    	  
    			pigeon.findClosestFood(graines);    	  
    	  
      }
      
      Iterator<Graine> rectIter3 = graines.iterator();
      while(rectIter3.hasNext()){
          Graine myObject = rectIter3.next();
          if(myObject.getxLoc()==pigeon.getxLoc() && myObject.getyLoc() == pigeon.getyLoc())
          {
        	  
        	  graines.remove(myObject);
        	  break;
          }
      }
      
      batch.draw(pigeon.getMyTexture(), pigeon.getxLoc(), pigeon.getyLoc(), 100, 100);
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
}
