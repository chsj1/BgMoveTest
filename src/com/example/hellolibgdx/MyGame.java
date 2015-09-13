package com.example.hellolibgdx;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RotateByAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class MyGame implements ApplicationListener {
	Stage stage;//����һ����̨����
	TextureAtlas atlas;//Ӧ��һ��TextureAtlas����
	TextureRegion bgRegion;//����һ��TextureRegion����.
	BgImage bgImage1;//����һ��Image����ʵ�ֱ����ƶ��ĵ�һ��ͼ
	BgImage bgImage2;//ʵ�ֱ����ƶ��ĵڶ���ͼ
	@Override
	public void create() {
		stage = new Stage(480, 800, false);//��ʼ��stage����,�����480���߶���800.
		atlas = new TextureAtlas(Gdx.files.internal("data/movebg.atlas"));//��ʼ��TextureAtlas����
		bgRegion = atlas.findRegion("movebg");//��ʼ��TextureAtlas
		bgImage1 = new BgImage(bgRegion);//��ʼ����һ��bgImage����
		bgImage1.setSize(480, 800);//����bgImage�Ĵ�С�����Ϊ480,�߶�Ϊ800
		bgImage2 = new BgImage(bgRegion);
		bgImage2.setSize(480, 800);
		bgImage2.setPosition(0, 800);//���õڶ��±���ͼ��λ��
		stage.addActor(bgImage1);//����Ա��ӵ���̨��
		stage.addActor(bgImage2);
		Gdx.input.setInputProcessor(stage);//ʹ��stage��������������¼�
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
	}
	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);// ���ñ���Ϊ��ɫ
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);// ����
		bgImage1.update();//ÿһ֡�����µ�һ�±���ͼ�͵ڶ��ű���ͼ��λ��
		bgImage2.update();
		stage.act();
		stage.draw();
		
//		RotateByAction r = new RotateByAction();
//		r.setAmount(rotationAmount);
//		RotateByAction  rotateByAction = Actions.rotateBy(rotationAmount, duration);
	}
	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
	}
}
