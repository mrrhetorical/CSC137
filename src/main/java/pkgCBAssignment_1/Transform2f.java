package pkgCBAssignment_1;

import org.joml.Vector2f;

import java.util.HashSet;
import java.util.Set;

/**
* Transform class to encapsulate an object's position, rotation, and scale. Also allows hierarchical structuring of
 * parent/children transforms.
* */
public class Transform2f {

	private Transform2f parent = null;
	private final Set<Transform2f> children = new HashSet<>();

	private Vector2f position = new Vector2f(0f, 0f);
	private Vector2f rotation = new Vector2f(0f, 0f);
	private Vector2f scale = new Vector2f(1f, 1f);

	public Transform2f() {}

	public final Vector2f getGlobalPosition() {
		return position;
	}

	/**
	 * Updates the global position. Also updates the children's positions.
	 * */
	public void setGlobalPosition(Vector2f position) {
		if (getChildren().isEmpty()) {
			this.position = position;
			return;
		}

		Vector2f delta = new Vector2f(getGlobalPosition()).sub(position);
		this.position = position;

		for (Transform2f child : getChildren()) {
			child.setGlobalPosition(new Vector2f(child.getGlobalPosition()).add(delta));
		}
	}

	/**
	 * Gets the local position relative to the parent.
	 * */
	public final Vector2f getLocalPosition() {
		if (getParent() == null) {
			return getGlobalPosition();
		}

		Vector2f localPosition = new Vector2f();
		getParent().getGlobalPosition().sub(getGlobalPosition(), localPosition);
		return localPosition;
	}

	/**
	 * Sets the local position relative to the parent. In most cases please, use this.
	 * */
	public void setLocalPosition(Vector2f localPosition) {
		if (getParent() == null) {
			setGlobalPosition(localPosition);
			return;
		}

		Vector2f globalPosition = new Vector2f(getParent().getGlobalPosition()).add(localPosition);
		setGlobalPosition(globalPosition);
	}

	/**
	 * Translates the transform with the given translation about its local position
	 * */
	public void translate(Vector2f translation) {
		setLocalPosition(new Vector2f(getLocalPosition()).add(translation));
	}


	public final Vector2f getRotation() {
		return rotation;
	}

	public void setRotation(Vector2f rotation) {
		if (getChildren().isEmpty()){
			this.rotation = rotation;
			return;
		}

		Vector2f delta = new Vector2f(getRotation()).sub(rotation);
		this.rotation = rotation;

		for (Transform2f child : getChildren()) {
			child.setRotation(new Vector2f(child.getRotation()).add(delta));
		}
	}

	public final Vector2f getScale() {
		return scale;
	}

	/**
	 * Sets the scale of this transform and affects children.
	 * */
	public void setScale(Vector2f scale) {
		if (getChildren().isEmpty()){
			this.scale = scale;
			return;
		}

		Vector2f delta = new Vector2f(getScale()).sub(scale);
		this.scale = scale;

		for (Transform2f child : getChildren()) {
			child.setScale(new Vector2f(child.getScale()).add(delta));
		}
	}

	public Transform2f getParent() {
		return parent;
	}

	public void setParent(Transform2f parent) {
		this.parent = parent;
	}

	public final Set<Transform2f> getChildren() {
		return children;
	}

	/**
	 * Adds a child transform and sets this transform as the parent.
	* */
	public void addChild(Transform2f child) {
		children.add(child);
		child.setParent(this);
	}

}
