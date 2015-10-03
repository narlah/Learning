package archive;

import java.lang.StringBuilder;
import java.util.Random;

class AdvertiserGenerator {
	String[] adFrazi = { "Продуктът  е  отличен.", "Това  е  страхотен продукт.",
			"Постоянно  ползвам  този  продукт.", "Това  е  най-добрият продукт от тази категория." };

	String[] adSluchki = { "Вече  се  чувствам  добре.", "Успях  да  се променя.", "Той  направи  чудо.",
			"Не мога да повярвам, но вече се чувствам страхотно.", "Опитайте и вие. Аз съм много доволна." };

	String[] adAutorFirstName = { "Диана", "Петя", "Стела", "Елена", "Катя" };
	String[] adAutorSecondName = { "Иванова", "Петрова", "Кирова" };
	String[] adCities = { "София", "Пловдив", "Варна", "Русе", "Бургас" };

	public String getAdMessage() {
		StringBuilder returnedMessage = new StringBuilder(100);
		Random ran = new Random();

		String fraza = adFrazi[ran.nextInt(adFrazi.length)];
		String sluchka = adSluchki[ran.nextInt(adSluchki.length)];
		String autorFirstName = adAutorFirstName[ran.nextInt(adAutorFirstName.length)];
		String autorSecondName = adAutorSecondName[ran.nextInt(adAutorSecondName.length)];
		String city = adCities[ran.nextInt(adCities.length)];

		returnedMessage.append(fraza).append(" ").append(sluchka).append("\n --").append(autorFirstName).append(" ").append(
				autorSecondName).append(", ").append(city);

		return returnedMessage.toString();
	}
}

public class TesterAdvertiserGenerator {

	public static void main(String[] args) {
		AdvertiserGenerator adGenerator = new AdvertiserGenerator();
		for (int i = 0; i <= 10; i++) {
			System.out.println(adGenerator.getAdMessage());
			System.out.println();
			System.out.println();
		}

	}
}
