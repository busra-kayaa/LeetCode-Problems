// 1
class Solution {
    public int lengthOfLastWord(String s) {
        // trim baştaki ve sondaki boşlukları siler.
        // split(" ") stringi her boşluk karakterinde böler ve diziye ekler
        String[] array = s.trim().split(" ");
        int size = array.length;

        return array[size-1].length();
    }
}

// 1. cozumum dogru ancak bellek kullanimi acisindan verimsiz
// Cunku:
// - trim(): O(n) zaman + O(n) bellek (yeni string olusturur)
// - split(): O(n) zaman + O(n) bellek (tum kelimeler icin dizi olusturur)
// - Sadece son kelime gerekliyken tum string isleniyor

// 2
class Solution {
    public int lengthOfLastWord(String s) {
    
    int length = 0;

    for (int i = s.length() -1; i>=0; i--){
        if (s.charAt(i) != ' '){
            length++;
        }
        else if (length > 0) {
            return length;
        }
    }
    return length;
    }
}

// 2. cozum bellek kullanimi acisindan cok verimli
// Cunku :
// - bellek: O(1) → sabit bellek kullanimi
// - zaman : O(n) teorikte ama pratikte O(k) → sadece son kelime kadar
// - Sadece son kelimeyi sayar, tum string islenmez