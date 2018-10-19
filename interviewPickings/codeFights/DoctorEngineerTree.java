package interviewPickings.codeFights;

public class DoctorEngineerTree {
    public static void main(String[] args) {
        DoctorEngineerTree deT = new DoctorEngineerTree();
        System.out.println(deT.findProfession(8, 100));
    }

    String findProfession(int level, int pos) {
        boolean isCurrentRootEngineer = true;
        int tempLvl = level;
        int tempPos = pos;
        for (int i = 1; i <= level; i++) {
            int total = (int) Math.pow(2, tempLvl--);
            if (tempPos > total) {
                tempPos = tempPos - total;
                isCurrentRootEngineer = !isCurrentRootEngineer;
            }
        }
        return ((tempPos == 1) ? isCurrentRootEngineer : !isCurrentRootEngineer) ? "Engineer" : "Doctor";
    }
    //oficial
    /*
    String findProfession(int level, int pos) {
        level--;
        pos--;
        int profession = pos % 2;
        while(level > 0){
            level--;
            pos >>= 1;
            profession ^= pos % 2;
        }
        return profession == 1 ? "Doctor" : "Engineer";
    }
     */
//naive brute force
//    String findProfession(int level, int pos) {
//        LinkedList<Boolean> llE = new LinkedList<>();
//        llE.add(true);
//        for(int i =1;i<=level;i++){
//            int lSize = llE.size();
//            for(int j = 0;j<lSize;j++){
//                if (llE.removeFirst()) {
//                    llE.addLast(true);
//                    llE.addLast(false);
//                } else {
//                    llE.addLast(false);
//                    llE.addLast(true);
//                }
//            }
//        }
//        return llE.get(pos-1)?"Engineer":"Doctor";
//    }

}


