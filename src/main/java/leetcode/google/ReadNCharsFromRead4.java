package leetcode.google;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReadNCharsFromRead4 extends Reader4 {
    public ReadNCharsFromRead4(String content) {
        super(content);
    }

    boolean readAll = false;
    Deque<Character> queue = new ArrayDeque<>();
    public int read(char[] buf, int n) {
        int writeIndex = 0;
        while (!queue.isEmpty() && n > writeIndex) {
            buf[writeIndex++] = queue.remove();
        }
        while (n > writeIndex && !readAll) {
            writeIndex = readMore(buf, n, writeIndex);
        }
        return writeIndex;
    }

    private int readMore(char[] buf, int n, int writeIndex) {
        char[] b = new char[4];
        int readCount = read4(b);
        //no more chars to read from source
        if (readCount == 0) {
            readAll = true;
            return writeIndex;
        }
        int localIndex = 0;
        while (n > writeIndex && localIndex < readCount) {
            buf[writeIndex++] = b[localIndex++];
        }
        while (localIndex < readCount) {
            queue.addLast(b[localIndex++]);
        }
        return writeIndex;
    }
}

class Reader4 {
    char[] content = null;
    int index = 0;
    int n;

    Reader4(String content) {
        this.content = content.toCharArray();
        index = 0;
        n = content.length();
    }

    int read4(char[] buf) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (index < n) {
                buf[i] = content[index++];
                count++;
            }
        }
        return count;
    }
}
