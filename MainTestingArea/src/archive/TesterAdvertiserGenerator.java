package archive;

import java.util.Random;

class AdvertiserGenerator {
    String[] adFrazi = {"���������  �  �������.", "����  �  ��������� �������.",
            "���������  �������  ����  �������.", "����  �  ���-������� ������� �� ���� ���������."};

    String[] adSluchki = {"����  ��  ��������  �����.", "�����  ��  �� �������.", "���  �������  ����.",
            "�� ���� �� ��������, �� ���� �� �������� ���������.", "�������� � ���. �� ��� ����� �������."};

    String[] adAutorFirstName = {"�����", "����", "�����", "�����", "����"};
    String[] adAutorSecondName = {"�������", "�������", "������"};
    String[] adCities = {"�����", "�������", "�����", "����", "������"};

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
