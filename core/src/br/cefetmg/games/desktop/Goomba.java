/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.games.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 *
 * @author aluno
 */
public class Goomba {

    private final Texture texture;
    private final Sprite sprite;
    TextureRegion[][] quadrosDaAnimacao;
    float tempoDaAnimacao;
    int direction;
    
    private Animation<TextureRegion> andarParaFrente;
    private Animation<TextureRegion> andarParaTras;
    private Animation<TextureRegion> andarParaDireita;
    private Animation<TextureRegion> andarParaEsquerda;
    
    public Goomba(Texture texture) {
        this.texture = texture;
        this.sprite = new Sprite(texture);
        this.sprite.setPosition(30, 10);
        this.quadrosDaAnimacao = TextureRegion.split(texture, 21, 24);

         andarParaTras = new Animation<TextureRegion>(0.1f, 
        		quadrosDaAnimacao[0][0],
        		quadrosDaAnimacao[0][1],
        		quadrosDaAnimacao[0][2],
        		quadrosDaAnimacao[0][3],
        		quadrosDaAnimacao[0][4]);
        andarParaTras.setPlayMode(PlayMode.LOOP_PINGPONG);
        
        andarParaFrente = new Animation<TextureRegion>(0.1f, new TextureRegion[]{
        		quadrosDaAnimacao[2][0],
        		quadrosDaAnimacao[2][1],
        		quadrosDaAnimacao[2][2],
        		quadrosDaAnimacao[2][3],
        		quadrosDaAnimacao[2][4],
        });
        andarParaFrente.setPlayMode(PlayMode.LOOP_PINGPONG);
        
        andarParaDireita = new Animation<TextureRegion>(0.1f, new TextureRegion[]{
        		quadrosDaAnimacao[1][0],
        		quadrosDaAnimacao[1][1],
        		quadrosDaAnimacao[1][2],
        		quadrosDaAnimacao[1][3],
        		quadrosDaAnimacao[1][4],
        });
        andarParaDireita.setPlayMode(PlayMode.LOOP_PINGPONG);
        
        andarParaEsquerda = new Animation<TextureRegion>(0.1f, new TextureRegion[]{
        		quadrosDaAnimacao[3][0],
        		quadrosDaAnimacao[3][1],
        		quadrosDaAnimacao[3][2],
        		quadrosDaAnimacao[3][3],
        		quadrosDaAnimacao[3][4],
        });
        andarParaEsquerda.setPlayMode(PlayMode.LOOP_PINGPONG);
    }
    
    public void update() {
        tempoDaAnimacao += Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if (sprite.getY() < Gdx.graphics.getHeight() - 24 ) {
                sprite.setPosition(sprite.getX(), sprite.getY() + 1);
            }
            direction = 1;
        } 
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            if (sprite.getY() > 0) {
                sprite.setPosition(sprite.getX(), sprite.getY() - 1);
            }
            direction = 2;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (sprite.getX() > 0) {
                sprite.setPosition(sprite.getX() - 1, sprite.getY());
            }
            direction = 3;
        }  
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (sprite.getX() < Gdx.graphics.getWidth() - 21 ) {
                sprite.setPosition(sprite.getX() + 1, sprite.getY());
            }
            direction = 4;
        }
    }
    
    public void render(Batch batch) {
        update();
        switch (direction) {
            case 1:
                // Cima
                batch.draw((TextureRegion)andarParaFrente.getKeyFrame(tempoDaAnimacao), sprite.getX(), sprite.getY());
                break;
            case 2:
                // Baixo
                batch.draw((TextureRegion)andarParaTras.getKeyFrame(tempoDaAnimacao), sprite.getX(), sprite.getY());
                break;
            case 3:
                // Esquerda
                batch.draw((TextureRegion)andarParaEsquerda.getKeyFrame(tempoDaAnimacao), sprite.getX(), sprite.getY());
                break;
            case 4:
                // Direita
                batch.draw((TextureRegion)andarParaDireita.getKeyFrame(tempoDaAnimacao), sprite.getX(), sprite.getY());
                break;
            default:
                break;
        }
    }
    
}
