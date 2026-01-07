//longest substring without repeating char
class LongestSubstring {
    public static int lengthOfLongestSubstring(String s){
        int[] freq = new int[128];
        int l=0, max=0;
        for(int r=0; r<s.length(); r++){
            freq[s.charAt(r)]++;
            while(freq[s.charAt(r)]>1) freq[s.charAt(l++)]--;
            max = Math.max(max, r-l+1);
        }
        return max;
    }

    public static void main(String[] args){
        String s = "zxyzxyz";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
