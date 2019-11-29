package withgoogle;
/*
Your input is a compressed string of the format number[string]
and the decompressed output form should be the string written number times.
For example:
The input 3[abc]4[ab]c
Would be output as abcabcabcababababc

Approach:
1. what if numbers are more then single digit
2. can we have 0 as number?
3. can we have empty []
4. nested []
5. any validation - what if no number before []
 */

import org.junit.Test;

import java.util.Stack;


public class CompressionDecompression {

    @Test
    public void canDecompress() {
        System.out.println(decompress("3[abc]4[ab]1[c]"));
    }

    String decompress(String compress) {
        StringBuilder sb = new StringBuilder();
        sb.append("1[").append(compress).append("]");
        String processedCompress = sb.toString();

        Stack<Character> stack = new Stack<>();

        String finalDecompress = "";

        for (char ch : processedCompress.toCharArray()) {

            if (ch != ']') {
                stack.push(ch);
            } else {
                StringBuilder subSBForRepeat = new StringBuilder();
                char popCharacter;
                do {
                    popCharacter = stack.pop();
                    subSBForRepeat.append(popCharacter);
                }
                while (popCharacter != '[');

                subSBForRepeat.deleteCharAt(subSBForRepeat.indexOf("["));
                subSBForRepeat.reverse();

                int count = 0;
                StringBuilder sbForNumber = new StringBuilder();
                sbForNumber.append('0');
                while (!stack.empty()) {
                    char lastCharacter = stack.pop();

                    sbForNumber.append(lastCharacter);
                    try {
                        count = Integer.parseInt(sbForNumber.toString());
                    } catch (NumberFormatException nfe) {
                        stack.push(lastCharacter);
                        break;
                    }
                }

                //process
                System.out.println("Count: " + count);
                for (int i = 2; i < count; i++) {
                    subSBForRepeat.append(subSBForRepeat);
                }
                System.out.println(finalDecompress);
                finalDecompress = finalDecompress + subSBForRepeat.toString();
            }
        }
        return finalDecompress;
    }

    @Test
    public void canDecom() {
        decomReursively("1[3[abc]4[ab]1[c]]");
    }

    void decomReursively(String com) {

        int right = com.indexOf("]"); //C0
        if (right < 1) { //c1
            return; //c2
        } else { //c3
            int left = com.substring(0, right).lastIndexOf("["); //right + left-right = left
            String repeatableWords = com.substring(left + 1, right); //right -left

            int count = 0; //c4
            StringBuilder sbForNumber = new StringBuilder(); //c5
            sbForNumber.append('0'); //c6
            int newLeft = 0;//c7
            for (int i = left - 1; i > -1; i--) { //left
                char lastCharacter = com.charAt(i); //c7
                sbForNumber.append(lastCharacter); //c8
                try {
                    count = Integer.parseInt(sbForNumber.toString());
                } catch (NumberFormatException nfe) {
                    newLeft = i + 1;
                    break;
                }
            }
            StringBuilder decom = new StringBuilder();
            //decom.append(repeatableWords);
            for (int i = 1; i <= count; i++) {
                decom.append(repeatableWords);
            }
            String toBeReplace = com.substring(newLeft, right + 1);
            String newValue = decom.toString();
            com = com.replace(toBeReplace, newValue);
            System.out.println(toBeReplace + " - " + newValue + " - " + com);
            decomReursively(com);//log n times
        }

    }
}
