package interviewPickings.codeFights;

public class DiceRolls {
    public static void main(String[] args) {
        System.out.println();

    }

//    int diceRolls(int[][] dice, int sum) {
//        int diceLen = dice[0]
//        arrNs:=make([]int,diceLen)
//        counter:=0
//        for index, arr :=range dice {
//            x:=sort.SearchInts(arr, sum)
//            for _, y :=range arr[ x:]{
//                if arr[x] != y {
//                    break
//                }
//                x++
//            }
//            arrNs[index] = x
//        }
//        for i, el :=range dice[ diceLen - 1]{
//            dice[diceLen - 1][i] = sum - el
//        }
//        var fu func(currDiceIndex int,currSum int)
//        fu = func(currDiceIndex int,currSum int){
//            if currDiceIndex == -1 && currSum == 0 {
//                counter++
//                return
//            }
//            if currDiceIndex< 0 {
//
//                return
//            }
//            for i:=arrNs[currDiceIndex] - 1;
//            i >= 0;
//            i-- {
//                newSum:=currSum - dice[currDiceIndex][i]
//                if newSum< 0 {
//                    continue
//                }
//                fu(currDiceIndex - 1, newSum)
//            }
//        }
//        for _, el :=range dice[ diceLen - 1]{
//            fu(diceLen - 2, el)
//        }
//        return counter
//    }

}



/* func diceRolls(dice [][]int, sum int) int {
	diceLen := len(dice)
	arrNs := make([]int, diceLen)
	counter := 0
	for index, arr := range dice {
		x := sort.SearchInts(arr, sum)
		for _, y := range arr[x:] {
			if arr[x] != y {
				break
			}
			x++
		}
		arrNs[index] = x
	}
	for i, el := range dice[diceLen-1] {
		dice[diceLen-1][i] = sum - el
	}
	var fu func(currDiceIndex int, currSum int)
	fu = func(currDiceIndex int, currSum int) {
		if currDiceIndex == -1 && currSum == 0 {
			counter++
			return
		}
		if currDiceIndex < 0 {

			return
		}
		for i := arrNs[currDiceIndex] - 1; i >= 0; i-- {
			newSum := currSum - dice[currDiceIndex][i]
			if newSum < 0 {
				continue
			}
			fu(currDiceIndex-1, newSum)
		}
	}
	for _, el := range dice[diceLen-1] {
		fu(diceLen-2, el)
	}
	return counter
}*/