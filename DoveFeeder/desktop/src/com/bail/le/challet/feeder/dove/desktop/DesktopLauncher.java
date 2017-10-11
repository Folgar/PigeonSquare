package com.bail.le.challet.feeder.dove.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.bail.le.challet.feeder.dove.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		  config.title = "my-gdx-game";
		  config.width = 1920;
		  config.height = 1980;
		new LwjglApplication(new MyGdxGame(), config);
	}
}
