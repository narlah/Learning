package hackerRank;

class Add {
    public void add(int... list) {
        int sum = 0;
        String text = "";
        for (int i =0;i<list.length;i++) {
            sum += list[i];
            String sign = list[i]>=0?"+":"";
            if (i == 0) {
                text += list[i] ;
            } else {
                text += sign + list[i];
            }
        }
        text = text.equals("")?"0":text;
        System.out.println(text + "=" + sum);
    }

    public static void main(String[] args) {
        Add a = new Add();
        a.add();
        a.add(1,2,0);
        a.add(1,2,3,4,-100);
        a.add(1,2,3,4,5,6,12,12);
    }

}