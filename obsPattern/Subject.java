package obsPattern;

public interface Subject {

	public void detach(Observer o);

	public void notifyObservers();

	public void attach(Observer o);

}
