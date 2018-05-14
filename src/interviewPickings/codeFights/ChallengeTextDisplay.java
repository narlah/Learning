package interviewPickings.codeFights;


import java.util.LinkedList;
import java.util.ListIterator;

public class ChallengeTextDisplay {

    public static void main(String[] args) {

        // the output should be textDisplay(keycodes) = "nice and simple".
        int[] keycodes = new int[]{78, 73, 67, 69, 32, 65, 78, 68, 32, 83, 73, 77, 80, 76, 69};
        //, the output should be textDisplay(keycodes) = "hey, you did it"
        int[] keycodes2 = new int[]{72, 69, 89, 32, 89, 79, 85, 32, 68, 73, 68, 32, 73, 84, 32, 87, 82, 79, 78, 71, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 188, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 46, 46, 8, 8, 46, 46, 8};

        ChallengeTextDisplay cha = new ChallengeTextDisplay();
        System.out.println(cha.textDisplay(keycodes));
        System.out.println(cha.textDisplay(keycodes2));
    }


    String textDisplay(int[] keycodes) {
        LinkedList<Integer> dl = new LinkedList<>();
        int cursorIndex = 0;
        for (int i : keycodes) {
            //backspace, delete, home, end, and the left & right arrow keys, in addition to alphanumeric characters and punctuation.
            //08 bs,127 del, end 35, home 36, left arrow 	37, right arrow 	39
            switch (i) {
                case (35): {
                    cursorIndex = -1;
                    break;
                }

                case (36): {
                    cursorIndex = dl.size() - 1;
                    break;
                }
                case (8): {
                    cursorIndex--;
                    dl.remove(cursorIndex);
                    break;
                }
                case (127): {
                    if (dl.size() > cursorIndex)
                        dl.remove(cursorIndex);
                    break;
                }
                case (37): {
                    cursorIndex--;
                    break;
                }
                case (39): {
                    if (dl.size() > cursorIndex)
                        cursorIndex++;
                    break;
                }
                default: {
                    dl.add(cursorIndex, i);
                    cursorIndex++;
                }

            }

        }
        StringBuilder strB = new StringBuilder(dl.size());
        ListIterator<Integer> listI = dl.listIterator();
        while (listI.hasNext()) {

            strB.append((char) listI.next().intValue());
        }
        return strB.toString().toLowerCase();
    }


}
