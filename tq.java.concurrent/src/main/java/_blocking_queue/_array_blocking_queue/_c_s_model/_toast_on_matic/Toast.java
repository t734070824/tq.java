package _blocking_queue._array_blocking_queue._c_s_model._toast_on_matic;

public class Toast{
	public enum Status {DRY, BUTTERED, JAMMED};

	private Status status = Status.DRY;

	private final int id;

	public Toast(int id) {
		this.id = id;
	}

	public void butter() {status = Status.BUTTERED;}

	public void jam() {status = Status.JAMMED;}

	public Status getStatus() {
		return status;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "toast:" + id + ", status:" + status;
	}

}
