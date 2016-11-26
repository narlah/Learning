public class ElenaZadanie2Zadacha8 {
    public static void main(String[] args) {
        int N = 3;
        int currentElement = N - 1;
        for (int i = 0; i < N; i++) { //N-���� �� � ����, ��� �=1 ������ �� ������� ���� ���� ���
            //���� �������� ���������� � ����
            for (int j = 0; j < N; j++) { //npyti
                System.out.print(currentElement);
            }
            System.out.println(); //��� ���
            currentElement = currentElement + 2; //������ ���� 2 3333->5555->7777
        }
    }
}
