package pkgCBUtils;

import org.lwjgl.glfw.GLFWFramebufferSizeCallback;

import static org.lwjgl.glfw.GLFW.*;

public class CBWindowManager {
	private static GLFWFramebufferSizeCallback resizeWindow;
	private static CBWindowManager my_window;
	private static long glfwWindow;
	private static int win_height;
	private static int win_width;

	private CBWindowManager() {}

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

	public static CBWindowManager get(int a,int b) {
		throw new RuntimeException("Not implemented yet");
	}

	public static CBWindowManager get(int width, int height, int orgX, int orgY) {
		get(width, height);
		setWindowPosition(width, height);
		return my_window;
	}

	public static void setWindowPosition(int orgX, int orgY) {
		if (glfwWindow > 0) {
			glfwSetWindowPos(glfwWindow, orgX, orgY);
		}
	}

	public static CBWindowManager get() {
		throw new RuntimeException("Not implemented yet");
	}

	protected static void setWinWidth(int window, int width) {
		throw new RuntimeException("Not implemented yet");
	}

	public void enableResizeWindowCallback() {
		throw new RuntimeException("Not implemented yet");
	}

	public void swapBuffers() {
		throw new RuntimeException("Not implemented yet");
	}

	private static void initGlfwWindow() {

		glfwWindow = glfwCreateWindow(win_width, win_height, "CB Window", 0, 0);

		throw new RuntimeException("Not implemented yet");
	}

	public int[] getWindowSize() {
		throw new RuntimeException("Not implemented yet");
	}
}
