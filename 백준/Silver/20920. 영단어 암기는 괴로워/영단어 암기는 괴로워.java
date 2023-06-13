import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Word implements Comparable<Word>{
        String word;
        int cnt;

        @Override
        public int compareTo(Word o) {
            if (this.cnt != o.cnt) {
                return -Integer.compare(this.cnt, o.cnt);
            }
            if (this.word.length() != o.word.length()) {
                return -Integer.compare(this.word.length(),(o.word.length()));
            }
            return this.word.compareTo(o.word);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Word> map = new HashMap<>();
        List<Word> list = new ArrayList<>();
        while (N-- > 0) {
            String s = br.readLine();
            if (s.length() < M) {
                continue;
            }
            if (map.containsKey(s)) {
                map.get(s).cnt++;
            } else {
                Word w = new Word();
                w.word=s;
                w.cnt=1;
                list.add(w);
                map.put(s, w);
            }
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        for (Word w:list) {
            sb.append(w.word).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}