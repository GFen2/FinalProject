package finalproject;

public class MyMain {

	public static void main(String[] args) {

		// TASK 1: CREATE A CANVAS FOR ANIMATION
		Canvas canvas = new Canvas();
		canvas.requestFocus();
		
		//TASK 2:  ADD A USER GAME OBJECT OF TYPE D
		Type_D_GameObject user = new Type_D_GameObject(200, 200);
		user.setVelocity(10);
		canvas.addKeyListener(user);
		canvas.addGameObject(user);
		
		Type_A_GameObject A = new Type_A_GameObject(400, 400);
		A.setVelocity(10);
		canvas.addKeyListener(A);
		canvas.addGameObject(A);
		
		Type_B_GameObject B = new Type_B_GameObject(200, 200);
		B.setVelocity(10);
		canvas.addKeyListener(B);
		canvas.addGameObject(B);
		
		Type_C_GameObject C = new Type_C_GameObject(100, 100);
		C.setVelocity(10);
		canvas.addKeyListener(C);
		canvas.addGameObject(C);

	}

}
