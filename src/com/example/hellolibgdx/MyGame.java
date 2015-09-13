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
	Stage stage;//定义一个舞台对象
	TextureAtlas atlas;//应以一个TextureAtlas对象
	TextureRegion bgRegion;//定义一个TextureRegion对象.
	BgImage bgImage1;//定义一个Image对象。实现背景移动的第一张图
	BgImage bgImage2;//实现背景移动的第二张图
	@Override
	public void create() {
		stage = new Stage(480, 800, false);//初始化stage对象,宽度是480，高度是800.
		atlas = new TextureAtlas(Gdx.files.internal("data/movebg.atlas"));//初始化TextureAtlas对象
		bgRegion = atlas.findRegion("movebg");//初始化TextureAtlas
		bgImage1 = new BgImage(bgRegion);//初始化第一个bgImage对象
		bgImage1.setSize(480, 800);//设置bgImage的大小。宽度为480,高度为800
		bgImage2 = new BgImage(bgRegion);
		bgImage2.setSize(480, 800);
		bgImage2.setPosition(0, 800);//设置第二章背景图的位置
		stage.addActor(bgImage1);//将演员添加到舞台上
		stage.addActor(bgImage2);
		Gdx.input.setInputProcessor(stage);//使用stage来处理输入输出事件
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
		Gdx.gl.glClearColor(1, 1, 1, 1);// 设置背景为白色
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);// 清屏
		bgImage1.update();//每一帧都更新第一章背景图和第二张背景图的位置
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
