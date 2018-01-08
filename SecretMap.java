/**
 * 카카오 샘플  비밀 지도(난이도: 하)
 * 문제 링크: http://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/
 * @author Bryant Son
 * @since 01/07/2017
 */

import java.lang.StringBuilder;

public class SecretMap {

	public static void main(String[] args) {

		//System.out.println("LENGTH: " + args.length);
		if (args.length != 3) {
			System.err.println("ERROR: Your input has to be the length of 3");
			return;
		}

		SecretMap sm = new SecretMap();

		int n = Integer.valueOf(args[0]);
		String[] listArr1String = args[1].replaceAll("\\[","").replaceAll("\\]","").replaceAll("\\s+","").split(",");
		String[] listArr2String = args[2].replaceAll("\\[","").replaceAll("\\]","").replaceAll("\\s+","").split(",");

		String[] result = sm.solveSecretMap(n, listArr1String, listArr2String);

		sm.printResultInString(result);
	}

  /**
	 * printResultInString(String[] list)
	 * 	어레이로 되어 있는 결과를 요구하는 출려과 같은 스트링으로 해서 콘솔로 프린트 한다
	 * @return none
	 */
	public void printResultInString(String[] list) {
		StringBuilder result = new StringBuilder();
		result.append("[");
		for(int i=0, n = list.length; i < n; ++ i) {
			result.append("\"");
			result.append(list[i]);
			result.append("\"");
			if(i < (n -1)) {

				result.append(",");
			}
		}
		result.append("]");
		System.out.println(result.toString());

	}

	/**
	 * printResultInList(String[] list)
	 * 	어레이로 되어 있는 결과를 요구하는 차례되로 콘솔로 프린트 한다
	 * @return none
	 */
	public void printResultInList(String[] list) {
		for(int i=0, n = list.length; i < n; ++ i) {
			System.out.println(list[i]);
		}
	}

	/**
	 * solveSecretMap(int n, String[] arr1, String[] arr2)
	 * 	문제의 주 해결 메소드. 3가지 인풋을 받아서 답을 리턴한다.
	 * @return 지도를 # = 1 과 _ = 0 로 표현 한 스트링 어레이
	 */
	public String[] solveSecretMap(int n, String[] arr1, String[] arr2) {
		String[] result = new String[n];

		int[] arr1Int = convert2IntArray(arr1);
		int[] arr2Int = convert2IntArray(arr2);

		for(int i=0; i < n; ++ i) {
			int bitNum = arr1Int[i] | arr2Int[i];
			String lineMap = convert2Maze(bitNum);
			result[i] = lineMap;
		}
		return result;
	}

	/**
	 * convert2IntArray(String[] list)
	 * 	스트링 어레이를 받아 인트 어레이로 변화해서 리턴
	 * @return array of integers
	 */
	public int[] convert2IntArray(String[] list) {
		int n = list.length;
		int[] result = new int[n];

		for(int i=0; i < n; ++ i) {
			result[i] = Integer.valueOf(list[i]);
		}
		return result;
	}

	/**
	 * convert2Maze(int n)
	 * 	이진법에 해당하는 숫자를 받아 # 과 빈칸으로 체어진 스트링으로 변화 그리고 리턴
	 * @return string representing the map layout
	 */
	public String convert2Maze(int n) {
		StringBuilder result = new StringBuilder();

		while (n != 0) {
			int bit = n % 2;
			if (bit == 1) {
				result.append("#");
			}
			else {
				result.append(" ");
			}
			n /= 2;
		}
		return result.reverse().toString();
	}
}
