package pkgCBUtils;

import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFWFramebufferSizeCallback;

import java.nio.IntBuffer;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11C.glViewport;

public class CBWindowManager {
	private static GLFWFramebufferSizeCallback resizeWindow = new GLFWFramebufferSizeCallback(){
		@Override
		public void invoke(long window, int width, int height){
			glViewport(0,0,width, height);
		}
	};
	;
	private static CBWindowManager my_window;
	private static long glfwWindow;
	private static int win_height;
	private static int win_width;

	private CBWindowManager() {
		initGlfwWindow();
	}

	public void updateContextToThis() {
		glfwMakeContextCurrent(glfwWindow);
	}

	public void destroyGlfwWindow() {
		glfwDestroyWindow(glfwWindow);
		glfwWindow = 0;
	}

	public boolean isGlfwWindowClosed() {
		return glfwWindow != 0;
	}

	public static CBWindowManager get(int width, int height) {
		if (my_window == null) {
			my_window = new CBWindowManager();
		}

		win_width = width;
		win_height = height;
		glfwSetWindowSize(glfwWindow, win_width, win_height);
		return my_window;
	}

	public static CBWindowManager get(int width, int height, int orgX, int orgY) {
		get(width, height);
		setWindowPosition(orgX, orgY);
		return my_window;
	}

	public static void setWindowPosition(int orgX, int orgY) {
		if (glfwWindow > 0) {
			glfwSetWindowPos(glfwWindow, orgX, orgY);
		}
	}

	public static CBWindowManager get() {
		return get(win_width, win_height);
	}

	protected static void setWinWidth(int width, int height) {
		glfwSetWindowSize(glfwWindow, width, height);
	}

	public void enableResizeWindowCallback() {
		glfwSetFramebufferSizeCallback(glfwWindow, resizeWindow);
	}

	public void swapBuffers() {
		glfwSwapBuffers(glfwWindow);
	}

	private static void initGlfwWindow() {
		glfwWindow = glfwCreateWindow(win_width, win_height, "CB Window", 0, 0);
	}

	public int[] getWindowSize() {
		IntBuffer windowSize = BufferUtils.createIntBuffer(2);
		glfwGetWindowSize(glfwWindow, windowSize, windowSize);
		return new int[]{windowSize.get(0), windowSize.get(1)};
	}
}
