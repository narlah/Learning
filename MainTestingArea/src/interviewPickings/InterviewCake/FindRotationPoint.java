package interviewPickings.InterviewCake;

public class FindRotationPoint {

    public static void main(String[] args) {

        String[] words = new String[]{
                "ptolemaic",
                "retrograde",
                "supplant",
                "undulate",
                "xenoepist",
                "zamunda",
                "zimbabwe",
                "asymptote",  // <-- rotates here!
                "babka",
                "banoffee",
                "engender",
                "karpatka",
                "manwe",
                "othellolagkage"

        };

        FindRotationPoint fr = new FindRotationPoint();
        System.out.println(fr.findRotationPoint(words));
    }

    private int findRotationPoint(String[] words) {
        if (words[0].charAt(0) - words[words.length - 1].charAt(0) < 0) return -1; //not rotated
        int begin = 0, end = words.length - 1;
        while (begin <= end) {
            int half = (begin + end) / 2;

            if (begin == end - 1)
                return end;

            int coefficient = (words[begin].charAt(0) - words[half].charAt(0));
            if (coefficient >= 0) {
                end = half;
            } else
                begin = half;

        }
        return begin;
    }
}

