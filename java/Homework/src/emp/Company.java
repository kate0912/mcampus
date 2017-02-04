package emp;

public class Company {
	public static void main(String[] args) {
		// Employee 배열에 객체들을 생성하여 저장한다.
		Employee em[] = new Employee[2];
		em[0] = new Secretary("Duke", 1, "secretary", 800);
		em[1] = new Sales("Tuxi", 2, "sales", 1200);
        // printEmployee()  메서드를 호출하여 Employee 배열의 객체들 정보를 출력한다.
		// 이 때는 세금을 출력하지 않는다.
		printEmployee(em, false);
		// 모든 직원에게 인센티브로 100씩 지급한다.(직원에 따라 적용되는 인센티브 금액은
        // 다르다. 
		System.out.println("인센티브 100 지급\n");
		for(int i=0; i<em.length; i++) {
			if(em[i] instanceof Secretary)
				((Secretary)em[i]).incentive(100);
			else if(em[i] instanceof Sales)
				((Sales)em[i]).incentive(100);
		}
        // printEmployee()  메서드를 호출하여 Employee 배열의 객체들 정보
		// 와 세금을 출력한다.    
		printEmployee(em, true);

	}
	
	public static void printEmployee(Employee[] emp, boolean isTax) {
		// 객체의 정보를 출력한다.
        // isTax 의 참/거짓 여부에 따라서 텍스 출력 여부를 결정하여 처리한다.
		if(isTax) {
			System.out.println("name\tdepartment\tsalary\t\ttax");
			System.out.println("------------------------------------------------");
			for(int i=0; i<emp.length; i++) {
				System.out.printf("%-8s%-16s%-16d%-8.1f", emp[i].getName(), emp[i].getDepartment(), emp[i].getSalary(), emp[i].tax());
				System.out.println();
			}
		} else {
			System.out.println("name\tdepartment\tsalary");
			System.out.println("-------------------------------");
			for(int i=0; i<emp.length; i++) {
				System.out.printf("%-8s%-16s%-10d", emp[i].getName(), emp[i].getDepartment(), emp[i].getSalary());
				System.out.println();
			}
		}
		System.out.println();
	}
}
