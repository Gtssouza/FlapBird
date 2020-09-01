package com.example.flapbird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {
	private SpriteBatch spriteBatch; //exibe imagens e formas dentro do jogo
	private Texture passaro;
	
	@Override
	public void create () {
		//Gdx.app.log("Create","Jogo iniciado");
		spriteBatch = new SpriteBatch();
		passaro = new Texture("passaro1.png");
	}

	@Override
	public void render () {

		spriteBatch.begin();
		spriteBatch.draw(passaro,0,0);
		spriteBatch.end();

		//Gdx.app.log("Render","Jogo renderizado");
	}
	
	@Override
	public void dispose () {
		//Gdx.app.log("Dispose","Descarte de conteudo");
	}
}
