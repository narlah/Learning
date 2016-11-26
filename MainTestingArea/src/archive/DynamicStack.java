package archive;

class ElementStack {
    ElementStack prev;
    int data = 0;

    public ElementStack(ElementStack prevConstr, int dataConstr) {
        this.prev = prevConstr;
        this.data = dataConstr;
    }

}

public class DynamicStack {
    private ElementStack Last = null;
    private int counter = 0;

    //constructors
    public DynamicStack() { //empty list created
    }

    public DynamicStack(int[] values) { //array in to create many elements
        if (Last == null && values.length != 0) {
            this.Last = new ElementStack(null, values[0]);
            this.counter++;
            for (int i = 1; i < values.length; i++) {
                ElementStack e = new ElementStack(Last, values[i]);
                this.Last = e;
                this.counter++;
            }
        }
    }

    public void addElement(int inData) { //��������
        ElementStack e;
        if (this.Last != null) {
            e = new ElementStack(Last, inData);
        } else {
            e = new ElementStack(null, inData);
        }
        Last = e;
        counter++;
    }

    public int deleteElement() { //����������
        int result = Last.data;
        Last = Last.prev;
        counter--;
        return result;

    }

    public int getElement() { //������ ��� ������
        int result = Last.data;
        return result;

    }

    public int[] toArray() { //�����  ����� ����� � ���������� �� �������.
        int[] result = new int[counter];
        result[0] = this.Last.data;
        ElementStack e = Last;
        int i = 1;
        while (e.prev != null) {
            e = e.prev;
            result[i] = e.data;
            i++;
        }
        return result;
    }

    public int getCount() {
        return this.counter;
    }

    public void emptyArray() {
        this.counter = 0;
        this.Last = null;
    }

}
