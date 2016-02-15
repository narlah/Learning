public class ElenaZadanie2Zadacha8 {
	public static void main(String[] args) {
		int N=3;
		int currentElement = N-1;
		for (int i = 0; i < N; i++) { //N-пъти за Н реда, при н=1 цикъла ще извърти само един път
			//сега печатаме елементите в реда 
			for (int j = 0; j < N; j++) { //npyti
				System.out.print(currentElement);
			}
			System.out.println(); //нов ред
			currentElement=currentElement+2; //стъпка през 2 3333->5555->7777
		}
	}
}
