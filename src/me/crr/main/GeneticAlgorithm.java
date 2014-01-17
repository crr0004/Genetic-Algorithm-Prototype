/**
 * 
 */

package me.crr.main;

import me.crr.gamepieces.Player;
import me.tempus.camera.Camera;
import me.tempus.inputmmanagement.InputManager;
import me.tempus.inputmmanagement.InputReciever;
import me.tempus.math.Vector3;
import me.tempus.shader.PVM;
import me.tempus.shader.VIT_Shader;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

public class GeneticAlgorithm implements InputReciever, MainChannel {

	final Camera camera = new Camera();
	
	public VIT_Shader shader;
	public float screenWidth = 1024;
	public float screenHeight = 1024;
	
	private boolean done = false;
	private InputManager inputManager;
	private Player player;
	
	private void createScreen(String title, int width, int height){
		try {
	
			//Display.setFullscreen(fullscreen);
	
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle(title);
				Display.create();
			
			GL11.glViewport(0, 0, width, height);
	
			GL11.glEnable(GL11.GL_TEXTURE_2D);                          // Enable Texture Mapping
			
			GL11.glShadeModel(GL11.GL_SMOOTH);                          // Enables Smooth Color Shading
			GL11.glClearColor(0.5f, 0.5f, 0.5f, 0.0f);                // This Will Clear The Background Color To Gray
			GL11.glClearDepth(1.0);                                   // Enables Clearing Of The Depth Buffer
			GL11.glEnable(GL11.GL_DEPTH_TEST);                          // Enables Depth Testing
			GL11.glDepthFunc(GL11.GL_LEQUAL);                           // The Type Of Depth Test To Do
			GL11.glEnable (GL11.GL_BLEND);
			GL11.glBlendFunc (GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			PVM.setUpProjection(45f, width, height, 0.1f, 100f);
			System.out.println("OpenGL version: " + GL11.glGetString(GL11.GL_VERSION));
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
		
	private void initOPGL(){
		Keyboard.enableRepeatEvents(true);
		inputManager = new InputManager(1);
		inputManager.addReciever(this);
		
		player = new Player(new Vector3(0, -(screenHeight /2) /screenHeight, 0), new Vector3(1f,1f,1f));

		//camera.getPos().z = 0;
	}
	
	public void loop(){
		
		createScreen("Genetic Algorithm", (int)screenWidth, (int)screenHeight);
		initOPGL();
		setUpShaders();
		
		while(!done){
			update();
			draw();
			
		}
		return;
	}
	
	@Override
	public void onKeyEvent(int keyCode) {
		player.onKeyEvent(keyCode);
	}
	
	private void setUpShaders(){
		
		shader = new VIT_Shader();
		shader.load("../enginegit/Engine/Engine/shaders/VIT.vert", "../enginegit/Engine/Engine/shaders/VIT.frag");
	}
		
	private void update(){
		
		//camera.pollInput();
		inputManager.update();
		
	}
		
	private void draw(){
			
		GL20.glUseProgram(shader.getShaderID());
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		
		PVM.loadIdentity();
		camera.transform();
		player.draw();
		
		GL20.glUseProgram(0);
		Display.sync(60);
		Display.update();
			
	}
	
	
	public static void main(String[] args){
		new GeneticAlgorithm().loop();
	}

	@Override
	public float getScreenHeight() {
		return screenHeight;
	}

	@Override
	public float getScreenWidth() {
		return screenWidth;
	}

	@Override
	public Object getShader() {
		return shader;
	}
}
