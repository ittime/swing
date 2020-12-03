/**
 * 
 */
package exampleInternet.javaBasic.hr;

/**
 * @author jron
 *
 */
public class HrMain {

	/***
	 * 
	 */
	private int counter = 0;
	
	
	/**
	 * 
	 */
	public HrMain() {
		counter++;
		System.out.println(counter);
		// TODO Auto-generated constructor stub
	}

	
	public String getTeamIcon() {
		
		return "Go Team";
	}
	
	
	public static void teamIcon(HrMain hm) {
		System.out.println("yeaa");
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HrMain hm = new HrMain();
	}

	
}
