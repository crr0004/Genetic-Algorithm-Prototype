/**
 * 
 */
package me.crr.gamepieces;

import me.crr.main.MainChannel;
import me.tempus.collision.AABB;
import me.tempus.collision.IAABB;
import me.tempus.gameobjects.Plane;
import me.tempus.math.Vector3;
import me.tempus.shader.PVM;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

/**
 * @author Chris
 *
 */
public class Player implements IAABB {
	
	private MainChannel main;
	private AABB volume;
	private Plane model;
	private Vector3 pos;
	private float speed = 0.02f;
	
	public Player(Vector3 pos, Vector3 scale){
		this.model = new Plane(pos, scale);
		this.pos = pos;
		System.out.println(pos);
		this.model.create("textures/player.png", 0.05f);
		this.volume = AABB.findAABB(model.getVertices(), model.getIndices());
		Vector3 playerRotation = new Vector3((float) Math.toRadians(-90),0,0);
		model.setRotation(playerRotation);
	}
	
	public void update(){
		
		model.setPos(PVM.transformToLocalCords(pos, main.getScreenWidth(), main.getScreenWidth()));
	}
	
	@Override
	public AABB getAABB() {
		return volume;
	}
	
	public Plane getModel(){
		return model;
	}

	public void onKeyEvent(int keyCode) {
		if(keyCode == Keyboard.KEY_UP){
			pos.add(Vector3.scale(speed, Vector3.up));
		}else if(keyCode == Keyboard.KEY_DOWN){
			pos.add(Vector3.scale(speed, Vector3.down));
		}
		if(keyCode == Keyboard.KEY_LEFT){
			pos.add(Vector3.scale(speed, Vector3.left));
		}else if(keyCode == Keyboard.KEY_RIGHT){
			pos.add(Vector3.scale(speed, Vector3.right));
		}
		System.out.println(pos);
	}

	public void draw() {
		model.draw();
	}

	
}
