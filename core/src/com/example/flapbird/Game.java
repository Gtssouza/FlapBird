package com.example.flapbird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Game extends ApplicationAdapter {
	private int movimentoX = 0;
	private SpriteBatch spriteBatch; //exibe imagens e formas dentro do jogo
	private Texture[] passaros;
	private Texture fundo;

	private float variacao = 0;
	
	@Override
	public void create () {
		//Gdx.app.log("Create","Jogo iniciado");
		spriteBatch = new SpriteBatch();
		passaros = new Texture[3];
		passaros[0] = new Texture("passaro1.png");
		passaros[1] = new Texture("passaro2.png");
		passaros[2] = new Texture("passaro3.png");
		fundo = new Texture("fundo.png");
	}

	@Override
	public void render () {


		spriteBatch.begin();
		if(variacao > 3){
			variacao=0;
		}
		spriteBatch.draw(fundo,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		spriteBatch.draw(passaros[(int)variacao],movimentoX,500);
		//Calcula a diferença entre um render e outro
		variacao+= Gdx.graphics.getDeltaTime() * 10;
		movimentoX++;
		spriteBatch.end();

		//Gdx.app.log("Render","Jogo renderizado");
	}
	
	@Override
	public void dispose () {
		//Gdx.app.log("Dispose","Descarte de conteudo");
	}
}
