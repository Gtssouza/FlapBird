package com.example.flapbird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {
	private int movimentoX = 0;
	private SpriteBatch spriteBatch; //exibe imagens e formas dentro do jogo
	private Texture passaro;
	private Texture fundo;
	
	@Override
	public void create () {
		//Gdx.app.log("Create","Jogo iniciado");
		spriteBatch = new SpriteBatch();
		passaro = new Texture("passaro1.png");
		fundo = new Texture("fundo.png");
	}

	@Override
	public void render () {

		movimentoX++;
		spriteBatch.begin();
		spriteBatch.draw(fundo,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		spriteBatch.draw(passaro,movimentoX,500);
		spriteBatch.end();

		//Gdx.app.log("Render","Jogo renderizado");
	}
	
	@Override
	public void dispose () {
		//Gdx.app.log("Dispose","Descarte de conteudo");
	}
}
