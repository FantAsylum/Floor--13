package com.floor13.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.floor13.game.FloorMinus13;

public class DesktopLauncher {
	public static void main (String[] arg) {
		System.setProperty("user.name","user");
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(FloorMinus13.INSTANCE, config);
	}
}
