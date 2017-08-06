package archive;

//������������  �����������  ������  ������� ��������� ������ � ������, 
//�����  ��������  ����  ��������,  �����  ���  ���������  ����  �  ���  ����-�������� �� �������. 
//������������ ���������� ��������, ���������� 
//� �������  ��  �������,  ��������  ��  �������  ��  ����������  �����
//(������),  ���������  �� �������  ��  ������ �  �����,  �����  ����� ����� 
//� ���������� �� �������.
class Element {
    Element prev;
    Element next;
    int data = 0;

    public Element(Element prevConstr, Element nextConstr, int dataConstr) {
        this.prev = prevConstr;
        this.next = nextConstr;
        this.data = dataConstr;
    }

}

public class DoubleLinkedList {
    private Element First = null;
    private Element Last = null;
    private int counter = 0;

    //constructors
    public DoubleLinkedList() { //empty list created
    }

    public DoubleLinkedList(int[] values) { //array in to create many elements
        if (Last == null && values.length != 0) {
            this.First = this.Last = new Element(null, null, values[0]);
            this.counter++;
            for (int i = 1; i < values.length; i++) {
                Element e = new Element(Last, null, values[i]);
                this.Last.next = e;
                this.Last = e;
                this.counter++;
            }
        }
    }

    public void addElement(int inData) { //��������
        if (this.Last != null) {
            Element e = new Element(Last, null, inData);
            Last.next = e;
            Last = e;
            counter++;
        } else {
            Element e = new Element(null, null, inData);
            this.Last = this.First = e;
            counter++;
        }
    }

    private void addElementFirst(int inData) { //�������� ������
        if (this.First != null) {
            First = new Element(null, First, inData);
            counter++;
        } else {
            addElement(inData);
        }
    }

    public void deleteElement(int index) { //����������
        if (index > counter || index <= 0) {
            System.out.println("Index out of bounds!");
        } else if (index == 1) {
            this.First = First.next;
            counter--;
        } else {
            Element e = First;
            int c = 1;
            do {
                e = e.next;
                c++;
            } while (c < index);
            Element prevFound = e.prev;
            Element nextFound = e.next;
            prevFound.next = nextFound;
            if (nextFound != null) {
                nextFound.prev = prevFound;
            }
            counter--;
        }
    }

    public int findIndexData(int inData) { //�������  ��  �������
        if (this.First.data == inData) {
            return 1;
        } else {
            Element e = First;
            for (int i = 2; i <= this.counter; i++) {
                e = e.next;
                if (e.data == inData)
                    return i;
            }
        }
        return -1;
    }

    public void addElementAt(int index, int inData) {//��������  ��  �������  ��  ����������  ����� (������)
        if (index > this.counter || index <= 0) {
            System.out.println("Index out of bounds!");
        } else if (index == 1) {
            addElementFirst(inData);
        } else if (index == counter) {
            addElement(inData);
        } else {
            Element e = this.First;
            for (int i = 2; i < this.counter; i++) {
                e = e.next;
                if (i == index) {
                    Element nov = new Element(e.prev, e, inData);
                    this.counter++;
                    e.prev.next = nov;
                    e.prev = nov;
                    break;
                }

            }
        }
    }

    public int getElementAt(int index) { //���������  �� �������  ��  ������
        if (index > counter || index <= 0) {
            System.out.println("Index out of bounds!");
            return -1;
        } else if (index == 1) {
            return First.data;
        } else {
            Element e = First;
            int c = 1;
            do {
                e = e.next;
                c++;
            } while (c < index);
            return e.data;
        }
    }

    public int[] toArray() { //�����  ����� ����� � ���������� �� �������.
        int[] result = new int[counter];
        result[0] = this.First.data;
        Element e = First;
        for (int i = 1; i < counter; i++) {
            e = e.next;
            result[i] = e.data;

        }
        return result;
    }

    public int getCount() {
        return this.counter;
    }

    public void emptyArray() {
        this.counter = 0;
        First = Last = null;
    }

}
