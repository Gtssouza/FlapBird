package com.example.flapbird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

public class Game extends ApplicationAdapter {
	private int movimentoX = 0;
	private SpriteBatch spriteBatch; //exibe imagens e formas dentro do jogo
	private Texture[] passaros;
	private Texture fundo;
	private Texture canoBaixo;
	private Texture canoAlto;

	private float variacao = 0;
	private float gravidade = 2;
	private float larguraDispositivo;
	private float alturaDispositivo;
	private float posicaoInicialVerticalPassaro = 0;
	private float posicaoCanoHorizontal;
	private float posicaoCanoVertical;
	private float espacoEntreCanos;
	private Random random;
	private int pontos = 0;

	//Exibição de textos
	BitmapFont textoPontuacao;

	@Override
	public void create () {

		iniciarTexturas();
		iniciarObjetos();
	}

	@Override
	public void render () {

		verificaEstadoJogo();
		desenharTexturas();


	}

	private void desenharTexturas(){
		spriteBatch.begin();

		spriteBatch.draw(fundo,0,0,larguraDispositivo,alturaDispositivo);
		spriteBatch.draw(passaros[(int)variacao],30,posicaoInicialVerticalPassaro);
		posicaoCanoHorizontal--;
		spriteBatch.draw(canoBaixo, posicaoCanoHorizontal,alturaDispositivo/2 - canoBaixo.getHeight() - espacoEntreCanos/2 + posicaoCanoVertical);
		spriteBatch.draw(canoAlto,posicaoCanoHorizontal,alturaDispositivo/2 + espacoEntreCanos/2 + posicaoCanoVertical);
		textoPontuacao.draw(spriteBatch,String.valueOf(pontos), larguraDispositivo/2, alturaDispositivo-100);
		spriteBatch.end();
	}

	private void iniciarTexturas(){
		passaros = new Texture[3];
		passaros[0] = new Texture("passaro1.png");
		passaros[1] = new Texture("passaro2.png");
		passaros[2] = new Texture("passaro3.png");
		fundo = new Texture("fundo.png");

		canoAlto = new Texture("cano_topo_maior.png");
		canoBaixo = new Texture("cano_baixo_maior.png");

	}

	private void verificaEstadoJogo(){
		//Movimentação do cano
		posicaoCanoHorizontal -= Gdx.graphics.getDeltaTime()*200;
		if(posicaoCanoHorizontal < - canoAlto.getWidth()){
			posicaoCanoHorizontal = larguraDispositivo;
			posicaoCanoVertical = random.nextInt(800) - 400;
		}
		//aplica evento de toque na tela
		boolean toqueNaTela = Gdx.input.justTouched();
		if(toqueNaTela){
			gravidade = -20;
		}

		//Aplica gravidade no passaro
		if(posicaoInicialVerticalPassaro > 0 || toqueNaTela)
			posicaoInicialVerticalPassaro = posicaoInicialVerticalPassaro - gravidade;

		//Calcula a diferença entre um render e outro
		variacao+= Gdx.graphics.getDeltaTime() * 10;
		if(variacao > 3)
			variacao=0;

		gravidade++;
	}
	private void iniciarObjetos(){
		random = new Random();
		spriteBatch = new SpriteBatch();
		alturaDispositivo= Gdx.graphics.getHeight();
		larguraDispositivo = Gdx.graphics.getWidth();
		posicaoInicialVerticalPassaro = alturaDispositivo/2;
		posicaoCanoHorizontal = larguraDispositivo;
		espacoEntreCanos = 400;

		textoPontuacao = new BitmapFont();
		textoPontuacao.setColor(Color.WHITE);
		textoPontuacao.getData().setScale(10);
	}

	@Override
	public void dispose () {
		//Gdx.app.log("Dispose","Descarte de conteudo");
	}
}
