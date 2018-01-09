/**
 * 카카오 샘플  다트 게임(난이도: 하)
 * 문제 링크: http://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/
 * @author Bryant Son
 * @since 01/08/2017
 */
public class DartGame {

	public static void main(String[] args) {
		DartGame dg = new DartGame();
		int result = dg.solveDartGame(args[0]);
		System.out.println(result);
	}

	/**
	 * solveDartGame(String input)
	 *    String 인풋을 받아서 다트 게임 정답을 찾아냅니다.
	 * @return int 는 계산한 가격
	 */
	public int solveDartGame(String input) {
		int result = 0;

		int[] resultsGame = new int[3];
		StringBuilder digit = new StringBuilder();
		String letter = "";
		int len = input.length();

		int i = 0;
		int j = 0;
		while(i < len) {
			String c = input.substring(i, i+1);
			if(isNumber(c)) {
				digit.append(c);
			}
			else if (isLetter(c)) {
				resultsGame[j] = calculateMultiplier(Integer.valueOf(digit.toString()), c);
				++ j;
				digit = new StringBuilder();
			}
			else if(c.equals("#")) {
				resultsGame[j-1] = -1 * resultsGame[j-1];
			}
			else if(c.equals("*")) {
				if((j - 1) == 0) {
					resultsGame[j-1] *= 2;
				}
				else {
					resultsGame[j-1] *= 2;
					resultsGame[j-2] *= 2;
				}
			}
			++ i;
		}

		int sum = calculateSum(resultsGame);
		return sum;
	}

	/**
	 * isLetter(String str)
	 *    String 인풋이 알파벳 D,T,S 인지 아닌지 알려냅니다.
	 * @return D,T,S 가 맞으면 true. 아니면, false
	 */
	public boolean isLetter(String str) {
		return str.equals("D") || str.equals("T") || str.equals("S");
	}

	/**
	 * isNumber(String str)
	 *    String 인풋이 숫자인지 알려줍닏
	 * @return 인풋이 숫자이면 true. 아니면 false.
	 */
	public boolean isNumber(String str) {
		boolean result = false;
		try {
			int num = Integer.parseInt(str);
			result = true;
		}
		catch(NumberFormatException e) {

		}
		return result;
	}

	/**
	 * calculateMultiplier(int num, String letter)
	 *    주어진만큼 계산해서 숫자를 구합니다
	 * @return multiplier 와 숫자를 곱한 값
	 */
	public int calculateMultiplier(int num, String letter) {
		int sum = num;
		if(letter.equals("D")) {
			sum *= num;
		}
		else if (letter.equals("T")) {
			sum *= (num * num);
		}

		return sum;
	}

	/**
	 * calculateSum(int[] list)
	 *    전체 총계를 계산합니다
	 * @return 어레이에 있는 값을 총계한 값
	 */
  public int calculateSum(int[] list) {
		int sum = 0;
		for(int i=0, n=list.length; i < n; ++ i) {
			sum += list[i];
		}
		return sum;
	}

}
