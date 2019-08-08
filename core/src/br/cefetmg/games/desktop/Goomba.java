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
    Texture spriteSheet;
    TextureRegion[][] quadrosDaAnimacao;
    Animation andarParaFrente;
    float tempoDaAnimacao;
    
    public Goomba(Texture texture) {
        this.texture = texture;
        this.sprite = new Sprite(texture);
        this.sprite.setPosition(30, 10);
    }
    
    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP) && sprite.getY() > 0) {
            sprite.setPosition(sprite.getX(), sprite.getY() + 1);
        } 
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && sprite.getY() < Gdx.graphics.getHeight()- sprite.getHeight()) {
            sprite.setPosition(sprite.getX(), sprite.getY() - 1);

        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && sprite.getX() > 0) {
            sprite.setPosition(sprite.getX() - 1, sprite.getY());

        }  
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && sprite.getX() < Gdx.graphics.getWidth() - sprite.getWidth()) {
            sprite.setPosition(sprite.getX() + 1, sprite.getY());
        }
    }
    
    public void render(Batch batch) {
        sprite.draw(batch);
    }
    
}
