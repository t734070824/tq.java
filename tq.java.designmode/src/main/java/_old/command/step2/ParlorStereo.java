package _old.command.step2;

public class ParlorStereo implements Stereo{

	@Override
	public void on() {
		System.err.println("ParlorStereo on");
	}

	@Override
	public void off() {
		System.err.println("ParlorStereo off");
	}

	@Override
	public void setCD(String cdName) {
		System.err.println("ParlorStereo cd-" + cdName);
	}

	@Override
	public void setDVD(String dvdName) {
		System.err.println("ParlorStereo dvd-" + dvdName);
	}

	@Override
	public void setRadio(String radioName) {
		System.err.println("ParlorStereo radio-" + radioName);
	}

	@Override
	public void setVolume(int num) {
		System.err.println("ParlorStereo V-" + num);
	}

}
