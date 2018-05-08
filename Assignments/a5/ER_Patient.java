import java.time.LocalTime;
import java.util.Random;

/**
 * ER_Patient is a class that represents a patient who signs into the Emergency Room
 * to be assessed and treated by an ER Physician.
 * Each patient has :
 * <ul>
 * <li> an Id number, either accepted or generated,</li>
 * <li> a time of admission, either accepted or generated,</li>
 * <li> and a specific symptom that determines the priority number [1,4], inclusive,
 *	 calculated within the program.</li>
 * </ul>
 */

public class ER_Patient {

	/* Static variables necessary to randomize Id numbers */
	private static final int numDigits = 2;
	private static int range = (int)(Math.pow(10,numDigits));
	private static boolean[] used = new boolean[range];
	private static int[] fresh;
	private static int currIndex = 0;
	private static boolean open = false;

	/* instance variables */
	private String patientId;
	private String symptoms;
	private int priorityNum;
	private LocalTime admitTime;

	/**
 	 * Create ER_Patient admission information.
	 * @param admitTime The time given in hh:mm:ss format.
	 * @param patientNumber A number given to the patient.
	 * 	If this number is unique, then it is applied to the Patient Id
	 *	If it is not unique, then a random unique Id is attributed to the
	 *	patient.
	 * @param symptomCategory The category that determines the priority.
	 * 	Acceptable categories are:<ol>
	 *	<li>Life-threatening</li>
	 * 	<li>Chronic</li>
	 *	<li>Major fracture</li>
	 *	<li>Walk-in</li>
	 *	</ol>
	 */
	public ER_Patient(String admitTime, int patientNumber, String symptomCategory) {
		if (!open) {
			createUniqueIdList();
		}
		this.admitTime = LocalTime.parse(admitTime);
		patientId = setUniqueId(patientNumber);
		symptoms = symptomCategory;
		priorityNum = determinePriority();
	}

	/**
 	 * Create ER_patient dmission information.
	 * A patient Id number is generated.
	 * @param admitTime The time given in hh:mm:ss format.
	 * @param symptomCategory The category that determines the priority.
	 * 	Acceptable categories are:<ol>
	 *	<li>Life-threatening</li>
	 * 	<li>Chronic</li>
	 *	<li>Major fracture</li>
	 *	<li>Walk-in</li>
	 *	</ol>
	 */
	public ER_Patient(String admitTime, String symptomCategory) {
		if (!open) {
			createUniqueIdList();
		}
		this.admitTime = LocalTime.parse(admitTime);
		patientId = createUniqueId();
		symptoms = symptomCategory;
		priorityNum = determinePriority();
	}

	/**
 	 * Create ER_patient dmission information.
	 * A patient Id number is generated.
	 * The admission time to the current time.
	 * @param symptomCategory The category that determines the priority.
	 * 	Acceptable categories are:<ol>
	 *	<li>Life-threatening</li>
	 * 	<li>Chronic</li>
	 *	<li>Major fracture</li>
	 *	<li>Walk-in</li>
	 *	</ol>
	 */
	public ER_Patient(String symptomCategory) {
		if (!open) {
			createUniqueIdList();
		}
		admitTime = LocalTime.now();
		admitTime = admitTime.minusNanos(admitTime.getNano());
		patientId = createUniqueId();
		symptoms = symptomCategory;
		priorityNum = determinePriority();
	}

	/*
	 * Given the symptom, assigns a priority number.
	 * Assumes that the 
	 */
	private int determinePriority() {
		switch(symptoms) {
			case "Life-threatening":
				return 1;
			case "Chronic":
				return 2;
			case "Major fracture":
				return 3;
			case "Walk-in":
				return 4;
			default:
				throw new NoSuchCategoryException("Category does not exist.");
		}
	}

	/**
	 * @return The id number of the patient.
	 */
	public String getId() {
		return patientId;
	}

	public int getPriority() {
		return priorityNum;
	}

	public String getSymptoms() {
		return symptoms;
	}

	/**
	 * Determines equality: If this patient has the same id, then
	 * equality is true.
	 * @param other The paitent to compare to this one.
	 * @return True if the paitent id of this patient is the same
	 * 	as the other pateint's id.
	 */
	public boolean equals(ER_Patient other) {
		return this.patientId.equals(other.patientId);
	}

	/**
	 * Determines the order of this patient and another patient
	 * on the basis of their the Id numbers.
	 * @param other The patient to compare to this one.
	 * @return a number less than 0 if the Id of this patient is before the other.
	 *	0 if the ids are equal.
	 *	A number greater tha 0 if the other patient id is lower than this patients.
	 */
	public int compareTo(ER_Patient other) {
		return this.patientId.compareTo(other.patientId);
	}

	/**
	 * Determines whether this patient should be seen before the other patient.
	 * Order is determined first by priority number and secondarily by the admission
	 * time.
	 * @param other The patient to compare to this one.
	 * @return a number less than 0 if this patient has a higher priority.
	 * 	0 if the priorities are equal (which should only happen if it is the same patient).
	 * 	1 if the other patient has a higher priority.
	 */
	 public int prioritize(ER_Patient other) {
		int priorityDiff = this.priorityNum - other.priorityNum;
		if (priorityDiff != 0) {
			return priorityDiff;
		} else {
			return this.admitTime.compareTo(other.admitTime);
		}
	}

	/**
	 * The string representation of a Patient.
	 * Format:
	 * <pre>
	 * patientId: priorityNum admission time symptom
	 * </pre>
	 * @return Information about this patient as a String.
	 */
	public String toString() {
		StringBuilder s = new StringBuilder(range+2+2+8+symptoms.length());
		s.append(patientId+": "+priorityNum+" ");
		s.append(admitTime+" ");
		s.append(symptoms);
		return s.toString();
	}

	/**
 	 * A private method that shuffles an array of integers between 0 and range.
	 * Used to determine the unique values.
	 * This method is only called once for the first time a ER_Patient is created.
	 */
	private void createUniqueIdList() {
		fresh = new int[range];
		for (int i=0; i<range; i++) {
			fresh[i] = i;
		}
		// Implement the Durstenfeld shuffle
		Random rand = new Random();
		int r, tmp;
		for (int i=range-1; i>0; i--) {
			r = rand.nextInt(i+1);
			tmp = fresh[i];
			fresh[i] = fresh[r];
			fresh[r] = tmp;
		}
		open = true;
	}

	/**
	 * A private method that sets the number as the patient id, after
	 * checking that it has not been used before.
	 * If it has, then a new number is generated instead.
	 */
	private String setUniqueId(int num) {
		if (num < 0 || num > range-1) {
			return createUniqueId();
		}
		if (used[num]) {
			return createUniqueId();
		}
		return createId(num);
	}

	/**
	 * A private method that creates a unique patient id number.
	 */
	private String createUniqueId() {
		while (currIndex < fresh.length && used[fresh[currIndex]]) {
			currIndex++;
		}
		if (currIndex >= fresh.length) {
			throw new RuntimeException("Cannot create the new ER_Patient: No unique id numbers available.");
		}
		return createId(fresh[currIndex++]);
	}

	/**
	 * Converts the checked number into a String starting with 'P'.
 	 */
	private String createId(int num) {
		StringBuilder sb = new StringBuilder(numDigits+1);
		sb.append('P');
		used[num] = true;
		int base = range/10;
		int currDigit;
		while (base >= 1) {
			currDigit = num/base;
			if (currDigit != 0) {
				num %= 10;
			}
			sb.append(currDigit);
			base /= 10;
		}
		return sb.toString();
	}

	/**
	 * The unit tester for this class.
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		ER_Patient[] patients = new ER_Patient[5];
		String[] complaints = {"Walk-in", "Life-threatening","Chronic","Major fracture", "Chronic"};
		for (int i=0; i<5; i++) {
			patients[i] = new ER_Patient(complaints[i]);
			// spread out the admission times by 1 second
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("sleep interrupted");
				return;
			}
		}
		System.out.println("Patients waiting:");
		for (int i=0; i<5; i++) {
			System.out.println(patients[i]);
		}
	}
}
