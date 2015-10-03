package archive;

class Student {
	private static int studentsCounter = 0;
	private String firstName;
	private String middleName;
	private String lastName;
	private int course; //1-4
	private String speciality;
	private String univercity;
	private String eMail;
	private String phoneNumber;

	//	All
	public Student(String firstName, String middleName, String lastName, int course, String speciality,
			String univercity, String mail, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.course = course;
		this.speciality = speciality;
		this.univercity = univercity;
		this.eMail = mail;
		this.phoneNumber = phoneNumber;
		Student.incrementCounter();
	}

	//no contacts , first course or transfer
	public Student(String firstName, String middleName, String lastName, int course, String speciality,
			String univercity) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.course = course;
		this.speciality = speciality;
		this.univercity = univercity;
		this.eMail = null;
		this.phoneNumber = null;
		Student.incrementCounter();
	}

	// candidate only , no contacts or uni/speciality or course
	public Student(String firstName, String middleName, String lastName, String mail) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.course = 0;
		this.speciality = null;
		this.univercity = null;
		this.eMail = mail;
		this.phoneNumber = null;
		Student.incrementCounter();
	}

	//setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getCourse() {
		return course;
	}

	public void setCourse(int course) {
		this.course = course;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	//getters
	public String getUnivercity() {
		return univercity;
	}

	public void setUnivercity(String univercity) {
		this.univercity = univercity;
	}

	public String getEMail() {
		return eMail;
	}

	public void setEMail(String mail) {
		eMail = mail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static int getStudentsCounter() {
		return studentsCounter;
	}

	public static int nullifyCounter() {
		int tempCounter = studentsCounter;
		studentsCounter = 0;
		return tempCounter;
	}

	public static void incrementCounter() {
		Student.studentsCounter++;
	}

	public void extractStudent() {
		int counter = getStudentsCounter();
		System.out
				.printf(
						"StudentNumber : %d \n FullName: %s %s %s \n Course: %d \n Speciality: %s \n Univercity: %s \n Email: %s \n PhoneNumber: %s \n \n",
						counter, firstName, middleName, lastName, course, speciality, univercity, eMail,
						phoneNumber);
	}

}

public class TestStudent {
	public static Student student1 = new Student("Nikolai", "Ivanov", "Kosev", 1, "Mathematics", "SU",
			"a@a.com", "08881123123");
	public static Student student2 = new Student("Nikolai", "Ivanov", "Kosev", 2, "Mathematics", "SU",
			"b@b.com", "08881123123");
	public static Student student3 = new Student("Nikolai", "Ivanov", "Kosev", 3, "Mathematics", "SU",
			"c@c.com", "08881123123");
	public static Student student4 = new Student("Nikolai", "Ivanov", "Kosev", 4, "Mathematics", "SU",
			"d@d.com", "08881123123");

	public static Student getStudent1() {
		return student1;
	}

	public static Student getStudent2() {
		return student2;
	}

	public static Student getStudent3() {
		return student3;
	}

	public static Student getStudent4() {
		return student4;
	}

	public static void main(String[] args) {
		//		Student student = new Student("Nikolai", "Ivanov", "Kosev", 1, "Mathematics", "SU", "a@a.com",
		//				"08881123123");
		//		student.extractStudent();
		//		System.out.println("Number of students:->" + Student.getStudentsCounter() + "\n");
		//		Student student2 = new Student("Ivan", "Ivanov", "Draganov", 4, "Infomratics", "TU", "b@b.bg",
		//				"08881897129");
		//		student2.extractStudent();
		System.out.println("Number of students:->>" + Student.nullifyCounter());

		Student student1 = getStudent1();
		student1.extractStudent();
		Student student2 = getStudent2();
		student2.extractStudent();
		Student student3 = getStudent3();
		student3.extractStudent();
		Student student4 = getStudent4();
		student4.extractStudent();
		Student student6 = new Student("Nikolai", "Ivanov", "Kosev", 5, "Mathematics", "SU",
				"d@d.com", "08881123123");
		student6.extractStudent();

		System.out.println("Number of students:->>" + Student.getStudentsCounter());

	}
}
