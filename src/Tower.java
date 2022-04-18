
import java.util.ArrayList;

public class Tower {
	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		this.observers.add(flyable);
		towerMessage(flyable, "registered to");
	}

	public void unregister(Flyable flyable) {
		this.observers.remove(flyable);
		towerMessage(flyable, "unregistered from");
	}

	protected void conditionChanged() {
		for (int i = observers.size() - 1; i >= 0; --i) {
			observers.get(i).updateConditions();
		}
	}

	private void towerMessage(Flyable flyable, String operation) {
		Aircraft aircraft = Aircraft.class.cast(flyable);
		System.out.printf("Tower says: ");
		if (flyable instanceof Baloon)
			System.out.printf("Baloon");
		if (flyable instanceof JetPlane)
			System.out.printf("JetPlane");
		if (flyable instanceof Helicopter)
			System.out.printf("Helicopter");
		System.out.printf("#%s(%s) %s weather tower.\n",
				aircraft.name, aircraft.id, operation);
	}
}
