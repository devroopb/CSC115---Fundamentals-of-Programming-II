import java.util.List;
import java.util.LinkedList;
import java.util.Random;

/**
 * CSC115 201509 Assignemnt 4 
 * 
 * This class is a simple record consisting af a patient and 
 * the current list of medications.
 * The id number has the format "Pdd", where d is a digit between 0 and 9.
 */


public class PatientMedRecord implements Comparable<PatientMedRecord> {

	private static final int numDigits = 2;
	private static int range = (int)(Math.pow(10,numDigits));
	private static boolean[] numbers = new boolean[range];
	private static Random rand = new Random();

	private String patientId;
	private List<String> medications;

	/**
	 * Create a patient record.
	 * @param patientNumber the unique id number of the patient.
	 * 	The number must be a unique id between 0 and 99.
	 * If the number is already attached to another patient, then
	 * the patient will be given a new unique number.
	 */
	public PatientMedRecord(int patientNumber) {
		patientId = setUniqueId(patientNumber);
		this.medications = new LinkedList<String>();
	}
		
	/**
	 * Create a patient record.
	 * In this version, the ids are created randomly for the purposes
	 * of adding some randomness in their insertion into a BinarySearchTree.
	 * A unique Id is created as "Pdd" where d is a digit between 0 and 9.
	 */
	public PatientMedRecord() {
		patientId = createUniqueId();
		this.medications = new LinkedList<String>();
	}

	/**
	 * @return The id number of the patient.
	 */
	public String getId() {
		return patientId;
	}

	/**
	 * Adds a medication to the list, if is not already in the list.
	 * @param medication The name of the medication.
	 * @return True if the medication was successfully added.
	 * 	If false is returned, it means that the medication cannot be added.
	 * 	In this version of the software, it means the medication is already listed.
	 */
	public boolean addMed(String medication) {
		if (medications.contains(medication)) {
			return false;
		} else {
			medications.add(medication);
			return true;
		}
	}

	/**
	 * Determines equality: If this patient has the same id then
	 * equality is true.
	 * @param other The patient to compare to this one.
	 * @return True if the patient id of the this Patient is the same
 	 * 	 as other patient's id.
	 */
	public boolean equals(PatientMedRecord other) {
		return this.patientId == other.patientId;
	}

	/**
	 * Determines the natural order of this patient and the other patient.
	 * @param other The patient to compare to this one.
	 * @return -1 if The id of this patient is before the other.
	 * 	    0 if the ids are equal.
	 * 	    1 if the other patient comes before this one.
	 */
	public int compareTo(PatientMedRecord other) {
		return this.patientId.compareTo(other.patientId);
	}

	/**
 	 * @return The current list of medications.
	 */
	public List<String> getMedications() {
		return medications;
	}

	/**
	 * @return The id number of the patient as a string.
 	 */
	public String toString() {
		return patientId;
	}

	/**
	 * A private method that sets the number as the patient id, after
	 * checkin that it has not been used before.
	 * If it has, then a new number is generated instead.
	 */
	private String setUniqueId(int num) {
		if (num < 0 || num > range-1) {
			return createUniqueId();
		}
		if (numbers[num]) {
			return createUniqueId();
		}
		return createId(num);
	}

	/**
	 * A private method that creates a unique patient id number.
	 */
	private String createUniqueId() {
		int uniqueNumber = rand.nextInt(range);
		int count = 0;
		// make sure there are no duplicates
		while (numbers[uniqueNumber] && count < range/2) {
			uniqueNumber = rand.nextInt(range);
			count++;
		}
		if (count == range+1) {
			System.out.println("Unable to easily find a unique patient id;");
			System.out.println("Add another digit to the patient id number.");
			System.exit(1);
		}
		return createId(uniqueNumber);
	}

	/**
	 * Converts the checked number into a String starting with 'P'.
	 */
	private String createId(int num) {
		StringBuilder sb = new StringBuilder(numDigits+1);
		sb.append('P');
		numbers[num] = true;
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
	 * Used as a unit tester in this class
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		PatientMedRecord pr = new PatientMedRecord();
		pr.addMed("ASA");
		pr.addMed("Dilantin");
		pr.addMed("Phenobarbital");
		pr.addMed("Tagamet");
		System.out.println("Created a new patient record called "+pr);
		System.out.println("The list of medications is "+pr.getMedications());
		// Checking to make sure the id is unique.
		PatientMedRecord[] bunch = new PatientMedRecord[10];
		for (int i=0; i<bunch.length; i++) {
			bunch[i] = new PatientMedRecord();
		}
		System.out.println("Ten random id  records created.");
		for (int i=0; i<bunch.length; i++) {
			System.out.println("\t"+bunch[i]);
		}
		//Try some home-made id numbers
		PatientMedRecord[] others = new PatientMedRecord[10];
		for (int i=0; i<others.length; i++) {
			others[i] = new PatientMedRecord(i);
		}
		System.out.println("Ten iterated id records created.");
		for (int i=0; i<others.length; i++) {
			System.out.println("\t"+others[i]);
		}
	}
}
